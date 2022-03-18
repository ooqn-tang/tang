package cn.ttcxy.controller.admin;

import cn.hutool.core.bean.BeanUtil;
import cn.ttcxy.controller.BaseController;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.entity.param.UtsAuthorParam;
import cn.ttcxy.service.UtsAuthorService;
import cn.ttcxy.service.UtsRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/admin/author")
public class AdminAuthorController extends BaseController {

    @Autowired
    private UtsAuthorService authorService;

    @Autowired
    private UtsRoleService roleService;


    @GetMapping
    public ResponseEntity<List<UtsAuthor>> select(@RequestParam(value = "queryData",defaultValue = "") String queryData){
        List<UtsAuthor> authorList = authorService.select(queryData);
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
