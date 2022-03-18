package cn.ttcxy.core.security;

import cn.ttcxy.mapper.dao.UtsResourceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;

public class MyFilterInvocationSecurityMetadataSource implements FilterInvocationSecurityMetadataSource {

    @Autowired
    private UtsResourceDao utsResourceDao;

    /**
     * 资源权限
     */
    private volatile HashMap<String, Collection<ConfigAttribute>> urlPermMap = null;

    @PostConstruct
    public void init() {
        loadResourceDefine();
    }

    /**
     * 加载资源，初始化资源变量
     */
    public void loadResourceDefine() {
        urlPermMap = new HashMap<>();

    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        FilterInvocation fi = (FilterInvocation) object;
        String url = fi.getRequestUrl();

        // 资源权限为空，初始化资源
        if (null == urlPermMap) {
            synchronized (MyFilterInvocationSecurityMetadataSource.class) {
                if (null == urlPermMap) {
                    loadResourceDefine();
                }
            }
        }

        return urlPermMap.get(url);
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
