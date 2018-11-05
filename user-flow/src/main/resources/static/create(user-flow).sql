-- ----------------------------
-- 流程定义表 `bss_flow`
-- ----------------------------
DROP TABLE IF EXISTS `bss_flow`;
CREATE TABLE `bss_flow` (
  `id`          			int(11) 			  NOT NULL 					  AUTO_INCREMENT ,
	`flow_id`  				  int(11)				  NOT NULL  					COMMENT '流程ID',
	`flow_code`  			  varchar(32)			NOT NULL  					COMMENT '流程code',
	`flow_type`  			  varchar(32)			NOT NULL  					COMMENT '流程类型' ,
	`flow_name`  			  varchar(100)		NOT NULL    				COMMENT '流程名称',
	`fullname`  			  varchar(100)		NULL DEFAULT NULL   COMMENT '全名',
	`flow_version`  		varchar(32)			NOT NULL    				COMMENT '流程版本',
	`priority`  			  int(2) 				  NOT NULL  DEFAULT '1'  COMMENT '优先级， 0：表示默认流程 1:定义流程',
	`cc_type`  				  int(11)				  NOT NULL    				  COMMENT '抄送类型，0：无抄送人员，1：按角色，2：按人员',
	`cc_users`  			  longtext		    NULL DEFAULT NULL     	COMMENT '抄送人或者角色（人数最多不超过30个人）',
	`effect_start_time` varchar(32)			NULL DEFAULT NULL     	COMMENT '启用时间',
	`effect_end_time`  	varchar(32)			NULL DEFAULT NULL     	COMMENT '停用时间',
	`status`  				  tinyint(1) 			NOT NULL  DEFAULT '1'   COMMENT '状态, 1: 正常，0：禁用',
	`remark`  				  varchar(100) 		NULL DEFAULT NULL  			COMMENT '备注' ,
	`ext`  					    varchar(100)		NULL DEFAULT NULL     	COMMENT '预留字段',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `flow_id` (`flow_id`) USING BTREE,
	UNIQUE INDEX `flow_id_priority_name` (`flow_id`,`priority`,`flow_name`) USING BTREE
)comment='流程定义表'
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- 流程节点表 `bss_flow_node`
-- ----------------------------
DROP TABLE IF EXISTS `bss_flow_node`;
CREATE TABLE `bss_flow_node` (
  `id`          		int(11) 			  NOT NULL 					AUTO_INCREMENT ,
	`node_id`  				int(11)				  NOT NULL  				COMMENT '节点ID' ,
	`flow_id`  				int(11)				  NOT NULL  				COMMENT '流程ID' ,
	`node_name`  			varchar(100)		NOT NULL    			COMMENT '节点名称',
	`node_type`  			varchar(100)		NOT NULL    			COMMENT '节点类型',
	`node_step`  			int(11)				  NOT NULL  				COMMENT '节点步骤',
	`node_des`  			varchar(100)		NULL    					COMMENT '节点描述',
	`approver_person_type`  int(11)				NOT NULL    	COMMENT '审批人类别， 1：主管-指定一级 2：主管-连续多级 3：指定成员 4：角色（一组固定成员）5：发起人自己',
	`approve_mode`  		int(11)				NOT NULL    			COMMENT '审批方式 ， 1:依次审批（本环节内审批人依次审批）2:会签（须所有审批人同意）,3:或签（一名审批人同意或拒绝即可）4:发起人从角色成员自选， ',
	`approve_depth`  		int(11)				NOT NULL    			COMMENT '审批深度：只对直到第几级主管',
	`approver_fill`  		int(11)				NOT NULL    			COMMENT '0: 不查找上级, 1:若该审批人空缺，由其在通讯录中的上级主管代审批， 2：提示流程错误',
	`approver_users`  	longtext		    NULL DEFAULT NULL   COMMENT ' 3：指定成员 4：指定角色（一组固定成员）对应信息',
	`runtime`  				varchar(32)			NULL DEFAULT NULL     		COMMENT '启用时间',
	`status`  				tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
	`remark`  				varchar(100) 		NULL DEFAULT NULL  			COMMENT '备注' ,
	`ext`  					varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `node_id` (`node_id`) USING BTREE
)comment='流程节点表'
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;

-- ----------------------------
-- 流程审批详情表 `bss_flow_approve`
-- ----------------------------
DROP TABLE IF EXISTS `bss_flow_approve`;
CREATE TABLE `bss_flow_approve` (
    `id`          		int(11) 			    NOT NULL 					AUTO_INCREMENT ,
    `buss_type`  			varchar(100)		  NOT NULL 					COMMENT '业务类型',
    `buss_uuid`  			varchar(64)		    NOT NULL 					COMMENT '业务UUID',
	  `flow_id`  				int(11)				    NOT NULL  				COMMENT '流程ID' ,
    `node_id`  				int(11)				    NOT NULL  				COMMENT '节点ID' ,
	  `node_name`  			varchar(100)		  NOT NULL    			COMMENT '节点名称',
	  `node_des`  			varchar(100)		  NULL    					COMMENT '节点描述',
	  `approver_user`  		int(11)				  NOT NULL    			COMMENT '审批人',
	  `approver_uuid`  		varchar(50)			NOT NULL    		COMMENT '审批人UUID',
	  `approver_comment`  	varchar(200)		NOT NULL    	COMMENT '审批语',
	  `approver_result`  		tinyint(1) 			NOT NULL			COMMENT '审批结果, 1: 同意，0：拒绝',
	  `approve_time`  		varchar(32)			NULL DEFAULT NULL     		COMMENT '审批时间',

	`flow_status`  			tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '审批状态, 1: 等待审批，2: 正在审批，3：审批完成',
	`status`  				tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
	`remark`  				varchar(100) 		NULL DEFAULT NULL  			COMMENT '备注' ,
	`ext`  					varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
	PRIMARY KEY (`id`),

	UNIQUE INDEX `buss_uuid_node_id_approver_user` (`buss_uuid`, `node_id`) USING BTREE
)comment='流程审批详情表'
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- ----------------------------
-- 业务流程审核记录表 `bss_flow_buss_record`
-- ----------------------------
DROP TABLE IF EXISTS `bss_flow_buss_record`;
CREATE TABLE `bss_flow_buss_record` (
    `id`          			  int(11) 			  NOT NULL 					AUTO_INCREMENT ,
    `buss_type`  			    varchar(100)		NULL    					COMMENT '业务类型',
    `buss_uuid`  			    varchar(64)		  NOT NULL 					COMMENT '业务类型UUID',
    `buss_record_uuid`  	varchar(64)		  NOT NULL 					COMMENT '业务表单UUID',
	  `buss_apply_time`  		varchar(32)			NOT NULL 					COMMENT '提交时间',
	  `flow_id`  				    int(11)				  NOT NULL  				COMMENT '流程ID' ,
	  `flow_name`  			    varchar(11)			NULL  						COMMENT '流程名称' ,
	  `flow_status`  			  tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '审批状态, 1: 等待审批，2: 正在审批，3：审批完成',
	  `approver_result`  		tinyint(1) 			NOT NULL  DEFAULT '0'   	COMMENT '审批结果, 0: 审核中， 1: 同意，2：拒绝',
	  `approve_start_time`  varchar(32)			NULL DEFAULT NULL     		COMMENT '审批开始时间',
	  `approve_end_time`  	varchar(32)			NULL DEFAULT NULL     		COMMENT '审批结束时间',
	  `status`  				    tinyint(1) 			NOT NULL  DEFAULT '1'   	COMMENT '状态, 1: 正常，0：禁用',
	  `remark`  				    varchar(100) 		NULL DEFAULT NULL  			COMMENT '备注' ,
	  `ext`  					      varchar(100)		NULL DEFAULT NULL     		COMMENT '预留字段',
	PRIMARY KEY (`id`),
	UNIQUE INDEX `buss_uuid` (`buss_uuid`) USING BTREE
)comment='业务流程审核记录表'
ENGINE=InnoDB
DEFAULT CHARACTER SET=utf8 COLLATE=utf8_general_ci;


-- ------------------------------------
-- 流程与业务对应关系表 `bss_flow_buss_r`
-- ------------------------------------
DROP TABLE IF EXISTS `bss_flow_buss_r`;
CREATE TABLE `bss_flow_buss_r` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `buss_type`  			    varchar(100)		NULL    					COMMENT '业务类型',
  `buss_uuid`  			    varchar(64)		  NOT NULL 					COMMENT '业务UUID',
  `buss_condition_id`   int(11)         DEFAULT NULL      COMMENT '表单前置条件ID',
  `flow_id`             int(11)         NOT NULL          COMMENT '流程ID',
  `flowCode`            varchar(32)     DEFAULT NULL      COMMENT '流程编码',
  `priority`            int(2)          NULL  DEFAULT '1' COMMENT '优先级， 0：表示默认流程 1:定义流程',
  `effect_start_time`   varchar(32)     DEFAULT NULL      COMMENT '有效期限开始时间',
  `effect_end_time`     varchar(32)     DEFAULT NULL      COMMENT '有效期限结束时间',
  `status`              tinyint(1)      NOT NULL DEFAULT '1' COMMENT '状态, 1: 正常，0：禁用',
  `remark` varchar(100) DEFAULT NULL COMMENT '备注',
  `ext` varchar(100) DEFAULT NULL COMMENT '预留字段',
  PRIMARY KEY (`id`),
  UNIQUE KEY `flow_id_buss_id` (`buss_uuid`,`flow_id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8 COMMENT='流程与业务对应关系表';



