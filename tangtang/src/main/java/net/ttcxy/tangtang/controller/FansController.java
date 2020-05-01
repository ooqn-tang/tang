package net.ttcxy.tangtang.controller;

import net.ttcxy.tangtang.api.CommonResult;
import net.ttcxy.tangtang.service.impl.FansServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author ：HuangLei
 * @date ：2020/4/10 0010 20:07
 */
@Controller
@RequestMapping("fans")
public class FansController {

    @Autowired
    FansServiceImpl fansServiceImpl;


    /**
     * 查询粉丝
     * @param fansName
     * @return
     */
    @GetMapping("{fansName}")
    @ResponseBody
    public CommonResult selectFans(@PathVariable("fansName") String fansName){
        return CommonResult.success(fansServiceImpl.selectFans(fansName));
    }

    /**
     * 关注粉丝
     * @param fansName
     * @return
     */
    @PostMapping("{fansName}")
    @ResponseBody
    public CommonResult insertFans(@PathVariable("fansName") String fansName){
        return CommonResult.success(fansServiceImpl.insertFans(fansName));
    }

    /**
     * 取消粉丝
     * @param fansName
     * @return
     */
    @DeleteMapping("{fansName}")
    @ResponseBody
    public CommonResult deleteFans(@PathVariable("fansName") String fansName){
        return CommonResult.success(fansServiceImpl.deleteFans(fansName));
    }
}
