package cn.ttcxy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.ttcxy.core.BaseController;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.dto.DtsVideoDto;
import cn.ttcxy.entity.model.DtsVideo;
import cn.ttcxy.entity.param.VideoParam;
import cn.ttcxy.service.DtsVideoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/video")
@RestController
public class DtsVideoController extends BaseController {

    @Autowired
    private DtsVideoService videoService;

    @GetMapping("{videoId}/author")
    public ResponseEntity<DtsVideo> selectCreateInfo(@PathVariable("videoId") String videoId){
        DtsVideo dtsVideo = videoService.selectByIdCreateInfo(videoId);
        return ResponseEntity.ok(dtsVideo);
    }

    @GetMapping("{videoId}")
    public ResponseEntity<DtsVideoDto> select(@PathVariable("videoId") String videoId){
        DtsVideoDto videoDto = videoService.selectById(videoId);
        return ResponseEntity.ok(videoDto);
    }

    @GetMapping("username/{authorId}")
    public ResponseEntity<PageInfo<DtsVideoDto>> selectByUsername(
            @RequestParam(value = "page",defaultValue = "0")Integer page,
            @RequestParam(value = "size",defaultValue = "10")Integer size,
            @PathVariable("authorId") String authorId){
        PageInfo<DtsVideoDto> select = videoService.selectByUsername(authorId,page,size);
        return ResponseEntity.ok(select);
    }

    @GetMapping
    public ResponseEntity< PageInfo<DtsVideoDto>> select(
            @RequestParam(value = "page",defaultValue = "0")Integer page,
            @RequestParam(value = "size",defaultValue = "12")Integer size,
            @RequestParam(value = "classId",defaultValue = "")String classId,
            @RequestParam(value = "title",defaultValue = "")String title){
        PageInfo<DtsVideoDto> select;
        if (classId.equals("gz")){
            select = videoService.selectGz(page, size, authorId());
        }else{
            select = videoService.select(page, size, title, classId);
        }
        return ResponseEntity.ok(select);

    }

    @GetMapping("so")
    public ResponseEntity<PageInfo<DtsVideoDto>> search(
            @RequestParam(value = "page",defaultValue = "0")Integer page,
            @RequestParam("wb") String wb){
        PageInfo<DtsVideoDto> select = videoService.search(wb,page);
        return ResponseEntity.ok(select);
    }

    @GetMapping("rand")
    public ResponseEntity<List<DtsVideoDto>> rand(@RequestParam("num")Integer num){
        List<DtsVideoDto> select = videoService.rand(num);
        return ResponseEntity.ok(select);
    }

    /**
     * 创建一个有ID的空数据，保存时直接更新
     */
    @PostMapping
    public ResponseEntity<String> create(){
        String authorId = authorId();
        String videoId = IdUtil.objectId();
        DtsVideo dtsVideo = new DtsVideo();
        dtsVideo.setAuthorId(authorId);
        dtsVideo.setVideoId(videoId);
        dtsVideo.setCreateDate(DateUtil.date());
        dtsVideo.setState(3);
        int count = videoService.insert(dtsVideo);
        if (count > 0){
            return ResponseEntity.ok(videoId);
        }
        return null;
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody VideoParam videoParam){
        DtsVideo video = BeanUtil.toBean(videoParam, DtsVideo.class);
        String authorId = videoService.authorId(video.getVideoId());
        if (StrUtil.equals(authorId,authorId())){
            video.setState(2);
            int count = videoService.updateSelective(video);
            if (count > 0){
                return ResponseEntity.ok("执行成功");
            }
        }
        throw new ApiException();
    }

    @DeleteMapping("{videoId}")
    public ResponseEntity<String> delete(@PathVariable("videoId")String videoId){
        String authorId = videoService.authorId(videoId);
        if (StrUtil.equals(authorId,authorId())){
            int count = videoService.deleteById(videoId);
            if (count > 0){
                return ResponseEntity.ok("执行成功");
            }
        }
        throw new ApiException();
    }
}
