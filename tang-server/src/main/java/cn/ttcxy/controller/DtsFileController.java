package cn.ttcxy.controller;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import cn.ttcxy.core.api.ResponseCode;
import cn.ttcxy.core.exception.ApiException;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Optional;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.catalina.connector.ClientAbortException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/file")
public class DtsFileController extends BaseController {

  @Value("${tang-file}")
  private String tangFile;

  @PostMapping("/upload")
  public String create(
    @RequestParam("file") MultipartFile file,
    @RequestParam("type") String type
  )
    throws IOException {
    String fileName = Optional
      .ofNullable(file.getOriginalFilename())
      .orElseThrow();

    String[] split = fileName.split("\\.");
    if (split.length < 2) {
      throw new ApiException(ResponseCode.VALIDATE_FAILED);
    }
    String s = split[split.length - 1];
    String objectId = IdUtil.objectId();
    File dest = new File(tangFile + File.separator + objectId + "." + s);
    Files.copy(file.getInputStream(), dest.toPath());

    if (StrUtil.equals(type, "1")) {
      BufferedImage sourceImg = ImageIO.read(
        new FileInputStream(tangFile + File.separator + objectId + "." + s)
      );
      if (sourceImg == null) {
        throw new ApiException(
          ResponseCode.FAILED.getStatus(),
          "请上传PNG格式"
        );
      }
      System.out.println(sourceImg.getWidth()); // 源图宽度
      System.out.println(sourceImg.getHeight()); // 源图高度
      double i = (sourceImg.getWidth() + 0.0) / sourceImg.getHeight();
      if (i == 2) {
        return objectId + "." + s;
      } else {
        throw new ApiException(
          ResponseCode.FAILED.getStatus(),
          "图片尺寸必须为2：1"
        );
      }
    }
    if (StrUtil.equals(type, "2")) {
      return objectId + "." + s;
    }
    throw new ApiException();
  }

  @GetMapping("{fileName}")
  public void create(
    @PathVariable("fileName") String fileName,
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws IOException {
    try {
      //清空缓存
      response.reset();
      //获取响应的输出流
      OutputStream outputStream = response.getOutputStream();
      File file = new File(tangFile + File.separator + fileName);
      if (file.exists()) {
        //创建随机读取文件对象
        try (RandomAccessFile targetFile = new RandomAccessFile(file, "r")) {
          long fileLength = file.length();
          //获取从那个字节开始读取文件
          String rangeString = request.getHeader("Range");
          if (rangeString != null) { //如果rangeString不为空，证明是播放视频发来的请求
            long range = Long.parseLong(
              rangeString.substring(
                rangeString.indexOf("=") + 1,
                rangeString.indexOf("-")
              )
            );
            //设置内容类型
            response.setHeader("Content-Type", "img/png");
            //设置此次相应返回的数据长度
            response.setHeader(
              "Content-Length",
              String.valueOf(fileLength - range)
            );
            //设置此次相应返回的数据范围
            response.setHeader(
              "Content-Range",
              "bytes " + range + "-" + (fileLength - 1) + "/" + fileLength
            );
            //返回码需要为206，而不是200
            response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
            //设定文件读取开始位置（以字节为单位）
            targetFile.seek(range);
          } else {
            //设置响应头，把文件名字设置好
            response.setHeader(
              "Content-Disposition",
              "attachment; filename=caiwei.mp4"
            );
            //设置文件长度
            response.setHeader("Content-Length", String.valueOf(fileLength));
            //解决编码问题
            response.setHeader("Content-Type", "application/octet-stream");
          }
          byte[] cache = new byte[1024 * 300];
          int flag;
          while ((flag = targetFile.read(cache)) != -1) {
            try {
              outputStream.write(cache, 0, flag);
            } catch (ClientAbortException ignored) {}
          }
        }
      } else {
        String message = "file:" + fileName + " not exists";
        //解决编码问题
        response.setHeader("Content-Type", "application/json");
        outputStream.write(message.getBytes(StandardCharsets.UTF_8));
      }
      outputStream.flush();
      outputStream.close();
    } catch (Exception ignored) {}
  }

  public static String downloadFile(
    HttpServletResponse response,
    String fileName
  ) {
    response.setContentType("video/mp4");
    byte[] buff = new byte[1024];
    BufferedInputStream bis = null;
    OutputStream os;
    try {
      os = response.getOutputStream();
      bis =
        new BufferedInputStream(new FileInputStream("D:\\obj\\" + fileName));
      int i = bis.read(buff);
      while (i != -1) {
        os.write(buff, 0, buff.length);
        os.flush();
        i = bis.read(buff);
      }
    } catch (FileNotFoundException e1) {
      return "系统找不到指定的文件";
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (bis != null) {
        try {
          bis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
    return "success";
  }

  @GetMapping("download/{fileName}")
  public void download(
    @PathVariable("fileName") String fileName,
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws IOException {
    try {
      //获取响应的输出流
      OutputStream outputStream = response.getOutputStream();
      //设置内容类型
      response.setHeader("Content-Type", "img/png");
      //返回码需要为206，而不是200
      response.setStatus(HttpServletResponse.SC_PARTIAL_CONTENT);
      byte[] qrCodeImage = getQRCodeImage("12121212", 100, 100);
      outputStream.write(
        getQRCodeImage("12121212", 100, 100),
        0,
        qrCodeImage.length
      );
      outputStream.flush();
      outputStream.close();
    } catch (Exception ignored) {}
  }

  /**
   * 生成二维码，返回字节流
   *
   * @param text   二维码需要包含的信息
   * @param width  二维码宽度
   * @param height 二维码高度
   */
  public static byte[] getQRCodeImage(String text, int width, int height)
    throws WriterException, IOException {
    QRCodeWriter qrCodeWriter = new QRCodeWriter();
    BitMatrix bitMatrix = qrCodeWriter.encode(
      text,
      BarcodeFormat.QR_CODE,
      width,
      height
    );
    ByteArrayOutputStream pngOutputStream = new ByteArrayOutputStream();
    MatrixToImageWriter.writeToStream(bitMatrix, "PNG", pngOutputStream);
    return pngOutputStream.toByteArray();
  }
}
