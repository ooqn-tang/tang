package net.ttcxy.tang.portal.controller.api;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.UtsFansDto;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.model.UtsFans;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import net.ttcxy.tang.portal.service.UtsFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 粉丝
 * @author huanglei
 */
@RestController
@RequestMapping("api/fans")
public class ApiFansController {


    @Autowired
    private UtsFansService fansService;

    @Autowired
    UtsAuthorService utsAuthorService;

    @GetMapping("is")
    public ResponseResult<Integer> isFans(@RequestParam("username") String username){
        String authorId = CurrentUtil.id();
        UtsAuthor utsAuthor = utsAuthorService.selectAuthorByName(username);
        if (utsAuthor != null){
            Integer count = fansService.isFans(authorId,utsAuthor.getAuthorId());
            return ResponseResult.success(count);
        }
        throw new ApiException();
    }

    @GetMapping("list")
    public ResponseResult<PageInfo<UtsFansDto>> fansList(){
        String authorId = CurrentUtil.id();
        PageInfo<UtsFansDto> authorDtoPageInfo = fansService.selectFansList(authorId);
        return ResponseResult.success(authorDtoPageInfo);
    }

    @PostMapping("{fansName}")
    public ResponseResult<?> insert(@PathVariable("fansName") String fansName){
        String authorId = CurrentUtil.id();

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
    public ResponseResult<Integer> delete(@PathVariable("fansName") String fansName){
        String authorId = CurrentUtil.id();

        int count = fansService.deleteFans(fansName,authorId);
        if (count > 0){
            return ResponseResult.success(count);
        }
        throw new ApiException(ResponseCode.FAILED);
    }
}
