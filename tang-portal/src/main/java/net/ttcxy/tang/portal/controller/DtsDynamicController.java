package net.ttcxy.tang.portal.controller;

import cn.hutool.core.util.StrUtil;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.UtsDynamicDto;
import net.ttcxy.tang.portal.service.DtsDynamicService;
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
