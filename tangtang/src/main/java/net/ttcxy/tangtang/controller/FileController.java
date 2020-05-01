package net.ttcxy.tangtang.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：HuangLei
 * @date ：2020/4/16 0016 19:53
 */
@Controller
public class FileController {

    @GetMapping("md")
    public String toMd(){
        return "/page/md";
    }

    //@Value("${uploadFile}")
    private String uploadFile;


    @PostMapping("image/upload.do")
    @ResponseBody
    public JSONObject imageUpload(@RequestParam(value = "editormd-image-file") MultipartFile file, HttpServletResponse response){
        System.out.println(file.getName());
        response.setHeader("X-Frame-Options", "SAMEORIGIN");

        JSONObject res = new JSONObject();

        String imageHost = "/images/"+ IdUtil.fastSimpleUUID() + ".png";

        String imagePath = uploadFile + imageHost;



        try {
            FileUtil.writeFromStream(file.getInputStream(),imagePath);
        } catch (IOException e) {
            e.printStackTrace();
        }

        res.put("url", imageHost);
        res.put("success", 1);
        res.put("message", "upload success!");
        return res;
    }



}
