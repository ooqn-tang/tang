package com.ooqn.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ooqn.entity.dto.DtsRemarkDto;
import com.ooqn.entity.model.DtsRemark;
import com.ooqn.entity.model.UtsAuthor;
import com.ooqn.repository.DtsRemarkRepository;
import com.ooqn.repository.UtsAuthorRepository;

@Service
public class DtsRemarkService {

    @Autowired
    private DtsRemarkRepository remarkRepository;

    @Autowired
    private UtsAuthorRepository authorRepository;

    public DtsRemark insert(DtsRemark remark) {
        return remarkRepository.save(remark);
    }

    public void delete(String dataId) {
        remarkRepository.deleteById(dataId);
    }

    public Page<DtsRemarkDto> list(String dataId, Pageable pageable) {
        return remarkRepository.findByDataIdOrderByCreateTimeDesc(dataId,pageable).map( remark -> {
            DtsRemarkDto remarkDto = new DtsRemarkDto(remark);
            if (remarkDto.getAuthorId() != null) {
                Optional<UtsAuthor> authorOptional = authorRepository.findById(remarkDto.getAuthorId());
                remarkDto.setAuthor(authorOptional.orElseThrow());
            }
            return remarkDto;
        });
    }
}
