package net.ttcxy.tang.gateway.controller;

import io.swagger.annotations.Api;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.gateway.service.DtsVboService;
import net.ttcxy.tang.model.DtsVbo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("vbo")
@Api(tags = "VboController")
public class DtsVboController {

    @Autowired
    private DtsVboService dtsVboService;

    @PostMapping("insert")
    public ResponseResult<?> insert(@RequestBody DtsVbo dtsVbo){
        int count = dtsVboService.insert(dtsVbo);
        return ResponseResult.success(count);
    }

    @GetMapping("select")
    public ResponseResult<?> select(
            @RequestParam(value = "author" , defaultValue = "")String author,
            @RequestParam(value = "time" , defaultValue = "")String time,
            @RequestParam(value = "page" ,defaultValue = "1")Integer page){
        return ResponseResult.success(dtsVboService.selectVbo(author));
    }
}
