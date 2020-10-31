package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import net.ttcxy.tang.gateway.dao.AuthorDao;
import net.ttcxy.tang.gateway.entity.AuthorLogin;
import net.ttcxy.tang.model.Author;
import net.ttcxy.tang.model.AuthorExample;
import net.ttcxy.tang.mapper.AuthorMapper;
import net.ttcxy.tang.gateway.service.AuthorService;
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
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorDao authorDao;

    @Autowired
    private AuthorMapper authorMapper;

    @Override
    public AuthorLogin selectUserByName(String username) {
        return authorDao.selectAuthorByName(username);
    }

    @Override
    public AuthorLogin selectLoginAuthorByMail(String mail) {
        return authorDao.selectAuthorByMail(mail);
    }

    @Override
    public int insertAuthor(Author author) throws DuplicateKeyException {
        author.setId(IdUtil.simpleUUID());
        String password = author.getPassword();
        String encodePassword = new BCryptPasswordEncoder().encode(password);
        author.setPassword(encodePassword);
        return authorMapper.insertSelective(author);
    }

    @Override
    public int updateAuthor(Author author) {
        return authorMapper.updateByPrimaryKeySelective(author);
    }


    @Override
    public int updateAuthorPassword(Author author) {
        return authorMapper.updateByPrimaryKeySelective(author);
    }

    @Override
    public Boolean selectUsernameIsTrue(String username) {
        int count = authorDao.selectUsernameIsTrue(username);
        return count > 0;
    }

    @Override
    public Boolean selectNicknameIsTrue(String nickname) {
        int count = authorDao.selectNicknameIsTrue(nickname);
        return count > 0;
    }

    @Override
    public Boolean selectMailIsTrue(String username) {
        int count = authorDao.selectEmailIsTrue(username);
        return count > 0;
    }

    @Override
    public int updateUserByMail(String mail,String password) {

        Author author = new Author();
        author.setPassword(password);

        AuthorExample authorExample = new AuthorExample();
        authorExample.createCriteria().andMailEqualTo(mail).andPasswordEqualTo(password);

        return authorMapper.updateByExampleSelective(author, authorExample);

    }

    @Override
    public List<Author> listAuthor(Integer page){
        PageHelper.startPage(page, 10);
        return authorMapper.selectByExample(new AuthorExample());
    }
}
