package com.ooqn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.entity.model.DtsCategory;
import com.ooqn.service.DtsCategoryService;

@RestController
@RequestMapping("api/category")
public class DtsCategoryController extends BaseController {

    @Autowired
    private DtsCategoryService categoryService;

    @GetMapping("list")
    public List<DtsCategory> selectCategoryList(@RequestParam String type,@RequestParam String parentId) {
        return categoryService.selectCategoryList(type,parentId);
    }
    
}
