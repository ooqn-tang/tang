package net.ttcxy.tang.gateway.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.core.api.ApiException;
import net.ttcxy.tang.gateway.core.api.ResponseResult;
import net.ttcxy.tang.gateway.core.api.ResponseCode;
import net.ttcxy.tang.gateway.entity.dto.UtsAuthorDto;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.UtsFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 粉丝
 * @author huanglei
 */
@RestController
@RequestMapping("fans")
@Api("FansController")
public class UtsFansController {

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private UtsFansService fansService;

    @GetMapping("list")
    @ApiOperation("关注的作者列表")
    public ResponseResult<PageInfo<UtsAuthorDto>> fansList(){
        String authorId = currentAuthorService.getAuthor().getAuthorId();
        PageInfo<UtsAuthorDto> authorDtoPageInfo = fansService.selectFansList(authorId);
        return ResponseResult.success(authorDtoPageInfo);
    }

    @PostMapping("insert/{fansName}")
    @ApiOperation("添加关注")
    public ResponseResult<?> insert(@PathVariable("fansName") String fansName){
        int count = fansService.insertFans(fansName);
        if (count > 0){
            return ResponseResult.success(count);
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @PostMapping("delete/{fansName}")
    @ApiOperation("删除关注")
    public ResponseResult<Integer> delete(@PathVariable("fansName") String fansName){
        int count = fansService.deleteFans(fansName);
        if (count > 0){
            return ResponseResult.success(count);
        }
        throw new ApiException(ResponseCode.FAILED);
    }
}
