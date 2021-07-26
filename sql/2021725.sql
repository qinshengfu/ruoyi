/*
SQLyog 企业版 - MySQL GUI v8.14 
MySQL - 5.7.34 : Database - ry
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`ry` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `ry`;

/*Table structure for table `inventory_record` */

DROP TABLE IF EXISTS `inventory_record`;

CREATE TABLE `inventory_record` (
  `inventory_record_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '库存记录id',
  `supplier_id` int(11) DEFAULT NULL COMMENT '供应商id',
  `product_id` int(11) DEFAULT NULL COMMENT '产品id',
  `record_time` datetime DEFAULT NULL COMMENT '记录时间',
  `operator` varchar(255) DEFAULT NULL COMMENT '操作人员',
  `change_number` int(11) DEFAULT NULL COMMENT '入/出库数量',
  `record_status` varchar(99) DEFAULT NULL COMMENT '记录状态',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `receive_people` varchar(255) DEFAULT NULL COMMENT '领取人',
  PRIMARY KEY (`inventory_record_id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='库存记录表';

/*Data for the table `inventory_record` */

insert  into `inventory_record`(`inventory_record_id`,`supplier_id`,`product_id`,`record_time`,`operator`,`change_number`,`record_status`,`note`,`receive_people`) values (1,2,1,'2021-07-22 16:45:16','admin',100,'0','66','嘿嘿'),(2,1,1,'2021-07-22 16:49:02','admin',10,'0','88','哈哈'),(3,1,1,'2021-07-22 17:24:12','admin',10,'1','88','哈哈哈'),(4,2,2,'2021-07-22 20:26:11','admin',100,'0','66','admin'),(5,2,2,'2021-07-22 20:27:54','admin',10,'0','722','admin'),(6,2,2,'2021-07-22 20:28:28','admin',10,'1','21','急急急'),(7,1,1,'2021-07-25 15:26:00','admin',NULL,'1','入库','admin'),(8,0,2,'2021-07-25 15:44:32','admin',NULL,'0','修改后测试','admin'),(9,0,1,'2021-07-25 15:47:28','admin',NULL,'0','修改后测试','admin'),(10,1,1,'2021-07-25 15:58:46','admin',0,'0','又修改后入库','admin'),(11,2,2,'2021-07-25 16:04:18','admin',15,'0','成功','admin'),(12,2,2,'2021-07-25 16:07:24','admin',15,'0','成功入库','admin'),(13,2,2,'2021-07-25 17:03:03','admin',15,'1','测试出库','666'),(14,2,2,'2021-07-25 17:14:16','admin',10,'1','这个是出库','777'),(15,2,2,'2021-07-25 17:17:14','admin',10,'2','这个是退货','刚刚回归'),(16,2,2,'2021-07-25 17:18:54','admin',10,'1','这个是出库','规定缴纳');

/*Table structure for table `procurement` */

DROP TABLE IF EXISTS `procurement`;

CREATE TABLE `procurement` (
  `procurement_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '采购id',
  `supplier_id` int(11) DEFAULT NULL COMMENT '供应商id',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `number` int(11) DEFAULT NULL COMMENT '采购数量',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `total_price` decimal(10,2) DEFAULT NULL COMMENT '总价',
  `receipt` int(11) DEFAULT '0' COMMENT '入库量',
  `odd_numbers` varchar(100) DEFAULT NULL COMMENT '送货单号',
  `delivery_time` datetime DEFAULT NULL COMMENT '送货日期',
  `procurement_note` varchar(255) DEFAULT NULL COMMENT '备注',
  `status` char(111) DEFAULT '0' COMMENT '采购状态',
  PRIMARY KEY (`procurement_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='采购管理';

/*Data for the table `procurement` */

insert  into `procurement`(`procurement_id`,`supplier_id`,`product_id`,`number`,`price`,`total_price`,`receipt`,`odd_numbers`,`delivery_time`,`procurement_note`,`status`) values (1,1,1,15,'500.00','7500.00',15,'100100','2021-07-25 00:00:00','测试一下','0'),(2,2,2,15,'1000.00','15000.00',15,'10010','2021-07-25 00:00:00','还是测试','0'),(3,2,2,15,'1000.00','15000.00',15,'99999','2021-07-25 00:00:00','再次测试','0');

/*Table structure for table `product` */

DROP TABLE IF EXISTS `product`;

CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '产品id',
  `supplier_id` int(11) DEFAULT NULL COMMENT '供应商id',
  `product_name` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `warehouse_code` varchar(255) DEFAULT NULL COMMENT '仓库编码',
  `model` varchar(255) DEFAULT NULL COMMENT '规格型号',
  `unit` varchar(255) DEFAULT NULL COMMENT '单位',
  `price` decimal(10,2) DEFAULT NULL COMMENT '单价',
  `inventory` int(11) DEFAULT '0' COMMENT '库存数量',
  `image` varchar(255) DEFAULT NULL COMMENT '图像',
  `status` char(99) DEFAULT '0' COMMENT '使用状态',
  `note` varchar(255) DEFAULT NULL COMMENT '备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='商品管理';

/*Data for the table `product` */

insert  into `product`(`product_id`,`supplier_id`,`product_name`,`warehouse_code`,`model`,`unit`,`price`,`inventory`,`image`,`status`,`note`,`create_time`,`update_time`) values (1,1,'咕咕咕','M203','hfsv','pm','500.00',100,NULL,'0','88','2021-07-19 19:51:52','2021-07-25 15:22:58'),(2,2,'哈哈哈','M201','2','5','1000.00',70,NULL,'0','66','2021-07-22 15:09:58','2021-07-25 17:18:54');

/*Table structure for table `supplier` */

DROP TABLE IF EXISTS `supplier`;

CREATE TABLE `supplier` (
  `supplier_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '供应商id',
  `supplier_name` varchar(255) DEFAULT NULL COMMENT '供应商名称',
  `supplier_address` varchar(255) DEFAULT NULL COMMENT '供应商地址',
  `ten_phone` varchar(255) DEFAULT NULL COMMENT '电话',
  `contact_people` varchar(255) DEFAULT NULL COMMENT '联系人',
  `contact_phone` varchar(255) DEFAULT NULL COMMENT '联系人电话',
  `email` varchar(255) DEFAULT NULL COMMENT '邮件',
  `fax` varchar(255) DEFAULT NULL COMMENT '传真',
  `status` char(20) DEFAULT '0' COMMENT '可用状态',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  PRIMARY KEY (`supplier_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC COMMENT='供应商表';

/*Data for the table `supplier` */

insert  into `supplier`(`supplier_id`,`supplier_name`,`supplier_address`,`ten_phone`,`contact_people`,`contact_phone`,`email`,`fax`,`status`,`create_time`,`update_time`) values (1,'999','66','1','1','1','1','1','0','2021-07-20 18:43:06','2021-07-23 16:34:04'),(2,'222','333','1132','221211131','213122','32233133','232313','0','2021-07-20 18:43:06',NULL),(3,'333','333','13','233168','168','268','666','0','2021-07-23 18:36:17','2021-07-25 11:15:08');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
