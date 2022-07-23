package cn.ttcxy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.ttcxy.core.BaseController;
import cn.ttcxy.entity.model.DtsDynamic;
import cn.ttcxy.entity.param.DtsDynamicParam;
import cn.ttcxy.service.DtsDynamicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/dynamic")
public class DtsDynamicController extends BaseController {

    @Autowired
    private DtsDynamicService dynamicService;

    @PostMapping
    public ResponseEntity<?> insert(DtsDynamicParam dynamicParam){
        DtsDynamic dynamic = BeanUtil.toBean(dynamicParam, DtsDynamic.class);
        return ResponseEntity.ok(dynamicService.insert(dynamic));
    }

    @GetMapping
    public ResponseEntity<?> select(@RequestParam(value = "type")String type){
        return ResponseEntity.ok(dynamicService.select(authorId(),type));
    }

    @DeleteMapping("{dynamicId}")
    public ResponseEntity<?> delete(@PathVariable("dynamicId") String dynamicId){
        return ResponseEntity.ok(dynamicService.delete(dynamicId));
    }
}
