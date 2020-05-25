drop table if exists "dsp_account_balance";

create table "dsp_account_balance" (
ts timestamptz not null,
dsp_id integer not null,
balance_in_micro bigint not null default 0,
updated_at timestamptz not null default now(),
primary key (ts, dsp_id)
);
