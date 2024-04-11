-- 创建库
create database if not exists api_platform_db;

-- 切换库
use api_platform_db;

-- 用户表
create table if not exists user
(
    id           bigint auto_increment comment 'id' primary key,
    userName     varchar(256)                           null comment '用户昵称',
    userAccount  varchar(256)                           not null comment '账号',
    userAvatar   varchar(1024)                          null comment '用户头像',
    userGender       tinyint                                null comment '性别',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    userPassword varchar(512)                           not null comment '密码',
    `accessKey` varchar(512) not null comment 'accessKey',
    `secretKey` varchar(512) not null comment 'secretKey',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_userAccount
        unique (userAccount)
) engine InnoDB default charset = utf8mb4 comment '用户';

-- 接口信息
create table if not exists api_platform_db.`interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `name` varchar(256) not null comment '名称',
    `description` varchar(256) null comment '描述',
    `url` varchar(512) not null comment '接口地址',
    `requestParams` text not null comment '请求参数',
    `requestHeader` text null comment '请求头',
    `responseHeader` text null comment '响应头',
    `status` int default 0 not null comment '接口状态（0-关闭，1-开启）',
    `method` varchar(256) not null comment '请求类型',
    `userId` bigint not null comment '创建人',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) engine InnoDB default charset = utf8mb4 comment '接口信息';

-- 用户调用接口关系表
create table if not exists api_platform_db.`user_interface_info`
(
    `id` bigint not null auto_increment comment '主键' primary key,
    `userId` bigint not null comment '调用用户 id',
    `interfaceInfoId` bigint not null comment '接口 id',
    `totalNum` int default 0 not null comment '总调用次数',
    `leftNum` int default 0 not null comment '剩余调用次数',
    `status` int default 0 not null comment '0-正常，1-禁用',
    `createTime` datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    `updateTime` datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    `isDelete` tinyint default 0 not null comment '是否删除(0-未删, 1-已删)'
) engine InnoDB default charset = utf8mb4 comment '用户调用接口关系';

INSERT INTO api_platform_db.interface_info (name, description, url, requestParams, requestHeader, responseHeader, status, method, userId, createTime, updateTime, isDelete)
VALUES
    ('User Details', 'Retrieve user information', '/api/user', '{"userId": 123}', '{"Authorization": "Bearer token"}', '{"Content-Type": "application/json"}', 1, 'GET', 1, '2024-04-11 08:00:00', '2024-04-11 08:00:00', 0),
    ('Update User', 'Update user information', '/api/user/update', '{"userId": 123, "name": "John Doe", "email": "john@example.com"}', '{"Authorization": "Bearer token"}', '{"Content-Type": "application/json"}', 1, 'POST', 1, '2024-04-11 09:00:00', '2024-04-11 09:00:00', 0),
    ('Product List', 'Retrieve list of products', '/api/products', '{}', '{"Authorization": "Bearer token"}', '{"Content-Type": "application/json"}', 1, 'GET', 2, '2024-04-11 10:00:00', '2024-04-11 10:00:00', 0),
    ('Create Product', 'Create a new product', '/api/product/create', '{"name": "New Product", "price": 50}', '{"Authorization": "Bearer token"}', '{"Content-Type": "application/json"}', 1, 'POST', 2, '2024-04-11 11:00:00', '2024-04-11 11:00:00', 0),
    ('Order Details', 'Retrieve details of an order', '/api/order/123', '{}', '{"Authorization": "Bearer token"}', '{"Content-Type": "application/json"}', 1, 'GET', 3, '2024-04-11 12:00:00', '2024-04-11 12:00:00', 0);
