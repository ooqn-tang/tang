package net.ttcxy.tang.portal.controller.api;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.file.Files;

@RestController
@RequestMapping("api/file")
public class ApiFileController {

    @PostMapping("/upload")
    public ResponseEntity<String> create(@RequestParam("file") MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        if (StrUtil.isBlank(fileName)){
            throw new ApiException(ResponseCode.VALIDATE_FAILED);
        }
        String[] split = fileName.split("\\.");
        if (split.length < 2){
            throw new ApiException(ResponseCode.VALIDATE_FAILED);
        }
        String s = split[split.length - 1];
        String objectId = IdUtil.objectId();
        String filePath = "D:\\obj\\" + objectId +"."+s;
        File dest = new File(filePath);
        Files.copy(file.getInputStream(), dest.toPath());
        return ResponseEntity.ok(objectId + "."+s);
    }

    @GetMapping("{fileName}")
    public void create(@PathVariable("fileName") String fileName, HttpServletResponse response) throws IOException {
        downloadFile(response, fileName);
    }

    public static String downloadFile(HttpServletResponse response, String fileName) {
        response.setContentType("video/mp4");
        byte[] buff =new byte[1024];
        BufferedInputStream bis =null;
        OutputStream os;
        try {
            os = response.getOutputStream();
            bis =new BufferedInputStream(new FileInputStream(new File("D:\\obj\\" + fileName)));
            int i = bis.read(buff);
            while (i != -1) {
                os.write(buff,0, buff.length);
                os.flush();
                i = bis.read(buff);
            }
        }catch (FileNotFoundException e1) {
            return "系统找不到指定的文件";
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (bis !=null) {
                try {
                    bis.close();
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return "success";
    }

}
