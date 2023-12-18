package com.ooqn.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.entity.model.StsTemplate;
import com.ooqn.service.StsTemplateService;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/admin/template")
@Tag(name = "模板管理")
public class AdminTemplateController {

    @Autowired
    private StsTemplateService templateService;

    /**
     * 获取列表
     */
    @GetMapping
    public Iterable<StsTemplate> select() {
        return templateService.select();
    }

    /**
     * 插件模板
     */
    @PostMapping
    public StsTemplate insert(@RequestBody StsTemplate template) {
        template.setId(IdUtil.objectId());
        template.setCreateTime(DateUtil.date());
        template.setUpdateTime(DateUtil.date());
        return templateService.insert(template);
    }

    /**
     * 删除模板
     */
    @DeleteMapping("{id}")
    public void delete(@PathVariable("id") String id) {
        templateService.delete(id);
    }

    /**
     * 更新模板
     */
    @PutMapping
    public StsTemplate update(@RequestBody StsTemplate template){
        template.setUpdateTime(DateUtil.date());
        return templateService.update(template);
    }
    
}
