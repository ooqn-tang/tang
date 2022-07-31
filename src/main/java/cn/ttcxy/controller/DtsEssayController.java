package cn.ttcxy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.ttcxy.core.BaseController;
import cn.ttcxy.entity.dto.DtsEssayDto;
import cn.ttcxy.entity.model.DtsEssay;
import cn.ttcxy.entity.param.DtsEssayParam;
import cn.ttcxy.service.DtsEssayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/essay")
public class DtsEssayController extends BaseController {

    @Autowired
    private DtsEssayService essayService;

    @PostMapping
    public Integer insert(@RequestBody DtsEssayParam essayParam){
        DtsEssay essay = BeanUtil.toBean(essayParam, DtsEssay.class);
        essay.setAuthorId(authorId());
        essay.setType("essay");
        return essayService.insert(essay);
    }

    @GetMapping
    public List<DtsEssayDto> select(@RequestParam(value = "type",required = false)String type){
        return essayService.select(authorId(),type);
    }

    @GetMapping("essay")
    public Object selectEssay(@RequestParam(value = "type")String type){
        return essayService.selectEssay(authorId(),type);
    }

    @DeleteMapping("{essayId}")
    public Integer delete(@PathVariable("essayId") String essayId){
        return essayService.delete(essayId);
    }
}
