package cn.ttcxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleSubject;
import cn.ttcxy.mapper.dsl.DtsArticleSubjectDsl;
import cn.ttcxy.mapper.repository.DtsArticleRepository;
import cn.ttcxy.mapper.repository.DtsArticleSubjectRepository;

@Service
public class DtsArticleSubjectService {

    @Autowired
    private DtsArticleSubjectDsl articleSubjectDsl;

    @Autowired
    private DtsArticleSubjectRepository articleSubjectRepository;

    @Autowired
    private DtsArticleRepository articleRepository;

    public DtsArticleSubjectDto selectSubjectArticleListById(String subjectId) {
        DtsArticleSubjectDto dtsArticleSubjectDto = articleSubjectDsl.selectSubjectById(subjectId);
        List<DtsArticle> dtsArticles = articleRepository.findAllBySubjectId(subjectId);
        dtsArticleSubjectDto.setArticleList(dtsArticles);
        return dtsArticleSubjectDto;
    }

    public PageInfo<DtsArticleSubjectDto> selectSubjectList(Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(articleSubjectDsl.selectSubjectList());
    }

    public PageInfo<DtsArticleSubjectDto> selectSubjectListByUsername(String username, Integer page, Integer pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(articleSubjectDsl.selectSubjectListByUsername(username));
    }

    public DtsArticleSubject insertSubject(DtsArticleSubject subject) {
        subject.setSubjectId(IdUtil.objectId());
        DateTime date = DateUtil.date();
        subject.setCreateDate(date);
        subject.setUpdateDate(date);
        return articleSubjectRepository.save(subject);
    }

    public DtsArticleSubject updateSubject(DtsArticleSubject subject) {
        subject.setUpdateDate(DateUtil.date());
        return articleSubjectRepository.save(subject);
    }

    public PageInfo<DtsArticleSubjectDto> selectSubjectListBySubjectName(String name, int page, int pageSize) {
        PageHelper.startPage(page,pageSize);
        return new PageInfo<>(articleSubjectDsl.selectSubjectListBySubjectName(name));
    }

    public String selectSubjectIdByArticleId(String articleId) {
        return articleRepository.findById(articleId).orElseThrow().getSubjectId();
    }

    public DtsArticleSubject subjectById(String subjectId) {
        return articleSubjectRepository.findById(subjectId).orElseThrow();
    }

}
