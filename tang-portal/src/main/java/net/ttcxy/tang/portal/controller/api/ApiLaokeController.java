package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.DtsLaokeDto;
import net.ttcxy.tang.portal.entity.model.DtsLaoke;
import net.ttcxy.tang.portal.entity.param.DtsLaokeParam;
import net.ttcxy.tang.portal.service.DtsLaokeService;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RequestMapping("api/laoke")
@RestController
@Validated
public class ApiLaokeController {

    @Autowired
    private DtsLaokeService dtsLaokeService;

    @PostMapping
    public ResponseResult<Integer> send(@RequestBody DtsLaokeParam laoke){
        DtsLaoke dtsLaoke = BeanUtil.toBean(laoke, DtsLaoke.class);
        dtsLaoke.setLaokeId(IdUtil.objectId());
        dtsLaoke.setAuthorId(CurrentUtil.id());
        dtsLaoke.setCreateDate(DateUtil.date());
        int insert = dtsLaokeService.insert(dtsLaoke);
        if (insert > 0){
            return ResponseResult.success(insert);
        }
        return ResponseResult.failed();
    }

    @GetMapping
    public ResponseResult<PageInfo<List<DtsLaokeDto>>> load(@RequestParam(value = "page",defaultValue = "1") Integer page){
        PageInfo<List<DtsLaokeDto>> listPageInfo = dtsLaokeService.loadList(1, 20);
        return ResponseResult.success(listPageInfo);
    }

    @DeleteMapping("{id}")
    public ResponseResult<Integer> delete(@PathVariable("id") String id){
        return ResponseResult.success(dtsLaokeService.delete(id));
    }
}
