package net.ttcxy.tangtang.entity.params;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;


/**
 * 修改，添加博客需要的参数
 */
@Data
public class BlogParam {

    private String id;

    @NotNull
    @Length(min = 1,message = "长度不能小于1")
    private String title;

    @NotNull
    @Length(min = 1,message = "长度不能小于1")
    private String text;

    @NotNull
    @Length(min = 1,message = "长度不能小于1")
    private String markdown;

    private String stateId;

    private String userId;

    @NotNull
    private String classId;

}
