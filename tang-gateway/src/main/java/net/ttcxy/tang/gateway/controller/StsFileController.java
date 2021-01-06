package net.ttcxy.tang.gateway.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.qiniu.util.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.api.ResponseResult;
import net.ttcxy.tang.util.ImgUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("file")
@Api("FileController")
public class StsFileController {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;

    @Value("${qiniu.bucket}")
    private String bucket;

    @ApiOperation("文件上传")
    @RequestMapping(value = "/up-token", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<?> upToken() {

        Auth auth = Auth.create(accessKey, secretKey);
        String uuid = IdUtil.fastSimpleUUID();
        String upToken = auth.uploadToken(bucket,uuid);

        Map<String,String> map = new HashMap<>();
        map.put("upToken",upToken);
        map.put("key",uuid);
        map.put("dz","https://obj.ttcxy.net/");
        return ResponseResult.success(map);
    }

    public static void main(String[] args) {
        String accessKey = "M6qf3dVX9P5RY1fQWnFItPjw7q8ExvUhFmGRgyHq";
        String secretKey = "EoiEXLXG_GwLox4TA0W28bVCj3tXkZwT7Le_LK1z";
        String bucket = "sdalsdsdf";
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket,"");
        System.out.println(upToken);
    }
}
