package cn.ttcxy.controller;

import cn.ttcxy.entity.dto.DtsDataDto;
import cn.ttcxy.service.DtsCollectService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/collect")
public class DtsCollectController extends BaseController{

    @Autowired
    private DtsCollectService collectService;

    @GetMapping("{dataId}")
    public ResponseEntity<Long> getCollect(@PathVariable("dataId") String dataId){
        String authorId = authorId();
        return ResponseEntity.ok(collectService.select(authorId,dataId));
    }

    @GetMapping("list")
    public ResponseEntity<PageInfo<DtsDataDto>> list(@RequestParam(value = "page",defaultValue = "1") Integer page){
        String username = authorName();
        return ResponseEntity.ok(collectService.selectCollect(username, page, 10));
    }

    @PostMapping("{dataId}")
    public ResponseEntity<Integer> insert(@PathVariable("dataId") String dataId){
        String authorId = authorId();
        return ResponseEntity.ok(collectService.insert(authorId,dataId));
    }

    @DeleteMapping("{dataId}")
    public ResponseEntity<Integer> delete(@PathVariable("dataId") String dataId){
        String authorId = authorId();
        return ResponseEntity.ok(collectService.unCollect(authorId,dataId));
    }
}
