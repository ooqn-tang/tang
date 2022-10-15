package cn.ttcxy.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.core.exception.ApiException;
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
    public DtsLike like(@PathVariable("dataId")String dataId){
        DtsLike praise = new DtsLike();
        praise.setLikeId(IdUtil.objectId());
        praise.setDataId(dataId);
        praise.setAuthorId(authorId());
        praise.setCreateTime(DateUtil.date());
        return likeService.insert(praise);
    }

    @DeleteMapping("{dataId}")
    public void unlike(@PathVariable("dataId")String dataId){
        likeService.delete(authorId(),dataId);
    }

    @GetMapping("{dataId}")
    public Long select(@PathVariable("dataId")String dataId){
        return likeService.select(authorId(),dataId);
    }
}
