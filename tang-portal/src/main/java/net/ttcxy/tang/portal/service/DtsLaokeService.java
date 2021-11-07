package net.ttcxy.tang.portal.service;

import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.entity.dto.DtsLaokeDto;
import net.ttcxy.tang.portal.entity.model.DtsLaoke;

import java.util.List;

public interface DtsLaokeService {

    Integer insert(DtsLaoke laoke);

    Integer delete(String id);

    PageInfo<List<DtsLaokeDto>> loadList(Integer page,Integer pageSize);
}
