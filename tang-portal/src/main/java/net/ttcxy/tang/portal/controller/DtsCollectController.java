package net.ttcxy.tang.portal.controller;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.DtsArticleDto;
import net.ttcxy.tang.portal.entity.dto.DtsDataDto;
import net.ttcxy.tang.portal.service.DtsCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/collect")
public class DtsCollectController {

    @Autowired
    private DtsCollectService collectService;

    @GetMapping("{dataId}")
    public ResponseEntity<Long> getCollect(@PathVariable("dataId") String dataId){
        String authorId = CurrentUtil.id();
        return ResponseEntity.ok(collectService.select(authorId,dataId));
    }

    @GetMapping("list")
    public ResponseEntity<PageInfo<DtsDataDto>> list(@RequestParam(value = "page",defaultValue = "1") Integer page){
        String username = CurrentUtil.name();
        return ResponseEntity.ok(collectService.selectCollect(username, page, 10));
    }

    @PostMapping("{dataId}")
    public ResponseEntity<Integer> insert(@PathVariable("dataId") String dataId){
        String authorId = CurrentUtil.id();
        return ResponseEntity.ok(collectService.insert(authorId,dataId));
    }

    @DeleteMapping("{dataId}")
    public ResponseEntity<Integer> delete(@PathVariable("dataId") String dataId){
        String authorId = CurrentUtil.id();
        return ResponseEntity.ok(collectService.unCollect(authorId,dataId));
    }
}
