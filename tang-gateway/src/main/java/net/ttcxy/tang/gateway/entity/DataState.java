package net.ttcxy.tang.gateway.entity;

public class DataState {
    // 博客 ============================================================================
    /**
     * 发布状态
     */
    public static final Integer BLOG_RELEASE = 1001;
    /**
     * 草稿状态
     */
    public static final Integer BLOG_DRAFT = 1002;
    /**
     * 未发布状态
     */
    public static final Integer BLOG_NOT_RELEASE = 1003;
    /**
     * 删除状态博客
     */
    public static final Integer BLOG_DELETE = 1004;
    // 评论 ============================================================================
    /**
     * 评论 发布状态
     */
    public static final Integer COMMENT_RELEASE = 2001;
    /**
     * 评论 草稿状态
     */
    public static final Integer COMMENT_DRAFT = 2002;
    /**
     * 评论 未发布状态
     */
    public static final Integer COMMENT_NOT_RELEASE = 2003;
    /**
     * 评论 删除状态
     */
    public static final Integer COMMENT_DELETE = 2004;

}
