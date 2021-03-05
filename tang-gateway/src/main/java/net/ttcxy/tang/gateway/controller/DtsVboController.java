package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.bean.BeanUtil;
import io.swagger.annotations.Api;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.gateway.entity.param.DtsVboCommentParam;
import net.ttcxy.tang.gateway.service.DtsVboCommentService;
import net.ttcxy.tang.gateway.service.DtsVboService;
import net.ttcxy.tang.model.DtsVbo;
import net.ttcxy.tang.model.DtsVboComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @PostMapping("delete")
    public ResponseResult<?> delete(@RequestBody DtsVbo dtsVbo){
        String id = dtsVbo.getId();
        return ResponseResult.success(dtsVboService.delete(id));
    }

    @PostMapping("favorite")
    public ResponseResult<?> favorite(@RequestBody DtsVbo dtsVbo) {
        String id = dtsVbo.getId();
        return ResponseResult.success(dtsVboService.favorite(id));
    }

    @Autowired
    private DtsVboCommentService dtsVboCommentService;

    @PostMapping("comment")
    public ResponseResult<?> comment(@Valid DtsVboCommentParam dtsVboCommentParam){
        DtsVboComment dtsVboComment = new DtsVboComment();
        BeanUtil.copyProperties(dtsVboCommentParam,dtsVboComment);

        int i = dtsVboCommentService.addComment(dtsVboComment);
        return ResponseResult.success(i);
    }
}
