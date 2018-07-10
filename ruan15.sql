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

-- ----------------------------
-- Table structure for `book`
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `image` varchar(255) DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES ('1', 'p', '3.6', '11', '1');
INSERT INTO `book` VALUES ('2', 'q', '6.3', '22', '2');
INSERT INTO `book` VALUES ('3', 'r', '9.6', '33', '3');

-- ----------------------------
-- Table structure for `employee`
-- ----------------------------
DROP TABLE IF EXISTS `employee`;
CREATE TABLE `employee` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `sex` varchar(1) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phone` varchar(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of employee
-- ----------------------------
INSERT INTO `employee` VALUES ('1', 'hha', '1', '11', '13566988526');
INSERT INTO `employee` VALUES ('2', 'opp', '0', '36', '1685987755');

-- ----------------------------
-- Table structure for `orders`
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `id` int(16) NOT NULL AUTO_INCREMENT,
  `orderNum` varchar(50) DEFAULT NULL,
  `buyerId` int(16) DEFAULT NULL,
  `createDate` date DEFAULT NULL,
  `state` int(2) DEFAULT NULL,
  `totalPrice` decimal(16,0) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '13213212', '1', '2018-07-07', '1', '14');
INSERT INTO `orders` VALUES ('2', '13145456', '2', '2018-07-18', '1', '17');
INSERT INTO `orders` VALUES ('3', '56456456', '3', '2018-07-11', '3', '665');

-- ----------------------------
-- Table structure for `person`
-- ----------------------------
DROP TABLE IF EXISTS `person`;
CREATE TABLE `person` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `age` int(11) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of person
-- ----------------------------
INSERT INTO `person` VALUES ('1', '15', 'Tom');
INSERT INTO `person` VALUES ('2', '15', 'Tom');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `info` varchar(255) DEFAULT NULL,
  `isLock` tinyint(1) NOT NULL DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('3', 'user3', '0');
INSERT INTO `user` VALUES ('4', 'user4', '1');
INSERT INTO `user` VALUES ('5', 'user5', '0');
INSERT INTO `user` VALUES ('6', 'user6', '1');
INSERT INTO `user` VALUES ('7', 'user11', '1');
INSERT INTO `user` VALUES ('8', 'user1.1', '1');
