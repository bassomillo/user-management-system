/*
 Navicat Premium Data Transfer

 Source Server         : zhgh
 Source Server Type    : MySQL
 Source Server Version : 80026
 Source Host           : localhost:3306
 Source Schema         : javaweb

 Target Server Type    : MySQL
 Target Server Version : 80026
 File Encoding         : 65001

 Date: 09/01/2022 19:11:51
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for dept
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES (1, 'Enginnering');
INSERT INTO `dept` VALUES (2, 'Manager');
INSERT INTO `dept` VALUES (3, 'Finance');
INSERT INTO `dept` VALUES (4, 'Testing');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `profile` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL,
  `deptId` int NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 22 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (17, 'lucy2', 'PbwQ6TSrzQNdS8kvsvBbZw==', 'http://localhost:8080/img/lucy2/b6d9f187-73cd-4c66-9a1e-9f9289e4d21a_图片3.jpg', 1);
INSERT INTO `user` VALUES (20, 'lucyhjk', 'TCzODhAhQYetWPeXWRHHaQ==', 'http://localhost:8080/img/lucyhjk/0f45a0b6-952f-4971-9e0c-1a2c410e5a48_微信图片_20210907142333.jpg', 3);
INSERT INTO `user` VALUES (21, 'kity', 'PbwQ6TSrzQNdS8kvsvBbZw==', 'http://localhost:8080/img/lucyhjk\\4058972e-e01e-4a88-9f0a-5f12a7288883_photomode_19042021_231648.png', 2);
INSERT INTO `user` VALUES (22, 'frey', 'PbwQ6TSrzQNdS8kvsvBbZw==', 'http://localhost:8080/img/lucyhjk/0f45a0b6-952f-4971-9e0c-1a2c410e5a48_微信图片_20210907142333.jpg', 1);

SET FOREIGN_KEY_CHECKS = 1;
