package net.ttcxy.tang.admin.controller;

import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.service.UtsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("resource")
public class UtsResourceController {

    @Autowired
    UtsResourceService utsResourceService;

    @PostMapping("list")
    public ResponseResult<?> resourceList(){
        return ResponseResult.success(utsResourceService.resourceList());
    }
}
