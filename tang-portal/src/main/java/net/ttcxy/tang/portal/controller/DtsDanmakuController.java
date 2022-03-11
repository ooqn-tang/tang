package net.ttcxy.tang.portal.controller;

import com.alibaba.fastjson.JSONObject;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.security.jwt.TokenProvider;
import net.ttcxy.tang.portal.entity.dto.CurrentAuthor;
import net.ttcxy.tang.portal.service.DtsDanmakuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/danmaku")
public class DtsDanmakuController {

    @Autowired
    private DtsDanmakuService danmakuService;

    @GetMapping("v3")
    public ResponseEntity<?> select(@RequestParam(value = "id",defaultValue = "") String id){
        JSONObject object = danmakuService.select(id);
        return ResponseEntity.ok(object);
    }

    @Autowired
    private TokenProvider tokenProvider;

    @PostMapping("v3")
    public void select(@RequestBody JSONObject json){
        String jwt = json.getString("token");
        if (StringUtils.hasText(jwt) && tokenProvider.validateToken(jwt)) {
            Authentication authentication = tokenProvider.getAuthentication(jwt);
            CurrentAuthor author = (CurrentAuthor) authentication.getPrincipal();
            json.put("authorId",author.getUtsAuthor().getAuthorId());
            danmakuService.insert(json);
        }
    }
}
