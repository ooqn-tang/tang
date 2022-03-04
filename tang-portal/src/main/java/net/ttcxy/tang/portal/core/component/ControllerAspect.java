package net.ttcxy.tang.portal.core.component;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * 统一日志处理切面
 * @author LYJ
 */
@Aspect
@Component
@Order(1)
public class ControllerAspect {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Pointcut("execution(public * net.ttcxy.tang.gateway.controller.*.*(..))")
    public void node() {
    }

    @Before("node()")
    public void doBefore(JoinPoint joinPoint) {
    }

    @AfterReturning(value = "node()", returning = "ret")
    public void doAfterReturning(Object ret) {
    }

    @Around("node()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        return joinPoint.proceed();
    }
}
