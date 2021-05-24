/*
Navicat MySQL Data Transfer

Source Server         : 个人-47.103.130.29
Source Server Version : 50733
Source Host           : 47.103.130.29:3306
Source Database       : v20

Target Server Type    : MYSQL
Target Server Version : 50733
File Encoding         : 65001

Date: 2021-05-17 01:35:11
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for appointment
-- ----------------------------
DROP TABLE IF EXISTS `appointment`;
CREATE TABLE `appointment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ''id'',
  `del_flag` int(2) DEFAULT ''1'' COMMENT ''是否有效 1有效 2无效'',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT ''创建时间'',
  `user_id` bigint(20) DEFAULT NULL COMMENT ''预约人id'',
  `start_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT ''开始时间'',
  `status` int(2) DEFAULT ''1'' COMMENT ''是否有效 1待审批 2审批通过 3审批不通过'',
  `end_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT ''预约时间'',
  `name` varchar(100) DEFAULT '''' COMMENT ''教材名称'',
  `remark` varchar(500) DEFAULT '''' COMMENT ''教材描述'',
  `book_id` bigint(20) DEFAULT NULL COMMENT ''bookid'',
  `photo` varchar(500) DEFAULT '''' COMMENT ''图片'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COMMENT=''教师订购'';

-- ----------------------------
-- Records of appointment
-- ----------------------------
INSERT INTO `appointment` VALUES (''20'', ''1'', ''2021-05-16 22:38:08'', ''14'', ''2021-05-16 22:03:50'', ''2'', ''2021-05-17 22:03:53'', ''图书1'', ''作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20'', ''15'', ''600a003a29ba480683504da9d4b6b831.jpg'');
INSERT INTO `appointment` VALUES (''21'', ''1'', ''2021-05-16 22:38:13'', ''14'', ''2021-05-16 22:36:17'', ''2'', ''2021-05-17 22:36:19'', ''图书5'', ''图书5描述'', ''19'', ''f4448fa0140c468ea29d43cd68965ff9.jpg'');
INSERT INTO `appointment` VALUES (''22'', ''1'', ''2021-05-16 22:37:12'', ''14'', ''2021-05-16 22:37:06'', ''1'', ''2021-05-17 22:37:08'', ''图书2'', ''作者：李四，版本：v21'', ''21'', ''dc020ea94e144939863a66880e200502.jpg'');
INSERT INTO `appointment` VALUES (''23'', ''1'', ''2021-05-16 23:33:39'', ''15'', ''2021-05-18 23:33:31'', ''1'', ''2021-05-19 23:33:34'', ''图书1'', ''作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20'', ''15'', ''600a003a29ba480683504da9d4b6b831.jpg'');
INSERT INTO `appointment` VALUES (''24'', ''1'', ''2021-05-17 01:22:07'', ''14'', ''2021-05-17 01:21:17'', ''2'', ''2021-05-18 01:21:20'', ''图书2'', ''图书2描述'', ''16'', ''c8b5e8c241a348f19f00ed3588f58c01.jpg'');
INSERT INTO `appointment` VALUES (''25'', ''1'', ''2021-05-17 01:31:41'', ''14'', ''2021-05-17 01:31:17'', ''2'', ''2021-05-18 01:31:20'', ''图书1'', ''作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20'', ''15'', ''600a003a29ba480683504da9d4b6b831.jpg'');

-- ----------------------------
-- Table structure for book
-- ----------------------------
DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ''id'',
  `del_flag` int(2) DEFAULT ''1'' COMMENT ''是否有效 1有效 2无效'',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT ''创建时间'',
  `user_id` bigint(20) DEFAULT NULL COMMENT ''预约人id'',
  `status` int(2) DEFAULT ''1'' COMMENT ''是否有效 1待审批 2审批通过 3审批不通过'',
  `name` varchar(100) DEFAULT '''' COMMENT ''教材名称'',
  `remark` varchar(500) DEFAULT '''' COMMENT ''教材描述'',
  `photo` varchar(100) DEFAULT '''' COMMENT ''图书配图'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8mb4 COMMENT=''书籍信息'';

-- ----------------------------
-- Records of book
-- ----------------------------
INSERT INTO `book` VALUES (''15'', ''1'', ''2021-05-16 19:31:53'', ''2'', ''2'', ''图书1'', ''作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20作者：张三，出版社：北京大学，版本：v20'', ''600a003a29ba480683504da9d4b6b831.jpg'');
INSERT INTO `book` VALUES (''16'', ''1'', ''2021-05-17 00:46:27'', ''3'', ''2'', ''图书2'', ''图书2描述'', ''c8b5e8c241a348f19f00ed3588f58c01.jpg'');
INSERT INTO `book` VALUES (''17'', ''1'', ''2021-05-16 15:02:19'', ''3'', ''2'', ''图书3'', ''图书描述'', ''3d241183356543a0af6626e42cca4958.jpg'');
INSERT INTO `book` VALUES (''18'', ''1'', ''2021-05-17 00:46:38'', ''3'', ''3'', ''图书4'', ''图书4描述'', ''119a8a46375a45bd872b63e928a99d65.png'');
INSERT INTO `book` VALUES (''19'', ''1'', ''2021-05-16 22:04:52'', ''3'', ''2'', ''图书5'', ''图书5描述'', ''f4448fa0140c468ea29d43cd68965ff9.jpg'');
INSERT INTO `book` VALUES (''20'', ''1'', ''2021-05-16 19:31:08'', ''14'', ''1'', ''图书1'', ''作者：张三，出版社：北京大学，版本：v20'', ''0c058fcd836e4974a958c61ed3a312e5.jpg'');
INSERT INTO `book` VALUES (''21'', ''1'', ''2021-05-16 22:05:00'', ''14'', ''2'', ''图书2'', ''作者：李四，版本：v21'', ''dc020ea94e144939863a66880e200502.jpg'');
INSERT INTO `book` VALUES (''22'', ''1'', ''2021-05-17 01:22:00'', ''14'', ''2'', ''数学'', ''出版社：人教版，作者：李四，版本：v20'', ''efef45e607904bdca467795f45d7b63f.jpg'');

-- ----------------------------
-- Table structure for classes
-- ----------------------------
DROP TABLE IF EXISTS `classes`;
CREATE TABLE `classes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ''id'',
  `name` varchar(100) DEFAULT '''' COMMENT ''标题'',
  `remark` varchar(5000) DEFAULT NULL COMMENT ''内容'',
  `del_flag` int(2) DEFAULT ''1'' COMMENT ''是否有效 1有效 2无效'',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT ''创建时间'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COMMENT=''班级'';

-- ----------------------------
-- Records of classes
-- ----------------------------
INSERT INTO `classes` VALUES (''1'', ''01级01班'', ''01级01班'', ''1'', ''2021-05-16 14:01:00'');
INSERT INTO `classes` VALUES (''2'', ''01级02班'', ''01级02班'', ''1'', ''2021-05-16 14:01:06'');
INSERT INTO `classes` VALUES (''3'', ''02级01班'', ''02级01班'', ''1'', ''2021-05-16 14:01:11'');
INSERT INTO `classes` VALUES (''4'', ''02级02班'', ''02级02班'', ''1'', ''2021-05-16 14:01:15'');
INSERT INTO `classes` VALUES (''7'', ''03级01班'', ''03级01班'', ''1'', ''2021-05-16 14:01:23'');
INSERT INTO `classes` VALUES (''20'', ''04级01班'', ''04级01班'', ''1'', ''2021-05-17 00:43:01'');

-- ----------------------------
-- Table structure for news
-- ----------------------------
DROP TABLE IF EXISTS `news`;
CREATE TABLE `news` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ''id'',
  `name` varchar(100) DEFAULT '''' COMMENT ''标题'',
  `remark` varchar(5000) DEFAULT NULL COMMENT ''内容'',
  `photo` varchar(200) DEFAULT '''' COMMENT ''配图'',
  `del_flag` int(2) DEFAULT ''1'' COMMENT ''是否有效 1有效 2无效'',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT ''创建时间'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8mb4 COMMENT=''新闻'';

-- ----------------------------
-- Records of news
-- ----------------------------
INSERT INTO `news` VALUES (''1'', ''学校通知1'', ''学校通知1描述'', ''6adcc0eed78344c5930a22e6b90edfe1.jpg'', ''1'', ''2021-05-16 14:27:58'');
INSERT INTO `news` VALUES (''2'', ''学校通知2'', ''医疗业内人士认为,在上述两个案例中,医院需要对发生产伤性新生儿骨折的原因进行分析,以提高新生儿骨折诊断、治疗、护理水平,降低产伤性新生儿骨折发生率。 来源▏南方都市报、深圳大件事、北京青年报、北晚新'', ''d3e9b64342784267aa24cc3c2505decc.jpg'', ''1'', ''2021-05-16 14:28:09'');
INSERT INTO `news` VALUES (''3'', ''前三季度全国GDP同比增长0.7%'', ''前三季度，面对新冠肺炎疫情巨大冲击和复杂严峻的国内外环境，在以习近平同志为核心的党中央坚强领导下，各地区各部门科学统筹疫情防控和经济社会发展，有力有效推动生产生活秩序恢复，前三季度经济增速由负转正，供需关系逐步改善，市场活力动力增强，就业民生较好保障，国民经济延续稳定恢复态势，社会大局保持稳定。'', ''fd20d11473664d30b04719d2b54bf4ab.jpg'', ''1'', ''2021-04-11 15:47:14'');
INSERT INTO `news` VALUES (''4'', ''沪指开盘涨0.29%'', ''三大指数高开，沪指开盘涨0.29%，深证成指涨0.54%，创业板指涨0.64%。服装家织板块持续活跃，美邦服饰(002269,股吧)涨停，太平鸟(603877,股吧)涨超4%，海澜之家(600398,股吧)涨超3%'', ''4c352b9c341f497d80e145d754e6945e.jpg'', ''1'', ''2021-04-11 15:47:21'');
INSERT INTO `news` VALUES (''20'', ''学校通知3'', ''学校通知3学校通知3学校通知3学校通知3学校通知3'', ''663f9faa595849db9b424b60a76b335b.jpg'', ''1'', ''2021-05-17 00:44:50'');

-- ----------------------------
-- Table structure for suggestion
-- ----------------------------
DROP TABLE IF EXISTS `suggestion`;
CREATE TABLE `suggestion` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ''id'',
  `user_id` bigint(20) DEFAULT ''0'' COMMENT ''用户id'',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT ''创建时间'',
  `del_flag` int(2) DEFAULT ''1'' COMMENT ''是否有效 1有效 2无效'',
  `content` varchar(5000) DEFAULT '''' COMMENT ''评论'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8mb4 COMMENT=''意见'';

-- ----------------------------
-- Records of suggestion
-- ----------------------------
INSERT INTO `suggestion` VALUES (''40'', ''3'', ''2021-05-16 18:25:57'', ''1'', ''非常好'');
INSERT INTO `suggestion` VALUES (''41'', ''3'', ''2021-04-11 13:59:11'', ''1'', ''请大家积极配合'');
INSERT INTO `suggestion` VALUES (''42'', ''22'', ''2021-04-11 15:56:07'', ''1'', ''服务人员态度更好点'');
INSERT INTO `suggestion` VALUES (''43'', ''3'', ''2021-05-16 18:26:03'', ''1'', ''还是挺好的'');
INSERT INTO `suggestion` VALUES (''44'', ''23'', ''2021-04-12 16:37:22'', ''1'', ''多方便哦'');
INSERT INTO `suggestion` VALUES (''45'', ''3'', ''2021-05-06 11:59:46'', ''1'', ''非常不好'');
INSERT INTO `suggestion` VALUES (''46'', ''3'', ''2021-05-06 11:59:55'', ''1'', ''没法玩'');
INSERT INTO `suggestion` VALUES (''47'', ''3'', ''2021-05-06 23:53:07'', ''1'', ''怎么样啊'');
INSERT INTO `suggestion` VALUES (''48'', ''3'', ''2021-05-16 18:26:09'', ''1'', ''请问你们在哪里订购的书'');
INSERT INTO `suggestion` VALUES (''49'', ''14'', ''2021-05-16 19:39:16'', ''1'', ''非常好'');
INSERT INTO `suggestion` VALUES (''50'', ''14'', ''2021-05-17 01:21:34'', ''1'', ''很好'');
INSERT INTO `suggestion` VALUES (''51'', ''3'', ''2021-05-17 01:22:35'', ''1'', ''好了，结束了'');
INSERT INTO `suggestion` VALUES (''52'', ''3'', ''2021-05-17 01:32:35'', ''1'', ''收官'');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ''id'',
  `login_name` varchar(100) DEFAULT '''' COMMENT ''登录名 '',
  `password` varchar(100) DEFAULT '''' COMMENT ''密码 '',
  `user_name` varchar(100) DEFAULT '''' COMMENT ''用户名 '',
  `photo` varchar(100) DEFAULT '''' COMMENT ''头像'',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT ''审核时间'',
  `phone` varchar(100) DEFAULT '''' COMMENT '' 手机号'',
  `sex` varchar(100) DEFAULT '''' COMMENT ''性别'',
  `del_flag` int(2) DEFAULT ''1'' COMMENT ''是否有效 1有效 2无效'',
  `type` int(2) DEFAULT ''0'' COMMENT ''0管理员 1学生 2教师'',
  `cert_no` varchar(100) DEFAULT '''' COMMENT ''身份证号'',
  `code` varchar(100) DEFAULT '''' COMMENT ''学/工号'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COMMENT=''用户表'';

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (''1'', ''admin'', ''admin'', ''管理员'', ''98718b5677394691b4a57384bc889b77.png'', ''2021-05-05 21:59:40'', ''13688884888'', ''女'', ''1'', ''0'', ''61884484845454'', '''');
INSERT INTO `user` VALUES (''2'', ''2'', ''2'', ''张三'', ''6a9e5a53725a44069770c8ad9a714d52.jpg'', ''2021-05-16 23:23:11'', ''13688884888'', ''女'', ''1'', ''1'', ''612254844885'', ''x001'');
INSERT INTO `user` VALUES (''3'', ''1'', ''1'', ''王五'', ''c9704aeef34c41b490b5a7922379af82.jpg'', ''2021-05-16 23:34:36'', ''136885554455'', ''男'', ''1'', ''1'', ''615544545454644564'', ''x002'');
INSERT INTO `user` VALUES (''7'', ''w5'', ''1'', ''用户2'', ''b2ef0eebb26e4210ac64f0310672acf7.jpg'', ''2021-05-17 00:43:24'', ''13689554454'', ''男'', ''1'', ''1'', '''', ''x003'');
INSERT INTO `user` VALUES (''9'', ''zl'', ''1'', ''用户3'', ''fb99df57c4d9429d84325271da8fc89d.png'', ''2021-05-16 14:17:31'', ''13689261145'', ''男'', ''1'', ''1'', '''', ''x004'');
INSERT INTO `user` VALUES (''10'', ''s1'', ''1'', ''用户4'', ''25d86769088746168d2d21090b992564.jpg'', ''2021-05-16 14:17:34'', ''139555455445'', ''男'', ''1'', ''1'', '''', ''x005'');
INSERT INTO `user` VALUES (''11'', ''g1'', ''1'', ''用户5'', ''164d21efe4a64fc79daa05cdc0882e2a.jpg'', ''2021-05-16 14:17:36'', ''13689998885'', ''女'', ''1'', ''1'', '''', ''x006'');
INSERT INTO `user` VALUES (''12'', ''y1'', ''1'', ''用户6'', ''abd984a7681e472fab721dc05fda8035.jpg'', ''2021-05-16 14:17:39'', ''136899988874'', ''男'', ''1'', ''1'', '''', ''x007'');
INSERT INTO `user` VALUES (''13'', ''zz'', ''zz'', ''zz'', ''5bf01f28aa2546f59d2973fece46b6e4.jpg'', ''2021-05-16 18:02:02'', ''13688995555'', ''男'', ''1'', ''1'', '''', ''x008'');
INSERT INTO `user` VALUES (''14'', ''js1'', ''1'', ''教师1'', ''fb938d2bd21f408d92229d142b529574.jpg'', ''2021-05-16 17:27:43'', ''13689554455'', ''男'', ''1'', ''2'', ''61545454545454'', ''001'');
INSERT INTO `user` VALUES (''15'', ''js2'', ''1'', ''教师2'', ''8b21f65334ab4ac2ac0cd4ef9cb821c1.jpg'', ''2021-05-16 22:37:41'', ''13684884888'', ''女'', ''1'', ''2'', ''6120545454545'', ''002'');
INSERT INTO `user` VALUES (''21'', ''js3'', ''1'', ''教师3'', ''e0e2d8fcaf9449e6ab6b7a1a4aabcd44.jpg'', ''2021-05-16 22:37:52'', ''13688478484'', ''男'', ''1'', ''2'', ''615454545454'', ''003'');
INSERT INTO `user` VALUES (''22'', ''js4'', ''1'', ''教师3'', ''0e6c0f9fb5254a2093304e9a35a3669e.jpg'', ''2021-05-16 23:21:54'', ''1368888888'', ''男'', ''1'', ''2'', ''6136545454545544'', ''004'');
INSERT INTO `user` VALUES (''23'', ''js5'', ''1'', ''教师4'', ''fed43369ecbb46799c8c8795a35d3065.jpg'', ''2021-05-17 00:43:11'', ''136888848'', ''男'', ''1'', ''2'', ''61213213221321'', ''005'');
INSERT INTO `user` VALUES (''24'', ''js6'', ''1'', ''教师5'', ''d46a575497a04f41bcc720c8c09fed18.jpg'', ''2021-05-16 14:16:30'', ''13654546546'', ''男'', ''1'', ''2'', ''61245454545454'', ''006'');
INSERT INTO `user` VALUES (''25'', ''js7'', ''1'', ''教师6'', ''4dd30b50bd0c42c1bc4a2e28313d1403.jpg'', ''2021-05-16 14:16:33'', ''13689878787'', ''男'', ''1'', ''2'', ''64545454545454554'', ''007'');

-- ----------------------------
-- Table structure for user_appointment
-- ----------------------------
DROP TABLE IF EXISTS `user_appointment`;
CREATE TABLE `user_appointment` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ''id'',
  `user_id` bigint(20) DEFAULT ''0'' COMMENT ''用户id'',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT ''创建时间'',
  `del_flag` int(2) DEFAULT ''1'' COMMENT ''是否有效 1有效 2无效'',
  `appointment_id` bigint(20) DEFAULT ''0'' COMMENT ''订购id'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COMMENT=''用户班级关系表'';

-- ----------------------------
-- Records of user_appointment
-- ----------------------------
INSERT INTO `user_appointment` VALUES (''1'', ''3'', ''2021-05-17 01:22:22'', ''1'', ''24'');
INSERT INTO `user_appointment` VALUES (''2'', ''3'', ''2021-05-17 01:32:15'', ''1'', ''25'');

-- ----------------------------
-- Table structure for user_classes
-- ----------------------------
DROP TABLE IF EXISTS `user_classes`;
CREATE TABLE `user_classes` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT ''id'',
  `user_id` bigint(20) DEFAULT ''0'' COMMENT ''用户id'',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT ''创建时间'',
  `del_flag` int(2) DEFAULT ''1'' COMMENT ''是否有效 1有效 2无效'',
  `classes_id` bigint(20) DEFAULT ''0'' COMMENT ''班级id'',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COMMENT=''用户班级关系表'';

-- ----------------------------
-- Records of user_classes
-- ----------------------------
INSERT INTO `user_classes` VALUES (''3'', ''14'', ''2021-05-16 17:27:43'', ''1'', ''2'');
INSERT INTO `user_classes` VALUES (''4'', ''14'', ''2021-05-16 17:27:43'', ''1'', ''1'');
INSERT INTO `user_classes` VALUES (''5'', ''15'', ''2021-05-16 22:37:41'', ''1'', ''3'');
INSERT INTO `user_classes` VALUES (''6'', ''21'', ''2021-05-16 22:37:52'', ''1'', ''2'');
INSERT INTO `user_classes` VALUES (''7'', ''22'', ''2021-05-16 23:21:54'', ''1'', ''1'');
INSERT INTO `user_classes` VALUES (''8'', ''2'', ''2021-05-16 23:23:11'', ''1'', ''1'');
INSERT INTO `user_classes` VALUES (''9'', ''3'', ''2021-05-16 23:34:36'', ''1'', ''1'');
INSERT INTO `user_classes` VALUES (''10'', ''23'', ''2021-05-17 00:43:11'', ''1'', ''1'');
INSERT INTO `user_classes` VALUES (''11'', ''23'', ''2021-05-17 00:43:11'', ''1'', ''2'');
INSERT INTO `user_classes` VALUES (''12'', ''23'', ''2021-05-17 00:43:11'', ''1'', ''3'');
INSERT INTO `user_classes` VALUES (''13'', ''7'', ''2021-05-17 00:43:24'', ''1'', ''1'');
