use o2o;
create table `tb_area`
(
    `area_id`        int(2)       NOT NULL AUTO_INCREMENT,
    `area_name`      varchar(200) NOT NULL,
    `priority`       int(2)       NOT NULL DEFAULT '0',
    `create_time`    datetime              DEFAULT NULL,
    `last_edit_time` datetime              DEFAULT NULL,

    primary key (`area_id`),
    unique key `UK_AREA` (`area_name`)
    -- sql的日期有两种格式    datetime和timestamp，datetime的时间范围大于timestamp，但是timestamp可以自适应时区
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

-- mysql有两个引擎，InnoDB和MYISAM

create table `tb_person_info`
(
    `user_id`        int(10) NOT NULL AUTO_INCREMENT,
    `name`           varchar(200)     DEFAULT NULL,
    `profile_img`    varchar(1024)    DEFAULT NULL,
    `email`          varchar(1024)    DEFAULT NULL,
    `gender`         varchar(2)       DEFAULT NULL,
    # 默认为禁止状态
    `enable_status`  int(2)  NOT NULL DEFAULT '0'
        COMMENT '0.禁止使用本商城, 1.允许使用本商城',
    `user_type`      int(2)  NOT NULL DEFAULT '1'
        COMMENT '1.顾客, 2.店家, 3.超级管理员',
    `create_time`    datetime         DEFAULT NULL,
    `last_edit_time` datetime         DEFAULT NULL,
    primary key (`user_id`),
    unique key `UK_AREA` (`name`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

create table `tb_wechat_auth`
(
    `wechat_auth_id` int(10) NOT NULL AUTO_INCREMENT,
    `user_id`        int(10) NOT NULL,
#     openId由字母和数字组成
    `open_id`        varchar(1024) DEFAULT NULL,
    `create_time`    datetime      DEFAULT NULL,
    primary key (`wechat_auth_id`),
#     增加外键约束，并与哪个表做关联
    constraint `fk_wechatauth_profile` foreign key (`user_id`) references `tb_person_info` (`user_id`)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

create table `tb_local_auth`
(
    `local_auth_id`  int(10)      NOT NULL AUTO_INCREMENT,
    `user_id`        int(10)      NOT NULL,
#     openId由字母和数字组成
    `username`       varchar(128) NOT NULL,
    `password`       varchar(128) NOT NULL,
    `create_time`    datetime DEFAULT NULL,
    `last_edit_time` datetime DEFAULT NULL,
    primary key (`local_auth_id`),
    unique key `uk_local_profile` (`username`),
#     增加外键约束，并与哪个表做关联
    constraint `fk_localauth_profile` foreign key (`user_id`) references `tb_person_info` (`user_id`)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

# 这里增加的是索引，索引能增加查询的性能，但索引过多会影响数据库的性能
alter table tb_wechat_auth
    add unique index (open_id);