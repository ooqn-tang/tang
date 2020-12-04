/*
 Navicat Premium Data Transfer

 Source Server         : 106.54.189.191
 Source Server Type    : MySQL
 Source Server Version : 80019
 Source Host           : 106.54.189.191:3306
 Source Schema         : tang-3

 Target Server Type    : MySQL
 Target Server Version : 80019
 File Encoding         : 65001

 Date: 04/12/2020 17:16:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dts_advertise
-- ----------------------------
DROP TABLE IF EXISTS `dts_advertise`;
CREATE TABLE `dts_advertise`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_date` timestamp(0) NULL DEFAULT NULL,
  `delivery_time` int(0) NULL DEFAULT NULL,
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dts_advertise
-- ----------------------------
INSERT INTO `dts_advertise` VALUES ('10', '公众号推荐列表', 'http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba', '2020-06-11 15:58:38', 1, NULL);
INSERT INTO `dts_advertise` VALUES ('11', '好用的教程', 'http://www.ttcxy.net/post/98d9f0454fe34b9589e36cdcfc45e02f', '2020-06-11 15:58:41', 2, NULL);
INSERT INTO `dts_advertise` VALUES ('4', '可能是目前为止最好的QQ群列表\r\n', 'http://www.ttcxy.net/post/461196615cb14caaad4cbb58e82c58e6', '2020-06-11 15:58:42', 3, '没有问题');
INSERT INTO `dts_advertise` VALUES ('5', '堂堂程序员.公众号', 'http://www.ttcxy.net/post/098384e9a34d438480289ad23c8625ba', '2020-06-11 15:58:42', 4, '没有问题');
INSERT INTO `dts_advertise` VALUES ('6', '帮忙Github点个❤好不好', 'https://github.com/one-few/tang', '2020-06-18 09:48:20', 5, '问');
INSERT INTO `dts_advertise` VALUES ('7', '不仅仅是Java面试宝典', 'http://www.ttcxy.net/post/d313651c1ff04f85b6f6a9c45580a79c', '2020-06-11 15:58:44', 6, NULL);
INSERT INTO `dts_advertise` VALUES ('8', '不错的开源项目', 'https://github.com/macrozheng/mall', '2020-06-11 15:58:45', 7, NULL);
INSERT INTO `dts_advertise` VALUES ('9', '开源项目推荐列表', 'http://www.ttcxy.net/post/5fad0cad5e5f46f0880799fa9b4cffb7', '2020-06-11 15:58:49', 8, NULL);

-- ----------------------------
-- Table structure for dts_blog
-- ----------------------------
DROP TABLE IF EXISTS `dts_blog`;
CREATE TABLE `dts_blog`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `title` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  `update_date` datetime(0) NULL DEFAULT NULL,
  `state_id` int(0) NULL DEFAULT NULL COMMENT '1 发布 2 草稿 3 删除',
  `text` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  `markdown` longtext CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dts_blog
-- ----------------------------
INSERT INTO `dts_blog` VALUES ('13b528323cfe4c79aa6926f2bcfc78fb', '都督1ssss', '6593b9af5636415db6fe8801e1ca6b30', '2020-12-03 12:45:36', '2020-12-04 01:02:18', 1, '<p>顶顶顶</p>\n', '顶顶顶');
INSERT INTO `dts_blog` VALUES ('271b3c23484f4e5aaeb6e63ba6776cec', 'asdfasdfasdf', '6593b9af5636415db6fe8801e1ca6b30', '2020-10-01 10:06:11', '2020-10-01 10:06:11', 1, '<p>asdfasdfasdfasdf</p>\n', 'asdfasdfasdfasdf');
INSERT INTO `dts_blog` VALUES ('3311f976fcba48d392bea54c44b9c592', NULL, '6593b9af5636415db6fe8801e1ca6b30', '2020-12-04 02:03:48', '2020-12-04 02:03:48', 2, NULL, NULL);
INSERT INTO `dts_blog` VALUES ('34599ad6cc724b14a1c4ec7cc22428af', 'leilei', 'c82856bcb7014cd6a6a47a0e00736fc2', '2020-09-24 13:03:02', '2020-09-24 13:03:02', 1, '<p>bobobo</p>\n<h1 id=\"dfjdk-aksdjfaksdj-fasdfasdf\">dfjdk aksdjfaksdj fasdfasdf</h1>\n', 'bobobo\n# dfjdk aksdjfaksdj fasdfasdf');
INSERT INTO `dts_blog` VALUES ('35af07dbc45b4687886d558354bb0188', 'qwerqwerqwe', '6593b9af5636415db6fe8801e1ca6b30', '2020-10-31 11:30:07', '2020-10-31 11:30:07', 1, '<p>qwerqwerqwer</p>\n', 'qwerqwerqwer');
INSERT INTO `dts_blog` VALUES ('5776e9366eb44463a65a65576858807a', 'asdf', '6593b9af5636415db6fe8801e1ca6b30', '2020-12-03 12:36:10', '2020-12-03 12:36:10', 1, '<p>asdfadsf</p>\n', 'asdfadsf');
INSERT INTO `dts_blog` VALUES ('878104bc44244994b8695df1ccf12243', 'ss', '6593b9af5636415db6fe8801e1ca6b30', '2020-12-03 12:42:50', '2020-12-03 12:42:50', 1, '<p>ss</p>\n', 'ss');
INSERT INTO `dts_blog` VALUES ('87ed916f753848b1b74eb2ec0dce0f31', 'asdfasdf', '6593b9af5636415db6fe8801e1ca6b30', '2020-12-03 12:07:10', '2020-12-03 12:07:10', 1, '<p>asdfasdf</p>\n', 'asdfasdf');
INSERT INTO `dts_blog` VALUES ('a0a55f5a7b6245e5bcebf138ad842f6c', 'asdfasdfasdf', '6593b9af5636415db6fe8801e1ca6b30', '2020-10-01 10:06:07', '2020-10-01 10:06:07', 1, '<p>asdfasdfasdfasdf</p>\n', 'asdfasdfasdfasdf');
INSERT INTO `dts_blog` VALUES ('b0191087ea4c4677995d8c32520d586d', 'ddd', '6593b9af5636415db6fe8801e1ca6b30', '2020-12-03 12:43:47', '2020-12-03 12:43:47', 1, '<p>ddd</p>\n', 'ddd');
INSERT INTO `dts_blog` VALUES ('d05f2198e62646d89f379e4237480fe0', '啊手动阀手动阀啊手动阀手动阀', 'c82856bcb7014cd6a6a47a0e00736fc2', '2020-09-24 15:56:39', '2020-09-24 15:56:39', 1, '<p><img src=\"/obj/8f204ecbdaf24ae69d3b3360206bc689.png\" alt=\"图片片\"><br><img src=\"/obj/8f204ecbdaf24ae69d3b3360206bc689.png\" alt=\"图片片\"><br><img src=\"/obj/8f204ecbdaf24ae69d3b3360206bc689.png\" alt=\"图片片\"><br><img src=\"/obj/8f204ecbdaf24ae69d3b3360206bc689.png\" alt=\"图片片\"><br><img src=\"/obj/8f204ecbdaf24ae69d3b3360206bc689.png\" alt=\"图片片\"><br><img src=\"/obj/8f204ecbdaf24ae69d3b3360206bc689.png\" alt=\"图片片\"><br><img src=\"/obj/8f204ecbdaf24ae69d3b3360206bc689.png\" alt=\"图片片\"><br><img src=\"/obj/8f204ecbdaf24ae69d3b3360206bc689.png\" alt=\"图片片\"><br><img src=\"/obj/8f204ecbdaf24ae69d3b3360206bc689.png\" alt=\"图片片\"></p>\n', '![图片片](/obj/8f204ecbdaf24ae69d3b3360206bc689.png)\n![图片片](/obj/8f204ecbdaf24ae69d3b3360206bc689.png)\n![图片片](/obj/8f204ecbdaf24ae69d3b3360206bc689.png)\n![图片片](/obj/8f204ecbdaf24ae69d3b3360206bc689.png)\n![图片片](/obj/8f204ecbdaf24ae69d3b3360206bc689.png)\n![图片片](/obj/8f204ecbdaf24ae69d3b3360206bc689.png)\n![图片片](/obj/8f204ecbdaf24ae69d3b3360206bc689.png)\n![图片片](/obj/8f204ecbdaf24ae69d3b3360206bc689.png)\n![图片片](/obj/8f204ecbdaf24ae69d3b3360206bc689.png)');
INSERT INTO `dts_blog` VALUES ('dc01d9cfd8b948ca966be5406fb93257', 'asdfasdfasdf', '6593b9af5636415db6fe8801e1ca6b30', '2020-10-01 10:06:14', '2020-10-01 10:06:14', 1, '<p>asdfasdfasdfasdf</p>\n', 'asdfasdfasdfasdf');
INSERT INTO `dts_blog` VALUES ('ee14c427228b497ebc16c1cea32f9d1d', 'asdfadsfasdf', '6593b9af5636415db6fe8801e1ca6b30', '2020-10-01 10:16:46', '2020-10-01 10:16:46', 1, '<p><img src=\"/obj/88cc742630724ee09e52fa4c05833643.png\" alt=\"\"><br><img src=\"/obj/88cc742630724ee09e52fa4c05833643.png\" alt=\"\"><br><img src=\"/obj/88cc742630724ee09e52fa4c05833643.png\" alt=\"\"><br><img src=\"/obj/88cc742630724ee09e52fa4c05833643.png\" alt=\"\"><br><img src=\"/obj/88cc742630724ee09e52fa4c05833643.png\" alt=\"\"><br><img src=\"/obj/88cc742630724ee09e52fa4c05833643.png\" alt=\"\"><br><img src=\"/obj/88cc742630724ee09e52fa4c05833643.png\" alt=\"\"><br><img src=\"/obj/88cc742630724ee09e52fa4c05833643.png\" alt=\"\"></p>\n', '![](/obj/88cc742630724ee09e52fa4c05833643.png)\n![](/obj/88cc742630724ee09e52fa4c05833643.png)\n![](/obj/88cc742630724ee09e52fa4c05833643.png)\n![](/obj/88cc742630724ee09e52fa4c05833643.png)\n![](/obj/88cc742630724ee09e52fa4c05833643.png)\n![](/obj/88cc742630724ee09e52fa4c05833643.png)\n![](/obj/88cc742630724ee09e52fa4c05833643.png)\n![](/obj/88cc742630724ee09e52fa4c05833643.png)');
INSERT INTO `dts_blog` VALUES ('efcb3dba11ce4d8abbf4fcc4352d245d', NULL, '', '2020-12-03 15:31:19', '2020-12-03 15:31:19', 2, NULL, NULL);

-- ----------------------------
-- Table structure for dts_blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `dts_blog_comment`;
CREATE TABLE `dts_blog_comment`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `blog_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `status` int(0) NULL DEFAULT NULL,
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dts_blog_comment
-- ----------------------------
INSERT INTO `dts_blog_comment` VALUES ('02d4c1f48e114adf9c95051444b79b86', '13b528323cfe4c79aa6926f2bcfc78fb', 1, '6593b9af5636415db6fe8801e1ca6b30', 'nbbnmbnmbnmbnmbnm', '2020-12-04 01:56:39');
INSERT INTO `dts_blog_comment` VALUES ('11ccd77b15634179aa7bfdacfde037d2', 'd05f2198e62646d89f379e4237480fe0', 1, '6593b9af5636415db6fe8801e1ca6b30', 'asdfasdf', '2020-10-31 11:24:56');
INSERT INTO `dts_blog_comment` VALUES ('1a66ec1031764d41a1f2415a9c9af0ff', '34599ad6cc724b14a1c4ec7cc22428af', 1, '6593b9af5636415db6fe8801e1ca6b30', 'adfasdf', '2020-11-13 04:11:07');
INSERT INTO `dts_blog_comment` VALUES ('243a02c62a8a440cbec56b9a44ef9353', 'd05f2198e62646d89f379e4237480fe0', 1, '6593b9af5636415db6fe8801e1ca6b30', 'asdfasdf', '2020-10-31 11:24:54');
INSERT INTO `dts_blog_comment` VALUES ('316f056ce0f64d12ba2dc7ba554b69ce', '34599ad6cc724b14a1c4ec7cc22428af', 1, '6593b9af5636415db6fe8801e1ca6b30', 'asdfasdf', '2020-11-13 04:11:16');
INSERT INTO `dts_blog_comment` VALUES ('37d88e44c4a44a07b39f55c6b49bf1e3', '6a5f038a3959426fb988590bd85a81e5', 1, '6593b9af5636415db6fe8801e1ca6b30', 'obj', '2020-11-07 17:25:51');
INSERT INTO `dts_blog_comment` VALUES ('5b2ac245099341c8beb887d935185cf8', '34599ad6cc724b14a1c4ec7cc22428af', 1, '6593b9af5636415db6fe8801e1ca6b30', 'asdfasdf', '2020-11-13 04:11:12');
INSERT INTO `dts_blog_comment` VALUES ('5ff7981fd5794043a7cae58484094c97', '13b528323cfe4c79aa6926f2bcfc78fb', 1, '6593b9af5636415db6fe8801e1ca6b30', 'gfhghfhgfghjfgfhgjf', '2020-12-04 01:56:34');
INSERT INTO `dts_blog_comment` VALUES ('72e06aa95c2f4979bf96456c9f830da2', 'b195933b335942b9b8c2c42eeb523f62', 1, '6593b9af5636415db6fe8801e1ca6b30', '啊手动阀手动阀', '2020-11-07 11:28:04');
INSERT INTO `dts_blog_comment` VALUES ('76eac65b3a074129befe2b9b12d4e508', '6a5f038a3959426fb988590bd85a81e5', 1, '6593b9af5636415db6fe8801e1ca6b30', 'kkkk', '2020-11-07 17:25:46');
INSERT INTO `dts_blog_comment` VALUES ('9dc96e6995b64d43a9ad11659783f65e', 'd05f2198e62646d89f379e4237480fe0', 1, '6593b9af5636415db6fe8801e1ca6b30', '发士大夫啊手动阀手动阀啊手动阀手动阀啊手动阀手动阀啊手动阀手动阀啊手动阀手动阀', '2020-10-11 11:03:01');
INSERT INTO `dts_blog_comment` VALUES ('a94cc0f3f97648a8ad231c89c946e87a', '6a5f038a3959426fb988590bd85a81e5', 1, '6593b9af5636415db6fe8801e1ca6b30', 'ksjfkajksdf', '2020-11-07 17:25:42');
INSERT INTO `dts_blog_comment` VALUES ('ac1a8dc6aec94d8e87d1c003f4aadc80', '2c5a2db4467e4081af0b22fcae0cafd5', 1, '6593b9af5636415db6fe8801e1ca6b30', 'asdfasdf', '2020-10-31 12:20:41');
INSERT INTO `dts_blog_comment` VALUES ('b4e51f49d28940878421d7146687eb13', '34599ad6cc724b14a1c4ec7cc22428af', 1, '6593b9af5636415db6fe8801e1ca6b30', '啊手动阀手动阀', '2020-09-27 14:38:07');
INSERT INTO `dts_blog_comment` VALUES ('c6ea3217d8a24bfa95bf6137bbb98d0c', '34599ad6cc724b14a1c4ec7cc22428af', 1, '6593b9af5636415db6fe8801e1ca6b30', 'asdfadsf', '2020-11-13 04:10:54');

-- ----------------------------
-- Table structure for dts_favorite
-- ----------------------------
DROP TABLE IF EXISTS `dts_favorite`;
CREATE TABLE `dts_favorite`  (
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `blog_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dts_favorite
-- ----------------------------

-- ----------------------------
-- Table structure for dts_like_data
-- ----------------------------
DROP TABLE IF EXISTS `dts_like_data`;
CREATE TABLE `dts_like_data`  (
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `blog_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dts_like_data
-- ----------------------------
INSERT INTO `dts_like_data` VALUES ('c82856bcb7014cd6a6a47a0e00736fc2', 'd05f2198e62646d89f379e4237480fe0', '2020-09-25 13:01:34');
INSERT INTO `dts_like_data` VALUES ('6593b9af5636415db6fe8801e1ca6b30', 'd05f2198e62646d89f379e4237480fe0', '2020-09-29 15:38:19');
INSERT INTO `dts_like_data` VALUES ('6593b9af5636415db6fe8801e1ca6b30', 'ee14c427228b497ebc16c1cea32f9d1d', '2020-10-29 13:10:20');
INSERT INTO `dts_like_data` VALUES ('6593b9af5636415db6fe8801e1ca6b30', 'dc01d9cfd8b948ca966be5406fb93257', '2020-10-31 11:30:40');
INSERT INTO `dts_like_data` VALUES ('6593b9af5636415db6fe8801e1ca6b30', '2c5a2db4467e4081af0b22fcae0cafd5', '2020-11-01 13:10:21');
INSERT INTO `dts_like_data` VALUES ('6593b9af5636415db6fe8801e1ca6b30', 'b195933b335942b9b8c2c42eeb523f62', '2020-11-07 11:27:59');
INSERT INTO `dts_like_data` VALUES ('6593b9af5636415db6fe8801e1ca6b30', '271b3c23484f4e5aaeb6e63ba6776cec', '2020-11-07 17:27:00');
INSERT INTO `dts_like_data` VALUES ('6593b9af5636415db6fe8801e1ca6b30', '6a5f038a3959426fb988590bd85a81e5', '2020-11-09 06:32:22');

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `series` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `token` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `last_used` timestamp(0) NULL DEFAULT NULL
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of persistent_logins
-- ----------------------------
INSERT INTO `persistent_logins` VALUES ('t365383036', 'JaqVmAkctP8iOS48QE9jCQ==', 'PZUz2yXCv1K9xulV20wHnw==', '2020-12-04 02:02:56');

-- ----------------------------
-- Table structure for sts_visit_log
-- ----------------------------
DROP TABLE IF EXISTS `sts_visit_log`;
CREATE TABLE `sts_visit_log`  (
  `id` int(0) NOT NULL,
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路径',
  `ip_addr` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'IP',
  `member_id` int(0) NULL DEFAULT NULL COMMENT '成员ID',
  `create_date` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sts_visit_log
-- ----------------------------

-- ----------------------------
-- Table structure for uts_fans
-- ----------------------------
DROP TABLE IF EXISTS `uts_fans`;
CREATE TABLE `uts_fans`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `user_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `follower` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uts_fans
-- ----------------------------
INSERT INTO `uts_fans` VALUES ('072417fc46dd4d43aa23192c0489d679', '6593b9af5636415db6fe8801e1ca6b30', '6593b9af5636415db6fe8801e1ca6b30', '2020-09-25 14:10:57');
INSERT INTO `uts_fans` VALUES ('1d8e1bdb4d5c4a258eaf0f7318317e0f', 'c82856bcb7014cd6a6a47a0e00736fc2', 'c82856bcb7014cd6a6a47a0e00736fc2', '2020-09-25 13:01:39');
INSERT INTO `uts_fans` VALUES ('421763385e3f4c86b04bc8ec1a4a84b3', '6593b9af5636415db6fe8801e1ca6b30', 'c82856bcb7014cd6a6a47a0e00736fc2', '2020-12-03 11:54:40');

-- ----------------------------
-- Table structure for uts_login_log
-- ----------------------------
DROP TABLE IF EXISTS `uts_login_log`;
CREATE TABLE `uts_login_log`  (
  `id` int(0) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uts_login_log
-- ----------------------------

-- ----------------------------
-- Table structure for uts_member
-- ----------------------------
DROP TABLE IF EXISTS `uts_member`;
CREATE TABLE `uts_member`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  `state` varchar(1) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT '1' COMMENT '1：激活 ，2：封禁，3：删除',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uts_member
-- ----------------------------
INSERT INTO `uts_member` VALUES ('6593b9af5636415db6fe8801e1ca6b30', 't365383036', 'Leileias', '$2a$10$ngZ4TfJXLsNltcdu5V9a6.MPpjgbGkikRQCKhfpsuafJbzTpDP5V6', '792190997@qq.com', 'Objj', '2020-11-17 15:12:10', NULL);
INSERT INTO `uts_member` VALUES ('c82856bcb7014cd6a6a47a0e00736fc2', 'root', '不得了的人物', '$2a$10$ngZ4TfJXLsNltcdu5V9a6.MPpjgbGkikRQCKhfpsuafJbzTpDP5V6', '1604403854@qq.com', '我的微信号：mrocat', '2020-11-26 16:58:09', NULL);
INSERT INTO `uts_member` VALUES ('c894e7a08bf041e985876d31b3977141', 'bobcbui', '一点', '$2a$10$ngZ4TfJXLsNltcdu5V9a6.MPpjgbGkikRQCKhfpsuafJbzTpDP5V6', '7921909971@qq.com', '我的微信号：mrocat', '2020-11-17 15:12:07', NULL);

-- ----------------------------
-- Table structure for uts_member_role
-- ----------------------------
DROP TABLE IF EXISTS `uts_member_role`;
CREATE TABLE `uts_member_role`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `member_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uts_member_role
-- ----------------------------
INSERT INTO `uts_member_role` VALUES ('1', 'c894e7a08bf041e985876d31b3977141', '1', NULL);
INSERT INTO `uts_member_role` VALUES ('2', 'c894e7a08bf041e985876d31b3977141', '2', NULL);
INSERT INTO `uts_member_role` VALUES ('3', '6593b9af5636415db6fe8801e1ca6b30', '8', '2020-11-13 10:23:53');
INSERT INTO `uts_member_role` VALUES ('4', 'c894e7a08bf041e985876d31b3977141', '8', NULL);

-- ----------------------------
-- Table structure for uts_member_state
-- ----------------------------
DROP TABLE IF EXISTS `uts_member_state`;
CREATE TABLE `uts_member_state`  (
  `id` int(0) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_date` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uts_member_state
-- ----------------------------

-- ----------------------------
-- Table structure for uts_resource
-- ----------------------------
DROP TABLE IF EXISTS `uts_resource`;
CREATE TABLE `uts_resource`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `parent_id` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '父ID',
  `path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '路径',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资源名',
  `level` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '资源所在节点,例,/为一级，/user为二级，/user/delete为三级',
  `type` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT 'M：目录，C：菜单 ，A : 接口 。',
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uts_resource
-- ----------------------------
INSERT INTO `uts_resource` VALUES ('1', '0', '', '根', '1', 'M', '2020-11-11 09:53:47');
INSERT INTO `uts_resource` VALUES ('10', '0', '/password', '更新密码', '1', 'A', '2020-11-11 00:00:00');
INSERT INTO `uts_resource` VALUES ('11', '0', '/doLogin', '登录请求', '1', 'A', '2020-11-11 00:00:00');
INSERT INTO `uts_resource` VALUES ('12', '0', '/verify', '验证码', '1', 'A', '2020-11-11 00:00:00');
INSERT INTO `uts_resource` VALUES ('13', '0', '/verifyMail/*', '邮箱验证码', '1', 'A', '2020-11-11 00:00:00');
INSERT INTO `uts_resource` VALUES ('14', '0', '/post/*', '文章页面', '1', 'A', '2020-11-11 00:00:00');
INSERT INTO `uts_resource` VALUES ('15', '0', '/login', '登录页面', '1', 'A', '2020-11-11 00:00:00');
INSERT INTO `uts_resource` VALUES ('16', '0', '/so', '搜索', '1', 'A', '2020-11-11 00:00:00');
INSERT INTO `uts_resource` VALUES ('17', '0', '/blog/comment/*', '评论消息查询', '1', 'A', '2020-11-11 00:00:00');
INSERT INTO `uts_resource` VALUES ('18', '0', '/register', '注册', '1', 'A', '2020-11-11 00:00:00');
INSERT INTO `uts_resource` VALUES ('19', '0', '/blog/blogs', '博客列表', '1', 'A', '2020-11-11 00:00:00');
INSERT INTO `uts_resource` VALUES ('2', '1', '/home', '首页', '2', 'C', '2020-11-11 09:53:47');
INSERT INTO `uts_resource` VALUES ('20', '0', '/map', '未命名', '1', 'A', '2020-11-11 09:59:35');
INSERT INTO `uts_resource` VALUES ('21', '0', '/**.*', '静态资源', '1', 'A', '2020-11-11 00:00:00');
INSERT INTO `uts_resource` VALUES ('22', '0', '/**/*.*', '未命名', '1', 'A', '2020-11-11 09:59:35');
INSERT INTO `uts_resource` VALUES ('23', '0', '/blog/like', '未命名', '1', 'A', '2020-11-11 09:59:35');
INSERT INTO `uts_resource` VALUES ('24', '0', '/blog/home/*', '未命名', '1', 'A', '2020-11-11 09:59:35');
INSERT INTO `uts_resource` VALUES ('25', '0', '/blog/so', '未命名', '1', 'A', '2020-11-11 09:59:35');
INSERT INTO `uts_resource` VALUES ('26', '0', '/editor', '编辑器', '1', 'A', '2020-11-13 00:00:00');
INSERT INTO `uts_resource` VALUES ('27', '0', '/fans/*', '粉丝列表', '1', 'A', '2020-11-13 00:00:00');
INSERT INTO `uts_resource` VALUES ('28', '0', '/blog/delete/*', '未命名', '1', 'A', '2020-11-13 10:40:26');
INSERT INTO `uts_resource` VALUES ('29', '0', '/blog/like/*/insert', '未命名', '1', 'A', '2020-11-13 10:40:26');
INSERT INTO `uts_resource` VALUES ('3', '1', '/author', '作者', '2', 'M', '2020-11-11 09:57:01');
INSERT INTO `uts_resource` VALUES ('30', '0', '/login/info', '登录消息', '1', 'A', '2020-11-13 00:00:00');
INSERT INTO `uts_resource` VALUES ('4', '3', '/author/*', '作者首页', '3', 'C', '2020-11-11 09:59:35');
INSERT INTO `uts_resource` VALUES ('5', '4', '/author/*/list', '作者首页查询', '4', 'A', '2020-11-11 00:00:00');
INSERT INTO `uts_resource` VALUES ('6', '1', 'http://www.baidu.com', '百度', '1', 'A', '2020-11-11 09:59:35');
INSERT INTO `uts_resource` VALUES ('7', '1', '/obj', '未命名', '1', 'A', '2020-11-11 09:59:35');
INSERT INTO `uts_resource` VALUES ('8', '0', '/post', '未命名', '1', 'A', '2020-11-11 09:59:35');
INSERT INTO `uts_resource` VALUES ('9', '0', '/', '首页', '1', 'A', '2020-11-11 00:00:00');

-- ----------------------------
-- Table structure for uts_resource_role
-- ----------------------------
DROP TABLE IF EXISTS `uts_resource_role`;
CREATE TABLE `uts_resource_role`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `resource_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `role_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `create_time` timestamp(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uts_resource_role
-- ----------------------------
INSERT INTO `uts_resource_role` VALUES ('1', '1', '1', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('10', '4', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('11', '5', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('12', '6', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('13', '7', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('14', '8', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('15', '9', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('16', '10', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('17', '11', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('18', '12', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('19', '13', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('2', '2', '1', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('20', '14', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('21', '15', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('22', '16', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('23', '17', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('24', '18', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('25', '19', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('26', '20', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('27', '21', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('28', '22', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('29', '23', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('3', '3', '1', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('30', '24', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('31', '25', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('4', '2', '2', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('40', '26', '8', '2020-11-13 10:26:19');
INSERT INTO `uts_resource_role` VALUES ('41', '27', '8', '2020-11-13 10:39:34');
INSERT INTO `uts_resource_role` VALUES ('42', '28', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('43', '29', '8', '2020-11-13 11:04:02');
INSERT INTO `uts_resource_role` VALUES ('44', '30', '8', '2020-11-22 19:07:51');
INSERT INTO `uts_resource_role` VALUES ('5', '3', '2', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('6', '2', '3', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('7', '1', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('8', '2', '8', '2020-11-11 19:44:46');
INSERT INTO `uts_resource_role` VALUES ('9', '3', '8', '2020-11-11 19:44:46');

-- ----------------------------
-- Table structure for uts_role
-- ----------------------------
DROP TABLE IF EXISTS `uts_role`;
CREATE TABLE `uts_role`  (
  `id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT 'id',
  `role_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '中文名称',
  `role_value` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '角色值，需要为字母，推荐为中文拼音',
  `create_time` timestamp(0) NULL DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of uts_role
-- ----------------------------
INSERT INTO `uts_role` VALUES ('1', '管理官', 'GLG', '2020-11-11 00:00:00');
INSERT INTO `uts_role` VALUES ('2', '创作官', 'CZG', '2020-11-11 00:00:00');
INSERT INTO `uts_role` VALUES ('8', '默认官', 'ANONYMOUS', '2020-11-11 19:26:52');

SET FOREIGN_KEY_CHECKS = 1;
