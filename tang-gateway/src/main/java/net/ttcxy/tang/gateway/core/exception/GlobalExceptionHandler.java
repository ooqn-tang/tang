package net.ttcxy.tang.gateway.core.exception;

import net.ttcxy.tang.gateway.core.api.ApiException;
import net.ttcxy.tang.gateway.core.api.ResponseResult;
import net.ttcxy.tang.gateway.core.verify.VerifyException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

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
    @ExceptionHandler(AccessDeniedException.class)
    public ResponseResult<?> errorHandler(AccessDeniedException ex) {
        logger.error(ex.getMessage(),ex);
        return ResponseResult.failed("AccessDeniedException");
    }

    @ResponseBody
    @ExceptionHandler(VerifyException.class)
    public ResponseResult<?> errorHandler(VerifyException ex) {
        logger.error(ex.getMessage());
        return ResponseResult.validateFailed(ex.getData());
    }

    /**
     * ApiException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(ApiException.class)
    public ResponseResult<?> errorHandler(ApiException ex) {
        logger.error(ex.getMessage(),ex);
        return ResponseResult.failed(ex.getMessage());
    }

    /**
     * ConstraintViolationException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResult<?> errorHandler(ConstraintViolationException ex) {
        logger.error(ex.getMessage(),ex);
        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        return ResponseResult.validateFailed(violations.iterator().next().getMessage());
    }

    /**
     * MethodArgumentNotValidException 参数校验统一异常处理
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseResult<?> errorHandler(MethodArgumentNotValidException ex) {
        logger.error(ex.getMessage(),ex);
        String str = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return ResponseResult.validateFailed(str);
    }
    /**
     * Exception 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseResult<?> errorHandler(Exception ex) {
        logger.error(ex.getMessage(),ex);
        return ResponseResult.failed("系统异常：" + ex.getMessage());
    }
}
