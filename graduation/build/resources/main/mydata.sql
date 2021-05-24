/*
 Navicat Premium Data Transfer

 Source Server         : dsb
 Source Server Type    : MySQL
 Source Server Version : 50729
 Source Host           : localhost:3306
 Source Schema         : mydata

 Target Server Type    : MySQL
 Target Server Version : 50729
 File Encoding         : 65001

 Date: 23/05/2021 21:15:41
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `del_flag` int(2) NULL DEFAULT 1 COMMENT '是否有效 1有效 2无效',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '预约人id',
  `start_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '开始时间',
  `status` int(2) NULL DEFAULT 1 COMMENT '是否有效 1待审批 2审批通过 3审批不通过',
  `lesson` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '课程名称',
  `end_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '结束时间',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '教材名称',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '教材描述',
  `book_id` bigint(20) NULL DEFAULT NULL COMMENT 'bookid',
  `photo` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '图片',
  `Total` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '订购总人数',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '教师订购' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES (27, 1, '2021-05-23 20:48:02', 14, '2021-05-23 20:47:53', 1, NULL, '2021-05-23 20:49:56', '数学', '出版社：人教版，作者：李四，版本：v20', 22, '', '');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `del_flag` int(2) NULL DEFAULT 1 COMMENT '是否有效 1有效 2无效',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `user_id` bigint(20) NULL DEFAULT NULL COMMENT '申请id',
  `status` int(2) NULL DEFAULT 1 COMMENT '是否有效 1待审批 2审批通过 3审批不通过',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '教材名称',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '教材描述',
  `photo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '图书配图',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 23 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '书籍信息' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (20, 1, '2021-05-23 15:27:05', 14, 1, '图书1', '作者：张三，出版社：北京大学，版本：v20', '');
INSERT INTO `book` VALUES (21, 1, '2021-05-23 15:27:06', 14, 2, '图书2', '作者：李四，版本：v21', '');
INSERT INTO `book` VALUES (22, 1, '2021-05-23 15:27:08', 14, 2, '数学', '出版社：人教版，作者：李四，版本：v20', '');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '班名',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '备注',
  `Total` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '班级内总人数',
  `del_flag` int(2) NULL DEFAULT 1 COMMENT '是否有效 1有效 2无效',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '班级' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (1, '商务1701', '电子商务2017级1班', '1', 1, '2021-05-23 15:33:27');
INSERT INTO `classes` VALUES (2, '商务1702', '电子商务2017级2班', '', 1, '2021-05-19 23:54:22');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '标题',
  `remark` varchar(5000) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '内容',
  `photo` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '配图',
  `del_flag` int(2) NULL DEFAULT 1 COMMENT '是否有效 1有效 2无效',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '新闻' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (1, '学校通知1', '学校通知1描述', '6adcc0eed78344c5930a22e6b90edfe1.jpg', 1, '2021-05-16 14:27:58');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `login_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '登录名 ',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '密码 ',
  `user_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '用户名 ',
  `photo` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '头像',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '审核时间',
  `phone` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT ' 手机号',
  `sex` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '性别',
  `del_flag` int(2) NULL DEFAULT 1 COMMENT '是否有效 1有效 2无效',
  `type` int(2) NULL DEFAULT 0 COMMENT '0管理员 1学生 2教师 ',
  `cert_no` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '身份证号',
  `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '学/工号',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 28 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'admin', 'admin', '管理员', '', '2021-05-23 15:27:15', '13688884888', '女', 1, 0, '110112150886', 'admin');
INSERT INTO `user` VALUES (2, '2017012348', '123456', '王阳', '', '2021-05-23 15:33:18', '17600602506', '男', 1, 1, '610321', '2017012348');
INSERT INTO `user` VALUES (14, 't1', '123456', '教师1', '', '2021-05-23 15:27:24', '111', '男', 1, 2, '110', '');
INSERT INTO `user` VALUES (15, 't2', '123456', '教师2', '', '2021-05-23 15:27:27', '123', '女', 1, 2, '1101', '');
INSERT INTO `user` VALUES (26, '2017012352', '123456', '周弘宇', '', '2021-05-23 15:30:18', '119', '男', 1, 1, '001', '2017012352');
INSERT INTO `user` VALUES (27, '2017012349', '123456', '杨晨', '', '2021-05-23 16:34:22', '4396', '男', 1, 0, '113', '2017012349');

-- ----------------------------
-- Table structure for user_appointment
-- ----------------------------
DROP TABLE IF EXISTS `user_appointment`;
CREATE TABLE `user_appointment`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NULL DEFAULT 0 COMMENT '用户id',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `del_flag` int(2) NULL DEFAULT 1 COMMENT '是否有效 1有效 2无效',
  `appointment_id` bigint(20) NULL DEFAULT 0 COMMENT '订购id',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户班级关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_appointment
-- ----------------------------

-- ----------------------------
-- Table structure for user_classes
-- ----------------------------
DROP TABLE IF EXISTS `user_classes`;
CREATE TABLE `user_classes`  (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id',
  `user_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '用户id',
  `create_time` datetime(0) NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP(0) COMMENT '创建时间',
  `del_flag` int(2) NULL DEFAULT 1 COMMENT '是否有效 1有效 2无效',
  `classes_id` bigint(20) NOT NULL DEFAULT 0 COMMENT '班级id',
  PRIMARY KEY (`id`, `classes_id`, `user_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 61 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '用户班级关系表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user_classes
-- ----------------------------
INSERT INTO `user_classes` VALUES (57, 14, '2021-05-23 14:42:33', 1, 1);
INSERT INTO `user_classes` VALUES (58, 14, '2021-05-23 14:42:33', 1, 2);
INSERT INTO `user_classes` VALUES (59, 2, '2021-05-23 15:33:18', 1, 1);
INSERT INTO `user_classes` VALUES (60, 0, '2021-05-23 16:34:22', 1, 1);

SET FOREIGN_KEY_CHECKS = 1;
