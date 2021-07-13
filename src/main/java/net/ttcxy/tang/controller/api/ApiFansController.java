package net.ttcxy.tang.controller.api;

import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.core.api.ApiException;
import net.ttcxy.tang.core.api.ResponseCode;
import net.ttcxy.tang.core.api.ResponseResult;
import net.ttcxy.tang.entity.dto.UtsFansDto;
import net.ttcxy.tang.entity.model.UtsAuthor;
import net.ttcxy.tang.entity.model.UtsFans;
import net.ttcxy.tang.service.CurrentAuthorService;
import net.ttcxy.tang.service.UtsAuthorService;
import net.ttcxy.tang.service.UtsFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 粉丝
 * @author huanglei
 */
@RestController
@RequestMapping("api/fans")
@Api("粉丝操作")
public class ApiFansController {

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private UtsFansService fansService;

    @Autowired
    UtsAuthorService utsAuthorService;

    @GetMapping("is")
    @ApiOperation("关注的作者列表")
    public ResponseResult<Integer> isFans(@RequestParam("username") String username){
        String authorId = currentAuthorService.getAuthor().getAuthorId();
        UtsAuthor utsAuthor = utsAuthorService.selectAuthorByName(username);
        if (utsAuthor != null){
            Integer count = fansService.isFans(authorId,utsAuthor.getAuthorId());
            return ResponseResult.success(count);
        }
        throw new ApiException();
    }

    @GetMapping("list")
    @ApiOperation("关注的作者列表")
    public ResponseResult<PageInfo<UtsFansDto>> fansList(){
        String authorId = currentAuthorService.getAuthor().getAuthorId();
        PageInfo<UtsFansDto> authorDtoPageInfo = fansService.selectFansList(authorId);
        return ResponseResult.success(authorDtoPageInfo);
    }

    @PostMapping("{fansName}")
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

    @DeleteMapping("{fansName}")
    @ApiOperation("删除关注")
    public ResponseResult<Integer> delete(@PathVariable("fansName") String fansName){
        String authorId = currentAuthorService.getAuthorId();

        int count = fansService.deleteFans(fansName,authorId);
        if (count > 0){
            return ResponseResult.success(count);
        }
        throw new ApiException(ResponseCode.FAILED);
    }
}
