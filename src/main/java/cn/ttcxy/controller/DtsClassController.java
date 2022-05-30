package cn.ttcxy.controller;

import cn.ttcxy.core.BaseController;
import cn.ttcxy.entity.model.DtsClass;
import cn.ttcxy.service.DtsClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/class")
public class DtsClassController extends BaseController {

    @Autowired
    private DtsClassService classService;

    @GetMapping
    public ResponseEntity<List<DtsClass>> select(@RequestParam("type") String type){
        List<DtsClass> classList = classService.selectClass(type);
        return ResponseEntity.ok(classList);
    }
}
