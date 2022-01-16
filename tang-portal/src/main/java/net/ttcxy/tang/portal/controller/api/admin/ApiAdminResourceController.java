package net.ttcxy.tang.portal.controller.api.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.entity.model.UtsResource;
import net.ttcxy.tang.portal.entity.param.UtsResourceParam;
import net.ttcxy.tang.portal.service.UtsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/admin/resource")
public class ApiAdminResourceController {

    @Autowired
    private UtsResourceService resourceService;

    @GetMapping
    public ResponseResult<List<UtsResource>> select(){
        List<UtsResource> resourceList = resourceService.select();
        return ResponseResult.success(resourceList);
    }

    @PostMapping
    public ResponseResult<String> insert(@RequestBody UtsResourceParam resourceParam){
        UtsResource resource = BeanUtil.toBean(resourceParam, UtsResource.class);
        resource.setResourceId(IdUtil.objectId());
        resource.setCreateTime(new Date());
        int count = resourceService.insert(resource);
        if (count > 0){
            return ResponseResult.success("添加成功");
        }
        return ResponseResult.failed("添加失败");
    }

    @PutMapping
    public ResponseResult<String> update(@RequestBody UtsResourceParam resourceParam){
        UtsResource resource = BeanUtil.toBean(resourceParam, UtsResource.class);
        int count = resourceService.update(resource);
        if (count > 0){
            return ResponseResult.success("添加成功");
        }
        return ResponseResult.failed("添加失败");
    }

    @GetMapping("{resourceId}")
    public ResponseResult<UtsResource> select(@PathVariable("resourceId") String resourceId){
        UtsResource resource = resourceService.selectById(resourceId);
        return ResponseResult.success(resource);
    }

    @DeleteMapping("{resourceId}")
    public ResponseResult<String> delete(@PathVariable("resourceId") String resourceId){
        int count = resourceService.delete(resourceId);
        if (count > 0){
            return ResponseResult.success("删除成功");
        }
        return ResponseResult.failed("删除失败");
    }

    @GetMapping("role/{roleId}")
    public ResponseResult<List<String>> selectIdByRole(@PathVariable("roleId") String roleId){
        List<String> resourceList = resourceService.selectByRoleId(roleId);
        return ResponseResult.success(resourceList);
    }

}
