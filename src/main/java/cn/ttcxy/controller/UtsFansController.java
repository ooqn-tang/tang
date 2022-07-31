package cn.ttcxy.controller;

import cn.ttcxy.core.BaseController;
import cn.ttcxy.core.api.ApiException;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.entity.dto.UtsFansDto;
import cn.ttcxy.entity.model.UtsAuthor;
import cn.ttcxy.entity.model.UtsFans;
import cn.ttcxy.service.UtsAuthorService;
import cn.ttcxy.service.UtsFansService;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 粉丝
 */
@RestController
@RequestMapping("api/fans")
public class UtsFansController extends BaseController {

    @Autowired
    private UtsFansService fansService;

    @Autowired
    private UtsAuthorService authorService;

    @GetMapping("username/{username}")
    public Integer selectByUsername(@PathVariable("username") String username) {
        String authorId = authorId();
        UtsAuthor utsAuthor = authorService.selectAuthorByName(username);
        if (utsAuthor != null) {
            return fansService.isFans(authorId, utsAuthor.getAuthorId());
        }
        throw new ApiException();
    }

    @GetMapping("list")
    public PageInfo<UtsFansDto> selectList() {
        String authorId = authorId();
        return fansService.selectFansList(authorId);
    }

    @PostMapping("{fansName}")
    public Integer insert(@PathVariable("fansName") String fansName) {
        String authorId = authorId();

        UtsAuthor utsAuthor = authorService.selectAuthorByName(fansName);
        if (utsAuthor == null) {
            throw new ApiException(ResponseCode.VALIDATE_FAILED);
        }

        UtsFans fans = new UtsFans();
        fans.setAuthorId(authorId);
        fans.setBeAuthorId(utsAuthor.getAuthorId());
        int count = fansService.insertFans(fans);
        if (count > 0) {
            return count;
        }
        throw new ApiException();
    }

    @DeleteMapping("{fansName}")
    public Integer delete(@PathVariable("fansName") String fansName) {
        String authorId = authorId();

        int count = fansService.deleteFans(fansName, authorId);
        if (count > 0) {
            return count;
        }
        throw new ApiException();
    }
}
