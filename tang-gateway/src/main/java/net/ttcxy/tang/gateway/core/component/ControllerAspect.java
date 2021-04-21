package net.ttcxy.tang.gateway.core.component;

import net.ttcxy.tang.gateway.core.verify.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.*;

/**
 * 统一日志处理切面
 * @author huanglei
 */
@Aspect
@Component
@Order(1)
public class ControllerAspect {

    private Logger logger = LoggerFactory.getLogger(getClass());

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
        verify(joinPoint);
        return joinPoint.proceed();
    }

    void verify(ProceedingJoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature)signature;
        Method targetMethod = methodSignature.getMethod();

        if (targetMethod.getAnnotation(Create.class)  !=  null){
            for (Object arg : joinPoint.getArgs()) {
                if (arg instanceof VerifyEntity){
                    ((VerifyEntity) arg).createVerify();
                }
            }
        }
        if (targetMethod.getAnnotation(Delete.class)  !=  null){
            for (Object arg : joinPoint.getArgs()) {
                if (arg instanceof VerifyEntity){
                    ((VerifyEntity) arg).deleteVerify();
                }
            }
        }
        if (targetMethod.getAnnotation(Select.class)  !=  null){
            for (Object arg : joinPoint.getArgs()) {
                if (arg instanceof VerifyEntity){
                    ((VerifyEntity) arg).selectVerify();
                }
            }
        }
        if (targetMethod.getAnnotation(Update.class)  !=  null){
            for (Object arg : joinPoint.getArgs()) {
                if (arg instanceof VerifyEntity){
                    ((VerifyEntity) arg).updateVerify();
                }
            }
        }
    }
}
