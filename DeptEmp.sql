/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50527
Source Host           : localhost:3306
Source Database       : ly

Target Server Type    : MYSQL
Target Server Version : 50527
File Encoding         : 65001

Date: 2018-09-06 16:19:01
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `dept`
-- ----------------------------
DROP TABLE IF EXISTS `dept`;
CREATE TABLE `dept` (
  `deptno` int(2) NOT NULL DEFAULT '0',
  `dname` varchar(14) DEFAULT NULL,
  `loc` varchar(13) DEFAULT NULL,
  PRIMARY KEY (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of dept
-- ----------------------------
INSERT INTO `dept` VALUES ('10', 'ACCOUNTING', 'NEW YORK');
INSERT INTO `dept` VALUES ('20', 'RESEARCH', 'DALLAS');
INSERT INTO `dept` VALUES ('30', 'SALES', 'CHICAGO');
INSERT INTO `dept` VALUES ('40', 'OPERATIONS', 'BOSTON');

-- ----------------------------
-- Table structure for `emp`
-- ----------------------------
DROP TABLE IF EXISTS `emp`;
CREATE TABLE `emp` (
  `EMPNO` int(4) NOT NULL,
  `ENAME` varchar(10) DEFAULT NULL,
  `JOB` varchar(9) DEFAULT NULL,
  `MGR` int(4) DEFAULT NULL,
  `HIREDATE` date DEFAULT NULL,
  `SAL` int(7) DEFAULT NULL,
  `COMM` int(7) DEFAULT NULL,
  `DEPTNO` int(2) DEFAULT NULL,
  PRIMARY KEY (`EMPNO`),
  KEY `FK_DEPTNO` (`DEPTNO`),
  CONSTRAINT `FK_DEPTNO` FOREIGN KEY (`DEPTNO`) REFERENCES `dept` (`deptno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of emp
-- ----------------------------
INSERT INTO `emp` VALUES ('7369', 'SMITH', 'CLERK', '7902', '1980-12-17', '800', '300', '20');
INSERT INTO `emp` VALUES ('7499', 'ALLEN', 'SALESMAN', '7698', '1981-02-20', '1600', '300', '30');
INSERT INTO `emp` VALUES ('7521', 'WARD', 'SALESMAN', '7698', '1981-02-22', '1250', '500', '30');
INSERT INTO `emp` VALUES ('7566', 'JONES', 'MANAGER', '7839', '1981-04-02', '2975', '300', '20');
INSERT INTO `emp` VALUES ('7654', 'MARTIN', 'SALESMAN', '7698', '1981-09-28', '1250', '1400', '30');
INSERT INTO `emp` VALUES ('7698', 'BLAKE', 'MANAGER', '7839', '1981-05-01', '2850', '100', '30');
INSERT INTO `emp` VALUES ('7782', 'CLARK', 'MANAGER', '7839', '1981-06-09', '2450', '120', '10');
INSERT INTO `emp` VALUES ('7788', 'SCOTT', 'ANALYST', '7566', '1987-04-19', '3000', '300', '20');
INSERT INTO `emp` VALUES ('7839', 'KING', 'PRESIDENT', '7700', '1981-11-17', '5000', '300', '10');
INSERT INTO `emp` VALUES ('7844', 'TURNER', 'SALESMAN', '7698', '1981-09-08', '1500', '0', '30');
INSERT INTO `emp` VALUES ('7876', 'ADAMS', 'CLERK', '7788', '1987-05-23', '1100', '200', '20');
INSERT INTO `emp` VALUES ('7900', 'JAMES', 'CLERK', '7698', '1981-12-03', '950', '100', '30');
INSERT INTO `emp` VALUES ('7902', 'FORD', 'ANALYST', '7566', '1981-12-03', '3000', '500', '20');
INSERT INTO `emp` VALUES ('7934', 'MILLER', 'CLERK', '7782', '1982-01-23', '1300', '300', '10');

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(30) NOT NULL AUTO_INCREMENT,
  `product_title` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_price` bigint(30) DEFAULT NULL,
  `product_image` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_category` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_seller` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_brand` varchar(30) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_description` varchar(100) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_spec` varchar(200) COLLATE utf8_unicode_ci DEFAULT NULL,
  `product_status` varchar(2) COLLATE utf8_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_product_spec_1` (`product_spec`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', 'vivo手机大屏高像素男女', '1599', 'images/vivov3', '手机', '李一', 'vivo', '特别好用啊，不信你就试试', '{\"网络制式\":\"4g\",\"尺寸\":\"5.5英寸\"}', '1');
INSERT INTO `product` VALUES ('2', '华为手机像素特高', '1399', 'images/huawei', '手机', '李一', 'huawei', '非常好的手机', '{\"net\":\"4g\",\"size\":\"6.0英寸\"}', '1');
INSERT INTO `product` VALUES ('3', '宋慧乔', '9999', 'images/huiqiao.jpg', '乔', '宋宋', 'beauty', '123', null, '1');
INSERT INTO `product` VALUES ('4', 'oppo手机男女', '2599', 'images', '手机', '张三', 'oppo', '很棒的手机', '{\"net\":\"4g\",\"size\":\"7.0英寸\"}', '1');
