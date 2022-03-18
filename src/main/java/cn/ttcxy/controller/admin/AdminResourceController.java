package cn.ttcxy.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.model.UtsResource;
import cn.ttcxy.entity.param.UtsResourceParam;
import cn.ttcxy.service.UtsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/admin/resource")
public class AdminResourceController {

    @Autowired
    private UtsResourceService resourceService;

    @GetMapping("refresh")
    public void refresh(){
        resourceService.urls();
    }

    @GetMapping
    public ResponseEntity<List<UtsResource>> loadResponseList(@RequestParam(value = "queryData",defaultValue = "")String queryData){
        List<UtsResource> resourceList = resourceService.select(queryData);
        return ResponseEntity.ok(resourceList);
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody UtsResourceParam resourceParam){
        UtsResource resource = BeanUtil.toBean(resourceParam, UtsResource.class);
        resource.setResourceId(IdUtil.objectId());
        resource.setCreateTime(new Date());
        int count = resourceService.insert(resource);
        if (count > 0){
            return ResponseEntity.ok("添加成功");
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody UtsResourceParam resourceParam){
        UtsResource resource = BeanUtil.toBean(resourceParam, UtsResource.class);
        int count = resourceService.update(resource);
        if (count > 0){
            return ResponseEntity.ok("添加成功");
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @GetMapping("{resourceId}")
    public ResponseEntity<UtsResource> select(@PathVariable("resourceId") String resourceId){
        UtsResource resource = resourceService.selectById(resourceId);
        return ResponseEntity.ok(resource);
    }

    @DeleteMapping("{resourceId}")
    public ResponseEntity<String> delete(@PathVariable("resourceId") String resourceId){
        int count = resourceService.delete(resourceId);
        if (count > 0){
            return ResponseEntity.ok("删除成功");
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @GetMapping("role/{roleId}")
    public ResponseEntity<List<String>> selectIdByRole(@PathVariable("roleId") String roleId){
        List<String> resourceList = resourceService.selectByRoleId(roleId);
        return ResponseEntity.ok(resourceList);
    }

}