package net.ttcxy.tang.admin.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import net.ttcxy.tang.admin.dao.UtsMemberDao;
import net.ttcxy.tang.admin.dao.UtsRoleDao;
import net.ttcxy.tang.admin.entity.UtsMemberLogin;
import net.ttcxy.tang.admin.entity.dto.UtsMemberDto;
import net.ttcxy.tang.admin.entity.dto.UtsRoleDto;
import net.ttcxy.tang.admin.service.UtsMemberService;
import net.ttcxy.tang.mapper.UtsAuthorMapper;
import net.ttcxy.tang.model.UtsAuthor;
import net.ttcxy.tang.model.UtsAuthorExample;
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
public class UtsMemberServiceImpl implements UtsMemberService {

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
    public List<UtsMemberDto> memberListDto(Integer page){
        PageHelper.startPage(page, 10);
        List<UtsAuthor> utsAuthor = authorMapper.selectByExample(new UtsAuthorExample());

        List<UtsMemberDto> utsMemberDtoList = new ArrayList<>();

        for (UtsAuthor member : utsAuthor) {
            UtsMemberDto utsMemberDto = new UtsMemberDto();
            utsMemberDto.setUtsAuthor(member);
            List<UtsRoleDto> utsRoleDtoList = utsRoleDao.selectRoleListByMemberId(member.getId());
            utsMemberDto.setUtsRoleDto(new HashSet<>(utsRoleDtoList));
            utsMemberDtoList.add(utsMemberDto);
        }

        return utsMemberDtoList;
    }

    public static void main(String[] args) {
        UtsMemberDto utsMemberDto = new UtsMemberDto();
        UtsAuthor utsAuthor = new UtsAuthor();
        utsAuthor.setId("asdfads");
        utsAuthor.setNickname("kasfjkajdfk");
        BeanUtil.copyProperties(utsAuthor, utsMemberDto);
        System.out.println(utsMemberDto);
    }
}
