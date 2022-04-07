package cn.ttcxy.controller;

import cn.ttcxy.entity.dto.CurrentAuthor;
import cn.ttcxy.service.DtsDanmakuService;
import com.alibaba.fastjson.JSONObject;
import cn.ttcxy.core.security.JwtProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/danmaku")
public class DtsDanmakuController extends BaseController {

    @Autowired
    private DtsDanmakuService danmakuService;

    @Autowired
    private JwtProvider jwtProvider;

    @GetMapping("v3")
    public ResponseEntity<?> select(@RequestParam(value = "id",defaultValue = "") String id){
        JSONObject object = danmakuService.select(id);
        return ResponseEntity.ok(object);
    }

    @PostMapping("v3")
    public JSONObject select(@RequestBody JSONObject json){
        String jwt = json.getString("token");
        if (StringUtils.hasText(jwt) && jwtProvider.validateToken(jwt)) {
            Authentication authentication = jwtProvider.getAuthentication(jwt);
            CurrentAuthor author = (CurrentAuthor) authentication.getPrincipal();
            json.put("authorId",author.getAuthor().getAuthorId());
            danmakuService.insert(json);
        }
        JSONObject object = new JSONObject();
        object.put("code","0");
        return object;
    }
}
