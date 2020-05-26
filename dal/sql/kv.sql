create table kv1 (
  k text primary key,
  v text default '' not null,
  updated_at timestamp with time zone default now() not null);