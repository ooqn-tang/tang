package net.ttcxy.tang.portal.controller.api.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.entity.model.UtsResource;
import net.ttcxy.tang.portal.entity.model.UtsRole;
import net.ttcxy.tang.portal.entity.param.UtsRoleParam;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import net.ttcxy.tang.portal.service.UtsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/admin/role")
public class ApiAdminRoleController {

    @Autowired
    private UtsRoleService roleService;

    @GetMapping
    public ResponseEntity<List<UtsRole>> select(){
        List<UtsRole> roleList = roleService.select();
        return ResponseEntity.ok(roleList);
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody UtsRoleParam roleParam){
        UtsRole role = BeanUtil.toBean(roleParam, UtsRole.class);
        role.setRoleId(IdUtil.objectId());
        role.setCreateTime(new Date());
        int count = roleService.insert(role);
        if (count > 0){
            return ResponseEntity.ok("添加成功");
        }
        throw new ApiException(ResponseCode.ACCEPTED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody UtsRoleParam roleParam){
        UtsRole role = BeanUtil.toBean(roleParam, UtsRole.class);
        int count = roleService.update(role);
        if (count > 0){
            return ResponseEntity.ok("添加成功");
        }
        throw new ApiException(ResponseCode.ACCEPTED);
    }

    @GetMapping("{roleId}")
    public ResponseEntity<UtsRole> select(@PathVariable("roleId") String roleId){
        UtsRole role = roleService.selectById(roleId);
        return ResponseEntity.ok(role);
    }

    @DeleteMapping("{roleId}")
    public ResponseEntity<String> delete(@PathVariable("roleId") String roleId){
        int count = roleService.delete(roleId);
        if (count > 0){
            return ResponseEntity.ok("删除成功");
        }
        throw new ApiException(ResponseCode.ACCEPTED);
    }

    @PostMapping("resource/{roleId}")
    public ResponseEntity<String> insertResource(@PathVariable("roleId")String roleId,@RequestBody List<UtsResource> resourceList){
        roleService.insertResource(roleId,resourceList);
        return ResponseEntity.ok("添加成功");
    }

    @GetMapping("author/{authorId}")
    public ResponseEntity<List<String>> selectAuthorIdList(@PathVariable("authorId")String authorId){
        List<String> roleList = roleService.selectRoleIdList(authorId);
        return ResponseEntity.ok(roleList);
    }

    @Autowired
    private UtsAuthorService authorService;

    @PostMapping("author/{authorId}")
    public ResponseEntity<String> insertRoleOnAuthor(@PathVariable("authorId")String authorId, @RequestBody List<UtsRoleParam> roleParams){
        authorService.insertRole(authorId,roleParams);
        return ResponseEntity.ok("添加成功");
    }

}
