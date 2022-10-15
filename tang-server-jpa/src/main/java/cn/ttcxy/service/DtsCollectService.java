package cn.ttcxy.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.dto.DtsDataDto;
import cn.ttcxy.entity.model.DtsCollect;
import cn.ttcxy.entity.model.DtsCollectExample;
import cn.ttcxy.mapper.dsl.DtsCollectDsl;
import cn.ttcxy.mapper.dsl.DtsDataDsl;
import cn.ttcxy.mapper.repository.DtsCollectRepository;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsCollectService {

    @Autowired
    private DtsCollectRepository collectRepository;

    @Autowired
    private DtsCollectDsl collectDsl;

    @Autowired
    private DtsDataDsl dataDsl;

    public long select(String authorId, String dataId) {
        return collectRepository.countByDataIdAndAuthorId(dataId, authorId);
    }

    public List<DtsDataDto> selectCollect(String username) {
        return collectDsl.selectCollect(username);
    }

    public DtsCollect insert(String authorId, String dataId) {
        Integer type = dataDsl.selectDataType(dataId);
        DtsCollectExample collectExample = new DtsCollectExample();
        collectExample.createCriteria().andDataIdEqualTo(dataId).andAuthorIdEqualTo(authorId);
        DtsCollect dtsCollect = new DtsCollect();
        String id = IdUtil.objectId();
        dtsCollect.setAuthorId(authorId);
        dtsCollect.setDataId(dataId);
        dtsCollect.setCollectId(id);
        dtsCollect.setType(type);
        dtsCollect.setCreateDate(DateUtil.date());
        return collectRepository.save(dtsCollect);
    }

    public int unCollect(String authorId, String dataId) {
        return collectRepository.deleteByDataIdAndAuthorId(dataId,authorId);
    }
}
