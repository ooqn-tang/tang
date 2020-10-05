package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.api.CommonResult;
import net.ttcxy.tang.gateway.util.ImgProUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

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

    @Value("${my-file-static-path}")
    private String myFileStaticPath;

    @ApiOperation("文件上传")
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult upload(@RequestParam("file") MultipartFile file) throws IOException {

        String[] split = file.getOriginalFilename().split("\\.");
        if (split.length == 0){
            return CommonResult.failed();
        }

        if (ImgProUtil.isNotImage(file.getInputStream())){
            return CommonResult.failed("请上传正确文件");
        }


        String urlFileName = IdUtil.fastSimpleUUID() + "." + split[split.length - 1];
        String path = myFileDataPath + File.separator + urlFileName;



        try {
            FileUtil.writeBytes(file.getBytes(),path);
        } catch (IOException e) {
            return CommonResult.failed(e.getMessage());
        }
        return CommonResult.success( "/" + myFileStaticPath + "/" + urlFileName);
    }

    @ApiOperation("文件删除")
    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult delete(@RequestParam("objectName") String objectName) {
        return CommonResult.failed();
    }


    public static void main(String[] args) {


    }


}
