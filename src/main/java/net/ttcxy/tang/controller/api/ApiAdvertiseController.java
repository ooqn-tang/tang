package net.ttcxy.tang.controller.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.core.api.ResponseResult;
import net.ttcxy.tang.entity.model.DtsAdvertise;
import net.ttcxy.tang.service.StsAdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/advertise")
@Api("广告")
public class ApiAdvertiseController {

    @Autowired
    private StsAdvertiseService advertiseService;

    @GetMapping("list")
    @ApiOperation("记载")
    public ResponseResult<List<DtsAdvertise>> loadAdv(){
        return ResponseResult.success(advertiseService.selectAllAdvertise());
    }
}
