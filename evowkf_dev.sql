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
-- CREATE TIME:2018-07-04 19:12:22.113
-- TABLE NAME:系统预定义表
DROP TABLE IF EXISTS SY_GLOBAL_DEFINE;
CREATE TABLE SY_GLOBAL_DEFINE (
  SGD_FIELD varchar(60) BINARY NOT NULL COMMENT '字段定义',
  SGD_VALUE varchar(60) BINARY NOT NULL COMMENT '字段值',
  SGD_DSP varchar(256) BINARY  NULL COMMENT '注释'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_GLOBAL_DEFINE ADD PRIMARY KEY(SGD_FIELD,SGD_VALUE);

-- CREATE TIME:2018-07-04 19:12:22.500
-- TABLE NAME:用户信息表
DROP TABLE IF EXISTS SY_USER_INFO;
CREATE TABLE SY_USER_INFO (
  SUI_USER_CID varchar(10) BINARY NOT NULL COMMENT '用户号',
  SUI_LOGIN_NAME varchar(60) BINARY NOT NULL COMMENT '登录名',
  SUI_TYPE char(2) BINARY NOT NULL COMMENT '用户类型',
  SUI_PHONE varchar(20) BINARY  NULL COMMENT '手机',
  SUI_MAIL varchar(100) BINARY  NULL COMMENT '邮箱',
  SUI_PWD varchar(100) BINARY NOT NULL COMMENT '密码',
  SUI_SALT varchar(100) BINARY NOT NULL COMMENT '旧盐',
  SUI_NEW_SALT varchar(100) BINARY NOT NULL COMMENT '新盐',
  SUI_HASH_TIMES int NOT NULL COMMENT 'N值',
  SUI_FACE varchar(100) BINARY  NULL COMMENT '头像',
  SUI_STATE char(1) BINARY NOT NULL COMMENT '状态',
  SUI_ERROR_TIMES int NOT NULL COMMENT '密码错误次数',
  SUI_REGISTER_TIME timestamp NOT NULL COMMENT '注册时间',
  SUI_HAS_KEY char(1) BINARY NOT NULL COMMENT '是否证书卡用户',
  SUI_KEY_UID varchar(36) BINARY  NULL COMMENT '证书卡号',
  SUI_STAFF_CID char(4) BINARY  NULL COMMENT '员工编号'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_USER_INFO ADD PRIMARY KEY(SUI_USER_CID);

-- CREATE TIME:2018-07-04 19:12:22.507
-- TABLE NAME:用户信息交易表
DROP TABLE IF EXISTS SY_USER_TRADE;
CREATE TABLE SY_USER_TRADE (
  SUT_TRADE_UID varchar(36) BINARY NOT NULL COMMENT '交易编号',
  SUT_TRADE_TYPE varchar(10) BINARY NOT NULL COMMENT '交易类型',
  SUT_TRADE_TIME timestamp NOT NULL COMMENT '交易时间',
  SUT_OPR_USER_CID varchar(10) BINARY NOT NULL COMMENT '经办人用户号',
  SUT_OPR_NAME varchar(60) BINARY NOT NULL COMMENT '经办人姓名',
  SUT_LOGIN_NAME varchar(60) BINARY NOT NULL COMMENT '登录名',
  SUT_PHONE varchar(20) BINARY  NULL COMMENT '手机',
  SUT_MAIL varchar(100) BINARY  NULL COMMENT '邮箱',
  SUT_FACE varchar(100) BINARY  NULL COMMENT '头像',
  SUT_WKF_NBR varchar(16) BINARY  NULL COMMENT '工作流流水号',
  SUT_HAS_KEY char(1) BINARY  NULL COMMENT '是否证书卡用户',
  SUT_KEY_UID varchar(36) BINARY  NULL COMMENT '证书卡号',
  SUT_STAFF_CID char(4) BINARY  NULL COMMENT '员工编号',
  SUT_STATE char(1) BINARY NOT NULL COMMENT '交易状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_USER_TRADE ADD PRIMARY KEY(SUT_TRADE_UID);

-- CREATE TIME:2018-07-04 19:12:22.517
-- TABLE NAME:登录日志
DROP TABLE IF EXISTS SY_LOGIN_LOG;
CREATE TABLE SY_LOGIN_LOG (
  SLL_LOG_UID varchar(36) BINARY NOT NULL COMMENT '登录ID',
  SLL_USER_CID varchar(10) BINARY NOT NULL COMMENT '用户号',
  SLL_TIME timestamp NOT NULL COMMENT '登录时间',
  SLL_IP varchar(46) BINARY  NULL COMMENT '登录IP'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_LOGIN_LOG ADD PRIMARY KEY(SLL_LOG_UID);

-- CREATE TIME:2018-07-04 19:12:22.521
-- TABLE NAME:角色表
DROP TABLE IF EXISTS SY_ROLE;
CREATE TABLE SY_ROLE (
  SRO_ROLE_CODE char(6) BINARY NOT NULL COMMENT '角色编码',
  SRO_NAME varchar(60) BINARY NOT NULL COMMENT '角色名称',
  SRO_STATE char(1) BINARY NOT NULL COMMENT '状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_ROLE ADD PRIMARY KEY(SRO_ROLE_CODE);

-- CREATE TIME:2018-07-04 19:12:22.524
-- TABLE NAME:角色组表
DROP TABLE IF EXISTS SY_ROLE_GROUP;
CREATE TABLE SY_ROLE_GROUP (
  SRG_GROUP_CODE char(6) BINARY NOT NULL COMMENT '角色组编码',
  SRG_NAME varchar(60) BINARY NOT NULL COMMENT '角色组名称',
  SRG_STATE char(1) BINARY NOT NULL COMMENT '状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_ROLE_GROUP ADD PRIMARY KEY(SRG_GROUP_CODE);

-- CREATE TIME:2018-07-04 19:12:22.527
-- TABLE NAME:用户角色关联表
DROP TABLE IF EXISTS SY_USER_ROLE;
CREATE TABLE SY_USER_ROLE (
  SUR_USER_CID varchar(10) BINARY NOT NULL COMMENT '用户号',
  SUR_ROLE_CODE char(6) BINARY NOT NULL COMMENT '角色编码',
  SUR_CMT varchar(512) BINARY  NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_USER_ROLE ADD PRIMARY KEY(SUR_USER_CID,SUR_ROLE_CODE);

-- CREATE TIME:2018-07-04 19:12:22.530
-- TABLE NAME:角色角色组关联表
DROP TABLE IF EXISTS SY_ROLE_ROLE_GROUP;
CREATE TABLE SY_ROLE_ROLE_GROUP (
  SRR_ROLE_CODE char(6) BINARY NOT NULL COMMENT '角色编码',
  SRR_GROUP_CODE char(6) BINARY NOT NULL COMMENT '角色组编码',
  SRR_CMT varchar(512) BINARY  NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_ROLE_ROLE_GROUP ADD PRIMARY KEY(SRR_ROLE_CODE,SRR_GROUP_CODE);

-- CREATE TIME:2018-07-04 19:12:22.533
-- TABLE NAME:菜单表
DROP TABLE IF EXISTS SY_MENU;
CREATE TABLE SY_MENU (
  SME_MENU_CODE char(8) BINARY NOT NULL COMMENT '菜单编码',
  SME_TITLE varchar(60) BINARY NOT NULL COMMENT '菜单名称',
  SME_FAT_MENU char(8) BINARY  NULL COMMENT '上级菜单',
  SME_ROOT_MENU char(8) BINARY NOT NULL COMMENT '根菜单',
  SME_DEEP int NOT NULL COMMENT '深度',
  SME_SEQ int NOT NULL COMMENT '序号',
  SME_INDEX varchar(100) BINARY NULL COMMENT '视图url',
  SME_STATE char(1) BINARY NOT NULL COMMENT '状态',
  SME_ICON varchar(100) BINARY  NULL COMMENT '图标'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_MENU ADD PRIMARY KEY(SME_MENU_CODE);

-- CREATE TIME:2018-07-04 19:12:22.536
-- TABLE NAME:请求定义表
DROP TABLE IF EXISTS SY_REQ_DEF;
CREATE TABLE SY_REQ_DEF (
  SRD_REQ_URL varchar(60) BINARY NOT NULL COMMENT '请求URL',
  SRD_NAME varchar(60) BINARY NOT NULL COMMENT '请求名称',
  SRD_DBPOOL_TYPE char(2) BINARY NOT NULL COMMENT '数据库连接池类型',
  SRD_DBPOOL_CODE varchar(20) BINARY  NULL COMMENT '数据库连接池代码',
  SRD_MSG_TYPE char(1) BINARY NOT NULL COMMENT '报文格式',
  SRD_SIGN_FLAG char(1) BINARY NOT NULL COMMENT '验签标志',
  SRD_ENCRYPT char(1) BINARY NOT NULL COMMENT '是否通信加密',
  SRD_CHANNEL char(1) BINARY NOT NULL COMMENT '渠道',
  SRD_STATE char(1) BINARY NOT NULL COMMENT '状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_REQ_DEF ADD PRIMARY KEY(SRD_REQ_URL);

-- CREATE TIME:2018-07-04 19:12:22.539
-- TABLE NAME:权限定义表
DROP TABLE IF EXISTS SY_AUT_DEF;
CREATE TABLE SY_AUT_DEF (
  SAD_AUT_CODE char(8) BINARY NOT NULL COMMENT '权限编码',
  SAD_TYPE char(1) BINARY NOT NULL COMMENT '权限类型',
  SAD_NAME varchar(60) BINARY NOT NULL COMMENT '权限名称',
  SAD_STATE char(1) BINARY NOT NULL COMMENT '状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_AUT_DEF ADD PRIMARY KEY(SAD_AUT_CODE);

-- CREATE TIME:2018-07-04 19:12:22.543
-- TABLE NAME:菜单权限关联表
DROP TABLE IF EXISTS SY_MENU_AUT;
CREATE TABLE SY_MENU_AUT (
  SMA_MENU_CODE char(8) BINARY NOT NULL COMMENT '菜单编码',
  SMA_AUT_CODE char(8) BINARY NOT NULL COMMENT '权限编码',
  SMA_CMT varchar(512) BINARY  NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_MENU_AUT ADD PRIMARY KEY(SMA_MENU_CODE,SMA_AUT_CODE);

-- CREATE TIME:2018-07-04 19:12:22.547
-- TABLE NAME:请求权限关联表
DROP TABLE IF EXISTS SY_REQ_AUT;
CREATE TABLE SY_REQ_AUT (
  SRA_REQ_URL varchar(60) BINARY NOT NULL COMMENT '请求URL',
  SRA_AUT_CODE char(8) BINARY NOT NULL COMMENT '权限编码',
  SRA_CMT varchar(512) BINARY  NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_REQ_AUT ADD PRIMARY KEY(SRA_REQ_URL,SRA_AUT_CODE);

-- CREATE TIME:2018-07-04 19:12:22.551
-- TABLE NAME:角色组权限关联表
DROP TABLE IF EXISTS SY_ROLE_GROUP_AUT;
CREATE TABLE SY_ROLE_GROUP_AUT (
  SGA_GROUP_CODE char(6) BINARY NOT NULL COMMENT '角色组编码',
  SGA_AUT_CODE char(8) BINARY NOT NULL COMMENT '权限编码',
  SGA_CMT varchar(512) BINARY  NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_ROLE_GROUP_AUT ADD PRIMARY KEY(SGA_GROUP_CODE,SGA_AUT_CODE);

-- CREATE TIME:2018-07-04 19:12:22.554
-- TABLE NAME:角色权限关联表
DROP TABLE IF EXISTS SY_ROLE_AUT;
CREATE TABLE SY_ROLE_AUT (
  SRA_ROLE_CODE char(6) BINARY NOT NULL COMMENT '角色编码',
  SRA_AUT_CODE char(8) BINARY NOT NULL COMMENT '权限编码',
  SRA_CMT varchar(512) BINARY  NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_ROLE_AUT ADD PRIMARY KEY(SRA_ROLE_CODE,SRA_AUT_CODE);

-- CREATE TIME:2018-07-04 19:12:22.557
-- TABLE NAME:用户权限关联表
DROP TABLE IF EXISTS SY_USER_AUT;
CREATE TABLE SY_USER_AUT (
  SUA_USER_CID varchar(10) BINARY NOT NULL COMMENT '用户号',
  SUA_AUT_CODE char(8) BINARY NOT NULL COMMENT '权限编码',
  SUA_CMT varchar(512) BINARY  NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_USER_AUT ADD PRIMARY KEY(SUA_USER_CID,SUA_AUT_CODE);

-- CREATE TIME:2018-07-04 19:12:22.561
-- TABLE NAME:数据类型定义表
DROP TABLE IF EXISTS SY_DATA_DEF;
CREATE TABLE SY_DATA_DEF (
  SDD_DATA_CODE char(6) BINARY NOT NULL COMMENT '数据类型编码',
  SDD_NAME varchar(60) BINARY NOT NULL COMMENT '数据类型名称',
  SDD_FIELD varchar(60) BINARY NOT NULL COMMENT '字段名'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_DATA_DEF ADD PRIMARY KEY(SDD_DATA_CODE);

-- CREATE TIME:2018-07-04 19:12:22.564
-- TABLE NAME:数据值权限控制表
DROP TABLE IF EXISTS SY_DATA_AUT;
CREATE TABLE SY_DATA_AUT (
  SDA_DATA_AUT_UID varchar(36) BINARY NOT NULL COMMENT '数据权限关联ID',
  SDA_DATA_CODE char(6) BINARY NOT NULL COMMENT '数据类型编码',
  SDA_VALUE varchar(36) BINARY NOT NULL COMMENT '数据值',
  SDA_OWNER_TYPE char(2) BINARY NOT NULL COMMENT '授权对象类型',
  SDA_USER_CID varchar(10) BINARY  NULL COMMENT '用户号',
  SDA_ROLE_CODE char(6) BINARY  NULL COMMENT '角色编码',
  SDA_GROUP_CODE char(6) BINARY  NULL COMMENT '角色组编码',
  SDA_CMT varchar(512) BINARY  NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_DATA_AUT ADD PRIMARY KEY(SDA_DATA_AUT_UID);

-- CREATE TIME:2018-07-04 19:12:22.567
-- TABLE NAME:文件信息表
DROP TABLE IF EXISTS SY_FILE_INFO;
CREATE TABLE SY_FILE_INFO (
  DFI_FILE_UID varchar(36) BINARY NOT NULL COMMENT '文件编号',
  DFI_FILE_NAME varchar(256) BINARY NOT NULL COMMENT '文件名',
  DFI_STORE_TYPE char(1) BINARY NOT NULL COMMENT '保存方式',
  DFI_IP varchar(46) BINARY  NULL COMMENT 'IP',
  DFI_PORT int  NULL COMMENT '端口',
  DFI_PATH varchar(100) BINARY  NULL COMMENT '文件路径',
  DFI_SECURITY char(1) BINARY NOT NULL COMMENT '是否加密',
  DFI_STATE char(1) BINARY NOT NULL COMMENT '文件状态',
  DFI_PENDING_USER varchar(10) BINARY NULL COMMENT '锁定人',
  DFI_VERSION long NOT NULL COMMENT '文件版本',
  DFI_CMT varchar(512) BINARY  NULL COMMENT '备注',
  DFI_CREATE_TIME timestamp  NULL COMMENT '创建时间',
  DFI_CREATE_USER varchar(10) BINARY  NULL COMMENT '创建人',
  DFI_UPDATE_TIME timestamp  NULL COMMENT '最近更新时间',
  DFI_UPDATE_USER varchar(10) BINARY  NULL COMMENT '最近更新人'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_FILE_INFO ADD PRIMARY KEY(DFI_FILE_UID);

-- CREATE TIME:2018-07-04 19:12:22.570
-- TABLE NAME:文件权限关联表
DROP TABLE IF EXISTS SY_FILE_AUT;
CREATE TABLE SY_FILE_AUT (
  SFA_FILE_AUT_UID varchar(36) BINARY NOT NULL COMMENT '数据权限关联ID',
  SFA_FILE_UID varchar(36) BINARY NOT NULL COMMENT '文件编号',
  SFA_OWNER_TYPE char(2) BINARY NOT NULL COMMENT '授权对象类型',
  SFA_USER_CID varchar(10) BINARY  NULL COMMENT '用户号',
  SFA_ROLE_CODE char(6) BINARY  NULL COMMENT '角色编码',
  SFA_GROUP_CODE char(6) BINARY  NULL COMMENT '角色组编码',
  SFA_CMT varchar(512) BINARY  NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_FILE_AUT ADD PRIMARY KEY(SFA_FILE_AUT_UID);

-- CREATE TIME:2018-07-04 19:12:22.574
-- TABLE NAME:参数表
DROP TABLE IF EXISTS SY_PARAM;
CREATE TABLE SY_PARAM (
  SPA_PARAM_CODE char(8) BINARY NOT NULL COMMENT '参数编码',
  SPA_VALUE varchar(512) BINARY  NULL COMMENT '参数值',
  SPA_NAME varchar(60)  BINARY NULL COMMENT '参数名称',
  SPA_ROOT_CODE char(8) BINARY NOT NULL COMMENT '根参数',
  SPA_FAT_CODE char(8) BINARY  NULL COMMENT '父参数',
  SPA_DEEP int NOT NULL COMMENT '深度',
  SPA_SEQ int NOT NULL COMMENT '序号',
  SPA_CMT varchar(512) BINARY  NULL COMMENT '备注'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_PARAM ADD PRIMARY KEY(SPA_PARAM_CODE);

-- CREATE TIME:2018-07-04 19:12:22.577
-- TABLE NAME:错误码表
DROP TABLE IF EXISTS SY_ERROR_INFO;
CREATE TABLE SY_ERROR_INFO (
  SEI_ERROR_CODE char(8) BINARY NOT NULL COMMENT '错误码',
  SEI_CHN_MSG varchar(100) BINARY  NULL COMMENT '错误信息-中文',
  SEI_ENG_MSG varchar(100) BINARY  NULL COMMENT '错误信息-英文'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_ERROR_INFO ADD PRIMARY KEY(SEI_ERROR_CODE);

-- CREATE TIME:2018-07-04 19:12:22.580
-- TABLE NAME:计数器表
DROP TABLE IF EXISTS SY_COUNTER;
CREATE TABLE SY_COUNTER (
  SCO_COUNTER_CODE char(8) BINARY NOT NULL COMMENT '计数器编码',
  SCO_NAME varchar(60) BINARY NOT NULL COMMENT '计数器名称',
  SCO_CUR_VALUE varchar(10) BINARY NOT NULL COMMENT '当前值',
  SCO_MIN varchar(10) BINARY NOT NULL COMMENT '起始值',
  SCO_MAX varchar(10) BINARY NOT NULL COMMENT '最大值',
  SCO_STEP varchar(10) BINARY NOT NULL COMMENT '步长',
  SCO_OVER char(1) BINARY NOT NULL COMMENT '溢出控制',
  SCO_RESET_PERIOD char(1) BINARY NOT NULL COMMENT '重置周期',
  SCO_RESET_TIME timestamp  NULL COMMENT '下一重置时间',
  SCO_STATE char(1) BINARY NOT NULL COMMENT '状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_COUNTER ADD PRIMARY KEY(SCO_COUNTER_CODE);

-- CREATE TIME:2018-07-04 19:12:22.584
-- TABLE NAME:待阅通知表
DROP TABLE IF EXISTS SY_NTF_RECORD;
CREATE TABLE SY_NTF_RECORD (
  SNR_NTF_UID varchar(36) BINARY NOT NULL COMMENT '通知ID',
  SNR_TOPIC varchar(60) BINARY  NULL COMMENT '通知主题',
  SNR_CONTENT varchar(1000) BINARY NOT NULL COMMENT '内容',
  SNR_TYPE char(2) BINARY NOT NULL COMMENT '发送类型',
  SNR_SENDER varchar(10) BINARY NOT NULL COMMENT '发件人',
  SNR_SENDER_NAME varchar(60) BINARY  NULL COMMENT '发件人名称',
  SNR_RECEIVER varchar(10) BINARY NOT NULL COMMENT '收件人',
  SNR_RECEIVER_NAME varchar(60) BINARY  NULL COMMENT '收件人名称',
  SNR_SEND_TIME timestamp NOT NULL COMMENT '发送时间',
  SNR_CHECK_TIME timestamp  NULL COMMENT '阅读时间',
  SNR_STATE char(1) BINARY NOT NULL COMMENT '状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_NTF_RECORD ADD PRIMARY KEY(SNR_NTF_UID);

-- CREATE TIME:2018-07-04 19:12:22.588
-- TABLE NAME:通知历史表
DROP TABLE IF EXISTS SY_NTF_RECORD_HIS;
CREATE TABLE SY_NTF_RECORD_HIS (
  SNR_NTF_UID varchar(36) BINARY NOT NULL COMMENT '通知ID',
  SNR_TOPIC varchar(60) BINARY  NULL COMMENT '通知主题',
  SNR_CONTENT varchar(1000) BINARY NOT NULL COMMENT '内容',
  SNR_TYPE char(2) BINARY NOT NULL COMMENT '发送类型',
  SNR_SENDER varchar(10) BINARY NOT NULL COMMENT '发件人',
  SNR_SENDER_NAME varchar(60) BINARY  NULL COMMENT '发件人名称',
  SNR_RECEIVER varchar(10) BINARY NOT NULL COMMENT '收件人',
  SNR_RECEIVER_NAME varchar(60) BINARY  NULL COMMENT '收件人名称',
  SNR_SEND_TIME timestamp NOT NULL COMMENT '发送时间',
  SNR_CHECK_TIME timestamp  NULL COMMENT '阅读时间',
  SNR_STATE char(1) BINARY NOT NULL COMMENT '状态'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_NTF_RECORD_HIS ADD PRIMARY KEY(SNR_NTF_UID);

-- CREATE TIME:2018-07-04 20:32:11.133
-- TABLE NAME:缓存控制表
DROP TABLE IF EXISTS SY_CACHE_CTL;
CREATE TABLE SY_CACHE_CTL (
  SCC_CACHE_CODE varchar(10) BINARY NOT NULL COMMENT '缓存编码',
  SCC_NAME varchar(60) BINARY NOT NULL COMMENT '缓存名称',
  SCC_CLAZZ varchar(100) BINARY  NULL COMMENT '加载类'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE SY_CACHE_CTL ADD PRIMARY KEY(SCC_CACHE_CODE);

-- 用户
delete from SY_USER_INFO;
INSERT INTO SY_USER_INFO VALUES ('0000000001', 'kool', 'SA', '', 'luyuzjut@163.com', '3f62de1ff5c0337e3dcefc465bf2bb35346599f1d6acbba9094207aa9d181221', 'bf769', 'bf769', '3', null, 'A', '0', '2018-07-12 23:35:53', 'Y', '5673fd6e30bd48b5a4fefe90db022300', '9999');
INSERT INTO SY_USER_INFO VALUES ('0000000002', 'admin', 'AD', null, null, '3f35d3a1ec49172acc0a1592c5c2c1f0aa91d10b51c4e34475ab6130ce6c5c1e', '7dc92', '7dc92', '3', null, 'A', '0', '2018-07-04 19:56:46', 'Y', '6859ea50e5c74ebda3467cb6e3f1b099', null);
INSERT INTO SY_USER_INFO VALUES ('0000000003', 'aa', 'UR', null, null, 'fde14267bfdf3f5a0561d8d703e926e03e1059fb05d27a660599606ece3196ef', '6ee9b', '6ee9b', '3', null, 'A', '0', '2018-07-04 19:57:13', 'Y', '47e8ce878764439c94c1e802397c1dc7', null);
INSERT INTO SY_USER_INFO VALUES ('0000000004', 'bb', 'VR', null, null, '3f860f53df8eebc6ec2f5ad1a88a0d204f55cb5ee629f94a646a41b397810303', 'ea7ef', 'ea7ef', '3', null, 'A', '0', '2018-07-04 19:57:13', 'Y', '4bcd8736adf843d6aa045be4de2e504a', null);

-- 缓存
delete from SY_CACHE_CTL;
INSERT INTO SY_CACHE_CTL VALUES ('ERRCOD', '错误码', 'com.kool.system.cache.ErrorCodeLoader');
INSERT INTO SY_CACHE_CTL VALUES ('GLOBAL_DEF', '预定义', 'com.kool.system.cache.GlobalDefineLoader');
INSERT INTO SY_CACHE_CTL VALUES ('MENU', '菜单', 'com.kool.system.cache.MenuLoader');
INSERT INTO SY_CACHE_CTL VALUES ('PARAM', '参数', 'com.kool.system.cache.ParamLoader');
INSERT INTO SY_CACHE_CTL VALUES ('REQ', '请求', 'com.kool.system.cache.ReqLoader');
INSERT INTO SY_CACHE_CTL VALUES ('USER', '用户', 'com.kool.system.cache.UserInfoLoader');
INSERT INTO SY_CACHE_CTL VALUES ('USER_MENU', '用户菜单关系', 'com.kool.system.cache.UserMenuLoader');
INSERT INTO SY_CACHE_CTL VALUES ('USER_REQ', '用户请求关系', 'com.kool.system.cache.UserReqLoader');
INSERT INTO SY_CACHE_CTL VALUES ('AUT', '权限', 'com.kool.system.cache.AutLoader');
INSERT INTO SY_CACHE_CTL VALUES ('ROLE', '角色', 'com.kool.system.cache.RoleLoader');
INSERT INTO SY_CACHE_CTL VALUES ('ROLE_GROUP', '角色组', 'com.kool.system.cache.RoleGroupLoader');

-- 计数器
delete from SY_COUNTER;
INSERT INTO SY_COUNTER VALUES ('99USRCID', '用户号', '0000000004', '0000000000', '9999999999', '1', 'E', 'N', NULL, 'A');

-- 错误码
delete from SY_ERROR_INFO;
INSERT INTO SY_ERROR_INFO VALUES ('SY000001', '登录名不存在或密码错误', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000002', '密码错误次数达到5次，请修改密码！', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000003', '登录名不存在或密码错误', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000004', '密码不一致', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000005', '用户名已经存在', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000006', '加数为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000007', '延时器出错', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000008', '时间格式错误', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000009', '计数器不存在', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000010', '加载菜单异常', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000011', '文件路径为空!', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000012', '文件不存在', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000013', '读文件异常', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000014', '增加菜单出错，菜单信息为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000015', '数据转换错误！', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000016', '修改菜单出错，菜单信息为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000017', '删除菜单出错，菜单信息为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000018', '用户信息为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000019', '用户号为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000020', '用户[%1]不存在', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000021', '用户状态[%1]不允许被解冻', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000022', '用户状态[%1]不允许被冻结', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000023', '密码格式错误', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000024', '授权信息为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000025', '授权信息中缺少用户号', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000026', '权限信息为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000027', '输入信息为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000028', '输入主键为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000029', '角色编码为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000030', '权限[%1]已使用，无法删除，请先取消用户权限关联', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000031', '权限[%1]已使用，无法删除，请先取消角色权限关联', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000032', '权限[%1]已使用，无法删除，请先取消角色组权限关联', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000033', '权限[%1]已使用，无法删除，请先取消菜单权限关联', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000034', '权限[%1]已使用，无法删除，请先取消请求权限关联', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000035', '角色组编码为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000036', '字段[%1]为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000037', '字段[%1]小于最小长度[%2]', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000038', '字段[%1]大于最大长度[%2]', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000039', '字段[%1]小于最小值[%2]', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000040', '字段[%1]大于最大值[%2]', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000041', '参数码已经存在', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000042', '权限码已经存在', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000043', '菜单码已经存在', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000044', '请求URL已经存在', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000045', '角色码已经存在', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000046', '角色组编码已经存在', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000047', '输入为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000048', '权限码为空', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000049', '上传头像失败！', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000050', '角色有关联用户，无法删除', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000051', '角色组有关联的角色，无法删除', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000052', '错误码已经存在', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000053', '权限码已经存在', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000054', '计数器编码已经存在', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000055', '获取请求参数失败', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000056', '加密标志错误', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000057', '请求发起方信息为空，请求不通过', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000058', '请求发起方无请求[%1]的访问权限', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000059', '获取用户信息失败，请刷新缓存后重试', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000060', '获取权限信息失败，请刷新缓存后重试', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000061', '授权[%1]失败，用户类型[%2]无法授权权限类型[%3]的权限', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000062', '系统异常，请联系管理员！异常码：%1', NULL);
INSERT INTO SY_ERROR_INFO VALUES ('SY000063', '用户当前状态[%1]，无法登录，请联系管理员修改用户状态！', NULL);

-- 预定义
delete from SY_GLOBAL_DEFINE;
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SME_STATE', 'A', 'A-正常');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SME_STATE', 'C', 'C-关闭');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SUI_STATE', 'A', 'A-正常');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SUI_STATE', 'C', 'C-关闭');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SUI_STATE', 'E', 'E-异常');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SUI_STATE', 'F', 'F-冻结');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SUI_STATE', 'P', 'P-非工作');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SUI_TYPE', 'SA', 'SA-超级管理员');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SUI_TYPE', 'AD', 'AD-管理员');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SUI_TYPE', 'UR', 'UR-一般用户');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SUI_TYPE', 'VR', 'VR-游客');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SUI_HAS_KEY', 'Y', 'Y-是');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SUI_HAS_KEY', 'N', 'N-否');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_DBPOOL_TYPE', 'RC', 'RC-读实时');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_DBPOOL_TYPE', 'RH', 'RH-读历史');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_DBPOOL_TYPE', 'WC', 'WC-写实时');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_DBPOOL_TYPE', 'WH', 'WH-写历史');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_DBPOOL_TYPE', 'DF', 'DF-默认连接池');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_MSG_TYPE', 'J', 'J-JSON');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_MSG_TYPE', 'X', 'X-XML');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_SIGN_FLAG', 'Y', 'Y-验签');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_SIGN_FLAG', 'N', 'N-不验签');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_ENCRYPT', 'Y', 'Y-是');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_ENCRYPT', 'N', 'N-否');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_CHANNEL', '0', '0-web');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_CHANNEL', '1', '1-桌面客户端');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_CHANNEL', '2', '2-微信公众号');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_CHANNEL', '3', '3-APP');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_CHANNEL', '9', '9-外部');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_STATE', 'A', 'A-正常');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRD_STATE', 'C', 'C-关闭');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SAD_STATE', 'A', 'A-正常');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SAD_STATE', 'C', 'C-关闭');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SCO_OVER', 'E', 'E-溢出报错');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SCO_OVER', 'R', 'R-溢出重置');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SCO_RESET_PERIOD', 'N', 'N-不重置');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SCO_RESET_PERIOD', 'D', 'D-日');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SCO_RESET_PERIOD', 'W', 'W-周');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SCO_RESET_PERIOD', 'M', 'M-月');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SCO_RESET_PERIOD', 'Y', 'Y-年');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SCO_STATE', 'A', 'A-正常');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SCO_STATE', 'C', 'C-关闭');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SCO_STATE', 'E', 'E-溢出报错');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRO_STATE', 'A', 'A-正常');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRO_STATE', 'C', 'C-关闭');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRG_STATE', 'A', 'A-正常');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SRG_STATE', 'C', 'C-关闭');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SAD_TYPE', 'S', 'S-超级管理员权限');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SAD_TYPE', 'A', 'A-管理员权限');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SAD_TYPE', 'B', 'B-普通权限');
INSERT INTO SY_GLOBAL_DEFINE VALUES ('SAD_TYPE', 'C', 'C-游客权限');

-- 权限定义
delete from SY_AUT_DEF;
INSERT INTO SY_AUT_DEF VALUES ('SYBASIC0', 'C', '基本访问权限', 'A');
INSERT INTO SY_AUT_DEF VALUES ('SYUSRMNG', 'A', '用户管理', 'A');
INSERT INTO SY_AUT_DEF VALUES ('SYAUTMNG', 'S', '权限管理', 'A'); 
INSERT INTO SY_AUT_DEF VALUES ('SYMNUMNG', 'S', '菜单管理', 'A');
INSERT INTO SY_AUT_DEF VALUES ('SYREQMNG', 'S', '请求管理', 'A');
INSERT INTO SY_AUT_DEF VALUES ('SYROLMNG', 'A', '角色管理', 'A'); 
INSERT INTO SY_AUT_DEF VALUES ('SYRGPMNG', 'A', '角色组管理', 'A'); 
INSERT INTO SY_AUT_DEF VALUES ('SYPAMMNG', 'S', '参数管理', 'A'); 
INSERT INTO SY_AUT_DEF VALUES ('SYERRMNG', 'S', '错误码管理', 'A'); 
INSERT INTO SY_AUT_DEF VALUES ('SYCNTMNG', 'S', '计数器管理', 'A'); 
INSERT INTO SY_AUT_DEF VALUES ('SYCHEMNG', 'S', '缓存管理', 'A'); 

-- 菜单、菜单权限关联
delete from SY_MENU;
delete from SY_MENU_AUT;
INSERT INTO SY_MENU VALUES ('SY000000', '首页', NULL, 'SY000000', 0, 0, '/home', 'A', 'el-icon-k-home2');
INSERT INTO SY_MENU_AUT VALUES ('SY000000', 'SYBASIC0', '首页-基本访问权限'); 
INSERT INTO SY_MENU VALUES ('SY000001', '平台运维', NULL, 'SY000001', 0, 1, '', 'A', 'el-icon-k-setting');
INSERT INTO SY_MENU_AUT VALUES ('SY000001', 'SYUSRMNG', '平台运维-用户管理'); 
INSERT INTO SY_MENU_AUT VALUES ('SY000001', 'SYAUTMNG', '平台运维-权限管理'); 
INSERT INTO SY_MENU_AUT VALUES ('SY000001', 'SYMNUMNG', '平台运维-菜单管理'); 
INSERT INTO SY_MENU_AUT VALUES ('SY000001', 'SYREQMNG', '平台运维-请求管理'); 
INSERT INTO SY_MENU_AUT VALUES ('SY000001', 'SYROLMNG', '平台运维-角色管理'); 
INSERT INTO SY_MENU_AUT VALUES ('SY000001', 'SYRGPMNG', '平台运维-角色组管理'); 
INSERT INTO SY_MENU_AUT VALUES ('SY000001', 'SYPAMMNG', '平台运维-参数管理'); 
INSERT INTO SY_MENU_AUT VALUES ('SY000001', 'SYERRMNG', '平台运维-错误码管理'); 
INSERT INTO SY_MENU_AUT VALUES ('SY000001', 'SYCHEMNG', '平台运维-缓存管理'); 
INSERT INTO SY_MENU_AUT VALUES ('SY000001', 'SYCNTMNG', '平台运维-计数器管理'); 
INSERT INTO SY_MENU VALUES ('SY000002', '用户管理', 'SY000001', 'SY000001', 1, 0, '/sys-user', 'A', 'el-icon-k-user-setting');
INSERT INTO SY_MENU_AUT VALUES ('SY000002', 'SYUSRMNG', '用户管理-用户管理'); 
INSERT INTO SY_MENU VALUES ('SY000003', '权限管理', 'SY000001', 'SY000001', 1, 1, '/sys-auth', 'A', 'el-icon-k-management');
INSERT INTO SY_MENU_AUT VALUES ('SY000003', 'SYAUTMNG', '权限管理-权限管理'); 
INSERT INTO SY_MENU VALUES ('SY000004', '菜单管理', 'SY000001', 'SY000001', 1, 2, '/sys-menu', 'A', 'el-icon-k-menu');
INSERT INTO SY_MENU_AUT VALUES ('SY000004', 'SYMNUMNG', '菜单管理-菜单管理'); 
INSERT INTO SY_MENU VALUES ('SY000005', '请求管理', 'SY000001', 'SY000001', 1, 3, '/sys-req', 'A', 'el-icon-k-req');
INSERT INTO SY_MENU_AUT VALUES ('SY000005', 'SYREQMNG', '请求管理-请求管理'); 
INSERT INTO SY_MENU VALUES ('SY000006', '角色管理', 'SY000001', 'SY000001', 1, 4, '/sys-role', 'A', 'el-icon-k-role');
INSERT INTO SY_MENU_AUT VALUES ('SY000006', 'SYROLMNG', '角色管理-角色管理'); 
INSERT INTO SY_MENU VALUES ('SY000007', '角色组管理', 'SY000001', 'SY000001', 1, 5, '/sys-group', 'A', 'el-icon-k-group');
INSERT INTO SY_MENU_AUT VALUES ('SY000007', 'SYRGPMNG', '角色组管理-角色组管理'); 
INSERT INTO SY_MENU VALUES ('SY000008', '参数管理', 'SY000001', 'SY000001', 1, 6, '/sys-param', 'A', 'el-icon-k-param');
INSERT INTO SY_MENU_AUT VALUES ('SY000008', 'SYPAMMNG', '参数管理-参数管理'); 
INSERT INTO SY_MENU VALUES ('SY000009', '错误码管理', 'SY000001', 'SY000001', 1, 7, '/sys-errCod', 'A', 'el-icon-k-errCod');
INSERT INTO SY_MENU_AUT VALUES ('SY000009', 'SYERRMNG', '错误码管理-错误码管理'); 
INSERT INTO SY_MENU VALUES ('SY000010', '缓存管理', 'SY000001', 'SY000001', 1, 9, '/sys-cache', 'A', 'el-icon-k-cache');
INSERT INTO SY_MENU_AUT VALUES ('SY000010', 'SYCHEMNG', '缓存管理-缓存管理'); 
INSERT INTO SY_MENU VALUES ('SY000011', '计数器管理', 'SY000001', 'SY000001', 1, 8, '/sys-counter', 'A', 'el-icon-k-counter');
INSERT INTO SY_MENU_AUT VALUES ('SY000011', 'SYCNTMNG', '计数器管理-计数器管理'); 

-- 请求、请求权限关联
delete from SY_REQ_DEF;
delete from SY_REQ_AUT;
INSERT INTO SY_REQ_DEF VALUES ('/refresh', '刷新', 'DF', NULL, 'J', 'N', 'N', '0', 'A');
INSERT INTO SY_REQ_DEF VALUES ('/test', '测试', 'DF', NULL, 'J', 'N', 'N', '0', 'A');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/preLogin', '预登录', 'DF', NULL, 'J', 'N', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/preLogin', 'SYBASIC0', '预登录-基本访问权限');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/login', '登录', 'DF', NULL, 'J', 'N', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/login', 'SYBASIC0', '登录-基本访问权限');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/queryUserMenu', '查询用户有权限的菜单', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/queryUserMenu', 'SYBASIC0', '查询用户有权限的菜单-基本访问权限');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/logout', '安全退出', 'DF', NULL, 'J', 'N', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/logout', 'SYBASIC0', '安全退出-基本访问权限');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/register', '注册', 'DF', NULL, 'J', 'N', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/register', 'SYBASIC0', '注册-基本访问权限');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/resetAut', '用户授权', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/resetAut', 'SYUSRMNG', '用户授权-用户管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/freezeUser', '冻结', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/freezeUser', 'SYUSRMNG', '冻结-用户管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/queryUserAut', '查询用户权限列表', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/queryUserAut', 'SYUSRMNG', '查询用户权限列表-用户管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/queryUserRole', '查询用户角色列表', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/queryUserRole', 'SYUSRMNG', '查询用户角色列表-用户管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/resetPwd', '重置密码', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/resetPwd', 'SYUSRMNG', '重置密码-用户管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/setRole', '赋予角色', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/setRole', 'SYUSRMNG', '赋予角色-用户管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/unfreezeUser', '解冻', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/unfreezeUser', 'SYUSRMNG', '解冻-用户管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/updatePwd', '修改密码', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/updatePwd', 'SYBASIC0', '修改密码-用户管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/uploadFace', '上传头像', 'DF', NULL, 'J', 'N', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/uploadFace', 'SYBASIC0', '上传头像-用户管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/addUser', '增加用户', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/addUser', 'SYUSRMNG', '增加用户-用户管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/queryUserDetail', '查询用户详情', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/queryUserDetail', 'SYBASIC0', '查询用户详情-用户管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/queryUserListPage', '分页查询用户信息列表', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/queryUserListPage', 'SYUSRMNG', '分页查询用户信息列表-用户管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/user/updateUser', '修改用户信息', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/user/updateUser', 'SYUSRMNG', '修改用户信息-用户管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/aut/addAut', '增加权限', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/aut/addAut', 'SYAUTMNG', '增加权限-权限管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/aut/bindMenu', '绑定菜单', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/aut/bindMenu', 'SYAUTMNG', '绑定菜单-权限管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/aut/bindReq', '绑定请求', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/aut/bindReq', 'SYAUTMNG', '绑定请求-权限管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/aut/deleteAut', '删除权限', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/aut/deleteAut', 'SYAUTMNG', '删除权限-权限管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/aut/queryAut', '查询权限', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/aut/queryAut', 'SYAUTMNG', '查询权限-权限管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/aut/queryAutMenu', '查询权限绑定的菜单', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/aut/queryAutMenu', 'SYAUTMNG', '查询权限绑定的菜单-权限管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/aut/queryAutReq', '查询权限绑定的请求', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/aut/queryAutReq', 'SYAUTMNG', '查询权限绑定的请求-权限管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/aut/queryAutListPage', '分页查询权限列表', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/aut/queryAutListPage', 'SYAUTMNG', '分页查询权限列表-权限管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/aut/updateAut', '修改权限信息', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/aut/updateAut', 'SYAUTMNG', '修改权限信息-权限管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/menu/queryMenuTree', '查询菜单树', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/menu/queryMenuTree', 'SYMNUMNG', '查询菜单树-菜单管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/menu/addMenu', '增加菜单', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/menu/addMenu', 'SYMNUMNG', '增加菜单-菜单管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/menu/deleteMenu', '删除菜单', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/menu/deleteMenu', 'SYMNUMNG', '删除菜单-菜单管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/menu/queryMenu', '查询菜单', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/menu/queryMenu', 'SYMNUMNG', '查询菜单-菜单管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/menu/queryMenuListPage', '分页查询菜单列表', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/menu/queryMenuListPage', 'SYMNUMNG', '分页查询菜单列表-菜单管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/menu/updateMenu', '修改菜单', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/menu/updateMenu', 'SYMNUMNG', '修改菜单-菜单管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/req/addReq', '增加请求', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/req/addReq', 'SYREQMNG', '增加请求-请求管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/req/deleteReq', '删除请求', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/req/deleteReq', 'SYREQMNG', '删除请求-请求管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/req/queryReqListPage', '分页查询请求列表', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/req/queryReqListPage', 'SYREQMNG', '分页查询请求列表-请求管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/req/queryReq', '查询请求', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/req/queryReq', 'SYREQMNG', '查询请求-请求管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/req/updateReq', '修改请求信息', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/req/updateReq', 'SYREQMNG', '修改请求信息-请求管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/role/addRole', '增加角色', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/role/addRole', 'SYROLMNG', '增加角色-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/role/updateRole', '修改角色', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/role/updateRole', 'SYROLMNG', '修改角色-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/role/deleteRole', '删除角色', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/role/deleteRole', 'SYROLMNG', '删除角色-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/role/queryRoleListPage', '分页查询角色', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/role/queryRoleListPage', 'SYROLMNG', '分页查询角色-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/role/queryRole', '查询角色', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/role/queryRole', 'SYROLMNG', '查询角色-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/role/joinGroup', '加入角色组', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/role/joinGroup', 'SYROLMNG', '加入角色组-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/role/resetAut', '角色授权', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/role/resetAut', 'SYROLMNG', '角色授权-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/role/queryRoleDetail', '角色详情', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/role/queryRoleDetail', 'SYROLMNG', '角色详情-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/role/queryGroupOfRole', '查询角色所属角色组', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/role/queryGroupOfRole', 'SYROLMNG', '查询角色所属角色组-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/role/queryRoleAut', '查询角色权限', 'DF', NULL, 'J', 'Y', 'N', '0', 'A');
INSERT INTO SY_REQ_AUT VALUES ('/sys/role/queryRoleAut', 'SYROLMNG', '查询角色权限-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/roleGroup/addRoleGroup', '增加角色组', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/roleGroup/addRoleGroup', 'SYRGPMNG', '增加角色组-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/roleGroup/updateRoleGroup', '修改角色组', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/roleGroup/updateRoleGroup', 'SYRGPMNG', '修改角色组-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/roleGroup/deleteRoleGroup', '删除角色组', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/roleGroup/deleteRoleGroup', 'SYRGPMNG', '删除角色组-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/roleGroup/queryRoleGroupListPage', '分页查询角色组', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/roleGroup/queryRoleGroupListPage', 'SYRGPMNG', '分页查询角色组-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/roleGroup/queryRoleGroup', '查询角色组', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/roleGroup/queryRoleGroup', 'SYRGPMNG', '查询角色组-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/roleGroup/resetAut', '角色组授权', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/roleGroup/resetAut', 'SYRGPMNG', '角色组授权-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/roleGroup/queryRoleGroupDetail', '角色组详情', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/roleGroup/queryRoleGroupDetail', 'SYRGPMNG', '角色组详情-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/roleGroup/queryGroupAut', '查询角色组权限', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/roleGroup/queryGroupAut', 'SYRGPMNG', '查询角色组权限-角色管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/param/addParam', '增加参数', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/param/addParam', 'SYPAMMNG', '增加参数-参数管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/param/deleteParam', '删除参数', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/param/deleteParam', 'SYPAMMNG', '删除参数-参数管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/param/queryParamListPage', '分页查询参数', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/param/queryParamListPage', 'SYPAMMNG', '分页查询参数-参数管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/param/queryParam', '查询参数', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/param/queryParam', 'SYPAMMNG', '查询参数-参数管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/param/updateParam', '修改参数', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/param/updateParam', 'SYPAMMNG', '修改参数-参数管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/errorCode/addErrorCode', '增加错误码', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/errorCode/addErrorCode', 'SYERRMNG', '增加错误码-错误码管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/errorCode/deleteErrorCode', '删除错误码', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/errorCode/deleteErrorCode', 'SYERRMNG', '删除错误码-错误码管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/errorCode/queryErrorCodeListPage', '分页查询参数', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/errorCode/queryErrorCodeListPage', 'SYERRMNG', '分页查询错误码-错误码管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/errorCode/queryErrorCode', '查询错误码', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/errorCode/queryErrorCode', 'SYERRMNG', '查询错误码-错误码管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/errorCode/updateErrorCode', '修改错误码', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/errorCode/updateErrorCode', 'SYERRMNG', '修改错误码-错误码管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/counter/addCounter', '增加计数器', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/counter/addCounter', 'SYCNTMNG', '增加计数器-计数器管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/counter/deleteCounter', '删除计数器', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/counter/deleteCounter', 'SYCNTMNG', '删除计数器-计数器管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/counter/queryCounter', '查询计数器', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/counter/queryCounter', 'SYCNTMNG', '查询计数器-计数器管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/counter/queryCounterListPage', '分页查询计数器', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/counter/queryCounterListPage', 'SYCNTMNG', '分页查询计数器-计数器管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/counter/updateCounter', '修改计数器', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/counter/updateCounter', 'SYCNTMNG', '修改计数器-计数器管理');
INSERT INTO SY_REQ_DEF VALUES ('/sys/cache/refresh', '刷新缓存', 'DF', NULL, 'J', 'Y', 'N', '0', 'A'); 
INSERT INTO SY_REQ_AUT VALUES ('/sys/cache/refresh', 'SYCHEMNG', '刷新缓存-缓存管理');

-- 角色
delete from SY_ROLE;
INSERT INTO SY_ROLE VALUES ('SYSAUT', '公共系统审批人', 'A');
INSERT INTO SY_ROLE VALUES ('SYSCHK', '公共系统复核人', 'A');
INSERT INTO SY_ROLE VALUES ('SYSOPR', '公共系统经办人', 'A');

-- 用户权限关联
delete from SY_USER_AUT;
INSERT INTO SY_USER_AUT VALUES ('0000000001', 'SYBASIC0', 'kool-基本访问权限');
INSERT INTO SY_USER_AUT VALUES ('0000000001', 'SYUSRMNG', 'kool-用户管理');
INSERT INTO SY_USER_AUT VALUES ('0000000001', 'SYAUTMNG', 'kool-权限管理');
INSERT INTO SY_USER_AUT VALUES ('0000000001', 'SYMNUMNG', 'kool-菜单管理');
INSERT INTO SY_USER_AUT VALUES ('0000000001', 'SYREQMNG', 'kool-请求管理');
INSERT INTO SY_USER_AUT VALUES ('0000000001', 'SYROLMNG', 'kool-角色管理');
INSERT INTO SY_USER_AUT VALUES ('0000000001', 'SYRGPMNG', 'kool-角色组管理');
INSERT INTO SY_USER_AUT VALUES ('0000000001', 'SYPAMMNG', 'kool-参数管理');
INSERT INTO SY_USER_AUT VALUES ('0000000001', 'SYERRMNG', 'kool-错误码管理');
INSERT INTO SY_USER_AUT VALUES ('0000000001', 'SYCNTMNG', 'kool-计数器管理');
INSERT INTO SY_USER_AUT VALUES ('0000000001', 'SYCHEMNG', 'kool-缓存管理');

INSERT INTO SY_USER_AUT VALUES ('0000000002', 'SYBASIC0', 'admin-基本访问权限');
INSERT INTO SY_USER_AUT VALUES ('0000000003', 'SYBASIC0', 'aa-基本访问权限');
INSERT INTO SY_USER_AUT VALUES ('0000000004', 'SYBASIC0', 'bb-基本访问权限');
