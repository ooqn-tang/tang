package cn.ttcxy.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import cn.ttcxy.entity.dto.UtsRoleDto;
import cn.ttcxy.entity.model.*;
import cn.ttcxy.entity.param.UtsRoleParam;
import cn.ttcxy.mapper.UtsAuthorMapper;
import cn.ttcxy.mapper.UtsAuthorRoleMapper;
import cn.ttcxy.mapper.dao.UtsAuthorDao;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 创作者服务
 */
@Service
public class UtsAuthorService {

    @Autowired
    private UtsAuthorDao authorDao;

    @Autowired
    private UtsAuthorMapper utsAuthorMapper;

    @Autowired
    private UtsAuthorRoleMapper authorRoleMapper;

    @Autowired
    private UtsRoleService roleService;

    private static final Map<String,Date> usernameTime = new HashMap<>();

    private static final Map<String,Date> roleNameTime = new HashMap<>();

    public UtsAuthor selectAuthorByName(String username) {
        UtsAuthorExample authorExample = new UtsAuthorExample();
        authorExample.createCriteria().andUsernameEqualTo(username);
        List<UtsAuthor> utsAuthors = utsAuthorMapper.selectByExample(authorExample);
        if (utsAuthors.size() > 0){
            return utsAuthors.get(0);
        }
        return null;
    }

    public UtsAuthor selectAuthorByMail(String mail) {
        UtsAuthorExample authorExample = new UtsAuthorExample();
        authorExample.createCriteria().andMailEqualTo(mail);
        List<UtsAuthor> utsAuthors = utsAuthorMapper.selectByExample(authorExample);
        if (utsAuthors.size() > 0){
            return utsAuthors.get(0);
        }
        return null;
    }

    public int insertAuthor(UtsAuthor author) throws DuplicateKeyException {
        String objectId = IdUtil.objectId();
        author.setAuthorId(objectId);
        String username = getUsername();
        author.setNickname(username);
        author.setUsername(username);

        UtsAuthorRole authorRole = new UtsAuthorRole();
        authorRole.setAuthorRoleId(IdUtil.objectId());
        authorRole.setAuthorId(objectId);
        authorRole.setRoleId("2");
        authorRole.setCreateTime(DateUtil.date());
        authorRoleMapper.insert(authorRole);
        return utsAuthorMapper.insertSelective(author);
    }

    public int updateAuthorByName(UtsAuthor author) {
        UtsAuthorExample authorExample = new UtsAuthorExample();
        authorExample.createCriteria().andMailEqualTo(author.getMail());
        return utsAuthorMapper.updateByExampleSelective(author, authorExample);
    }

    public Boolean selectUsernameIsTrue(String username) {
        UtsAuthorExample authorExample = new UtsAuthorExample();
        authorExample.createCriteria().andUsernameEqualTo(username);
        return utsAuthorMapper.countByExample(authorExample) > 0;
    }

    public Boolean selectNicknameIsTrue(String nickname) {
        UtsAuthorExample authorExample = new UtsAuthorExample();
        authorExample.createCriteria().andNicknameEqualTo(nickname);
        return utsAuthorMapper.countByExample(authorExample) > 0;
    }

    public Boolean selectMailIsTrue(String mail) {
        UtsAuthorExample authorExample = new UtsAuthorExample();
        authorExample.createCriteria().andMailEqualTo(mail);
        return utsAuthorMapper.countByExample(authorExample) > 0;
    }

    public PageInfo<UtsAuthor> selectAuthor(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        UtsAuthorExample example = new UtsAuthorExample();
        return new PageInfo<>(utsAuthorMapper.selectByExample(null));
    }

    public List<UtsAuthor> select(String queryData) {
        UtsAuthorExample example = new UtsAuthorExample();
        example.or().andMailLike("%"+queryData+"%");
        example.or().andUsernameLike("%"+queryData+"%");
        example.or().andNicknameLike("%"+queryData+"%");
        return utsAuthorMapper.selectByExample(example);
    }

    public int update(UtsAuthor author) {
        return utsAuthorMapper.updateByPrimaryKeySelective(author);
    }

    public int delete(String authorId) {
        return utsAuthorMapper.deleteByPrimaryKey(authorId);
    }

    public void insertRole(String authorId,List<UtsRoleParam> roleParams) {
        UtsAuthorRoleExample authorRoleExample = new UtsAuthorRoleExample();
        authorRoleExample.createCriteria().andAuthorIdEqualTo(authorId);
        authorRoleMapper.deleteByExample(authorRoleExample);
        for (UtsRoleParam roleParam : roleParams) {
            UtsAuthorRole authorRole = new UtsAuthorRole();
            authorRole.setAuthorRoleId(IdUtil.objectId());
            authorRole.setRoleId(roleParam.getRoleId());
            authorRole.setCreateTime(new Date());
            authorRole.setAuthorId(authorId);
            authorRoleMapper.insert(authorRole);
        }
    }

    public Date nowTime(String username, List<UtsRoleDto> roleList) {
        Set<Date> dateSet = new TreeSet<>();
        Date usernameTime = getUsernameTime(username);
        if (usernameTime!=null){
            dateSet.add(usernameTime);
        }
        dateSet.addAll(getRoleNameTime(roleList));

        return dateSet.stream().reduce((first, second) -> second).orElse(new Date());
    }

    private Date getUsernameTime(String username){
        Date date = usernameTime.get(username);
        if (ObjectUtil.isEmpty(date)){
            UtsAuthor author = selectAuthorByName(username);
            date = author.getRefreshTime();
            usernameTime.put(username,date);
        }
        return date;
    }

    private Set<Date> getRoleNameTime(List<UtsRoleDto> roleList){
        Set<Date> dateSet = new TreeSet<>();
        for (UtsRoleDto role : roleList) {
            List<UtsRole> roles = roleService.selectByName(role.getRoleValue());
            for (UtsRole r : roles) {
                Date refreshTime = r.getRefreshTime();
                if (!ObjectUtil.isEmpty(refreshTime)){
                    dateSet.add(refreshTime);
                }
            }
        }
        return dateSet;
    }

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


}
