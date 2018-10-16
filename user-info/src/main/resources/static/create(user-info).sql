-- -----------------------------------------------
-- 用户登录账号信息表 `sys_account`
-- -----------------------------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account` (
       `id`          		  int(11) 			  NOT NULL 					        AUTO_INCREMENT ,
       `uuid`  			      varchar(64)			NOT NULL  					      COMMENT '员工uuid',
       `user_id`  			  bigint(18)			NOT NULL  					      COMMENT '用户id' ,
       `name`  			      varchar(64)		  NOT NULL  					      COMMENT '登录名' ,
       `fullname`  			  varchar(100)		NULL                      COMMENT '姓名',
       `password`  	      varchar(100) 		NOT NULL                  COMMENT '密码',
       `orgz_id`  	      int(11)         DEFAULT NULL              COMMENT '组织架构ID',
       `user_type`        int(2)          DEFAULT NULL              COMMENT '账号类型 0：super管理员   1：普通用户',
       `user_state`       int(2)          DEFAULT NULL              COMMENT '账号状态 1:为启用   0:停用',
       `last_login`       varchar(32)     DEFAULT NULL              COMMENT '最后登录时间',
       `phone`            varchar(32)     DEFAULT NULL              COMMENT '电话号码',
       `idcard`           varchar(255)    DEFAULT NULL              COMMENT '身份证号',
       `email`            varchar(255)    DEFAULT NULL              COMMENT '邮箱',
       `user_photo`       varchar(255)    DEFAULT NULL              COMMENT '个人头像',
       `effect_start`     varchar(32)     DEFAULT NULL              COMMENT '有效期限开始时间',
       `effect_end`       varchar(32)     DEFAULT NULL              COMMENT '有效期限结束时间',
       `status`  				  tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
       `remark`  				  varchar(100) 	 NULL DEFAULT NULL  			  COMMENT '备注,描述' ,
       `modify_time`  		varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改时间',
       `modify_user`  		varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改人' ,
       `ext`  					  varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext1`  				    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext2`  				    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `uuid` (`uuid`) USING BTREE,
       UNIQUE INDEX `user_id` (`user_id`,`user_state`) USING BTREE,
       UNIQUE INDEX `name` (`name`,`user_state`) USING BTREE,
       UNIQUE INDEX `idcard` (`idcard`, `user_state`) USING BTREE
)  comment='用户登录账号信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- -----------------------------------------------
-- 用户扩展信息表 `sys_user_eav`
-- -----------------------------------------------
DROP TABLE IF EXISTS `sys_user_eav`;
CREATE TABLE `sys_user_eav` (
       `id`          		    int(11) 			  NOT NULL 				        AUTO_INCREMENT ,
       `user_id`  			    bigint(18)			NOT NULL  					    COMMENT '用户id' ,
       `dict_key`  			    varchar(64)			NOT NULL  		          COMMENT '字段key',
       `dict_code`  			  varchar(64)			NOT NULL  		          COMMENT '字段编码',
       `dict_value`  			  varchar(64)			NOT NULL  		          COMMENT '字段值',
       `status`  				    tinyint(1) 			NOT NULL  DEFAULT '1'   COMMENT '状态, 1: 正常，0：禁用',
       `remark`  				    varchar(100) 	  NULL DEFAULT NULL  			COMMENT '备注,描述' ,
       `modify_time`  		  varchar(32) 		NULL DEFAULT NULL  			COMMENT '修改时间',
       `modify_user`  		  varchar(32) 		NULL DEFAULT NULL  			COMMENT '修改人' ,
       `ext`  					    varchar(100)		NULL DEFAULT NULL       COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `user_id_dict_code` (`user_id`,`dict_code`) USING BTREE
)  comment='用户扩展信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;