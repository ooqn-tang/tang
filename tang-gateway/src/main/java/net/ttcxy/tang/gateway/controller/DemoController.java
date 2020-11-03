package net.ttcxy.tang.gateway.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotBlank;

/**
 * @author huanglei
 */
@RestController
@Validated
public class DemoController {

    @GetMapping("obj")
    public String obj(@NotBlank(message = "姓名不能为空")String s){
        return "obj : " + s;
    }
}
