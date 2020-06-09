package net.ttcxy.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import net.ttcxy.model.BlogComment;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author ：huanglei
 * @date ：2020/4/18 0018 15:14
 */
@Getter
@Setter
@ToString
@EqualsAndHashCode
public class CommentDto extends BlogComment {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern="yyyy.MM.dd",timezone = "GMT+8")
    private Date createDate;

    private String username;

    private String nickname;

}
