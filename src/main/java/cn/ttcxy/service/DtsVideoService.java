package cn.ttcxy.service;

import cn.hutool.core.date.DateUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import cn.ttcxy.entity.dto.DtsDataCount;
import cn.ttcxy.entity.dto.DtsVideoDto;
import cn.ttcxy.entity.model.DtsVideo;
import cn.ttcxy.entity.model.DtsVideoClass;
import cn.ttcxy.entity.param.DtsVideoParam;
import cn.ttcxy.mapper.DtsVideoClassMapper;
import cn.ttcxy.mapper.DtsVideoMapper;
import cn.ttcxy.mapper.dao.DtsDataDao;
import cn.ttcxy.mapper.dao.DtsVideoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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

    @Autowired
    private DtsVideoClassMapper videoClassMapper;

    public int deleteById(String videoId) {
        DtsVideo video = new DtsVideo();
        video.setVideoId(videoId);
        video.setState(4);
        return videoMapper.updateByPrimaryKeySelective(video);
    }

    public int update(DtsVideo dtsVideo) {
        return videoMapper.updateByPrimaryKey(dtsVideo);
    }

    public int updateSelective(DtsVideo dtsVideo) {
        return videoMapper.updateByPrimaryKeySelective(dtsVideo);
    }

    public int insert(DtsVideo dtsVideo) {
        return videoMapper.insert(dtsVideo);
    }

    public DtsVideoDto selectById(String videoId) {
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

    public List<DtsVideoClass> selectVideoClass() {
        return videoClassMapper.selectByExample(null);
    }

    public PageInfo<DtsVideoDto> selectList(DtsVideoParam videoParam) {
        PageHelper.startPage(videoParam.getPage(),20);
        List<DtsVideoDto> dtsVideoDtos = videoDao.selectList(videoParam);
        return new PageInfo<>(dtsVideoDtos);
    }

    public PageInfo<DtsVideoDto> selectGz(Integer page, Integer size,String authorId) {
        PageHelper.startPage(page,12);
        List<DtsVideoDto> videoDtoList = videoDao.selectGz(authorId);
        return new PageInfo<>(videoDtoList);
    }

    public PageInfo<DtsVideoDto> search(String wb,Integer page) {
        PageHelper.startPage(page,24);
        List<DtsVideoDto> videoDtoList = videoDao.search(wb);
        return new PageInfo<>(videoDtoList);
    }

    public PageInfo<DtsVideoDto> ranking() {
        PageHelper.startPage(1,10);
        List<DtsVideoDto> videoDtoList = videoDao.ranking(DateUtil.lastWeek(),DateUtil.date());
        return new PageInfo<>(videoDtoList);
    }

    public List<DtsVideoDto> rand(Integer num) {
        List<DtsVideoDto> videoDtoList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            DtsVideoDto rand = videoDao.rand();
            videoDtoList.add(rand);
        }
        return videoDtoList;
    }
}
