package cn.ttcxy.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import cn.ttcxy.entity.model.UtsAuthor;

public interface UtsAuthorRepository extends CrudRepository<UtsAuthor, String> {

    UtsAuthor findByUsername(String username);

    UtsAuthor findByMail(String mail);

    @Query("update UtsAuthor ua set ua.mail = ?1 where ua.mail = ?1 ")
    int saveByMail(String mail);

    int countByUsername(String username);

    List<UtsAuthor> findByMailLikeAndUsernameLikeAndNicknameLike(String mailLike, String username, String nicknameLike);

    long countByNickname(String nickname);

    long countByMail(String mail);

    Page<UtsAuthor> findAll(Pageable pageable);
}
