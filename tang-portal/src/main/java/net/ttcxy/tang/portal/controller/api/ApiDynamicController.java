package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.CurrentAuthor;
import net.ttcxy.tang.portal.entity.dto.UtsDynamicDto;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.param.UtsAuthorUpdateParam;
import net.ttcxy.tang.portal.service.DynamicService;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/dynamic")
@Validated
public class ApiDynamicController {

    @Autowired
    private DynamicService dynamicService;

    @GetMapping
    public ResponseEntity<List<UtsDynamicDto>> dynamic(@RequestParam(value = "type", defaultValue = "") String type) {
        if (StrUtil.equalsAny(type,"","video","article")){
            return ResponseEntity.ok(dynamicService.authorDynamicList(CurrentUtil.name(),type));
        }
        throw new ApiException(ResponseCode.FAILED);
    }
}
