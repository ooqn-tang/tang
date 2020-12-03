package net.ttcxy.tang.admin.controller;

import cn.hutool.core.bean.BeanUtil;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.entity.dto.DtsBlogDto;
import net.ttcxy.tang.entity.model.DtsBlog;
import net.ttcxy.tang.entity.param.DtsBlogParam;
import net.ttcxy.tang.service.DtoBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("blog")
public class DtsBlogController {

    //@Autowired
    private DtoBlogService dtoBlogService;

    @PostMapping("insert")
    public ResponseResult insert(@RequestBody DtsBlogParam blogParam){
        DtsBlog blog = new DtsBlog();
        BeanUtil.copyProperties(blogParam,blog);

        int count = dtoBlogService.insert(blog);
        if (count > 0) {
            return ResponseResult.success(count);
        }
        return ResponseResult.failed();
    }

    @PostMapping("delete")
    public ResponseResult delete(@NotNull(message = "ID不能为空") String id){
        int count = dtoBlogService.delete(id);
        if (count > 0){
            return ResponseResult.success();
        }
        return ResponseResult.failed();
    }

    @PostMapping("update")
    public ResponseResult update(@RequestBody DtsBlogParam blogParam){
        DtsBlog blog = new DtsBlog();
        BeanUtil.copyProperties(blogParam,blog);

        int count = dtoBlogService.update(blog);
        if (count > 0){
            return ResponseResult.success();
        }
        return ResponseResult.failed();
    }

    @PostMapping("query")
    public ResponseResult<PageInfo<?>> query(@RequestBody DtsBlogParam blogParam){
        PageInfo<List<DtsBlogDto>> listPageInfo = dtoBlogService.query(blogParam);
        return ResponseResult.success(listPageInfo);
    }


}
