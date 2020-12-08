package net.ttcxy.tang.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.IdUtil;
import com.github.pagehelper.PageHelper;
import net.ttcxy.tang.db.dao.UtsMemberDao;
import net.ttcxy.tang.db.dao.UtsRoleDao;
import net.ttcxy.tang.entity.UtsMemberLogin;
import net.ttcxy.tang.entity.dto.UtsMemberDto;
import net.ttcxy.tang.entity.dto.UtsRoleDto;
import net.ttcxy.tang.service.UtsMemberService;
import net.ttcxy.tang.db.mapper.UtsMemberMapper;
import net.ttcxy.tang.entity.model.UtsMember;
import net.ttcxy.tang.entity.model.UtsMemberExample;
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
    private UtsMemberMapper authorMapper;

    @Override
    public UtsMemberLogin selectMemberByName(String username) {
        return utsMemberDao.selectMemberByName(username);
    }

    @Override
    public UtsMemberLogin selectMemberByMail(String mail) {
        return utsMemberDao.selectMemberByMail(mail);
    }

    @Override
    public int insertMember(UtsMember member) throws DuplicateKeyException {
        member.setId(IdUtil.simpleUUID());
        String password = member.getPassword();
        String encodePassword = new BCryptPasswordEncoder().encode(password);
        member.setPassword(encodePassword);

        return authorMapper.insertSelective(member);
    }

    @Override
    public int updateMember(UtsMember member) {
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
    public List<UtsMember> memberList(Integer page){
        PageHelper.startPage(page, 10);
        return authorMapper.selectByExample(new UtsMemberExample());
    }

    @Autowired
    private UtsRoleDao utsRoleDao;

    @Override
    public List<UtsMemberDto> memberListDto(Integer page){
        PageHelper.startPage(page, 10);
        List<UtsMember> utsMember = authorMapper.selectByExample(new UtsMemberExample());

        List<UtsMemberDto> utsMemberDtoList = new ArrayList<>();

        for (UtsMember member : utsMember) {
            UtsMemberDto utsMemberDto = new UtsMemberDto();
            utsMemberDto.setUtsMember(member);
            List<UtsRoleDto> utsRoleDtoList = utsRoleDao.selectRoleListByMemberId(member.getId());
            utsMemberDto.setUtsRoleDto(new HashSet<>(utsRoleDtoList));
            utsMemberDtoList.add(utsMemberDto);
        }

        return utsMemberDtoList;
    }

    public static void main(String[] args) {
        UtsMemberDto utsMemberDto = new UtsMemberDto();
        UtsMember utsMember = new UtsMember();
        utsMember.setId("asdfads");
        utsMember.setNickname("kasfjkajdfk");
        BeanUtil.copyProperties(utsMember, utsMemberDto);
        System.out.println(utsMemberDto);
    }
}
