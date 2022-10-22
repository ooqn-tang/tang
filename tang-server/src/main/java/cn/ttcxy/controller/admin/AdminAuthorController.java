package cn.ttcxy.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.hutool.core.bean.BeanUtil;
import cn.ttcxy.controller.BaseController;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.core.exception.ApiException;
import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.entity.param.UtsAuthorParam;
import cn.ttcxy.service.UtsAuthorService;

@RestController
@RequestMapping("api/admin/author")
public class AdminAuthorController extends BaseController {

    @Autowired
    private UtsAuthorService authorService;

    @GetMapping
    public List<UtsAuthor> select(@RequestParam(value = "queryData",defaultValue = "") String queryData){
        return authorService.select(queryData);
    }

    @PostMapping
    public String insert(@RequestBody UtsAuthorParam authorParam){
        UtsAuthor author = BeanUtil.toBean(authorParam, UtsAuthor.class);
        UtsAuthor utsAuthor = authorService.insertAuthor(author);
        if (utsAuthor != null){
            return ResponseCode.SUCCESS.getMessage();
        }
        throw new ApiException();
    }

    @PutMapping
    public long update(@RequestBody UtsAuthorParam authorParam){
        UtsAuthor author = BeanUtil.toBean(authorParam, UtsAuthor.class);
        return authorService.update(author);
    }

    @DeleteMapping("{authorId}")
    public void delete(@PathVariable("authorId") String authorId){
        authorService.delete(authorId);
    }

}
