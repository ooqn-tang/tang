package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import net.ttcxy.tang.gateway.entity.UtsAuthorLogin;
import net.ttcxy.tang.gateway.entity.dto.UtsAuthorDto;
import net.ttcxy.tang.gateway.dao.UtsAuthorDao;
import net.ttcxy.tang.gateway.service.UtsAuthorService;
import net.ttcxy.tang.mapper.UtsAuthorMapper;
import net.ttcxy.tang.model.UtsAuthor;
import net.ttcxy.tang.model.UtsAuthorExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    public UtsAuthorLogin selectAuthorByName(String username) {
        return utsAuthorDao.selectAuthorByName(username);
    }

    @Override
    public UtsAuthorLogin selectAuthorByMail(String mail) {
        return utsAuthorDao.selectAuthorByMail(mail);
    }

    @Override
    public int insertAuthor(UtsAuthor author) throws DuplicateKeyException {
        author.setId(IdUtil.fastSimpleUUID());
        String username = getUsername();
        author.setNickname(username);
        author.setUsername(username);
        return authorMapper.insertSelective(author);
    }

    @Override
    public int updateAuthor(UtsAuthor author) {
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
        int count = utsAuthorDao.selectMailIsTrue(username);
        return count > 0;
    }

    @Override
    public List<UtsAuthor> authorList(Integer page){
        PageHelper.startPage(page, 10);
        return authorMapper.selectByExample(new UtsAuthorExample());
    }



    @Override
    public List<UtsAuthorDto> authorListDto(Integer page){
        PageHelper.startPage(page, 10);
        List<UtsAuthor> utsAuthor = authorMapper.selectByExample(new UtsAuthorExample());

        List<UtsAuthorDto> utsAuthorDtoList = new ArrayList<>();

        for (UtsAuthor author : utsAuthor) {
            UtsAuthorDto utsAuthorDto = new UtsAuthorDto();
            utsAuthorDto.setUtsAuthor(author);
            utsAuthorDtoList.add(utsAuthorDto);
        }

        return utsAuthorDtoList;
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
        utsAuthor.setId("asdfads");
        utsAuthor.setNickname("kasfjkajdfk");
        BeanUtil.copyProperties(utsAuthor, utsAuthorDto);
        System.out.println(utsAuthorDto);
    }
}
