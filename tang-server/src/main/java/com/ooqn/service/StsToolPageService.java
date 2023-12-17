package com.ooqn.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ooqn.core.template.FreemarkerEngine;
import com.ooqn.entity.model.DtsContext;
import com.ooqn.entity.model.StsToolPage;
import com.ooqn.repository.DtsContextRepository;
import com.ooqn.repository.StsToolPageRepository;

@Service
public class StsToolPageService {

    @Autowired
    private StsToolPageRepository templateResource;

    @Autowired
    private DtsContextRepository contextResource;

    public static Map<String, StsToolPage> templateMap = new HashMap<>();

    public String run(String name) {
        if(templateMap.size() == 0){
            templateResource.findAll().forEach(template -> {
                templateMap.put(template.getName(), template);
            });
        }

        StsToolPage template = templateMap.get(name);
        if(template == null){
            return null;
        }

        String contextId = template.getContextId();
        DtsContext context = contextResource.findById(contextId).orElseThrow();
        return context.getText();
    }

}
