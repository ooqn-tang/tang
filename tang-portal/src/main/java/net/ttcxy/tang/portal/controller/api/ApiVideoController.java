package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.DtsVideoDto;
import net.ttcxy.tang.portal.entity.model.DtsVideo;
import net.ttcxy.tang.portal.entity.model.DtsVideoClass;
import net.ttcxy.tang.portal.entity.param.VideoParam;
import net.ttcxy.tang.portal.service.DtsVideoService;
import net.ttcxy.tang.portal.service.DtsVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/video")
@RestController
public class ApiVideoController {


    @Autowired
    private DtsVideoService videoService;

    @Autowired
    private DtsVisitService visitService;


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
            @RequestParam(value = "size",defaultValue = "10")Integer size,
            @RequestParam(value = "videoClass",defaultValue = "")String videoClass,
            @RequestParam(value = "title",defaultValue = "")String title){
        PageInfo<DtsVideoDto> select = videoService.select(page, size, title,videoClass);
        return ResponseEntity.ok(select);
    }

    /**
     * 创建一个有ID的空数据，保存时直接更新
     */
    @PostMapping
    public ResponseEntity<String> create(){
        String authorId = CurrentUtil.id();
        String videoId = IdUtil.objectId();
        DtsVideo dtsVideo = new DtsVideo();
        dtsVideo.setAuthorId(authorId);
        dtsVideo.setVideoId(videoId);
        dtsVideo.setCreateDate(DateUtil.date());
        dtsVideo.setState(2);
        int count = videoService.insert(dtsVideo);
        if (count > 0){
            return ResponseEntity.ok(videoId);
        }
        return null;
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody VideoParam video){
            DtsVideo dtsVideo = BeanUtil.toBean(video, DtsVideo.class);
        dtsVideo.setState(1);
        int count = videoService.update(dtsVideo);
        if (count > 0){
            return ResponseEntity.ok("执行成功");
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @DeleteMapping("{videoId}")
    public ResponseEntity<String> delete(@PathVariable("videoId")String videoId){
        int count = videoService.deleteById(videoId);
        if (count > 0){
            return ResponseEntity.ok("执行成功");
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @GetMapping("class")
    public ResponseEntity<List<DtsVideoClass>> selectVideoClass(){
        List<DtsVideoClass> videoClassList = videoService.selectVideoClass();
        return ResponseEntity.ok(videoClassList);
    }
}
