package cn.ttcxy.dao.dsl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.querydsl.jpa.impl.JPAQueryFactory;

import cn.ttcxy.entity.model.DtsClass;
import cn.ttcxy.entity.model.QDtsClass;

@Component
public class DtsClassDsl {

    @Autowired
    private JPAQueryFactory query;

    private final QDtsClass qDtsClass = QDtsClass.dtsClass;

    public List<DtsClass> selectClass(String type) {
        return query
                .select(qDtsClass)
                .from(qDtsClass)
                .where(
                        qDtsClass.type.eq(type))
                .fetch();
    }
}
