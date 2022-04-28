package cn.ttcxy.controller.admin;

import cn.ttcxy.controller.BaseController;
import cn.ttcxy.entity.dto.DtsCommentDto;
import cn.ttcxy.entity.param.DtsCommentParam;
import cn.ttcxy.service.DtsCommentService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/comment")
public class AdminCommentController extends BaseController {

    @Autowired
    private DtsCommentService commentService;

    @GetMapping("list")
    public ResponseEntity<PageInfo<DtsCommentDto>> selectAll(
            @RequestParam(value = "state",defaultValue = "") String state,
            @RequestParam(value = "page",defaultValue = "1") Integer page){
        return ResponseEntity.ok(commentService.selectAll(state,page));
    }

    @PutMapping("pass/{commentId}")
    public ResponseEntity<?> pass(@RequestBody DtsCommentParam commentParam){
        Integer state = commentParam.getState();
        String commentId = commentParam.getCommentId();
        return ResponseEntity.ok(commentService.updateState(commentId,state));
    }
}
