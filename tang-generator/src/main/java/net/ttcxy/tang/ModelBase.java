package net.ttcxy.tang;

import cn.hutool.core.bean.BeanDesc;
import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ClassUtil;

import java.lang.reflect.ParameterizedType;

/**
 * @author huanglei
 */
public interface ModelBase<T> {
    default T getClone(T t) {
        BeanUtil.copyProperties(this,t);
        return t;
    }
}
