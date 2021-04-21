package net.ttcxy.tang.gateway.core.component;

import cn.hutool.core.annotation.AnnotationUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.core.util.URLUtil;
import cn.hutool.json.JSONUtil;
import io.swagger.annotations.ApiOperation;
import net.ttcxy.tang.gateway.core.verify.Update;
import net.ttcxy.tang.gateway.core.verify.Verify;
import net.ttcxy.tang.gateway.core.verify.VerifyEntity;
import net.ttcxy.tang.gateway.entity.dto.StsWebLogDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.aspectj.MethodInvocationProceedingJoinPoint;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import springfox.documentation.spring.web.plugins.SpringIntegrationPluginNotPresentInClassPathCondition;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
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
    public void webLog() {
    }

    @Before("webLog()")
    public void doBefore(JoinPoint joinPoint) {
    }

    @AfterReturning(value = "webLog()", returning = "ret")
    public void doAfterReturning(Object ret) {
    }

    @Around("webLog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        for (Object arg : joinPoint.getArgs()) {
            for (Method method : arg.getClass().getMethods()) {
                Parameter[] parameters = method.getParameters();
                for (Parameter parameter : parameters) {
                    Update annotation = parameter.getAnnotation(Update.class);
                    if (annotation != null){
                        System.out.println(arg);
                    }
                }
            }
        }
        return joinPoint.proceed();
    }

    /**
     * 根据方法和传入的参数获取请求参数
     */
    private Object getParameter(Method method, Object[] args) {
        List<Object> argList = new ArrayList<>();
        Parameter[] parameters = method.getParameters();
        for (int i = 0; i < parameters.length; i++) {
            //将RequestBody注解修饰的参数作为请求参数
            RequestBody requestBody = parameters[i].getAnnotation(RequestBody.class);
            if (requestBody != null) {
                argList.add(args[i]);
            }
            //将RequestParam注解修饰的参数作为请求参数
            RequestParam requestParam = parameters[i].getAnnotation(RequestParam.class);
            if (requestParam != null) {
                Map<String, Object> map = new HashMap<>();
                String key = parameters[i].getName();
                if (!StringUtils.isEmpty(requestParam.value())) {
                    key = requestParam.value();
                }
                map.put(key, args[i]);
                argList.add(map);
            }
        }
        if (argList.size() == 0) {
            return null;
        } else if (argList.size() == 1) {
            return argList.get(0);
        } else {
            return argList;
        }
    }
}
