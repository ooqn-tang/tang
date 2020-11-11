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
public class FileController {


    /**
     * 文件存储 位置
     */
    @Value("${my-file-data-path}")
    private String myFileDataPath;

    @Value("${my-file-static-path}")
    private String myFileStaticPath;

    @ApiOperation("文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<?> upload(@RequestParam("file") MultipartFile file) throws IOException {

        String[] split = file.getOriginalFilename().split("\\.");
        if (split.length == 0){
            return ResponseResult.failed();
        }

        if (ImgUtil.isNotImage(file.getInputStream())){
            return ResponseResult.failed("请上传正确文件");
        }

        String urlFileName = IdUtil.fastSimpleUUID() + "." + split[split.length - 1];
        String path = myFileDataPath + File.separator + urlFileName;

        try {
            FileUtil.writeBytes(file.getBytes(),path);
        } catch (IOException e) {
            return ResponseResult.failed(e.getMessage());
        }
        return ResponseResult.success( "/" + myFileStaticPath + "/" + urlFileName);
    }

    @ApiOperation("文件删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public ResponseResult<?> delete(@RequestParam("objectName") String objectName) {
        return ResponseResult.failed();
    }

}
