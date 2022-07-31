package cn.ttcxy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.ttcxy.core.BaseController;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.entity.dto.DtsVideoDto;
import cn.ttcxy.entity.model.DtsVideo;
import cn.ttcxy.entity.param.VideoParam;
import cn.ttcxy.service.DtsVideoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/video")
@RestController
public class DtsVideoController extends BaseController {

    @Autowired
    private DtsVideoService videoService;

    @GetMapping("{videoId}/author")
    public DtsVideo selectCreateInfo(@PathVariable("videoId") String videoId){
        return videoService.selectByIdCreateInfo(videoId);
    }

    @GetMapping("{videoId}")
    public DtsVideoDto select(@PathVariable("videoId") String videoId){
        return videoService.selectById(videoId);
    }

    @GetMapping("username/{authorId}")
    public PageInfo<DtsVideoDto> selectByUsername(
            @RequestParam(value = "page",defaultValue = "0")Integer page,
            @RequestParam(value = "size",defaultValue = "10")Integer size,
            @PathVariable("authorId") String authorId){
        return videoService.selectByUsername(authorId,page,size);
    }

    @GetMapping
    public PageInfo<DtsVideoDto> select(
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
        return select;

    }

    @GetMapping("so")
    public PageInfo<DtsVideoDto> search(
            @RequestParam(value = "page",defaultValue = "0")Integer page,
            @RequestParam("wb") String wb){
        return videoService.search(wb,page);
    }

    @GetMapping("rand")
    public List<DtsVideoDto> rand(@RequestParam("num")Integer num){
        return videoService.rand(num);
    }

    /**
     * 创建一个有ID的空数据，保存时直接更新
     */
    @PostMapping
    public String create(){
        String authorId = authorId();
        String videoId = IdUtil.objectId();
        DtsVideo dtsVideo = new DtsVideo();
        dtsVideo.setAuthorId(authorId);
        dtsVideo.setVideoId(videoId);
        dtsVideo.setCreateDate(DateUtil.date());
        dtsVideo.setState(3);
        int count = videoService.insert(dtsVideo);
        if (count > 0){
            return videoId;
        }
        return null;
    }

    @PutMapping
    public String update(@RequestBody VideoParam videoParam){
        DtsVideo video = BeanUtil.toBean(videoParam, DtsVideo.class);
        String authorId = videoService.authorId(video.getVideoId());
        if (StrUtil.equals(authorId,authorId())){
            video.setState(2);
            int count = videoService.updateSelective(video);
            if (count > 0){
                return "执行成功";
            }
        }
        throw new ApiException();
    }

    @DeleteMapping("{videoId}")
    public String delete(@PathVariable("videoId")String videoId){
        String authorId = videoService.authorId(videoId);
        if (StrUtil.equals(authorId,authorId())){
            int count = videoService.deleteById(videoId);
            if (count > 0){
                return "执行成功";
            }
        }
        throw new ApiException();
    }
}
