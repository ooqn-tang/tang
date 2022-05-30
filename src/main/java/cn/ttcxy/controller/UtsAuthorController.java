package cn.ttcxy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.ttcxy.core.BaseController;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.entity.param.UtsAuthorParam;
import cn.ttcxy.service.UtsAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("api/author")
@Validated
public class UtsAuthorController extends BaseController {

    @Autowired
    private UtsAuthorService authorService;

    @Autowired
    private HttpSession httpSession;

    @GetMapping("authorListArticleCount")
    public ResponseEntity<?> select(
            @RequestParam(value = "page", defaultValue = "1") Integer page) {
        return ResponseEntity.ok(authorService.selectAuthorArticleCount(page, 100));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody UtsAuthorParam authorParam) {
        UtsAuthor author = BeanUtil.toBean(authorParam, UtsAuthor.class);
        String authorId = authorId();
        author.setAuthorId(authorId);
        int count = authorService.updateAuthorByName(author);
        if (count > 0) {
            return ResponseEntity.ok("更新成功");
        }
        throw new ApiException();
    }


    @GetMapping("{username}")
    public ResponseEntity<?> authorByUsername(@PathVariable(value = "username") String username) {
        UtsAuthor utsAuthor = authorService.selectAuthorByName(username);
        utsAuthor.setPassword(null);
        return ResponseEntity.ok(utsAuthor);
    }

    @GetMapping("list")
    public ResponseEntity<?> authorList(@RequestParam(value = "page", defaultValue = "1") Integer page) {
        return ResponseEntity.ok(authorService.authorList(page, 10));
    }
}
