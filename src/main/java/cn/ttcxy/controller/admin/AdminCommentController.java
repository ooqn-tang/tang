package cn.ttcxy.controller.admin;

import cn.ttcxy.core.BaseController;
import cn.ttcxy.entity.dto.DtsCommentDto;
import cn.ttcxy.entity.param.DtsCommentParam;
import cn.ttcxy.service.DtsCommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/comment")
public class AdminCommentController extends BaseController {

    @Autowired
    private DtsCommentService commentService;

    @GetMapping("list")
    public PageInfo<DtsCommentDto> selectAll(
            @RequestParam(value = "state",defaultValue = "") String state,
            @RequestParam(value = "page",defaultValue = "1") Integer page){
        return commentService.selectAll(state,page);
    }

    @PutMapping("pass/{commentId}")
    public Integer pass(@RequestBody DtsCommentParam commentParam){
        Integer state = commentParam.getState();
        String commentId = commentParam.getCommentId();
        return commentService.updateState(commentId,state);
    }
}
