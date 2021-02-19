package net.ttcxy.tang.gateway.service;

import net.ttcxy.tang.model.DtsVbo;

import java.util.List;

public interface DtsVboService {
    int insert(DtsVbo dtsVbo);

    List<DtsVbo> selectVbo(String authorUuid);
}
