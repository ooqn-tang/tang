package net.ttcxy.tang.portal.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.core.security.CurrentUtil;
import net.ttcxy.tang.portal.entity.dto.DtsDataCount;
import net.ttcxy.tang.portal.entity.dto.DtsVideoDto;
import net.ttcxy.tang.portal.entity.model.DtsVideo;
import net.ttcxy.tang.portal.entity.model.DtsVideoClass;
import net.ttcxy.tang.portal.mapper.DtsVideoClassMapper;
import net.ttcxy.tang.portal.mapper.DtsVideoMapper;
import net.ttcxy.tang.portal.mapper.dao.DtsDataDao;
import net.ttcxy.tang.portal.mapper.dao.DtsVideoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DtsVideoService {

    // 单表操作
    @Autowired
    private DtsVideoMapper videoMapper;

    // 多表
    @Autowired
    private DtsVideoDao videoDao;

    @Autowired
    private DtsDataDao countDao;

    public int deleteById(String videoId) {
        DtsVideo video = new DtsVideo();
        video.setVideoId(videoId);
        video.setState(4);
        return videoMapper.updateByPrimaryKeySelective(video);
    }

    public int update(DtsVideo dtsVideo) {
        return videoMapper.updateByPrimaryKey(dtsVideo);
    }

    public int insert(DtsVideo dtsVideo) {
        return videoMapper.insert(dtsVideo);
    }

    @Autowired
    private DtsViewService visitService;

    public DtsVideoDto selectById(String videoId) {
        String id = CurrentUtil.id();
        DtsVideoDto dtsVideoDto = videoDao.selectById(videoId);
        DtsDataCount dataCount = countDao.selectDataStatCount(videoId);
        dtsVideoDto.setDataCount(dataCount);
        return dtsVideoDto;
    }

    public PageInfo<DtsVideoDto> select(Integer page,Integer size, String title,String videoClass) {
        PageHelper.startPage(page,size);
        List<DtsVideoDto> videoDtoList = videoDao.select(title,videoClass);
        return new PageInfo<>(videoDtoList);
    }

    public DtsVideo selectByIdCreateInfo(String videoId) {
        return videoMapper.selectByPrimaryKey(videoId);
    }

    public PageInfo<DtsVideoDto> selectByUsername(String authorName,Integer page,Integer size) {
        PageHelper.startPage(page,size);
        List<DtsVideoDto> videoDtoList = videoDao.selectByUsername(authorName);
        return new PageInfo<>(videoDtoList);
    }

    @Autowired
    private DtsVideoClassMapper videoClassMapper;

    public List<DtsVideoClass> selectVideoClass() {
        return videoClassMapper.selectByExample(null);
    }
}
