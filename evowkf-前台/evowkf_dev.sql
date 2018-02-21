/*
Navicat MySQL Data Transfer

Source Server         : hellofirst
Source Server Version : 50096
Source Host           : localhost:3306
Source Database       : evowkf_dev

Target Server Type    : MYSQL
Target Server Version : 50096
File Encoding         : 65001

Date: 2018-02-20 18:05:00
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `sy_global_define`
-- ----------------------------
DROP TABLE IF EXISTS `sy_global_define`;
CREATE TABLE `sy_global_define` (
  `SGD_FIELD` varchar(60) NOT NULL COMMENT '字段定义',
  `SGD_BUS_TYPE` varchar(10) NOT NULL COMMENT '所属业务类型',
  `SGD_VALUE` varchar(60) NOT NULL COMMENT '字段值',
  `SGD_DSP` varchar(256) default NULL COMMENT '注释',
  PRIMARY KEY  (`SGD_FIELD`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_global_define
-- ----------------------------
INSERT INTO `sy_global_define` VALUES ('017473985497068923943039656531786925383025097813497064466608', 'SYUSR', '540085710350922744174047018239043097664042235330547831754823', '10');
INSERT INTO `sy_global_define` VALUES ('230842555947249597602963550980711730013138265092046308064010', 'SYUSR', '455696604371331355201320911866933165555899025076981795733056', '10');
INSERT INTO `sy_global_define` VALUES ('266060175454271417609043373593438458810905578920901566268744', 'SYUSR', '909040694119361924643994898177069324505533633260418392876148', '10');
INSERT INTO `sy_global_define` VALUES ('316670241845190885405976784353239030846797611921765189496070', 'SYUSR', '464338140466479414262599123425748315784403996051694719821163', '10');
INSERT INTO `sy_global_define` VALUES ('424616629898242912635937386541689957458161714564208536420344', 'SYUSR', '043584667828778824613079421775791912033856408281303224484215', '10');

-- ----------------------------
-- Table structure for `sy_user_info`
-- ----------------------------
DROP TABLE IF EXISTS `sy_user_info`;
CREATE TABLE `sy_user_info` (
  `SUI_ID` varchar(36) NOT NULL COMMENT '用户号',
  `SUI_LOGIN_NAME` varchar(60) NOT NULL COMMENT '登录名',
  `SUI_PHONE` varchar(20) default NULL COMMENT '手机',
  `SUI_MAIL` varchar(100) default NULL COMMENT '邮箱',
  `SUI_PWD` varchar(100) NOT NULL COMMENT '密码',
  `SUI_SALT` varchar(100) NOT NULL COMMENT '旧盐',
  `SUI_NEW_SALT` varchar(100) NOT NULL COMMENT '新盐',
  `SUI_HASH_TIMES` int(11) NOT NULL COMMENT 'N值',
  `SUI_FACE` varchar(100) default NULL COMMENT '头像',
  `SUI_STATUS` char(1) NOT NULL COMMENT '状态',
  `SUI_ERROR_TIMES` int(11) NOT NULL COMMENT '密码错误次数',
  `SUI_REGISTER_TIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '注册时间',
  PRIMARY KEY  (`SUI_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_user_info
-- ----------------------------
INSERT INTO `sy_user_info` VALUES ('15b3cdcc16ee4460b52d17cead3da833', 'cc', '98765433', null, 'aaad61805dd6d4c67bdb3dee0c5c107261010248fe690f700b5e111ce3026e31', 'ad5e6', 'bf4ee', '2', null, 'A', '0', '2018-02-19 17:20:21');
INSERT INTO `sy_user_info` VALUES ('1f364372866047f792c2e3d0c2c1ff38', 'kool', null, null, '2893786f5aaeb4f6dfbcd499242f1dfc572595d3697c7462966fddff04f5cb32', 'e0803', '12fe3', '2', null, 'A', '0', '2018-02-18 17:51:52');
INSERT INTO `sy_user_info` VALUES ('32b3689f5b3b41eab6883df33d20b41d', 'testc', null, null, 'caaafabea21b2f005a2811f3861f9b328d740011bedfa2c530221d878ba04e48', 'b5d42', '4610a', '3688', null, 'A', '0', '2018-02-18 17:54:59');
INSERT INTO `sy_user_info` VALUES ('34d99e0732884f6688e471e71af93c68', 'dd', null, null, '8c6a3f3f2870c0b7890a5108772f01fac28e10abf1724194b64076f9148a62e8', '9e851', 'd38e4', '2', null, 'A', '0', '2018-02-19 17:20:29');
INSERT INTO `sy_user_info` VALUES ('5486eb178eb44283b3ca546f39d5ba3c', 'sdf', null, null, '7daa6dd08615761a1f616f4da2806f0ee35dc2c1c352eb42df370009594eb479', '2a406', '2a406', '3', null, 'A', '0', '2018-02-20 16:34:17');
INSERT INTO `sy_user_info` VALUES ('66adcd356e064d728e30d8b1d35b4cb2', 'ooo', null, null, 'fb7207eb9559f07366f80c59dbe1ced8b43427af4a0e5c9603a370ff9b88cac4', '5c6f8', '5c6f8', '3', null, 'A', '0', '2018-02-20 16:39:06');
INSERT INTO `sy_user_info` VALUES ('6e634aa12095426497c0fd23081d3cb4', 'admin', null, null, 'a19cce0d159a6726e4436ec2d61c6eb76f922f07b1c10593dfe7f39d40c87761', '7d37e', '7d37e', '3', null, 'A', '0', '2018-02-16 10:49:20');
INSERT INTO `sy_user_info` VALUES ('7adae6f0010c4204a75ff50189a0fcb8', 'gg', null, null, 'c921849a66916eb4094fd7c6a7498f2a76f559feb5d644bdc21955460b446f14', '6f480', '235ff', '2', null, 'A', '0', '2018-02-19 16:35:32');
INSERT INTO `sy_user_info` VALUES ('8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, '2fa3f8069efb99a994c367195f584e81aed06dda2835a61d53ed76473b1c3eca', '079aa', 'f16b7', '1683', '../../../static/img/img.jpg', 'A', '0', '2018-02-20 16:53:03');
INSERT INTO `sy_user_info` VALUES ('95ac2c849990405ea4a4004785f5e693', 'asdfasdf', null, null, 'c444f76522b110c833d89b64e3d43b33ef06a5d935354dc658c07f8fd84c2b8f', 'f47bb', 'f47bb', '3', null, 'A', '0', '2018-02-19 17:22:56');
INSERT INTO `sy_user_info` VALUES ('9a917dc64a80483ea717dd0389207533', 'vbn', null, null, '41b89137583a0afbbcbda9357e0333bcf3c6dcc64167face4f0a103ebcba75d2', 'fb926', 'fb926', '3', null, 'A', '0', '2018-02-20 16:34:30');
INSERT INTO `sy_user_info` VALUES ('aa709353500845aeb97be4fcdfddf8ec', 'testa', null, null, 'a3a2ec281a05ce4fb87656079e11029c6177431723df930609e7acfe07914820', '0dafe', '3b8cb', '616', null, 'A', '0', '2018-02-18 17:54:49');
INSERT INTO `sy_user_info` VALUES ('b0e403ba11034368b18bd5cc7bc86966', 'bb', null, null, 'ae47d2985f9aff49901fffb17f6e2060be560ce0efea5f2a701e0af6c5e95f5b', '98f51', '3edbe', '7036', null, 'A', '0', '2018-02-19 17:20:17');
INSERT INTO `sy_user_info` VALUES ('bd4cc829cceb441a8a1b704d9a570fb7', '000', null, null, '1249f24200b5ba32faf29ddeb94fa38fcbb87469e495c10adb06d3b558b4388c', 'cf7a0', 'ac89f', '2', null, 'A', '0', '2018-02-20 16:40:41');
INSERT INTO `sy_user_info` VALUES ('cb8b43344fcc47a5bf3187a0b2b2fae9', 'testb', null, null, 'ceae36b109e3dd58712050a635e1ee9ec25d23f95bdd94a6fac1db0675398c28', 'fddc0', '2b6b3', '1888', null, 'A', '0', '2018-02-18 17:52:20');

-- ----------------------------
-- Table structure for `sy_user_trade`
-- ----------------------------
DROP TABLE IF EXISTS `sy_user_trade`;
CREATE TABLE `sy_user_trade` (
  `SUT_TRADE_ID` varchar(36) NOT NULL COMMENT '交易编号',
  `SUT_TRADE_TYPE` varchar(10) NOT NULL COMMENT '交易类型',
  `SUT_TRADE_TIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '交易时间',
  `SUT_OPR_USER_ID` varchar(36) NOT NULL COMMENT '经办人用户号',
  `SUT_OPR_LOGIN_NAME` varchar(60) NOT NULL COMMENT '经办人登录名',
  `SUT_LOGIN_NAME` varchar(60) NOT NULL COMMENT '登录名',
  `SUT_PHONE` varchar(20) default NULL COMMENT '手机',
  `SUT_MAIL` varchar(100) default NULL COMMENT '邮箱',
  `SUT_FACE` varchar(100) default NULL COMMENT '头像',
  `SUT_RECORD_ID` varchar(36) NOT NULL COMMENT '流程记录编号',
  `SUT_TRADE_STATUS` char(1) NOT NULL COMMENT '交易状态',
  PRIMARY KEY  (`SUT_TRADE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_user_trade
-- ----------------------------
INSERT INTO `sy_user_trade` VALUES ('02410bb6918b4a02a2d1bb7fec0f4119', 'SYUSRADD01', '2018-02-20 15:03:31', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'eee', '', '', null, 'bc340dd331ac400cb36ce24248536920', 'A');
INSERT INTO `sy_user_trade` VALUES ('4583f7bf97b44f74b42e49681768bf1d', 'SYUSRADD01', '2018-02-20 15:03:18', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'xxx', '', '', null, '5274482f31db45b283bf7bfc7aea3e33', 'A');
INSERT INTO `sy_user_trade` VALUES ('4f8d98c06db64994b9c70eb57f41d2f4', 'SYUSRADD01', '2018-02-20 15:03:40', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'hhh', '', '', null, '6e3a760b4b85430f84a91458ae958bb8', 'A');
INSERT INTO `sy_user_trade` VALUES ('50e35a63af274689a33ce2fa06a22ca7', 'SYUSRADD01', '2018-02-19 16:49:45', '32b3689f5b3b41eab6883df33d20b41d', 'testc', 'bb', '', '', null, '446381f6d5564102b459163f58de7d77', 'F');
INSERT INTO `sy_user_trade` VALUES ('662af6778ca54de5849891e615bc6f0e', 'SYUSRADD01', '2018-02-20 15:03:16', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'ccc', '', '', null, '08879535f3dc418692156e6d4a3b4447', 'A');
INSERT INTO `sy_user_trade` VALUES ('80cf88d78e6a494b852f9d04de280e35', 'SYUSRADD01', '2018-02-20 15:03:29', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'rrr', '', '', null, '6bb143fcf0ad41429111bdd73f3af749', 'A');
INSERT INTO `sy_user_trade` VALUES ('916eb94dd60449c485487faa72609c9c', 'SYUSRADD01', '2018-02-20 15:03:22', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'zzz', '', '', null, '2d729dbd74ed4834b08d4cbbc182b757', 'A');
INSERT INTO `sy_user_trade` VALUES ('9830596c730a4424a3eb6b0c98163565', 'SYUSRADD01', '2018-02-19 15:40:09', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'gg', '', '', null, '7cf3fe4901eb4f5da6139910a398f954', 'S');
INSERT INTO `sy_user_trade` VALUES ('a0da8d0153e145feb4a50d8f0142e62c', 'SYUSRADD01', '2018-02-20 15:03:43', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'jjj', '', '', null, '1af06e088f684396981a43d790cfa005', 'A');
INSERT INTO `sy_user_trade` VALUES ('a88f208ae9794937906ea19d1c36124d', 'SYUSRADD01', '2018-02-20 15:03:37', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'nnn', '', '', null, 'ad3af9fac2cf42a986f50d2da57c15e8', 'A');
INSERT INTO `sy_user_trade` VALUES ('b55e2fbf986e4d3fa34c9c88d823188c', 'SYUSRADD01', '2018-02-18 21:28:18', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'qq', '', '', null, '931f8941549c428dabcb60d1fabc8c5a', 'A');
INSERT INTO `sy_user_trade` VALUES ('cddd9959e54547429c4263d09e8ff1b6', 'SYUSRADD01', '2018-02-20 15:03:34', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'bbb', '', '', null, '63d41804f6214b8a9405d86c2c6f7ae4', 'A');
INSERT INTO `sy_user_trade` VALUES ('d3a4d27102c34e4fb36e1d4f8e9a9a70', 'SYUSRADD01', '2018-02-20 10:30:11', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'kjk', '', '', null, 'a98b95fcc4f34337b031169e40f2d190', 'A');
INSERT INTO `sy_user_trade` VALUES ('d4a9102d9a6a4d4d92e97b5c61204c21', 'SYUSRADD01', '2018-02-20 15:03:12', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'sss', '', '', null, '5ae62adaee424605bb4698d765bf395f', 'A');
INSERT INTO `sy_user_trade` VALUES ('de8d5b21fd794ef2af6808ba440f61c9', 'SYUSRADD01', '2018-02-20 15:03:26', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'trtt', '', '', null, 'f6b419f7933c4eefa1720f4e44b983f1', 'A');
INSERT INTO `sy_user_trade` VALUES ('fd912f5bb4ec4002a695b8cfd2bb5d3b', 'SYUSRADD01', '2018-02-19 17:22:23', '8db93e067da349cdb13a356f739c8f4f', 'aa', 'asdfasdf', '', '', null, '8a4c31fc20904f00a6a3299d467d0a92', 'S');

-- ----------------------------
-- Table structure for `sy_wkf_agent`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_agent`;
CREATE TABLE `sy_wkf_agent` (
  `SWA_USER_ID` varchar(36) NOT NULL COMMENT '用户号',
  `SWA_LOGIN_NAME` varchar(60) NOT NULL COMMENT '登录名',
  `SWA_AGENT_USER_ID` varchar(36) NOT NULL COMMENT '代理人用户号',
  `SWA_AGENT_LOGIN_NAME` varchar(60) NOT NULL COMMENT '代理人登录名',
  `SWA_AGENT_STATUS` char(1) NOT NULL COMMENT '状态',
  PRIMARY KEY  (`SWA_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_agent
-- ----------------------------

-- ----------------------------
-- Table structure for `sy_wkf_cfg_log`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_cfg_log`;
CREATE TABLE `sy_wkf_cfg_log` (
  `SCL_LOG_ID` varchar(36) NOT NULL COMMENT '日志编号',
  `SCL_LOG_TIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '日志时间',
  `SCL_USER_ID` varchar(36) NOT NULL COMMENT '操作人用户号',
  `SCL_LOGIN_NAME` varchar(60) NOT NULL COMMENT '操作人登录名',
  `SCL_TABLE` varchar(60) NOT NULL COMMENT '操作表',
  `SCL_OPR_TYPE` char(2) NOT NULL COMMENT '操作类型',
  `SCL_FIELD` varchar(60) default NULL COMMENT '字段定义',
  `SCL_OLD_VALUE` varchar(60) default NULL COMMENT '旧值',
  `SCL_NEW_VALUE` varchar(60) default NULL COMMENT '新值',
  PRIMARY KEY  (`SCL_LOG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_cfg_log
-- ----------------------------

-- ----------------------------
-- Table structure for `sy_wkf_define`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_define`;
CREATE TABLE `sy_wkf_define` (
  `SWD_WKF_CODE` char(4) NOT NULL COMMENT '模式代号',
  `SWD_WKF_NAME` varchar(60) NOT NULL COMMENT '名称',
  `SWD_WKF_TYPE` char(2) NOT NULL COMMENT '流程模型',
  `SWD_ROUTE_TYPE` char(2) NOT NULL COMMENT '路由类型',
  `SWD_CHECK_FLAG` char(1) NOT NULL COMMENT '签收标志',
  `SWD_WKF_STATUS` char(1) NOT NULL COMMENT '工作流状态',
  PRIMARY KEY  (`SWD_WKF_CODE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_define
-- ----------------------------
INSERT INTO `sy_wkf_define` VALUES ('A001', '审批流', 'A1', 'SI', 'Y', 'A');

-- ----------------------------
-- Table structure for `sy_wkf_entity`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_entity`;
CREATE TABLE `sy_wkf_entity` (
  `SWE_ENTITY_ID` varchar(36) NOT NULL COMMENT '实例编号',
  `SWE_ENTITY_NAME` varchar(60) default NULL COMMENT '实例名称',
  `SWE_WKF_CODE` char(4) NOT NULL COMMENT '模式代号',
  `SWE_BUSINESS_TYPE` varchar(10) NOT NULL COMMENT '关联业务类型',
  `SWE_MATCH_VALUE` char(2) default NULL COMMENT '实例匹配值',
  `SWE_NODE_HEAD` varchar(36) NOT NULL COMMENT '首结点编号',
  `SWE_NODE_HEAD_NAME` varchar(60) default NULL COMMENT '首结点名称',
  `SWE_ENTITY_STATUS` char(1) NOT NULL COMMENT '流程实例状态',
  PRIMARY KEY  (`SWE_ENTITY_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_entity
-- ----------------------------
INSERT INTO `sy_wkf_entity` VALUES ('bedc8a83ec9a451587f16bb6d7e097d8', '用户管理-审批流程', 'A001', 'SYUSR', '', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'A');

-- ----------------------------
-- Table structure for `sy_wkf_entity_business`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_entity_business`;
CREATE TABLE `sy_wkf_entity_business` (
  `SEB_WKF_CODE` char(4) NOT NULL COMMENT '模式代号',
  `SEB_BUSINESS_TYPE` varchar(10) NOT NULL COMMENT '关联业务类型',
  `SEB_IS_SINGLE` char(1) NOT NULL COMMENT '是否单实例',
  `SEB_MATCH_STRATEGY` char(2) default NULL COMMENT '多实例匹配策略',
  `SEB_MATCH_CLAZZ` varchar(100) default NULL COMMENT '实例匹配自定义实现类',
  PRIMARY KEY  (`SEB_WKF_CODE`,`SEB_BUSINESS_TYPE`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_entity_business
-- ----------------------------
INSERT INTO `sy_wkf_entity_business` VALUES ('A001', 'SYUSR', 'Y', '', '');

-- ----------------------------
-- Table structure for `sy_wkf_node`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_node`;
CREATE TABLE `sy_wkf_node` (
  `SWN_NODE_ID` varchar(36) NOT NULL COMMENT '结点编号',
  `SWN_NODE_NAME` varchar(60) default NULL COMMENT '结点名称',
  `SWN_ENTITY_ID` varchar(36) NOT NULL COMMENT '实例编号',
  `SWN_WG_ID` varchar(36) NOT NULL COMMENT '工作组编号',
  `SWN_EVENT_TYPE` char(2) NOT NULL COMMENT '事件类型',
  `SWN_EVENT_RULE` char(2) NOT NULL COMMENT '事件执行方式',
  `SWN_EVENT_EXT` varchar(100) default NULL COMMENT '事件执行扩展',
  `SWN_RECORD_TYPE` char(2) NOT NULL COMMENT '数据记录方式',
  `SWN_ROUTE_STRATEGY` char(2) NOT NULL COMMENT '路由策略',
  `SWN_ROUTE_STRATEGY_CLAZZ` varchar(100) default NULL COMMENT '自定义路由策略实现类',
  `SWN_BACK_STRATEGY` char(2) NOT NULL COMMENT '回退策略',
  `SWN_BACK_STRATEGY_CLAZZ` varchar(100) default NULL COMMENT '自定义回退策略实现类',
  `SWN_BRANCH_STRATEGY` char(2) default NULL COMMENT '分支处理策略',
  `SWN_BRANCH_STRATEGY_CLAZZ` varchar(100) default NULL COMMENT '自定义分支处理策略',
  `SWN_IS_AUTO` char(1) NOT NULL COMMENT '是否自动执行',
  `SWN_VIEW_URL` varchar(100) default NULL COMMENT '前端URL',
  `SWN_NODE_STATUS` char(1) NOT NULL COMMENT '结点状态',
  PRIMARY KEY  (`SWN_NODE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_node
-- ----------------------------
INSERT INTO `sy_wkf_node` VALUES ('14d63db4291b4170b0bc82e2717021d7', '用户管理-审批2', 'bedc8a83ec9a451587f16bb6d7e097d8', 'f66b18e1abe74245ad9c25a0ed065ad2', 'E2', 'T1', '', 'R1', 'A2', '', 'C2', '', '', '', 'N', '', 'A');
INSERT INTO `sy_wkf_node` VALUES ('d8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'bedc8a83ec9a451587f16bb6d7e097d8', 'b88422f50c8540998dc9228cf4c9db10', 'E2', 'T1', '', 'R1', 'A2', '', 'C2', '', '', '', 'N', '', 'A');
INSERT INTO `sy_wkf_node` VALUES ('e8f06af891774dfc9aea03fd60bbc7cb', '用户管理-终审', 'bedc8a83ec9a451587f16bb6d7e097d8', '10bfa7ec1ec84360b27d9c5566b42628', 'E2', 'T2', 'com.kool.system.wkfhandler.UserManagerApproveHandler', 'R1', 'A2', '', 'C2', '', '', '', 'N', '', 'A');

-- ----------------------------
-- Table structure for `sy_wkf_node_template`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_node_template`;
CREATE TABLE `sy_wkf_node_template` (
  `SNT_TEMPLATE_ID` varchar(36) NOT NULL COMMENT '结点模板编号',
  `SNT_TEMPLATE_NAME` varchar(60) default NULL COMMENT '结点模板名称',
  `SNT_ENTITY_ID` varchar(36) NOT NULL COMMENT '实例编号',
  `SNT_EVENT_TYPE` char(2) NOT NULL COMMENT '事件类型',
  `SNT_EVENT_RULE` char(2) NOT NULL COMMENT '事件执行方式',
  `SNT_EVENT_EXT` varchar(100) default NULL COMMENT '事件执行扩展',
  `SNT_RECORD_TYPE` char(2) NOT NULL COMMENT '数据记录方式',
  `SNT_ROUTE_STRATEGY` char(2) NOT NULL COMMENT '路由策略',
  `SNT_ROUTE_STRATEGY_CLAZZ` varchar(100) default NULL COMMENT '自定义策略实现类',
  `SNT_ROUTE_TYPE` char(2) NOT NULL COMMENT '路由类型',
  `SNT_BRANCH_STRATEGY` char(2) default NULL COMMENT '分支处理策略',
  `SNT_BRANCH_STRATEGY_CLAZZ` varchar(100) default NULL COMMENT '自定义分支处理策略',
  `SNT_IS_AUTO` char(1) NOT NULL COMMENT '是否自动执行',
  `SNT_VIEW_URL` varchar(100) default NULL COMMENT '前端URL',
  PRIMARY KEY  (`SNT_TEMPLATE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_node_template
-- ----------------------------

-- ----------------------------
-- Table structure for `sy_wkf_record`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_record`;
CREATE TABLE `sy_wkf_record` (
  `SRC_RECORD_ID` varchar(36) NOT NULL COMMENT '记录编号',
  `SRC_TIME_BEGIN` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '流程开始时间',
  `SRC_TIME_END` timestamp NULL default NULL COMMENT '流程结束时间',
  `SRC_WKF_CODE` char(4) NOT NULL COMMENT '模式代号',
  `SRC_ENTITY_ID` varchar(36) NOT NULL COMMENT '实例编号',
  `SRC_BUSINESS_ID` varchar(60) default NULL COMMENT '关联业务流水号',
  `SRC_BUSINESS_TYPE` varchar(10) NOT NULL COMMENT '关联业务类型',
  `SRC_NODE_HEAD` varchar(36) NOT NULL COMMENT '首结点编号',
  `SRC_NODE_HEAD_NAME` varchar(60) default NULL COMMENT '首结点名称',
  `SRC_START_USER_ID` varchar(36) NOT NULL COMMENT '发起人用户号',
  `SRC_START_LOGIN_NAME` varchar(60) NOT NULL COMMENT '发起人登录名',
  `SRC_END_USER_ID` varchar(36) default NULL COMMENT '完成人用户号',
  `SRC_END_LOGIN_NAME` varchar(60) default NULL COMMENT '完成人登录名',
  `SRC_DESCRIPTION` varchar(256) default NULL COMMENT '流程概要描述',
  `SRC_RECORD_STATUS` char(3) NOT NULL COMMENT '执行状态',
  PRIMARY KEY  (`SRC_RECORD_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_record
-- ----------------------------
INSERT INTO `sy_wkf_record` VALUES ('08879535f3dc418692156e6d4a3b4447', '2018-02-20 15:03:16', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');
INSERT INTO `sy_wkf_record` VALUES ('1af06e088f684396981a43d790cfa005', '2018-02-20 15:03:43', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');
INSERT INTO `sy_wkf_record` VALUES ('2d729dbd74ed4834b08d4cbbc182b757', '2018-02-20 15:03:22', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');
INSERT INTO `sy_wkf_record` VALUES ('446381f6d5564102b459163f58de7d77', '2018-02-19 16:49:45', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '32b3689f5b3b41eab6883df33d20b41d', 'testc', null, null, null, 'FIN');
INSERT INTO `sy_wkf_record` VALUES ('5274482f31db45b283bf7bfc7aea3e33', '2018-02-20 15:03:18', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');
INSERT INTO `sy_wkf_record` VALUES ('5ae62adaee424605bb4698d765bf395f', '2018-02-20 15:03:13', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');
INSERT INTO `sy_wkf_record` VALUES ('63d41804f6214b8a9405d86c2c6f7ae4', '2018-02-20 15:03:34', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');
INSERT INTO `sy_wkf_record` VALUES ('6bb143fcf0ad41429111bdd73f3af749', '2018-02-20 15:03:29', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');
INSERT INTO `sy_wkf_record` VALUES ('6e3a760b4b85430f84a91458ae958bb8', '2018-02-20 15:03:40', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');
INSERT INTO `sy_wkf_record` VALUES ('7cf3fe4901eb4f5da6139910a398f954', '2018-02-19 15:40:40', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FIN');
INSERT INTO `sy_wkf_record` VALUES ('8254a540a4914dcc934e07a3ad4e4216', '2018-02-18 21:19:07', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', '', '', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');
INSERT INTO `sy_wkf_record` VALUES ('8a4c31fc20904f00a6a3299d467d0a92', '2018-02-19 17:22:23', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FIN');
INSERT INTO `sy_wkf_record` VALUES ('931f8941549c428dabcb60d1fabc8c5a', '2018-02-18 21:28:18', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');
INSERT INTO `sy_wkf_record` VALUES ('a98b95fcc4f34337b031169e40f2d190', '2018-02-20 10:30:11', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');
INSERT INTO `sy_wkf_record` VALUES ('ad3af9fac2cf42a986f50d2da57c15e8', '2018-02-20 15:03:37', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');
INSERT INTO `sy_wkf_record` VALUES ('bc340dd331ac400cb36ce24248536920', '2018-02-20 15:03:31', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');
INSERT INTO `sy_wkf_record` VALUES ('f6b419f7933c4eefa1720f4e44b983f1', '2018-02-20 15:03:26', null, 'A001', 'bedc8a83ec9a451587f16bb6d7e097d8', null, 'SYUSR', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '8db93e067da349cdb13a356f739c8f4f', 'aa', null, null, null, 'FAT');

-- ----------------------------
-- Table structure for `sy_wkf_record_data`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_record_data`;
CREATE TABLE `sy_wkf_record_data` (
  `SRT_RECORD_ID` varchar(36) NOT NULL COMMENT '记录编号',
  `SRT_DETAIL_ID` varchar(36) NOT NULL COMMENT '记录明细编号',
  `SRT_BUS_PKG` blob NOT NULL COMMENT '大字段',
  PRIMARY KEY  (`SRT_RECORD_ID`,`SRT_DETAIL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_record_data
-- ----------------------------

-- ----------------------------
-- Table structure for `sy_wkf_record_detail`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_record_detail`;
CREATE TABLE `sy_wkf_record_detail` (
  `SRD_DETAIL_ID` varchar(36) NOT NULL COMMENT '记录明细编号',
  `SRD_RECORD_ID` varchar(36) NOT NULL COMMENT '记录编号',
  `SRD_SCHEDULE_ID` varchar(36) NOT NULL COMMENT '待办编号',
  `SRD_DETAIL_SEQ` int(11) default NULL COMMENT '序号',
  `SRD_DETAIL_TIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '记录时间',
  `SRD_NODE_ID` varchar(36) NOT NULL COMMENT '执行结点编号',
  `SRD_NODE_NAME` varchar(60) default NULL COMMENT '执行结点名称',
  `SRD_USER_ID` varchar(36) NOT NULL COMMENT '执行人用户号',
  `SRD_LOGIN_NAME` varchar(60) NOT NULL COMMENT '执行人登录名',
  `SRD_EVENT_TYPE` char(2) NOT NULL COMMENT '事件类型',
  `SRD_EVENT_RULE` char(2) NOT NULL COMMENT '事件执行方式',
  `SRD_EVENT_FLAG` char(1) default NULL COMMENT '事件选择标志',
  `SRD_EVENT_DSP` varchar(256) default NULL COMMENT '事件摘要',
  `SRD_BUSINESS_FIELD1` varchar(36) default NULL COMMENT '业务要素1',
  `SRD_BUSINESS_FIELD2` varchar(36) default NULL COMMENT '业务要素2',
  `SRD_BUSINESS_FIELD3` varchar(36) default NULL COMMENT '业务要素3',
  `SRD_BUSINESS_FIELD4` varchar(36) default NULL COMMENT '业务要素4',
  `SRD_BUSINESS_FIELD5` varchar(36) default NULL COMMENT '业务要素5',
  `SRD_BUSINESS_FIELD6` varchar(60) default NULL COMMENT '业务要素6',
  `SRD_BUSINESS_FIELD7` varchar(256) default NULL COMMENT '业务要素7',
  `SRD_BUSINESS_FIELD8` date default NULL COMMENT '业务要素8',
  `SRD_BUSINESS_FIELD9` timestamp NULL default NULL COMMENT '业务要素9',
  `SRD_BUSINESS_FIELD10` decimal(10,0) default NULL COMMENT '业务要素10',
  `SRD_RECORD_STATUS` char(3) NOT NULL COMMENT '执行后状态',
  PRIMARY KEY  (`SRD_DETAIL_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_record_detail
-- ----------------------------
INSERT INTO `sy_wkf_record_detail` VALUES ('331de55d13484c50805f15689ea52c29', '8a4c31fc20904f00a6a3299d467d0a92', '46c931fac4a8426ab1a01fc842540ca9', '1', '2018-02-19 17:22:45', '14d63db4291b4170b0bc82e2717021d7', '用户管理-审批2', '15b3cdcc16ee4460b52d17cead3da833', 'cc', 'E2', 'T1', 'Y', '', null, null, null, null, null, null, null, null, null, null, 'FIN');
INSERT INTO `sy_wkf_record_detail` VALUES ('4e33b047a5194c9aa21f74add0e44861', '446381f6d5564102b459163f58de7d77', '58b5656edd464ca3bd20d8f490d2e0cc', '1', '2018-02-19 17:13:20', '14d63db4291b4170b0bc82e2717021d7', '用户管理-审批2', 'cb8b43344fcc47a5bf3187a0b2b2fae9', 'testb', 'E2', 'T1', 'Y', 'asdf', null, null, null, null, null, null, null, null, null, null, 'FIN');
INSERT INTO `sy_wkf_record_detail` VALUES ('5843275fc3094f879b80b2d0fa05648d', '446381f6d5564102b459163f58de7d77', 'dcf7dea8ac1d4ed18c9a5b09e3004b9d', '1', '2018-02-19 17:13:00', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'aa709353500845aeb97be4fcdfddf8ec', 'testa', 'E2', 'T1', 'Y', 'affsdf', null, null, null, null, null, null, null, null, null, null, 'FIN');
INSERT INTO `sy_wkf_record_detail` VALUES ('606e538eb91442fcb0de1244f091c96f', '8a4c31fc20904f00a6a3299d467d0a92', '601ec1c100c540f8b23ecea20e69ad21', '1', '2018-02-19 17:22:36', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b0e403ba11034368b18bd5cc7bc86966', 'bb', 'E2', 'T1', 'Y', '', null, null, null, null, null, null, null, null, null, null, 'FIN');
INSERT INTO `sy_wkf_record_detail` VALUES ('635acf41a42444aeb8341cfd6ef90124', '7cf3fe4901eb4f5da6139910a398f954', 'bf0fb8c81b8c4608b8f1a6f5ddb79c11', '1', '2018-02-19 16:06:30', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'aa709353500845aeb97be4fcdfddf8ec', 'testa', 'E2', 'T1', 'Y', 'agree', null, null, null, null, null, null, null, null, null, null, 'FIN');
INSERT INTO `sy_wkf_record_detail` VALUES ('72cf24e4b35b4efd92acd7b95963867c', '7cf3fe4901eb4f5da6139910a398f954', 'bf0fb8c81b8c4608b8f1a6f5ddb79c11', '1', '2018-02-19 16:29:50', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'aa709353500845aeb97be4fcdfddf8ec', 'testa', 'E2', 'T1', 'Y', 'aaa', null, null, null, null, null, null, null, null, null, null, 'FIN');
INSERT INTO `sy_wkf_record_detail` VALUES ('8d6be00c632f41b3bba659368493106b', '446381f6d5564102b459163f58de7d77', '62398cbc5dc14f4ea7cd4676b7dbc74d', '1', '2018-02-19 17:13:44', 'e8f06af891774dfc9aea03fd60bbc7cb', '用户管理-终审', '32b3689f5b3b41eab6883df33d20b41d', 'testc', 'E2', 'T2', 'N', '', null, null, null, null, null, null, null, null, null, null, 'FIN');
INSERT INTO `sy_wkf_record_detail` VALUES ('c03caa1c3d4741d3a37290c13b390ab6', '8a4c31fc20904f00a6a3299d467d0a92', 'd5ceaa47dd2b49218919713d853bd6f8', '1', '2018-02-19 17:22:56', 'e8f06af891774dfc9aea03fd60bbc7cb', '用户管理-终审', '34d99e0732884f6688e471e71af93c68', 'dd', 'E2', 'T2', 'Y', 's', null, null, null, null, null, null, null, null, null, null, 'FIN');
INSERT INTO `sy_wkf_record_detail` VALUES ('e9ba31b91faa4d54a252fd4cc8c87b99', '7cf3fe4901eb4f5da6139910a398f954', '27beaa597c0a45dc90ea50f20d8b0012', '1', '2018-02-19 16:35:34', 'e8f06af891774dfc9aea03fd60bbc7cb', '用户管理-终审', '32b3689f5b3b41eab6883df33d20b41d', 'testc', 'E2', 'T2', 'Y', '', null, null, null, null, null, null, null, null, null, null, 'FIN');
INSERT INTO `sy_wkf_record_detail` VALUES ('ffe100d1696942f590501595a29d40fe', '7cf3fe4901eb4f5da6139910a398f954', '0de680daa897435d8d3f8575a1fed81d', '1', '2018-02-19 16:30:35', '14d63db4291b4170b0bc82e2717021d7', '用户管理-审批2', 'cb8b43344fcc47a5bf3187a0b2b2fae9', 'testb', 'E2', 'T1', 'Y', 'vv', null, null, null, null, null, null, null, null, null, null, 'FIN');

-- ----------------------------
-- Table structure for `sy_wkf_route`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_route`;
CREATE TABLE `sy_wkf_route` (
  `SWR_ROUTE_ID` varchar(36) NOT NULL COMMENT '路由编号',
  `SWR_ENTITY_ID` varchar(36) NOT NULL COMMENT '实例编号',
  `SWR_ROUTE_CODE` varchar(36) default NULL COMMENT '路由代码',
  `SWR_NODE_HEAD` varchar(36) NOT NULL COMMENT '首结点编号',
  `SWR_NODE_HEAD_NAME` varchar(60) default NULL COMMENT '首结点名称',
  `SWR_NODE_TAIL` varchar(36) NOT NULL COMMENT '尾结点编号',
  `SWR_NODE_TAIL_NAME` varchar(60) default NULL COMMENT '尾结点名称',
  `SWR_ROUTE_STATUS` char(1) NOT NULL COMMENT '路由状态',
  PRIMARY KEY  (`SWR_ROUTE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_route
-- ----------------------------
INSERT INTO `sy_wkf_route` VALUES ('36c22335ddf44220ad2ea57065e797f6', 'bedc8a83ec9a451587f16bb6d7e097d8', '', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', '14d63db4291b4170b0bc82e2717021d7', '用户管理-审批2', 'A');
INSERT INTO `sy_wkf_route` VALUES ('57a1b590c21845d2b845205f1b072d9f', 'bedc8a83ec9a451587f16bb6d7e097d8', '', '14d63db4291b4170b0bc82e2717021d7', '用户管理-审批2', 'e8f06af891774dfc9aea03fd60bbc7cb', '用户管理-终审', 'A');

-- ----------------------------
-- Table structure for `sy_wkf_schedule`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_schedule`;
CREATE TABLE `sy_wkf_schedule` (
  `SWS_SCHEDULE_ID` varchar(36) NOT NULL COMMENT '待办编号',
  `SWS_RECORD_ID` varchar(36) NOT NULL COMMENT '记录编号',
  `SWS_LAST_NODE_ID` varchar(36) default NULL COMMENT '上一结点编号',
  `SWS_LAST_NODE_NAME` varchar(60) default NULL COMMENT '上一结点名称',
  `SWS_LAST_USER_ID` varchar(36) default NULL COMMENT '上一执行人用户编号',
  `SWS_LAST_LOGIN_NAME` varchar(60) default NULL COMMENT '上一执行人用户登录名',
  `SWS_SCHEDULE_NODE_ID` varchar(36) NOT NULL COMMENT '待办结点编号',
  `SWS_SCHEDULE_NODE_NAME` varchar(60) default NULL COMMENT '待办结点名称',
  `SWS_WG_ID` varchar(36) NOT NULL COMMENT '待办工作组ID',
  `SWS_WG_NAME` varchar(60) default NULL COMMENT '工作组名称',
  `SWS_SCHEDULE_USER_ID` varchar(36) default NULL COMMENT '签收人用户号',
  `SWS_SCHEDULE_LOGIN_NAME` varchar(60) default NULL COMMENT '签收人登录名',
  `SWS_BRANCH_FLAG` char(1) default NULL COMMENT '是否分支中标志',
  `SWS_BRANCH_HEAD_ID` varchar(36) default NULL COMMENT '分支首结点编号',
  `SWS_BRANCH_HEAD_NAME` varchar(60) default NULL COMMENT '分支首结点名称',
  `SWS_SCHEDULE_STATUS` char(3) NOT NULL COMMENT '状态',
  `SWS_CREATE_TIME` timestamp NOT NULL default CURRENT_TIMESTAMP on update CURRENT_TIMESTAMP COMMENT '创建时间',
  PRIMARY KEY  (`SWS_SCHEDULE_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_schedule
-- ----------------------------
INSERT INTO `sy_wkf_schedule` VALUES ('0de680daa897435d8d3f8575a1fed81d', '7cf3fe4901eb4f5da6139910a398f954', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'aa709353500845aeb97be4fcdfddf8ec', 'testa', '14d63db4291b4170b0bc82e2717021d7', '用户管理-审批2', 'f66b18e1abe74245ad9c25a0ed065ad2', null, null, null, 'N', null, null, 'CLS', '2018-02-19 16:35:34');
INSERT INTO `sy_wkf_schedule` VALUES ('259714cd759242968b5ec8683080fc43', 'ad3af9fac2cf42a986f50d2da57c15e8', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'RDY', '2018-02-20 15:03:37');
INSERT INTO `sy_wkf_schedule` VALUES ('27beaa597c0a45dc90ea50f20d8b0012', '7cf3fe4901eb4f5da6139910a398f954', '14d63db4291b4170b0bc82e2717021d7', '用户管理-审批2', 'cb8b43344fcc47a5bf3187a0b2b2fae9', 'testb', 'e8f06af891774dfc9aea03fd60bbc7cb', '用户管理-终审', '10bfa7ec1ec84360b27d9c5566b42628', null, null, null, 'N', null, null, 'FIN', '2018-02-19 16:30:36');
INSERT INTO `sy_wkf_schedule` VALUES ('30408f7a4ae04364868eb760189f63fa', '2d729dbd74ed4834b08d4cbbc182b757', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'RDY', '2018-02-20 15:03:22');
INSERT INTO `sy_wkf_schedule` VALUES ('4225d87cd64b49709da292a0999beef2', 'a98b95fcc4f34337b031169e40f2d190', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, 'cb8b43344fcc47a5bf3187a0b2b2fae9', 'testb', 'N', null, null, 'CHK', '2018-02-20 10:30:11');
INSERT INTO `sy_wkf_schedule` VALUES ('46c931fac4a8426ab1a01fc842540ca9', '8a4c31fc20904f00a6a3299d467d0a92', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b0e403ba11034368b18bd5cc7bc86966', 'bb', '14d63db4291b4170b0bc82e2717021d7', '用户管理-审批2', 'f66b18e1abe74245ad9c25a0ed065ad2', null, null, null, 'N', null, null, 'CLS', '2018-02-19 17:22:56');
INSERT INTO `sy_wkf_schedule` VALUES ('52bddca59cfd4d3095f3cff018878e15', '63d41804f6214b8a9405d86c2c6f7ae4', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'RDY', '2018-02-20 15:03:34');
INSERT INTO `sy_wkf_schedule` VALUES ('58b5656edd464ca3bd20d8f490d2e0cc', '446381f6d5564102b459163f58de7d77', 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'aa709353500845aeb97be4fcdfddf8ec', 'testa', '14d63db4291b4170b0bc82e2717021d7', '用户管理-审批2', 'f66b18e1abe74245ad9c25a0ed065ad2', null, null, null, 'N', null, null, 'CLS', '2018-02-19 17:13:44');
INSERT INTO `sy_wkf_schedule` VALUES ('601ec1c100c540f8b23ecea20e69ad21', '8a4c31fc20904f00a6a3299d467d0a92', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'CLS', '2018-02-19 17:22:56');
INSERT INTO `sy_wkf_schedule` VALUES ('62398cbc5dc14f4ea7cd4676b7dbc74d', '446381f6d5564102b459163f58de7d77', '14d63db4291b4170b0bc82e2717021d7', '用户管理-审批2', 'cb8b43344fcc47a5bf3187a0b2b2fae9', 'testb', 'e8f06af891774dfc9aea03fd60bbc7cb', '用户管理-终审', '10bfa7ec1ec84360b27d9c5566b42628', null, null, null, 'N', null, null, 'FIN', '2018-02-19 17:13:20');
INSERT INTO `sy_wkf_schedule` VALUES ('63e6e4ac0d3a472d825c058e1d3f87a5', 'f6b419f7933c4eefa1720f4e44b983f1', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'RDY', '2018-02-20 15:03:26');
INSERT INTO `sy_wkf_schedule` VALUES ('717071cc0dae4f308d6fafac3687b4ff', '6e3a760b4b85430f84a91458ae958bb8', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'RDY', '2018-02-20 15:03:40');
INSERT INTO `sy_wkf_schedule` VALUES ('9506258cd8064f2ba1cb14f1fcd885b8', 'bc340dd331ac400cb36ce24248536920', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'RDY', '2018-02-20 15:03:31');
INSERT INTO `sy_wkf_schedule` VALUES ('a09f914069294828a009afe10e37d197', '1af06e088f684396981a43d790cfa005', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'RDY', '2018-02-20 15:03:43');
INSERT INTO `sy_wkf_schedule` VALUES ('a99d777bb7fb4cc6bddc9ed7f132a72b', '5274482f31db45b283bf7bfc7aea3e33', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'RDY', '2018-02-20 15:03:18');
INSERT INTO `sy_wkf_schedule` VALUES ('b52c774a1c104e93b9300f2e0062401d', '6bb143fcf0ad41429111bdd73f3af749', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'RDY', '2018-02-20 15:03:29');
INSERT INTO `sy_wkf_schedule` VALUES ('bf0fb8c81b8c4608b8f1a6f5ddb79c11', '7cf3fe4901eb4f5da6139910a398f954', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'CLS', '2018-02-19 16:35:34');
INSERT INTO `sy_wkf_schedule` VALUES ('bf3bf9cba7144042b90ef8684a576a97', '08879535f3dc418692156e6d4a3b4447', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'RDY', '2018-02-20 15:03:16');
INSERT INTO `sy_wkf_schedule` VALUES ('cdcb15ffe19b4c20a961114f930a7c65', '5ae62adaee424605bb4698d765bf395f', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'RDY', '2018-02-20 15:03:13');
INSERT INTO `sy_wkf_schedule` VALUES ('d5ceaa47dd2b49218919713d853bd6f8', '8a4c31fc20904f00a6a3299d467d0a92', '14d63db4291b4170b0bc82e2717021d7', '用户管理-审批2', '15b3cdcc16ee4460b52d17cead3da833', 'cc', 'e8f06af891774dfc9aea03fd60bbc7cb', '用户管理-终审', '10bfa7ec1ec84360b27d9c5566b42628', null, null, null, 'N', null, null, 'FIN', '2018-02-19 17:22:45');
INSERT INTO `sy_wkf_schedule` VALUES ('dcf7dea8ac1d4ed18c9a5b09e3004b9d', '446381f6d5564102b459163f58de7d77', null, null, null, null, 'd8cf2046b7d544b1bb7bf21fbeccdd03', '用户管理-审批1', 'b88422f50c8540998dc9228cf4c9db10', null, null, null, 'N', null, null, 'CLS', '2018-02-19 17:13:44');

-- ----------------------------
-- Table structure for `sy_wkf_worker`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_worker`;
CREATE TABLE `sy_wkf_worker` (
  `SWO_WG_ID` varchar(36) NOT NULL COMMENT '工作组编号',
  `SWO_USER_ID` varchar(36) NOT NULL COMMENT '用户号',
  `SWO_LOGIN_NAME` varchar(60) NOT NULL COMMENT '登录名',
  `SWO_USER_STATUS` char(1) NOT NULL COMMENT '用户状态',
  PRIMARY KEY  (`SWO_WG_ID`,`SWO_USER_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_worker
-- ----------------------------
INSERT INTO `sy_wkf_worker` VALUES ('10bfa7ec1ec84360b27d9c5566b42628', '34d99e0732884f6688e471e71af93c68', 'dd', 'A');
INSERT INTO `sy_wkf_worker` VALUES ('b88422f50c8540998dc9228cf4c9db10', 'b0e403ba11034368b18bd5cc7bc86966', 'bb', 'A');
INSERT INTO `sy_wkf_worker` VALUES ('b88422f50c8540998dc9228cf4c9db10', 'cb8b43344fcc47a5bf3187a0b2b2fae9', 'testb', 'A');
INSERT INTO `sy_wkf_worker` VALUES ('f66b18e1abe74245ad9c25a0ed065ad2', '15b3cdcc16ee4460b52d17cead3da833', 'cc', 'A');

-- ----------------------------
-- Table structure for `sy_wkf_workgroup`
-- ----------------------------
DROP TABLE IF EXISTS `sy_wkf_workgroup`;
CREATE TABLE `sy_wkf_workgroup` (
  `SWW_WG_ID` varchar(36) NOT NULL COMMENT '工作组编号',
  `SWW_WG_NAME` varchar(60) default NULL COMMENT '工作组名称',
  `SWW_WG_TYPE` char(2) NOT NULL COMMENT '工作组类型',
  `SWW_WKF_TYPE` char(2) default NULL COMMENT '流程模型',
  `SWW_WKF_CODE` char(4) default NULL COMMENT '流程代号',
  `SWW_ENTITY_ID` varchar(36) default NULL COMMENT '流程实例编号',
  `SWW_BUS_TYPE` varchar(10) default NULL COMMENT '关联业务类型',
  `SWW_WG_STATUS` char(1) NOT NULL COMMENT '工作组状态',
  PRIMARY KEY  (`SWW_WG_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of sy_wkf_workgroup
-- ----------------------------
INSERT INTO `sy_wkf_workgroup` VALUES ('10bfa7ec1ec84360b27d9c5566b42628', '用户管理-终审', 'W4', '', '', '', 'SYUSR', 'A');
INSERT INTO `sy_wkf_workgroup` VALUES ('b88422f50c8540998dc9228cf4c9db10', '用户管理-审批1', 'W4', '', '', '', 'SYUSR', 'A');
INSERT INTO `sy_wkf_workgroup` VALUES ('f66b18e1abe74245ad9c25a0ed065ad2', '用户管理-审批2', 'W4', '', '', '', 'SYUSR', 'A');
