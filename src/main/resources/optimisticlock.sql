/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : optimisticlock

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-03-25 16:41:55
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for usr_user_account
-- ----------------------------
DROP TABLE IF EXISTS `usr_user_account`;
CREATE TABLE `usr_user_account` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `user_id` bigint(20) NOT NULL COMMENT '用户ID',
  `balance` decimal(50,10) DEFAULT '0.0000000000' COMMENT '余额',
  `version` bigint(20) DEFAULT '0' COMMENT '乐观锁版本号',
  `create_by` bigint(20) DEFAULT NULL COMMENT ' 创建人',
  `create_time` datetime NOT NULL COMMENT ' 创建时间',
  `modify_by` bigint(20) DEFAULT NULL,
  `modify_time` datetime DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='用户账户表';

-- ----------------------------
-- Records of usr_user_account
-- ----------------------------
INSERT INTO `usr_user_account` VALUES ('1', '1001', '1000.0000000000', '0', '1', '2019-03-25 14:14:49', '1', '2019-03-25 16:28:26');
INSERT INTO `usr_user_account` VALUES ('2', '1002', '1000.0000000000', '0', '1', '2019-03-25 14:14:49', '2', '2019-03-25 16:28:26');
