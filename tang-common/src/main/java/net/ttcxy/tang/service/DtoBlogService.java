package net.ttcxy.tang.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.entity.dto.DtsBlogDto;
import net.ttcxy.tang.entity.model.DtsBlog;
import net.ttcxy.tang.entity.param.DtsBlogParam;

import java.util.List;

/**
 * @author huanglei
 */
public interface DtoBlogService {
    int insert(DtsBlog blog);

    int delete(String id);

    int update(DtsBlog blog);

    PageInfo<List<DtsBlogDto>> query(DtsBlogParam blogParam);
}
