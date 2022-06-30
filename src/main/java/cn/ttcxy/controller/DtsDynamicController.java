package cn.ttcxy.controller;

import cn.hutool.core.util.StrUtil;
import cn.ttcxy.core.BaseController;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.dto.UtsDynamicDto;
import cn.ttcxy.service.DtsDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/dynamic")
@Validated
public class DtsDynamicController extends BaseController {

    @Autowired
    private DtsDynamicService dynamicService;

    @GetMapping
    public ResponseEntity<List<UtsDynamicDto>> dynamic(@RequestParam(value = "type", defaultValue = "") String type) {
        if (StrUtil.equalsAny(type,"","video","article")){
            return ResponseEntity.ok(dynamicService.authorDynamicList(authorName(),type));
        }
        throw new ApiException();
    }
}
