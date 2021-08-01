package net.ttcxy.tang.portal.controller.api;

import net.ttcxy.tang.portal.core.api.ResponseResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huanglei
 */
@RestController
@RequestMapping("api/file")
public class ApiFileController {


    @Value("${my-file-data}")
    private String myFileData;

    @RequestMapping(value = "/upload", method = RequestMethod.GET)
    @ResponseBody
    public ResponseResult<?> upload() {
        return ResponseResult.success("map");
    }

}
