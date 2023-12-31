package com.ooqn.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.method.RequestMappingInfo;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.ooqn.core.config.TangConfig;
import com.ooqn.core.security.NotLogin;

import cn.hutool.core.io.IoUtil;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@Service
public class StsInitService {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    private RequestMappingHandlerMapping requestMappingHandlerMapping;

    @Transactional
    public void init() {
        whiteUrlLoad();
        initData();
    }

    /**
     * 数据初始化
     */
    private void initData() {
        try {
            Object singleResult = entityManager.createNativeQuery("select count(1) from uts_author").getSingleResult();
            if (singleResult != null && Integer.parseInt(singleResult.toString()) == 0) {
                executeSqlFile("import-data.sql");
            }
        } catch (Exception e) {
            // 处理异常
            e.printStackTrace();
        }
    }

    private void executeSqlFile(String filename) {
        try {
            Resource resource = new ClassPathResource(filename);
            byte[] bytes = IoUtil.readBytes(resource.getInputStream());
            String sql = new String(bytes);
            jdbcTemplate.execute(sql);
        } catch (Exception e) {
            // 处理异常
            e.printStackTrace();
        }
    }

    /**
     * 加载不需要进行连接的资源
     */
    private void whiteUrlLoad() {
        Map<RequestMappingInfo, HandlerMethod> methodMap = requestMappingHandlerMapping.getHandlerMethods();
        for (RequestMappingInfo info : methodMap.keySet()) {
            for (String patternValues : info.getPatternValues()) {
                String path = patternValues.replaceAll("\\{[^}]*\\}", "*");
                for (RequestMethod method : info.getMethodsCondition().getMethods()) {
                    HandlerMethod handlerMethod = methodMap.get(info);
                    if (handlerMethod.getMethod().isAnnotationPresent(NotLogin.class)) {
                        Map<String, String> map = new HashMap<>();
                        map.put("method", method.name());
                        map.put("path", path);
                        TangConfig.whiteUrl.add(map);
                    }
                }
            }
        }
    }
}
