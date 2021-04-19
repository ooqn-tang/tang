package net.ttcxy.tang.gateway.code.exception;

import net.ttcxy.tang.gateway.api.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestHandler;
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
     * AccessDeniedException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = AccessDeniedException.class)
    public ResponseResult<?> errorHandler(AccessDeniedException ex, HttpRequestHandler httpRequestHandler) {
        logger.error(ex.getMessage(),ex);
        return ResponseResult.failed("系统异常");
    }


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
     * ConstraintViolationException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = ConstraintViolationException.class)
    public ResponseResult<?> errorHandler(ConstraintViolationException ex) {
        logger.error(ex.getMessage(),ex);
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        return ResponseResult.validateFailed(violations.iterator().next().getMessage());
    }

    /**
     * MethodArgumentNotValidException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public ResponseResult<?> errorHandler(MethodArgumentNotValidException ex) {
        logger.error(ex.getMessage(),ex);
        String str = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return ResponseResult.validateFailed(str);
    }
}
