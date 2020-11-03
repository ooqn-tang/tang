package net.ttcxy.tang.gateway.code.exception;

import net.ttcxy.tang.api.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ValidationException;

/**
 * 全局异常处理
 * @author huanglei
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult<String> handle(ApiException e) {
        if (e.getErrorCode() != null) {
            return CommonResult.failed(e.getErrorCode());
        }
        return CommonResult.failed(e.getMessage());
    }

    /**
     * 参数校验统一异常处理
     */
    @ExceptionHandler(ValidationException.class)
    @ResponseBody
    public CommonResult<?> validateErrorHandler(ValidationException e) {
        return CommonResult.failed(e.getMessage());
    }

    /**
     * 参数校验统一异常处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseBody
    public CommonResult<?> validateErrorHandler(MethodArgumentNotValidException e) {
        ObjectError error = e.getBindingResult().getAllErrors().get(0);
        return CommonResult.failed(error.getDefaultMessage());
    }

    /**
     * 参数校验统一异常处理
     */
    @ExceptionHandler(BindException.class)
    @ResponseBody
    public CommonResult<String> validateErrorHandler(BindException e) {
        ObjectError error = e.getAllErrors().get(0);
        return CommonResult.failed(error.getDefaultMessage());
    }

    /**
     * 参数校验统一异常处理
     */
    @ExceptionHandler(Throwable.class)
    @ResponseBody
    public CommonResult<String> validateErrorHandler(Throwable e) {
        System.out.println("Error : " + e.getClass().getName());

        return CommonResult.failed(e.getMessage());
    }

    //ConstraintViolationException


}
