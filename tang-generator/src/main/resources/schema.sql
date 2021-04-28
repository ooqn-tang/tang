



-- ----------------------------
-- Table structure for dts_advertise
-- ----------------------------
DROP TABLE IF EXISTS `dts_advertise`;
CREATE TABLE `dts_advertise`  (
  `advertise_id` varchar(32) NOT NULL PRIMARY KEY,
  `title` varchar(50) NULL DEFAULT NULL,
  `url` varchar(255) NULL DEFAULT NULL,
  `create_date` timestamp(0) NULL DEFAULT NULL,
  `delivery_time` int(0) NULL DEFAULT NULL,
  `description` varchar(255) NULL DEFAULT NULL
) ;

-- ----------------------------
-- Table structure for dts_blog
-- ----------------------------
DROP TABLE IF EXISTS `dts_blog`;
CREATE TABLE `dts_blog`  (
  `blog_id` varchar(32) NOT NULL PRIMARY KEY,
  `title` varchar(35) NULL DEFAULT NULL COMMENT '博客标题',
  `author_id` varchar(32) NULL DEFAULT NULL COMMENT '作者ID',
  `create_date` timestamp(0) DEFAULT NULL COMMENT '创建时间',
  `update_date` timestamp(0) DEFAULT NULL COMMENT '更新时间',
  `state_code` int(0) NULL DEFAULT 1002 COMMENT '状态ID,发布状态，草稿状态，退回状态，删除状态',
  `text` mediumtext NULL COMMENT '博文文本',
  `markdown` mediumtext NULL COMMENT 'markdown',
  `synopsis` varchar(1000) NULL DEFAULT NULL
) ;

-- ------------------------------------
-- Table structure for dts_blog_subject
-- ------------------------------------
DROP TABLE IF EXISTS `dts_blog_subject`;
CREATE TABLE `dts_blog_subject`  (
  `blog_subject_id` varchar(32) NOT NULL PRIMARY KEY,
  `subject_name` varchar(35) NOT NULL COMMENT '标题',
  `author_id` varchar(32) NOT NULL COMMENT '作者ID',
  `create_date` timestamp(0) NOT NULL COMMENT '创建时间',
  `update_date` timestamp(0) NOT NULL COMMENT '更新时间',
  `synopsis` varchar(1000) NULL DEFAULT NULL
) ;

-- ---------------------------------------------
-- Table structure for dts_blog_subject_relation
-- ---------------------------------------------
DROP TABLE IF EXISTS `dts_blog_subject_relation`;
CREATE TABLE `dts_blog_subject_relation`  (
  `blog_subject_relation_id` varchar(32) NOT NULL PRIMARY KEY,
  `blog_subject_id` varchar(32) NOT NULL COMMENT '专题ID',
  `blog_id` varchar(32) NOT NULL COMMENT '博客ID',
  `create_date` timestamp(0) NOT NULL COMMENT '创建时间',
  UNIQUE INDEX `dts_blog_subject_relation`(`blog_subject_id`, `blog_id`) USING BTREE
) ;

-- --------------------------------
-- Table structure for dts_blog_tag
-- --------------------------------
DROP TABLE IF EXISTS `dts_blog_tag`;
CREATE TABLE `dts_blog_tag`(
  `blog_tag_id` varchar(32) NOT NULL PRIMARY KEY,
  `tag_name` varchar(10) NOT NULL COMMENT '标签名',
  `synopsis` varchar(1000) NOT NULL COMMENT '描述',
  `create_date` timestamp(0) DEFAULT NULL COMMENT '创建时间'
) ;

-- --------------------------------
-- Table structure for dts_blog_tag_relation
-- --------------------------------
DROP TABLE IF EXISTS `dts_blog_tag_relation`;
CREATE TABLE `dts_blog_tag_relation`(
  `blog_tag_relation_id` varchar(32) NOT NULL PRIMARY KEY,
  `blog_id` varchar(32) NOT NULL COMMENT '博客ID',
  `blog_tag_id` varchar(32) NOT NULL COMMENT '博客标签ID',
  `create_date` timestamp(0) DEFAULT NULL COMMENT '创建时间'
) ;


-- ----------------------------
-- Table structure for dts_blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `dts_blog_comment`;
CREATE TABLE `dts_blog_comment`  (
  `blog_comment_id` varchar(32) NOT NULL PRIMARY KEY,
  `blog_id` varchar(32) NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  `author_id` varchar(32) NULL DEFAULT NULL,
  `content` varchar(2000) NULL DEFAULT NULL,
  `create_date` timestamp(0) DEFAULT NULL
) ;



-- ----------------------------
-- Table structure for dts_like_blog
-- ----------------------------
DROP TABLE IF EXISTS `dts_like_blog`;
CREATE TABLE `dts_like_blog`  (
  `like_blog_id` varchar(32) NOT NULL PRIMARY KEY,
  `author_id` varchar(32) NULL DEFAULT NULL,
  `blog_id` varchar(32) NULL DEFAULT NULL,
  `create_date` timestamp(0) DEFAULT NULL,
  UNIQUE INDEX `dts_like_blog_unique`(`author_id`, `blog_id`) USING BTREE
) ;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp(0) NOT NULL
) ;

-- ----------------------------
-- Table structure for uts_author
-- ----------------------------
DROP TABLE IF EXISTS `uts_author`;
CREATE TABLE `uts_author`  (
  `author_id` varchar(32) NOT NULL PRIMARY KEY,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `nickname` varchar(255) NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `mail` varchar(255) NULL DEFAULT NULL COMMENT '邮箱号',
  `signature` varchar(255) NULL DEFAULT NULL COMMENT '简介',
  UNIQUE INDEX `uts_author_unique_username`(`username`) USING BTREE,
  UNIQUE INDEX `uts_author_unique_nickname`(`nickname`) USING BTREE,
  UNIQUE INDEX `uts_author_unique_mail`(`mail`) USING BTREE
) ;

-- ----------------------------
-- Table structure for uts_author_role
-- ----------------------------
DROP TABLE IF EXISTS `uts_author_role`;
CREATE TABLE `uts_author_role`  (
  `author_role_id` varchar(32) NOT NULL PRIMARY KEY,
  `author_id` varchar(32) NULL DEFAULT NULL,
  `role_id` varchar(32) NULL DEFAULT NULL,
  `create_time` timestamp(0) DEFAULT NULL
) ;

-- ----------------------------
-- Table structure for uts_resource
-- ----------------------------
DROP TABLE IF EXISTS `uts_resource`;
CREATE TABLE `uts_resource`  (
  `resource_id` varchar(32) NOT NULL PRIMARY KEY,
  `parent_id` varchar(255) NULL DEFAULT NULL COMMENT '父ID',
  `path` varchar(255) NULL DEFAULT NULL COMMENT '路径',
  `name` varchar(255) NULL DEFAULT NULL COMMENT '资源名',
  `level` varchar(255) NULL DEFAULT NULL COMMENT '资源所在节点,例,/为一级，/user为二级，/user/delete为三级',
  `type` varchar(255) NULL DEFAULT NULL COMMENT 'M：目录，C：菜单 ，A : 接口 。',
  `create_time` timestamp(0) DEFAULT NULL
) ;

-- ----------------------------
-- Table structure for uts_resource_role
-- ----------------------------
DROP TABLE IF EXISTS `uts_resource_role`;
CREATE TABLE `uts_resource_role`  (
  `resource_role_id` varchar(32) NOT NULL PRIMARY KEY,
  `resource_id` varchar(32) NULL DEFAULT NULL,
  `role_id` varchar(32) NULL DEFAULT NULL,
  `create_time` timestamp(0) DEFAULT NULL
) ;

-- ----------------------------
-- Table structure for uts_role
-- ----------------------------
DROP TABLE IF EXISTS `uts_role`;
CREATE TABLE `uts_role`  (
  `role_id` varchar(32) NOT NULL PRIMARY KEY COMMENT 'id',
  `role_name` varchar(255) NULL DEFAULT NULL COMMENT '中文名称',
  `role_value` varchar(255) NULL DEFAULT NULL COMMENT '角色值，需要为字母，推荐为中文拼音',
  `create_time` timestamp(0) DEFAULT NULL COMMENT '创建时间'
) ;

-- ----------------------------
-- Table structure for uts_fans
-- ----------------------------
DROP TABLE IF EXISTS `uts_fans`;
CREATE TABLE `uts_fans`  (
  `fans_id` varchar(32) NOT NULL PRIMARY KEY,
  `be_author_id` varchar(32) NOT NULL,
  `author_id` varchar(32) NOT NULL,
  `create_date` timestamp(0) DEFAULT NULL,
  UNIQUE INDEX `uts_fans_unique`(`be_author_id`, `author_id`) USING BTREE
) ;