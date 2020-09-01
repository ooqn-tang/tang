package net.ttcxy.tang.controller;

import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.CommonResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author ：HuangLei
 * @date ：2020/4/16 0016 19:53
 */
@RestController
@RequestMapping("file")
public class FileController {


    /**
     * 文件存储 位置
     */
    @Value("${my-file-data-path}")
    private String myFileDataPath;


    @ApiOperation("文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(@RequestParam("file") MultipartFile file) {
        return CommonResult.failed();
    }

    @ApiOperation("文件删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("objectName") String objectName) {
        return CommonResult.failed();
    }
}
