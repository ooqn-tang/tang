package cn.ttcxy.controller;

import cn.hutool.core.bean.BeanUtil;
import cn.ttcxy.core.exception.ApiException;
import cn.ttcxy.entity.dto.DtsEssayDto;
import cn.ttcxy.entity.model.DtsEssay;
import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.entity.param.DtsEssayParam;
import cn.ttcxy.service.DtsEssayService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/essay")
public class DtsEssayController extends BaseController {

    @Autowired
    private DtsEssayService essayService;

    @PostMapping
    public DtsEssayDto insert(@RequestBody DtsEssayParam essayParam){
        DtsEssay essay = BeanUtil.toBean(essayParam, DtsEssay.class);
        essay.setAuthorId(authorId());
        essay.setType("essay");
        DtsEssay dtsEssay = essayService.insert(essay);
        if (dtsEssay != null){
            DtsEssayDto dtsEssayDto = BeanUtil.toBean(essay, DtsEssayDto.class);
            UtsAuthor author = author();
            dtsEssayDto.setUsername(author.getUsername());
            dtsEssayDto.setNickname(author.getNickname());
            return dtsEssayDto;
        }
        throw new ApiException("添加失败");
    }

    @GetMapping
    public PageInfo<DtsEssayDto> select(@RequestParam(defaultValue = "0")Integer page){
        return essayService.select(page);
    }

    @DeleteMapping("{essayId}")
    public void delete(@PathVariable("essayId") String essayId){
        essayService.delete(essayId);
    }
}
