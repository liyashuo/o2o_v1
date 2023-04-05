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

create table `tb_head_line`
(
    `line_id`        int(100)      NOT NULL AUTO_INCREMENT,
    `line_name`      varchar(1000) NOT NULL,
    `line_link`      varchar(2000) NOT NULL,
    `line_img`       varchar(2000) NOT NULL,
    `priority`       int(2)                 DEFAULT NULL,
    `enable_status`  int(2)        NOT NULL DEFAULT '0',
    `create_time`    datetime               DEFAULT NULL,
    `last_edit_time` datetime               DEFAULT NULL,

    primary key (`line_id`)
) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

create table `tb_shop_category`
(
    `shop_category_id`   int(11)      NOT NULL AUTO_INCREMENT,
    `shop_category_name` varchar(100) NOT NULL DEFAULT '',
    `shop_category_desc` varchar(1000)         DEFAULT '',
    `shop_category_img`  varchar(2000)         DEFAULT NULL,
    `priority`           int(2)       NOT NULL DEFAULT '0',
    `create_time`        datetime              DEFAULT NULL,
    `last_edit_time`     datetime              DEFAULT NULL,
    `parent_id`          int(11)               DEFAULT NULL,
    primary key (`shop_category_id`),
#     增加外键约束，并与哪个表做关联
    constraint `fk_shop_category_self` foreign key (`parent_id`) references `tb_shop_category` (`shop_category_id`)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

create table `tb_shop`
(
    `shop_id`          int(10)      NOT NULL AUTO_INCREMENT,
    `owner_id`         int(10)      NOT NULL COMMENT '店铺创建人',
    `area_id`          int(5)                DEFAULT NULL,
    `shop_category_id` int(11)               DEFAULT NULL,
    `shop_name`        varchar(256) NOT NULL,
    `shop_desc`        varchar(1024)         DEFAULT '',
    `shop_addr`        varchar(200)          DEFAULT NULL,
    `phone`            varchar(128)          DEFAULT NULL,
    `shop_img`         varchar(1024)         DEFAULT NULL,
    `priority`         int(3)                DEFAULT '0',
    `create_time`      datetime              DEFAULT NULL,
    `last_edit_time`   datetime              DEFAULT NULL,
    `enable_status`    int(2)       NOT NULL DEFAULT '0',
    `advice`           varchar(255)          DEFAULT NULL,
    primary key (`shop_id`),
#     增加外键约束，并与哪个表做关联
    constraint `fk_shop_area` foreign key (`area_id`) references `tb_area` (`area_id`),
    constraint `fk_shop_profile` foreign key (`owner_id`) references `tb_person_info` (`user_id`),
    constraint `fk_shop_shopcate` foreign key (`shop_category_id`) references `tb_shop_category` (`shop_category_id`)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

create table `tb_product_category`
(
    `product_category_id`   int(11)      NOT NULL AUTO_INCREMENT,
    `product_category_name` varchar(100) NOT NULL,
    `priority`              int(2)                DEFAULT '0',
    `create_time`           datetime              DEFAULT NULL,
    `shop_id`               int(20)      NOT NULL DEFAULT '0',
    primary key (`product_category_id`),
#     增加外键约束，并与哪个表做关联
    constraint `fk_procate_shop` foreign key (`shop_id`) references `tb_shop` (`shop_id`)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;


create table `tb_product`
(
    `product_id`          int(100)     NOT NULL AUTO_INCREMENT,
    `product_name`        varchar(100) NOT NULL,
    `product_desc`        varchar(2000)         DEFAULT '',
    `img_addr`            varchar(2000)         DEFAULT '',
    `normal_price`        varchar(100)          DEFAULT NULL,
    `promotion_price`     varchar(100)          DEFAULT NULL,
    `shop_img`            varchar(1024)         DEFAULT NULL,
    `priority`            int(2)       NOT NULL DEFAULT '0',
    `create_time`         datetime              DEFAULT NULL,
    `last_edit_time`      datetime              DEFAULT NULL,
    `enable_status`       int(2)       NOT NULL DEFAULT '0',
    `product_category_id` int(11)               DEFAULT '0',
    `shop_id`             int(20)      NOT NULL DEFAULT '0',
    primary key (`product_id`),
#     增加外键约束，并与哪个表做关联
    constraint `fk_product_procate` foreign key (`product_category_id`) references `tb_product_category` (`product_category_id`),
    constraint `fk_product_shop` foreign key (`shop_id`) references `tb_shop` (`shop_id`)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;

create table `tb_product_img`
(
    `product_img_id` int(20)       NOT NULL AUTO_INCREMENT,
    `img_addr`       varchar(2000) NOT NULL,
    `img_desc`       varchar(2000) NOT NULL,
    `priority`       int(2)   DEFAULT '0',
    `create_time`    datetime DEFAULT NULL,
    `product_id`     int(20)  DEFAULT NULL,
    primary key (`product_img_id`),
#     增加外键约束，并与哪个表做关联
    constraint `fk_proimg_product` foreign key (`product_id`) references `tb_product` (`product_id`)

) ENGINE = InnoDB
  AUTO_INCREMENT = 1
  DEFAULT CHARSET = utf8;