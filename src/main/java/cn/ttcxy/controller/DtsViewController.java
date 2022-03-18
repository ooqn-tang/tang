package cn.ttcxy.controller;

import com.github.pagehelper.PageInfo;
import cn.ttcxy.entity.dto.DtsRecordDto;
import cn.ttcxy.entity.dto.DtsViewDto;
import cn.ttcxy.service.DtsViewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/view")
public class DtsViewController {

    @Autowired
    private DtsViewService viewService;

    @GetMapping
    public ResponseEntity<List<DtsRecordDto>> load(){
        return null;
    }

    @GetMapping("list")
    public ResponseEntity<PageInfo<DtsViewDto>> selectList(
            @RequestParam(value = "type",defaultValue = "")String type){
        PageInfo<DtsViewDto> list = viewService.list(type);
        return ResponseEntity.ok(list);
    }
}
