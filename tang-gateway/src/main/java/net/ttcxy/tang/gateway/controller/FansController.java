package net.ttcxy.tang.gateway.controller;

import net.ttcxy.tang.gateway.service.FansService;
import net.ttcxy.tang.api.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("fans")
public class FansController {

    @Autowired
    private FansService fansService;


    /**
     * 查询粉丝
     */
    @GetMapping("{fansName}")
    public CommonResult<Integer> selectFans(@PathVariable("fansName") String fansName){
        int count = fansService.selectFans(fansName);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 关注粉丝
     */
    @PostMapping("{fansName}")
    public CommonResult<Integer> insertFans(@PathVariable("fansName") String fansName){
        int count = fansService.insertFans(fansName);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 取消粉丝
     */
    @DeleteMapping("{fansName}")
    public CommonResult<Integer> deleteFans(@PathVariable("fansName") String fansName){
        int count = fansService.deleteFans(fansName);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
