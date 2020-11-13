package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import net.ttcxy.tang.gateway.dao.UtsAuthorDao;
import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
import net.ttcxy.tang.gateway.service.UtsAuthorService;
import net.ttcxy.tang.mapper.UtsAuthorMapper;
import net.ttcxy.tang.model.UtsAuthor;
import net.ttcxy.tang.model.UtsAuthorExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 创作者服务
 * @author huanglei
 */
@Service
public class UtsAuthorServiceImpl implements UtsAuthorService {

    @Autowired
    private UtsAuthorDao utsAuthorDao;

    @Autowired
    private UtsAuthorMapper authorMapper;

    @Override
    public UtsAuthorLogin selectUserByName(String username) {
        return utsAuthorDao.selectAuthorByName(username);
    }

    @Override
    public UtsAuthorLogin selectLoginAuthorByMail(String mail) {
        return utsAuthorDao.selectAuthorByMail(mail);
    }

    @Override
    public int insertAuthor(UtsAuthor author) throws DuplicateKeyException {
        author.setId(IdUtil.simpleUUID());
        String password = author.getPassword();
        String encodePassword = new BCryptPasswordEncoder().encode(password);
        author.setPassword(encodePassword);
        return authorMapper.insertSelective(author);
    }

    @Override
    public int updateAuthor(UtsAuthor author) {
        return authorMapper.updateByPrimaryKeySelective(author);
    }


    @Override
    public int updateAuthorPassword(UtsAuthor author) {
        return authorMapper.updateByPrimaryKeySelective(author);
    }

    @Override
    public Boolean selectUsernameIsTrue(String username) {
        int count = utsAuthorDao.selectUsernameIsTrue(username);
        return count > 0;
    }

    @Override
    public Boolean selectNicknameIsTrue(String nickname) {
        int count = utsAuthorDao.selectNicknameIsTrue(nickname);
        return count > 0;
    }

    @Override
    public Boolean selectMailIsTrue(String username) {
        int count = utsAuthorDao.selectEmailIsTrue(username);
        return count > 0;
    }

    @Override
    public int updateUserByMail(String mail,String password) {

        UtsAuthor author = new UtsAuthor();
        author.setPassword(password);

        UtsAuthorExample authorExample = new UtsAuthorExample();
        authorExample.createCriteria().andMailEqualTo(mail).andPasswordEqualTo(password);

        return authorMapper.updateByExampleSelective(author, authorExample);

    }

    @Override
    public List<UtsAuthor> listAuthor(Integer page){
        PageHelper.startPage(page, 10);
        return authorMapper.selectByExample(new UtsAuthorExample());
    }
}
