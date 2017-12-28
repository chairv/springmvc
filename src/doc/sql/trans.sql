CREATE TABLE `u_trans_ratio` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `regDate` date DEFAULT NULL COMMENT '时期',
  `regCnt` int(11) DEFAULT NULL COMMENT '注册数',
  `dreamUserCnt` int(11) DEFAULT NULL COMMENT '创建过钱罐用户',
  `depUserCnt` int(11) DEFAULT NULL COMMENT '投资过用户',
  `reDepUserCnt` int(11) DEFAULT NULL COMMENT '复投过用户',
  `seedUserCnt` int(11) DEFAULT NULL COMMENT '种子用户',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin;