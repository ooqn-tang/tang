package net.ttcxy.tang.portal.controller.api;

import net.ttcxy.tang.portal.core.api.ResponseResult;
import net.ttcxy.tang.portal.entity.model.DtsAdvertise;
import net.ttcxy.tang.portal.service.StsAdvertiseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("api/advertise")
public class ApiAdvertiseController {

    @Autowired
    private StsAdvertiseService advertiseService;

    @GetMapping("list")
    public ResponseResult<List<DtsAdvertise>> loadAdv(){
        return ResponseResult.success(advertiseService.selectAllAdvertise());
    }
}
