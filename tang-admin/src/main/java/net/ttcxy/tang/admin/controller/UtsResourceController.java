package net.ttcxy.tang.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.code.Insert;
import net.ttcxy.tang.code.Update;
import net.ttcxy.tang.entity.model.UtsResource;
import net.ttcxy.tang.entity.param.UtsResourceParam;
import net.ttcxy.tang.service.UtsResourceService;
import org.hibernate.validator.internal.engine.groups.Group;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("resource")
@Api("资源管理")
public class UtsResourceController {

    @Autowired
    UtsResourceService utsResourceService;

    @PostMapping("list")
    @ApiOperation("读取资源列表")
    public ResponseResult<?> resourceList(){
        return ResponseResult.success(utsResourceService.resourceList());
    }

    @PostMapping("insert")
    @ApiOperation("添加资源")
    public ResponseResult<?> insertResource(UtsResourceParam resource){
        UtsResource utsResource = new UtsResource();
        BeanUtil.copyProperties(resource,utsResource);
        int count = utsResourceService.insertResource(utsResource);
        if (count > 0) {
            return ResponseResult.success();
        }
        return ResponseResult.failed();
    }

    @PostMapping("delete/{id}")
    @ApiOperation("删除资源")
    public ResponseResult<?> deleteResource(@PathVariable("id") String id){
        int count = utsResourceService.deleteResource(id);
        if (count > 0){
            return ResponseResult.success();
        }
        return ResponseResult.failed();
    }

    @PostMapping("update")
    @ApiOperation("更新资源")
    public ResponseResult<?> updateResource(@Validated({Update.class}) UtsResourceParam resource){
        UtsResource utsResource = new UtsResource();
        BeanUtil.copyProperties(resource,utsResource);

        int count = utsResourceService.updateResource(utsResource);
        if (count > 0){
            return ResponseResult.success();
        }
        return ResponseResult.failed();
    }
}
