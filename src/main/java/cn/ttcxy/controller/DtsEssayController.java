package cn.ttcxy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.ttcxy.core.BaseController;
import cn.ttcxy.entity.model.DtsEssay;
import cn.ttcxy.entity.param.DtsEssayParam;
import cn.ttcxy.service.DtsEssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/essay")
public class DtsEssayController extends BaseController {

    @Autowired
    private DtsEssayService essayService;

    @PostMapping
    public ResponseEntity<?> insert(DtsEssayParam essayParam){
        DtsEssay essay = BeanUtil.toBean(essayParam, DtsEssay.class);
        return ResponseEntity.ok(essayService.insert(essay));
    }

    @GetMapping
    public ResponseEntity<?> select(@RequestParam(value = "type")String type){
        return ResponseEntity.ok(essayService.select(authorId(),type));
    }

    @GetMapping("essay")
    public ResponseEntity<?> selectEssay(@RequestParam(value = "type")String type){
        return ResponseEntity.ok(essayService.selectEssay(authorId(),type));
    }

    @DeleteMapping("{essayId}")
    public ResponseEntity<?> delete(@PathVariable("essayId") String essayId){
        return ResponseEntity.ok(essayService.delete(essayId));
    }
}
