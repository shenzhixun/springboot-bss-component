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
)  comment='组织架构信息表'
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
) comment='角色类型表'
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- 角色定义表 `sys_role`
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
) comment='角色定义表'
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- 用户角色关联表 `sys_account_role_r`
-- ----------------------------
DROP TABLE IF EXISTS `sys_account_role_r`;
CREATE TABLE `sys_account_role_r` (
  `id`          			int(11) 			  NOT NULL 					AUTO_INCREMENT ,
	`account_uuid`  	  varchar(64)     NOT NULL          COMMENT '帐号uuid',
	`role_type_id`  		int(11)				  NOT NULL  				COMMENT '角色类型ID',
	`role_id`  				  int(11)				  NOT NULL  				COMMENT '角色ID' ,
	`status`  				  tinyint(1) 			NOT NULL  DEFAULT '1' COMMENT '状态, 1: 正常，0：不正常',
	`remark`  				  varchar(100) 		NULL DEFAULT NULL  		COMMENT '备注' ,
	`ext`  					    varchar(100)		NULL DEFAULT NULL     COMMENT '预留字段',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `account_uuid_role_id` (`account_uuid`, `role_id`, `role_type_id`) USING BTREE
)comment='用户角色关联表'
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- 功能模块表 `sys_module`
-- ----------------------------
DROP TABLE IF EXISTS `sys_module`;
CREATE TABLE `sys_module` (
    `id`          			int(11) 			NOT NULL 					AUTO_INCREMENT ,
	`module_id`  			int(11)				NOT NULL  DEFAULT '0'   	COMMENT '模块ID' ,
	`module_pid`  			int(11) 			NOT NULL  DEFAULT '0'   	COMMENT '父模块' ,
	`module_level`  		int(11) 			NOT NULL  DEFAULT '0'   	COMMENT '层级' ,
	`module_name`  			varchar(100)		NOT NULL DEFAULT ''   		COMMENT '模块名称' ,
	`module_name_en`  		varchar(50)			NULL DEFAULT NULL     		COMMENT '模块名称(英文)' ,
	`module_type`  			tinyint(1) 			NOT NULL  DEFAULT '0'   	COMMENT '模块类型,  1:菜单， 2：链接页面 ，3：button ' ,
	`sort_order`  			int(2) 				NOT NULL  DEFAULT '0'   	COMMENT '排序' ,
	`url`  					varchar(100)		NULL DEFAULT NULL     		COMMENT '模块URL',
	`act`  					varchar(100)		NULL DEFAULT NULL     		COMMENT '动作',
	`flag`  				varchar(50)			NULL DEFAULT NULL     		COMMENT '标志(备用)',
	`icon`  				varchar(100)		NULL DEFAULT NULL     		COMMENT '模块icon',
	`css`  					varchar(100)		NULL DEFAULT NULL     		COMMENT '模块css样式',
	`status`  				tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '模块状态, 1: 正常显示，0：不显示',
	`remark`  				varchar(100) 		NULL DEFAULT NULL  			COMMENT '备注' ,
	`modify_time`  			varchar(32) 		NULL DEFAULT NULL  			COMMENT '修改时间',
	`modify_user`  			varchar(32) 		NULL DEFAULT NULL  			COMMENT '修改人' ,
	`ext`  					varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
	`ext1`  				varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
	`ext2`  				varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `module_id` (`module_id`) USING BTREE,
	UNIQUE INDEX `module_id_level` (`module_id`, `module_level`, `module_type`) USING BTREE
)comment='功能模块表'
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- 角色功能权限关联表 `sys_role_module_r`
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
	UNIQUE INDEX `role_id_module_id` (`role_id`, `module_id`) USING BTREE
)comment='角色功能权限关联表'
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- 用户功能权限关联表 `sys_account_module_r`
-- ----------------------------
DROP TABLE IF EXISTS `sys_account_module_r`;
CREATE TABLE `sys_account_module_r` (
  `id`          		int(11) 			  NOT NULL 					AUTO_INCREMENT ,
	`user_id`  				bigint(18)			NOT NULL  					COMMENT '用户ID',
	`module_id`  			int(11)				  NOT NULL  					COMMENT '模块ID',
	`module_type`  		tinyint(1)			NOT NULL  					COMMENT '模块类型',
	`act_rights`  		varchar(10)			NOT NULL  					COMMENT '模块对应权限：共五位：增，删，改，查，审批  1表示有，0表示无',
	`status`  				tinyint(1) 			NOT NULL  DEFAULT '1'   COMMENT '状态, 1: 正常，0：不正常',
	`remark`  				varchar(100) 		NULL DEFAULT NULL  			COMMENT '备注' ,
	`ext`  					varchar(100)		  NULL DEFAULT NULL     	COMMENT '预留字段',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `user_id_role_id` (`user_id`, `module_id`, `module_type`) USING BTREE
)comment='用户功能权限关联表'
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;



-- ----------------------------
-- 数据权限体系层次表 `sys_syslevel`
-- ----------------------------
DROP TABLE IF EXISTS `sys_syslevel`;
CREATE TABLE `sys_syslevel` (
    `id`          			int(11) 			NOT NULL 					AUTO_INCREMENT ,
    `syslevel_id`       int(11) 			NOT NULL 					COMMENT '节点编号'  ,
	  `syslevel_name`  		varchar(32)		NOT NULL    			COMMENT '节点名' ,
    `syslevel_pid`      int(11) 			NOT NULL 					COMMENT '父节点编号'  ,
    `levels`          	int(11) 			NOT NULL 					COMMENT '节点层级'  ,
	  `syslevel_type`  		int(2) 				NOT NULL 					COMMENT '节点类型：1、组织架构 2：行政区域（预留）' ,
	  `status`  				  tinyint(1) 			NOT NULL  DEFAULT '1'   COMMENT '状态, 1: 正常，0：不正常',
	  `remark`  				  varchar(100) 		NULL DEFAULT NULL  			COMMENT '备注' ,
	  `modify_time`  			varchar(32) 		NULL DEFAULT NULL  			COMMENT '修改时间',
	  `modify_user`  			varchar(32) 		NULL DEFAULT NULL  			COMMENT '修改人' ,
	  `ext`  					    varchar(100)		NULL DEFAULT NULL     	COMMENT '预留字段',
	  `ext1`  				    varchar(100)		NULL DEFAULT NULL     	COMMENT '预留字段',
	  `ext2`  				    varchar(100)		NULL DEFAULT NULL     	COMMENT '预留字段',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `syslevel_id_type_levels` (`syslevel_id`, `levels`, `syslevel_type`) USING BTREE
)comment='数据权限体系层次表'
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- 角色数据权限关联表 `sys_role_syslevel_r`
-- ----------------------------
DROP TABLE IF EXISTS `sys_role_syslevel_r`;
CREATE TABLE `sys_role_syslevel_r` (
  `id`          			int(11) 			NOT NULL 					  AUTO_INCREMENT ,
	`role_id`  				  int(11)				NOT NULL  					COMMENT '角色ID' ,
	`syslevel_id`  			int(11)				NOT NULL  					COMMENT '体系ID',
	`syslevel_type`  		int(2)				NOT NULL  					COMMENT '体系类型',
	`levels`  				  int(11) 			NOT NULL  DEFAULT '1'   	COMMENT '体系层级',
	`status`  				  tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：不正常',
	`remark`  				  varchar(100) 		NULL DEFAULT NULL  			COMMENT '备注' ,
	`ext`  					    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `role_id_level_id_type` (`role_id`, `syslevel_id`, `syslevel_type` ) USING BTREE
)comment='角色数据权限关联表'
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- 用户数据权限关联表 `sys_account_syslevel_r`
-- ----------------------------
DROP TABLE IF EXISTS `sys_account_syslevel_r`;
CREATE TABLE `sys_account_syslevel_r` (
    `id`          		int(11) 			NOT NULL 					AUTO_INCREMENT ,
	`user_id`  				  bigint(18)				NOT NULL  					COMMENT '用户ID',
	`syslevel_id`  			int(11)				NOT NULL  					COMMENT '体系ID',
	`syslevel_type`  		int(2)				NOT NULL  					COMMENT '体系类型',
	`levels`  				  int(11) 			NOT NULL  DEFAULT '1'   	COMMENT '体系层级',
	`act_rights`  			varchar(10)			NULL DEFAULT NULL  			COMMENT '模块对应权限：共五位：增，删，改，查，审批  1表示有，0表示无',
	`status`  				  tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：不正常',
	`remark`  				  varchar(100) 		NULL DEFAULT NULL  			COMMENT '备注' ,
	`ext`  					    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `user_id_level_id_type` (`user_id`, `syslevel_id`, `syslevel_type`, `levels`) USING BTREE
)comment='用户数据权限关联表'
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;





/** 角色类型 */
INSERT INTO `sys_role_type` (`id`, `role_type_id`, `role_type_code`, `role_type_name`, `fullname`, `status`, `remark`, `ext`)
VALUES ('1', '1', 'admin', '管理员', '管理员', '1', '管理员类型', NULL);
INSERT INTO `sys_role_type` (`id`, `role_type_id`, `role_type_code`, `role_type_name`, `fullname`, `status`, `remark`, `ext`)
VALUES ('2', '2', 'dept_manager', '主管类型', '主管类型', '1', '主管类型', NULL);
INSERT INTO `sys_role_type` (`id`, `role_type_id`, `role_type_code`, `role_type_name`, `fullname`, `status`, `remark`, `ext`)
VALUES ('3', '3', 'default', '员工类型', '员工类型', '1', '普通员工类型', NULL);

/** 角色 */
INSERT INTO `sys_role` (`id`, `role_id`, `role_type_id`, `role_type_code`, `role_name`, `fullname`, `status`, `remark`, `ext`)
VALUES ('1', '1', '1', 'admin', '超级管理员', '超级管理员', '1', '超级管理员角色', NULL);
INSERT INTO `sys_role` (`id`, `role_id`, `role_type_id`, `role_type_code`, `role_name`, `fullname`, `status`, `remark`, `ext`)
VALUES ('2', '2', '2', 'dept_manager', '主管', '主管', '1', '主管角色', NULL);
INSERT INTO `sys_role` (`id`, `role_id`, `role_type_id`, `role_type_code`, `role_name`, `fullname`, `status`, `remark`, `ext`)
VALUES ('3', '3', '3', 'default', '员工', '员工', '1', '员工角色', NULL);

/** 超级管理员与角色对应表 */
INSERT INTO `sys_account_role_r` VALUES ('1', '1', '1', '1', '1', null, null);

/** 添加基础菜单 */
INSERT INTO `sys_module` VALUES ('100', '100', '0', '1', '系统管理', 'xtgl', '1', '1', null, null, null, null, null, '1', null, null, null, null, '', null);
INSERT INTO `sys_module` VALUES ('10010', '10010', '0', '2', '角色类型管理', 'jsxlgl', '0', '1', null, null, null, null, null, '1', null, null, null, null, null, null);
INSERT INTO `sys_module` VALUES ('10020', '10020', '0', '2', '角色管理', 'jsgl', '0', '2', null, null, null, null, null, '1', null, null, null, null, null, null);


/** 添加管理员对应菜单 */