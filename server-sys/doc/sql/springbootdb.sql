create database springbootdb;

create table user
(
    userId   varchar(64) null,
    userName varchar(64) null,
    age      int         null,
    sex      int         null
)
    comment '用户表';

create table diyquery
(
    id_        varchar(64) not null
        primary key,
    name_      varchar(20) null comment '名称',
    key_       varchar(20) not null comment 'key',
    sql_       blob        null comment 'sql',
    createdate datetime    null comment '创建时间',
    dataSource varchar(64) null comment '数据源',
    ext2       varchar(64) null comment '扩展2',
    ext3       varchar(64) null comment '扩展3'
)
    comment '自定义查询';

INSERT INTO springbootdb.user (userId, userName, age, sex) VALUES ('1', 'xzw', 12, 1);
INSERT INTO springbootdb.user (userId, userName, age, sex) VALUES ('145', 'zzl', 122, 0);
INSERT INTO springbootdb.user (userId, userName, age, sex) VALUES ('685', 'zzl', 122, 0);
INSERT INTO springbootdb.user (userId, userName, age, sex) VALUES ('666', 'tjh', 12, 1);

INSERT INTO springbootdb.diyquery (id_, name_, key_, sql_, createdate, dataSource, ext2, ext3) VALUES ('1', '查询用户', 'USER_CX', 0x73656C656374202A2066726F6D2075736572, '2021-01-01 16:57:04', 'main', null, null);