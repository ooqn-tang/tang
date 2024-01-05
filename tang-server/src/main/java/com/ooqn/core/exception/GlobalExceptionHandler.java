package com.ooqn.core.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;

/**
 * 全局异常处理
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

	private final Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * ApiException 参数校验统一异常处理
	 */
	@ExceptionHandler(ApiException.class)
	public ResponseEntity<String> errorHandler(ApiException ex,
			HttpServletResponse httpServletResponse) {
		logger.error(ex.getMessage());
		Map<String,String> map = new HashMap<>();
		map.put("message", ex.getMessage());
		return ResponseEntity.status(ex.getStatus()).body(String.format("{\"message\":\"%s\"}", ex.getMessage()));
	}

	/**
	 * ConstraintViolationException 参数校验统一异常处理
	 */
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> errorHandler(ConstraintViolationException ex,
			HttpServletResponse httpServletResponse) {
		Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
		return ResponseEntity.badRequest().body(violations.iterator().next().getMessage());
	}

	/**
	 * MethodArgumentNotValidException 参数校验统一异常处理
	 */
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<String> errorHandler(MethodArgumentNotValidException ex,
			HttpServletResponse httpServletResponse) {
		String result = ex.getBindingResult().getFieldErrors().get(0).getDefaultMessage();
		return ResponseEntity.badRequest().body(result);
	}

	/**
	 * Exception 参数校验统一异常处理
	 */
	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> errorHandler(Exception ex,
			HttpServletResponse httpServletResponse) {
		logger.error(ex.getMessage(), ex);
		return ResponseEntity.badRequest().body(ex.getMessage());
	}

	/**
	 * Exception 参数校验统一异常处理
	 */
	@ExceptionHandler(ServletException.class)
	public ResponseEntity<?> errorHandler(ServletException ex,
			HttpServletResponse httpServletResponse, HttpServletRequest httpServletRequest) {
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
	}

}
