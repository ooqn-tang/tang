package com.ooqn.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ooqn.entity.model.StsTemplate;
import com.ooqn.repository.StsTemplateRepository;

@Service
public class StsTemplateService {

    @Autowired
    private StsTemplateRepository templateResource;

    public static Map<String, StsTemplate> templateMap = new HashMap<>();

    public String run(String name) {
        if(templateMap.size() == 0){
            templateResource.findAll().forEach(template -> {
                templateMap.put(template.getName(), template);
            });
        }
        StsTemplate template = templateMap.get(name);
        if(template == null){
            return null;
        }
        return template.getContext();
    }

    public Iterable<StsTemplate> select() {
        return templateResource.findAll(); 
    }

    public StsTemplate insert(StsTemplate template) {
        return templateResource.save(template);
    }

    public void delete(String id) {
        templateResource.deleteById(id);
    }

    public StsTemplate update(StsTemplate template) {
        StsTemplate newTemplate = templateResource.findById(template.getId()).orElseThrow();
        newTemplate.setContext(template.getContext());
        newTemplate.setName(template.getName());
        newTemplate.setUpdateTime(template.getUpdateTime());
        newTemplate.setSynopsis(template.getSynopsis());
        return templateResource.save(newTemplate);
    }

}
