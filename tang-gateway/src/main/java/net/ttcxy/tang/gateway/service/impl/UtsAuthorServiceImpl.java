package net.ttcxy.tang.gateway.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import net.ttcxy.tang.gateway.entity.UtsMemberLogin;
import net.ttcxy.tang.gateway.entity.dto.UtsAuthorDto;
import net.ttcxy.tang.gateway.entity.dto.UtsRoleDto;
import net.ttcxy.tang.model.UtsAuthor;
import net.ttcxy.tang.model.UtsAuthorExample;
import net.ttcxy.tang.gateway.dao.UtsMemberDao;
import net.ttcxy.tang.gateway.dao.UtsRoleDao;
import net.ttcxy.tang.gateway.service.UtsAuthorService;
import net.ttcxy.tang.mapper.UtsAuthorMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
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
    private UtsAuthorMapper authorMapper;

    @Autowired
    private UtsRoleDao utsRoleDao;

    @Override
    public UtsMemberLogin selectMemberByName(String username) {
        return utsMemberDao.selectMemberByName(username);
    }

    @Override
    public UtsMemberLogin selectMemberByMail(String mail) {
        return utsMemberDao.selectMemberByMail(mail);
    }

    @Override
    public int insertMember(UtsAuthor member) throws DuplicateKeyException {
        member.setId(IdUtil.simpleUUID());
        String password = member.getPassword();
        String encodePassword = new BCryptPasswordEncoder().encode(password);
        member.setPassword(encodePassword);

        return authorMapper.insertSelective(member);
    }

    @Override
    public int updateMember(UtsAuthor member) {
        return authorMapper.updateByPrimaryKeySelective(member);
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
        int count = utsMemberDao.selectMailIsTrue(username);
        return count > 0;
    }

    @Override
    public List<UtsAuthor> memberList(Integer page){
        PageHelper.startPage(page, 10);
        return authorMapper.selectByExample(new UtsAuthorExample());
    }



    @Override
    public List<UtsAuthorDto> memberListDto(Integer page){
        PageHelper.startPage(page, 10);
        List<UtsAuthor> utsAuthor = authorMapper.selectByExample(new UtsAuthorExample());

        List<UtsAuthorDto> utsAuthorDtoList = new ArrayList<>();

        for (UtsAuthor member : utsAuthor) {
            UtsAuthorDto utsAuthorDto = new UtsAuthorDto();
            utsAuthorDto.setUtsAuthor(member);
            List<UtsRoleDto> utsRoleDtoList = utsRoleDao.selectRoleListByMemberId(member.getId());
            utsAuthorDto.setUtsRoleDto(new HashSet<>(utsRoleDtoList));
            utsAuthorDtoList.add(utsAuthorDto);
        }

        return utsAuthorDtoList;
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
