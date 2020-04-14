package net.ttcxy.tangtang.controller.web;

import net.ttcxy.tangtang.code.ResponseData;
import net.ttcxy.tangtang.service.impl.FansServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
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
    public ResponseData selectFans(@PathVariable("fansName") String fansName){
        return ResponseData.successful(fansServiceImpl.selectFans(fansName));
    }

    /**
     * 关注粉丝
     * @param fansName
     * @return
     */
    @PostMapping("{fansName}")
    @ResponseBody
    public ResponseData insertFans(@PathVariable("fansName") String fansName){
        try {
            return ResponseData.successful(fansServiceImpl.insertFans(fansName));
        } catch (DuplicateKeyException e) {
            return ResponseData.error("已经关注了");
        }
    }

    /**
     * 取消粉丝
     * @param fansName
     * @return
     */
    @DeleteMapping("{fansName}")
    @ResponseBody
    public ResponseData deleteFans(@PathVariable("fansName") String fansName){
        return ResponseData.successful(fansServiceImpl.deleteFans(fansName));
    }
}
