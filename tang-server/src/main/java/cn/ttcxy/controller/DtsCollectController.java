package cn.ttcxy.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.ttcxy.entity.dto.DtsDataDto;
import cn.ttcxy.entity.model.DtsCollect;
import cn.ttcxy.service.DtsCollectService;

@RestController
@RequestMapping("api/collect")
public class DtsCollectController extends BaseController {

    @Autowired
    private DtsCollectService collectService;

    @GetMapping("{dataId}")
    public Long collect(@PathVariable("dataId") String dataId){
        String authorId = authorId();
        return collectService.select(authorId,dataId);
    }

    @GetMapping("list")
    public List<DtsDataDto> list(){
        String username = authorName();
        return collectService.selectCollect(username);
    }

    @PostMapping("{dataId}")
    public DtsCollect insert(@PathVariable("dataId") String dataId){
        String authorId = authorId();
        return collectService.insert(authorId,dataId);
    }

    @DeleteMapping("{dataId}")
    public Integer delete(@PathVariable("dataId") String dataId){
        String authorId = authorId();
        return collectService.unCollect(authorId,dataId);
    }
}
