-- -----------------------------------------------
-- 登录账号信息表 `sys_account`
-- -----------------------------------------------
DROP TABLE IF EXISTS `sys_account`;
CREATE TABLE `sys_account` (
       `id`          		  int(11) 			  NOT NULL 					        AUTO_INCREMENT ,
       `uuid`  			      varchar(64)			NOT NULL  					      COMMENT '帐号uuid',
       `name`  			      varchar(64)		  NOT NULL  					      COMMENT '登录名' ,
       `nickname`  			  varchar(64)		  NOT NULL  					      COMMENT '昵称' ,
       `password`  	      varchar(100) 		NOT NULL                  COMMENT '密码',
       `account_type`     int(2)          DEFAULT NULL              COMMENT '账号类型 0：super管理员   1：管理员 2：普通用户',
       `account_state`    int(2)          DEFAULT NULL              COMMENT '账号状态 1:为启用   0:停用',
       `effect_start`     varchar(32)     DEFAULT NULL              COMMENT '有效期限开始时间',
       `effect_end`       varchar(32)     DEFAULT NULL              COMMENT '有效期限结束时间',
       `last_login`       varchar(32)     DEFAULT NULL              COMMENT '最后登录时间',
       `login_state`      tinyint(1) 			NOT NULL  DEFAULT '1'     COMMENT '登录状态, 1: 在线，0：未登录',
       `status`  				  tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
       `remark`  				  varchar(100) 	  NULL DEFAULT NULL  			  COMMENT '备注,描述' ,
       `create_time`  		varchar(32) 		NULL DEFAULT NULL  			  COMMENT '创建时间',
       `modify_time`  		varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改时间',
       `modify_user`  		varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改人' ,
       `ext`  					  varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext1`  				    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext2`  				    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `name` (`name`) USING BTREE,
       UNIQUE INDEX `uuid` (`uuid`) USING BTREE
)  comment='登录账号信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- -----------------------------------------------
-- 用户信息表 `sys_user`
-- -----------------------------------------------
DROP TABLE IF EXISTS `sys_user`;
CREATE TABLE `sys_user` (
       `id`          		    int(11) 			  NOT NULL 				          AUTO_INCREMENT ,
       `user_id`  			    bigint(18)			NOT NULL  					      COMMENT '用户id(取身份证号)' ,
       `user_name`  			  varchar(64)		  NOT NULL  					      COMMENT '用户名' ,
       `fullname`  			    varchar(100)		NULL DEFAULT NULL         COMMENT '姓名',
       `orgz_id`  	        int(11)         NULL DEFAULT NULL         COMMENT '组织架构ID',
       `user_photo`         varchar(255)    NULL DEFAULT NULL         COMMENT '个人头像',
       `phone`              varchar(32)     NULL DEFAULT NULL         COMMENT '电话号码',
       `idcard`             varchar(255)    NULL DEFAULT NULL         COMMENT '身份证号',
       `email`              varchar(255)    NULL DEFAULT NULL         COMMENT '邮箱',

       `has_account`  			tinyint(1) 			NOT NULL  DEFAULT '1'     COMMENT '状态, 1: 分配账号，0：不分配',
       `account_uuid`  			varchar(64)			NULL DEFAULT NULL  			  COMMENT '帐号uuid',

       `status`  				    tinyint(1) 			NOT NULL  DEFAULT '1'     COMMENT '用户状态, 1: 正常，0：禁用',
       `remark`  				    varchar(100) 	  NULL DEFAULT NULL  			  COMMENT '备注,描述' ,
       `modify_time`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改时间',
       `modify_user`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改人' ,
       `ext`  					    varchar(100)		NULL DEFAULT NULL         COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `account_uuid_user_id` (`account_uuid`,`user_id`) USING BTREE,
       UNIQUE INDEX `user_name` (`user_name`) USING BTREE,
       UNIQUE INDEX `user_id` (`user_id`) USING BTREE
)  comment='用户信息表'
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



-- 初始化账号 -----------------------------------------------
INSERT INTO `sys_account` VALUES ('1', '1', 'root', '超级管理员', '21232f297a57a5a743894a0e4a801fc3', '1', '1', null, null, null, '1', '1', null, null, null, null, null, null, null);
