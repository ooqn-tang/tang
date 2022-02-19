package net.ttcxy.tang.portal.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.param.UtsAuthorParam;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import net.ttcxy.tang.portal.service.UtsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/author")
public class AdminAuthorController {

    @Autowired
    private UtsAuthorService authorService;

    @Autowired
    private UtsRoleService roleService;


    @GetMapping
    public ResponseEntity<List<UtsAuthor>> select(){
        List<UtsAuthor> authorList = authorService.select();
        return ResponseEntity.ok(authorList);
    }

    @PostMapping
    public ResponseEntity<String> insert(@RequestBody UtsAuthorParam authorParam){
        UtsAuthor author = BeanUtil.toBean(authorParam, UtsAuthor.class);
        int count = authorService.insertAuthor(author);
        if (count > 0){
            return ResponseEntity.ok("添加成功");
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody UtsAuthorParam authorParam){
        UtsAuthor author = BeanUtil.toBean(authorParam, UtsAuthor.class);
        int count = authorService.update(author);
        if (count > 0){
            return ResponseEntity.ok("添加成功");
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @DeleteMapping("{authorId}")
    public ResponseEntity<String> delete(@PathVariable("authorId") String authorId){
        int count = authorService.delete(authorId);
        if (count > 0){
            return ResponseEntity.ok("删除成功");
        }
        throw new ApiException(ResponseCode.FAILED);
    }

}
