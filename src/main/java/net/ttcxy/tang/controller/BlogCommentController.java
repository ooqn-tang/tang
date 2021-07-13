package net.ttcxy.tang.controller;

import io.swagger.annotations.Api;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("comment")
@Validated
@Api("博客评论")
public class BlogCommentController {
}
