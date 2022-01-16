package net.ttcxy.tang.portal.controller.api.admin;

import cn.hutool.core.bean.BeanUtil;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.param.UtsAuthorParam;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import net.ttcxy.tang.portal.service.UtsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/author")
public class ApiAdminAuthorController {

    @Autowired
    private UtsAuthorService authorService;

    @Autowired
    private UtsRoleService roleService;


    @GetMapping
    public ResponseResult<List<UtsAuthor>> select(){
        List<UtsAuthor> authorList = authorService.select();
        return ResponseResult.success(authorList);
    }

    @PostMapping
    public ResponseResult<String> insert(@RequestBody UtsAuthorParam authorParam){
        UtsAuthor author = BeanUtil.toBean(authorParam, UtsAuthor.class);
        int count = authorService.insertAuthor(author);
        if (count > 0){
            return ResponseResult.success("添加成功");
        }
        return ResponseResult.failed("添加失败");
    }

    @PutMapping
    public ResponseResult<String> update(@RequestBody UtsAuthorParam authorParam){
        UtsAuthor author = BeanUtil.toBean(authorParam, UtsAuthor.class);
        int count = authorService.update(author);
        if (count > 0){
            return ResponseResult.success("添加成功");
        }
        return ResponseResult.failed("添加失败");
    }

    @DeleteMapping("{authorId}")
    public ResponseResult<String> delete(@PathVariable("authorId") String authorId){
        int count = authorService.delete(authorId);
        if (count > 0){
            return ResponseResult.success("删除成功");
        }
        return ResponseResult.failed("删除失败");
    }

}
