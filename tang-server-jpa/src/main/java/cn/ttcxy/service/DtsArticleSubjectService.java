package cn.ttcxy.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

    public Page<DtsArticleSubjectDto> selectSubjectList(Pageable pageable) {
        return articleSubjectDsl.selectSubjectList(pageable);
    }

    public Page<DtsArticleSubjectDto> selectSubjectListByUsername(String username, Pageable pageable) {
        return articleSubjectDsl.selectSubjectListByUsername(username,pageable);
    }

    public DtsArticleSubject insertSubject(DtsArticleSubject subject) {
        subject.setSubjectId(IdUtil.objectId());
        DateTime date = DateUtil.date();
        subject.setCreateDate(date);
        subject.setUpdateDate(date);
        return articleSubjectRepository.save(subject);
    }

    public DtsArticleSubject updateSubject(DtsArticleSubject subject) {
        DtsArticleSubject articleSubject = articleSubjectRepository.findById(subject.getSubjectId()).orElseThrow();
        articleSubject.setUpdateDate(DateUtil.date());
        articleSubject.setSubjectName(subject.getSubjectName());
        articleSubject.setSynopsis(subject.getSynopsis());
        return articleSubjectRepository.save(articleSubject);
    }

    public Page<DtsArticleSubjectDto> selectSubjectListBySubjectName(String name, Pageable pageable) {
        return articleSubjectDsl.selectSubjectListBySubjectName(name, pageable);
    }

    public String selectSubjectIdByArticleId(String articleId) {
        return articleRepository.findById(articleId).orElseThrow().getSubjectId();
    }

    public DtsArticleSubject subjectById(String subjectId) {
        return articleSubjectRepository.findById(subjectId).orElseThrow();
    }

}
