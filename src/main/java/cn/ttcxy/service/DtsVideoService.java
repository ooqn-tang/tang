package cn.ttcxy.service;

import cn.ttcxy.entity.dto.DtsDataCount;
import cn.ttcxy.entity.dto.DtsVideoDto;
import cn.ttcxy.entity.model.DtsVideo;
import cn.ttcxy.entity.param.DtsVideoParam;
import cn.ttcxy.mapper.DtsVideoMapper;
import cn.ttcxy.mapper.dao.DtsDataDao;
import cn.ttcxy.mapper.dao.DtsVideoDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class DtsVideoService {

    @Autowired
    private DtsVideoMapper videoMapper;

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

    public PageInfo<DtsVideoDto> select(Integer page,Integer size, String title,String classId) {
        PageHelper.startPage(page,size);
        List<DtsVideoDto> videoDtoList = videoDao.select(title,classId);
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

    public List<DtsVideoDto> rand(Integer num) {
        List<DtsVideoDto> videoDtoList = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            DtsVideoDto rand = videoDao.rand();
            videoDtoList.add(rand);
        }
        return videoDtoList;
    }

    public String authorId(String videoId){
        DtsVideo dtsVideo = videoMapper.selectByPrimaryKey(videoId);
        return dtsVideo.getAuthorId();
    }
}
