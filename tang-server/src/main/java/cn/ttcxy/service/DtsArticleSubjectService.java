package cn.ttcxy.service;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.ttcxy.dao.dsl.DtsArticleSubjectDsl;
import cn.ttcxy.dao.repository.DtsArticleSubjectRepository;
import cn.ttcxy.entity.dto.DtsArticleSubjectDto;
import cn.ttcxy.entity.model.DtsArticle;
import cn.ttcxy.entity.model.DtsArticleSubject;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class DtsArticleSubjectService {

  @Autowired
  private DtsArticleSubjectDsl articleSubjectDsl;

  @Autowired
  private DtsArticleSubjectRepository articleSubjectRepository;

  @Autowired
  private DtsArticleSubjectDsl dtsArticleSubjectDsl;

  public DtsArticleSubjectDto findSubjectArticleListBySubjectId(
    String subjectId
  ) {
    DtsArticleSubjectDto dtsArticleSubjectDto = articleSubjectDsl.findSubjectById(
      subjectId
    );
    if (dtsArticleSubjectDto == null) {
      return null;
    }
    List<DtsArticle> dtsArticles = articleSubjectDsl.findAllBySubjectId(
      subjectId
    );
    dtsArticleSubjectDto.setArticleList(dtsArticles);
    return dtsArticleSubjectDto;
  }

  public Page<DtsArticleSubjectDto> selectSubjectList(Pageable pageable) {
    return articleSubjectDsl.findSubjectList(pageable);
  }

  public List<DtsArticleSubjectDto> selectSubjectListByUsername(
    String username
  ) {
    return articleSubjectDsl.findSubjectListByUsername(username);
  }

  public DtsArticleSubject insertSubject(DtsArticleSubject subject) {
    subject.setSubjectId(IdUtil.objectId());
    DateTime date = DateUtil.date();
    subject.setCreateDate(date);
    subject.setUpdateDate(date);
    return articleSubjectRepository.save(subject);
  }

  public DtsArticleSubject updateSubject(DtsArticleSubject subject) {
    DtsArticleSubject articleSubject = articleSubjectRepository
      .findById(subject.getSubjectId())
      .orElseThrow();
    articleSubject.setUpdateDate(DateUtil.date());
    articleSubject.setSubjectName(subject.getSubjectName());
    articleSubject.setSynopsis(subject.getSynopsis());
    return articleSubjectRepository.save(articleSubject);
  }

  public Page<DtsArticleSubjectDto> selectSubjectListBySubjectName(
    String name,
    Pageable pageable
  ) {
    return articleSubjectDsl.findSubjectListBySubjectName(name, pageable);
  }

  public String findSubjectIdByArticleId(String articleId) {
    return articleSubjectDsl.findSubjectIdByArticleId(articleId);
  }

  public DtsArticleSubject subjectById(String subjectId) {
    return articleSubjectRepository.findById(subjectId).orElseThrow();
  }

  public List<DtsArticle> findSubjectArticleTitleListByArticleId(
    String articleId
  ) {
    String subjectId = findSubjectIdByArticleId(articleId);
    return dtsArticleSubjectDsl.findSubjectArticleTitleListBySubjectId(
      subjectId
    );
  }

  public void deleteBySubjectIdAndAuthorId(String subjectId, String authorId) {
    dtsArticleSubjectDsl.deleteBySubjectIdAndAuthorId(subjectId, authorId);
  }
}
