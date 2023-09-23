package com.ooqn.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ooqn.core.template.FreemarkerEngine;
import com.ooqn.entity.model.DtsContext;
import com.ooqn.entity.model.StsTemplate;
import com.ooqn.repository.DtsContextRepository;
import com.ooqn.repository.StsTemplateRepository;

@Service
public class StsTemplateService {

    @Autowired
    private StsTemplateRepository templateResource;

    @Autowired
    private DtsContextRepository contextResource;

    public static Map<String, StsTemplate> templateMap = new HashMap<>();

    public String run(String path, Map<String,Object> params) {
        if(templateMap.size() == 0){
            templateResource.findAll().forEach(template -> {
                templateMap.put(template.getPath(), template);
            });
        }
        StsTemplate template = templateMap.get(path);
        if(template != null){
            String contextId = template.getContextId();
            String templateStr = "";
            // 如果 contextResource.findById(contextId) 不为空获取 context 的 text 属性
            DtsContext context = contextResource.findById(contextId).orElseThrow();
            if(context != null){
                templateStr = context.getText();
                return FreemarkerEngine.run(templateStr, params);
            }
        }
        return "";
    }

}
