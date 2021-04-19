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
-- Table structure for dts_favorite
-- ----------------------------
DROP TABLE IF EXISTS `dts_favorite`;
CREATE TABLE `dts_favorite` (
  `favorite_id` varchar(32) NOT NULL PRIMARY KEY,
  `author_id` varchar(32) NULL DEFAULT NULL,
  `blog_id` varchar(32) NULL DEFAULT NULL,
  `create_date` timestamp(0) DEFAULT NULL,
  UNIQUE INDEX `dts_favorite_unique_some_name`(`author_id`, `blog_id`) USING BTREE
);

-- ----------------------------
-- Table structure for dts_like_data
-- ----------------------------
DROP TABLE IF EXISTS `dts_like_data`;
CREATE TABLE `dts_like_data`  (
  `like_data_id` varchar(32) NOT NULL PRIMARY KEY,
  `author_id` varchar(32) NULL DEFAULT NULL,
  `blog_id` varchar(32) NULL DEFAULT NULL,
  `create_date` timestamp(0) DEFAULT NULL
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
-- Table structure for sts_state
-- ----------------------------
DROP TABLE IF EXISTS `sts_state`;
CREATE TABLE `sts_state`  (
  `state_id` int(0) NOT NULL PRIMARY KEY,
  `code` varchar(255) NULL DEFAULT NULL COMMENT '全局唯一状态码',
  `value` varchar(255) NULL DEFAULT NULL COMMENT '值',
  `comment` varchar(255) NULL DEFAULT NULL COMMENT '描述'
) ;

-- ----------------------------
-- Table structure for sts_visit_log
-- ----------------------------
DROP TABLE IF EXISTS `sts_visit_log`;
CREATE TABLE `sts_visit_log`  (
  `visit_log_id` int(0) NOT NULL PRIMARY KEY,
  `path` varchar(255) NULL DEFAULT NULL COMMENT '路径',
  `ip_addr` varchar(255) NULL DEFAULT NULL COMMENT 'IP',
  `member_id` int(0) NULL DEFAULT NULL COMMENT '成员ID',
  `create_date` timestamp(0) DEFAULT NULL COMMENT '创建时间'
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
-- Table structure for uts_fans
-- ----------------------------
DROP TABLE IF EXISTS `uts_fans`;
CREATE TABLE `uts_fans`  (
  `fans_id` varchar(32) NOT NULL PRIMARY KEY,
  `author_id` varchar(32) NOT NULL,
  `follower` varchar(255) NOT NULL,
  `create_date` timestamp(0) DEFAULT NULL,
  UNIQUE INDEX `uts_fans_unique_author_id`(`author_id`, `follower`) USING BTREE
) ;

-- ----------------------------
-- Table structure for uts_login_log
-- ----------------------------
DROP TABLE IF EXISTS `uts_login_log`;
CREATE TABLE `uts_login_log`  (
  `login_log_id` int(0) NOT NULL PRIMARY KEY
) ;

-- ----------------------------
-- Table structure for uts_member
-- ----------------------------
DROP TABLE IF EXISTS `uts_member`;
CREATE TABLE `uts_member`  (
  `member_id` varchar(32) NOT NULL PRIMARY KEY,
  `username` varchar(255) NOT NULL COMMENT '用户名',
  `nickname` varchar(255) NULL DEFAULT NULL COMMENT '昵称',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `mail` varchar(255) NULL DEFAULT NULL COMMENT '邮箱号',
  `state` int(0) NULL DEFAULT NULL COMMENT '1001:发布，1002：草稿，1003:审核,1004:删除',
  `signature` varchar(255) NULL DEFAULT NULL COMMENT '简介',
  UNIQUE INDEX `uts_member_unique_username`(`username`) USING BTREE,
  UNIQUE INDEX `uts_member_unique_nickname`(`nickname`) USING BTREE,
  UNIQUE INDEX `uts_member_unique_mail`(`mail`) USING BTREE
) ;

-- ----------------------------
-- Table structure for uts_member_role
-- ----------------------------
DROP TABLE IF EXISTS `uts_member_role`;
CREATE TABLE `uts_member_role`  (
  `member_role_id` varchar(32) NOT NULL PRIMARY KEY,
  `member_id` varchar(32) NULL DEFAULT NULL,
  `role_id` varchar(32) NULL DEFAULT NULL,
  `create_time` timestamp(0) DEFAULT NULL
) ;

-- ----------------------------
-- Table structure for uts_member_state
-- ----------------------------
DROP TABLE IF EXISTS `uts_member_state`;
CREATE TABLE `uts_member_state`  (
  `member_state_id` int(0) NOT NULL PRIMARY KEY,
  `name` varchar(255) NULL DEFAULT NULL,
  `create_date` timestamp(0) DEFAULT NULL
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