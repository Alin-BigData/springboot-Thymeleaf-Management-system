/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50711
Source Host           : localhost:3306
Source Database       : sampling

Target Server Type    : MYSQL
Target Server Version : 50711
File Encoding         : 65001

Date: 2019-02-27 10:31:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `admin`
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userName` varchar(45) NOT NULL,
  `email` varchar(45) DEFAULT NULL,
  `password` varchar(45) NOT NULL,
  `realName` varchar(45) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `phoneNumber` varchar(45) DEFAULT NULL,
  `headPicture` varchar(45) DEFAULT NULL,
  `addDate` date DEFAULT NULL,
  `updateDate` date DEFAULT NULL,
  `state` int(11) DEFAULT '0' COMMENT '1：正常\n2：冻结\n3：删除',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name_UNIQUE` (`userName`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES ('1', '1037377970@qq.com', '1037377970@qq.com', '123456', 'wangfulin', '20', '15759206413', null, '2018-12-20', '2018-12-27', '0');
INSERT INTO `admin` VALUES ('2', 'wangfulin@qq.com', null, '55665566g', null, null, null, null, null, '2018-12-20', '0');
INSERT INTO `admin` VALUES ('4', '103737970@qq.com', '312312@qq.com', '31231', '312312', null, '312312', null, '2018-12-25', null, '0');

-- ----------------------------
-- Table structure for `tb_order`
-- ----------------------------
DROP TABLE IF EXISTS `tb_order`;
CREATE TABLE `tb_order` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `order_id` varchar(50) NOT NULL,
  `user_name` varchar(20) NOT NULL,
  `sex` char(1) NOT NULL,
  `phone_num` varchar(20) NOT NULL,
  `birthday` datetime DEFAULT NULL,
  `email` char(50) DEFAULT NULL,
  `region` char(20) NOT NULL,
  `location` char(100) NOT NULL,
  `paper_status` int(1) DEFAULT '0' COMMENT '0：否\n1：是',
  `project_type` int(1) DEFAULT '0' COMMENT '0：类型0\n1：类型1',
  `pay_status` int(1) DEFAULT NULL COMMENT '0：未支付\n1：已支付',
  `sms_num` char(4) DEFAULT NULL,
  `sms_status` int(1) DEFAULT '0' COMMENT '0：未发送\n1：已发送',
  `sms_time` datetime DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `handle_status` int(1) DEFAULT '0' COMMENT '0：待处理\n1：处理中\n3：已处理\n4:已作废',
  `handle_time` datetime DEFAULT NULL,
  `remarks_msg` varchar(50) DEFAULT NULL,
  `src_address` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=61 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tb_order
-- ----------------------------
INSERT INTO `tb_order` VALUES ('38', '2018122500401946399', 'xiaowng', '男', '13124123124', '2018-12-25 08:00:00', '13313@qq.com', '北京市,北京市,东城区', '4242', '1', '0', '0', null, null, null, '2018-12-25 10:47:21', '0', '2018-12-25 10:47:21', null, null);
INSERT INTO `tb_order` VALUES ('39', '2018122502063204596', 'dalsdal;', '男', '12314235234', '2018-09-25 08:00:00', '321312@qq.com', '天津市,天津市,和平区', '31fs', '1', '2', null, null, null, null, '2018-12-25 10:52:59', null, '2018-12-25 10:52:59', null, null);
INSERT INTO `tb_order` VALUES ('40', '2018122501844551969', 'laowang1', '男', '13333332123', '2018-12-25 08:00:00', '233333333', '北京市,北京市,东城区', '132323', '0', '0', null, null, null, null, '2018-12-25 10:53:58', null, '2018-12-25 10:53:58', null, null);
INSERT INTO `tb_order` VALUES ('41', '2018122500564514074', 'laowang2', '男', '13333332123', '2018-12-25 08:00:00', '233333333', '北京市,北京市,东城区', '132323', '0', '0', null, null, null, null, '2018-12-25 10:54:06', null, '2018-12-25 10:54:06', null, null);
INSERT INTO `tb_order` VALUES ('42', '2018122500392563197', 'laowang2', '男', '13333332111', '2018-12-25 08:00:00', '233333333', '北京市,北京市,东城区', '132323', '0', '0', null, null, null, null, '2018-12-25 10:54:13', null, '2018-12-25 10:54:13', null, null);
INSERT INTO `tb_order` VALUES ('43', '2018122500833222536', 'laowang3', '男', '13333332199', '2018-12-25 08:00:00', '233333333', '北京市,北京市,东城区', '132323', '0', '0', null, null, null, null, '2018-12-25 10:54:30', null, '2018-12-25 10:54:30', null, null);
INSERT INTO `tb_order` VALUES ('44', '2018122501974799726', 'nidanid', '男', '13124423523', '2018-12-25 08:00:00', '312312@qq.com', '天津市,天津市,和平区', '3122z', '1', '1', null, null, null, null, '2018-12-25 10:54:35', null, '2018-12-25 10:54:35', null, null);
INSERT INTO `tb_order` VALUES ('45', '2018122500623033983', 'dsfa', '男', '16678687432', '2018-12-25 08:00:00', 'wefsd@qq.com', '北京市,北京市,东城区', '3123', '1', '0', null, null, null, null, '2018-12-25 10:55:53', null, '2018-12-25 10:55:53', null, null);
INSERT INTO `tb_order` VALUES ('46', '2018122500748261969', 'laowang4', '男', '13333000000', '2018-12-25 08:00:00', '233333333', '北京市,北京市,西城区', '132323', '0', '1', null, null, null, null, '2018-12-25 10:55:59', null, '2018-12-25 10:55:59', null, null);
INSERT INTO `tb_order` VALUES ('47', '2018122500536996960', 'laowang3', '男', '13333011000', '2018-12-25 08:00:00', '233333333', '北京市,北京市,西城区', '132323', '0', '1', null, null, null, null, '2018-12-25 10:56:16', null, '2018-12-25 10:56:16', null, null);
INSERT INTO `tb_order` VALUES ('48', '2018122500931091867', 'laowang6', '男', '13333011023', '2018-12-25 08:00:00', '233333333', '北京市,北京市,西城区', '132323', '0', '1', null, null, null, null, '2018-12-25 10:56:34', null, '2018-12-25 10:56:34', null, null);
INSERT INTO `tb_order` VALUES ('49', '2018122500270932936', '342342', '男', '12323232331', '2018-12-25 08:00:00', '3123ee@qq.com', '北京市,北京市,东城区', '312312', '1', '0', null, null, null, null, '2018-12-25 10:56:40', null, '2018-12-25 10:56:40', null, null);
INSERT INTO `tb_order` VALUES ('50', '2018122500972412996', 'dsfasdfasd', '男', '13546546546', '2018-12-25 08:00:00', 'eqweqwe', '北京市,北京市,东城区', '32312', '1', '0', null, null, null, null, '2018-12-25 10:57:23', null, '2018-12-25 10:57:23', null, null);
INSERT INTO `tb_order` VALUES ('51', '2018122500270932936', '342342', '男', '12323232331', null, null, '北京市,北京市,东城区', '312312', null, null, null, null, null, null, null, null, '2018-12-25 11:17:49', null, null);
INSERT INTO `tb_order` VALUES ('52', '2018122500270932936', '342342', '男', '12323232331', null, null, '北京市,北京市,东城区', '312312', null, null, null, null, null, null, null, null, '2018-12-25 11:17:59', null, null);
INSERT INTO `tb_order` VALUES ('53', '2018122500270932936', '342342', '男', '12323232331', null, null, '北京市,北京市,东城区', '312312', null, null, null, null, null, null, null, null, '2018-12-25 11:25:08', null, null);
INSERT INTO `tb_order` VALUES ('54', '2018122501631253926', 'liao', '男', '12322323232', '2015-11-25 08:00:00', '44444444444', '北京市,北京市,东城区', '213123123', '0', '0', null, null, null, null, '2018-12-25 12:47:40', null, '2018-12-25 12:47:40', null, null);
INSERT INTO `tb_order` VALUES ('55', '2018122501409906601', 'liao', '男', '12322323232', '2015-11-25 08:00:00', '44444444444', '北京市,北京市,东城区', '213123123', '0', '0', null, null, null, null, '2018-12-25 12:48:18', null, '2018-12-25 12:48:18', null, null);
INSERT INTO `tb_order` VALUES ('56', '2018122500095574816', '王总', '男', '13232434555', '2018-12-25 08:00:00', '4444444444444444', '北京市,北京市,东城区', '1232332', '0', '1', null, null, null, null, '2018-12-25 15:27:01', null, '2018-12-25 15:27:01', null, null);
INSERT INTO `tb_order` VALUES ('57', '2018122500002970774', '王总', '男', '13232434555', '2018-12-25 08:00:00', '4444444444444444', '北京市,北京市,东城区', '1232332', '0', '1', null, null, null, null, '2018-12-25 15:27:31', null, '2018-12-25 15:27:31', null, null);
INSERT INTO `tb_order` VALUES ('58', '2018122500108146016', '王总', '男', '13232434555', '2018-12-25 08:00:00', '4444444444444444', '北京市,北京市,东城区', '1232332', '0', '1', null, null, null, null, '2018-12-25 15:28:13', null, '2018-12-25 15:28:13', null, null);
INSERT INTO `tb_order` VALUES ('59', '2018122500129538232', '王总', '男', '13232434555', '2018-12-25 08:00:00', '4444444444444444', '北京市,北京市,东城区', '1232332', '0', '1', null, null, null, null, '2018-12-25 15:28:19', null, '2018-12-25 15:28:19', null, null);
INSERT INTO `tb_order` VALUES ('60', '2018122500871182564', 'EQWEQ', '男', '13241242344', '2018-12-25 08:00:00', '31321', '北京市,北京市,东城区', '31231', '1', '0', null, null, null, null, '2018-12-25 15:33:18', null, '2018-12-25 15:33:18', null, null);
