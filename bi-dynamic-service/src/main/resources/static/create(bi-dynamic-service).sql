-- -----------------------------------------------
-- 数据库信息表 `bi_database_info`
-- -----------------------------------------------
DROP TABLE IF EXISTS `bi_database_info`;
CREATE TABLE `bi_database_info` (
       `id`          		  int(11) 			  NOT NULL 					        AUTO_INCREMENT ,
       `uuid`  			      varchar(64)			NOT NULL  					      COMMENT '库ID' ,
       `name`  			      varchar(200)		NOT NULL  					      COMMENT '库名称' ,
       `db_driver`  			varchar(64)			NOT NULL                  COMMENT '驱动名称',
       `db_url`  	        varchar(400) 		NULL DEFAULT NULL     		COMMENT '数据库url',
       `db_username`  	  varchar(64) 		NULL DEFAULT NULL     		COMMENT '用户名',
       `db_password`  	  varchar(64) 		NULL DEFAULT NULL     		COMMENT '密码',
       `status`  				  tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
       `remark`  				   varchar(100) 	NULL DEFAULT NULL  			  COMMENT '备注,描述' ,
       `modify_time`  		 varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改时间',
       `modify_user`  		 varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改人' ,
       `ext`  					   varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext1`  				     varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext2`  				     varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `uuid` (`uuid`) USING BTREE,
       INDEX `db_driver` (`db_driver`) USING BTREE
)  comment='数据库信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- -----------------------------------------------
-- 数据库配置表 `bi_database_config`
-- -----------------------------------------------
DROP TABLE IF EXISTS `bi_database_config`;
CREATE TABLE `bi_database_config` (
       `id`          		        int(11) 			    NOT NULL 					        AUTO_INCREMENT ,
       `uuid`  			            varchar(64)			  NOT NULL  					      COMMENT '标识ID' ,
       `param_type`             varchar(200)		  NOT NULL  					      COMMENT '库名称' ,
       `param_name`             int(11) 			    NOT NULL  					      COMMENT '初始化时建立物理连接的个数。初始化发生在显示调用init方法，或者第一次getConnection时' ,
       `param_value`             int(11) 			    NOT NULL  					      COMMENT '最大连接数数，如果为0的话，表示无限制' ,
       `min_idle`               int(11) 			    NOT NULL  					      COMMENT '最小连接池数量' ,
       `max_wait`               int(11) 			    NOT NULL  					      COMMENT '可用连接是的等待时间，单位毫秒，配置了maxWait之后，缺省启用公平锁，并发效率会有所下降，如果需要可以通过配置useUnfairLock属性为true使用非公平锁。' ,
       `pool_pre_statements`    int(1) 			      NOT NULL  					      COMMENT '1:true 0:false 是否缓存preparedStatement，也就是PSCache。PSCache对支持游标的数据库性能提升巨大，比如说oracle。在mysql下建议关闭。' ,
       `max_open_pre_statements`int(11) 			    NOT NULL  					      COMMENT '当大于0时，poolPreparedStatements自动触发修改为true。在Druid中，不会存在Oracle下PSCache占用内存过多的问题，可以把这个数值配置大一些，比如说100' ,
       `min_evictable_idletime` int(11) 			    NOT NULL  					      COMMENT '连接被收回前的空闲时间，超过这个时间，该连接会被收回，单位毫秒' ,
       `ext`  					   varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext`  					   varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext1`  				     varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext2`  				     varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `uuid` (`uuid`) USING BTREE
)  comment='数据库信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- -----------------------------------------------
-- 业务sql资源分类 `bi_resource_category`
-- -----------------------------------------------
DROP TABLE IF EXISTS `bi_resource_category`;
CREATE TABLE `bi_resource_category` (
       `id`          		    int(11) 			  NOT NULL 					        AUTO_INCREMENT ,
       `uuid`  			        varchar(64)			NOT NULL  					      COMMENT '分组标识ID' ,
       `name`  			        varchar(200)		NOT NULL  					      COMMENT '分组名称' ,
       `status`  				    tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
       `remark`  				    varchar(100) 	  NULL DEFAULT NULL  			  COMMENT '备注,描述' ,
       `modify_time`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改时间',
       `modify_user`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改人' ,
       `ext`  					    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `uuid` (`uuid`) USING BTREE,
       INDEX `name` (`name`) USING BTREE
)  comment='sql资源分类表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- -----------------------------------------------
-- 业务sql配置表 `bi_resource`
-- -----------------------------------------------
DROP TABLE IF EXISTS `bi_resource`;
CREATE TABLE `bi_resource` (
       `id`          		              int(11) 			    NOT NULL 					        AUTO_INCREMENT ,
       `uuid`  			                  varchar(64)			  NOT NULL  					      COMMENT 'sql标识ID' ,
       `database_info_uuid`           varchar(200)		  NOT NULL  					      COMMENT '库名称' ,
       `resource_category_uuid`       varchar(64)			  NOT NULL  					      COMMENT '分组标识ID',
       `resource_category_name`       varchar(200)		  NOT NULL  					      COMMENT '分组名称' ,
        `name`  			                varchar(200)		  NOT NULL  					      COMMENT 'sql业务名称' ,
       `type`  			                  varchar(64)			  NOT NULL                  COMMENT 'view\proc\sql\func',
       `sql_content`  	              LONGTEXT 		      NOT NULL                  COMMENT '视图\sql内容',
       `status`  				              tinyint(1) 			  NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
       `remark`  				              varchar(100) 	    NULL DEFAULT NULL  			  COMMENT '备注,描述' ,
       `modify_time`  		            varchar(32) 		  NULL DEFAULT NULL  			  COMMENT '修改时间',
       `modify_user`  		            varchar(32) 	  	NULL DEFAULT NULL  			  COMMENT '修改人' ,
       `ext`  					              varchar(100)		  NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext1`  				                varchar(100)		  NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext2`  				                varchar(100)		  NULL DEFAULT NULL     		COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `uuid` (`uuid`) USING BTREE,
       INDEX `resource_category_uuid_name` (`resource_category_uuid`, `name` ) USING BTREE
)  comment='sql配置信息表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- -----------------------------------------------
-- 业务sql配置表参数 `bi_resource_param`
-- -----------------------------------------------
DROP TABLE IF EXISTS `bi_resource_param`;
CREATE TABLE `bi_resource_param` (
       `id`          		    int(11) 			  NOT NULL 					        AUTO_INCREMENT ,
       `uuid`  			        varchar(64)			NOT NULL  					      COMMENT 'sql标识ID' ,
       `resource_uuid`      varchar(200)		NOT NULL  					      COMMENT '业务bi_resource表uuid' ,
       `param_sql`  	      LONGTEXT 		    NULL DEFAULT NULL  			  COMMENT '参数sql拼接条件',
       `param_name`  			  varchar(200)		NULL DEFAULT NULL  			  COMMENT '参数名称' ,
       `param_type`  			  varchar(64)			NULL DEFAULT NULL  			  COMMENT '参数类型',
       `param_value`  	    LONGTEXT 		    NULL DEFAULT NULL  			  COMMENT '参数值',
       `status`  				    tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
       `remark`  				    varchar(100) 	  NULL DEFAULT NULL  			  COMMENT '备注,描述' ,
       `modify_time`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改时间',
       `modify_user`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改人' ,
       `ext`  					    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext1`  				      varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext2`  				      varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `uuid` (`uuid`) USING BTREE,
       INDEX `resource_uuid_name` (`resource_uuid`, `param_name`) USING BTREE
)  comment='参数表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- -----------------------------------------------
-- 业务api分类 `bi_api_category`
-- -----------------------------------------------
DROP TABLE IF EXISTS `bi_api_category`;
CREATE TABLE `bi_api_category` (
       `id`          		    int(11) 			  NOT NULL 					        AUTO_INCREMENT ,
       `uuid`  			        varchar(64)			NOT NULL  					      COMMENT '分组标识ID' ,
       `name`  			        varchar(200)		NOT NULL  					      COMMENT '分组名称' ,
       `url_prefix`  			  varchar(100)		NOT NULL  					      COMMENT '分组请求URL前缀' ,
       `status`  				    tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
       `remark`  				    varchar(100) 	  NULL DEFAULT NULL  			  COMMENT '备注,描述' ,
       `modify_time`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改时间',
       `modify_user`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改人' ,
       `ext`  					    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
        PRIMARY KEY (`id`),
        UNIQUE INDEX `uuid` (`uuid`) USING BTREE,
        INDEX `name` (`name`) USING BTREE
)  comment='api分类表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- -- -----------------------------------------------
-- -- 业务api配置 `bi_api_define`
-- -- -----------------------------------------------
-- DROP TABLE IF EXISTS `bi_api_define`;
-- CREATE TABLE `bi_api_define` (
--        `id`          		    int(11) 			  NOT NULL 					        AUTO_INCREMENT ,
--        `uuid`  			        varchar(64)			NOT NULL  					      COMMENT 'sql标识ID' ,
--        `api_category_uuid`  varchar(64)			NOT NULL  					      COMMENT '分类UUID' ,
--        `name`               varchar(200)		NOT NULL  					      COMMENT '服务名称' ,
--        `path`               varchar(200)		NOT NULL  					      COMMENT '定义请求的路径' ,
--        `url`  			        varchar(200)		NOT NULL  					      COMMENT '参数名称' ,
--        `prefix`  			      varchar(100)		NOT NULL  					      COMMENT 'url前缀信息' ,
--        `resource_uuid`      varchar(200)		NOT NULL  					      COMMENT '业务sql配置表uuid' ,
--        `status`  				    tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
--        `remark`  				    varchar(100) 	  NULL DEFAULT NULL  			  COMMENT '备注,描述' ,
--        `modify_time`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改时间',
--        `modify_user`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改人' ,
--        `ext`  					    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
--        `ext1`  				      varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
--        `ext2`  				      varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
--        PRIMARY KEY (`id`),
--        UNIQUE INDEX `uuid` (`uuid`) USING BTREE,
--        UNIQUE INDEX `url` (`url`) USING BTREE
-- )  comment='api定义表'
--  ENGINE=InnoDB
--  DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;



-- -----------------------------------------------
-- 业务服务配置 `bi_api_service`
-- -----------------------------------------------
DROP TABLE IF EXISTS `bi_api_service`;
CREATE TABLE `bi_api_service` (
       `id`          		    int(11) 			  NOT NULL 					        AUTO_INCREMENT ,
       `uuid`  			        varchar(64)			NOT NULL  					      COMMENT '标识ID' ,
       `api_category_uuid`  varchar(64)			NOT NULL  					      COMMENT '分类UUID' ,
       `name`               varchar(200)		NOT NULL  					      COMMENT '服务名称',
       `path`               varchar(200)		NOT NULL  					      COMMENT '定义请求的路径' ,
       `url`  			        varchar(200)		NOT NULL  					      COMMENT '参数名称' ,
       `prefix`  			      varchar(100)		NOT NULL  					      COMMENT 'url前缀信息' ,
       `status`  				    tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
       `remark`  				    varchar(100) 	  NULL DEFAULT NULL  			  COMMENT '备注,描述' ,
       `modify_time`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改时间',
       `modify_user`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改人' ,
       `ext`  					    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext1`  				      varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext2`  				      varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `uuid` (`uuid`) USING BTREE,
       UNIQUE INDEX `url` (`url`) USING BTREE
)  comment='业务服务配置表'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;



-- -----------------------------------------------
-- api服务与资源关系 `bi_api_service_resource_r`
-- -----------------------------------------------
DROP TABLE IF EXISTS `bi_api_service_resource_r`;
CREATE TABLE `bi_api_service_resource_r` (
       `id`          		    int(11) 			  NOT NULL 					        AUTO_INCREMENT ,
       `uuid`  			        varchar(64)			NOT NULL  					      COMMENT '标识ID' ,
       `api_service_uuid`   varchar(64)			NOT NULL  					      COMMENT '服务uuid' ,
       `resource_uuid`      varchar(64)			NOT NULL  					      COMMENT '资源表uuid' ,
       `status`  				    tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
       `remark`  				    varchar(100) 	  NULL DEFAULT NULL  			  COMMENT '备注,描述' ,
       `modify_time`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改时间',
       `modify_user`  		  varchar(32) 		NULL DEFAULT NULL  			  COMMENT '修改人' ,
       `ext`  					    varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext1`  				      varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       `ext2`  				      varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
       PRIMARY KEY (`id`),
       UNIQUE INDEX `uuid` (`uuid`) USING BTREE,
       UNIQUE INDEX `api_service_uuid_resource_uuid` (`api_service_uuid`, `resource_uuid`) USING BTREE
)  comment='api服务与资源关系'
 ENGINE=InnoDB
 DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;
