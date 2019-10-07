/*
 Navicat Premium Data Transfer

 Source Server         : 47.106.203.60
 Source Server Type    : MySQL
 Source Server Version : 50727
 Source Host           : 47.106.203.60:3306
 Source Schema         : vblogdb

 Target Server Type    : MySQL
 Target Server Version : 50727
 File Encoding         : 65001

 Date: 07/10/2019 12:51:02
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for entity_advertise
-- ----------------------------
DROP TABLE IF EXISTS `entity_advertise`;
CREATE TABLE `entity_advertise`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `title` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '广告标题',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '广告地址',
  `create_date` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `delivery_time` int(11) DEFAULT NULL COMMENT '投放时间',
  `description` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '广告描述',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of entity_advertise
-- ----------------------------
INSERT INTO `entity_advertise` VALUES ('1', '淘宝', 'https://www.taobao.com/', '2019-09-08 16:42:59', 8888, '总想买点什么...');
INSERT INTO `entity_advertise` VALUES ('2', '京东', 'https://www.jd.com', '2019-09-08 17:21:55', 6666, '我是东哥的兄弟！！！');
INSERT INTO `entity_advertise` VALUES ('3', '百度一下', 'https://www.baidu.com', '2019-09-08 23:50:30', 9999, '有问题，找度娘！！！');
INSERT INTO `entity_advertise` VALUES ('4', 'Java学习交流群', NULL, '2019-09-18 21:16:22', 9999, '没有问题');
INSERT INTO `entity_advertise` VALUES ('5', '堂堂程序员微信公众号', NULL, '2019-09-18 21:16:54', 9999, '没问题');

-- ----------------------------
-- Table structure for entity_blog
-- ----------------------------
DROP TABLE IF EXISTS `entity_blog`;
CREATE TABLE `entity_blog`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `title` varchar(35) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '博客标题',
  `user_id` int(11) DEFAULT NULL COMMENT '作者ID',
  `create_date` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `update_date` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '更新时间',
  `summary` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '博文文本',
  `class_id` int(11) DEFAULT NULL COMMENT '类型ID',
  `state_id` int(11) DEFAULT NULL COMMENT '状态ID,发布状态，草稿状态，退回状态，删除状态',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of entity_blog
-- ----------------------------
INSERT INTO `entity_blog` VALUES ('1', 'asdf', 111, '2019-08-05 22:49:51', '2019-10-03 11:00:32', '', '', 1, 1);
INSERT INTO `entity_blog` VALUES ('10', '一个不得了的网站', 111, '2019-08-11 20:19:16', NULL, '一个不得了的网站Editor.md directoryeditor.md/\n        lib', '<h3 id=\"h3-u4E00u4E2Au4E0Du5F97u4E86u7684u7F51u7AD9\"><a name=\"一个不得了的网站\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>一个不得了的网站</h3><h4 id=\"h4-editor-md-directory\"><a name=\"Editor.md directory\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Editor.md directory</h4><pre><code>editor.md/\n        lib/\n        css/\n        scss/\n        tests/\n        fonts/\n        images/\n        plugins/\n        examples/\n        languages/\n        editormd.js\n        ...\n</code></pre>', 1, 1);
INSERT INTO `entity_blog` VALUES ('11', '如果开发一个博客系统', 111, '2019-08-11 21:08:08', NULL, '你好，这是一个博客\n\n\n\n\n中杯\n\n\n\n\n大杯\n\n\n\n\n特大杯\n', '<pre><code>你好，这是一个博客\n\n\n\n\n中杯\n\n\n\n\n大杯\n\n\n\n\n特大杯\n</code></pre>', 1, 1);
INSERT INTO `entity_blog` VALUES ('12', '123456的博客', 222, '2019-08-11 21:08:49', NULL, 'Disabled optionsEditor.md directoryDisabled optio', '<div class=\"markdown-toc editormd-markdown-toc\"><ul class=\"markdown-toc-list\"><li><a class=\"toc-level-4\" href=\"#Disabled options\" level=\"4\">Disabled options</a></li><li><a class=\"toc-level-4\" href=\"#Editor.md directory\" level=\"4\">Editor.md directory</a><ul></ul></li></ul></div><h4 id=\"h4-disabled-options\"><a name=\"Disabled options\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Disabled options</h4><ul>\n<li>TeX (Based on KaTeX);</li><li>Emoji;</li><li>Task lists;</li><li>HTML tags decode;</li><li>Flowchart and Sequence Diagram;</li></ul>\n<h4 id=\"h4-editor-md-directory\"><a name=\"Editor.md directory\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Editor.md directory</h4><p>editor.md/<br>        lib/<br>        css/<br>        scss/<br>        tests/<br>        fonts/<br>        images/<br>        plugins/<br>        examples/<br>        languages/<br>        editormd.js<br>        …</p>\n', 1, 1);
INSERT INTO `entity_blog` VALUES ('13', '', 222, '2019-08-11 21:09:49', NULL, 'Disabled optionsEditor.md directoryDisabled optio', '<div class=\"markdown-toc editormd-markdown-toc\"><ul class=\"markdown-toc-list\"><li><a class=\"toc-level-4\" href=\"#Disabled options\" level=\"4\">Disabled options</a></li><li><a class=\"toc-level-4\" href=\"#Editor.md directory\" level=\"4\">Editor.md directory</a><ul></ul></li></ul></div><h4 id=\"h4-disabled-options\"><a name=\"Disabled options\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Disabled options</h4><ul>\n<li>TeX (Based on KaTeX);</li><li>Emoji;</li><li>Task lists;</li><li>HTML tags decode;</li><li>Flowchart and Sequence Diagram;</li></ul>\n<h4 id=\"h4-editor-md-directory\"><a name=\"Editor.md directory\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Editor.md directory</h4><p>editor.md/<br>        lib/<br>        css/<br>        scss/<br>        tests/<br>        fonts/<br>        images/<br>        plugins/<br>        examples/<br>        languages/<br>        editormd.js<br>        …</p>\n', 1, 1);
INSERT INTO `entity_blog` VALUES ('14', '一篇不得了的文章', 111, '2019-09-01 12:38:37', NULL, '你好，小娜一个人物。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。', '<h1 id=\"h1--\"><a name=\"你好，小娜\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>你好，小娜</h1><pre><code>一个人物。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。\n</code></pre>', 1, 1);
INSERT INTO `entity_blog` VALUES ('15', '一篇不得了的文章', 111, '2019-09-01 12:39:09', NULL, '你好，小娜一个人物。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。', '<h1 id=\"h1--\"><a name=\"你好，小娜\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>你好，小娜</h1><pre><code>一个人物。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。。\n</code></pre>', 1, 1);
INSERT INTO `entity_blog` VALUES ('16', '阿道夫', 111, '2019-09-01 12:42:16', NULL, '啊手动阀\n', '<p>啊手动阀</p>\n', 1, 1);
INSERT INTO `entity_blog` VALUES ('17', '111', 111, '2019-09-01 12:45:25', NULL, '111\n', '<p>111</p>\n', 1, 1);
INSERT INTO `entity_blog` VALUES ('2', '漫画：我是程序员，总想打测试工程师怎么办？', 222, '2019-08-06 22:49:51', NULL, '漫画：我是程序员，总想打测试工程师怎么办？漫画：我是程序员，总想打测试工程师怎么办？漫画：我是程序员，总想打测试工程师怎么办？漫画：我是程序员，总想打测试工程师怎么办？漫画：我是程序员，总想打测试工程师怎么办？', 'dfghgvnghdghdfgh', 1, 2);
INSERT INTO `entity_blog` VALUES ('26c0fd33c3a34ee2abdc7b545e9cb287', '一篇不得了的博客', 111, '2019-09-01 17:59:45', NULL, 'TT神秘代码\n', '<h1 id=\"h1-tt\"><a name=\"TT\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>TT</h1><pre><code>神秘代码\n</code></pre>', 1, 1);
INSERT INTO `entity_blog` VALUES ('3', '相比于寒冬，互联网公司更怕夏天', 111, '2019-08-06 22:49:51', NULL, '相比于寒冬，互联网公司更怕夏天相比于寒冬，互联网公司更怕夏天相比于寒冬，互联网公司更怕夏天相比于寒冬，互联网公司更怕夏天相比于寒冬，互联网公司更怕夏天', '<article class=\"markdown-body entry-content p-5\" itemprop=\"text\"><h1><a id=\"user-content-editormd\" class=\"anchor\" aria-hidden=\"true\" href=\"#editormd\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>Editor.md</h1>\r\n<p><a target=\"_blank\" rel=\"noopener noreferrer\" href=\"https://camo.githubusercontent.com/b39e5c062500d805c098bc47a9713d420d8130aa/68747470733a2f2f70616e64616f2e6769746875622e696f2f656469746f722e6d642f696d616765732f6c6f676f732f656469746f726d642d6c6f676f2d313830783138302e706e67\"><img src=\"https://camo.githubusercontent.com/b39e5c062500d805c098bc47a9713d420d8130aa/68747470733a2f2f70616e64616f2e6769746875622e696f2f656469746f722e6d642f696d616765732f6c6f676f732f656469746f726d642d6c6f676f2d313830783138302e706e67\" alt=\"\" data-canonical-src=\"https://pandao.github.io/editor.md/images/logos/editormd-logo-180x180.png\" style=\"max-width:100%;\"></a></p>\r\n<p><a target=\"_blank\" rel=\"noopener noreferrer\" href=\"https://camo.githubusercontent.com/f9e30cf9da6582e72fb7b47aeea07d9fc3776a4a/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f73746172732f70616e64616f2f656469746f722e6d642e737667\"><img src=\"https://camo.githubusercontent.com/f9e30cf9da6582e72fb7b47aeea07d9fc3776a4a/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f73746172732f70616e64616f2f656469746f722e6d642e737667\" alt=\"\" data-canonical-src=\"https://img.shields.io/github/stars/pandao/editor.md.svg\" style=\"max-width:100%;\"></a>\r\n<a target=\"_blank\" rel=\"noopener noreferrer\" href=\"https://camo.githubusercontent.com/e989ee0b8e4206c776a746102b5a5085d61ea082/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f666f726b732f70616e64616f2f656469746f722e6d642e737667\"><img src=\"https://camo.githubusercontent.com/e989ee0b8e4206c776a746102b5a5085d61ea082/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f666f726b732f70616e64616f2f656469746f722e6d642e737667\" alt=\"\" data-canonical-src=\"https://img.shields.io/github/forks/pandao/editor.md.svg\" style=\"max-width:100%;\"></a>\r\n<a target=\"_blank\" rel=\"noopener noreferrer\" href=\"https://camo.githubusercontent.com/1f3602693125e8cfc2db712afacf7b4832273e78/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f7461672f70616e64616f2f656469746f722e6d642e737667\"><img src=\"https://camo.githubusercontent.com/1f3602693125e8cfc2db712afacf7b4832273e78/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f7461672f70616e64616f2f656469746f722e6d642e737667\" alt=\"\" data-canonical-src=\"https://img.shields.io/github/tag/pandao/editor.md.svg\" style=\"max-width:100%;\"></a>\r\n<a target=\"_blank\" rel=\"noopener noreferrer\" href=\"https://camo.githubusercontent.com/7a93a55cec8944b4ddc48cf954267547392c02c9/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f72656c656173652f70616e64616f2f656469746f722e6d642e737667\"><img src=\"https://camo.githubusercontent.com/7a93a55cec8944b4ddc48cf954267547392c02c9/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f72656c656173652f70616e64616f2f656469746f722e6d642e737667\" alt=\"\" data-canonical-src=\"https://img.shields.io/github/release/pandao/editor.md.svg\" style=\"max-width:100%;\"></a>\r\n<a target=\"_blank\" rel=\"noopener noreferrer\" href=\"https://camo.githubusercontent.com/72148687ce514f22b201ae347744330039669706/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f6973737565732f70616e64616f2f656469746f722e6d642e737667\"><img src=\"https://camo.githubusercontent.com/72148687ce514f22b201ae347744330039669706/68747470733a2f2f696d672e736869656c64732e696f2f6769746875622f6973737565732f70616e64616f2f656469746f722e6d642e737667\" alt=\"\" data-canonical-src=\"https://img.shields.io/github/issues/pandao/editor.md.svg\" style=\"max-width:100%;\"></a>\r\n<a target=\"_blank\" rel=\"noopener noreferrer\" href=\"https://camo.githubusercontent.com/2df813de78454c7b875ce279374e4361b4dd39f8/68747470733a2f2f696d672e736869656c64732e696f2f626f7765722f762f656469746f722e6d642e737667\"><img src=\"https://camo.githubusercontent.com/2df813de78454c7b875ce279374e4361b4dd39f8/68747470733a2f2f696d672e736869656c64732e696f2f626f7765722f762f656469746f722e6d642e737667\" alt=\"\" data-canonical-src=\"https://img.shields.io/bower/v/editor.md.svg\" style=\"max-width:100%;\"></a></p>\r\n<p><strong>Editor.md</strong> : The open source embeddable online markdown editor (component), based on CodeMirror &amp; jQuery &amp; Marked.</p>\r\n<h3><a id=\"user-content-features\" class=\"anchor\" aria-hidden=\"true\" href=\"#features\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>Features</h3>\r\n<ul>\r\n<li>Support Standard Markdown / CommonMark and GFM (GitHub Flavored Markdown);</li>\r\n<li>Full-featured: Real-time Preview, Image (cross-domain) upload, Preformatted text/Code blocks/Tables insert, Code fold, Search replace, Read only, Themes, Multi-languages, L18n, HTML entities, Code syntax highlighting...;</li>\r\n<li>Markdown Extras : Support <a href=\"https://pandao.github.io/editor.md/examples/toc.html\" rel=\"nofollow\">ToC (Table of Contents)</a>, <a href=\"https://pandao.github.io/editor.md/examples/emoji.html\" rel=\"nofollow\">Emoji</a>, <a href=\"https://pandao.github.io/editor.md/examples/task-lists.html\" rel=\"nofollow\">Task lists</a>, <a href=\"https://pandao.github.io/editor.md/examples/@links.html\" rel=\"nofollow\">@Links</a>...;</li>\r\n<li>Compatible with all major browsers (IE8+), compatible Zepto.js and iPad;</li>\r\n<li>Support <a href=\"https://pandao.github.io/editor.md/examples/html-tags-decode.html\" rel=\"nofollow\">decode &amp; fliter of the HTML tags &amp; attributes</a>;</li>\r\n<li>Support <a href=\"https://pandao.github.io/editor.md/examples/katex.html\" rel=\"nofollow\">TeX (LaTeX expressions, Based on KaTeX)</a>, <a href=\"https://pandao.github.io/editor.md/examples/flowchart.html\" rel=\"nofollow\">Flowchart</a> and <a href=\"https://pandao.github.io/editor.md/examples/sequence-diagram.html\" rel=\"nofollow\">Sequence Diagram</a> of Markdown extended syntax;</li>\r\n<li>Support AMD/CMD (Require.js &amp; Sea.js) Module Loader, and Custom/define editor plugins;</li>\r\n</ul>\r\n<p><a href=\"https://pandao.github.io/editor.md/en.html\" rel=\"nofollow\">README &amp; Examples (English)</a></p>\r\n<hr>\r\n<p><strong>Editor.md</strong> 是一款开源的、可嵌入的 Markdown 在线编辑器（组件），基于 CodeMirror、jQuery 和 Marked 构建。</p>\r\n<p><a target=\"_blank\" rel=\"noopener noreferrer\" href=\"https://camo.githubusercontent.com/65daba94cfd2da981dba7a39f3f39dff108dd6ca/68747470733a2f2f70616e64616f2e6769746875622e696f2f656469746f722e6d642f6578616d706c65732f696d616765732f656469746f726d642d73637265656e73686f742e706e67\"><img src=\"https://camo.githubusercontent.com/65daba94cfd2da981dba7a39f3f39dff108dd6ca/68747470733a2f2f70616e64616f2e6769746875622e696f2f656469746f722e6d642f6578616d706c65732f696d616765732f656469746f726d642d73637265656e73686f742e706e67\" alt=\"editormd-screenshot\" title=\"editormd-screenshot\" data-canonical-src=\"https://pandao.github.io/editor.md/examples/images/editormd-screenshot.png\" style=\"max-width:100%;\"></a></p>\r\n<h4><a id=\"user-content-主要特性\" class=\"anchor\" aria-hidden=\"true\" href=\"#主要特性\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>主要特性</h4>\r\n<ul>\r\n<li>支持通用 Markdown / CommonMark 和 GFM (GitHub Flavored Markdown) 风格的语法，也可<a href=\"https://pandao.github.io/editor.md/examples/change-mode.html\" rel=\"nofollow\">变身为代码编辑器</a>；</li>\r\n<li>支持实时预览、图片（跨域）上传、预格式文本/代码/表格插入、代码折叠、跳转到行、搜索替换、只读模式、自定义样式主题和多语言语法高亮等功能；</li>\r\n<li>支持 <a href=\"https://pandao.github.io/editor.md/examples/toc.html\" rel=\"nofollow\">ToC（Table of Contents）</a>、<a href=\"https://pandao.github.io/editor.md/examples/emoji.html\" rel=\"nofollow\">Emoji表情</a>、<a href=\"https://pandao.github.io/editor.md/examples/task-lists.html\" rel=\"nofollow\">Task lists</a>、<a href=\"https://pandao.github.io/editor.md/examples/@links.html\" rel=\"nofollow\">@链接</a>等 Markdown 扩展语法；</li>\r\n<li>支持 TeX 科学公式（基于 <a href=\"https://pandao.github.io/editor.md/examples/katex.html\" rel=\"nofollow\">KaTeX</a>）、流程图 <a href=\"https://pandao.github.io/editor.md/examples/flowchart.html\" rel=\"nofollow\">Flowchart</a> 和 <a href=\"https://pandao.github.io/editor.md/examples/sequence-diagram.html\" rel=\"nofollow\">时序图 Sequence Diagram</a>;</li>\r\n<li>支持<a href=\"https://pandao.github.io/editor.md/examples/html-tags-decode.html\" rel=\"nofollow\">识别和解析 HTML 标签，并且支持自定义过滤标签及属性解析</a>，具有可靠的安全性和几乎无限的扩展性；</li>\r\n<li>支持 AMD / CMD 模块化加载（支持 <a href=\"https://pandao.github.io/editor.md/examples/use-requirejs.html\" rel=\"nofollow\">Require.js</a> &amp; <a href=\"https://pandao.github.io/editor.md/examples/use-seajs.html\" rel=\"nofollow\">Sea.js</a>），并且支持<a href=\"https://pandao.github.io/editor.md/examples/define-plugin.html\" rel=\"nofollow\">自定义扩展插件</a>；</li>\r\n<li>兼容主流的浏览器（IE8+）和 <a href=\"https://pandao.github.io/editor.md/examples/use-zepto.html\" rel=\"nofollow\">Zepto.js</a>，且支持 iPad 等平板设备；</li>\r\n</ul>\r\n<h4><a id=\"user-content-download--install\" class=\"anchor\" aria-hidden=\"true\" href=\"#download--install\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>Download &amp; install</h4>\r\n<p>Download:</p>\r\n<p><a href=\"https://github.com/pandao/editor.md/archive/master.zip\">Github download</a></p>\r\n<p>NPM install :</p>\r\n<div class=\"highlight highlight-source-shell\"><pre>npm install editor.md</pre></div>\r\n<p>Bower install :</p>\r\n<div class=\"highlight highlight-source-shell\"><pre>bower install editor.md</pre></div>\r\n<h4><a id=\"user-content-usages\" class=\"anchor\" aria-hidden=\"true\" href=\"#usages\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>Usages</h4>\r\n<h5><a id=\"user-content-create-a-markdown-editor\" class=\"anchor\" aria-hidden=\"true\" href=\"#create-a-markdown-editor\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>Create a Markdown editor</h5>\r\n<div class=\"highlight highlight-text-html-basic\"><pre>&lt;<span class=\"pl-ent\">link</span> <span class=\"pl-e\">rel</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>stylesheet<span class=\"pl-pds\">\"</span></span> <span class=\"pl-e\">href</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>editor.md/css/editormd.min.css<span class=\"pl-pds\">\"</span></span> /&gt;\r\n&lt;<span class=\"pl-ent\">div</span> <span class=\"pl-e\">id</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>editor<span class=\"pl-pds\">\"</span></span>&gt;\r\n    <span class=\"pl-c\"><span class=\"pl-c\">&lt;!--</span> Tips: Editor.md can auto append a `&lt;textarea&gt;` tag <span class=\"pl-c\">--&gt;</span></span>\r\n    &lt;<span class=\"pl-ent\">textarea</span> <span class=\"pl-e\">style</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span><span class=\"pl-s1\"><span class=\"pl-c1\"><span class=\"pl-c1\">display</span></span>:<span class=\"pl-c1\">none</span>;</span><span class=\"pl-pds\">\"</span></span>&gt;### Hello Editor.md !&lt;/<span class=\"pl-ent\">textarea</span>&gt;\r\n&lt;/<span class=\"pl-ent\">div</span>&gt;\r\n&lt;<span class=\"pl-ent\">script</span> <span class=\"pl-e\">src</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>jquery.min.js<span class=\"pl-pds\">\"</span></span>&gt;&lt;/<span class=\"pl-ent\">script</span>&gt;\r\n&lt;<span class=\"pl-ent\">script</span> <span class=\"pl-e\">src</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>editor.md/editormd.min.js<span class=\"pl-pds\">\"</span></span>&gt;&lt;/<span class=\"pl-ent\">script</span>&gt;\r\n&lt;<span class=\"pl-ent\">script</span> <span class=\"pl-e\">type</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>text/javascript<span class=\"pl-pds\">\"</span></span>&gt;<span class=\"pl-s1\"></span>\r\n<span class=\"pl-s1\">    <span class=\"pl-en\">$</span>(<span class=\"pl-k\">function</span>() {</span>\r\n<span class=\"pl-s1\">        <span class=\"pl-k\">var</span> editor <span class=\"pl-k\">=</span> <span class=\"pl-en\">editormd</span>(<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>editor<span class=\"pl-pds\">\"</span></span>, {</span>\r\n<span class=\"pl-s1\">            <span class=\"pl-c\"><span class=\"pl-c\">//</span> width: \"100%\",</span></span>\r\n<span class=\"pl-s1\">            <span class=\"pl-c\"><span class=\"pl-c\">//</span> height: \"100%\",</span></span>\r\n<span class=\"pl-s1\">            <span class=\"pl-c\"><span class=\"pl-c\">//</span> markdown: \"xxxx\",     // dynamic set Markdown text</span></span>\r\n<span class=\"pl-s1\">            path <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>editor.md/lib/<span class=\"pl-pds\">\"</span></span>  <span class=\"pl-c\"><span class=\"pl-c\">//</span> Autoload modules mode, codemirror, marked... dependents libs path</span></span>\r\n<span class=\"pl-s1\">        });</span>\r\n<span class=\"pl-s1\">    });</span>\r\n<span class=\"pl-s1\"></span>&lt;/<span class=\"pl-ent\">script</span>&gt;</pre></div>\r\n<p>If you using modular script loader:</p>\r\n<ul>\r\n<li><a href=\"https://github.com/pandao/editor.md/tree/master/examples/use-requirejs.html\">Using Require.js</a></li>\r\n<li><a href=\"https://github.com/pandao/editor.md/tree/master/examples/use-seajs.html\">Using Sea.js</a></li>\r\n</ul>\r\n<h5><a id=\"user-content-markdown-to-html\" class=\"anchor\" aria-hidden=\"true\" href=\"#markdown-to-html\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>Markdown to HTML</h5>\r\n<div class=\"highlight highlight-text-html-basic\"><pre>&lt;<span class=\"pl-ent\">link</span> <span class=\"pl-e\">rel</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>stylesheet<span class=\"pl-pds\">\"</span></span> <span class=\"pl-e\">href</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>editormd/css/editormd.preview.css<span class=\"pl-pds\">\"</span></span> /&gt;\r\n&lt;<span class=\"pl-ent\">div</span> <span class=\"pl-e\">id</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>test-markdown-view<span class=\"pl-pds\">\"</span></span>&gt;\r\n    <span class=\"pl-c\"><span class=\"pl-c\">&lt;!--</span> Server-side output Markdown text <span class=\"pl-c\">--&gt;</span></span>\r\n    &lt;<span class=\"pl-ent\">textarea</span> <span class=\"pl-e\">style</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span><span class=\"pl-s1\"><span class=\"pl-c1\"><span class=\"pl-c1\">display</span></span>:<span class=\"pl-c1\">none</span>;</span><span class=\"pl-pds\">\"</span></span>&gt;### Hello world!&lt;/<span class=\"pl-ent\">textarea</span>&gt;             \r\n&lt;/<span class=\"pl-ent\">div</span>&gt;\r\n&lt;<span class=\"pl-ent\">script</span> <span class=\"pl-e\">src</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>jquery.min.js<span class=\"pl-pds\">\"</span></span>&gt;&lt;/<span class=\"pl-ent\">script</span>&gt;\r\n&lt;<span class=\"pl-ent\">script</span> <span class=\"pl-e\">src</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>editormd/editormd.js<span class=\"pl-pds\">\"</span></span>&gt;&lt;/<span class=\"pl-ent\">script</span>&gt;\r\n&lt;<span class=\"pl-ent\">script</span> <span class=\"pl-e\">src</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>editormd/lib/marked.min.js<span class=\"pl-pds\">\"</span></span>&gt;&lt;/<span class=\"pl-ent\">script</span>&gt;\r\n&lt;<span class=\"pl-ent\">script</span> <span class=\"pl-e\">src</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>editormd/lib/prettify.min.js<span class=\"pl-pds\">\"</span></span>&gt;&lt;/<span class=\"pl-ent\">script</span>&gt;\r\n&lt;<span class=\"pl-ent\">script</span> <span class=\"pl-e\">type</span>=<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>text/javascript<span class=\"pl-pds\">\"</span></span>&gt;<span class=\"pl-s1\"></span>\r\n<span class=\"pl-s1\">    <span class=\"pl-en\">$</span>(<span class=\"pl-k\">function</span>() {</span>\r\n<span class=\"pl-s1\">	    <span class=\"pl-k\">var</span> testView <span class=\"pl-k\">=</span> <span class=\"pl-smi\">editormd</span>.<span class=\"pl-en\">markdownToHTML</span>(<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>test-markdown-view<span class=\"pl-pds\">\"</span></span>, {</span>\r\n<span class=\"pl-s1\">            <span class=\"pl-c\"><span class=\"pl-c\">//</span> markdown : \"[TOC]\\n### Hello world!\\n## Heading 2\", // Also, you can dynamic set Markdown text</span></span>\r\n<span class=\"pl-s1\">            <span class=\"pl-c\"><span class=\"pl-c\">//</span> htmlDecode : true,  // Enable / disable HTML tag encode.</span></span>\r\n<span class=\"pl-s1\">            <span class=\"pl-c\"><span class=\"pl-c\">//</span> htmlDecode : \"style,script,iframe\",  // Note: If enabled, you should filter some dangerous HTML tags for website security.</span></span>\r\n<span class=\"pl-s1\">        });</span>\r\n<span class=\"pl-s1\">    });</span>\r\n<span class=\"pl-s1\"></span>&lt;/<span class=\"pl-ent\">script</span>&gt;    </pre></div>\r\n<blockquote>\r\n<p>See the full example: <a href=\"http://editor.md.ipandao.com/examples/html-preview-markdown-to-html.html\" rel=\"nofollow\">http://editor.md.ipandao.com/examples/html-preview-markdown-to-html.html</a></p>\r\n</blockquote>\r\n<h5><a id=\"user-content-html-to-markdown\" class=\"anchor\" aria-hidden=\"true\" href=\"#html-to-markdown\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>HTML to Markdown?</h5>\r\n<p>Sorry, Editor.md not support HTML to Markdown parsing, Maybe In the future.</p>\r\n<h4><a id=\"user-content-examples\" class=\"anchor\" aria-hidden=\"true\" href=\"#examples\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>Examples</h4>\r\n<p><a href=\"https://pandao.github.io/editor.md/examples/index.html\" rel=\"nofollow\">https://pandao.github.io/editor.md/examples/index.html</a></p>\r\n<h4><a id=\"user-content-options\" class=\"anchor\" aria-hidden=\"true\" href=\"#options\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>Options</h4>\r\n<p>Editor.md options and default values:</p>\r\n<div class=\"highlight highlight-source-js\"><pre>{\r\n    mode                 <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>gfm<span class=\"pl-pds\">\"</span></span>,          <span class=\"pl-c\"><span class=\"pl-c\">//</span> gfm or markdown</span>\r\n    name                 <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span><span class=\"pl-pds\">\"</span></span>,             <span class=\"pl-c\"><span class=\"pl-c\">//</span> Form element name for post</span>\r\n    value                <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span><span class=\"pl-pds\">\"</span></span>,             <span class=\"pl-c\"><span class=\"pl-c\">//</span> value for CodeMirror, if mode not gfm/markdown</span>\r\n    theme                <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span><span class=\"pl-pds\">\"</span></span>,             <span class=\"pl-c\"><span class=\"pl-c\">//</span> Editor.md self themes, before v1.5.0 is CodeMirror theme, default empty</span>\r\n    editorTheme          <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>default<span class=\"pl-pds\">\"</span></span>,      <span class=\"pl-c\"><span class=\"pl-c\">//</span> Editor area, this is CodeMirror theme at v1.5.0</span>\r\n    previewTheme         <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span><span class=\"pl-pds\">\"</span></span>,             <span class=\"pl-c\"><span class=\"pl-c\">//</span> Preview area theme, default empty</span>\r\n    markdown             <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span><span class=\"pl-pds\">\"</span></span>,             <span class=\"pl-c\"><span class=\"pl-c\">//</span> Markdown source code</span>\r\n    appendMarkdown       <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span><span class=\"pl-pds\">\"</span></span>,             <span class=\"pl-c\"><span class=\"pl-c\">//</span> if in init textarea value not empty, append markdown to textarea</span>\r\n    width                <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>100%<span class=\"pl-pds\">\"</span></span>,\r\n    height               <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>100%<span class=\"pl-pds\">\"</span></span>,\r\n    path                 <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>./lib/<span class=\"pl-pds\">\"</span></span>,       <span class=\"pl-c\"><span class=\"pl-c\">//</span> Dependents module file directory</span>\r\n    pluginPath           <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span><span class=\"pl-pds\">\"</span></span>,             <span class=\"pl-c\"><span class=\"pl-c\">//</span> If this empty, default use settings.path + \"../plugins/\"</span>\r\n    delay                <span class=\"pl-k\">:</span> <span class=\"pl-c1\">300</span>,            <span class=\"pl-c\"><span class=\"pl-c\">//</span> Delay parse markdown to html, Uint : ms</span>\r\n    autoLoadModules      <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> Automatic load dependent module files</span>\r\n    watch                <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,\r\n    placeholder          <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>Enjoy Markdown! coding now...<span class=\"pl-pds\">\"</span></span>,\r\n    gotoLine             <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> Enable / disable goto a line</span>\r\n    codeFold             <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,\r\n    autoHeight           <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,\r\n    autoFocus            <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> Enable / disable auto focus editor left input area</span>\r\n    autoCloseTags        <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,\r\n    searchReplace        <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> Enable / disable (CodeMirror) search and replace function</span>\r\n    syncScrolling        <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> options: true | false | \"single\", default true</span>\r\n    readOnly             <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,          <span class=\"pl-c\"><span class=\"pl-c\">//</span> Enable / disable readonly mode</span>\r\n    tabSize              <span class=\"pl-k\">:</span> <span class=\"pl-c1\">4</span>,\r\n    indentUnit           <span class=\"pl-k\">:</span> <span class=\"pl-c1\">4</span>,\r\n    lineNumbers          <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> Display editor line numbers</span>\r\n    lineWrapping         <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,\r\n    autoCloseBrackets    <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,\r\n    showTrailingSpace    <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,\r\n    matchBrackets        <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,\r\n    indentWithTabs       <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,\r\n    styleSelectedText    <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,\r\n    matchWordHighlight   <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> options: true, false, \"onselected\"</span>\r\n    styleActiveLine      <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> Highlight the current line</span>\r\n    dialogLockScreen     <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,\r\n    dialogShowMask       <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,\r\n    dialogDraggable      <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,\r\n    dialogMaskBgColor    <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>#fff<span class=\"pl-pds\">\"</span></span>,\r\n    dialogMaskOpacity    <span class=\"pl-k\">:</span> <span class=\"pl-c1\">0.1</span>,\r\n    fontSize             <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>13px<span class=\"pl-pds\">\"</span></span>,\r\n    saveHTMLToTextarea   <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,          <span class=\"pl-c\"><span class=\"pl-c\">//</span> If enable, Editor will create a &lt;textarea name=\"{editor-id}-html-code\"&gt; tag save HTML code for form post to server-side.</span>\r\n    disabledKeyMaps      <span class=\"pl-k\">:</span> [],\r\n    \r\n    <span class=\"pl-en\">onload</span>               <span class=\"pl-k\">:</span> <span class=\"pl-k\">function</span>() {},\r\n    <span class=\"pl-en\">onresize</span>             <span class=\"pl-k\">:</span> <span class=\"pl-k\">function</span>() {},\r\n    <span class=\"pl-en\">onchange</span>             <span class=\"pl-k\">:</span> <span class=\"pl-k\">function</span>() {},\r\n    onwatch              <span class=\"pl-k\">:</span> <span class=\"pl-c1\">null</span>,\r\n    onunwatch            <span class=\"pl-k\">:</span> <span class=\"pl-c1\">null</span>,\r\n    <span class=\"pl-en\">onpreviewing</span>         <span class=\"pl-k\">:</span> <span class=\"pl-k\">function</span>() {},\r\n    <span class=\"pl-en\">onpreviewed</span>          <span class=\"pl-k\">:</span> <span class=\"pl-k\">function</span>() {},\r\n    <span class=\"pl-en\">onfullscreen</span>         <span class=\"pl-k\">:</span> <span class=\"pl-k\">function</span>() {},\r\n    <span class=\"pl-en\">onfullscreenExit</span>     <span class=\"pl-k\">:</span> <span class=\"pl-k\">function</span>() {},\r\n    <span class=\"pl-en\">onscroll</span>             <span class=\"pl-k\">:</span> <span class=\"pl-k\">function</span>() {},\r\n    <span class=\"pl-en\">onpreviewscroll</span>      <span class=\"pl-k\">:</span> <span class=\"pl-k\">function</span>() {},\r\n    \r\n    imageUpload          <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,          <span class=\"pl-c\"><span class=\"pl-c\">//</span> Enable/disable upload</span>\r\n    imageFormats         <span class=\"pl-k\">:</span> [<span class=\"pl-s\"><span class=\"pl-pds\">\"</span>jpg<span class=\"pl-pds\">\"</span></span>, <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>jpeg<span class=\"pl-pds\">\"</span></span>, <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>gif<span class=\"pl-pds\">\"</span></span>, <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>png<span class=\"pl-pds\">\"</span></span>, <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>bmp<span class=\"pl-pds\">\"</span></span>, <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>webp<span class=\"pl-pds\">\"</span></span>],\r\n    imageUploadURL       <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span><span class=\"pl-pds\">\"</span></span>,             <span class=\"pl-c\"><span class=\"pl-c\">//</span> Upload url</span>\r\n    crossDomainUpload    <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,          <span class=\"pl-c\"><span class=\"pl-c\">//</span> Enable/disable Cross-domain upload</span>\r\n    uploadCallbackURL    <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span><span class=\"pl-pds\">\"</span></span>,             <span class=\"pl-c\"><span class=\"pl-c\">//</span> Cross-domain upload callback url</span>\r\n\r\n    toc                  <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> Table of contents</span>\r\n    tocm                 <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,          <span class=\"pl-c\"><span class=\"pl-c\">//</span> Using [TOCM], auto create ToC dropdown menu</span>\r\n    tocTitle             <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span><span class=\"pl-pds\">\"</span></span>,             <span class=\"pl-c\"><span class=\"pl-c\">//</span> for ToC dropdown menu button</span>\r\n    tocDropdown          <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,          <span class=\"pl-c\"><span class=\"pl-c\">//</span> Enable/disable Table Of Contents dropdown menu</span>\r\n    tocContainer         <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span><span class=\"pl-pds\">\"</span></span>,             <span class=\"pl-c\"><span class=\"pl-c\">//</span> Custom Table Of Contents Container Selector</span>\r\n    tocStartLevel        <span class=\"pl-k\">:</span> <span class=\"pl-c1\">1</span>,              <span class=\"pl-c\"><span class=\"pl-c\">//</span> Said from H1 to create ToC</span>\r\n    htmlDecode           <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,          <span class=\"pl-c\"><span class=\"pl-c\">//</span> Open the HTML tag identification </span>\r\n    pageBreak            <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> Enable parse page break [========]</span>\r\n    atLink               <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> for @link</span>\r\n    emailLink            <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> for email address auto link</span>\r\n    taskList             <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,          <span class=\"pl-c\"><span class=\"pl-c\">//</span> Enable Github Flavored Markdown task lists</span>\r\n    emoji                <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,          <span class=\"pl-c\"><span class=\"pl-c\">//</span> :emoji: , Support Github emoji, Twitter Emoji (Twemoji);</span>\r\n                                           <span class=\"pl-c\"><span class=\"pl-c\">//</span> Support FontAwesome icon emoji :fa-xxx: &gt; Using fontAwesome icon web fonts;</span>\r\n                                           <span class=\"pl-c\"><span class=\"pl-c\">//</span> Support Editor.md logo icon emoji :editormd-logo: :editormd-logo-1x: &gt; 1~8x;</span>\r\n    tex                  <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,          <span class=\"pl-c\"><span class=\"pl-c\">//</span> TeX(LaTeX), based on KaTeX</span>\r\n    flowChart            <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,          <span class=\"pl-c\"><span class=\"pl-c\">//</span> flowChart.js only support IE9+</span>\r\n    sequenceDiagram      <span class=\"pl-k\">:</span> <span class=\"pl-c1\">false</span>,          <span class=\"pl-c\"><span class=\"pl-c\">//</span> sequenceDiagram.js only support IE9+</span>\r\n    previewCodeHighlight <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> Enable / disable code highlight of editor preview area</span>\r\n\r\n    toolbar              <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> show or hide toolbar</span>\r\n    toolbarAutoFixed     <span class=\"pl-k\">:</span> <span class=\"pl-c1\">true</span>,           <span class=\"pl-c\"><span class=\"pl-c\">//</span> on window scroll auto fixed position</span>\r\n    toolbarIcons         <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>full<span class=\"pl-pds\">\"</span></span>,         <span class=\"pl-c\"><span class=\"pl-c\">//</span> Toolbar icons mode, options: full, simple, mini, See `editormd.toolbarModes` property.</span>\r\n    toolbarTitles        <span class=\"pl-k\">:</span> {},\r\n    toolbarHandlers      <span class=\"pl-k\">:</span> {\r\n        <span class=\"pl-en\">ucwords</span> <span class=\"pl-k\">:</span> <span class=\"pl-k\">function</span>() {\r\n            <span class=\"pl-k\">return</span> <span class=\"pl-smi\">editormd</span>.<span class=\"pl-smi\">toolbarHandlers</span>.<span class=\"pl-smi\">ucwords</span>;\r\n        },\r\n        <span class=\"pl-en\">lowercase</span> <span class=\"pl-k\">:</span> <span class=\"pl-k\">function</span>() {\r\n            <span class=\"pl-k\">return</span> <span class=\"pl-smi\">editormd</span>.<span class=\"pl-smi\">toolbarHandlers</span>.<span class=\"pl-smi\">lowercase</span>;\r\n        }\r\n    },\r\n    toolbarCustomIcons   <span class=\"pl-k\">:</span> {               <span class=\"pl-c\"><span class=\"pl-c\">//</span> using html tag create toolbar icon, unused default &lt;a&gt; tag.</span>\r\n        lowercase        <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>&lt;a href=<span class=\"pl-cce\">\\\"</span>javascript:;<span class=\"pl-cce\">\\\"</span> title=<span class=\"pl-cce\">\\\"</span>Lowercase<span class=\"pl-cce\">\\\"</span> unselectable=<span class=\"pl-cce\">\\\"</span>on<span class=\"pl-cce\">\\\"</span>&gt;&lt;i class=<span class=\"pl-cce\">\\\"</span>fa<span class=\"pl-cce\">\\\"</span> name=<span class=\"pl-cce\">\\\"</span>lowercase<span class=\"pl-cce\">\\\"</span> style=<span class=\"pl-cce\">\\\"</span>font-size:24px;margin-top: -10px;<span class=\"pl-cce\">\\\"</span>&gt;a&lt;/i&gt;&lt;/a&gt;<span class=\"pl-pds\">\"</span></span>,\r\n        <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>ucwords<span class=\"pl-pds\">\"</span></span>        <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>&lt;a href=<span class=\"pl-cce\">\\\"</span>javascript:;<span class=\"pl-cce\">\\\"</span> title=<span class=\"pl-cce\">\\\"</span>ucwords<span class=\"pl-cce\">\\\"</span> unselectable=<span class=\"pl-cce\">\\\"</span>on<span class=\"pl-cce\">\\\"</span>&gt;&lt;i class=<span class=\"pl-cce\">\\\"</span>fa<span class=\"pl-cce\">\\\"</span> name=<span class=\"pl-cce\">\\\"</span>ucwords<span class=\"pl-cce\">\\\"</span> style=<span class=\"pl-cce\">\\\"</span>font-size:20px;margin-top: -3px;<span class=\"pl-cce\">\\\"</span>&gt;Aa&lt;/i&gt;&lt;/a&gt;<span class=\"pl-pds\">\"</span></span>\r\n    },\r\n    toolbarIconTexts     <span class=\"pl-k\">:</span> {},\r\n    \r\n    lang <span class=\"pl-k\">:</span> {  <span class=\"pl-c\"><span class=\"pl-c\">//</span> Language data, you can custom your language.</span>\r\n        name        <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>zh-cn<span class=\"pl-pds\">\"</span></span>,\r\n        description <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>开源在线Markdown编辑器&lt;br/&gt;Open source online Markdown editor.<span class=\"pl-pds\">\"</span></span>,\r\n        tocTitle    <span class=\"pl-k\">:</span> <span class=\"pl-s\"><span class=\"pl-pds\">\"</span>目录<span class=\"pl-pds\">\"</span></span>,\r\n        toolbar     <span class=\"pl-k\">:</span> {\r\n            <span class=\"pl-c\"><span class=\"pl-c\">//</span>...</span>\r\n        },\r\n        button<span class=\"pl-k\">:</span> {\r\n            <span class=\"pl-c\"><span class=\"pl-c\">//</span>...</span>\r\n        },\r\n        dialog <span class=\"pl-k\">:</span> {\r\n            <span class=\"pl-c\"><span class=\"pl-c\">//</span>...</span>\r\n        }\r\n        <span class=\"pl-c\"><span class=\"pl-c\">//</span>...</span>\r\n    }\r\n}</pre></div>\r\n<h4><a id=\"user-content-dependents\" class=\"anchor\" aria-hidden=\"true\" href=\"#dependents\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>Dependents</h4>\r\n<ul>\r\n<li><a href=\"http://codemirror.net/\" title=\"CodeMirror\" rel=\"nofollow\">CodeMirror</a></li>\r\n<li><a href=\"https://github.com/markedjs/marked\" title=\"marked\">marked</a></li>\r\n<li><a href=\"http://jquery.com/\" title=\"jQuery\" rel=\"nofollow\">jQuery</a></li>\r\n<li><a href=\"http://fontawesome.io/\" title=\"FontAwesome\" rel=\"nofollow\">FontAwesome</a></li>\r\n<li><a href=\"https://github.com/sindresorhus/github-markdown-css\" title=\"github-markdown.css\">github-markdown.css</a></li>\r\n<li><a href=\"http://khan.github.io/KaTeX/\" title=\"KaTeX\" rel=\"nofollow\">KaTeX</a></li>\r\n<li><a href=\"http://code.google.com/p/google-code-prettify/\" title=\"prettify.js\" rel=\"nofollow\">prettify.js</a></li>\r\n<li><a href=\"http://raphaeljs.com/\" title=\"Rephael.js\" rel=\"nofollow\">Rephael.js</a></li>\r\n<li><a href=\"http://adrai.github.io/flowchart.js/\" title=\"flowchart.js\" rel=\"nofollow\">flowchart.js</a></li>\r\n<li><a href=\"http://bramp.github.io/js-sequence-diagrams/\" title=\"sequence-diagram.js\" rel=\"nofollow\">sequence-diagram.js</a></li>\r\n<li><a href=\"https://github.com/pandao/prefixes.scss\" title=\"Prefixes.scss\">Prefixes.scss</a></li>\r\n</ul>\r\n<h4><a id=\"user-content-changes\" class=\"anchor\" aria-hidden=\"true\" href=\"#changes\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>Changes</h4>\r\n<p><a href=\"https://github.com/pandao/editor.md/blob/master/CHANGE.md\">Change logs</a></p>\r\n<h4><a id=\"user-content-license\" class=\"anchor\" aria-hidden=\"true\" href=\"#license\"><svg class=\"octicon octicon-link\" viewBox=\"0 0 16 16\" version=\"1.1\" width=\"16\" height=\"16\" aria-hidden=\"true\"><path fill-rule=\"evenodd\" d=\"M4 9h1v1H4c-1.5 0-3-1.69-3-3.5S2.55 3 4 3h4c1.45 0 3 1.69 3 3.5 0 1.41-.91 2.72-2 3.25V8.59c.58-.45 1-1.27 1-2.09C10 5.22 8.98 4 8 4H4c-.98 0-2 1.22-2 2.5S3 9 4 9zm9-3h-1v1h1c1 0 2 1.22 2 2.5S13.98 12 13 12H9c-.98 0-2-1.22-2-2.5 0-.83.42-1.64 1-2.09V6.25c-1.09.53-2 1.84-2 3.25C6 11.31 7.55 13 9 13h4c1.45 0 3-1.69 3-3.5S14.5 6 13 6z\"></path></svg></a>License</h4>\r\n<p>The MIT License.</p>\r\n<p>Copyright (c) 2015-2019 Pandao</p>\r\n</article>', 2, 1);
INSERT INTO `entity_blog` VALUES ('4', '5 种编程语言可能注定失败！', 111, '2019-08-01 12:49:51', NULL, '5 种编程语言可能注定失败！5 种编程语言可能注定失败！5 种编程语言可能注定失败！5 种编程语言可能注定失败！5 种编程语言可能注定失败！', 'asdfasdfsdwererwqerqw', 2, 2);
INSERT INTO `entity_blog` VALUES ('5', '为程序员讨回失去的午觉，我被投诉了，差点吃官司', 111, '2019-08-06 22:49:51', NULL, '为程序员讨回失去的午觉，我被投诉了，差点吃官司为程序员讨回失去的午觉，我被投诉了，差点吃官司为程序员讨回失去的午觉，我被投诉了，差点吃官司为程序员讨回失去的午觉，我被投诉了，差点吃官司', 'asdfasdfasdfadsfnakdjfklasjdflkasdf', 3, 3);
INSERT INTO `entity_blog` VALUES ('6', '1', 111, '2019-08-11 12:07:21', NULL, '1', '1', 1, 1);
INSERT INTO `entity_blog` VALUES ('664365a84e3a490096308a5bd74d7c73', '第二天学java', 111, '2019-09-01 13:34:53', NULL, '一段神秘代码：\nprint(\"helloworld\")\n', '<div class=\"article-intro\" id=\"content\">\r\n			\r\n			<h1>Bootstrap4 <span class=\"color_h1\">教程</span></h1>\r\n<div class=\"tutintro\">\r\n<img src=\"//www.runoob.com/wp-content/uploads/2017/10/bootstrap-stack.png\" alt=\"Bootstrap 教程\" width=\"128\" height=\"128\">\r\n<p>\r\nBootstrap 是全球最受欢迎的前端组件库，用于开发响应式布局、移动设备优先的 WEB 项目。</p><p>\r\nBootstrap4 目前是 Bootstrap 的最新版本，是一套用于 HTML、CSS 和 JS 开发的开源工具集。利用我们提供的 Sass 变量和大量 mixin、响应式栅格系统、可扩展的预制组件、基于 jQuery 的强大的插件系统，能够快速为你的想法开发出原型或者构建整个 app 。</p>\r\n</div>\r\n\r\n<h2 class=\"tutheader\">谁适合阅读本教程？</h2>\r\n<p>只要您具备 HTML 和 CSS 的基础知识，您就可以阅读本教程，进而开发出自己的网站。在您学习完本教程后，您即可达到使用 Bootstrap 开发 Web 项目的中等水平。</p>\r\n\r\n<h2 class=\"tutheader\">阅读本教程前，您需要了解的知识：</h2>\r\n<p>在您开始阅读本教程之前，您必须具备 HTML 、 CSS 和 JavaScript 的基础知识。如果您还不了解这些概念，那么建议您先阅读我们的这些教程: \r\n</p><ul>\r\n<li><a href=\"/html/html-tutorial.html\" title=\"HTML 教程\">HTML 教程</a> </li>\r\n<li><a href=\"/css/css-tutorial.html\" title=\"CSS 教程\">CSS 教程</a></li>\r\n<li><a href=\"/js/js-tutorial.html\" title=\"JavaScript 教程\">JavaScript 教程</a></li>\r\n</ul>\r\n\r\n<h2 class=\"tutheader\">Bootstrap4 实例</h2>\r\n\r\n<div class=\"example\">\r\n<h2 class=\"example_head\">Bootstrap4 实例</h2>\r\n<div class=\"example_code\">\r\n<div class=\"hl-main\"><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">div</span><span class=\"hl-code\"> </span><span class=\"hl-var\">class</span><span class=\"hl-code\">=</span><span class=\"hl-quotes\">\"</span><span class=\"hl-string\">jumbotron text-center</span><span class=\"hl-quotes\">\"</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n  </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">h1</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">我的第一个 Bootstrap 页面</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">h1</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n  </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">重置浏览器大小查看效果!</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\"> \r\n</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">div</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n \r\n</span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">div</span><span class=\"hl-code\"> </span><span class=\"hl-var\">class</span><span class=\"hl-code\">=</span><span class=\"hl-quotes\">\"</span><span class=\"hl-string\">container</span><span class=\"hl-quotes\">\"</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n  </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">div</span><span class=\"hl-code\"> </span><span class=\"hl-var\">class</span><span class=\"hl-code\">=</span><span class=\"hl-quotes\">\"</span><span class=\"hl-string\">row</span><span class=\"hl-quotes\">\"</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n    </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">div</span><span class=\"hl-code\"> </span><span class=\"hl-var\">class</span><span class=\"hl-code\">=</span><span class=\"hl-quotes\">\"</span><span class=\"hl-string\">col-sm-4</span><span class=\"hl-quotes\">\"</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">h3</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">第一列</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">h3</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">菜鸟教程</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">学的不仅是技术，更是梦想！！！</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n    </span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">div</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n    </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">div</span><span class=\"hl-code\"> </span><span class=\"hl-var\">class</span><span class=\"hl-code\">=</span><span class=\"hl-quotes\">\"</span><span class=\"hl-string\">col-sm-4</span><span class=\"hl-quotes\">\"</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">h3</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">第二列</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">h3</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">菜鸟教程..</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">学的不仅是技术，更是梦想！！！</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n    </span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">div</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n    </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">div</span><span class=\"hl-code\"> </span><span class=\"hl-var\">class</span><span class=\"hl-code\">=</span><span class=\"hl-quotes\">\"</span><span class=\"hl-string\">col-sm-4</span><span class=\"hl-quotes\">\"</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">h3</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">第三列</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">h3</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\"> \r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">菜鸟教程..</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">学的不仅是技术，更是梦想！！！</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n    </span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">div</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n  </span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">div</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">div</span><span class=\"hl-brackets\">&gt;</span></div>\r\n</div>\r\n<br><a target=\"_blank\" href=\"/try/try.php?filename=trybs4_default\" class=\"tryitbtn\">尝试一下 »</a></div>\r\n\r\n<h2 class=\"tutheader\">Bootstrap4  与 Bootstrap3</h2>\r\n<p>Bootstrap4 是 Bootstrap 的最新版本，与 Bootstrap3 相比拥有了更多的具体的类以及把一些有关的部分变成了相关的组件。同时 Bootstrap.min.css 的体积减少了40%以上。</p>\r\n\r\n<p>Bootstrap4 放弃了对 IE8 以及 iOS 6 的支持，现在仅仅支持 IE9 以上 以及 iOS 7 以上版本的浏览器。如果对于其中需要用到以前的浏览器，那么请使用 <a href=\"/bootstrap/bootstrap-tutorial.html\" rel=\"noopener\" target=\"_blank\">Bootstrap3</a>。</p>			<!-- 其他扩展 -->\r\n						\r\n			</div>', 1, 1);
INSERT INTO `entity_blog` VALUES ('7', '1', 111, '2019-08-11 14:38:28', NULL, '1', '1', 1, 1);
INSERT INTO `entity_blog` VALUES ('8', '啊手动阀手动阀', 111, '2019-08-11 20:09:20', NULL, 'Disabled optionsEditor.md directoryDisabled optio', '<div class=\"markdown-toc editormd-markdown-toc\"><ul class=\"markdown-toc-list\"><li><a class=\"toc-level-4\" href=\"#Disabled options\" level=\"4\">Disabled options</a></li><li><a class=\"toc-level-4\" href=\"#Editor.md directory\" level=\"4\">Editor.md directory</a><ul></ul></li></ul></div><h4 id=\"h4-disabled-options\"><a name=\"Disabled options\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Disabled options</h4><ul>\n<li>TeX (Based on KaTeX);</li><li>Emoji;</li><li>Task lists;</li><li>HTML tags decode;</li><li>Flowchart and Sequence Diagram;</li></ul>\n<h4 id=\"h4-editor-md-directory\"><a name=\"Editor.md directory\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Editor.md directory</h4><p>editor.md/<br>        lib/<br>        css/<br>        scss/<br>        tests/<br>        fonts/<br>        images/<br>        plugins/<br>        examples/<br>        languages/<br>        editormd.js<br>        …</p>\n', 1, 1);
INSERT INTO `entity_blog` VALUES ('84407d904f434baf9e15c76b90beeccf', '第一天学Java', 111, '2019-09-01 13:33:55', NULL, 'System.out.print(“HelloWorl”)\n', '<p>System.out.print(“HelloWorl”)</p>\n', 2, 1);
INSERT INTO `entity_blog` VALUES ('8ef1c008cf7146b088828f44d748beba', 'SpringSecurity + SpringBoot 应用经验', 222, '2019-09-08 16:20:12', NULL, '\n为什么选择SpringSecurity，因为它是Spring的框架。\n\n实现 SimpleUrl', '<blockquote>\n<p>为什么选择SpringSecurity，因为它是Spring的框架。</p>\n</blockquote>\n<p>实现 <code>SimpleUrlAuthenticationFailureHandler</code> 接口，用户登录失败时，你可以做一些操作。<br>比如：</p>\n<ol>\n<li>统计用户登录失败次数，</li><li>删除用户session。</li><li>登录失败后，返回json的设置等。</li></ol>\n<p>实现<code>SavedRequestAwareAuthenticationSuccessHandler</code>接口，用户登录成功时，你可以在这里做一些操作，比如：</p>\n<ol>\n<li>统计用户登录时间</li><li>登录成功，返回数据等</li></ol>\n<p>实现 <code>UserDetailsService</code> 通过用户名获取用户。</p>\n<ol>\n<li><p>可以在这个接口中写保存登录的用户信息到session中</p>\n<pre><code><a href=\"https://github.com/Component\" title=\"@Component\" class=\"at-link\">@Component</a>\npublic class SecurityUserDetailsService implements UserDetailsService {\n\n private Logger logger = LoggerFactory.getLogger(getClass());\n\n <a href=\"https://github.com/Autowired\" title=\"@Autowired\" class=\"at-link\">@Autowired</a>\n private UserService userServiceImpl;\n\n <a href=\"https://github.com/Autowired\" title=\"@Autowired\" class=\"at-link\">@Autowired</a>\n private HttpSession session;\n\n <a href=\"https://github.com/Override\" title=\"@Override\" class=\"at-link\">@Override</a>\n public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {\n\n     logger.info(\"登录用户名：{}\",userServiceImpl.selectUserByName(username));\n\n     com.jnnvc.vblog.entity.User u = userServiceImpl.selectUserByName(username);\n\n     session.setAttribute(SessionKey.USER_INFO,u);\n\n     //根据用户名查找用户信息\n     User user = new User(username,userServiceImpl.selectUserByName(username).getPassword(),\n             true,true,true,true,\n             AuthorityUtils.commaSeparatedStringToAuthorityList(\"admin\"));\n\n     return user;\n }\n\n public UserService getUserServiceImpl() {\n     return userServiceImpl;\n }\n}\n</code></pre></li></ol>\n', 2, 1);
INSERT INTO `entity_blog` VALUES ('9', 'asdf ', 111, '2019-08-11 20:14:56', NULL, 'Disabled optionsEditor.md directoryDisabled optio', '<div class=\"markdown-toc editormd-markdown-toc\"><ul class=\"markdown-toc-list\"><li><a class=\"toc-level-4\" href=\"#Disabled options\" level=\"4\">Disabled options</a></li><li><a class=\"toc-level-4\" href=\"#Editor.md directory\" level=\"4\">Editor.md directory</a><ul></ul></li></ul></div><h4 id=\"h4-disabled-options\"><a name=\"Disabled options\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Disabled options</h4><ul>\n<li>TeX (Based on KaTeX);</li><li>Emoji;</li><li>Task lists;</li><li>HTML tags decode;</li><li>Flowchart and Sequence Diagram;</li></ul>\n<h4 id=\"h4-editor-md-directory\"><a name=\"Editor.md directory\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Editor.md directory</h4><p>editor.md/<br>        lib/<br>        css/<br>        scss/<br>        tests/<br>        fonts/<br>        images/<br>        plugins/<br>        examples/<br>        languages/<br>        editormd.js<br>        …</p>\n', 1, 1);
INSERT INTO `entity_blog` VALUES ('97dd1ae2e0d14f4bb2d632b8dc52448e', '开发统一文档', 222, '2019-09-08 16:44:51', NULL, 'Controller接口统一返回对象 com.jnnvc.vblog.controller.web', '<h4 id=\"h4-controller\"><a name=\"Controller\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>Controller</h4><p>接口统一返回对象 <code>com.jnnvc.vblog.controller.web.BlogController</code></p>\n<p>成功：<code>ResponseData.successful(data);</code><br>失败：<code>ResponseData.error(\"BlogDoecNotExist\",\"博客不存在，无法评论\");</code></p>\n<h4 id=\"h4-u6570u636Eu4E3Bu952E\"><a name=\"数据主键\" class=\"reference-link\"></a><span class=\"header-link octicon octicon-link\"></span>数据主键</h4><p>普通用户添加的数据，统一使用UUID Hutool <code>IdUtil.fastSimpleUUID();</code> 获取ID</p>\n', 1, 1);
INSERT INTO `entity_blog` VALUES ('9d1aeb2fc30146db87209accb96a7c7e', '阿道夫', 111, '2019-09-01 13:04:41', NULL, '阿道夫///\n', '<div class=\"article-intro\" id=\"content\">\r\n			\r\n			<h1>Bootstrap4 <span class=\"color_h1\">教程</span></h1>\r\n<div class=\"tutintro\">\r\n<img src=\"//www.runoob.com/wp-content/uploads/2017/10/bootstrap-stack.png\" alt=\"Bootstrap 教程\" width=\"128\" height=\"128\">\r\n<p>\r\nBootstrap 是全球最受欢迎的前端组件库，用于开发响应式布局、移动设备优先的 WEB 项目。</p><p>\r\nBootstrap4 目前是 Bootstrap 的最新版本，是一套用于 HTML、CSS 和 JS 开发的开源工具集。利用我们提供的 Sass 变量和大量 mixin、响应式栅格系统、可扩展的预制组件、基于 jQuery 的强大的插件系统，能够快速为你的想法开发出原型或者构建整个 app 。</p>\r\n</div>\r\n\r\n<h2 class=\"tutheader\">谁适合阅读本教程？</h2>\r\n<p>只要您具备 HTML 和 CSS 的基础知识，您就可以阅读本教程，进而开发出自己的网站。在您学习完本教程后，您即可达到使用 Bootstrap 开发 Web 项目的中等水平。</p>\r\n\r\n<h2 class=\"tutheader\">阅读本教程前，您需要了解的知识：</h2>\r\n<p>在您开始阅读本教程之前，您必须具备 HTML 、 CSS 和 JavaScript 的基础知识。如果您还不了解这些概念，那么建议您先阅读我们的这些教程: \r\n</p><ul>\r\n<li><a href=\"/html/html-tutorial.html\" title=\"HTML 教程\">HTML 教程</a> </li>\r\n<li><a href=\"/css/css-tutorial.html\" title=\"CSS 教程\">CSS 教程</a></li>\r\n<li><a href=\"/js/js-tutorial.html\" title=\"JavaScript 教程\">JavaScript 教程</a></li>\r\n</ul>\r\n\r\n<h2 class=\"tutheader\">Bootstrap4 实例</h2>\r\n\r\n<div class=\"example\">\r\n<h2 class=\"example_head\">Bootstrap4 实例</h2>\r\n<div class=\"example_code\">\r\n<div class=\"hl-main\"><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">div</span><span class=\"hl-code\"> </span><span class=\"hl-var\">class</span><span class=\"hl-code\">=</span><span class=\"hl-quotes\">\"</span><span class=\"hl-string\">jumbotron text-center</span><span class=\"hl-quotes\">\"</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n  </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">h1</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">我的第一个 Bootstrap 页面</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">h1</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n  </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">重置浏览器大小查看效果!</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\"> \r\n</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">div</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n \r\n</span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">div</span><span class=\"hl-code\"> </span><span class=\"hl-var\">class</span><span class=\"hl-code\">=</span><span class=\"hl-quotes\">\"</span><span class=\"hl-string\">container</span><span class=\"hl-quotes\">\"</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n  </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">div</span><span class=\"hl-code\"> </span><span class=\"hl-var\">class</span><span class=\"hl-code\">=</span><span class=\"hl-quotes\">\"</span><span class=\"hl-string\">row</span><span class=\"hl-quotes\">\"</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n    </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">div</span><span class=\"hl-code\"> </span><span class=\"hl-var\">class</span><span class=\"hl-code\">=</span><span class=\"hl-quotes\">\"</span><span class=\"hl-string\">col-sm-4</span><span class=\"hl-quotes\">\"</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">h3</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">第一列</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">h3</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">菜鸟教程</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">学的不仅是技术，更是梦想！！！</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n    </span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">div</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n    </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">div</span><span class=\"hl-code\"> </span><span class=\"hl-var\">class</span><span class=\"hl-code\">=</span><span class=\"hl-quotes\">\"</span><span class=\"hl-string\">col-sm-4</span><span class=\"hl-quotes\">\"</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">h3</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">第二列</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">h3</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">菜鸟教程..</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">学的不仅是技术，更是梦想！！！</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n    </span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">div</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n    </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">div</span><span class=\"hl-code\"> </span><span class=\"hl-var\">class</span><span class=\"hl-code\">=</span><span class=\"hl-quotes\">\"</span><span class=\"hl-string\">col-sm-4</span><span class=\"hl-quotes\">\"</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">h3</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">第三列</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">h3</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\"> \r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">菜鸟教程..</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n      </span><span class=\"hl-brackets\">&lt;</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">学的不仅是技术，更是梦想！！！</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">p</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n    </span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">div</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n  </span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">div</span><span class=\"hl-brackets\">&gt;</span><span class=\"hl-code\">\r\n</span><span class=\"hl-brackets\">&lt;/</span><span class=\"hl-reserved\">div</span><span class=\"hl-brackets\">&gt;</span></div>\r\n</div>\r\n<br><a target=\"_blank\" href=\"/try/try.php?filename=trybs4_default\" class=\"tryitbtn\">尝试一下 »</a></div>\r\n\r\n<h2 class=\"tutheader\">Bootstrap4  与 Bootstrap3</h2>\r\n<p>Bootstrap4 是 Bootstrap 的最新版本，与 Bootstrap3 相比拥有了更多的具体的类以及把一些有关的部分变成了相关的组件。同时 Bootstrap.min.css 的体积减少了40%以上。</p>\r\n\r\n<p>Bootstrap4 放弃了对 IE8 以及 iOS 6 的支持，现在仅仅支持 IE9 以上 以及 iOS 7 以上版本的浏览器。如果对于其中需要用到以前的浏览器，那么请使用 <a href=\"/bootstrap/bootstrap-tutorial.html\" rel=\"noopener\" target=\"_blank\">Bootstrap3</a>。</p>			<!-- 其他扩展 -->\r\n						\r\n			</div>', 1, 1);
INSERT INTO `entity_blog` VALUES ('bf2ab491455a4b23a2deb828a64e112e', '一篇前端日志', 222, '2019-09-02 20:19:25', NULL, '游戏\n', '<p>游戏</p>\n', 4, 1);
INSERT INTO `entity_blog` VALUES ('fedc39d6bfeb4b4cae01e69234dedc50', 'adfasdfadsf', 111, '2019-09-17 22:28:07', NULL, 'asdfadsfasdfasdfadsf\n', '<p>asdfadsfasdfasdfadsf</p>\n', 1, 1);

-- ----------------------------
-- Table structure for entity_blog_class
-- ----------------------------
DROP TABLE IF EXISTS `entity_blog_class`;
CREATE TABLE `entity_blog_class`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of entity_blog_class
-- ----------------------------
INSERT INTO `entity_blog_class` VALUES (1, '日志');
INSERT INTO `entity_blog_class` VALUES (2, 'Java');
INSERT INTO `entity_blog_class` VALUES (3, 'Python');
INSERT INTO `entity_blog_class` VALUES (4, '前端');

-- ----------------------------
-- Table structure for entity_blog_comment
-- ----------------------------
DROP TABLE IF EXISTS `entity_blog_comment`;
CREATE TABLE `entity_blog_comment`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `blog_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `comment_status` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0' COMMENT '评论状态',
  `comment_user_id` int(11) DEFAULT NULL COMMENT '评论人',
  `comment_content` varchar(2000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '评论内容',
  `create_time` datetime(0) DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of entity_blog_comment
-- ----------------------------
INSERT INTO `entity_blog_comment` VALUES ('1', '1', '0', 1, '一条评论', '2019-09-01 20:53:08');
INSERT INTO `entity_blog_comment` VALUES ('8c2ab1de033542c389ecf70f2f17e3a7', '26c0fd33c3a34ee2abdc7b545e9cb287', '0', 111, '1', '2019-09-01 20:59:55');
INSERT INTO `entity_blog_comment` VALUES ('fc881098150b440eafa78ef1c7f555ca', '26c0fd33c3a34ee2abdc7b545e9cb287', '0', 111, '1', '2019-09-01 20:59:52');

-- ----------------------------
-- Table structure for entity_blog_comment_child
-- ----------------------------
DROP TABLE IF EXISTS `entity_blog_comment_child`;
CREATE TABLE `entity_blog_comment_child`  (
  `id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `comment_id` int(11) DEFAULT NULL COMMENT '主评论',
  `crate_user` int(11) DEFAULT NULL,
  `child_comments_content` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '评论内容',
  `child_comments_num` int(11) DEFAULT NULL COMMENT '点赞',
  `child_comment_status` enum('0','1') CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '0',
  `upper_level_id` int(11) DEFAULT -1 COMMENT '上一级评论,主评论\'0\',\'-1\'还没有被评论',
  `add_Time` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for entity_blog_state
-- ----------------------------
DROP TABLE IF EXISTS `entity_blog_state`;
CREATE TABLE `entity_blog_state`  (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for entity_cyun
-- ----------------------------
DROP TABLE IF EXISTS `entity_cyun`;
CREATE TABLE `entity_cyun`  (
  `id` varchar(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `text` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_date` datetime(0) DEFAULT NULL,
  `create_user_id` int(11) DEFAULT NULL,
  `update_date` datetime(0) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for entity_cyun_class
-- ----------------------------
DROP TABLE IF EXISTS `entity_cyun_class`;
CREATE TABLE `entity_cyun_class`  (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for entity_cyun_comment
-- ----------------------------
DROP TABLE IF EXISTS `entity_cyun_comment`;
CREATE TABLE `entity_cyun_comment`  (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for entity_cyun_state
-- ----------------------------
DROP TABLE IF EXISTS `entity_cyun_state`;
CREATE TABLE `entity_cyun_state`  (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for entity_like
-- ----------------------------
DROP TABLE IF EXISTS `entity_like`;
CREATE TABLE `entity_like`  (
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `data_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `create_date` datetime(0) DEFAULT NULL,
  UNIQUE INDEX `some_name`(`user_id`, `data_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of entity_like
-- ----------------------------
INSERT INTO `entity_like` VALUES ('2', '2', '2019-10-04 20:18:35');
INSERT INTO `entity_like` VALUES ('3', '3', '2019-10-04 20:18:45');
INSERT INTO `entity_like` VALUES ('3', '4', '2019-10-04 20:27:55');
INSERT INTO `entity_like` VALUES ('1', '1', '2019-10-04 20:41:05');
INSERT INTO `entity_like` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 21:00:42');

-- ----------------------------
-- Table structure for entity_pageview
-- ----------------------------
DROP TABLE IF EXISTS `entity_pageview`;
CREATE TABLE `entity_pageview`  (
  `user_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT '0' COMMENT '阅读者',
  `data_id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '阅读信息ID',
  `create_datetime` datetime(0) DEFAULT NULL COMMENT '创建时间',
  INDEX `syin`(`data_id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of entity_pageview
-- ----------------------------
INSERT INTO `entity_pageview` VALUES ('1', '1', '2019-09-19 19:11:15');
INSERT INTO `entity_pageview` VALUES ('2', '2', '2019-09-19 19:22:37');
INSERT INTO `entity_pageview` VALUES ('2', '2', '2019-09-19 19:22:40');
INSERT INTO `entity_pageview` VALUES ('2', '2', '2019-09-19 19:22:41');
INSERT INTO `entity_pageview` VALUES ('2', '2', '2019-09-19 19:22:41');
INSERT INTO `entity_pageview` VALUES ('2', '2', '2019-09-19 19:22:42');
INSERT INTO `entity_pageview` VALUES ('1', '1', '2019-09-19 19:26:51');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:02:27');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:02:32');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:02:33');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:02:35');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:02:36');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:02:37');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:02:38');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:02:41');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:02:42');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:02:43');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:02:44');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:02:47');
INSERT INTO `entity_pageview` VALUES ('0', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-09-19 20:02:52');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:02:54');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-09-19 20:02:56');
INSERT INTO `entity_pageview` VALUES ('0', '033a91c457354943aaf168652620b782', '2019-09-19 20:02:59');
INSERT INTO `entity_pageview` VALUES ('0', '033a91c457354943aaf168652620b782', '2019-09-19 20:03:03');
INSERT INTO `entity_pageview` VALUES ('0', '033a91c457354943aaf168652620b782', '2019-09-19 20:03:03');
INSERT INTO `entity_pageview` VALUES ('0', '033a91c457354943aaf168652620b782', '2019-09-19 20:03:04');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:06');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:09');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:10');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:10');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:11');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:11');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:12');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:12');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:13');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:13');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:14');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:15');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:15');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:16');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:16');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:17');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:17');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:18');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:18');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:19');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:19');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:20');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:20');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:21');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:21');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:22');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:22');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:23');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:23');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:24');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:24');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:25');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:25');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:26');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:26');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:27');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:27');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:28');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:28');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:29');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:29');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:30');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:30');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:04:31');
INSERT INTO `entity_pageview` VALUES ('0', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-09-19 20:05:44');
INSERT INTO `entity_pageview` VALUES ('0', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-09-19 20:05:47');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:06:29');
INSERT INTO `entity_pageview` VALUES ('0', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-09-19 20:12:59');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:10');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:12');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:13');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:13');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:14');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:15');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:15');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:16');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:16');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:23');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:24');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:25');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:26');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:27');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:28');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:29');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:29');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:30');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:13:31');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:15:41');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:16:10');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:16:10');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:16:11');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:16:11');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:16:11');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:16:12');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:17:40');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:17:44');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:17:44');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:18:56');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:18:56');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:18:57');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:18:57');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:18:58');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:18:58');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:18:58');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:18:59');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:18:59');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:18:59');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:18:59');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:19:00');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:19:00');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:23:35');
INSERT INTO `entity_pageview` VALUES ('0', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-09-19 20:24:49');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:26:30');
INSERT INTO `entity_pageview` VALUES ('0', '1', '2019-09-19 20:26:45');
INSERT INTO `entity_pageview` VALUES ('0', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-09-19 20:28:09');
INSERT INTO `entity_pageview` VALUES ('0', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-09-19 20:28:14');
INSERT INTO `entity_pageview` VALUES ('0', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-09-19 20:28:19');
INSERT INTO `entity_pageview` VALUES ('0', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-09-19 20:28:27');
INSERT INTO `entity_pageview` VALUES ('0', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-09-19 20:28:28');
INSERT INTO `entity_pageview` VALUES ('0', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-09-19 20:28:38');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:29:02');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:32:49');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:33:24');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:33:24');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:33:25');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:34:55');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:35:35');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:35:39');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:35:49');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:35:49');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:35:50');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:35:50');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:36:07');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:36:08');
INSERT INTO `entity_pageview` VALUES ('0', '1', '2019-09-19 20:36:15');
INSERT INTO `entity_pageview` VALUES ('0', '1', '2019-09-19 20:36:20');
INSERT INTO `entity_pageview` VALUES ('0', '1', '2019-09-19 20:37:39');
INSERT INTO `entity_pageview` VALUES ('0', '1', '2019-09-19 20:37:44');
INSERT INTO `entity_pageview` VALUES ('0', '1', '2019-09-19 20:37:55');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 20:38:19');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:31');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:38');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:39');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:39');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:39');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:40');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:41');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:41');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:42');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:42');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:43');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:43');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:44');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:45');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-09-19 21:52:45');
INSERT INTO `entity_pageview` VALUES ('0', '10', '2019-10-03 11:04:59');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:06:14');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:06:20');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:07:30');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:07:31');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:07:34');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:10:57');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:10:59');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:11:00');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:11:01');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:11:01');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:14:53');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:14:54');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:14:54');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:27:30');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:27:32');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:27:33');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:27:34');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:27:34');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:27:35');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:27:36');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:27:36');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:27:37');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:27:39');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:28:35');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:28:40');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:29:16');
INSERT INTO `entity_pageview` VALUES ('111', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-10-03 11:29:20');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:29:25');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:31:03');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:31:03');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:31:04');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:31:05');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:31:05');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:31:06');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:31:06');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:31:36');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:31:55');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:31:57');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:32:10');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:32:22');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:32:38');
INSERT INTO `entity_pageview` VALUES ('111', '9d1aeb2fc30146db87209accb96a7c7e', '2019-10-03 11:32:43');
INSERT INTO `entity_pageview` VALUES ('111', '9d1aeb2fc30146db87209accb96a7c7e', '2019-10-03 11:33:08');
INSERT INTO `entity_pageview` VALUES ('111', '9d1aeb2fc30146db87209accb96a7c7e', '2019-10-03 11:34:16');
INSERT INTO `entity_pageview` VALUES ('111', '9d1aeb2fc30146db87209accb96a7c7e', '2019-10-03 11:34:51');
INSERT INTO `entity_pageview` VALUES ('111', '9d1aeb2fc30146db87209accb96a7c7e', '2019-10-03 11:36:21');
INSERT INTO `entity_pageview` VALUES ('111', '9d1aeb2fc30146db87209accb96a7c7e', '2019-10-03 11:36:54');
INSERT INTO `entity_pageview` VALUES ('111', '9d1aeb2fc30146db87209accb96a7c7e', '2019-10-03 11:37:18');
INSERT INTO `entity_pageview` VALUES ('111', '9d1aeb2fc30146db87209accb96a7c7e', '2019-10-03 11:37:32');
INSERT INTO `entity_pageview` VALUES ('111', '9d1aeb2fc30146db87209accb96a7c7e', '2019-10-03 11:37:38');
INSERT INTO `entity_pageview` VALUES ('111', '9d1aeb2fc30146db87209accb96a7c7e', '2019-10-03 11:38:46');
INSERT INTO `entity_pageview` VALUES ('111', '9d1aeb2fc30146db87209accb96a7c7e', '2019-10-03 11:39:02');
INSERT INTO `entity_pageview` VALUES ('111', '9d1aeb2fc30146db87209accb96a7c7e', '2019-10-03 11:41:48');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:43:33');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:44:12');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:45:30');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:45:46');
INSERT INTO `entity_pageview` VALUES ('111', '84407d904f434baf9e15c76b90beeccf', '2019-10-03 11:46:12');
INSERT INTO `entity_pageview` VALUES ('111', '84407d904f434baf9e15c76b90beeccf', '2019-10-03 11:46:16');
INSERT INTO `entity_pageview` VALUES ('111', '8ef1c008cf7146b088828f44d748beba', '2019-10-03 11:47:44');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:48:16');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:49:55');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:49:57');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:49:57');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:49:58');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:50:07');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:55:54');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:55:55');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:55:56');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:55:56');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:55:56');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:55:57');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:55:57');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:58:56');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 11:59:03');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 12:00:59');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 12:01:00');
INSERT INTO `entity_pageview` VALUES ('0', '26c0fd33c3a34ee2abdc7b545e9cb287', '2019-10-03 12:09:36');
INSERT INTO `entity_pageview` VALUES ('0', '26c0fd33c3a34ee2abdc7b545e9cb287', '2019-10-03 12:09:40');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 13:08:06');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 13:08:08');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 13:08:16');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 13:08:28');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 13:09:42');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 13:09:43');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 13:11:13');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 13:11:14');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 13:11:14');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 13:11:15');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-03 13:11:17');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-03 13:11:26');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-03 13:13:46');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-03 13:13:47');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-03 13:15:28');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-03 13:15:33');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-03 13:16:15');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-03 13:16:57');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-03 13:17:58');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-03 13:17:59');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-03 13:18:19');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-03 13:18:27');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-03 13:19:18');
INSERT INTO `entity_pageview` VALUES ('0', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-03 13:20:43');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 19:41:19');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 19:42:35');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 19:42:37');
INSERT INTO `entity_pageview` VALUES ('0', '8ef1c008cf7146b088828f44d748beba', '2019-10-04 19:42:39');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:42:44');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:15');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:16');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:16');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:17');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:17');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:17');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:17');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:17');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:18');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:18');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:18');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:18');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:19');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:19');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:19');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:19');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:20');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:20');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:20');
INSERT INTO `entity_pageview` VALUES ('0', '15', '2019-10-04 19:43:20');
INSERT INTO `entity_pageview` VALUES ('0', '3', '2019-10-04 19:43:26');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 19:46:13');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 19:47:18');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 19:47:19');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 19:47:20');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 19:48:08');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 20:05:39');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 20:48:50');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 20:49:01');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 20:51:10');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 20:52:32');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 20:55:44');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 21:00:34');
INSERT INTO `entity_pageview` VALUES ('111', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-04 21:02:55');
INSERT INTO `entity_pageview` VALUES ('111', 'bf2ab491455a4b23a2deb828a64e112e', '2019-10-04 21:03:05');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-06 19:10:47');
INSERT INTO `entity_pageview` VALUES ('0', '8ef1c008cf7146b088828f44d748beba', '2019-10-06 19:10:54');
INSERT INTO `entity_pageview` VALUES ('0', '8ef1c008cf7146b088828f44d748beba', '2019-10-06 19:13:37');
INSERT INTO `entity_pageview` VALUES ('0', '8ef1c008cf7146b088828f44d748beba', '2019-10-06 19:14:00');
INSERT INTO `entity_pageview` VALUES ('0', '8ef1c008cf7146b088828f44d748beba', '2019-10-06 19:16:24');
INSERT INTO `entity_pageview` VALUES ('0', '8ef1c008cf7146b088828f44d748beba', '2019-10-06 19:16:35');
INSERT INTO `entity_pageview` VALUES ('0', '8ef1c008cf7146b088828f44d748beba', '2019-10-06 19:17:32');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-07 12:35:01');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-07 12:35:43');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-07 12:36:41');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-07 12:36:44');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-07 12:37:06');
INSERT INTO `entity_pageview` VALUES ('0', '8ef1c008cf7146b088828f44d748beba', '2019-10-07 12:39:02');
INSERT INTO `entity_pageview` VALUES ('0', '3', '2019-10-07 12:39:08');
INSERT INTO `entity_pageview` VALUES ('0', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-10-07 12:40:27');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-07 12:40:31');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-07 12:43:02');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-07 12:44:17');
INSERT INTO `entity_pageview` VALUES ('0', 'fedc39d6bfeb4b4cae01e69234dedc50', '2019-10-07 12:46:18');
INSERT INTO `entity_pageview` VALUES ('0', '97dd1ae2e0d14f4bb2d632b8dc52448e', '2019-10-07 12:46:21');

-- ----------------------------
-- Table structure for entity_user
-- ----------------------------
DROP TABLE IF EXISTS `entity_user`;
CREATE TABLE `entity_user`  (
  `id` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户名',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '用户密码',
  `head_portrait` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '头像URL',
  `signature` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '签名',
  `birthday` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '生日',
  `sex` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '性别',
  `city` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '城市',
  `phone` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '手机号',
  `mail` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '邮箱号',
  `host_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '个人首页地址',
  `nickname` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '昵称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of entity_user
-- ----------------------------
INSERT INTO `entity_user` VALUES ('111', 'admin', '$2a$10$OYkw/El58TdHOsZPQeJrJ.OjeAadYuuHvfXXkfuX1JrqKhIpleb4K', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);
INSERT INTO `entity_user` VALUES ('222', '123456', '$2a$10$OYkw/El58TdHOsZPQeJrJ.OjeAadYuuHvfXXkfuX1JrqKhIpleb4K', NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL, NULL);

-- ----------------------------
-- Table structure for entity_user_class
-- ----------------------------
DROP TABLE IF EXISTS `entity_user_class`;
CREATE TABLE `entity_user_class`  (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for entity_user_state
-- ----------------------------
DROP TABLE IF EXISTS `entity_user_state`;
CREATE TABLE `entity_user_state`  (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for entity_vibo
-- ----------------------------
DROP TABLE IF EXISTS `entity_vibo`;
CREATE TABLE `entity_vibo`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '编号',
  `user_id` int(11) DEFAULT NULL COMMENT '创建者--用户id',
  `class_id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属于哪一分类编号',
  `text` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci COMMENT '内容',
  `create_date` datetime(0) DEFAULT NULL COMMENT '创建时间',
  `commentCount` int(3) DEFAULT NULL COMMENT '评论数',
  `praiseCount` int(3) DEFAULT NULL COMMENT '点赞数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for entity_vibo_class
-- ----------------------------
DROP TABLE IF EXISTS `entity_vibo_class`;
CREATE TABLE `entity_vibo_class`  (
  `id` varchar(36) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类编号',
  `name` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '分类名称',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for entity_vibo_comment
-- ----------------------------
DROP TABLE IF EXISTS `entity_vibo_comment`;
CREATE TABLE `entity_vibo_comment`  (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for entity_vibo_state
-- ----------------------------
DROP TABLE IF EXISTS `entity_vibo_state`;
CREATE TABLE `entity_vibo_state`  (
  `id` int(11) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Table structure for persistent_logins
-- ----------------------------
DROP TABLE IF EXISTS `persistent_logins`;
CREATE TABLE `persistent_logins`  (
  `username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `series` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `token` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `last_used` timestamp(0) NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP(0),
  PRIMARY KEY (`series`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
