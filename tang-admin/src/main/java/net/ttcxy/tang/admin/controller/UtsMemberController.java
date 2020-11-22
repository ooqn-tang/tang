package net.ttcxy.tang.admin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @author huanglei
 */
@Controller
@RequestMapping("member")
public class UtsMemberController {

    @PostMapping
    @ResponseBody
    public String memberList(@RequestBody Map<String,String> map){
        return "map:" + map;
    }
}
