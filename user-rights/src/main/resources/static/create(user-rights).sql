-- -----------------------------------------------
-- 组织架构信息 `sys_orgz`
-- -----------------------------------------------
DROP TABLE IF EXISTS `sys_orgz`;
CREATE TABLE `sys_orgz` (
       `id`          		    int(11) 			  NOT NULL 			    AUTO_INCREMENT ,
       `uuid`  			        varchar(64)			NOT NULL  		    COMMENT '标识uuid',
       `orgz_id`  			    int(11)			    NOT NULL  		    COMMENT '组织机构Id',
       `orgz_pid`  			    int(11)			    NOT NULL  		    COMMENT '组织机构父Id',
       `orgz_code`  			  varchar(64)			NOT NULL  		    COMMENT '组织机构编码',
       `orgz_name`  				varchar(64) 	  NOT NULL  		    COMMENT '名称',
       `fullname`  		      varchar(100) 	  NOT NULL  		    COMMENT '全称',
       `orgz_level`  		    int(11)         DEFAULT NULL      COMMENT '层级',
       `sort_order`  		    int(2)          NOT NULL DEFAULT '0' COMMENT '层级',
       `search_tag`         varchar(200)    DEFAULT NULL      COMMENT '搜索tag',
       `remark`  				    varchar(100) 	  NULL DEFAULT NULL  	COMMENT '备注,描述' ,
       `modify_time`  		  varchar(32) 		NULL DEFAULT NULL  	COMMENT '修改时间',
       `modify_user`  		  varchar(32) 		NULL DEFAULT NULL  	COMMENT '修改人' ,
       `ext`  					    varchar(100)		NULL DEFAULT NULL   COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `orgz_id` (`orgz_id`) USING BTREE
)  comment='用户扩展信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;



-- ----------------------------
-- 角色类型表 `sys_role_type`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_type`;
CREATE TABLE `sys_role_type` (
    `id`          			  int(11) 			  NOT NULL 					AUTO_INCREMENT ,
	  `role_type_id`  		  int(11)				  NOT NULL  					COMMENT '角色类型ID' ,
	  `role_type_code`  		varchar(64)			NOT NULL  					COMMENT '角色类型code' ,
	  `role_type_name`  		varchar(64)			NOT NULL    				COMMENT '角色类型名称' ,
	  `fullname`  			    varchar(100)		NULL DEFAULT NULL     		COMMENT '全名' ,
	  `status`  				    tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：不正常',
	  `remark`  				    varchar(100) 		NULL DEFAULT NULL  			COMMENT '备注' ,
	  `ext`  					      varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `role_type_code` (`role_type_code`),
	UNIQUE INDEX `role_type_code_name` (`role_type_code`,`role_type_name`) USING BTREE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- 角色表 `sys_role`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role`;
CREATE TABLE `sys_role` (
  `id`          			int(11) 			NOT NULL 					AUTO_INCREMENT ,
	`role_id`  				  int(11)				NOT NULL  					COMMENT '角色ID' ,
	`role_type_id`  		int(11)				NOT NULL  					COMMENT '角色类型ID',
	`role_type_code`  	varchar(64)			NOT NULL  					COMMENT '角色类型Code',
	`role_name`  			  varchar(64)			NOT NULL    				COMMENT '角色名称',
	`fullname`  			  varchar(100)			NULL DEFAULT NULL     		COMMENT '全名' ,
	`status`  				  tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：不正常',
	`remark`  				  varchar(100) 		NULL DEFAULT NULL  			COMMENT '备注' ,
	`ext`  					    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',

	PRIMARY KEY (`id`),
	UNIQUE INDEX `role_id` (`role_id`),
	UNIQUE INDEX `role_id_role_type_id` (`role_id`, `role_type_id`, `role_name`) USING BTREE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- 用户角色关联表 `sys_account_role_r`
-- ----------------------------
DROP TABLE IF EXISTS `sys_account_role_r`;
CREATE TABLE `sys_account_role_r` (
  `id`          			int(11) 			NOT NULL 					AUTO_INCREMENT ,
	`user_id`  			  bigint(18)			NOT NULL  					      COMMENT '用户id' ,
	`role_id`  				int(11)				NOT NULL  					COMMENT '角色ID' ,
	`role_type_id`  		int(11)				NOT NULL  					COMMENT '角色类型ID',
	`status`  				tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：不正常',
	`remark`  				varchar(100) 		NULL DEFAULT NULL  			COMMENT '备注' ,
	`ext`  					varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `user_id_role_id` (`user_id`, `role_id`, `role_type_id`) USING BTREE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- 角色功能权限表 `sys_role_module_r`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_module_r`;
CREATE TABLE `sys_role_module_r` (
  `id`          			int(11) 			NOT NULL 					AUTO_INCREMENT ,
	`role_id`  				int(11)				NOT NULL  					COMMENT '角色ID' ,
	`module_id`  			int(11)				NOT NULL  					COMMENT '模块ID',
	`act_rights`  			varchar(10)			NOT NULL  					COMMENT '模块对应权限：共五位：增，删，改，查，审批  1表示有，0表示无',
	`status`  				tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：不正常',
	`remark`  				varchar(100) 		NULL DEFAULT NULL  			COMMENT '备注' ,
	`ext`  					varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `role_id_module_id` (`role_id`, `module_id`, `module_type` ) USING BTREE
)
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;