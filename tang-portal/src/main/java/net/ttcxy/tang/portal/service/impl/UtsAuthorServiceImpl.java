package net.ttcxy.tang.portal.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.mapper.UtsAuthorMapper;
import net.ttcxy.tang.portal.mapper.dao.UtsAuthorDao;
import net.ttcxy.tang.portal.entity.dto.UtsAuthorDto;
import net.ttcxy.tang.portal.entity.model.UtsAuthor;
import net.ttcxy.tang.portal.entity.model.UtsAuthorExample;
import net.ttcxy.tang.portal.service.UtsAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * 创作者服务
 * @author huanglei
 */
@Service
public class UtsAuthorServiceImpl implements UtsAuthorService {

    @Autowired
    private UtsAuthorDao utsAuthorDao;

    @Autowired
    private UtsAuthorMapper utsAuthorMapper;


    @Override
    public UtsAuthor selectAuthorByName(String username) {
        return utsAuthorDao.selectAuthorByName(username);
    }

    @Override
    public UtsAuthor selectAuthorByMail(String mail) {
        return utsAuthorDao.selectAuthorByMailAll(mail);
    }

    @Override
    public int insertAuthor(UtsAuthor author) throws DuplicateKeyException {
        author.setAuthorId(IdUtil.objectId());
        String username = getUsername();
        author.setNickname(username);
        author.setUsername(username);
        return utsAuthorMapper.insertSelective(author);
    }

    @Override
    public int updateAuthorByName(UtsAuthor author) {
        UtsAuthorExample authorExample = new UtsAuthorExample();
        authorExample.createCriteria().andMailEqualTo(author.getMail());
        return utsAuthorMapper.updateByExampleSelective(author, authorExample);
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
        int count = utsAuthorDao.selectMailIsTrue(username);
        return count > 0;
    }

    @Override
    public PageInfo<UtsAuthor> authorList(Integer page, Integer size){
        PageHelper.startPage(page, size);
        return new PageInfo<>(utsAuthorDao.selectAuthor());
    }

    @Override
    public PageInfo selectAuthorBlogCount(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo(utsAuthorDao.selectAuthorBlogCount());
    }

    /**
     * 生成用户名
     */
    private String getUsername(){
        while(true){
            String name = RandomUtil.randomNumbers(8);
            Boolean isUsername = selectUsernameIsTrue(name);
            Boolean isNickname = selectNicknameIsTrue(name);
            if (!isUsername && !isNickname){
                return name;
            }
        }
    }



    public static void main(String[] args) {
        UtsAuthorDto utsAuthorDto = new UtsAuthorDto();
        UtsAuthor utsAuthor = new UtsAuthor();
        utsAuthor.setAuthorId("asdfads");
        utsAuthor.setNickname("kasfjkajdfk");
        BeanUtil.copyProperties(utsAuthor, utsAuthorDto);
        System.out.println(utsAuthorDto);
    }
}
