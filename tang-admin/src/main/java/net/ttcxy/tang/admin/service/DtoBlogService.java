package net.ttcxy.tang.admin.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.admin.entity.dto.DtsBlogDto;
import net.ttcxy.tang.admin.entity.param.DtsBlogParam;
import net.ttcxy.tang.model.DtsBlog;

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
