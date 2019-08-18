表：
    entity_blog `博客表`            
    entity_blog_class`博客类型`
    entity_blog_comment`评论表`
    entity_blog_state`状态`

    entity_cyun`收藏表`
    entity_cyun_class`类型`
    entity_cyun_comment`评论表`
    entity_cyun_state`状态`

    entity_user`用户表`
    entity_user_class`用户类型`
    entity_user_state`状态`

    entity_vibo`微博`
    entity_vibo_class`微博类型`
    entity_vibo_comment`评论表`
    entity_vibo_state`状态`

    entity_vlog`视频`
    entity_vlog_class`视频类型`
    entity_vlog_comment`评论表`
    entity_vlog_state`状态`

    persistent_logins `用户免登录表`

### 设计表注意事项
1.尽量不要与其他模块共用表格

2.ID使用Hutool工具类的生成无分隔符的UUID`IdUtil.fastSimpleUUID()`