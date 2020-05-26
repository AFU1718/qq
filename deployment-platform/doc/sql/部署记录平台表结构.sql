-- 项目部署记录表
CREATE TABLE "project_deployment_record" (
  "id" serial PRIMARY KEY, -- 主键id
  "project_id" int4 NOT NULL, -- 项目id
  "status" int4 NOT NULL,  -- 项目构建状态
  "version" text default '' NOT NULL, -- 版本信息
  "change_log" text default '' NOT NULL, -- 版本更新信息
  "developers" text default '' NOT NULL, -- 开发人员
  "testers" text default '' NOT NULL, -- 测试人员
  "deployed_at" timestamptz NOT NULL, -- 部署时间
  "total_time" int4 NOT NULL, -- 本次迭代开发总时间（单位：天）
  "note" text NOT NULL, -- 备注
  "created_by" int4 NOT NULL, -- 创建人id
  "updated_by" int4 NOT NULL, -- 最近更新人id
  "created_at" timestamptz DEFAULT now() NOT NULL , -- 创建时间
  "updated_at" timestamptz DEFAULT now() NOT NULL , -- 最近更新时间
  "is_deleted" int2 NOT NULL DEFAULT 0 -- 删除标记
)
;
comment on column project_deployment_record.id is '主键id';
comment on column project_deployment_record.project_id is '项目id';
comment on column project_deployment_record.status is '项目构建状态';
comment on column project_deployment_record.version is '版本信息';
comment on column project_deployment_record.change_log is '版本更新信息';
comment on column project_deployment_record.developers is '开发人员';
comment on column project_deployment_record.testers is '测试人员';
comment on column project_deployment_record.deployed_at is '部署时间';
comment on column project_deployment_record.total_time is '本次迭代开发总时间（单位：天）';
comment on column project_deployment_record.note is '备注';
comment on column project_deployment_record.created_by is '创建人id';
comment on column project_deployment_record.updated_by is '最近更新人id';
comment on column project_deployment_record.created_at is '创建时间';
comment on column project_deployment_record.updated_at is '最近更新时间';
comment on column project_deployment_record.is_deleted is '删除标记';


-- 项目表
CREATE TABLE "project" (
  "id" serial PRIMARY KEY, -- 主键id
  "project_group_id" int4 NOT NULL, --项目组id
  "project_name" text default '' NOT NULL, -- 项目名称
  "project_type" text default '' NOT NULL, -- 项目类型（比如scala项目，python项目等）
  "note" text default '' NOT NULL, -- 备注
  "created_by" int4 NOT NULL, -- 创建人id
  "updated_by" int4 NOT NULL, -- 最近更新人id
  "created_at" timestamptz DEFAULT now() NOT NULL , -- 创建时间
  "updated_at" timestamptz DEFAULT now() NOT NULL , -- 最近更新时间
  "is_deleted" int2 NOT NULL DEFAULT 0 -- 删除标记
)
;
comment on column project.id is '主键id';
comment on column project.project_group_id is '项目组id';
comment on column project.project_name is '项目名称';
comment on column project.project_type is '项目类型';
comment on column project.note is '备注';
comment on column project.created_by is '创建人id';
comment on column project.updated_by is '最近更新人id';
comment on column project.created_at is '创建时间';
comment on column project.updated_at is '最近更新时间';
comment on column project.is_deleted is '删除标记';

-- 项目组表
CREATE TABLE "project_group" (
  "id" serial PRIMARY KEY, -- 主键id
  "project_group_name" text default '' NOT NULL, -- 项目组名称
  "note" text default '' NOT NULL, -- 备注
  "created_by" int4 NOT NULL, -- 创建人id
  "updated_by" int4 NOT NULL, -- 最近更新人id
  "created_at" timestamptz DEFAULT now() NOT NULL , -- 创建时间
  "updated_at" timestamptz DEFAULT now() NOT NULL , -- 最近更新时间
  "is_deleted" int2 NOT NULL DEFAULT 0 -- 删除标记
)
;
comment on column project_group.id is '主键id';
comment on column project_group.project_group_name is '项目组名称';
comment on column project_group.note is '备注';
comment on column project_group.created_by is '创建人id';
comment on column project_group.updated_by is '最近更新人id';
comment on column project_group.created_at is '创建时间';
comment on column project_group.updated_at is '最近更新时间';
comment on column project_group.is_deleted is '删除标记';

-- 用户信息表
CREATE TABLE "user_info" (
  "id" serial PRIMARY KEY, -- 主键id
  "name" text default '' NOT NULL, -- 用户名
  "password" text default '' NOT NULL, -- 用户密码
  "role_id" int4 NOT NULL, --角色id
  "created_at" timestamptz DEFAULT now() NOT NULL , -- 创建时间
  "updated_at" timestamptz DEFAULT now() NOT NULL , -- 最近更新时间
  "is_deleted" int2 NOT NULL DEFAULT 0 -- 删除标记
)
;
comment on column user_info.id is '主键id';
comment on column user_info.name is '用户名';
comment on column user_info.password is '用户密码';
comment on column user_info.role_id is '角色id';
comment on column user_info.created_at is '创建时间';
comment on column user_info.updated_at is '最近更新时间';
comment on column user_info.is_deleted is '删除标记';

-- 角色表
CREATE TABLE "role" (
  "id" serial PRIMARY KEY, -- 主键id
  "role_name" text default '' NOT NULL, -- 角色名
  "note" text default '' NOT NULL, -- 备注
  "created_at" timestamptz DEFAULT now() NOT NULL , -- 创建时间
  "updated_at" timestamptz DEFAULT now() NOT NULL , -- 最近更新时间
  "is_deleted" int2 NOT NULL DEFAULT 0 -- 删除标记
)
;
comment on column role.id is '主键id';
comment on column role.role_name is '角色名';
comment on column role.note is '备注';
comment on column role.created_at is '创建时间';
comment on column role.updated_at is '最近更新时间';
comment on column role.is_deleted is '删除标记';
