package cn.ttcxy.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.core.BaseController;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.model.DtsLike;
import cn.ttcxy.service.DtsLikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/like")
public class DtsLikeController extends BaseController {

    @Autowired
    private DtsLikeService likeService;

    @PostMapping("{dataId}")
    public String like(@PathVariable("dataId")String dataId){
        DtsLike praise = new DtsLike();
        praise.setLikeId(IdUtil.objectId());
        praise.setDataId(dataId);
        praise.setAuthorId(authorId());
        praise.setCreateTime(DateUtil.date());
        int count = likeService.insert(praise);
        if (count > 0){
            return ResponseCode.SUCCESS.getMessage();
        }
        throw new ApiException();
    }

    @DeleteMapping("{dataId}")
    public String unlike(@PathVariable("dataId")String dataId){
        int count = likeService.delete(authorId(),dataId);
        if (count > 0){
            return ResponseCode.SUCCESS.getMessage();
        }
        throw new ApiException();
    }

    @GetMapping("{dataId}")
    public Integer select(@PathVariable("dataId")String dataId){
        return likeService.select(authorId(),dataId);
    }
}
