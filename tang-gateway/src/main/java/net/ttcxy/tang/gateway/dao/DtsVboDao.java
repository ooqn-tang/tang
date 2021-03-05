package net.ttcxy.tang.gateway.dao;

import net.ttcxy.tang.gateway.entity.dto.DtsVboDto;

import java.util.List;

public interface DtsVboDao {
    List<DtsVboDto> select(String username);
}
