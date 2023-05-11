package com.ooqn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ooqn.entity.model.StsCode;
import com.ooqn.repository.StsCodeRepository;

import cn.hutool.core.util.IdUtil;

@Service
public class StsCodeService {

    @Autowired
    private StsCodeRepository codeRepository;

    public void insertCode(String name, String value) {
        StsCode code = new StsCode();
        code.setCodeId(IdUtil.objectId());
        code.setCodeName(name);
        code.setCodeValue(value);
        codeRepository.save(code);
    }

}
