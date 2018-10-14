/*
MySQL Backup
Database: basketball
Backup Time: 2018-10-14 20:50:36
*/

SET FOREIGN_KEY_CHECKS=0;
DROP TABLE IF EXISTS `basketball`.`t_admin`;
DROP TABLE IF EXISTS `basketball`.`t_match`;
DROP TABLE IF EXISTS `basketball`.`t_member`;
DROP TABLE IF EXISTS `basketball`.`t_team`;
CREATE TABLE `t_admin` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `username` varchar(20) NOT NULL COMMENT '管理员用户名',
  `password` varchar(20) NOT NULL COMMENT ' 管理员密码',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `t_match` (
  `MatchTime` varchar(20) NOT NULL COMMENT '比赛时间记录',
  `EventType` int(11) unsigned NOT NULL COMMENT '事件类型0123',
  `memberId` int(11) unsigned NOT NULL COMMENT '球员编号',
  `teamId` int(11) unsigned NOT NULL COMMENT '球队编号',
  `createtime` datetime DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `updatetime` timestamp NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '修改时间'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `t_member` (
  `memberId` int(11) unsigned NOT NULL COMMENT '队员编号，即球衣号',
  `memberName` varchar(20) NOT NULL COMMENT '队员名称',
  `firstStart` tinyint(1) NOT NULL,
  `teamId` int(11) unsigned NOT NULL COMMENT '球队编号',
  PRIMARY KEY (`memberId`),
  KEY `m_fk1` (`teamId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
CREATE TABLE `t_team` (
  `teamId` int(11) unsigned NOT NULL COMMENT '球队编号',
  `teamName` varchar(20) NOT NULL COMMENT '球队名称',
  `teamLoginName` varchar(20) NOT NULL,
  `teamPassword` varchar(20) NOT NULL,
  PRIMARY KEY (`teamId`),
  UNIQUE KEY `teamName` (`teamName`),
  UNIQUE KEY `teamLoginName` (`teamLoginName`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
BEGIN;
LOCK TABLES `basketball`.`t_admin` WRITE;
DELETE FROM `basketball`.`t_admin`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `basketball`.`t_match` WRITE;
DELETE FROM `basketball`.`t_match`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `basketball`.`t_member` WRITE;
DELETE FROM `basketball`.`t_member`;
UNLOCK TABLES;
COMMIT;
BEGIN;
LOCK TABLES `basketball`.`t_team` WRITE;
DELETE FROM `basketball`.`t_team`;
UNLOCK TABLES;
COMMIT;
