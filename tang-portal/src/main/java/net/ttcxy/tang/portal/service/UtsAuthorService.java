package net.ttcxy.tang.portal.service;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.RandomUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import net.ttcxy.tang.portal.entity.model.*;
import net.ttcxy.tang.portal.entity.param.UtsRoleParam;
import net.ttcxy.tang.portal.mapper.UtsAuthorMapper;
import net.ttcxy.tang.portal.mapper.UtsAuthorRoleMapper;
import net.ttcxy.tang.portal.mapper.dao.UtsAuthorDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * 创作者服务
 * @author huanglei
 */
@Service
public class UtsAuthorService {

    @Autowired
    private UtsAuthorDao utsAuthorDao;

    @Autowired
    private UtsAuthorMapper utsAuthorMapper;

    @Autowired
    private UtsAuthorRoleMapper authorRoleMapper;


    
    public UtsAuthor selectAuthorByName(String username) {
        return utsAuthorDao.selectAuthorByName(username);
    }

    
    public UtsAuthor selectAuthorByMail(String mail) {
        return utsAuthorDao.selectAuthorByMailAll(mail);
    }

    
    public int insertAuthor(UtsAuthor author) throws DuplicateKeyException {
        author.setAuthorId(IdUtil.objectId());
        String username = getUsername();
        author.setNickname(username);
        author.setUsername(username);
        return utsAuthorMapper.insertSelective(author);
    }

    
    public int updateAuthorByName(UtsAuthor author) {
        UtsAuthorExample authorExample = new UtsAuthorExample();
        authorExample.createCriteria().andMailEqualTo(author.getMail());
        return utsAuthorMapper.updateByExampleSelective(author, authorExample);
    }

    
    public Boolean selectUsernameIsTrue(String username) {
        int count = utsAuthorDao.selectUsernameIsTrue(username);
        return count > 0;
    }

    
    public Boolean selectNicknameIsTrue(String nickname) {
        int count = utsAuthorDao.selectNicknameIsTrue(nickname);
        return count > 0;
    }

    
    public Boolean selectMailIsTrue(String username) {
        int count = utsAuthorDao.selectMailIsTrue(username);
        return count > 0;
    }

    
    public PageInfo<UtsAuthor> authorList(Integer page, Integer size){
        PageHelper.startPage(page, size);
        return new PageInfo<>(utsAuthorDao.selectAuthor());
    }

    
    public PageInfo selectAuthorArticleCount(Integer page, Integer size) {
        PageHelper.startPage(page, size);
        return new PageInfo(utsAuthorDao.selectAuthorArticleCount());
    }

    
    public List<UtsAuthor> select() {
        return utsAuthorMapper.selectByExample(null);
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



    
    public Date nowTime(String username, String... roleNames) {
        Set<Date> dateSet = new TreeSet<>();
        dateSet.add(getUsernameTime(username));
        dateSet.addAll(getRoleNameTime(roleNames));

        return dateSet.stream().reduce((first, second) -> second).orElse(new Date());
    }

    Map<String,Date> usernameTime = new HashMap<>();

    Map<String,Date> roleNameTime = new HashMap<>();

    private Date getUsernameTime(String username){
        Date date = usernameTime.get(username);
        if (ObjectUtil.isEmpty(date)){
            UtsAuthor author = utsAuthorDao.selectAuthorByName(username);
            date = author.getRefreshTime();
            usernameTime.put(username,date);
        }
        return date;
    }

    @Autowired
    UtsRoleService roleService;

    private Set<Date> getRoleNameTime(String... roleNames){
        Set<Date> dateSet = new TreeSet<>();
        for (String roleName : roleNames) {
            List<UtsRole> roleList = roleService.selectByName(roleName);
            for (UtsRole role : roleList) {
                Date refreshTime = role.getRefreshTime();
                if (!ObjectUtil.isEmpty(refreshTime)){
                    dateSet.add(refreshTime);
                }
            }
        }
        return dateSet;
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
        Set<Date> dateSet = new TreeSet<>();
        dateSet.add(DateUtil.parse("2021/01/01","yyyy/MM/dd"));
        dateSet.add(DateUtil.parse("2021/01/04","yyyy/MM/dd"));
        dateSet.add(DateUtil.parse("2021/01/02","yyyy/MM/dd"));
        dateSet.add(DateUtil.parse("2021/01/03","yyyy/MM/dd"));
    }
}
