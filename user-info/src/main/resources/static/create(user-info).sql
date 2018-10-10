-- -----------------------------------------------
-- 用户登录账号信息表 `sys_user`
-- -----------------------------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
       `id`          		  int(11) 			  NOT NULL 					        AUTO_INCREMENT ,
       `uuid`  			      varchar(64)			NOT NULL  					      COMMENT '员工uuid',
       `userid`  			    varchar(32)			NOT NULL  					      COMMENT '工号' ,
       `username`  			  varchar(32)		  NOT NULL  					      COMMENT '登录名' ,
       `fullname`  			  varchar(64)			NULL                      COMMENT '姓名',
       `password`  	      varchar(100) 		NOT NULL                  COMMENT '密码',
       `orgz_id`  	      int(11)         DEFAULT NULL              COMMENT '组织架构ID',
       `datalevel_id`     int(11)         DEFAULT NULL              COMMENT '所属体系ID',
       `account_type`     int(2)          DEFAULT NULL              COMMENT '账号类型 0：super管理员   1：普通用户',
        `account_state`   int(2)          DEFAULT NULL              COMMENT '账号状态 1:为启用   0:停用',
        `last_login`      varchar(32)     DEFAULT NULL              COMMENT '最后登录时间',
        `phone`           varchar(32)     DEFAULT NULL              COMMENT '电话号码',
        `idcard`          varchar(255)    DEFAULT NULL              COMMENT '身份证号',
        `email`           varchar(255)    DEFAULT NULL              COMMENT '邮箱',
        `userPhoto`       varchar(255)    DEFAULT NULL              COMMENT ' 个人头像',
        `effect_start`    varchar(255)    DEFAULT NULL              COMMENT '有效期限开始时间',
        `effect_end`      varchar(255)    DEFAULT NULL              COMMENT '有效期限结束时间',
       `status`  				  tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
       `remark`  				   varchar(100) 	NULL DEFAULT NULL  			  COMMENT '备注,描述' ,
       `modify_time`  		 varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改时间',
       `modify_user`  		 varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改人' ,
       `ext`  					   varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext1`  				     varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext2`  				     varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `uuid` (`uuid`) USING BTREE,
       UNIQUE INDEX `userid` (`userid`,`account_state`) USING BTREE,
       UNIQUE INDEX `username` (`username`,`account_state`) USING BTREE,
       UNIQUE INDEX `idcard` (`idcard`, `account_state`) USING BTREE
)  comment='用户登录账号信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- -----------------------------------------------
-- 用户扩展信息表 `sys_user_ext`
-- -----------------------------------------------
DROP TABLE IF EXISTS `sys_user_ext`;
CREATE TABLE `sys_user_ext` (
       `id`          		  int(11) 			  NOT NULL 				AUTO_INCREMENT ,
       `user_uuid`  			varchar(64)			NOT NULL  		  COMMENT '员工uuid',
       `sex`              varchar(50)     DEFAULT NULL    COMMENT '性别  1为男   0为女',
        `born_date`       varchar(20)     DEFAULT NULL    COMMENT '出生日期',
        `age`             int(2)          DEFAULT NULL    COMMENT '年龄',
        `prefession`      varchar(255)    DEFAULT NULL    COMMENT '专业',
        `nation`          varchar(255)    DEFAULT NULL    COMMENT '民族',
        `nationality`     varchar(255)    DEFAULT NULL COMMENT '国籍',
        `maxeducation`    varchar(255)    DEFAULT NULL COMMENT '最高学历',
        `marriage`         varchar(255)   DEFAULT NULL COMMENT '婚姻状况',
        `foreignLanguages` varchar(255)   DEFAULT NULL COMMENT '外语',
        `address`          varchar(200)   DEFAULT NULL COMMENT '地址',
        `qrcodeImg`        varchar(255)   DEFAULT NULL COMMENT '二维码图片地址  ',
        `fingerprint`       varchar(255) DEFAULT NULL COMMENT '指纹',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `user_uuid` (`user_uuid`) USING BTREE
)  comment='用户扩展信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;