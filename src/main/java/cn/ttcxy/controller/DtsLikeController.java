package cn.ttcxy.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.core.security.CurrentUtil;
import cn.ttcxy.entity.model.DtsLike;
import cn.ttcxy.service.DtsLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/like")
public class DtsLikeController {

    @Autowired
    private DtsLikeService likeService;

    /**
     * 喜欢
     */
    @PostMapping("{dataId}")
    public ResponseEntity<String> like(@PathVariable("dataId")String dataId){
        DtsLike praise = new DtsLike();
        praise.setLikeId(IdUtil.objectId());
        praise.setDataId(dataId);
        praise.setAuthorId(CurrentUtil.id());
        praise.setCreateTime(DateUtil.date());
        int count = likeService.insert(praise);
        if (count > 0){
            return ResponseEntity.ok(ResponseCode.SUCCESS.getMessage());
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    /**
     * 取消喜欢
     */
    @DeleteMapping("{dataId}")
    public ResponseEntity<String> unlike(@PathVariable("dataId")String dataId){
        int count = likeService.delete(CurrentUtil.id(),dataId);
        if (count > 0){
            return ResponseEntity.ok(ResponseCode.SUCCESS.getMessage());
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @GetMapping("{dataId}")
    public ResponseEntity<Integer> select(@PathVariable("dataId")String dataId){
        return ResponseEntity.ok(likeService.select(CurrentUtil.id(),dataId));
    }
}
