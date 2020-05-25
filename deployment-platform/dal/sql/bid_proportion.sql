create table bid_proportion(
    seller_id int not null default 0,
    buyer_id int not null default 0,
    percent int not null default 0,
    primary key (seller_id, buyer_id)
);