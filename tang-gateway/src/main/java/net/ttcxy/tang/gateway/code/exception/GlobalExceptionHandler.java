package net.ttcxy.tang.gateway.code.exception;

import cn.hutool.core.collection.CollUtil;
import net.ttcxy.tang.api.ResponseResult;
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
    public ResponseResult<?> errorHandler(Exception ex) {
        logger.error(ex.getMessage(),ex);
        return ResponseResult.failed("系统异常");
    }

    /**
     * ApiException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = ApiException.class)
    public ResponseResult<?> errorHandler(ApiException ex) {
        logger.error(ex.getMessage(),ex);
        return ResponseResult.failed(ex.getMessage());
    }

    /**
     * ApiException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseResult<?> errorHandler(ConstraintViolationException ex) {
        logger.error(ex.getMessage(),ex);
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        for (ConstraintViolation<?> item : violations) {
            return ResponseResult.validateFailed(item.getMessage());
        }
        return ResponseResult.validateFailed("验证异常");
    }

    /**
     * MethodArgumentNotValidException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult<?> errorHandler(MethodArgumentNotValidException ex) {
        logger.error(ex.getMessage(),ex);
        BindingResult bindingResult = ex.getBindingResult();
        if(CollUtil.isNotEmpty(bindingResult.getFieldErrors())){
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                return ResponseResult.validateFailed(fieldError.getDefaultMessage());
            }
        }
        return ResponseResult.validateFailed("验证异常");
    }
}
