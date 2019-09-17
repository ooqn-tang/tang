package net.ttcxy.tangtang.entity.params;

import lombok.Data;
import net.ttcxy.tangtang.entity.User;

import java.util.List;

@Data
public class ViboParam {

    //String ID
    private String id;

    //作者
    private User user;

    //内容
    private String text;

    //图片 links
    private List<String> ImageLinks;

    //绑定Link
    private String link;

    //评论数
    private Integer commentCount;

    //点赞数
    private Integer praiseCount;
}
