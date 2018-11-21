/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50717
Source Host           : localhost:3306
Source Database       : dog_db

Target Server Type    : MYSQL
Target Server Version : 50717
File Encoding         : 65001

Date: 2018-11-20 17:33:49
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for dogs
-- ----------------------------
DROP TABLE IF EXISTS `dogs`;
CREATE TABLE `dogs` (
  `dog_id` int(11) NOT NULL AUTO_INCREMENT,
  `dog_age` int(11) DEFAULT NULL,
  `dog_name` varchar(255) DEFAULT NULL,
  `dog_desc` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`dog_id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 COMMENT='狗皮子表';

-- ----------------------------
-- Records of dogs
-- ----------------------------
INSERT INTO `dogs` VALUES ('2', '8', 'wa', null);
INSERT INTO `dogs` VALUES ('3', '3', 'aaa', null);
INSERT INTO `dogs` VALUES ('5', '8', 'wa', null);
INSERT INTO `dogs` VALUES ('6', '3', 'hashiq', null);
INSERT INTO `dogs` VALUES ('7', '12', 'g1', null);
INSERT INTO `dogs` VALUES ('8', '13', 'g2', null);
INSERT INTO `dogs` VALUES ('9', '12', 'g1', null);
INSERT INTO `dogs` VALUES ('10', '13', 'g2', null);
INSERT INTO `dogs` VALUES ('11', null, null, null);
INSERT INTO `dogs` VALUES ('12', '12', 'afs', null);
INSERT INTO `dogs` VALUES ('13', '12', 'afs', null);
INSERT INTO `dogs` VALUES ('14', '12', 'afs', null);
INSERT INTO `dogs` VALUES ('15', '12', null, null);
INSERT INTO `dogs` VALUES ('16', '12', null, null);
INSERT INTO `dogs` VALUES ('17', '1', 'afs', null);
INSERT INTO `dogs` VALUES ('18', '1', 'afs', null);
INSERT INTO `dogs` VALUES ('19', '18', 'afs', null);
INSERT INTO `dogs` VALUES ('20', '22', 'afs', null);
INSERT INTO `dogs` VALUES ('21', null, null, null);
INSERT INTO `dogs` VALUES ('22', '18', 'ffdfa', null);
INSERT INTO `dogs` VALUES ('23', null, null, null);
INSERT INTO `dogs` VALUES ('24', '18', null, null);
INSERT INTO `dogs` VALUES ('25', '18', 'aaf', null);
INSERT INTO `dogs` VALUES ('26', '18', null, null);
INSERT INTO `dogs` VALUES ('27', null, null, null);
INSERT INTO `dogs` VALUES ('28', '19', null, null);
INSERT INTO `dogs` VALUES ('31', '19', 'hap_d', null);

-- ----------------------------
-- Table structure for role_permissions
-- ----------------------------
DROP TABLE IF EXISTS `role_permissions`;
CREATE TABLE `role_permissions` (
  `role_name` varchar(255) DEFAULT NULL,
  `role_permissions` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permissions
-- ----------------------------
INSERT INTO `role_permissions` VALUES ('user', 'user:login');
INSERT INTO `role_permissions` VALUES ('admin', 'user:delete');
INSERT INTO `role_permissions` VALUES ('admin', 'user:update');

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `user_name` varchar(64) DEFAULT NULL,
  `role_name` varchar(64) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('feike', 'admin');
INSERT INTO `user_role` VALUES ('asdf', 'user');

-- ----------------------------
-- Table structure for web_user
-- ----------------------------
DROP TABLE IF EXISTS `web_user`;
CREATE TABLE `web_user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(32) DEFAULT NULL,
  `pass_word` varchar(32) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of web_user
-- ----------------------------
INSERT INTO `web_user` VALUES ('1', 'feike', '2eec117978b1dc23d460b68ff5897bca');
INSERT INTO `web_user` VALUES ('2', 'asdf', '2eec117978b1dc23d460b68ff5897bca');
INSERT INTO `web_user` VALUES ('3', 'aaa', 'b106dc6352e5ec1f8aafd8c406d34d92');
INSERT INTO `web_user` VALUES ('4', 'ddd', 'b106dc6352e5ec1f8aafd8c406d34d92');
