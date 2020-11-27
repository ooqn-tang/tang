package net.ttcxy.tang.admin.controller;

import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.service.UtsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huanglei
 */
@RequestMapping("role")
@RestController
public class UtsRoleController {
    @Autowired
    private UtsRoleService utsRoleService;

    @PostMapping("list")
    public ResponseResult<?> roleList(){
        return ResponseResult.success(utsRoleService.getRoles());
    }
}
