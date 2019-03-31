/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50722
Source Host           : localhost:3306
Source Database       : test4

Target Server Type    : MYSQL
Target Server Version : 50722
File Encoding         : 65001

Date: 2019-03-31 20:11:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `chapter`
-- ----------------------------
DROP TABLE IF EXISTS `chapter`;
CREATE TABLE `chapter` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `title` varchar(20) NOT NULL DEFAULT '',
  `count` int(10) NOT NULL DEFAULT '0',
  `duration` time NOT NULL,
  `course_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `title` (`title`) USING BTREE
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of chapter
-- ----------------------------
INSERT INTO `chapter` VALUES ('1', 'qwe1', '121', '15:03:00', '1');
INSERT INTO `chapter` VALUES ('2', 'qwe', '12', '15:03:15', '1');
INSERT INTO `chapter` VALUES ('3', 'qwe3', '1', '15:05:21', '2');
INSERT INTO `chapter` VALUES ('4', 'qwe4', '2', '15:05:40', '3');

-- ----------------------------
-- Table structure for `course`
-- ----------------------------
DROP TABLE IF EXISTS `course`;
CREATE TABLE `course` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `course_title` varchar(20) COLLATE utf8_sinhala_ci NOT NULL,
  `course_desc` varchar(20) COLLATE utf8_sinhala_ci NOT NULL,
  `subject_id` int(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `course_title` (`course_title`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

-- ----------------------------
-- Records of course
-- ----------------------------
INSERT INTO `course` VALUES ('1', '场景秀项目开发-33', 'dsfa的说法萨达的说法', '1');
INSERT INTO `course` VALUES ('2', '响应式登录页面项目开发', 'sadf', '2');
INSERT INTO `course` VALUES ('3', 'sdfs', 'dsfds', '3');

-- ----------------------------
-- Table structure for `idcard`
-- ----------------------------
DROP TABLE IF EXISTS `idcard`;
CREATE TABLE `idcard` (
  `id` tinyint(2) NOT NULL AUTO_INCREMENT,
  `code` varchar(18) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of idcard
-- ----------------------------
INSERT INTO `idcard` VALUES ('1', '123');
INSERT INTO `idcard` VALUES ('2', '3434');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` tinyint(2) NOT NULL AUTO_INCREMENT,
  `ordersn` varchar(10) DEFAULT NULL,
  `user_id` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', 'dfasdf', '10');
INSERT INTO `orders` VALUES ('2', 'vccvb', '12');

-- ----------------------------
-- Table structure for `orders_detail`
-- ----------------------------
DROP TABLE IF EXISTS `orders_detail`;
CREATE TABLE `orders_detail` (
  `id` tinyint(2) NOT NULL AUTO_INCREMENT,
  `orders_id` tinyint(2) DEFAULT NULL,
  `product_id` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders_detail
-- ----------------------------
INSERT INTO `orders_detail` VALUES ('1', '1', '1');
INSERT INTO `orders_detail` VALUES ('2', '2', '2');

-- ----------------------------
-- Table structure for `party`
-- ----------------------------
DROP TABLE IF EXISTS `party`;
CREATE TABLE `party` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `email` varchar(20) COLLATE utf8_sinhala_ci NOT NULL,
  `keyword` varchar(20) COLLATE utf8_sinhala_ci NOT NULL,
  `nickname` varchar(20) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `sex` varchar(5) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `location` varchar(20) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `head_url` varchar(300) COLLATE utf8_sinhala_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

-- ----------------------------
-- Records of party
-- ----------------------------
INSERT INTO `party` VALUES ('1', '1@qq.com', '456', '尹素婉1', 'woman', '2017-05-17', '河北省石家庄', '152643649596814870D0C97B338C5CC468F1C73A6328D1524904208858E37A4A998E88A22DF22B4948B30FEE971524903339514EC99836ED6D94091B7C11295BEEFEFA315246408960641C686FF19AC40372D1050DDC0315D087girl.jpg');
INSERT INTO `party` VALUES ('2', '2@qq.com', '123', '阿婉', 'woman', '2018-05-10', '江苏省扬州', '15285265823561756871636F33833A853A8E9DCB2DFB11.jpg');
INSERT INTO `party` VALUES ('3', '3@qq.com', '123', '小王', '女', '2018-05-11', '黑龙江大连', '267f9e2f07082838625478cbb399a9014d08f190.jpg');

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` tinyint(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(20) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `idcard_id` tinyint(2) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', 'chegy122', '12', '1');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` tinyint(2) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) DEFAULT NULL,
  `price` double DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'first', '12');
INSERT INTO `product` VALUES ('2', 'second', '32');

-- ----------------------------
-- Table structure for `student`
-- ----------------------------
DROP TABLE IF EXISTS `student`;
CREATE TABLE `student` (
  `s_id` int(10) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(20) NOT NULL,
  `student_age` varchar(5) NOT NULL,
  `teacher_id` int(10) NOT NULL,
  PRIMARY KEY (`s_id`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of student
-- ----------------------------
INSERT INTO `student` VALUES ('1', '猴子', '12', '2');
INSERT INTO `student` VALUES ('2', '亚瑟', '34', '1');
INSERT INTO `student` VALUES ('3', '后羿', '23', '4');

-- ----------------------------
-- Table structure for `subject`
-- ----------------------------
DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `subject_name` varchar(20) COLLATE utf8_sinhala_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

-- ----------------------------
-- Records of subject
-- ----------------------------
INSERT INTO `subject` VALUES ('1', 'Web前端入门小项目');
INSERT INTO `subject` VALUES ('2', '前端开发与Git入门');
INSERT INTO `subject` VALUES ('3', 'JS');

-- ----------------------------
-- Table structure for `teacher`
-- ----------------------------
DROP TABLE IF EXISTS `teacher`;
CREATE TABLE `teacher` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(20) COLLATE utf8_sinhala_ci NOT NULL,
  `teacher_work` varchar(20) COLLATE utf8_sinhala_ci NOT NULL,
  `teacher_desc` varchar(200) COLLATE utf8_sinhala_ci NOT NULL,
  `head_img_url` varchar(200) COLLATE utf8_sinhala_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

-- ----------------------------
-- Records of teacher
-- ----------------------------
INSERT INTO `teacher` VALUES ('2', 'dsafdasdf', 'sdf', 'dsafs', 'dsfsadfds');
INSERT INTO `teacher` VALUES ('1', '士大夫撒111', 'dfa', '第三方士大夫撒', '1528348980319267f9e2f07082838625478cbb399a9014d08f190.jpg');
INSERT INTO `teacher` VALUES ('3', 'dsfasdf', 'dsfasd', 'dsaf', 'dsf');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(20) COLLATE utf8_sinhala_ci NOT NULL,
  `user_password` varchar(20) COLLATE utf8_sinhala_ci NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_name` (`user_name`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('10', 'chegy122', '男');
INSERT INTO `user` VALUES ('11', 'chi', '男');
INSERT INTO `user` VALUES ('12', 'chie', '女');
INSERT INTO `user` VALUES ('13', 'chu', '男');
INSERT INTO `user` VALUES ('14', 'cherer', '男');
INSERT INTO `user` VALUES ('15', 'chereree', '男');

-- ----------------------------
-- Table structure for `video`
-- ----------------------------
DROP TABLE IF EXISTS `video`;
CREATE TABLE `video` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `video_name` varchar(20) COLLATE utf8_sinhala_ci NOT NULL,
  `teacher_id` int(10) DEFAULT NULL,
  `course_id` int(10) NOT NULL,
  `video_desc` varchar(200) COLLATE utf8_sinhala_ci NOT NULL,
  `video_time` int(20) NOT NULL,
  `video_degree` int(20) DEFAULT NULL,
  `img_url` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL,
  `video_url` varchar(100) COLLATE utf8_sinhala_ci DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_sinhala_ci;

-- ----------------------------
-- Records of video
-- ----------------------------
INSERT INTO `video` VALUES ('1', '国服后羿', '1', '1', 'dsfds的都是范德萨', '12', null, null, 'sdafdsfsdfsd');
INSERT INTO `video` VALUES ('2', 'w213', '2', '2', 'dsaf', '123', '21', 'dsafd', 'dsfa');
INSERT INTO `video` VALUES ('3', 'dsfsdf', '3', '3', 'dsfds', '21', null, null, 'dsfsdfs');
