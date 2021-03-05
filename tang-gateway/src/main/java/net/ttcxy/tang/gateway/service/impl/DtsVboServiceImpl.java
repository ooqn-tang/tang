package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.StrUtil;
import net.ttcxy.tang.gateway.dao.DtsVboDao;
import net.ttcxy.tang.gateway.entity.dto.DtsVboDto;
import net.ttcxy.tang.gateway.service.CurrentAuthorService;
import net.ttcxy.tang.gateway.service.DtsVboService;
import net.ttcxy.tang.mapper.DtsFavoriteMapper;
import net.ttcxy.tang.mapper.DtsVboMapper;
import net.ttcxy.tang.model.DtsFavorite;
import net.ttcxy.tang.model.DtsVbo;
import net.ttcxy.tang.model.DtsVboExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsVboServiceImpl implements DtsVboService {

    @Autowired
    private DtsVboMapper dtsVboMapper;

    @Autowired
    private CurrentAuthorService currentAuthorService;

    @Autowired
    private DtsFavoriteMapper dtsFavoriteMapper;

    @Autowired
    private DtsVboDao dtsVboDao;

    @Override
    public int insert(DtsVbo dtsVbo) {
        String id = currentAuthorService.getAuthor().getId();
        dtsVbo.setId(IdUtil.fastSimpleUUID());
        dtsVbo.setUtsAuthorId(id);
        DateTime date = DateUtil.date();
        dtsVbo.setCreateDate(date);
        dtsVbo.setUpdateDate(date);
        return dtsVboMapper.insertSelective(dtsVbo);
    }


    public List<DtsVboDto> selectVbo(String authorUsername){
        return dtsVboDao.select(authorUsername);
    }

    @Override
    public int delete(String uuid) {
        return dtsVboMapper.deleteByPrimaryKey(uuid);
    }


    @Override
    public int favorite(String id) {
        String authorId = currentAuthorService.getAuthorId();
        DtsFavorite dtsFavorite = new DtsFavorite();
        dtsFavorite.setVboId(id);
        dtsFavorite.setAuthorId(authorId);
        dtsFavorite.setCreateDate(DateUtil.date());
        return dtsFavoriteMapper.insert(dtsFavorite);
    }
}
