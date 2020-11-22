package net.ttcxy.tang.service.impl;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import net.ttcxy.tang.db.dao.UtsMemberDao;
import net.ttcxy.tang.entity.UtsMemberLogin;
import net.ttcxy.tang.service.UtsAuthorService;
import net.ttcxy.tang.db.mapper.UtsMemberMapper;
import net.ttcxy.tang.entity.model.UtsMember;
import net.ttcxy.tang.entity.model.UtsMemberExample;
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
    private UtsMemberDao utsMemberDao;

    @Autowired
    private UtsMemberMapper authorMapper;

    @Override
    public UtsMemberLogin selectUserByName(String username) {
        return utsMemberDao.selectMemberByName(username);
    }

    @Override
    public UtsMemberLogin selectLoginAuthorByMail(String mail) {
        return utsMemberDao.selectMemberByMail(mail);
    }

    @Override
    public int insertAuthor(UtsMember author) throws DuplicateKeyException {
        author.setId(IdUtil.simpleUUID());
        String password = author.getPassword();
        String encodePassword = new BCryptPasswordEncoder().encode(password);
        author.setPassword(encodePassword);
        return authorMapper.insertSelective(author);
    }

    @Override
    public int updateAuthor(UtsMember author) {
        return authorMapper.updateByPrimaryKeySelective(author);
    }


    @Override
    public int updateAuthorPassword(UtsMember author) {
        return authorMapper.updateByPrimaryKeySelective(author);
    }

    @Override
    public Boolean selectUsernameIsTrue(String username) {
        int count = utsMemberDao.selectUsernameIsTrue(username);
        return count > 0;
    }

    @Override
    public Boolean selectNicknameIsTrue(String nickname) {
        int count = utsMemberDao.selectNicknameIsTrue(nickname);
        return count > 0;
    }

    @Override
    public Boolean selectMailIsTrue(String username) {
        int count = utsMemberDao.selectEmailIsTrue(username);
        return count > 0;
    }

    @Override
    public int updateUserByMail(String mail,String password) {

        UtsMember author = new UtsMember();
        author.setPassword(password);

        UtsMemberExample authorExample = new UtsMemberExample();
        authorExample.createCriteria().andMailEqualTo(mail).andPasswordEqualTo(password);

        return authorMapper.updateByExampleSelective(author, authorExample);

    }

    @Override
    public List<UtsMember> listAuthor(Integer page){
        PageHelper.startPage(page, 10);
        return authorMapper.selectByExample(new UtsMemberExample());
    }
}
