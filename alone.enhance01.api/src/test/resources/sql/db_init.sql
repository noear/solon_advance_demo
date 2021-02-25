CREATE TABLE `water_cfg_properties` (
                                        `row_id` int(11) NOT NULL AUTO_INCREMENT,
                                        `tag` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '分组标签',
                                        `key` varchar(99) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性key',
                                        `type` int(11) NOT NULL DEFAULT '0' COMMENT '类型：0:未知，1:数据库；2:Redis；3:MangoDb; 4:Memcached',
                                        `value` varchar(8000) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '属性值',
                                        `edit_mode` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL,
                                        `is_editable` tinyint(1) NOT NULL DEFAULT '0' COMMENT '是否可编辑',
                                        `is_enabled` int(11) NOT NULL DEFAULT '1' COMMENT '是否启用',
                                        `update_fulltime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
                                        PRIMARY KEY (`row_id`) USING BTREE,
                                        UNIQUE KEY `IX_tag_key` (`tag`,`key`) USING BTREE,
                                        KEY `IX_type` (`type`) USING BTREE
) ENGINE=InnoDB  DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='WATER-配置-属性表';





CREATE TABLE `water_reg_service` (
                                     `service_id` int(11) NOT NULL AUTO_INCREMENT,
                                     `key` varchar(40) COLLATE utf8mb4_general_ci NOT NULL COMMENT 'md5(name+‘#’+address)',
                                     `name` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
                                     `ver` varchar(40) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '版本号',
                                     `address` varchar(255) COLLATE utf8mb4_general_ci NOT NULL,
                                     `meta` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '源信息',
                                     `note` varchar(512) COLLATE utf8mb4_general_ci DEFAULT '',
                                     `alarm_mobile` varchar(20) COLLATE utf8mb4_general_ci DEFAULT NULL,
                                     `alarm_sign` varchar(50) COLLATE utf8mb4_general_ci DEFAULT NULL,
                                     `state` int(11) NOT NULL DEFAULT '0' COMMENT '0:待检查；1检查中',
                                     `code_location` varchar(512) COLLATE utf8mb4_general_ci DEFAULT NULL,
                                     `check_type` int(11) NOT NULL DEFAULT '0' COMMENT '检查方式（0被检查；1自己签到）',
                                     `check_url` varchar(200) COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '状态检查地址',
                                     `check_last_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '最后检查时间',
                                     `check_last_state` int(11) NOT NULL DEFAULT '0' COMMENT '最后检查状态（0：OK；1：error）',
                                     `check_last_note` varchar(255) COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '最后检查描述',
                                     `check_error_num` int(11) NOT NULL DEFAULT '0' COMMENT '检测异常数量',
                                     `is_unstable` int(11) NOT NULL DEFAULT '0' COMMENT '是否为不稳定的',
                                     `is_enabled` int(11) NOT NULL DEFAULT '1' COMMENT '是否为已启用',
                                     PRIMARY KEY (`service_id`) USING BTREE,
                                     UNIQUE KEY `IX_key` (`key`) USING BTREE,
                                     KEY `IX_address` (`address`(100)) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='WATER-注册-服务者表';