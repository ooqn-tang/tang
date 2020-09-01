package net.ttcxy.tang.controller;

import net.ttcxy.tang.api.CommonResult;
import net.ttcxy.tang.service.impl.FansServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：HuangLei
 * @date ：2020/4/10 0010 20:07
 */
@RestController
@RequestMapping("fans")
public class FansController {

    @Autowired
    private FansServiceImpl fansServiceImpl;


    /**
     * 查询粉丝
     * @param fansName fansName
     * @return 影响条数
     */
    @GetMapping("{fansName}")
    public CommonResult selectFans(@PathVariable("fansName") String fansName){
        int count = fansServiceImpl.selectFans(fansName);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 关注粉丝
     * @param fansName
     * @return
     */
    @PostMapping("{fansName}")
    public CommonResult insertFans(@PathVariable("fansName") String fansName){
        int count = fansServiceImpl.insertFans(fansName);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }

    /**
     * 取消粉丝
     * @param fansName
     * @return
     */
    @DeleteMapping("{fansName}")
    public CommonResult deleteFans(@PathVariable("fansName") String fansName){
        int count = fansServiceImpl.deleteFans(fansName);
        if (count > 0){
            return CommonResult.success(count);
        }
        return CommonResult.failed();
    }
}
