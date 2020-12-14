package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.util.ImgUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("file")
@Api("FileController")
public class StsFileController {



    @ApiOperation("文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<?> upload(@RequestParam("file") MultipartFile file) throws IOException {

        return null;
    }

    @ApiOperation("文件删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<?> delete(@RequestParam("objectName") String objectName) {
        return ResponseResult.failed();
    }

}
