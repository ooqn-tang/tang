package net.ttcxy.tang.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.entity.model.UtsRole;
import net.ttcxy.tang.entity.param.UtsRoleParam;
import net.ttcxy.tang.service.UtsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author huanglei
 */
@RequestMapping("role")
@RestController
public class UtsRoleController {

    @Autowired
    private UtsRoleService utsRoleService;

    @PostMapping("list")
    public ResponseResult<List<UtsRole>> roleList(){
        return ResponseResult.success(utsRoleService.getRoles());
    }

    @PostMapping("insert")
    public ResponseResult roleInsert(@RequestBody UtsRoleParam role){
        UtsRole utsRole = new UtsRole();
        BeanUtil.copyProperties(role,utsRole);

        utsRole.setId(IdUtil.fastSimpleUUID());
        utsRole.setCreateTime(DateUtil.date());
        int count = utsRoleService.insertRole(utsRole);
        if (count > 0){
            return ResponseResult.success();
        }
        return ResponseResult.failed();
    }

    @PostMapping("update")
    public ResponseResult roleUpdate(@RequestBody UtsRoleParam role){
        UtsRole utsRole = new UtsRole();
        BeanUtil.copyProperties(role,utsRole);
        int count = utsRoleService.updateRole(utsRole);
        if (count > 0){
            return ResponseResult.success();
        }
        return ResponseResult.failed();
    }
    @PostMapping("delete/{id}")
    public ResponseResult roleDelete(@PathVariable("id") String id){
        int count = utsRoleService.deleteRole(id);
        if (count > 0){
            return ResponseResult.failed();
        }
        return ResponseResult.success();
    }
}
