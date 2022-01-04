/*
 Navicat Premium Data Transfer

 Source Server         : lmwis@postit_card
 Source Server Type    : MySQL
 Source Server Version : 50736
 Source Host           : 101.43.95.32:7001
 Source Schema         : postit_card

 Target Server Type    : MySQL
 Target Server Version : 50736
 File Encoding         : 65001

 Date: 04/01/2022 19:17:23
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for card
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL DEFAULT '',
  `body` text NOT NULL,
  `publication_date` datetime NOT NULL,
  `expiration_date` datetime NOT NULL,
  `is_visible` tinyint(4) unsigned NOT NULL COMMENT '1-可见 0-不可见',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=814 DEFAULT CHARSET=utf8;

SET FOREIGN_KEY_CHECKS = 1;
