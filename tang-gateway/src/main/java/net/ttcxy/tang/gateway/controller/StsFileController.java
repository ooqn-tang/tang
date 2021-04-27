package net.ttcxy.tang.gateway.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.core.api.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("file")
@Api("文件")
public class StsFileController {


    @Value("${my-file-data}")
    private String myFileData;


    @ApiOperation("文件上传")
    @RequestMapping(value = "/up-token", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<?> upToken() {
        return ResponseResult.success("map");
    }

}
