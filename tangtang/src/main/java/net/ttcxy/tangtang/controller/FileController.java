package net.ttcxy.tangtang.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tangtang.api.CommonResult;
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


    //@Value("${tangtang.static.file}")
    private String TANGTANG_STATIC_FILE;

    //@Value("${tangtang.static.file-ame}")
    private String TANGTANG_STATIC_FILE_NAME;


    @ApiOperation("文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(@RequestParam("file") MultipartFile file) {

        //路径
        String fileHost = TANGTANG_STATIC_FILE + System.lineSeparator() + TANGTANG_STATIC_FILE_NAME + System.lineSeparator();

        String uuid = IdUtil.fastSimpleUUID();
        file.getOriginalFilename();



        return CommonResult.failed();
    }

    @ApiOperation("文件删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("objectName") String objectName) {

        return CommonResult.failed();
    }
}
