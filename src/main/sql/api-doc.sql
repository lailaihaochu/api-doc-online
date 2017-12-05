-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        10.2.8-MariaDB - mariadb.org binary distribution
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- 导出 demo 的数据库结构
CREATE DATABASE IF NOT EXISTS `api-doc` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `demo`;

-- 导出  表 demo.api_cotent 结构
CREATE TABLE IF NOT EXISTS `api_cotent` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `title` varchar(50) DEFAULT NULL COMMENT '标题',
  `param_in` text DEFAULT NULL COMMENT '传入参数',
  `param_out` text DEFAULT NULL COMMENT '传出参数',
  `description` text DEFAULT NULL COMMENT '描述',
  `request` varchar(50) DEFAULT NULL COMMENT 'get/post请求',
  `create_user` int(11) DEFAULT NULL COMMENT '创建人',
  `update_user` int(11) DEFAULT NULL COMMENT '修改人',
  `moudle_id` int(11) DEFAULT NULL COMMENT '模块id',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 COMMENT='接口内容';

-- 正在导出表  demo.api_cotent 的数据：~0 rows (大约)
/*!40000 ALTER TABLE `api_cotent` DISABLE KEYS */;
INSERT INTO `api_cotent` (`id`, `title`, `param_in`, `param_out`, `description`, `request`, `create_user`, `update_user`, `moudle_id`, `create_time`, `update_time`) VALUES
	(1, 'getList', '{\r\n"projectId":"1"\r\n}', '{\r\n"projectId":"1"\r\n}', 'asd阿萨德1', 'get', 1, 1, 0, '2017-11-02 15:58:20', '2017-11-02 17:19:13');
/*!40000 ALTER TABLE `api_cotent` ENABLE KEYS */;

-- 导出  表 demo.api_moudle 结构
CREATE TABLE IF NOT EXISTS `api_moudle` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(500) NOT NULL,
  `description` varchar(500) NOT NULL,
  `project_id` int(11) NOT NULL DEFAULT 0 COMMENT '项目id',
  `create_user` int(11) NOT NULL,
  `update_user` int(11) NOT NULL,
  `create_time` datetime NOT NULL,
  `update_time` datetime NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='模块表';

-- 正在导出表  demo.api_moudle 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `api_moudle` DISABLE KEYS */;
INSERT INTO `api_moudle` (`id`, `name`, `description`, `project_id`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES
	(1, 'asdasdzxczxcz1', '1231244', 1, 1, 1, '2017-11-02 11:38:28', '2017-11-02 11:38:45'),
	(2, 'sdad', '12312', 1, 1, 1, '2017-11-02 14:16:35', '2017-11-02 14:16:35');
/*!40000 ALTER TABLE `api_moudle` ENABLE KEYS */;

-- 导出  表 demo.api_project 结构
CREATE TABLE IF NOT EXISTS `api_project` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(500) DEFAULT NULL COMMENT '项目名称',
  `description` text DEFAULT NULL COMMENT '项目描述',
  `create_user` int(1) DEFAULT NULL COMMENT '创建人',
  `update_user` int(1) DEFAULT NULL COMMENT '更信任',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 COMMENT='项目';

-- 正在导出表  demo.api_project 的数据：~4 rows (大约)
/*!40000 ALTER TABLE `api_project` DISABLE KEYS */;
INSERT INTO `api_project` (`id`, `name`, `description`, `create_user`, `update_user`, `create_time`, `update_time`) VALUES
	(1, '3asd123zc', 'ccc1231c', 1, 1, '2017-10-26 17:47:36', '2017-10-31 14:31:20'),
	(6, 'dsadas', 'asdasdas', 1, 1, '2017-10-31 11:47:44', '2017-10-31 11:47:44'),
	(7, 'sadas', '123432', 1, 1, '2017-10-31 11:50:15', '2017-10-31 11:50:15'),
	(9, '菜单管理', '用户权限菜单', 1, 1, '2017-11-02 11:35:54', '2017-11-02 11:35:54');
/*!40000 ALTER TABLE `api_project` ENABLE KEYS */;

-- 导出  表 demo.user 结构
CREATE TABLE IF NOT EXISTS `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(500) NOT NULL COMMENT '登录名',
  `password` varchar(500) NOT NULL COMMENT '密码',
  `user_sex` int(1) NOT NULL DEFAULT 1 COMMENT '1 男  2 女',
  `name` varchar(500) DEFAULT NULL COMMENT '姓名',
  `age` int(11) NOT NULL DEFAULT 20 COMMENT '年龄',
  `token` varchar(500) DEFAULT NULL COMMENT 'token码',
  `is_super` int(1) NOT NULL DEFAULT 0,
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `update_time` datetime NOT NULL COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- 正在导出表  demo.user 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` (`id`, `username`, `password`, `user_sex`, `name`, `age`, `token`, `is_super`, `create_time`, `update_time`) VALUES
	(1, 'jcc', '123456', 1, 'jcc', 24, 'null', 1, '2017-10-23 16:08:37', '2017-10-23 16:08:38'),
	(2, 'leaf', '123456', 0, NULL, 0, NULL, 0, '2017-11-01 14:12:11', '2017-11-01 14:12:11');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
