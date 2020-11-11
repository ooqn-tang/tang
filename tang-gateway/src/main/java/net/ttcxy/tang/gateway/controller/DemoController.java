package net.ttcxy.tang.gateway.controller;

import net.ttcxy.tang.gateway.entity.Po;
import net.ttcxy.tang.model.DtsAdvertise;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;


/**
 * @author huanglei
 */
@RestController
public class DemoController<T> {

    @GetMapping("obj")
    public String obj(@NotBlank(message = "姓名不能为空") @Validated String s){
        return "obj : " + s;
    }

    @PostMapping("post")
    public String post(@RequestBody @Valid Po po){
        return po.toString();
    }


    public static void main(String[] args) {
        DtsAdvertise advertise = new DtsAdvertise();
        advertise.setId("aksdjfkasjdfk");


    }



}
