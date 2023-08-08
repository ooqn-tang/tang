package com.ooqn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.core.BaseController;
import com.ooqn.core.security.NotRole;
import com.ooqn.entity.model.DtsCategory;
import com.ooqn.service.DtsCategoryService;

import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("api/category")
@Tag(name = "分类")
public class DtsCategoryController extends BaseController {

    @Autowired
    private DtsCategoryService categoryService;

    @NotRole
    @GetMapping("list")
    public List<DtsCategory> selectCategoryList(@RequestParam String type) {
        return categoryService.selectCategoryList(type);
    }

    @NotRole
    @GetMapping("all")
    public List<DtsCategory> selectCategoryAllList(@RequestParam String type) {
        return categoryService.selectCategoryAllList(type);
    }
    
}
