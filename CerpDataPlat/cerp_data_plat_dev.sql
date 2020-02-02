/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50726
Source Host           : localhost:3306
Source Database       : cerp_data_plat_dev

Target Server Type    : MYSQL
Target Server Version : 50726
File Encoding         : 65001

Date: 2020-02-02 22:58:52
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for permission_t
-- ----------------------------
DROP TABLE IF EXISTS `permission_t`;
CREATE TABLE `permission_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  `icon` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of permission_t
-- ----------------------------
INSERT INTO `permission_t` VALUES ('1', '系统菜单', '0', null, 'glyphicon glyphicon-list');
INSERT INTO `permission_t` VALUES ('2', '权限管理', '1', null, 'glyphicon glyphicon-briefcase');
INSERT INTO `permission_t` VALUES ('3', '业务管理', '1', null, 'glyphicon glyphicon-th-large');
INSERT INTO `permission_t` VALUES ('4', '用户维护', '2', null, 'glyphicon glyphicon-user');
INSERT INTO `permission_t` VALUES ('5', '角色维护', '2', null, 'glyphicon glyphicon-king');
INSERT INTO `permission_t` VALUES ('6', '许可维护', '2', null, 'glyphicon glyphicon-lock');
INSERT INTO `permission_t` VALUES ('7', '定时任务管理', '3', null, 'glyphicon glyphicon-time');

-- ----------------------------
-- Table structure for qrtz_blob_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_blob_triggers`;
CREATE TABLE `qrtz_blob_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(80) NOT NULL,
  `trigger_group` varchar(80) NOT NULL,
  `blob_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_blob_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_blob_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_calendars
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_calendars`;
CREATE TABLE `qrtz_calendars` (
  `sched_name` varchar(120) NOT NULL,
  `calendar_name` varchar(80) NOT NULL,
  `calendar` blob NOT NULL,
  PRIMARY KEY (`calendar_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_calendars
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_cron_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_cron_triggers`;
CREATE TABLE `qrtz_cron_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(80) NOT NULL,
  `trigger_group` varchar(80) NOT NULL,
  `cron_expression` varchar(120) NOT NULL,
  `time_zone_id` varchar(80) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_cron_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_cron_triggers
-- ----------------------------
INSERT INTO `qrtz_cron_triggers` VALUES ('quartzScheduler', 'trigger1', 'triggergroup1', '0/10 * * * * ?', 'Asia/Shanghai');

-- ----------------------------
-- Table structure for qrtz_fired_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_fired_triggers`;
CREATE TABLE `qrtz_fired_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `entry_id` varchar(95) NOT NULL,
  `trigger_name` varchar(80) NOT NULL,
  `trigger_group` varchar(80) NOT NULL,
  `instance_name` varchar(80) NOT NULL,
  `fired_time` bigint(20) NOT NULL,
  `sched_time` bigint(20) NOT NULL,
  `priority` int(11) NOT NULL,
  `state` varchar(16) NOT NULL,
  `job_name` varchar(80) DEFAULT NULL,
  `job_group` varchar(80) DEFAULT NULL,
  `is_nonconcurrent` int(11) DEFAULT NULL,
  `requests_recovery` int(11) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`entry_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_fired_triggers
-- ----------------------------
INSERT INTO `qrtz_fired_triggers` VALUES ('dufy_test', 'NON_CLUSTERED1487230171387', 'trigger1', 'group1', 'NON_CLUSTERED', '1487230212028', '1487230214000', '5', 'ACQUIRED', null, null, '0', '0');

-- ----------------------------
-- Table structure for qrtz_job_details
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_job_details`;
CREATE TABLE `qrtz_job_details` (
  `sched_name` varchar(120) NOT NULL,
  `job_name` varchar(80) NOT NULL,
  `job_group` varchar(80) NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  `job_class_name` varchar(128) NOT NULL,
  `is_durable` int(11) NOT NULL,
  `is_nonconcurrent` int(11) NOT NULL,
  `is_update_data` int(11) NOT NULL,
  `requests_recovery` int(11) NOT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`job_name`,`job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_job_details
-- ----------------------------
INSERT INTO `qrtz_job_details` VALUES ('quartzScheduler', 'job1', 'jobgroup1', null, 'org.ssm.dufy.job.HelloWorldJob', '0', '0', '0', '0', 0x230D0A23576564204465632031312031303A34363A32302043535420323031390D0A);

-- ----------------------------
-- Table structure for qrtz_locks
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_locks`;
CREATE TABLE `qrtz_locks` (
  `sched_name` varchar(120) NOT NULL,
  `lock_name` varchar(40) NOT NULL,
  PRIMARY KEY (`sched_name`,`lock_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_locks
-- ----------------------------
INSERT INTO `qrtz_locks` VALUES ('dufy_test', 'TRIGGER_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('quartzScheduler', 'TRIGGER_ACCESS');
INSERT INTO `qrtz_locks` VALUES ('scheduler', 'TRIGGER_ACCESS');

-- ----------------------------
-- Table structure for qrtz_paused_trigger_grps
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_paused_trigger_grps`;
CREATE TABLE `qrtz_paused_trigger_grps` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_group` varchar(80) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_paused_trigger_grps
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_scheduler_state
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_scheduler_state`;
CREATE TABLE `qrtz_scheduler_state` (
  `sched_name` varchar(120) NOT NULL,
  `instance_name` varchar(80) NOT NULL,
  `last_checkin_time` bigint(20) NOT NULL,
  `checkin_interval` bigint(20) NOT NULL,
  PRIMARY KEY (`sched_name`,`instance_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_scheduler_state
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simple_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simple_triggers`;
CREATE TABLE `qrtz_simple_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(80) NOT NULL,
  `trigger_group` varchar(80) NOT NULL,
  `repeat_count` bigint(20) NOT NULL,
  `repeat_interval` bigint(20) NOT NULL,
  `times_triggered` bigint(20) NOT NULL,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  CONSTRAINT `qrtz_simple_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `trigger_name`, `trigger_group`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simple_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_simprop_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_simprop_triggers`;
CREATE TABLE `qrtz_simprop_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `TRIGGER_NAME` varchar(200) NOT NULL,
  `TRIGGER_GROUP` varchar(200) NOT NULL,
  `STR_PROP_1` varchar(512) DEFAULT NULL,
  `STR_PROP_2` varchar(512) DEFAULT NULL,
  `STR_PROP_3` varchar(512) DEFAULT NULL,
  `INT_PROP_1` int(11) DEFAULT NULL,
  `INT_PROP_2` int(11) DEFAULT NULL,
  `LONG_PROP_1` bigint(20) DEFAULT NULL,
  `LONG_PROP_2` bigint(20) DEFAULT NULL,
  `DEC_PROP_1` decimal(13,4) DEFAULT NULL,
  `DEC_PROP_2` decimal(13,4) DEFAULT NULL,
  `BOOL_PROP_1` varchar(1) DEFAULT NULL,
  `BOOL_PROP_2` varchar(1) DEFAULT NULL,
  PRIMARY KEY (`sched_name`,`TRIGGER_NAME`,`TRIGGER_GROUP`),
  CONSTRAINT `qrtz_simprop_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `TRIGGER_NAME`, `TRIGGER_GROUP`) REFERENCES `qrtz_triggers` (`sched_name`, `trigger_name`, `trigger_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_simprop_triggers
-- ----------------------------

-- ----------------------------
-- Table structure for qrtz_triggers
-- ----------------------------
DROP TABLE IF EXISTS `qrtz_triggers`;
CREATE TABLE `qrtz_triggers` (
  `sched_name` varchar(120) NOT NULL,
  `trigger_name` varchar(80) NOT NULL,
  `trigger_group` varchar(80) NOT NULL,
  `job_name` varchar(80) NOT NULL,
  `job_group` varchar(80) NOT NULL,
  `description` varchar(120) DEFAULT NULL,
  `next_fire_time` bigint(20) DEFAULT NULL,
  `prev_fire_time` bigint(20) DEFAULT NULL,
  `priority` int(11) DEFAULT NULL,
  `trigger_state` varchar(16) NOT NULL,
  `trigger_type` varchar(8) NOT NULL,
  `start_time` bigint(20) NOT NULL,
  `end_time` bigint(20) DEFAULT NULL,
  `calendar_name` varchar(80) DEFAULT NULL,
  `misfire_instr` smallint(6) DEFAULT NULL,
  `job_data` blob,
  PRIMARY KEY (`sched_name`,`trigger_name`,`trigger_group`),
  KEY `sched_name` (`sched_name`,`job_name`,`job_group`),
  CONSTRAINT `qrtz_triggers_ibfk_1` FOREIGN KEY (`sched_name`, `job_name`, `job_group`) REFERENCES `qrtz_job_details` (`sched_name`, `job_name`, `job_group`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of qrtz_triggers
-- ----------------------------
INSERT INTO `qrtz_triggers` VALUES ('quartzScheduler', 'trigger1', 'triggergroup1', 'job1', 'jobgroup1', null, '1578472540000', '1578472530000', '5', 'PAUSED', 'CRON', '1576032380000', '0', null, '0', '');

-- ----------------------------
-- Table structure for role_permission_t
-- ----------------------------
DROP TABLE IF EXISTS `role_permission_t`;
CREATE TABLE `role_permission_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `roleid` int(11) DEFAULT NULL,
  `permissionid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role_permission_t
-- ----------------------------
INSERT INTO `role_permission_t` VALUES ('1', '4', '1');
INSERT INTO `role_permission_t` VALUES ('2', '4', '2');
INSERT INTO `role_permission_t` VALUES ('3', '4', '4');
INSERT INTO `role_permission_t` VALUES ('4', '4', '5');
INSERT INTO `role_permission_t` VALUES ('5', '4', '6');

-- ----------------------------
-- Table structure for role_t
-- ----------------------------
DROP TABLE IF EXISTS `role_t`;
CREATE TABLE `role_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `comment` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of role_t
-- ----------------------------
INSERT INTO `role_t` VALUES ('1', '系统管理员', null);
INSERT INTO `role_t` VALUES ('2', '辽连锁管理员', '管理积分商城接口');
INSERT INTO `role_t` VALUES ('3', '东莞天士力', '东莞药事平台');
INSERT INTO `role_t` VALUES ('4', '陕西华氏', '华氏医院接口1');

-- ----------------------------
-- Table structure for user_role_t
-- ----------------------------
DROP TABLE IF EXISTS `user_role_t`;
CREATE TABLE `user_role_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `userid` int(11) DEFAULT NULL,
  `roleid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_user_t_id` (`userid`),
  KEY `fk_role_t_id` (`roleid`),
  CONSTRAINT `fk_role_t_id` FOREIGN KEY (`roleid`) REFERENCES `role_t` (`id`),
  CONSTRAINT `fk_user_t_id` FOREIGN KEY (`userid`) REFERENCES `user_t` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of user_role_t
-- ----------------------------
INSERT INTO `user_role_t` VALUES ('4', '5', '1');
INSERT INTO `user_role_t` VALUES ('7', '4', '4');
INSERT INTO `user_role_t` VALUES ('8', '3', '3');

-- ----------------------------
-- Table structure for user_t
-- ----------------------------
DROP TABLE IF EXISTS `user_t`;
CREATE TABLE `user_t` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(255) NOT NULL,
  `entryid` int(4) NOT NULL,
  `opers` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `uk_user_t_1` (`user_name`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_t
-- ----------------------------
INSERT INTO `user_t` VALUES ('1', 'admin', '1234567', '2', 'getgoods_lnjfsc,getstock_lnjfsc,getinsider_lnjfsc,getpointpolicy_lnjfsc,createprimiumorder_lnjfsc');
INSERT INTO `user_t` VALUES ('2', 'dgys', '123456', '343', 'getsainvoinfo_dgys,getsuinvoinfo_dgys');
INSERT INTO `user_t` VALUES ('3', 'sxhs', '123456', '3', 'getsalesinfo_sxhs,createapplyorder_sxhs');
INSERT INTO `user_t` VALUES ('4', 'test1', '123', '1', 'getuser12');
INSERT INTO `user_t` VALUES ('5', 'test', '1', '1', '1');
