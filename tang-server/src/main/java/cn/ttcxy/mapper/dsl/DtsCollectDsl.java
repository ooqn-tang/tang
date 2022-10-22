package cn.ttcxy.mapper.dsl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import cn.ttcxy.entity.dto.DtsDataDto;

/**
 * 收藏
 */
@Component
public class DtsCollectDsl {

    public List<DtsDataDto> selectCollect(String username) {
        return new ArrayList<>();
    }

}
