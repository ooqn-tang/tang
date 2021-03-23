package net.ttcxy.tang.admin.controller;

import net.ttcxy.tang.admin.entity.dto.UtsMemberDto;
import net.ttcxy.tang.admin.service.UtsMemberService;
import net.ttcxy.tang.api.ResponseResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("member")
public class UtsMemberController {

    @PostMapping
    @ResponseBody
    public String memberList(@RequestBody Map<String,String> map){
        return "map:" + map;
    }

    @Autowired
    private UtsMemberService utsMemberService;

    @PostMapping("list")
    public ResponseResult<List<UtsMemberDto>> memberList(){
        List<UtsMemberDto> utsMembers = utsMemberService.memberListDto(100);
        return ResponseResult.success(utsMembers);
    }
}
