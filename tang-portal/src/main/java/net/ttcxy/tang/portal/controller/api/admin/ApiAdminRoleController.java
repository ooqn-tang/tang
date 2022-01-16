package net.ttcxy.tang.portal.controller.api.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.entity.model.UtsResource;
import net.ttcxy.tang.portal.entity.model.UtsRole;
import net.ttcxy.tang.portal.entity.param.UtsRoleParam;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import net.ttcxy.tang.portal.service.UtsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/admin/role")
public class ApiAdminRoleController {

    @Autowired
    private UtsRoleService roleService;

    @GetMapping
    public ResponseResult<List<UtsRole>> select(){
        List<UtsRole> roleList = roleService.select();
        return ResponseResult.success(roleList);
    }

    @PostMapping
    public ResponseResult<String> insert(@RequestBody UtsRoleParam roleParam){
        UtsRole role = BeanUtil.toBean(roleParam, UtsRole.class);
        role.setRoleId(IdUtil.objectId());
        role.setCreateTime(new Date());
        int count = roleService.insert(role);
        if (count > 0){
            return ResponseResult.success("添加成功");
        }
        return ResponseResult.failed("添加失败");
    }

    @PutMapping
    public ResponseResult<String> update(@RequestBody UtsRoleParam roleParam){
        UtsRole role = BeanUtil.toBean(roleParam, UtsRole.class);
        int count = roleService.update(role);
        if (count > 0){
            return ResponseResult.success("添加成功");
        }
        return ResponseResult.failed("添加失败");
    }

    @GetMapping("{roleId}")
    public ResponseResult<UtsRole> select(@PathVariable("roleId") String roleId){
        UtsRole role = roleService.selectById(roleId);
        return ResponseResult.success(role);
    }

    @DeleteMapping("{roleId}")
    public ResponseResult<String> delete(@PathVariable("roleId") String roleId){
        int count = roleService.delete(roleId);
        if (count > 0){
            return ResponseResult.success("删除成功");
        }
        return ResponseResult.failed("删除失败");
    }

    @PostMapping("resource/{roleId}")
    public ResponseResult<String> insertResource(@PathVariable("roleId")String roleId,@RequestBody List<UtsResource> resourceList){
        roleService.insertResource(roleId,resourceList);
        return ResponseResult.success("添加成功");
    }

    @GetMapping("author/{authorId}")
    public ResponseResult<List<String>> selectAuthorIdList(@PathVariable("authorId")String authorId){
        List<String> roleList = roleService.selectRoleIdList(authorId);
        return ResponseResult.success(roleList);
    }

    @Autowired
    private UtsAuthorService authorService;

    @PostMapping("author/{authorId}")
    public ResponseResult<String> insertRoleOnAuthor(@PathVariable("authorId")String authorId, @RequestBody List<UtsRoleParam> roleParams){
        authorService.insertRole(authorId,roleParams);
        return ResponseResult.success("添加成功");
    }

}
