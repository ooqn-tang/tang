package net.ttcxy.tang.gateway.controller;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.core.api.ApiException;
import net.ttcxy.tang.gateway.core.api.ResponseResult;
import net.ttcxy.tang.gateway.core.api.ResponseCode;
import net.ttcxy.tang.gateway.core.exception.IErrorCode;
import net.ttcxy.tang.gateway.entity.dto.UtsAuthorDto;
import net.ttcxy.tang.gateway.entity.dto.UtsFansDto;
import net.ttcxy.tang.gateway.entity.model.UtsAuthor;
import net.ttcxy.tang.gateway.entity.model.UtsFans;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.UtsAuthorService;
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

    @Autowired
    UtsAuthorService utsAuthorService;

    @GetMapping("list")
    @ApiOperation("关注的作者列表")
    public ResponseResult<PageInfo<UtsFansDto>> fansList(){
        String authorId = currentAuthorService.getAuthor().getAuthorId();
        PageInfo<UtsFansDto> authorDtoPageInfo = fansService.selectFansList(authorId);
        return ResponseResult.success(authorDtoPageInfo);
    }

    @PostMapping("insert/{fansName}")
    @ApiOperation("添加关注")
    public ResponseResult<?> insert(@PathVariable("fansName") String fansName){
        String authorId = currentAuthorService.getAuthorId();

        UtsAuthor utsAuthor = utsAuthorService.selectAuthorByName(fansName);
        if (utsAuthor == null){
            throw new ApiException(ResponseCode.VALIDATE_FAILED);
        }

        UtsFans fans = new UtsFans();
        fans.setAuthorId(authorId);
        fans.setBeAuthorId(utsAuthor.getAuthorId());
        int count = fansService.insertFans(fans);
        if (count > 0){
            return ResponseResult.success(count);
        }
        throw new ApiException(ResponseCode.FAILED);
    }

    @DeleteMapping("{fansId}")
    @ApiOperation("删除关注")
    public ResponseResult<Integer> delete(@PathVariable("fansId") String fansId){
        String authorId = currentAuthorService.getAuthorId();

        int count = fansService.deleteFans(fansId,authorId);
        if (count > 0){
            return ResponseResult.success(count);
        }
        throw new ApiException(ResponseCode.FAILED);
    }
}
