package net.ttcxy.tang.gateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.entity.UtsMemberLogin;
import net.ttcxy.tang.service.CurrentMemberService;
import net.ttcxy.tang.service.UtsFansService;
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
    private CurrentMemberService currentMemberService;

    @Autowired
    private UtsFansService fansService;

    @GetMapping("list")
    @ApiOperation("关注的作者列表")
    public ResponseResult<List<UtsMemberLogin>> fansList(){
        String memberId = currentMemberService.getMember().getId();
        List<UtsMemberLogin> fansList = fansService.selectFansList(memberId);
        return ResponseResult.success(fansList);
    }

    @GetMapping("{fansName}")
    @ApiOperation("查询粉丝名是否存在")
    public ResponseResult selectByName(@PathVariable("fansName") String fansName){
        int count = fansService.selectFans(fansName);
        if (count > 0){
            return ResponseResult.success(count);
        }
        return ResponseResult.failed();
    }

    @PostMapping("insert/{fansName}")
    @ApiOperation("添加关注")
    public ResponseResult insert(@PathVariable("fansName") String fansName){
        int count = fansService.insertFans(fansName);
        if (count > 0){
            return ResponseResult.success(count);
        }
        return ResponseResult.failed();
    }

    @PostMapping("delete/{fansName}")
    @ApiOperation("删除关注")
    public ResponseResult delete(@PathVariable("fansName") String fansName){
        int count = fansService.deleteFans(fansName);
        if (count > 0){
            return ResponseResult.success(count);
        }
        return ResponseResult.failed();
    }
}
