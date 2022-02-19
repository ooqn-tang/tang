package net.ttcxy.tang.portal.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.CurrentAuthor;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.param.UtsAuthorUpdateParam;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Map;

@RestController
@RequestMapping("api/author")
@Validated
public class UtsAuthorController {

    @Autowired
    private UtsAuthorService authorService;


    @Autowired
    private HttpSession httpSession;

    @GetMapping("authorListArticleCount")
    public ResponseEntity<PageInfo<Map<String, String>>> select(
            @RequestParam(value = "page", defaultValue = "1") Integer page) {
        PageInfo<Map<String, String>> mapPageInfo = authorService.selectAuthorArticleCount(page, 100);
        return ResponseEntity.ok(mapPageInfo);
    }


    @GetMapping("isLogin")
    public ResponseEntity<Boolean> isLogin() {
        String authorId = CurrentUtil.id();
        if (authorId == null) {
            return ResponseEntity.ok(false);
        }
        return ResponseEntity.ok(true);
    }

    @PutMapping
    public ResponseEntity<String> updateAuthor(@RequestBody UtsAuthorUpdateParam authorParam) {

        UtsAuthor author = BeanUtil.toBean(authorParam, UtsAuthor.class);

        String authorId = CurrentUtil.id();

        author.setAuthorId(authorId);

        int count = authorService.updateAuthorByName(author);
        if (count > 0) {
            CurrentAuthor currentAuthor = CurrentUtil.author();
            BeanUtil.copyProperties(currentAuthor, authorService.selectAuthorByName(currentAuthor.getUsername()));
            return ResponseEntity.ok("更新成功");
        }
        throw new ApiException();
    }


    @GetMapping("{username}")
    public ResponseEntity<UtsAuthor> authorByUsername(@PathVariable(value = "username") String username) {
        UtsAuthor utsAuthor = authorService.selectAuthorByName(username);
        utsAuthor.setPassword(null);
        return ResponseEntity.ok(utsAuthor);
    }

    @GetMapping("list")
    public ResponseEntity<PageInfo<UtsAuthor>> authorList(@RequestParam(value = "page", defaultValue = "1") Integer page) {
        return ResponseEntity.ok(authorService.authorList(page, 10));
    }
}
