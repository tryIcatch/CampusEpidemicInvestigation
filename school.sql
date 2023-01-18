/*
 Navicat Premium Data Transfer

 Source Server         : Campus
 Source Server Type    : MySQL
 Source Server Version : 80031
 Source Host           : localhost:3306
 Source Schema         : school

 Target Server Type    : MySQL
 Target Server Version : 80031
 File Encoding         : 65001

 Date: 18/01/2023 11:39:16
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for sch_student
-- ----------------------------
DROP TABLE IF EXISTS `sch_student`;
CREATE TABLE `sch_student`  (
  `id` int(0) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `gender` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `age` int(0) DEFAULT NULL,
  `number` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `department` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `college` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `health` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `phonenumber` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `city` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `temperature` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci NOT NULL,
  `date` date DEFAULT NULL,
  `username` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb3 COLLATE utf8mb3_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb3 COLLATE = utf8mb3_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sch_student
-- ----------------------------
INSERT INTO `sch_student` VALUES (1, 'zs', '男', 18, ' 20224221188', '计算机科学与技术', '人工智能', '良好', '15827862', '武汉', '36.3', '2023-01-10', 'zs', '123456');
INSERT INTO `sch_student` VALUES (2, 'ls', '男', 19, '202200558', '艺术鉴赏', '艺术设计', '健康', '154888858', 'xs', '36.5', '2023-01-06', 'ww', '123456');
INSERT INTO `sch_student` VALUES (4, '测试5', '女', 18, '223332', '计算机科学与技术', '人工智能', '良好', '1586566888585', '武汉', '36.6', '2023-01-02', 'll', '123456');
INSERT INTO `sch_student` VALUES (5, '测试1', '男', 18, '111111111111', '计算机科学与技术', '人工智能', '良好', '15827862', '武汉', '36.6', '2023-01-01', 'ls', '123456');
INSERT INTO `sch_student` VALUES (6, '测试2', '男', 18, '111111111111', '计算机科学与技术', '人工智能', '良好', '15827862', '武汉', '36.6', '2023-01-03', 'zz', '123456');
INSERT INTO `sch_student` VALUES (7, 'gg', '男', 18, '111111111111', '计算机科学与技术', '人工智能', '良好', '15827862', '武汉', '36.5', '2023-01-15', 'kk', '123456');
INSERT INTO `sch_student` VALUES (8, '测试4', '男', 18, '111111111111', '计算机科学与技术', '人工智能', '良好', '15827862', '武汉', '36.6', '2023-01-15', 'mm', '123456');
INSERT INTO `sch_student` VALUES (9, '测试5', '男', 18, '111111111111', '计算机科学与技术', '人工智能', '良好', '15827862', '武汉', '36.6', '2023-01-07', 'uu', '123456');
INSERT INTO `sch_student` VALUES (10, '测试6', '男', 18, '111111111111', '计算机科学与技术', '人工智能', '良好', '15827862', '武汉', '36.6', '2023-01-08', 'jj', '123456');
INSERT INTO `sch_student` VALUES (16, '沐林', '男', 18, '2222', '计算机科学与技术', '人工智能', '健康', '1265', '钟祥', '36.6', '2023-01-09', '沐林', '123456');
INSERT INTO `sch_student` VALUES (17, 'jiang', '男', 18, '20158', '计算机科学与技术', '人工智能', '健康', '154866', '武汉', '36.5', '2023-01-09', 'jiang', '123456');
INSERT INTO `sch_student` VALUES (18, '初九', '男', 19, '2919', '计算机科学与技术', '人工智能', '健康', '186262', '北京', '36.6', '2023-01-16', '初九', '123456');
INSERT INTO `sch_student` VALUES (19, '沐林1', '男', 20, '26', '计算机', '人工智能', '健康', '33', '钟祥', '36.5', '2023-01-16', '沐林1', '123456');
INSERT INTO `sch_student` VALUES (20, 'l', '男', 20, '2929', '生物', '生命科学学院', '咳嗽', '15869658', '北京', '36.8', '2023-01-17', 'l', '123456');
INSERT INTO `sch_student` VALUES (21, 'jiang', '男', 33, '29916', '计算机', '人工智能', '健康', '55696', '北京', '36.3', '2023-01-17', 'jiang', '123456');
INSERT INTO `sch_student` VALUES (22, 'zcx', '女', 22, '29191', '舞蹈', '影视传媒', '发热', '81999', '武汉', '36.5', '2023-01-10', '哈哈', '123456');
INSERT INTO `sch_student` VALUES (23, 'hbs', '女', 19, '84996', '新媒体', '影视传媒', '流鼻涕', '498959', '襄阳', '36.3', '2023-01-08', '来来来', '123456');
INSERT INTO `sch_student` VALUES (24, 'thd', '女', 22, '20215666', '科学', '汉语言', '健康', '1965996', '上海', '36.6', '2023-01-17', 'thd', '123456');

-- ----------------------------
-- Table structure for sch_teacher
-- ----------------------------
DROP TABLE IF EXISTS `sch_teacher`;
CREATE TABLE `sch_teacher`  (
  `id` int(0) NOT NULL,
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of sch_teacher
-- ----------------------------
INSERT INTO `sch_teacher` VALUES (1, 'zs', '123456');

SET FOREIGN_KEY_CHECKS = 1;
