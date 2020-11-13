package net.ttcxy.tang.gateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.gateway.code.security.CurrentAuthorService;
import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
import net.ttcxy.tang.gateway.service.UtsFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("fans")
@Api("FansController")
public class UtsFansController {

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private UtsFansService fansService;

    /**
     * 关注用户
     */
    @GetMapping("list")
    @ApiOperation("关注的作者列表")
    public ResponseResult<?> fansList(){
        String authorId = currentAuthorService.getAuthor().getId();
        List<UtsAuthorLogin> fansList = fansService.selectFansList(authorId);
        return ResponseResult.success(fansList);
    }

    /**
     * 查询粉丝
     */
    @GetMapping("{fansName}")
    @ApiOperation("查询粉丝名是否存在")
    public ResponseResult<?> selectByName(@PathVariable("fansName") String fansName){
        int count = fansService.selectFans(fansName);
        if (count > 0){
            return ResponseResult.success(count);
        }
        return ResponseResult.failed();
    }

    /**
     * 关注粉丝
     */
    @PostMapping("insert/{fansName}")
    @ApiOperation("添加关注")
    public ResponseResult<?> insert(@PathVariable("fansName") String fansName){
        int count = fansService.insertFans(fansName);
        if (count > 0){
            return ResponseResult.success(count);
        }
        return ResponseResult.failed();
    }

    /**
     * 取消粉丝
     */
    @PostMapping("delete/{fansName}")
    @ApiOperation("删除关注")
    public ResponseResult<?> delete(@PathVariable("fansName") String fansName){
        int count = fansService.deleteFans(fansName);
        if (count > 0){
            return ResponseResult.success(count);
        }
        return ResponseResult.failed();
    }
}
