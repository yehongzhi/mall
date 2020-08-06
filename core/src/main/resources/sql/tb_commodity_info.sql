CREATE TABLE `tb_commodity_info` (
  `id` varchar(32) NOT NULL,
  `commodity_name` varchar(512) DEFAULT NULL COMMENT '商品名称',
  `commodity_price` varchar(36) DEFAULT '0' COMMENT '商品价格',
  `number` int(10) DEFAULT '0' COMMENT '商品数量',
  `description` varchar(2048) DEFAULT '' COMMENT '商品描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='商品信息表';

INSERT INTO tb_commodity_info VALUES('3e71a81fd80711eaaed600163e046cc3','叉烧包','3.99',3,'又大又香的叉烧包，老人小孩都喜欢');

DROP TABLE `tb_commodity_info`;