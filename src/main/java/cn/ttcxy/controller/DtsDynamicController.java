package cn.ttcxy.controller;

import cn.hutool.core.util.StrUtil;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.core.security.CurrentUtil;
import cn.ttcxy.entity.dto.UtsDynamicDto;
import cn.ttcxy.service.DtsDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/dynamic")
@Validated
public class DtsDynamicController {

    @Autowired
    private DtsDynamicService dtsDynamicService;

    @GetMapping
    public ResponseEntity<List<UtsDynamicDto>> dynamic(@RequestParam(value = "type", defaultValue = "") String type) {
        if (StrUtil.equalsAny(type,"","video","article")){
            return ResponseEntity.ok(dtsDynamicService.authorDynamicList(CurrentUtil.name(),type));
        }
        throw new ApiException(ResponseCode.FAILED);
    }
}