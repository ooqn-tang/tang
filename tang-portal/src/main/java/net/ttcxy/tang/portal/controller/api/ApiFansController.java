package net.ttcxy.tang.portal.controller.api;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.UtsFansDto;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.model.UtsFans;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import net.ttcxy.tang.portal.service.UtsFansService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * 粉丝
 *
 * @author huanglei
 */
@RestController
@RequestMapping("api/fans")
public class ApiFansController {


    @Autowired
    private UtsFansService fansService;

    @Autowired
    private UtsAuthorService utsAuthorService;

    @GetMapping("username/{username}")
    public ResponseEntity<Integer> selectByUsername(@PathVariable("username") String username) {
        String authorId = CurrentUtil.id();
        UtsAuthor utsAuthor = utsAuthorService.selectAuthorByName(username);
        if (utsAuthor != null) {
            Integer count = fansService.isFans(authorId, utsAuthor.getAuthorId());
            return ResponseEntity.ok(count);
        }
        throw new ApiException();
    }

    @GetMapping("list")
    public ResponseEntity<PageInfo<UtsFansDto>> selectList() {
        String authorId = CurrentUtil.id();
        PageInfo<UtsFansDto> authorDtoPageInfo = fansService.selectFansList(authorId);
        return ResponseEntity.ok(authorDtoPageInfo);
    }

    @PostMapping("{fansName}")
    public ResponseEntity<Integer> insert(@PathVariable("fansName") String fansName) {
        String authorId = CurrentUtil.id();

        UtsAuthor utsAuthor = utsAuthorService.selectAuthorByName(fansName);
        if (utsAuthor == null) {
            throw new ApiException(ResponseCode.VALIDATE_FAILED);
        }

        UtsFans fans = new UtsFans();
        fans.setAuthorId(authorId);
        fans.setBeAuthorId(utsAuthor.getAuthorId());
        int count = fansService.insertFans(fans);
        if (count > 0) {
            return ResponseEntity.ok(count);
        }
        throw new ApiException(ResponseCode.ACCEPTED);
    }

    @DeleteMapping("{fansName}")
    public ResponseEntity<Integer> delete(@PathVariable("fansName") String fansName) {
        String authorId = CurrentUtil.id();

        int count = fansService.deleteFans(fansName, authorId);
        if (count > 0) {
            return ResponseEntity.ok(count);
        }
        throw new ApiException(ResponseCode.ACCEPTED);
    }
}
