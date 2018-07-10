/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50627
Source Host           : localhost:3306
Source Database       : ruan15

Target Server Type    : MYSQL
Target Server Version : 50627
File Encoding         : 65001

Date: 2018-07-10 17:31:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(16) NOT NULL DEFAULT '0',
  `email` varchar(30) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `salt` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('0', '123@qq.com', 'f497fe30502d239ff1e640ac256d95f2070f53153ab5553a97ce75fe4fdeff58', 'b73412fc-d206-4a95-9be4-c482b45c65b9');



SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `books`
-- ----------------------------
DROP TABLE IF EXISTS `books`;
CREATE TABLE `books` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `bookname` varchar(40) CHARACTER SET utf8 DEFAULT NULL,
  `price` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `img` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of books
-- ----------------------------
INSERT INTO `books` VALUES ('1', '七龙珠', '20', '400', 'images/book/book_01.gif');
INSERT INTO `books` VALUES ('2', '死神', '15', '1000', 'images/book/book_02.gif');
INSERT INTO `books` VALUES ('3', '火影忍者', '10', '1000', 'images/book/book_03.gif');
INSERT INTO `books` VALUES ('4', '老人与海', '30', '1000', 'images/book/book_04.gif');
INSERT INTO `books` VALUES ('5', '海贼王', '20', '1000', 'images/book/book_05.gif');
INSERT INTO `books` VALUES ('6', '红楼梦', '45', '1000', 'images/book/book_06.gif');
INSERT INTO `books` VALUES ('7', '三国演义', '45', '1000', 'images/book/book_07.gif');
INSERT INTO `books` VALUES ('8', '西游记', '50', '1000', 'images/book/book_08.gif');
INSERT INTO `books` VALUES ('9', '悟空传', '30', '1000', 'images/book/book_09.gif');
INSERT INTO `books` VALUES ('10', '傲慢与偏见', '40', '1000', 'images/book/book_010.gif');

-- ----------------------------
-- Table structure for `orderitems`
-- ----------------------------
DROP TABLE IF EXISTS `orderitems`;
CREATE TABLE `orderitems` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderId` int(11) DEFAULT NULL,
  `bookId` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `orderId` (`orderId`),
  KEY `bookId` (`bookId`)
) ENGINE=MyISAM AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orderitems
-- ----------------------------
INSERT INTO `orderitems` VALUES ('1', '1', '1', '2');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `ordernum` varchar(50) DEFAULT NULL,
  `buyerId` int(11) DEFAULT NULL,
  `totalprice` double DEFAULT NULL,
  `createdate` datetime DEFAULT NULL,
  `state` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `buyerId` (`buyerId`)
) ENGINE=MyISAM AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '1', '1', '10', null, '0');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(20) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `islock` int(11) DEFAULT NULL,
  `lastdate` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '1111', '123456', null, '3', '2018-07-10 17:49:28');
INSERT INTO `user` VALUES ('2', '222', '123456', '31321@3131', null, null);
