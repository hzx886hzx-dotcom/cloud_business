-- cloud_business 业务表
-- 动态ua表
drop table if exists cloud_ua;
create table cloud_ua (
  id          bigint(20)      not null auto_increment    comment '编号',
  ua          varchar(500)    default ''                 comment 'ua信息',
  create_time datetime                                   comment '创建时间',
  primary key (id)
) engine=innodb auto_increment=1 comment = '动态ua表';
-- 用户表
drop table if exists cloud_user;
create table cloud_user (
  id          bigint(20)      not null auto_increment    comment '编号',
  username    varchar(50)     default ''                 comment '用户名',
  password    varchar(100)    default ''                 comment '密码',
  proxy       varchar(200)    default ''                 comment '代理',
  amount      decimal(14,2)   default 0.00               comment '金额',
  access_token varchar(500)    default ''                 comment '访问令牌',
  platform     int     DEFAULT 0                 COMMENT '平台 0=石头岛 1=鲸鱼',
  ua_id         bigint(20)                       COMMENT 'ua_id',
  create_time datetime                                   comment '创建时间',
  creator          varchar(50)    DEFAULT ''                COMMENT '创建人',
  create_by        bigint(20)     DEFAULT 0                 COMMENT '创建人ID',
  version int(11)       DEFAULT 0                 COMMENT '版本号',
  primary key (id),
  index idx_username (username),
  unique key uk_un_platform_type (username, platform)
) engine=innodb auto_increment=1 comment = '用户表';

-- 接口表
drop table if exists cloud_api;
CREATE TABLE cloud_api (
  id               bigint(20)     NOT NULL AUTO_INCREMENT    COMMENT '主键ID',
  category     int     DEFAULT 0                 COMMENT '分类 0=游戏 1=用户',
  platform     int     DEFAULT 0                 COMMENT '平台 0=石头岛 1=鲸鱼',
  name             varchar(100)   NOT NULL                   COMMENT '接口名称',
  api              varchar(1000)  NOT NULL                   COMMENT '接口URL',
  method           varchar(10)    DEFAULT 'GET'              COMMENT '请求方式',
  content_type     varchar(100)   DEFAULT 'application/json' COMMENT '内容类型',
  headers          json                                    COMMENT '请求头(JSON)',
  params           json                                    COMMENT '查询参数(JSON)',
  proxy            varchar(200)   DEFAULT ''                 COMMENT '代理',
  timeout          int             DEFAULT 30                COMMENT '超时时间(秒)',
  retry_times      int             DEFAULT 3                COMMENT '重试次数',
  retry_interval   int            DEFAULT 5                 COMMENT '重试间隔(秒)',
  next_execute_interval int            DEFAULT 100          COMMENT '下次执行间隔(秒)',
  resp_format      varchar(20)    DEFAULT 'JSON'            COMMENT '响应格式',
  expect_code      varchar(100)   DEFAULT '200'             COMMENT '期望响应码(多个用逗号分隔)',
  status           tinyint(1)     DEFAULT 1                 COMMENT '状态 0:禁用 1:启用',
  sort             int             DEFAULT 0                 COMMENT '排序',
  description      varchar(1000)  DEFAULT ''                COMMENT '接口描述',
  creator          varchar(50)    DEFAULT ''                COMMENT '创建人',
  create_by        bigint(20)     DEFAULT 0                 COMMENT '创建人ID',
  version          int             DEFAULT 0                COMMENT '版本号',
  create_time      datetime       DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  update_time      datetime       DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (id),
  UNIQUE KEY uk_name (name) COMMENT '名称唯一',
  INDEX idx_status (status),
  INDEX idx_create_time (create_time)
) ENGINE=InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET=utf8mb4
  COLLATE=utf8mb4_unicode_ci
  COMMENT='游戏接口表';