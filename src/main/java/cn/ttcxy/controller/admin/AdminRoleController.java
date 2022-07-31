package cn.ttcxy.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.core.BaseController;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.model.UtsResource;
import cn.ttcxy.entity.model.UtsRole;
import cn.ttcxy.entity.param.UtsRoleParam;
import cn.ttcxy.service.UtsAuthorService;
import cn.ttcxy.service.UtsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/admin/role")
public class AdminRoleController extends BaseController {

    @Autowired
    private UtsRoleService roleService;

    @Autowired
    private UtsAuthorService authorService;

    @GetMapping
    public List<UtsRole> select(){
        return roleService.select();
    }

    @PostMapping
    public String insert(@RequestBody UtsRoleParam roleParam){
        UtsRole role = BeanUtil.toBean(roleParam, UtsRole.class);
        role.setRoleId(IdUtil.objectId());
        role.setCreateTime(new Date());
        int count = roleService.insert(role);
        if (count > 0){
            return ResponseCode.SUCCESS.getMessage();
        }
        throw new ApiException();
    }

    @PutMapping
    public String update(@RequestBody UtsRoleParam roleParam){
        UtsRole role = BeanUtil.toBean(roleParam, UtsRole.class);
        int count = roleService.update(role);
        if (count > 0){
            return ResponseCode.SUCCESS.getMessage();
        }
        throw new ApiException();
    }

    @GetMapping("{roleId}")
    public UtsRole select(@PathVariable("roleId") String roleId){
        return roleService.selectById(roleId);
    }

    @DeleteMapping("{roleId}")
    public String delete(@PathVariable("roleId") String roleId){
        int count = roleService.delete(roleId);
        if (count > 0){
            return ResponseCode.SUCCESS.getMessage();
        }
        throw new ApiException();
    }

    @PostMapping("resource/{roleId}")
    public String insertResource(@PathVariable("roleId")String roleId,@RequestBody List<UtsResource> resourceList){
        roleService.insertResource(roleId,resourceList);
        return ResponseCode.SUCCESS.getMessage();
    }

    @GetMapping("author/{authorId}")
    public List<String> selectAuthorIdList(@PathVariable("authorId")String authorId){
        return roleService.selectRoleIdList(authorId);
    }

    @PostMapping("author/{authorId}")
    public String insertRoleOnAuthor(@PathVariable("authorId")String authorId, @RequestBody List<UtsRoleParam> roleParams){
        authorService.insertRole(authorId,roleParams);
        return ResponseCode.SUCCESS.getMessage();
    }

}
