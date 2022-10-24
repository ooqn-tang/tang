package cn.ttcxy.core.exception;

import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 */
@ControllerAdvice
public class GlobalExceptionHandler {

  private final Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * AccessDeniedException 参数校验统一异常处理
   */
  @ResponseBody
  @ExceptionHandler(AccessDeniedException.class)
  public ResponseEntity<String> errorHandler(
    AccessDeniedException ex,
    HttpServletResponse httpServletResponse
  ) {
    logger.error(ex.getMessage(), ex);
    return ResponseEntity.badRequest().body(ex.getMessage());
  }

  /**
   * ApiException 参数校验统一异常处理
   */
  @ResponseBody
  @ExceptionHandler(ApiException.class)
  public ResponseEntity<String> errorHandler(
    ApiException ex,
    HttpServletResponse httpServletResponse
  ) {
    logger.error(ex.getMessage(), ex);
    return ResponseEntity.status(ex.getStatus()).body(ex.getMessage());
  }

  /**
   * ConstraintViolationException 参数校验统一异常处理
   */
  @ResponseBody
  @ExceptionHandler(ConstraintViolationException.class)
  public ResponseEntity<String> errorHandler(
    ConstraintViolationException ex,
    HttpServletResponse httpServletResponse
  ) {
    Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
    return ResponseEntity
      .badRequest()
      .body(violations.iterator().next().getMessage());
  }

  /**
   * MethodArgumentNotValidException 参数校验统一异常处理
   */
  @ResponseBody
  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> errorHandler(
    MethodArgumentNotValidException ex,
    HttpServletResponse httpServletResponse
  ) {
    String result = ex
      .getBindingResult()
      .getFieldErrors()
      .get(0)
      .getDefaultMessage();
    return ResponseEntity.badRequest().body(result);
  }

  /**
   * Exception 参数校验统一异常处理
   */
  @ResponseBody
  @ExceptionHandler(Exception.class)
  public ResponseEntity<String> errorHandler(
    Exception ex,
    HttpServletResponse httpServletResponse
  ) {
    logger.error(ex.getMessage(), ex);
    return ResponseEntity.badRequest().body(ex.getMessage());
  }

  /**
   * Exception 参数校验统一异常处理
   */
  @ResponseBody
  @ExceptionHandler(ServletException.class)
  public ResponseEntity<?> errorHandler(
    ServletException ex,
    HttpServletResponse httpServletResponse,
    HttpServletRequest httpServletRequest
  ) {
    return ResponseEntity
      .status(HttpStatus.INTERNAL_SERVER_ERROR)
      .body(ex.getMessage());
  }
}
