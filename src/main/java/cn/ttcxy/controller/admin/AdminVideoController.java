package cn.ttcxy.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.ttcxy.core.BaseController;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.dto.DtsVideoDto;
import cn.ttcxy.entity.model.DtsVideo;
import cn.ttcxy.entity.param.DtsPassParam;
import cn.ttcxy.entity.param.DtsVideoParam;
import cn.ttcxy.service.DtsVideoService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/video")
public class AdminVideoController extends BaseController {

    @Autowired
    private DtsVideoService videoService;

    @PutMapping("pass")
    public ResponseEntity<String> pass(@RequestBody DtsPassParam pass){
        DtsVideo video = BeanUtil.toBean(pass,DtsVideo.class);
        video.setVideoId(pass.getDataId());
        int count = videoService.updateSelective(video);
        if (count > 0){
            return ResponseEntity.ok(ResponseCode.SUCCESS.getMessage());
        }
        throw new ApiException();
    }

    @DeleteMapping("{videoId}")
    public ResponseEntity<String> delete(@PathVariable("videoId")String videoId){
        int count = videoService.deleteById(videoId);
        if (count > 0){
            return ResponseEntity.ok(ResponseCode.SUCCESS.getMessage());
        }
        throw new ApiException();
    }

    @GetMapping("list")
    public ResponseEntity<PageInfo<DtsVideoDto>> selectList(DtsVideoParam videoParam){
        PageInfo<DtsVideoDto> videoPage =  videoService.selectList(videoParam);
        return ResponseEntity.ok(videoPage);
    }
}
