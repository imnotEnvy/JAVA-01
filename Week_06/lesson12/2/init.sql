
CREATE DATABASE IF NOT EXISTS mall;
USE mall;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `username` varchar(64) DEFAULT NULL COMMENT '用户名',
  `password` varchar(64) DEFAULT NULL COMMENT '密码',
  `nickname` varchar(64) DEFAULT NULL COMMENT '昵称',
  `phone` varchar(64) DEFAULT NULL COMMENT '手机号码',
  `email` varchar(64) DEFAULT NULL COMMENT '电子邮箱',
  `created_at` timestamp DEFAULT now(),
  `updated_at` timestamp DEFAULT now(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='用户表';


DROP TABLE IF EXISTS `address`;
CREATE TABLE `address` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '地址id',
  `user_id` int(8) NOT NULL COMMENT '用户id',
  `address_name` varchar(50) DEFAULT NULL COMMENT '地址',
  `name` varchar(64) DEFAULT NULL COMMENT '收货人',
  `phone` varchar(64) DEFAULT NULL COMMENT '电话号码',
  `province` varchar(64) DEFAULT NULL COMMENT '省/直辖市',
  `city` varchar(64) DEFAULT NULL COMMENT '市',
  `region` varchar(64) DEFAULT NULL COMMENT '区',
  `detail_address` varchar(100) DEFAULT NULL COMMENT '详细地址',
  `created_at` timestamp DEFAULT now(),
  `updated_at` timestamp DEFAULT now(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='收发货地址表';


DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `id` int(8) NOT NULL AUTO_INCREMENT,
  `price` decimal(10, 2) DEFAULT NULL COMMENT '价格',
  `catalog` varchar(10) DEFAULT NULL COMMENT '产品类别',
  `created_at` timestamp DEFAULT now(),
  `updated_at` timestamp DEFAULT now(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='产品';


DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `id` int(8) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `user_id` int(8) NOT NULL,
  `product_id` int(8) NOT NULL,
  `address_id` int(8) NOT NULL,
  `price` decimal(10, 2) DEFAULT NULL,
  `created_at` timestamp DEFAULT now(),
  `updated_at` timestamp DEFAULT now(),
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4 COMMENT='订单表';