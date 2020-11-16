package net.ttcxy.tang.admin.server.impl;

import net.ttcxy.tang.admin.server.UtsResourceService;
import net.ttcxy.tang.model.UtsResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author huanglei
 */
@Service
public class UtsResourceServiceImpl implements UtsResourceService {
    @Override
    public List<UtsResource> listAll() {
        List<UtsResource> lu = new ArrayList<>();
        lu.add(new UtsResource());
        return lu;
    }
}
