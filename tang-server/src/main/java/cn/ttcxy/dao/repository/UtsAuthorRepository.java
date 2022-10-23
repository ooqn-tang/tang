package cn.ttcxy.dao.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import cn.ttcxy.entity.model.UtsAuthor;

@Repository
public interface UtsAuthorRepository extends PagingAndSortingRepository<UtsAuthor, String> {

    UtsAuthor findByUsername(String username);

    UtsAuthor findByMail(String mail);

    @Query("update UtsAuthor ua set ua.mail = ?1 where ua.mail = ?1 ")
    int saveByMail(String mail);

    int countByUsername(String username);

    List<UtsAuthor> findByMailLikeAndUsernameLikeAndNicknameLike(String s, String s1, String s2);

    long countByNickname(String nickname);

    long countByMail(String mail);
}
