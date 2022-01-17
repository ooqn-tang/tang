package net.ttcxy.tang.portal.core.exception;

import cn.hutool.http.HttpStatus;
import net.ttcxy.tang.portal.core.api.ApiException;
import net.ttcxy.tang.portal.core.api.ResponseCode;
import net.ttcxy.tang.portal.core.api.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    public ResponseResult<?> errorHandler(AccessDeniedException ex, HttpServletResponse httpServletResponse) {
        logger.error(ex.getMessage(),ex);
        httpServletResponse.setStatus(HttpStatus.HTTP_BAD_REQUEST);
        return ResponseResult.validateFailed("ex.getMessage()");
    }

    /**
     * ApiException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(ApiException.class)
    public ResponseResult<?> errorHandler(ApiException ex, HttpServletResponse httpServletResponse) {
        logger.error(ex.getMessage(),ex);
        httpServletResponse.setStatus(ResponseCode.VALIDATE_FAILED.getCode());
        return ResponseResult.failed(ex.getMessage());
    }

    /**
     * ConstraintViolationException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseResult<?> errorHandler(ConstraintViolationException ex, HttpServletResponse httpServletResponse) {
        logger.error(ex.getMessage(),ex);
        httpServletResponse.setStatus(HttpStatus.HTTP_BAD_REQUEST);

        Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        return ResponseResult.validateFailed(violations.iterator().next().getMessage());
    }

    /**
     * MethodArgumentNotValidException 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseResult<?> errorHandler(MethodArgumentNotValidException ex, HttpServletResponse httpServletResponse) {
        logger.error(ex.getMessage(),ex);
        httpServletResponse.setStatus(HttpStatus.HTTP_BAD_REQUEST);
        String result = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
        return ResponseResult.validateFailed(result);
    }
    /**
     * Exception 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(Exception.class)
    public ResponseResult<?> errorHandler(Exception ex, HttpServletResponse httpServletResponse) {
        logger.error(ex.getMessage(),ex);
        httpServletResponse.setStatus(HttpStatus.HTTP_BAD_REQUEST);
        return ResponseResult.failed("系统异常");
    }
    /**
     * Exception 参数校验统一异常处理
     */
    @ResponseBody
    @ExceptionHandler(ServletException.class)
    public ResponseResult<?> errorHandler(ServletException ex, HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) {
        httpServletResponse.setStatus(HttpStatus.HTTP_BAD_REQUEST);
        return ResponseResult.failed(ex.getMessage());
    }

}
