package net.ttcxy.tang.gateway.core.exception;

import net.ttcxy.tang.gateway.core.api.ApiException;
import net.ttcxy.tang.gateway.core.api.ResponseCode;
import net.ttcxy.tang.gateway.core.api.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Set;

import static net.ttcxy.tang.gateway.core.api.ResponseCode.FAILED;
import static net.ttcxy.tang.gateway.core.api.ResponseCode.VALIDATE_FAILED;

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
    public ResponseResult<?> errorHandler(AccessDeniedException ex, HttpServletResponse httpServletResponse) {
        logger.error(ex.getMessage(),ex);
        return ResponseResult.failed(VALIDATE_FAILED,"ex.getMessage()");
    }

    /**
     * ApiException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(ApiException.class)
    public ResponseResult<?> errorHandler(ApiException ex, HttpServletResponse httpServletResponse) {
        logger.error(ex.getMessage(),ex);
        httpServletResponse.setStatus(VALIDATE_FAILED.getCode());
        return ResponseResult.failed(ex.getMessage());
    }

    /**
     * ConstraintViolationException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResult<?> errorHandler(ConstraintViolationException ex, HttpServletResponse httpServletResponse) {
        logger.error(ex.getMessage(),ex);
        httpServletResponse.setStatus(VALIDATE_FAILED.getCode());

        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        return ResponseResult.failed(VALIDATE_FAILED, violations.iterator().next().getMessage());
    }

    /**
     * MethodArgumentNotValidException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult<?> errorHandler(MethodArgumentNotValidException ex, HttpServletResponse httpServletResponse) {
        logger.error(ex.getMessage(),ex);
        String result = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return ResponseResult.failed(VALIDATE_FAILED, result);
    }
    /**
     * Exception 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseResult<?> errorHandler(Exception ex, HttpServletResponse httpServletResponse) {
        logger.error(ex.getMessage(),ex);
        return ResponseResult.failed(FAILED,"系统异常");
    }
}
