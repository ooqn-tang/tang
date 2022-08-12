package cn.ttcxy.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.controller.BaseController;
import cn.ttcxy.core.exception.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.model.UtsResource;
import cn.ttcxy.entity.param.UtsResourceParam;
import cn.ttcxy.service.UtsResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api/admin/resource")
public class AdminResourceController extends BaseController {

    @Autowired
    private UtsResourceService resourceService;

    @GetMapping("refresh")
    public void refresh(){
        resourceService.urls();
    }

    @GetMapping
    public List<UtsResource> loadResponseList(@RequestParam(value = "queryData",defaultValue = "")String queryData){
        return resourceService.select(queryData);
    }

    @PostMapping
    public String insert(@RequestBody UtsResourceParam resourceParam){
        UtsResource resource = BeanUtil.toBean(resourceParam, UtsResource.class);
        resource.setResourceId(IdUtil.objectId());
        resource.setCreateTime(new Date());
        int count = resourceService.insert(resource);
        if (count > 0){
            return ResponseCode.SUCCESS.getMessage();
        }
        throw new ApiException();
    }

    @PutMapping
    public String update(@RequestBody UtsResourceParam resourceParam){
        UtsResource resource = BeanUtil.toBean(resourceParam, UtsResource.class);
        int count = resourceService.update(resource);
        if (count > 0){
            return ResponseCode.SUCCESS.getMessage();
        }
        throw new ApiException();
    }

    @GetMapping("{resourceId}")
    public UtsResource select(@PathVariable("resourceId") String resourceId){
        return resourceService.selectById(resourceId);
    }

    @DeleteMapping("{resourceId}")
    public String delete(@PathVariable("resourceId") String resourceId){
        int count = resourceService.delete(resourceId);
        if (count > 0){
            return ResponseCode.SUCCESS.getMessage();
        }
        throw new ApiException();
    }

    @GetMapping("role/{roleId}")
    public List<String> selectIdByRole(@PathVariable("roleId") String roleId){
        return resourceService.selectByRoleId(roleId);
    }

}
