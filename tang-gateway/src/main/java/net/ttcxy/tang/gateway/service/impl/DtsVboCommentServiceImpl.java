package net.ttcxy.tang.gateway.service.impl;

import net.ttcxy.tang.gateway.service.DtsVboCommentService;
import net.ttcxy.tang.mapper.DtsVboCommentMapper;
import net.ttcxy.tang.model.DtsVboComment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DtsVboCommentServiceImpl implements DtsVboCommentService {

    @Autowired
    private DtsVboCommentMapper dtsVboCommentMapper;

    @Override
    public int addComment(DtsVboComment dtsVboComment) {
        return dtsVboCommentMapper.insertSelective(dtsVboComment);
    }
}
