package net.ttcxy.tang.portal.controller.admin;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.entity.dto.DtsCommentDto;
import net.ttcxy.tang.portal.entity.param.DtsCommentParam;
import net.ttcxy.tang.portal.service.DtsCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/admin/comment")
public class AdminCommentController {

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
