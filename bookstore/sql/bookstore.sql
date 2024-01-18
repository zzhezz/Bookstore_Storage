/*
 Navicat Premium Data Transfer

 Source Server         : 本地MySQL
 Source Server Type    : MySQL
 Source Server Version : 80035
 Source Host           : localhost:3306
 Source Schema         : bookstore

 Target Server Type    : MySQL
 Target Server Version : 80035
 File Encoding         : 65001

 Date: 12/12/2023 21:19:04
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `bookname` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `pub` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `price` decimal(10, 0) NOT NULL,
  `date` datetime NOT NULL,
  `count` int NOT NULL,
  `kind` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 32 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (1, 'The Burnout: A Novel', 'Sophie Kinsella ', 23, '2023-12-12 20:01:27', 20, 'Romance');
INSERT INTO `book` VALUES (2, 'Manwhore', 'Katy Evans ', 18, '2023-12-12 06:01:27', 10, 'Romance');
INSERT INTO `book` VALUES (5, 'Churchill: The Power of Words', 'Winston S. Churchill', 66, '2020-02-02 06:00:00', 34, 'Literature');
INSERT INTO `book` VALUES (6, 'We Are Not Okay', 'Gomes N. D.', 68, '2023-12-12 16:00:00', 10, 'Literature');
INSERT INTO `book` VALUES (7, 'Marrying Mr. Wrong', 'Claire Kingsley', 12, '2023-12-12 06:00:00', 23, 'Romance');
INSERT INTO `book` VALUES (8, '‎A Tale of Two Cities', 'Charles Dickens', 14, '2024-08-03 06:00:00', 50, 'Literature');
INSERT INTO `book` VALUES (32, 'Her Perfect Bones:', 'Ellery A. Kane', 12, '2023-12-12 05:00:00', 40, 'Mystery');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `password` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `phone` varchar(30) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `email` varchar(50) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `sex` char(5) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `perm` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  `role` varchar(20) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 30 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'Meiyu', '123123', '(450) 763-2604', 'mz3601@yfxpw.services', 'f', 'A-C-U-R-D', 'super-administrator');
INSERT INTO `user` VALUES (3, 'Zhichen', '123456', '(490) 334-6520', 'zh2208@nanoff.ca', 'm', 'R', 'guest');
INSERT INTO `user` VALUES (4, 'Rohit', '123456', '(992) 789-8407', 'rohit@xqj6f.site', 'm', 'R', 'guest');
INSERT INTO `user` VALUES (5, 'Margot', '123456', '(722) 621-6737', 'Margot745@nanoff.ca', 'f', 'R', 'guest');
INSERT INTO `user` VALUES (6, 'Marilyn', '123456', '(483) 502-0275', 'Marilyn@yafr7.website', 'f', 'R', 'guest');
INSERT INTO `user` VALUES (30, 'KK', '123123', '13889190', 'lolo332@gmail.com', 'm', 'R', 'guest');

SET FOREIGN_KEY_CHECKS = 1;
