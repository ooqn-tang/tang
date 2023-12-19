package com.ooqn.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ooqn.core.control.BaseController;
import com.ooqn.core.security.NotLogin;
import com.ooqn.entity.dto.DtsRemarkDto;
import com.ooqn.entity.model.DtsRemark;
import com.ooqn.entity.param.DtsRemarkParam;
import com.ooqn.service.DtsRemarkService;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;

@RestController
@RequestMapping("api/remark")
public class DtsRemarkController extends BaseController {
    
    @Autowired
    private DtsRemarkService remarkService;

    @PostMapping
    public DtsRemarkDto insertRemark(@RequestBody DtsRemarkParam remarkParam){
        DtsRemark remark = BeanUtil.toBean(remarkParam, DtsRemark.class);
        remark.setRemarkId(IdUtil.objectId());
        remark.setCreateTime(new Date());
        remark.setUpdateTime(new Date());
        remark.setAuthorId(authorId());
        DtsRemarkDto dtsRemarkDto = new DtsRemarkDto(remarkService.insert(remark));
        dtsRemarkDto.setAuthor(author());
        return dtsRemarkDto;
    }

    @DeleteMapping("{dataId}")
    public void deleteRemark(@PathVariable("dataId") String dataId){
        remarkService.delete(dataId);
    }

    @NotLogin
    @GetMapping("{dataId}/list")
    public Page<DtsRemarkDto> listRemark(@PathVariable("dataId") String dataId,@RequestParam("pageNum") Integer pageName){
        Pageable pageable = PageRequest.of(pageName, 15);
        return remarkService.list(dataId, pageable);
    }
}
