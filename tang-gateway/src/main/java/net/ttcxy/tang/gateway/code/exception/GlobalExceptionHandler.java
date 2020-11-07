package net.ttcxy.tang.gateway.code.exception;

import cn.hutool.core.collection.CollUtil;
import net.ttcxy.tang.api.CommonResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.ValidationException;
import java.util.Map;
import java.util.Set;

/**
 * 全局异常处理
 * @author huanglei
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * Exception 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public CommonResult<?> errorHandler(Exception ex) {
        logger.error(ex.getMessage(),ex);
        return CommonResult.failed("系统异常");
    }

    /**
     * ApiException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public CommonResult<?> errorHandler(ApiException ex) {
        logger.error(ex.getMessage(),ex);
        return CommonResult.failed(ex.getMessage());
    }

    /**
     * ApiException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public CommonResult<?> errorHandler(ConstraintViolationException ex) {
        logger.error(ex.getMessage(),ex);
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> item : violations) {
            return CommonResult.failed(item.getMessage());
        }
        return CommonResult.failed("未知异常");
    }

    /**
     * MethodArgumentNotValidException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public CommonResult<?> errorHandler(MethodArgumentNotValidException ex) {
        logger.error(ex.getMessage(),ex);
        BindingResult bindingResult = ex.getBindingResult();
        if(CollUtil.isNotEmpty(bindingResult.getFieldErrors())){
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                return CommonResult.failed(fieldError.getDefaultMessage());
            }
        }

        return CommonResult.failed("未知异常");
    }
}
