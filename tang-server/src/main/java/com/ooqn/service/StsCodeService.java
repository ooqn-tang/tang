package com.ooqn.service;

import java.util.ArrayList;
import java.util.List;

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

    public List<StsCode> loadSysCode(){
        List<StsCode> codeList = new ArrayList<StsCode>();
        Iterable<StsCode> findAll = codeRepository.findAll();
        findAll.iterator().forEachRemaining(codeList::add);
        return codeList;
    }

}
