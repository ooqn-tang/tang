package net.ttcxy.tangtang.service.impl;

import net.ttcxy.tangtang.entity.Comment;
import net.ttcxy.tangtang.mapper.CommentMapper;
import net.ttcxy.tangtang.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author ：HuangLei
 * @date ：2020/4/18 0018 18:18
 */
@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentMapper commentMapper;

    @Override
    public boolean insertComment(Comment comment) {
        int code = commentMapper.insertComment(comment);
        if (code==1){
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteComment(String id) {
        int code = commentMapper.deleteComment(id);
        if (code==1){
            return true;
        }
        return false;
    }

    @Override
    public List<Comment> selectComment(String blogId) {

        return commentMapper.selectComment(blogId);
    }
}
