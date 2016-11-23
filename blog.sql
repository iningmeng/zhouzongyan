/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50547
Source Host           : localhost:3306
Source Database       : blog

Target Server Type    : MYSQL
Target Server Version : 50547
File Encoding         : 65001

Date: 2016-11-23 21:15:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for articles
-- ----------------------------
DROP TABLE IF EXISTS `articles`;
CREATE TABLE `articles` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '文章序号',
  `account` varchar(255) NOT NULL COMMENT '作者',
  `indexs` varchar(255) NOT NULL COMMENT '文章编号',
  `title` varchar(255) NOT NULL COMMENT '标题',
  `category` varchar(255) NOT NULL,
  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '发布时间',
  `message` text NOT NULL COMMENT '文章内容',
  `formtext` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of articles
-- ----------------------------
INSERT INTO `articles` VALUES ('1', 'admin', '1', '用户须知', '编程', '2016-10-28 15:04:47', '内容测试', '');
INSERT INTO `articles` VALUES ('2', 'test', '2', '测试', '数码', '2016-10-28 15:05:02', 'Hello World', '');
INSERT INTO `articles` VALUES ('3', '1 ', ' bc1477644355366883', '1', '编程', '2016-10-28 04:45:55', '请输入内容...', '');
INSERT INTO `articles` VALUES ('4', '1 ', ' bc1477644439123963', '浅谈：html5和html的区别', '编程', '2016-11-20 15:12:12', '请输入内容...', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('5', '1', '74c5ef37-17f2-47c8-b162-e74a8d7c5706', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:13', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('6', '1', 'fe37a7cd-d47f-419b-b52a-21e5bcf48072', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:14', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('7', '1', 'c41cbb46-af76-4ebd-b3cb-ee2d07b0bcd0', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:16', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('8', '1', 'd7cb1ab4-011d-4ea3-9ebe-edf4cae84dd3', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:17', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('9', '1', 'f0edd4e3-052b-43f1-aa57-4fe905a8e278', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:18', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('10', '1', 'b2e71b66-237f-45aa-97b7-d75203e229ec', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:19', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('11', '1', '0666d11f-77e1-4d2e-b1bd-eae9bbad151d', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:19', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('12', '1', 'b1fa392a-d840-456e-8b31-e8863dd18153', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:20', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('13', '1', '94319d28-b1a7-48a4-adb4-1b461ca1f06c', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:21', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('14', '1', 'f9704573-d9ea-40b6-9cd4-4c2fce1aad83', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:22', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('15', '1', '10af01a3-0d4a-4789-a5ae-23e7571a69ee', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:23', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('16', '1', '1e00b282-b4b4-4798-a94f-a29a3662776a', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:23', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('17', '1', 'c3413662-9ac0-4e27-8cd1-b1321552a532', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:24', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('18', '1', '01cd544a-6f9d-4c89-b3e0-e794cbefbace', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:25', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('19', '1', '4c06fd88-d029-48d0-817a-7eb4e15efbbd', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:25', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('20', '1', '667f0ff6-1171-4aa9-84fe-7e334dfec7f1', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:26', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('21', '1', 'debf12b4-a672-47e5-83c7-6e575159b6af', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:27', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('22', '1', 'c1b14bb5-70ee-4fab-8d78-47051cb81720', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:28', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('23', '1', '7f75276b-193c-4b7f-b769-017d7ba5dff7', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:33', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('24', '1', '17ea5584-2619-4241-b28b-e5ab2ebd1184', '浅谈：html5和html的区别', '程序', '2016-11-20 15:12:32', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('25', '1', '7091f8c7-696f-463c-8eff-ecbd4b7d76f7', '浅谈：html5和html的区别', '程序', '2016-11-20 15:22:44', '			        <p>请输入内容...</p>			    <p><br></p>', '最近看群里聊天聊得最火热的莫过于手机网站和html5这两个词。可能有人会问，这两者有什么关系呢？随着这移动互联 网快速发展的时代，尤其是4G时代已经来临的时刻，加上微软对\"XP系统\"不提供更新补丁、维护的情况下。 html5+css3也逐渐的成为新一代web前端技术.....');
INSERT INTO `articles` VALUES ('26', '1', '4abdb117-e55b-4219-ac40-9af1fd03e029', '一带一路', '程序', '2016-11-22 18:03:56', '			        <p>请输入内容...</p>			    <p><img src=\"http://h.hiphotos.baidu.com/image/pic/item/f9dcd100baa1cd11dd1855cebd12c8fcc2ce2db5.jpg\"></p><p><br></p>', '请输入内容...');

-- ----------------------------
-- Table structure for comments
-- ----------------------------
DROP TABLE IF EXISTS `comments`;
CREATE TABLE `comments` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '评论序号',
  `account` varchar(255) NOT NULL COMMENT '用户账号',
  `indexs` varchar(255) NOT NULL COMMENT '文章编号',
  `time` timestamp NOT NULL DEFAULT '0000-00-00 00:00:00' ON UPDATE CURRENT_TIMESTAMP COMMENT '评论时间',
  `message` tinytext NOT NULL COMMENT '评论内容',
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comments
-- ----------------------------
INSERT INTO `comments` VALUES ('1', 'admin', '1', '2016-10-01 09:31:33', '测试');
INSERT INTO `comments` VALUES ('2', 'test', '2', '2016-10-27 09:32:33', '你好');
INSERT INTO `comments` VALUES ('3', '1', '7f75276b-193c-4b7f-b769-017d7ba5dff7', '2016-10-22 04:58:41', '123');
INSERT INTO `comments` VALUES ('4', '1', '7f75276b-193c-4b7f-b769-017d7ba5dff7', '2016-10-22 05:48:25', '234');
INSERT INTO `comments` VALUES ('5', '1', '7f75276b-193c-4b7f-b769-017d7ba5dff7', '2016-10-22 05:51:01', '456');
INSERT INTO `comments` VALUES ('6', '1', '4abdb117-e55b-4219-ac40-9af1fd03e029', '2016-10-23 00:58:12', '好图');
INSERT INTO `comments` VALUES ('7', '1', '4abdb117-e55b-4219-ac40-9af1fd03e029', '2016-11-23 13:00:56', '好图');

-- ----------------------------
-- Table structure for users
-- ----------------------------
DROP TABLE IF EXISTS `users`;
CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `account` varchar(255) NOT NULL,
  `password` varchar(255) NOT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of users
-- ----------------------------
INSERT INTO `users` VALUES ('1', 'admin', '123456', '理员');
INSERT INTO `users` VALUES ('2', 'test', '123456', '傻逼');
