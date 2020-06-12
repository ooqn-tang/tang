package net.ttcxy.tang.controller.api;

import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Token 登陆方式
 * @author login
 */
@Controller
@RequestMapping("api/login")
@Api(value = "ApiLoginController",description = "Token 登陆方式")
public class ApiLoginController {

    // todo 获取token
}
