package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.CurrentAuthor;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.param.UtsAuthorUpdateParam;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/author")
@Validated
public class ApiAuthorController {

    @Autowired
    private UtsAuthorService authorService;


    @Autowired
    private HttpSession httpSession;

    @GetMapping("authorListArticleCount")
    public ResponseResult<PageInfo<List<Map<String, String>>>> select(
            @RequestParam(value = "page", defaultValue = "1") Integer page) {
        return ResponseResult.success(authorService.selectAuthorArticleCount(page, 100));
    }


    @GetMapping("isLogin")
    public ResponseResult<Boolean> isLogin() {
        String authorId = CurrentUtil.id();
        if (authorId == null) {
            return ResponseResult.success(false);
        }
        return ResponseResult.success(true);
    }

    @PutMapping
    public ResponseResult<String> updateAuthor(@RequestBody UtsAuthorUpdateParam authorParam) {

        UtsAuthor author = BeanUtil.toBean(authorParam, UtsAuthor.class);

        String authorId = CurrentUtil.id();

        author.setAuthorId(authorId);

        int count = authorService.updateAuthorByName(author);
        if (count > 0) {
            CurrentAuthor currentAuthor = CurrentUtil.author();
            BeanUtil.copyProperties(currentAuthor, authorService.selectAuthorByName(currentAuthor.getUsername()));
            return ResponseResult.success("更新成功");
        }
        throw new ApiException();
    }


    @GetMapping("{username}")
    public ResponseResult<UtsAuthor> authorByUsername(@PathVariable(value = "username") String username) {
        UtsAuthor utsAuthor = authorService.selectAuthorByName(username);
        utsAuthor.setPassword(null);
        return ResponseResult.success(utsAuthor);
    }

    @GetMapping("list")
    public ResponseResult<PageInfo<UtsAuthor>> authorList(@RequestParam(value = "page", defaultValue = "1") Integer page) {
        return ResponseResult.success(authorService.authorList(page, 10));
    }


    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("mima135654.."));
    }
}
