package com.ooqn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ooqn.entity.dto.DtsSubjectDto;
import com.ooqn.entity.model.DtsSubject;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.repository.DtsSubjectRepository;
import com.ooqn.repository.UtsAuthorRepository;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;

@Service
public class DtsSubjectService {

    @Autowired
    private DtsSubjectRepository subjectRepository;

    @Autowired
    private UtsAuthorRepository authorRepository;
    
    /**
	 * 查询专辑链表
	 */
	public Page<DtsSubjectDto> selectList(Pageable pageable) {
		Page<DtsSubject> subjectPage = subjectRepository.findSubjectList(pageable);
		Page<DtsSubjectDto> subjectList = subjectPage.map(subject -> {
			String authorId = subject.getAuthorId();
			UtsAuthor author = authorRepository.findUsernameNicknameByAuthorId(authorId).orElseThrow();
			DtsSubjectDto subjectDto = new DtsSubjectDto(subject);
			subjectDto.setAuthor(author);
			return subjectDto;
		});
		return subjectList;
	}

    
	/**
	 * 通过作者名称查询专辑列表
	 */
	public List<DtsSubject> selectListByUsername(String username) {
		return subjectRepository.findByAuthorName(username);
	}

	/**
	 * 添加专辑
	 */
	public DtsSubject insert(DtsSubject subject) {
		DateTime date = DateUtil.date();
		subject.setSubjectId(IdUtil.objectId());
		subject.setCreateTime(date);
		subject.setUpdateTime(date);
		return subjectRepository.save(subject);
	}

	/**
	 * 更新专辑
	 */
	public DtsSubject update(DtsSubject subject) {
		DtsSubject articleSubject = subjectRepository.findById(subject.getSubjectId()).orElseThrow();
		articleSubject.setCreateTime(DateUtil.date());
		articleSubject.setSubjectName(subject.getSubjectName());
		articleSubject.setSynopsis(subject.getSynopsis());
		return subjectRepository.save(articleSubject);
	}

	/**
	 * 通过专辑名称搜索专辑
	 */
	public Page<DtsSubjectDto> findListBySubjectName(String name, Pageable pageable) {
		Page<DtsSubject> subjectList = subjectRepository.findBySubjectName(name, pageable);
		Page<DtsSubjectDto> subjectDtoList = subjectList.map(subject -> {
			DtsSubjectDto subjectDto = new DtsSubjectDto(subject);
			subjectDto.setAuthor(authorRepository.findUsernameNicknameByAuthorId(subject.getAuthorId()).orElseThrow());
			return subjectDto;
		});
		return subjectDtoList;
	}

    /**
	 * 通过专辑id查询专辑
	 * @param subjectId	专辑id
	 * @return	DtsSubject
	 */
	public DtsSubject subjectById(String subjectId) {
		return subjectRepository.findById(subjectId).orElseThrow();
	}

    	/**
	 * 通过文章id查询专辑 
	 * @param articleId 文章id
	 * @return	SubjectId
	 */
	public String findSubjectIdByArticleId(String articleId) {
		return subjectRepository.findSubjectIdByDataId(articleId);
	}

    
	@Transactional
	public void deleteBySubjectIdAndAuthorId(String subjectId, String authorId) {
		subjectRepository.deleteBySubjectIdAndAuthorId(subjectId, authorId);
	}
}
