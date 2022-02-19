package net.ttcxy.tang.portal.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.entity.dto.DtsDataDto;
import net.ttcxy.tang.portal.entity.model.DtsCollect;
import net.ttcxy.tang.portal.entity.model.DtsCollectExample;
import net.ttcxy.tang.portal.mapper.DtsCollectMapper;
import net.ttcxy.tang.portal.mapper.dao.DtsArticleDao;
import net.ttcxy.tang.portal.mapper.dao.DtsCollectDao;
import net.ttcxy.tang.portal.mapper.dao.DtsDataDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
public class DtsCollectService {

    @Autowired
    private DtsCollectMapper collectMapper;

    @Autowired
    private DtsArticleDao articleDao;

    @Autowired
    private DtsCollectDao collectDao;

    @Autowired
    private DtsDataDao dataDao;

    public long select(String authorId, String dataId) {
        DtsCollectExample collectExample = new DtsCollectExample();
        collectExample.createCriteria().andDataIdEqualTo(dataId).andAuthorIdEqualTo(authorId);
        return collectMapper.countByExample(collectExample);
    }

    public PageInfo<DtsDataDto> selectCollect(String username, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(collectDao.selectCollect(username));
    }

    public int insert(String authorId, String dataId) {
        Integer type = dataDao.selectDataType(dataId);
        try{
            DtsCollectExample collectExample = new DtsCollectExample();
            collectExample.createCriteria().andDataIdEqualTo(dataId).andAuthorIdEqualTo(authorId);
            DtsCollect dtsCollect = new DtsCollect();
            String id = IdUtil.objectId();
            dtsCollect.setAuthorId(authorId);
            dtsCollect.setDataId(dataId);
            dtsCollect.setCollectId(id);
            dtsCollect.setType(type);
            dtsCollect.setCreateDate(DateUtil.date());
            return collectMapper.insert(dtsCollect);
        }catch (DuplicateKeyException e){
            return 1;
        }
    }

    public int unCollect(String authorId, String dataId) {
        DtsCollectExample collectExample = new DtsCollectExample();
        collectExample.createCriteria().andDataIdEqualTo(dataId).andAuthorIdEqualTo(authorId);
        return collectMapper.deleteByExample(collectExample);
    }
}
