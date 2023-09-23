package com.ooqn.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ooqn.entity.model.UtsAuthor;

public interface UtsAuthorRepository extends CrudRepository<UtsAuthor, String> {

    @Query("select new UtsAuthor(ua.username,ua.nickname) From UtsAuthor ua where ua.authorId = ?1")
    Optional<UtsAuthor> findUsernameNicknameByAuthorId(String authorId);

    UtsAuthor findByUsername(String username);

    UtsAuthor findByMail(String mail);

    @Query("update UtsAuthor ua set ua.mail = ?1 where ua.mail = ?1 ")
    int saveByMail(String mail);

    int countByUsername(String username);

    @Query("From UtsAuthor ua where ua.nickname like %?1% or ua.username like %?1% or ua.nickname like %?1%")
    List<UtsAuthor> findByMailLikeOrUsernameLikeOrNicknameLike(String queryData);

    long countByNickname(String nickname);

    long countByMail(String mail);

    Page<UtsAuthor> findAll(Pageable pageable);
}
