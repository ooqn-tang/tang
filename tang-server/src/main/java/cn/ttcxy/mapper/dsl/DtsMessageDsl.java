package cn.ttcxy.mapper.dsl;

import cn.ttcxy.entity.dto.DtsMessageDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 动态
 */
@Component
public class DtsMessageDsl {

    public List<DtsMessageDto> selectAuthorMessage(String authorId) {
        return new ArrayList<>();
    }

}
