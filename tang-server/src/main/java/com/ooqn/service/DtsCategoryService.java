package com.ooqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ooqn.entity.model.DtsCategory;
import com.ooqn.repository.DtsCategoryRepository;

@Service
public class DtsCategoryService {

    @Autowired
    private DtsCategoryRepository categoryRepository;

    public List<DtsCategory> selectCategoryList(String type,String parentId) {
        return categoryRepository.findByTypeAndParentId(type,parentId);
    }

}
