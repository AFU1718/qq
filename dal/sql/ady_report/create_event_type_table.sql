drop table if exists event_type;

create table event_type (
    id      integer primary key,
    name    text not null,
    comment text default '' not null
);

insert into event_type (id, name, comment)
values (0, 'UNKNOWN_EVENT_TYPE', '什么鬼？'),
(10, 'SELLER_REQUEST', '流量端请求'),
(20, 'ADX_INTERCEPT', 'ADX 对流量断请求的拦截'),
(30, 'TO_BUYER_REQUEST', 'ADX 对 DSP 竞价请求'),
(40, 'BUYER_BID', '买家对 ADX 出价'),
(50, 'BUYER_NO_BID', '买家对 ADX 明确不出价, eg: 204'),
(60, 'BUYER_TIMEOUT', '买家响应超时'),
(70, 'BUYER_ERROR', '买家有响应，但是有错误'),
(80, 'ADX_BID', 'ADX 对卖家'),
(90, 'ADX_NO_BID', 'ADX 对卖家不出价'),
(100, 'ADX_DROP', 'ADX 丢弃买家的出价'),
(120, 'ADX_WIN_NOTICE', '流量端发出的竞价成功通知'),
(130, 'IMPRESSION', '展示'),
(140, 'CLICK', '点击'),
(150, 'DOWNLOAD_STARTED', '下载开始'),
(160, 'DOWNLOAD_COMPLETED', '下载完成'),
(170, 'INSTALL_STARTED', '安装开始'),
(180, 'INSTALL_COMPLETED', '安装完成');

