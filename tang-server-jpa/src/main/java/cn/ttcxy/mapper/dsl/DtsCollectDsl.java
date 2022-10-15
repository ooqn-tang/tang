package cn.ttcxy.mapper.dsl;

import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.dto.DtsDataDto;
import cn.ttcxy.entity.model.QDtsCollect;
import com.querydsl.core.types.Projections;
import com.querydsl.core.types.dsl.Wildcard;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 收藏
 */
@Component
public class DtsCollectDsl {

    @Autowired
    private JPAQueryFactory query;

    private final QDtsCollect qDtsCollect = QDtsCollect.dtsCollect;

    public List<DtsDataDto> selectCollect(String username) {
        return new ArrayList<>();
    }

}
