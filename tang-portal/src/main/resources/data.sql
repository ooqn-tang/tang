CREATE TABLE `dts_advertise`  (
  `advertise_id` varchar(32) NOT NULL PRIMARY KEY,
  `title` varchar(50) NULL DEFAULT NULL,
  `url` varchar(255) NULL DEFAULT NULL,
  `create_date` timestamp(0) NULL DEFAULT NULL,
  `description` varchar(255) NULL DEFAULT NULL
) ;

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

CREATE TABLE `dts_blog_subject`  (
  `blog_subject_id` varchar(32) NOT NULL PRIMARY KEY,
  `subject_name` varchar(35) NOT NULL COMMENT '标题',
  `author_id` varchar(32) NOT NULL COMMENT '作者ID',
  `order_num` int(0) DEFAULT 0 COMMENT '排序号码',
  `create_date` timestamp(0) NOT NULL COMMENT '创建时间',
  `update_date` timestamp(0) NOT NULL COMMENT '更新时间',
  `synopsis` varchar(1000) NULL DEFAULT NULL
) ;

CREATE TABLE `dts_blog_subject_relation`  (
  `blog_subject_relation_id` varchar(32) NOT NULL PRIMARY KEY,
  `blog_subject_id` varchar(32) NOT NULL COMMENT '专题ID',
  `blog_id` varchar(32) NOT NULL COMMENT '博客ID',
  `create_date` timestamp(0) NOT NULL COMMENT '创建时间',
  UNIQUE INDEX `dts_blog_subject_relation_unique`(`blog_subject_id`, `blog_id`) USING BTREE
) ;

CREATE TABLE `dts_blog_tag`(
  `blog_tag_id` varchar(32) NOT NULL PRIMARY KEY,
  `tag_name` varchar(10) NOT NULL COMMENT '标签名',
  `synopsis` varchar(1000) NULL DEFAULT NULL COMMENT '描述',
  `create_date` timestamp(0) DEFAULT NULL COMMENT '创建时间',
  UNIQUE INDEX `dts_blog_tag_unique`(`tag_name`) USING BTREE
) ;

CREATE TABLE `dts_blog_tag_relation`(
  `blog_tag_relation_id` varchar(32) NOT NULL PRIMARY KEY,
  `blog_id` varchar(32) NOT NULL COMMENT '博客ID',
  `blog_tag_id` varchar(32) NOT NULL COMMENT '博客标签ID',
  `create_date` timestamp(0) DEFAULT NULL COMMENT '创建时间'
) ;

CREATE TABLE `dts_blog_tag_author_relation`(
  `blog_tag_author_relation_id` varchar(32) NOT NULL PRIMARY KEY,
  `author_id` varchar(32) NOT NULL COMMENT '作者',
  `blog_tag_id` varchar(32) NOT NULL COMMENT '博客标签ID',
  `create_date` timestamp(0) DEFAULT NULL COMMENT '创建时间',
  UNIQUE INDEX `dts_blog_tag_author_relation_unique`(`author_id`, `blog_tag_id`) USING BTREE
) ;

CREATE TABLE `dts_blog_comment`  (
  `blog_comment_id` varchar(32) NOT NULL PRIMARY KEY,
  `blog_id` varchar(32) NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  `author_id` varchar(32) NULL DEFAULT NULL,
  `content` varchar(2000) NULL DEFAULT NULL,
  `create_date` timestamp(0) DEFAULT NULL
) ;

CREATE TABLE `dts_like_blog`  (
  `like_blog_id` varchar(32) NOT NULL PRIMARY KEY,
  `author_id` varchar(32) NULL DEFAULT NULL,
  `blog_id` varchar(32) NULL DEFAULT NULL,
  `create_date` timestamp(0) DEFAULT NULL,
  UNIQUE INDEX `dts_like_blog_unique`(`author_id`, `blog_id`) USING BTREE
) ;

CREATE TABLE `persistent_logins`  (
  `username` varchar(64) NOT NULL,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp(0) NOT NULL
) ;

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

CREATE TABLE `uts_author_role`  (
  `author_role_id` varchar(32) NOT NULL PRIMARY KEY,
  `author_id` varchar(32) NULL DEFAULT NULL,
  `role_id` varchar(32) NULL DEFAULT NULL,
  `create_time` timestamp(0) DEFAULT NULL
) ;

CREATE TABLE `uts_resource`  (
  `resource_id` varchar(32) NOT NULL PRIMARY KEY,
  `parent_id` varchar(255) NULL DEFAULT NULL COMMENT '父ID',
  `path` varchar(255) NULL DEFAULT NULL COMMENT '路径',
  `name` varchar(255) NULL DEFAULT NULL COMMENT '资源名',
  `level` varchar(255) NULL DEFAULT NULL COMMENT '资源所在节点,例,/为一级，/user为二级，/user/delete为三级',
  `type` varchar(255) NULL DEFAULT NULL COMMENT 'M：目录，C：菜单 ，A : 接口 。',
  `create_time` timestamp(0) DEFAULT NULL
) ;

CREATE TABLE `uts_resource_role`  (
  `resource_role_id` varchar(32) NOT NULL PRIMARY KEY,
  `resource_id` varchar(32) NULL DEFAULT NULL,
  `role_id` varchar(32) NULL DEFAULT NULL,
  `create_time` timestamp(0) DEFAULT NULL
) ;

CREATE TABLE `uts_role`  (
  `role_id` varchar(32) NOT NULL PRIMARY KEY COMMENT 'id',
  `role_name` varchar(255) NULL DEFAULT NULL COMMENT '中文名称',
  `role_value` varchar(255) NULL DEFAULT NULL COMMENT '角色值，需要为字母，推荐为中文拼音',
  `create_time` timestamp(0) DEFAULT NULL COMMENT '创建时间'
) ;

CREATE TABLE `uts_fans`  (
  `fans_id` varchar(32) NOT NULL PRIMARY KEY,
  `be_author_id` varchar(32) NOT NULL,
  `author_id` varchar(32) NOT NULL,
  `create_date` timestamp(0) DEFAULT NULL,
  UNIQUE INDEX `uts_fans_unique`(`be_author_id`, `author_id`) USING BTREE
) ;

CREATE TABLE `sts_config`  (
  `config_id` varchar(32) NOT NULL PRIMARY KEY,
  `config_name` varchar(32) NOT NULL,
  `data` varchar(32) NOT NULL,
  `create_date` timestamp(0) DEFAULT NULL
) ;

CREATE TABLE `persistent_logins` (
  `username` varchar(64) NOT NULL PRIMARY KEY,
  `series` varchar(64) NOT NULL,
  `token` varchar(64) NOT NULL,
  `last_used` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP
)


INSERT INTO DTS_BLOG (BLOG_ID ,TITLE ,AUTHOR_ID ,CREATE_DATE ,UPDATE_DATE ,STATE_CODE ,TEXT ,MARKDOWN ,SYNOPSIS )
VALUES('1', 'titile1', '1', '2020-08-08', '2020-08-08', '1001', '啊手动阀手动阀手动阀', 'asdfasdfxzcvczxv手动阀手动阀', '啊手动阀手动阀手动阀');

INSERT INTO DTS_BLOG (BLOG_ID ,TITLE ,AUTHOR_ID ,CREATE_DATE ,UPDATE_DATE ,STATE_CODE ,TEXT ,MARKDOWN ,SYNOPSIS )
VALUES('2', 'titile2', '1', '2020-08-08', '2020-08-08', '1001', '啊手动阀手动阀手动阀', '啊手动阀手动阀', '啊手动阀手动阀第三方');

INSERT INTO DTS_BLOG (BLOG_ID ,TITLE ,AUTHOR_ID ,CREATE_DATE ,UPDATE_DATE ,STATE_CODE ,TEXT ,MARKDOWN ,SYNOPSIS )
VALUES('3', 'titile3', '1', '2020-08-08', '2020-08-08', '1001', '阿斯顿法定', '啊手动阀手动阀手动阀', '啊手动阀手动阀手动阀');

INSERT INTO DTS_BLOG (BLOG_ID ,TITLE ,AUTHOR_ID ,CREATE_DATE ,UPDATE_DATE ,STATE_CODE ,TEXT ,MARKDOWN ,SYNOPSIS )
VALUES('4', 'titile4', '1', '2020-08-08', '2020-08-08', '1001', '对方对方的', '啊手动阀手动阀手动阀', '阿斯顿发射点发大水');

INSERT INTO DTS_BLOG (BLOG_ID ,TITLE ,AUTHOR_ID ,CREATE_DATE ,UPDATE_DATE ,STATE_CODE ,TEXT ,MARKDOWN ,SYNOPSIS )
VALUES('5', 'titile5', '1', '2020-08-08', '2020-08-08', '1001', '而微软微软为', '啊手动阀手动阀手动阀', '啊手动阀手动阀第三方');

INSERT INTO UTS_AUTHOR (AUTHOR_ID,USERNAME,NICKNAME ,PASSWORD ,MAIL ,SIGNATURE)
VALUES('1', 'leilei', 'leilei', '$2a$10$VjmkydqQA/bywWXNRx4ZgO26EiFzuaBxHozcV1yFTD357Zk3dnCl2', '792190997@qq.com', '而微软微软为');

INSERT INTO UTS_AUTHOR (AUTHOR_ID,USERNAME,NICKNAME ,PASSWORD ,MAIL ,SIGNATURE)
VALUES('2', 'lei', 'lei', '$2a$10$VjmkydqQA/bywWXNRx4ZgO26EiFzuaBxHozcV1yFTD357Zk3dnCl2', '1604403854@qq.com', '而微软微软为');

INSERT INTO dts_blog_subject (blog_subject_id,subject_name,author_id ,create_date ,update_date ,synopsis)
VALUES('1', '不得了的专题', '1', '2020-01-01', '2020-01-01', '打发士大夫拉省的分厘卡十六点爱丽丝的开发');


insert into DTS_BLOG_TAG (blog_tag_id,tag_name,create_date) values ('13','Java','2021-05-25 16:52:15');
insert into DTS_BLOG_TAG (blog_tag_id,tag_name,create_date) values ('14','Python','2021-05-25 16:52:15');
insert into DTS_BLOG_TAG (blog_tag_id,tag_name,create_date) values ('15','Web前端','2021-05-25 16:52:15');
insert into DTS_BLOG_TAG (blog_tag_id,tag_name,create_date) values ('16','Android','2021-05-25 16:52:15');
insert into DTS_BLOG_TAG (blog_tag_id,tag_name,create_date) values ('17','数据库','2021-05-25 16:52:15');
insert into DTS_BLOG_TAG (blog_tag_id,tag_name,create_date) values ('18','面试','2021-05-25 16:52:15');
insert into DTS_BLOG_TAG (blog_tag_id,tag_name,create_date) values ('19','算法','2021-05-25 16:52:15');
insert into DTS_BLOG_TAG (blog_tag_id,tag_name,create_date) values ('20','故事','2021-05-25 16:52:15');
insert into DTS_BLOG_TAG (blog_tag_id,tag_name,create_date) values ('21','开源项目','2021-05-25 16:52:15');

insert into dts_advertise(advertise_id,title,url,create_date,description) values ('1','Java从入门到精通','http://www.baidu.com','2021-05-25 16:52:15','');
insert into dts_advertise(advertise_id,title,url,create_date,description) values ('2','一个不得的人物','http://www.baidu.com','2021-05-25 16:52:15','');
insert into dts_advertise(advertise_id,title,url,create_date,description) values ('3','尽快答复金卡ask的风景','http://www.baidu.com','2021-05-25 16:52:15','');
insert into dts_advertise(advertise_id,title,url,create_date,description) values ('4','啊手动阀手动阀','http://www.baidu.com','2021-05-25 16:52:15','');
insert into dts_advertise(advertise_id,title,url,create_date,description) values ('5','Java从入门到精通','http://www.baidu.com','2021-05-25 16:52:15','');
insert into dts_advertise(advertise_id,title,url,create_date,description) values ('6','额外人情味人情味人情味若','http://www.baidu.com','2021-05-25 16:52:15','');
insert into dts_advertise(advertise_id,title,url,create_date,description) values ('7','自行车v自行车v自行车v','http://www.baidu.com','2021-05-25 16:52:15','');
insert into dts_advertise(advertise_id,title,url,create_date,description) values ('8','苏打粉倒入太温柔','http://www.baidu.com','2021-05-25 16:52:15','');
insert into dts_advertise(advertise_id,title,url,create_date,description) values ('9','广泛广泛广泛广泛','http://www.baidu.com','2021-05-25 16:52:15','');
