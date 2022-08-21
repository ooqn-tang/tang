package cn.ttcxy.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;

import cn.hutool.core.bean.BeanUtil;
import cn.ttcxy.core.exception.ApiException;
import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.entity.param.UtsAuthorParam;
import cn.ttcxy.service.UtsAuthorService;

@RestController
@RequestMapping("api/author")
@Validated
public class UtsAuthorController extends BaseController {

    @Autowired
    private UtsAuthorService authorService;

    @GetMapping("selectAuthor")
    public PageInfo<UtsAuthor> select(
            @RequestParam(value = "page", defaultValue = "1") Integer page) {
        return authorService.selectAuthor(page, 100);
    }

    @PutMapping
    public String update(@RequestBody UtsAuthorParam authorParam) {
        UtsAuthor author = BeanUtil.toBean(authorParam, UtsAuthor.class);
        String authorId = authorId();
        author.setAuthorId(authorId);
        int count = authorService.updateAuthorByName(author);
        if (count > 0) {
            return "更新成功";
        }
        throw new ApiException();
    }


    @GetMapping("{username}")
    public UtsAuthor authorByUsername(@PathVariable(value = "username") String username) {
        UtsAuthor utsAuthor = authorService.selectAuthorByName(username);
        utsAuthor.setPassword(null);
        return utsAuthor;
    }

    @GetMapping("list")
    public PageInfo<UtsAuthor> authorList(@RequestParam(value = "page", defaultValue = "1") Integer page) {
        return authorService.selectAuthor(page, 10);
    }
}
