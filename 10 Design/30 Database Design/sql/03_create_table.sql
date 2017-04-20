---------------------------------------------------
-- Export file for user BJ_CEMETERY              --
-- Created by baiweiming on 2015-01-19, 22:33:13 --
---------------------------------------------------

spool 03_create_table.log

prompt
prompt Creating table BUSINESS_DATA
prompt ============================
prompt
create table bj_cemetery.BUSINESS_DATA
(
  id             NUMBER(20) not null,
  business_name  VARCHAR2(20),
  business_type  VARCHAR2(20),
  remark         VARCHAR2(200),
  is_validate    NUMBER(1),
  sort           NUMBER(10),
  create_user_id NUMBER(20),
  create_date    DATE,
  create_org_id  NUMBER(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.BUSINESS_DATA
  is '机构业务明细';
comment on column bj_cemetery.BUSINESS_DATA.id
  is '主键';
comment on column bj_cemetery.BUSINESS_DATA.business_name
  is '明细名称';
comment on column bj_cemetery.BUSINESS_DATA.business_type
  is '业务分类';
comment on column bj_cemetery.BUSINESS_DATA.remark
  is '备注';
comment on column bj_cemetery.BUSINESS_DATA.is_validate
  is '是否有效(1有效，0无效)';
comment on column bj_cemetery.BUSINESS_DATA.sort
  is '排序';
comment on column bj_cemetery.BUSINESS_DATA.create_user_id
  is '创建人ID';
comment on column bj_cemetery.BUSINESS_DATA.create_date
  is '创建时间';
comment on column bj_cemetery.BUSINESS_DATA.create_org_id
  is '公墓id';
alter table bj_cemetery.BUSINESS_DATA
  add constraint BUSINESS_DATA_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CEMETERY_FILE
prompt ============================
prompt
create table bj_cemetery.CEMETERY_FILE
(
  id             NUMBER(20) not null,
  file_name      VARCHAR2(50),
  file_size      NUMBER(20),
  file_type      VARCHAR2(20),
  file_path      VARCHAR2(200),
  fid            NUMBER(20),
  create_user_id NUMBER(20),
  create_date    DATE,
  create_org_id  NUMBER(20),
  remark         VARCHAR2(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.CEMETERY_FILE
  is '附件信息表';
comment on column bj_cemetery.CEMETERY_FILE.file_name
  is '文件名称';
comment on column bj_cemetery.CEMETERY_FILE.file_size
  is '文件大小';
comment on column bj_cemetery.CEMETERY_FILE.file_type
  is '文件类型/1.墓地照片';
comment on column bj_cemetery.CEMETERY_FILE.file_path
  is '文件路径';
comment on column bj_cemetery.CEMETERY_FILE.fid
  is '外键ID';
comment on column bj_cemetery.CEMETERY_FILE.create_user_id
  is '创建人id';
comment on column bj_cemetery.CEMETERY_FILE.create_date
  is '创建时间';
comment on column bj_cemetery.CEMETERY_FILE.create_org_id
  is '公墓id';
comment on column bj_cemetery.CEMETERY_FILE.remark
  is '备注';
alter table bj_cemetery.CEMETERY_FILE
  add constraint PK_CEMETERY_FILE primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.CEMETERY_FILE
  add constraint FK_CEMETERY_F_REF_CEMETERY_R foreign key (FID)
  references bj_cemetery.CEMETERY_REGISTRY (ID)
  disable;

prompt
prompt Creating table CEMETERY_TYPE
prompt ============================
prompt
create table bj_cemetery.CEMETERY_TYPE
(
  id                 NUMBER(20) not null,
  cemetery_type_code VARCHAR2(20),
  cemetery_type_name VARCHAR2(20),
  cemetery_property  VARCHAR2(20),
  specification      VARCHAR2(20),
  area               NUMBER(20,2),
  cave               NUMBER(20),
  flatcost           NUMBER(1),
  boxsize            VARCHAR2(50),
  stoneprovider      VARCHAR2(200),
  remark             VARCHAR2(200),
  business_data_id   NUMBER(20),
  create_user_id     NUMBER(20),
  create_date        DATE,
  create_org_id      NUMBER(20),
  total_price        NUMBER(20,2),
  ground_price       NUMBER(20,2),
  manage_price       NUMBER(20,2),
  construction_price NUMBER(20,2),
  other_price        NUMBER(20,2),
  img                NUMBER(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.CEMETERY_TYPE
  is '墓位类型';
comment on column bj_cemetery.CEMETERY_TYPE.id
  is '主键';
comment on column bj_cemetery.CEMETERY_TYPE.cemetery_type_code
  is '墓型编号';
comment on column bj_cemetery.CEMETERY_TYPE.cemetery_type_name
  is '墓型名称';
comment on column bj_cemetery.CEMETERY_TYPE.cemetery_property
  is '墓型类别';
comment on column bj_cemetery.CEMETERY_TYPE.specification
  is '墓型规格';
comment on column bj_cemetery.CEMETERY_TYPE.area
  is '面积';
comment on column bj_cemetery.CEMETERY_TYPE.cave
  is '穴别';
comment on column bj_cemetery.CEMETERY_TYPE.flatcost
  is '工本费';
comment on column bj_cemetery.CEMETERY_TYPE.boxsize
  is '护合尺寸';
comment on column bj_cemetery.CEMETERY_TYPE.stoneprovider
  is '石料供应商';
comment on column bj_cemetery.CEMETERY_TYPE.remark
  is '备注';
comment on column bj_cemetery.CEMETERY_TYPE.business_data_id
  is '业务明细';
comment on column bj_cemetery.CEMETERY_TYPE.create_user_id
  is '创建人id';
comment on column bj_cemetery.CEMETERY_TYPE.create_date
  is '创建时间';
comment on column bj_cemetery.CEMETERY_TYPE.create_org_id
  is '公墓id';
comment on column bj_cemetery.CEMETERY_TYPE.total_price
  is '墓型总价格';
comment on column bj_cemetery.CEMETERY_TYPE.ground_price
  is '土地租赁费';
comment on column bj_cemetery.CEMETERY_TYPE.manage_price
  is '管理费';
comment on column bj_cemetery.CEMETERY_TYPE.construction_price
  is '工程费';
comment on column bj_cemetery.CEMETERY_TYPE.other_price
  is '其他费用';
comment on column bj_cemetery.CEMETERY_TYPE.img
  is '墓型图片ID';
alter table bj_cemetery.CEMETERY_TYPE
  add constraint CEMETERY_TYPE_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.CEMETERY_TYPE
  add constraint FK_CEMETERY_F_REF_CEMETERY_T foreign key (IMG)
  references bj_cemetery.CEMETERY_FILE (ID);
alter table bj_cemetery.CEMETERY_TYPE
  add constraint FK_CEMETERY_REFERENCE_BUSINESS foreign key (BUSINESS_DATA_ID)
  references bj_cemetery.BUSINESS_DATA (ID);

prompt
prompt Creating table CEMETERY_ZONE
prompt ============================
prompt
create table bj_cemetery.CEMETERY_ZONE
(
  id                 NUMBER(20) not null,
  cemetery_zone_name VARCHAR2(20),
  remark             VARCHAR2(200),
  create_org_id      NUMBER(20),
  create_user_id     NUMBER(20),
  create_date        DATE,
  pid                NUMBER(20),
  is_validate        NUMBER(1),
  sort               NUMBER(10)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.CEMETERY_ZONE
  is '区排信息';
comment on column bj_cemetery.CEMETERY_ZONE.id
  is '主键';
comment on column bj_cemetery.CEMETERY_ZONE.cemetery_zone_name
  is '区排名称';
comment on column bj_cemetery.CEMETERY_ZONE.remark
  is '备注';
comment on column bj_cemetery.CEMETERY_ZONE.create_org_id
  is '公墓机构ID';
comment on column bj_cemetery.CEMETERY_ZONE.create_user_id
  is '创建人id';
comment on column bj_cemetery.CEMETERY_ZONE.create_date
  is '创建时间';
comment on column bj_cemetery.CEMETERY_ZONE.pid
  is '父id';
comment on column bj_cemetery.CEMETERY_ZONE.is_validate
  is '是否有效（1有效，0无效）';
comment on column bj_cemetery.CEMETERY_ZONE.sort
  is '排序';
alter table bj_cemetery.CEMETERY_ZONE
  add constraint CEMETERY_ZONE_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.CEMETERY_ZONE
  add constraint FK_CEMETERY_Z_REF_CEMETERY_Z foreign key (PID)
  references bj_cemetery.CEMETERY_ZONE (ID);

prompt
prompt Creating table CEMETERY_LOCATION
prompt ================================
prompt
create table bj_cemetery.CEMETERY_LOCATION
(
  id                     NUMBER(20) not null,
  cemetery_location_code VARCHAR2(20),
  cemetery_type_id       NUMBER(20),
  status                 NUMBER(1),
  cemetery_zone_id       NUMBER(20),
  create_user_id         NUMBER(20),
  create_date            DATE,
  create_org_id          NUMBER(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.CEMETERY_LOCATION
  is '墓位信息';
comment on column bj_cemetery.CEMETERY_LOCATION.id
  is '主键';
comment on column bj_cemetery.CEMETERY_LOCATION.cemetery_location_code
  is '墓位编号';
comment on column bj_cemetery.CEMETERY_LOCATION.cemetery_type_id
  is '墓型ID';
comment on column bj_cemetery.CEMETERY_LOCATION.status
  is '墓位状态,1开发，2空闲，3锁定，4保留，5预定，6占有，7迁出';
comment on column bj_cemetery.CEMETERY_LOCATION.cemetery_zone_id
  is '区排id';
comment on column bj_cemetery.CEMETERY_LOCATION.create_user_id
  is '创建人id';
comment on column bj_cemetery.CEMETERY_LOCATION.create_date
  is '创建时间';
comment on column bj_cemetery.CEMETERY_LOCATION.create_org_id
  is '创建公墓id';
alter table bj_cemetery.CEMETERY_LOCATION
  add constraint CEMETERY_LOCATION_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.CEMETERY_LOCATION
  add constraint FK_CEMETERY_L_REF_CEMETERY_T foreign key (CEMETERY_TYPE_ID)
  references bj_cemetery.CEMETERY_TYPE (ID);
alter table bj_cemetery.CEMETERY_LOCATION
  add constraint FK_CEMETERY_Z_REF_CEMETERY_L foreign key (CEMETERY_ZONE_ID)
  references bj_cemetery.CEMETERY_ZONE (ID);

prompt
prompt Creating table CEMETERY_REGISTRY
prompt ================================
prompt
create table bj_cemetery.CEMETERY_REGISTRY
(
  id                     NUMBER(20) not null,
  cemetery_registry_code VARCHAR2(20),
  cemetery_registry_type NUMBER(1),
  name                   VARCHAR2(20),
  sex                    NUMBER(1),
  card_num               VARCHAR2(20),
  famliy_address         VARCHAR2(200),
  company_address        VARCHAR2(200),
  famliy_zip             VARCHAR2(20),
  company_tel            VARCHAR2(20),
  company_zip            VARCHAR2(20),
  famliy_tel             VARCHAR2(20),
  mobile_phone           VARCHAR2(20),
  email                  VARCHAR2(50),
  business_data_id       NUMBER(20),
  buydate                DATE,
  enddate                DATE,
  periods                NUMBER(20),
  cemetery_location_id   NUMBER(20),
  remark                 VARCHAR2(200),
  create_user_id         NUMBER(20),
  create_date            DATE,
  create_org_id          NUMBER(20),
  cemetery_price         NUMBER(20,2),
  other_price            NUMBER(20,2),
  total_price            NUMBER(20,2),
  discount_price         NUMBER(20,2),
  back_price             NUMBER(20,2),
  fact_price             NUMBER(20,2),
  debt                   NUMBER(20,2),
  nation                 VARCHAR2(20),
  nationality            VARCHAR2(20),
  card_type              VARCHAR2(20),
  province               VARCHAR2(20),
  county                 VARCHAR2(20),
  tomb_back              VARCHAR2(200),
  tomb_front             VARCHAR2(200),
  tomb_remark            VARCHAR2(200),
  is_oneself             NUMBER(1),
  agent_name             VARCHAR2(20),
  agent_tel              VARCHAR2(20),
  agent_reason           VARCHAR2(200),
  agent_prove            VARCHAR2(20),
  is_supply              NUMBER(1),
  back_reason            VARCHAR2(200)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.CEMETERY_REGISTRY
  is '业务登记';
comment on column bj_cemetery.CEMETERY_REGISTRY.id
  is '主键';
comment on column bj_cemetery.CEMETERY_REGISTRY.cemetery_registry_code
  is '业务编号';
comment on column bj_cemetery.CEMETERY_REGISTRY.cemetery_registry_type
  is '登记类型（1租用，2续租，3合葬，4迁出，5退墓）';
comment on column bj_cemetery.CEMETERY_REGISTRY.name
  is '登记人';
comment on column bj_cemetery.CEMETERY_REGISTRY.sex
  is '性别（1男，0女）';
comment on column bj_cemetery.CEMETERY_REGISTRY.card_num
  is '证件号码';
comment on column bj_cemetery.CEMETERY_REGISTRY.famliy_address
  is '家庭住址';
comment on column bj_cemetery.CEMETERY_REGISTRY.company_address
  is '单位地址';
comment on column bj_cemetery.CEMETERY_REGISTRY.famliy_zip
  is '家庭邮编';
comment on column bj_cemetery.CEMETERY_REGISTRY.company_tel
  is '单位电话';
comment on column bj_cemetery.CEMETERY_REGISTRY.company_zip
  is '单位邮编';
comment on column bj_cemetery.CEMETERY_REGISTRY.famliy_tel
  is '固定电话';
comment on column bj_cemetery.CEMETERY_REGISTRY.mobile_phone
  is '手机';
comment on column bj_cemetery.CEMETERY_REGISTRY.email
  is '电子邮件';
comment on column bj_cemetery.CEMETERY_REGISTRY.business_data_id
  is '业务分类';
comment on column bj_cemetery.CEMETERY_REGISTRY.buydate
  is '购墓时间';
comment on column bj_cemetery.CEMETERY_REGISTRY.enddate
  is '到期时间';
comment on column bj_cemetery.CEMETERY_REGISTRY.periods
  is '每期（年）';
comment on column bj_cemetery.CEMETERY_REGISTRY.cemetery_location_id
  is '墓位编号';
comment on column bj_cemetery.CEMETERY_REGISTRY.remark
  is '备注';
comment on column bj_cemetery.CEMETERY_REGISTRY.create_user_id
  is '创建人id';
comment on column bj_cemetery.CEMETERY_REGISTRY.create_date
  is '创建时间';
comment on column bj_cemetery.CEMETERY_REGISTRY.create_org_id
  is '公墓id';
comment on column bj_cemetery.CEMETERY_REGISTRY.cemetery_price
  is '墓穴价格';
comment on column bj_cemetery.CEMETERY_REGISTRY.other_price
  is '其他费用';
comment on column bj_cemetery.CEMETERY_REGISTRY.total_price
  is '应收费用';
comment on column bj_cemetery.CEMETERY_REGISTRY.discount_price
  is '优惠费用';
comment on column bj_cemetery.CEMETERY_REGISTRY.back_price
  is '退墓金额';
comment on column bj_cemetery.CEMETERY_REGISTRY.fact_price
  is '实收费用';
comment on column bj_cemetery.CEMETERY_REGISTRY.debt
  is '欠款';
comment on column bj_cemetery.CEMETERY_REGISTRY.nation
  is '民族';
comment on column bj_cemetery.CEMETERY_REGISTRY.nationality
  is '国籍';
comment on column bj_cemetery.CEMETERY_REGISTRY.card_type
  is '证件类型';
comment on column bj_cemetery.CEMETERY_REGISTRY.province
  is '户口所在地省';
comment on column bj_cemetery.CEMETERY_REGISTRY.county
  is '户口所在地县';
comment on column bj_cemetery.CEMETERY_REGISTRY.tomb_back
  is '碑后文字';
comment on column bj_cemetery.CEMETERY_REGISTRY.tomb_front
  is '碑前文字';
comment on column bj_cemetery.CEMETERY_REGISTRY.tomb_remark
  is '碑文说明';
comment on column bj_cemetery.CEMETERY_REGISTRY.is_oneself
  is '是否本人（1是0否）';
comment on column bj_cemetery.CEMETERY_REGISTRY.agent_name
  is '代理人姓名';
comment on column bj_cemetery.CEMETERY_REGISTRY.agent_tel
  is '代理人电话';
comment on column bj_cemetery.CEMETERY_REGISTRY.agent_reason
  is '代理原因';
comment on column bj_cemetery.CEMETERY_REGISTRY.agent_prove
  is '代理凭证';
comment on column bj_cemetery.CEMETERY_REGISTRY.is_supply
  is '是否补录';
comment on column bj_cemetery.CEMETERY_REGISTRY.back_reason
  is '退墓原因';
alter table bj_cemetery.CEMETERY_REGISTRY
  add constraint CEMETERY_REGISTRY_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.CEMETERY_REGISTRY
  add constraint FK_CEMETERY_R_REF_CEMETERY_L foreign key (CEMETERY_LOCATION_ID)
  references bj_cemetery.CEMETERY_LOCATION (ID);

prompt
prompt Creating table ARCHIVES_CEMETERY_REGISTRY
prompt =========================================
prompt
create table bj_cemetery.ARCHIVES_CEMETERY_REGISTRY
(
  id                     NUMBER(20) not null,
  cemetery_registry_code VARCHAR2(20),
  cemetery_registry_type NUMBER(1),
  name                   VARCHAR2(20),
  sex                    NUMBER(1),
  card_num               VARCHAR2(20),
  famliy_address         VARCHAR2(200),
  company_address        VARCHAR2(200),
  famliy_zip             VARCHAR2(20),
  company_tel            VARCHAR2(20),
  company_zip            VARCHAR2(20),
  famliy_tel             VARCHAR2(20),
  mobile_phone           VARCHAR2(20),
  email                  VARCHAR2(50),
  business_data_id       NUMBER(20),
  buydate                DATE,
  enddate                DATE,
  periods                NUMBER(20),
  cemetery_location_id   NUMBER(20),
  remark                 VARCHAR2(200),
  create_user_id         NUMBER(20),
  create_date            DATE,
  create_org_id          NUMBER(20),
  cemetery_price         NUMBER(20,2),
  other_price            NUMBER(20,2),
  total_price            NUMBER(20,2),
  discount_price         NUMBER(20,2),
  back_price             NUMBER(20,2),
  fact_price             NUMBER(20,2),
  debt                   NUMBER(20,2),
  nation                 VARCHAR2(20),
  nationality            VARCHAR2(20),
  card_type              VARCHAR2(20),
  province               VARCHAR2(20),
  county                 VARCHAR2(20),
  tomb_back              VARCHAR2(200),
  tomb_front             VARCHAR2(200),
  tomb_remark            VARCHAR2(200),
  is_oneself             NUMBER(1),
  agent_name             VARCHAR2(20),
  agent_tel              VARCHAR2(20),
  agent_reason           VARCHAR2(200),
  is_supply              NUMBER(1),
  agent_prove            VARCHAR2(20),
  cemetery_type_id       NUMBER(20),
  cemetery_zone_id       NUMBER(20),
  change_create_user_id  NUMBER(20),
  change_create_date     DATE,
  change_resone          VARCHAR2(200),
  change_remark          VARCHAR2(200),
  change_content         VARCHAR2(4000),
  back_reason            VARCHAR2(200)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.ARCHIVES_CEMETERY_REGISTRY
  is '归档信息业务登记';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.id
  is '主键';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.cemetery_registry_code
  is '业务编号';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.cemetery_registry_type
  is '登记类型（1租用，2续租，3合葬，4迁出，5退墓）';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.name
  is '登记人';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.sex
  is '性别（1男，0女）';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.card_num
  is '证件号码';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.famliy_address
  is '家庭住址';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.company_address
  is '单位地址';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.famliy_zip
  is '家庭邮编';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.company_tel
  is '单位电话';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.company_zip
  is '单位邮编';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.famliy_tel
  is '固定电话';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.mobile_phone
  is '手机';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.email
  is '电子邮件';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.business_data_id
  is '业务分类';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.buydate
  is '购墓时间';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.enddate
  is '到期时间';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.periods
  is '每期（年）';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.cemetery_location_id
  is '墓位编号';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.remark
  is '备注';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.create_user_id
  is '创建人id';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.create_date
  is '创建时间';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.create_org_id
  is '公墓id';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.cemetery_price
  is '墓穴价格';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.other_price
  is '其他费用';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.total_price
  is '应收费用';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.discount_price
  is '优惠费用';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.back_price
  is '退墓金额';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.fact_price
  is '实收费用';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.debt
  is '欠款';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.nation
  is '民族';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.nationality
  is '国籍';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.card_type
  is '证件类型';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.province
  is '户口所在地省';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.county
  is '户口所在市县';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.tomb_back
  is '碑后文字';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.tomb_front
  is '碑前文字';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.tomb_remark
  is '碑文说明';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.is_oneself
  is '是否本人(1是，0否)';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.agent_name
  is '代理人姓名';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.agent_tel
  is '代理人电话';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.agent_reason
  is '代理原因';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.is_supply
  is '是否补录';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.agent_prove
  is '代理凭证';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.cemetery_type_id
  is '墓型id（冗余字段用于统计）';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.cemetery_zone_id
  is '区排id（冗余字段用于统计）';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.change_create_user_id
  is '变更人id';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.change_create_date
  is '变更时间';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.change_resone
  is '变更原因';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.change_remark
  is '变更备注';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.change_content
  is '变更内容';
comment on column bj_cemetery.ARCHIVES_CEMETERY_REGISTRY.back_reason
  is '退墓原因';
alter table bj_cemetery.ARCHIVES_CEMETERY_REGISTRY
  add constraint ARCHIVES_CEMETERY_REGISTRY_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.ARCHIVES_CEMETERY_REGISTRY
  add constraint FK_ARCHIVES_REFERENCE_CEMETERY foreign key (CEMETERY_LOCATION_ID)
  references bj_cemetery.CEMETERY_LOCATION (ID);

prompt
prompt Creating table ARCHIVES_CEMETERY_CHARGE
prompt =======================================
prompt
create table bj_cemetery.ARCHIVES_CEMETERY_CHARGE
(
  id                            NUMBER(20) not null,
  product_name                  VARCHAR2(200),
  product_type                  VARCHAR2(20),
  price                         NUMBER(20,2),
  count                         NUMBER(10),
  receivable                    NUMBER(20,2),
  receive                       NUMBER(20,2),
  discount                      NUMBER(20,2),
  create_user_id                NUMBER(20),
  create_date                   DATE,
  create_org_id                 NUMBER(20),
  archives_cemetery_registry_id NUMBER(20),
  cemetery_commodity_id         NUMBER(20),
  out_storehouse_type           NUMBER(1),
  is_charge_type                NUMBER(1)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.ARCHIVES_CEMETERY_CHARGE
  is '归档收费信息';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.id
  is '主键';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.product_name
  is '商品名称';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.product_type
  is '商品类别';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.price
  is '单价';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.count
  is '数量';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.receivable
  is '应收款';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.receive
  is '本次收款';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.discount
  is '优惠价格';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.create_user_id
  is '创建人id';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.create_date
  is '创建时间';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.create_org_id
  is '公墓id';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.archives_cemetery_registry_id
  is '归档业务ID';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.cemetery_commodity_id
  is '公墓商品ID';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.out_storehouse_type
  is '出库类型1,售卖2，赠送，3损耗';
comment on column bj_cemetery.ARCHIVES_CEMETERY_CHARGE.is_charge_type
  is '是否是费用，1是(费用)，0否（商品）';
alter table bj_cemetery.ARCHIVES_CEMETERY_CHARGE
  add constraint ARCHIVES_CEMETERY_CHARGE_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.ARCHIVES_CEMETERY_CHARGE
  add constraint FK_ARCHIVES_REFERENCE_ARCHIVES foreign key (ARCHIVES_CEMETERY_REGISTRY_ID)
  references bj_cemetery.ARCHIVES_CEMETERY_REGISTRY (ID);

prompt
prompt Creating table ARCHIVES_CEMETERY_FILE
prompt =====================================
prompt
create table bj_cemetery.ARCHIVES_CEMETERY_FILE
(
  id             NUMBER(20) not null,
  file_name      VARCHAR2(50),
  file_size      NUMBER(20),
  file_type      VARCHAR2(20),
  file_path      VARCHAR2(200),
  fid            NUMBER(20),
  create_user_id NUMBER(20),
  create_date    DATE,
  create_org_id  NUMBER(20),
  remark         VARCHAR2(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.ARCHIVES_CEMETERY_FILE
  is '归档附件信息表';
comment on column bj_cemetery.ARCHIVES_CEMETERY_FILE.file_name
  is '文件名称';
comment on column bj_cemetery.ARCHIVES_CEMETERY_FILE.file_size
  is '文件大小';
comment on column bj_cemetery.ARCHIVES_CEMETERY_FILE.file_type
  is '文件类型';
comment on column bj_cemetery.ARCHIVES_CEMETERY_FILE.file_path
  is '文件路径';
comment on column bj_cemetery.ARCHIVES_CEMETERY_FILE.fid
  is '外键ID';
comment on column bj_cemetery.ARCHIVES_CEMETERY_FILE.create_user_id
  is '创建人id';
comment on column bj_cemetery.ARCHIVES_CEMETERY_FILE.create_date
  is '创建时间';
comment on column bj_cemetery.ARCHIVES_CEMETERY_FILE.create_org_id
  is '公墓id';
comment on column bj_cemetery.ARCHIVES_CEMETERY_FILE.remark
  is '备注';
alter table bj_cemetery.ARCHIVES_CEMETERY_FILE
  add constraint PK_ARCHIVES_CEMETERY_FILE primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.ARCHIVES_CEMETERY_FILE
  add constraint FK_ARCHIVES_FILE_REGISTRY foreign key (FID)
  references bj_cemetery.ARCHIVES_CEMETERY_REGISTRY (ID);

prompt
prompt Creating table ARCHIVES_DEPARTED
prompt ================================
prompt
create table bj_cemetery.ARCHIVES_DEPARTED
(
  id              NUMBER(20) not null,
  name            VARCHAR2(20),
  card_type       VARCHAR2(20),
  card_num        VARCHAR2(20),
  nationality     VARCHAR2(20),
  sex             NUMBER(1),
  age             NUMBER(3),
  nativeplace     VARCHAR2(50),
  nation          VARCHAR2(20),
  rentrelation    VARCHAR2(20),
  birth_date      DATE,
  dead_date       DATE,
  order_bury_date DATE,
  fact_bury_date  DATE,
  put_goods       VARCHAR2(200),
  worker          VARCHAR2(200),
  remark          VARCHAR2(200),
  create_user_id  NUMBER(20),
  create_date     DATE,
  create_org_id   NUMBER(20),
  id_card_num     VARCHAR2(20),
  funeral         VARCHAR2(200)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.ARCHIVES_DEPARTED
  is '归档逝者信息';
comment on column bj_cemetery.ARCHIVES_DEPARTED.id
  is '主键';
comment on column bj_cemetery.ARCHIVES_DEPARTED.name
  is '逝者姓名';
comment on column bj_cemetery.ARCHIVES_DEPARTED.card_type
  is '证件类型';
comment on column bj_cemetery.ARCHIVES_DEPARTED.card_num
  is '证件号码';
comment on column bj_cemetery.ARCHIVES_DEPARTED.nationality
  is '国籍';
comment on column bj_cemetery.ARCHIVES_DEPARTED.sex
  is '性别（1男，0女）';
comment on column bj_cemetery.ARCHIVES_DEPARTED.age
  is '年龄';
comment on column bj_cemetery.ARCHIVES_DEPARTED.nativeplace
  is '籍贯';
comment on column bj_cemetery.ARCHIVES_DEPARTED.nation
  is '民族';
comment on column bj_cemetery.ARCHIVES_DEPARTED.rentrelation
  is '与承租人关系';
comment on column bj_cemetery.ARCHIVES_DEPARTED.birth_date
  is '出生日期';
comment on column bj_cemetery.ARCHIVES_DEPARTED.dead_date
  is '辞世日期';
comment on column bj_cemetery.ARCHIVES_DEPARTED.order_bury_date
  is '预约安葬日期';
comment on column bj_cemetery.ARCHIVES_DEPARTED.fact_bury_date
  is '实际安葬日期';
comment on column bj_cemetery.ARCHIVES_DEPARTED.put_goods
  is '安防物';
comment on column bj_cemetery.ARCHIVES_DEPARTED.worker
  is '施工人';
comment on column bj_cemetery.ARCHIVES_DEPARTED.remark
  is '备注';
comment on column bj_cemetery.ARCHIVES_DEPARTED.create_user_id
  is '创建人id';
comment on column bj_cemetery.ARCHIVES_DEPARTED.create_date
  is '创建时间';
comment on column bj_cemetery.ARCHIVES_DEPARTED.create_org_id
  is '公墓id';
comment on column bj_cemetery.ARCHIVES_DEPARTED.id_card_num
  is '身份证';
comment on column bj_cemetery.ARCHIVES_DEPARTED.funeral
  is '火化殡仪馆';
alter table bj_cemetery.ARCHIVES_DEPARTED
  add constraint ARCHIVES_DEPARTED_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table ARC_CEMETERY_REGISTRY_DEPARTED
prompt =============================================
prompt
create table bj_cemetery.ARC_CEMETERY_REGISTRY_DEPARTED
(
  archives_cemetery_registry_id NUMBER(20) not null,
  archives_departed_id          NUMBER(20) not null
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.ARC_CEMETERY_REGISTRY_DEPARTED
  is '归档业务逝者关联表';
comment on column bj_cemetery.ARC_CEMETERY_REGISTRY_DEPARTED.archives_cemetery_registry_id
  is '归档业务ID';
comment on column bj_cemetery.ARC_CEMETERY_REGISTRY_DEPARTED.archives_departed_id
  is '归档逝者ID';
alter table bj_cemetery.ARC_CEMETERY_REGISTRY_DEPARTED
  add constraint FK_ARC_CEMETERY_REF_CEMETERY foreign key (ARCHIVES_CEMETERY_REGISTRY_ID)
  references bj_cemetery.ARCHIVES_CEMETERY_REGISTRY (ID);
alter table bj_cemetery.ARC_CEMETERY_REGISTRY_DEPARTED
  add constraint FK_ARC_CEMETERY_REF_DEPARTED foreign key (ARCHIVES_DEPARTED_ID)
  references bj_cemetery.ARCHIVES_DEPARTED (ID);

prompt
prompt Creating table CEMETERY_CERTIFICATE
prompt ===================================
prompt
create table bj_cemetery.CEMETERY_CERTIFICATE
(
  id                            NUMBER(20) not null,
  charge                        NUMBER(20,2),
  reason                        VARCHAR2(20),
  remark                        VARCHAR2(200),
  create_user_id                NUMBER(20),
  create_date                   DATE,
  create_org_id                 NUMBER(20),
  archives_cemetery_registry_id NUMBER(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.CEMETERY_CERTIFICATE
  is '补证';
comment on column bj_cemetery.CEMETERY_CERTIFICATE.id
  is '主键';
comment on column bj_cemetery.CEMETERY_CERTIFICATE.charge
  is '补证费用';
comment on column bj_cemetery.CEMETERY_CERTIFICATE.reason
  is '补证原因';
comment on column bj_cemetery.CEMETERY_CERTIFICATE.remark
  is '备注';
comment on column bj_cemetery.CEMETERY_CERTIFICATE.create_user_id
  is '操作人';
comment on column bj_cemetery.CEMETERY_CERTIFICATE.create_date
  is '操作时间';
comment on column bj_cemetery.CEMETERY_CERTIFICATE.create_org_id
  is '公墓机构ID';
comment on column bj_cemetery.CEMETERY_CERTIFICATE.archives_cemetery_registry_id
  is '业务办理ID';
alter table bj_cemetery.CEMETERY_CERTIFICATE
  add constraint PK_CEMETERY_CERTIFICATE primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.CEMETERY_CERTIFICATE
  add constraint FK_CEMETERY_C_REF_ARCHIVES foreign key (ARCHIVES_CEMETERY_REGISTRY_ID)
  references bj_cemetery.ARCHIVES_CEMETERY_REGISTRY (ID);

prompt
prompt Creating table CEMETERY_COMMODITY
prompt =================================
prompt
create table bj_cemetery.CEMETERY_COMMODITY
(
  id             NUMBER(20) not null,
  commodity_name VARCHAR2(200),
  commodity_type VARCHAR2(20),
  specifications VARCHAR2(20),
  in_price       NUMBER(20,2),
  count          NUMBER(10),
  out_price      NUMBER(20,2),
  create_user_id NUMBER(20),
  create_date    DATE,
  create_org_id  NUMBER(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.CEMETERY_COMMODITY
  is '公墓商品';
comment on column bj_cemetery.CEMETERY_COMMODITY.id
  is '主键';
comment on column bj_cemetery.CEMETERY_COMMODITY.commodity_name
  is '商品名称';
comment on column bj_cemetery.CEMETERY_COMMODITY.commodity_type
  is '商品类别';
comment on column bj_cemetery.CEMETERY_COMMODITY.specifications
  is '规格';
comment on column bj_cemetery.CEMETERY_COMMODITY.in_price
  is '进货单价';
comment on column bj_cemetery.CEMETERY_COMMODITY.count
  is '数量';
comment on column bj_cemetery.CEMETERY_COMMODITY.out_price
  is '销售价格';
comment on column bj_cemetery.CEMETERY_COMMODITY.create_user_id
  is '创建人id';
comment on column bj_cemetery.CEMETERY_COMMODITY.create_date
  is '创建时间';
comment on column bj_cemetery.CEMETERY_COMMODITY.create_org_id
  is '公墓id';
alter table bj_cemetery.CEMETERY_COMMODITY
  add constraint CEMETERY_COMMODITY_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CEMETERY_CHARGE
prompt ==============================
prompt
create table bj_cemetery.CEMETERY_CHARGE
(
  id                    NUMBER(20) not null,
  cemetery_registry_id  NUMBER(20),
  product_name          VARCHAR2(200),
  product_type          VARCHAR2(20),
  price                 NUMBER(20,2),
  count                 NUMBER(10),
  receivable            NUMBER(20,2),
  receive               NUMBER(20,2),
  discount              NUMBER(20,2),
  create_user_id        NUMBER(20),
  create_date           DATE,
  create_org_id         NUMBER(20),
  is_charge_type        NUMBER(1),
  out_storehouse_type   NUMBER(1),
  cemetery_commodity_id NUMBER(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.CEMETERY_CHARGE
  is '收费信息';
comment on column bj_cemetery.CEMETERY_CHARGE.id
  is '主键';
comment on column bj_cemetery.CEMETERY_CHARGE.cemetery_registry_id
  is '业务编号';
comment on column bj_cemetery.CEMETERY_CHARGE.product_name
  is '商品名称';
comment on column bj_cemetery.CEMETERY_CHARGE.product_type
  is '商品类别';
comment on column bj_cemetery.CEMETERY_CHARGE.price
  is '单价';
comment on column bj_cemetery.CEMETERY_CHARGE.count
  is '数量';
comment on column bj_cemetery.CEMETERY_CHARGE.receivable
  is '应收款';
comment on column bj_cemetery.CEMETERY_CHARGE.receive
  is '本次收款';
comment on column bj_cemetery.CEMETERY_CHARGE.discount
  is '优惠价格';
comment on column bj_cemetery.CEMETERY_CHARGE.create_user_id
  is '创建人id';
comment on column bj_cemetery.CEMETERY_CHARGE.create_date
  is '创建时间';
comment on column bj_cemetery.CEMETERY_CHARGE.create_org_id
  is '公墓id';
comment on column bj_cemetery.CEMETERY_CHARGE.is_charge_type
  is '是否是费用，1是(费用)，0否（商品）';
comment on column bj_cemetery.CEMETERY_CHARGE.out_storehouse_type
  is '出库类型1,售卖2，赠送，3损耗';
comment on column bj_cemetery.CEMETERY_CHARGE.cemetery_commodity_id
  is '公墓商品ID';
alter table bj_cemetery.CEMETERY_CHARGE
  add constraint CEMETERY_CHARGE_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.CEMETERY_CHARGE
  add constraint FK_CEMETERY_C_REF_CEMETERY_C foreign key (CEMETERY_COMMODITY_ID)
  references bj_cemetery.CEMETERY_COMMODITY (ID);
alter table bj_cemetery.CEMETERY_CHARGE
  add constraint FK_CEMETERY_C_REF_CEMETERY_R foreign key (CEMETERY_REGISTRY_ID)
  references bj_cemetery.CEMETERY_REGISTRY (ID);

prompt
prompt Creating table DEPARTED
prompt =======================
prompt
create table bj_cemetery.DEPARTED
(
  id                   NUMBER(20) not null,
  cemetery_registry_id NUMBER(20),
  name                 VARCHAR2(20),
  card_type            VARCHAR2(20),
  id_card_num          VARCHAR2(20),
  card_num             VARCHAR2(20),
  nationality          VARCHAR2(20),
  sex                  NUMBER(1),
  age                  NUMBER(3),
  nativeplace          VARCHAR2(50),
  nation               VARCHAR2(20),
  rentrelation         VARCHAR2(20),
  birth_date           DATE,
  dead_date            DATE,
  order_bury_date      DATE,
  fact_bury_date       DATE,
  funeral              VARCHAR2(200),
  put_goods            VARCHAR2(200),
  worker               VARCHAR2(200),
  remark               VARCHAR2(200),
  create_user_id       NUMBER(20),
  create_date          DATE,
  create_org_id        NUMBER(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.DEPARTED
  is '逝者信息';
comment on column bj_cemetery.DEPARTED.id
  is '主键';
comment on column bj_cemetery.DEPARTED.cemetery_registry_id
  is '业务编号';
comment on column bj_cemetery.DEPARTED.name
  is '逝者姓名';
comment on column bj_cemetery.DEPARTED.card_type
  is '证件类型';
comment on column bj_cemetery.DEPARTED.id_card_num
  is '身份证';
comment on column bj_cemetery.DEPARTED.card_num
  is '证件号码';
comment on column bj_cemetery.DEPARTED.nationality
  is '国籍';
comment on column bj_cemetery.DEPARTED.sex
  is '性别（1男，0女）';
comment on column bj_cemetery.DEPARTED.age
  is '年龄';
comment on column bj_cemetery.DEPARTED.nativeplace
  is '籍贯';
comment on column bj_cemetery.DEPARTED.nation
  is '民族';
comment on column bj_cemetery.DEPARTED.rentrelation
  is '与承租人关系';
comment on column bj_cemetery.DEPARTED.birth_date
  is '出生日期';
comment on column bj_cemetery.DEPARTED.dead_date
  is '辞世日期';
comment on column bj_cemetery.DEPARTED.order_bury_date
  is '预约安葬日期';
comment on column bj_cemetery.DEPARTED.fact_bury_date
  is '实际安葬日期';
comment on column bj_cemetery.DEPARTED.funeral
  is '火化殡仪馆';
comment on column bj_cemetery.DEPARTED.put_goods
  is '安防物';
comment on column bj_cemetery.DEPARTED.worker
  is '施工人';
comment on column bj_cemetery.DEPARTED.remark
  is '备注';
comment on column bj_cemetery.DEPARTED.create_user_id
  is '创建人id';
comment on column bj_cemetery.DEPARTED.create_date
  is '创建时间';
comment on column bj_cemetery.DEPARTED.create_org_id
  is '公墓id';
alter table bj_cemetery.DEPARTED
  add constraint DEPARTED_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CEMETERY_REGISTRY_DEPARTED
prompt =========================================
prompt
create table bj_cemetery.CEMETERY_REGISTRY_DEPARTED
(
  cemetery_registry_id NUMBER(20) not null,
  departed_id          NUMBER(20) not null
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.CEMETERY_REGISTRY_DEPARTED
  is '业务逝者关联表';
comment on column bj_cemetery.CEMETERY_REGISTRY_DEPARTED.cemetery_registry_id
  is '业务ID';
comment on column bj_cemetery.CEMETERY_REGISTRY_DEPARTED.departed_id
  is '逝者ID';
alter table bj_cemetery.CEMETERY_REGISTRY_DEPARTED
  add constraint FK_CEMETERY_REFERENCE_CEMETERY foreign key (CEMETERY_REGISTRY_ID)
  references bj_cemetery.CEMETERY_REGISTRY (ID);
alter table bj_cemetery.CEMETERY_REGISTRY_DEPARTED
  add constraint FK_CEMETERY_REFERENCE_DEPARTED foreign key (DEPARTED_ID)
  references bj_cemetery.DEPARTED (ID);

prompt
prompt Creating table CEMETERY_SERVICES
prompt ================================
prompt
create table bj_cemetery.CEMETERY_SERVICES
(
  id                            NUMBER(20) not null,
  item                          VARCHAR2(20),
  begindate                     DATE,
  enddate                       DATE,
  price                         NUMBER(20,2),
  contents                      VARCHAR2(200),
  remark                        VARCHAR2(200),
  create_user_id                NUMBER(20),
  create_date                   DATE,
  create_org_id                 NUMBER(20),
  archives_cemetery_registry_id NUMBER(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.CEMETERY_SERVICES
  is '服务事项';
comment on column bj_cemetery.CEMETERY_SERVICES.id
  is '主键';
comment on column bj_cemetery.CEMETERY_SERVICES.item
  is '服务事项';
comment on column bj_cemetery.CEMETERY_SERVICES.begindate
  is '服务开始时间';
comment on column bj_cemetery.CEMETERY_SERVICES.enddate
  is '服务结束时间';
comment on column bj_cemetery.CEMETERY_SERVICES.price
  is '服务费用';
comment on column bj_cemetery.CEMETERY_SERVICES.contents
  is '服务内容';
comment on column bj_cemetery.CEMETERY_SERVICES.remark
  is '备注';
comment on column bj_cemetery.CEMETERY_SERVICES.create_user_id
  is '操作人';
comment on column bj_cemetery.CEMETERY_SERVICES.create_date
  is '操作时间';
comment on column bj_cemetery.CEMETERY_SERVICES.create_org_id
  is '公墓机构ID';
comment on column bj_cemetery.CEMETERY_SERVICES.archives_cemetery_registry_id
  is '业务办理ID';
alter table bj_cemetery.CEMETERY_SERVICES
  add constraint PK_CEMETERY_SERVICES primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.CEMETERY_SERVICES
  add constraint FK_CEMETERY_S_REF_ARCHIVES foreign key (ARCHIVES_CEMETERY_REGISTRY_ID)
  references bj_cemetery.ARCHIVES_CEMETERY_REGISTRY (ID);

prompt
prompt Creating table CHARGE_DATA
prompt ==========================
prompt
create table bj_cemetery.CHARGE_DATA
(
  id                NUMBER(20) not null,
  charge_data_price NUMBER(20,2),
  charge_data_name  VARCHAR2(20),
  remark            VARCHAR2(200),
  is_validate       NUMBER(1),
  sort              NUMBER(10),
  create_user_id    NUMBER(20),
  create_date       DATE,
  create_org_id     NUMBER(20),
  charge_type_id    NUMBER(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.CHARGE_DATA
  is '费用明细';
comment on column bj_cemetery.CHARGE_DATA.id
  is '主键';
comment on column bj_cemetery.CHARGE_DATA.charge_data_price
  is '明细价格';
comment on column bj_cemetery.CHARGE_DATA.charge_data_name
  is '明细名称';
comment on column bj_cemetery.CHARGE_DATA.remark
  is '备注';
comment on column bj_cemetery.CHARGE_DATA.is_validate
  is '是否有效(1有效，0无效)';
comment on column bj_cemetery.CHARGE_DATA.sort
  is '排序';
comment on column bj_cemetery.CHARGE_DATA.create_user_id
  is '创建人 ID';
comment on column bj_cemetery.CHARGE_DATA.create_date
  is '创建时间';
comment on column bj_cemetery.CHARGE_DATA.create_org_id
  is '公墓id';
comment on column bj_cemetery.CHARGE_DATA.charge_type_id
  is '费用分类ID';
alter table bj_cemetery.CHARGE_DATA
  add constraint CHARGE_DATA_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table CHARGE_TYPE
prompt ==========================
prompt
create table bj_cemetery.CHARGE_TYPE
(
  id               NUMBER(20) not null,
  charge_type_name VARCHAR2(20),
  charge_type_dict VARCHAR2(20),
  remark           VARCHAR2(20),
  is_validate      NUMBER(20),
  sort             NUMBER(10),
  create_user_id   NUMBER(20),
  create_date      DATE,
  create_org_id    NUMBER(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.CHARGE_TYPE
  is '费用分类';
comment on column bj_cemetery.CHARGE_TYPE.id
  is '主键';
comment on column bj_cemetery.CHARGE_TYPE.charge_type_name
  is '分类名称';
comment on column bj_cemetery.CHARGE_TYPE.charge_type_dict
  is '所属类型';
comment on column bj_cemetery.CHARGE_TYPE.remark
  is '备注';
comment on column bj_cemetery.CHARGE_TYPE.is_validate
  is '是否有效(1,有效,0无效)';
comment on column bj_cemetery.CHARGE_TYPE.sort
  is '排序';
comment on column bj_cemetery.CHARGE_TYPE.create_user_id
  is '创建人id';
comment on column bj_cemetery.CHARGE_TYPE.create_date
  is '创建时间';
comment on column bj_cemetery.CHARGE_TYPE.create_org_id
  is '公墓机构id';
alter table bj_cemetery.CHARGE_TYPE
  add constraint PK_CHARGE_TYPE primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table DICT
prompt ===================
prompt
create table bj_cemetery.DICT
(
  id          NUMBER(20) not null,
  dict_code   VARCHAR2(20),
  dict_name   VARCHAR2(20),
  remark      VARCHAR2(200),
  is_validate NUMBER(1),
  sort        NUMBER(10),
  pid         NUMBER(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.DICT
  is '字典项';
comment on column bj_cemetery.DICT.id
  is '主键';
comment on column bj_cemetery.DICT.dict_code
  is '字典编码';
comment on column bj_cemetery.DICT.dict_name
  is '字典名称';
comment on column bj_cemetery.DICT.remark
  is '备注';
comment on column bj_cemetery.DICT.is_validate
  is '是否有效(1有效，0无效)';
comment on column bj_cemetery.DICT.sort
  is '排序';
comment on column bj_cemetery.DICT.pid
  is '所属父分类id';
alter table bj_cemetery.DICT
  add constraint DICT_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.DICT
  add constraint FK_DICT_REFERENCE_DICT foreign key (PID)
  references bj_cemetery.DICT (ID);
create unique index bj_cemetery.DICT_CODE on bj_cemetery.DICT (DICT_CODE)
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table GOS_APPFUN_URL
prompt =============================
prompt
create table bj_cemetery.GOS_APPFUN_URL
(
  id           NUMBER(19) not null,
  url          VARCHAR2(256),
  match_type   NUMBER(1),
  notes        VARCHAR2(128),
  moduletype   NUMBER(1),
  module       NUMBER(2),
  functiontype NUMBER(2),
  description  VARCHAR2(64),
  content_type NUMBER(1)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 512K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.GOS_APPFUN_URL
  is '日志配置表';
comment on column bj_cemetery.GOS_APPFUN_URL.match_type
  is '0,url不匹配,1rul匹配开头,2,全匹配';
comment on column bj_cemetery.GOS_APPFUN_URL.notes
  is '备注';
comment on column bj_cemetery.GOS_APPFUN_URL.moduletype
  is '模块类型1)内网2)外网';
comment on column bj_cemetery.GOS_APPFUN_URL.module
  is '系统:1)优抚管理系统,2)婚姻登记管理系统,3)救灾捐赠管理系统,4)殡葬火化费补助管理系统,5)救灾物资管理系统';
comment on column bj_cemetery.GOS_APPFUN_URL.functiontype
  is '系统模块:1)用户登陆,2)业务办理';
comment on column bj_cemetery.GOS_APPFUN_URL.description
  is '功能描述';
comment on column bj_cemetery.GOS_APPFUN_URL.content_type
  is '1:记录全部请求内容';

prompt
prompt Creating table GOS_APPLOG
prompt =========================
prompt
create table bj_cemetery.GOS_APPLOG
(
  id          NUMBER(9) not null,
  info        VARCHAR2(1000),
  modulename  VARCHAR2(50),
  platformid  NUMBER(10) default 10,
  userid      NUMBER(19),
  username    VARCHAR2(20),
  apenddate   DATE,
  operatetype NUMBER(10) default 50
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 4M
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.GOS_APPLOG
  add primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 960K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table GOS_DEPT
prompt =======================
prompt
create table bj_cemetery.GOS_DEPT
(
  id                NUMBER(25) not null,
  num               VARCHAR2(100),
  name              VARCHAR2(100) not null,
  cat               VARCHAR2(50),
  levelid           NUMBER(25) not null,
  createdate        DATE not null,
  creatorid         NUMBER(25) not null,
  description       VARCHAR2(500),
  bzsm              NUMBER(10),
  syrs              NUMBER(10),
  faren             NUMBER(25),
  bzxs              VARCHAR2(50),
  ldzzs             NUMBER(5),
  ldfzs             NUMBER(5),
  jfxs              VARCHAR2(50),
  shortname         VARCHAR2(10),
  frzhengshu        VARCHAR2(100),
  officephone       VARCHAR2(50),
  officecode        VARCHAR2(50),
  officeaddr        VARCHAR2(160),
  officeduty        VARCHAR2(50),
  regionid          NUMBER(25),
  disporder         VARCHAR2(4),
  officetime        VARCHAR2(100),
  traffictype       VARCHAR2(50),
  officemail        VARCHAR2(100),
  parent_id         NUMBER(32),
  role_lev          NUMBER(32),
  use_flag          NUMBER(1),
  contact_person    VARCHAR2(40),
  email             VARCHAR2(40),
  header            VARCHAR2(40),
  salvation_flag    VARCHAR2(2),
  old_unit_id       NUMBER(10),
  dept_type         NUMBER(1),
  approve_unit_code VARCHAR2(20),
  tree_node         NUMBER(2),
  low_flag          NUMBER(1)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 2M
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on column bj_cemetery.GOS_DEPT.id
  is '机构ID';
comment on column bj_cemetery.GOS_DEPT.name
  is '机构名称';
comment on column bj_cemetery.GOS_DEPT.levelid
  is '机构级别';
comment on column bj_cemetery.GOS_DEPT.officephone
  is '电话';
comment on column bj_cemetery.GOS_DEPT.officeaddr
  is '地址';
comment on column bj_cemetery.GOS_DEPT.regionid
  is '所属区域';
comment on column bj_cemetery.GOS_DEPT.disporder
  is '顺序号';
comment on column bj_cemetery.GOS_DEPT.parent_id
  is '上级机构ID';
comment on column bj_cemetery.GOS_DEPT.role_lev
  is '领导，1；市级：2；区县：3；委办：4；街道（乡镇）： 5；社区（村）';
comment on column bj_cemetery.GOS_DEPT.use_flag
  is '使用标识[0，不启用；1，启用]';
comment on column bj_cemetery.GOS_DEPT.contact_person
  is '				联系人				';
comment on column bj_cemetery.GOS_DEPT.email
  is 'EMAIL';
comment on column bj_cemetery.GOS_DEPT.header
  is '			负责人';
comment on column bj_cemetery.GOS_DEPT.salvation_flag
  is '	''1''		机构类型(是否救助机构标志)，0--不是救助机构，1--是救助机构';
comment on column bj_cemetery.GOS_DEPT.old_unit_id
  is '原低保系统中组织机构ID';
comment on column bj_cemetery.GOS_DEPT.dept_type
  is '单位属性（民政科为1，其他为0）';
comment on column bj_cemetery.GOS_DEPT.approve_unit_code
  is '审批单元表示（级别+编号）';
comment on column bj_cemetery.GOS_DEPT.tree_node
  is '树节点值（0根节点；1叶节点，2孙节点...）';
comment on column bj_cemetery.GOS_DEPT.low_flag
  is '救助机构标识(1,低保;2社救;0其他)';
alter table bj_cemetery.GOS_DEPT
  add constraint PK_GOS_DEPT_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 320K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table GOS_REGION
prompt =========================
prompt
create table bj_cemetery.GOS_REGION
(
  id                NUMBER(25) not null,
  name              VARCHAR2(100),
  levelid           NUMBER(25),
  description       VARCHAR2(100),
  createdate        DATE,
  creatorid         NUMBER(25),
  parentid          NUMBER(25),
  num               VARCHAR2(100),
  shortname         VARCHAR2(50),
  disporder         VARCHAR2(2),
  standard_no       VARCHAR2(20),
  use_flag          NUMBER(1),
  old_dictionary_id VARCHAR2(30),
  convert_id        VARCHAR2(30),
  people_num        NUMBER(10)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 2M
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.GOS_REGION
  is '区域表';
comment on column bj_cemetery.GOS_REGION.id
  is '区域ID';
comment on column bj_cemetery.GOS_REGION.name
  is '区域名称';
comment on column bj_cemetery.GOS_REGION.levelid
  is '区域级别';
comment on column bj_cemetery.GOS_REGION.description
  is '描述';
comment on column bj_cemetery.GOS_REGION.createdate
  is '创建日期';
comment on column bj_cemetery.GOS_REGION.creatorid
  is '创建机构';
comment on column bj_cemetery.GOS_REGION.parentid
  is '上级区域ID';
comment on column bj_cemetery.GOS_REGION.disporder
  is '顺序号';
comment on column bj_cemetery.GOS_REGION.standard_no
  is '国标、省标、市标或外部标准编码';
comment on column bj_cemetery.GOS_REGION.use_flag
  is '使用标志';
comment on column bj_cemetery.GOS_REGION.old_dictionary_id
  is '原低保系统字典id';
comment on column bj_cemetery.GOS_REGION.convert_id
  is '新系统RegionID，旧系统数据导入时专用，解决多对一';
comment on column bj_cemetery.GOS_REGION.people_num
  is '各区县非农业人口总数';
alter table bj_cemetery.GOS_REGION
  add constraint PK_GOS_REGION_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 192K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table GOS_ROLE
prompt =======================
prompt
create table bj_cemetery.GOS_ROLE
(
  id          NUMBER(25) not null,
  name        VARCHAR2(120) not null,
  createdate  DATE not null,
  creatorid   NUMBER(25) not null,
  description VARCHAR2(500),
  priority    VARCHAR2(2000),
  dept_id     NUMBER(25),
  old_role_id NUMBER(10)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on column bj_cemetery.GOS_ROLE.description
  is '描述';
comment on column bj_cemetery.GOS_ROLE.dept_id
  is '单位Id';
comment on column bj_cemetery.GOS_ROLE.old_role_id
  is '原低保系统中的角色ID';
alter table bj_cemetery.GOS_ROLE
  add constraint PK_GOS_ROLE_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table GOS_USER
prompt =======================
prompt
create table bj_cemetery.GOS_USER
(
  id              NUMBER(25) not null,
  loginid         VARCHAR2(100),
  password        VARCHAR2(50),
  name            VARCHAR2(20) not null,
  gender          VARCHAR2(10) not null,
  deptid          NUMBER(25) not null,
  num             VARCHAR2(100),
  jiguan          VARCHAR2(50),
  birthday        DATE,
  birthlocation   VARCHAR2(200),
  nation          VARCHAR2(20),
  xueli           VARCHAR2(50),
  xuewei          VARCHAR2(50),
  zhuanye         VARCHAR2(200),
  yuanxiao        VARCHAR2(200),
  zhengzhimianmao VARCHAR2(20),
  rudangshijian   DATE,
  workyear        DATE,
  callname        VARCHAR2(100),
  positionid      VARCHAR2(100),
  identitynum     VARCHAR2(100),
  worknum         VARCHAR2(100),
  address         VARCHAR2(100),
  homephone       VARCHAR2(100),
  officephone     VARCHAR2(100),
  mobile          VARCHAR2(100),
  publicmoneynum  VARCHAR2(100),
  oldsupportnum   VARCHAR2(100),
  housepaynum     VARCHAR2(100),
  securitynum     VARCHAR2(100),
  createdate      DATE not null,
  creatorid       NUMBER(25) not null,
  priority        VARCHAR2(4000),
  memo            VARCHAR2(500),
  deleted         NUMBER(1) default 0,
  biyetime        DATE,
  xzyear          DATE,
  retire          VARCHAR2(10),
  registstatus    NUMBER(2) default 0,
  deletereason    VARCHAR2(100),
  workdeptid      NUMBER(25),
  type            NUMBER(2),
  canumber        VARCHAR2(100),
  emailid         VARCHAR2(50),
  cansms          NUMBER(1) default 0,
  old_user_id     NUMBER(10),
  role_id         NUMBER(10),
  user_flag       NUMBER(1) default 1,
  dept_name       VARCHAR2(20),
  right_name      VARCHAR2(100),
  system_role     VARCHAR2(100)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 2M
    next 8K
    minextents 1
    maxextents unlimited
  );
comment on column bj_cemetery.GOS_USER.name
  is '姓名';
comment on column bj_cemetery.GOS_USER.gender
  is '性别';
comment on column bj_cemetery.GOS_USER.deptid
  is '单位ID';
comment on column bj_cemetery.GOS_USER.num
  is '人员编号';
comment on column bj_cemetery.GOS_USER.jiguan
  is '籍贯';
comment on column bj_cemetery.GOS_USER.birthday
  is '出生日期';
comment on column bj_cemetery.GOS_USER.birthlocation
  is '出生地';
comment on column bj_cemetery.GOS_USER.nation
  is '民族';
comment on column bj_cemetery.GOS_USER.xueli
  is '学历';
comment on column bj_cemetery.GOS_USER.xuewei
  is '学位';
comment on column bj_cemetery.GOS_USER.zhuanye
  is '所学专业';
comment on column bj_cemetery.GOS_USER.yuanxiao
  is '毕业院校及时间';
comment on column bj_cemetery.GOS_USER.zhengzhimianmao
  is '政治面貌';
comment on column bj_cemetery.GOS_USER.rudangshijian
  is '入党/团时间';
comment on column bj_cemetery.GOS_USER.workyear
  is '参加工作时间';
comment on column bj_cemetery.GOS_USER.callname
  is '职称';
comment on column bj_cemetery.GOS_USER.positionid
  is '职务';
comment on column bj_cemetery.GOS_USER.identitynum
  is '身份证号';
comment on column bj_cemetery.GOS_USER.worknum
  is '工作证号';
comment on column bj_cemetery.GOS_USER.address
  is '家庭住址';
comment on column bj_cemetery.GOS_USER.homephone
  is '住宅电话';
comment on column bj_cemetery.GOS_USER.officephone
  is '办公电话';
comment on column bj_cemetery.GOS_USER.mobile
  is '移动电话';
comment on column bj_cemetery.GOS_USER.publicmoneynum
  is '公积金号';
comment on column bj_cemetery.GOS_USER.oldsupportnum
  is '养老保险号';
comment on column bj_cemetery.GOS_USER.housepaynum
  is '住房补贴号';
comment on column bj_cemetery.GOS_USER.securitynum
  is '医疗保险号';
comment on column bj_cemetery.GOS_USER.registstatus
  is '0代表新注册、1代表部门领导审批、2代表通过最终审批';
comment on column bj_cemetery.GOS_USER.role_id
  is '角色ID';
comment on column bj_cemetery.GOS_USER.user_flag
  is '有效标识[0,无效；1，有效]';
comment on column bj_cemetery.GOS_USER.dept_name
  is '部门名称[社救科科长、社救科副科长、社救科科员、区县本级、民政科科长、民政科副科长、民政科科员、街道本级、社保所所长、社保所职员、办事处处长，办事处副处长，办事处科员、管理科科长、管理科科员；]';
comment on column bj_cemetery.GOS_USER.right_name
  is '权限名称[领导、城市专干、农村专干、管理员]';
comment on column bj_cemetery.GOS_USER.system_role
  is '系统角色(平台使用)';
alter table bj_cemetery.GOS_USER
  add constraint PK1_GOS_USER_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 128K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.GOS_USER
  add constraint PK1_UNI_GOS_USER_CANUMBER unique (CANUMBER)
  disable;

prompt
prompt Creating table GOS_USEREXT
prompt ==========================
prompt
create table bj_cemetery.GOS_USEREXT
(
  id            NUMBER(25) not null,
  issuperman    NUMBER(1) default 0 not null,
  issubman      NUMBER(1) default 0 not null,
  isdeptman     NUMBER(1) default 0 not null,
  islogman      NUMBER(1) default 0 not null,
  subcreatorid  NUMBER(25),
  logcreatorid  NUMBER(25),
  deptcreatorid NUMBER(25),
  substr        VARCHAR2(4000),
  deptstr       VARCHAR2(1000),
  logstr        VARCHAR2(1000),
  priority      VARCHAR2(2000)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 256K
    next 1M
    minextents 1
    maxextents unlimited
  );
alter table bj_cemetery.GOS_USEREXT
  add constraint GOS_USEREXT_PRI_ID primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table SJZD_NODE
prompt ========================
prompt
create table bj_cemetery.SJZD_NODE
(
  id            NUMBER(20) not null,
  parentid      NUMBER(20),
  node_name     VARCHAR2(200),
  node_typename VARCHAR2(100),
  node_level    NUMBER(20),
  node_value    VARCHAR2(100),
  node_index    NUMBER(20),
  institutionid VARCHAR2(100),
  state         NUMBER(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 384K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table VISIT_RETURN
prompt ===========================
prompt
create table bj_cemetery.VISIT_RETURN
(
  id              NUMBER(20) not null,
  customer_name   VARCHAR2(50),
  customer_tel    VARCHAR2(20),
  customer_source VARCHAR2(200),
  customer_num    NUMBER(10),
  customer_req    VARCHAR2(1000),
  is_return       NUMBER(1),
  create_user_id  NUMBER(20),
  create_date     DATE,
  remark          VARCHAR2(1000),
  return_remark   VARCHAR2(1000),
  return_user_id  NUMBER(20),
  return_date     DATE,
  create_org_id   NUMBER(20)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );
comment on table bj_cemetery.VISIT_RETURN
  is '来访信息';
comment on column bj_cemetery.VISIT_RETURN.id
  is '主键';
comment on column bj_cemetery.VISIT_RETURN.customer_name
  is '客户姓名';
comment on column bj_cemetery.VISIT_RETURN.customer_tel
  is '联系电话';
comment on column bj_cemetery.VISIT_RETURN.customer_source
  is '客户来源';
comment on column bj_cemetery.VISIT_RETURN.customer_num
  is '来访人数';
comment on column bj_cemetery.VISIT_RETURN.customer_req
  is '客户来访需求';
comment on column bj_cemetery.VISIT_RETURN.is_return
  is '是否已经回访（1是，0否）';
comment on column bj_cemetery.VISIT_RETURN.create_user_id
  is '操作人ID';
comment on column bj_cemetery.VISIT_RETURN.create_date
  is '操作时间';
comment on column bj_cemetery.VISIT_RETURN.remark
  is '备注';
comment on column bj_cemetery.VISIT_RETURN.return_remark
  is '回访情况';
comment on column bj_cemetery.VISIT_RETURN.return_user_id
  is '回访人ID';
comment on column bj_cemetery.VISIT_RETURN.return_date
  is '回访时间';
comment on column bj_cemetery.VISIT_RETURN.create_org_id
  is '公墓机构ID';
alter table bj_cemetery.VISIT_RETURN
  add constraint PK_VISIT_RETURN primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    next 1M
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence ARCHIVES_CEMETERY_CHARGE_SEQ
prompt ==============================================
prompt
create sequence bj_cemetery.ARCHIVES_CEMETERY_CHARGE_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 181
increment by 1
cache 20;

prompt
prompt Creating sequence ARCHIVES_CEMETERY_FILE_SEQ
prompt ============================================
prompt
create sequence bj_cemetery.ARCHIVES_CEMETERY_FILE_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 121
increment by 1
cache 20;

prompt
prompt Creating sequence ARCHIVES_CEMETERY_REGISTRY_SEQ
prompt ================================================
prompt
create sequence bj_cemetery.ARCHIVES_CEMETERY_REGISTRY_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 221
increment by 1
cache 20;

prompt
prompt Creating sequence ARCHIVES_DEPARTED_SEQ
prompt =======================================
prompt
create sequence bj_cemetery.ARCHIVES_DEPARTED_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 181
increment by 1
cache 20;

prompt
prompt Creating sequence BUSINESS_DATA_SEQ
prompt ===================================
prompt
create sequence bj_cemetery.BUSINESS_DATA_SEQ
minvalue 1
maxvalue 999999999999
start with 101
increment by 1
cache 20;

prompt
prompt Creating sequence CEMETERY_CERTIFICATE_SEQ
prompt ==========================================
prompt
create sequence bj_cemetery.CEMETERY_CERTIFICATE_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 121
increment by 1
cache 20;

prompt
prompt Creating sequence CEMETERY_CHARGE_DATA_SEQ
prompt ==========================================
prompt
create sequence bj_cemetery.CEMETERY_CHARGE_DATA_SEQ
minvalue 1
maxvalue 999999999999
start with 21
increment by 1
cache 20;

prompt
prompt Creating sequence CEMETERY_CHARGE_SEQ
prompt =====================================
prompt
create sequence bj_cemetery.CEMETERY_CHARGE_SEQ
minvalue 1
maxvalue 999999999999
start with 321
increment by 1
cache 20;

prompt
prompt Creating sequence CEMETERY_COMMODITY_SEQ
prompt ========================================
prompt
create sequence bj_cemetery.CEMETERY_COMMODITY_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 121
increment by 1
cache 20;

prompt
prompt Creating sequence CEMETERY_FILE_SEQ
prompt ===================================
prompt
create sequence bj_cemetery.CEMETERY_FILE_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 261
increment by 1
cache 20;

prompt
prompt Creating sequence CEMETERY_LOCATION_SEQ
prompt =======================================
prompt
create sequence bj_cemetery.CEMETERY_LOCATION_SEQ
minvalue 1
maxvalue 999999999999
start with 1091
increment by 1
cache 20;

prompt
prompt Creating sequence CEMETERY_LOCATION_SERIAL
prompt ==========================================
prompt
create sequence bj_cemetery.CEMETERY_LOCATION_SERIAL
minvalue 1
maxvalue 9999999999999999999999999999
start with 1221
increment by 1
cache 20;

prompt
prompt Creating sequence CEMETERY_REGISTRY_DEPARTED_SEQ
prompt ================================================
prompt
create sequence bj_cemetery.CEMETERY_REGISTRY_DEPARTED_SEQ
minvalue 1
maxvalue 99999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence CEMETERY_REGISTRY_SEQ
prompt =======================================
prompt
create sequence bj_cemetery.CEMETERY_REGISTRY_SEQ
minvalue 1
maxvalue 999999999999
start with 301
increment by 1
cache 20;

prompt
prompt Creating sequence CEMETERY_SERVICES_SEQ
prompt =======================================
prompt
create sequence bj_cemetery.CEMETERY_SERVICES_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 81
increment by 1
cache 20;

prompt
prompt Creating sequence CEMETERY_TYPE_SEQ
prompt ===================================
prompt
create sequence bj_cemetery.CEMETERY_TYPE_SEQ
minvalue 1
maxvalue 999999999999
start with 221
increment by 1
cache 20;

prompt
prompt Creating sequence CEMETERY_ZONE_SEQ
prompt ===================================
prompt
create sequence bj_cemetery.CEMETERY_ZONE_SEQ
minvalue 1
maxvalue 999999999999
start with 161
increment by 1
cache 20;

prompt
prompt Creating sequence CHARGE_DATA_SEQ
prompt =================================
prompt
create sequence bj_cemetery.CHARGE_DATA_SEQ
minvalue 1
maxvalue 999999999999
start with 121
increment by 1
cache 20;

prompt
prompt Creating sequence CHARGE_TYPE_SEQ
prompt =================================
prompt
create sequence bj_cemetery.CHARGE_TYPE_SEQ
minvalue 1
maxvalue 999999999999
start with 141
increment by 1
cache 20;

prompt
prompt Creating sequence DEPARTED_SEQ
prompt ==============================
prompt
create sequence bj_cemetery.DEPARTED_SEQ
minvalue 1
maxvalue 999999999999
start with 321
increment by 1
cache 20;

prompt
prompt Creating sequence DICT_SEQ
prompt ==========================
prompt
create sequence bj_cemetery.DICT_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 61
increment by 1
cache 20;

prompt
prompt Creating sequence GOS_APPFUN_URL_SEQ
prompt ====================================
prompt
create sequence bj_cemetery.GOS_APPFUN_URL_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 1000
increment by 1
cache 10;

prompt
prompt Creating sequence GOS_APPLOG_SEQ
prompt ================================
prompt
create sequence bj_cemetery.GOS_APPLOG_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 448943
increment by 1
nocache;

prompt
prompt Creating sequence GOS_DEPT_SEQ
prompt ==============================
prompt
create sequence bj_cemetery.GOS_DEPT_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 12022945
increment by 1
cache 20;

prompt
prompt Creating sequence GOS_REGION_SEQ
prompt ================================
prompt
create sequence bj_cemetery.GOS_REGION_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 11862
increment by 1
cache 20;

prompt
prompt Creating sequence GOS_ROLE_SEQ
prompt ==============================
prompt
create sequence bj_cemetery.GOS_ROLE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 1521
increment by 1
cache 20;

prompt
prompt Creating sequence GOS_USEREXT_SEQ
prompt =================================
prompt
create sequence bj_cemetery.GOS_USEREXT_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 4962
increment by 1
cache 20;

prompt
prompt Creating sequence GOS_USER_SEQ
prompt ==============================
prompt
create sequence bj_cemetery.GOS_USER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 12023187
increment by 1
cache 20;

prompt
prompt Creating sequence REGISTRY_BURIED_SERIAL
prompt ========================================
prompt
create sequence bj_cemetery.REGISTRY_BURIED_SERIAL
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence REGISTRY_EXIT_SERIAL
prompt ======================================
prompt
create sequence bj_cemetery.REGISTRY_EXIT_SERIAL
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence REGISTRY_OUTSIDE_SERIAL
prompt =========================================
prompt
create sequence bj_cemetery.REGISTRY_OUTSIDE_SERIAL
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence REGISTRY_RENEW_SERIAL
prompt =======================================
prompt
create sequence bj_cemetery.REGISTRY_RENEW_SERIAL
minvalue 1
maxvalue 9999999999999999999999999999
start with 1
increment by 1
cache 20;

prompt
prompt Creating sequence REGISTRY_RENT_SERIAL
prompt ======================================
prompt
create sequence bj_cemetery.REGISTRY_RENT_SERIAL
minvalue 1
maxvalue 9999
start with 424
increment by 1
cache 20
cycle;

prompt
prompt Creating sequence VISIT_RETURN_SEQ
prompt ==================================
prompt
create sequence bj_cemetery.VISIT_RETURN_SEQ
minvalue 1
maxvalue 9999999999999999999999999999
start with 142
increment by 1
cache 20;

prompt
prompt Creating view CAVE_USER_CASE_VIEW
prompt =================================
prompt
create or replace view bj_cemetery.cave_user_case_view as
select sum_area.org_id,
       sum_area.property_name property_name,
       now_area.now_area now_area,
       up_now_area.up_now_area up_now_area,
       year_area.year_area year_area,
       sum_area.sum_area sum_area,
       now_fact_price.now_fact_price now_fact_price,
       now_fact_price.now_fact_price / now_location.now_location now_location,
       now_fact_price.now_fact_price / now_cave.now_cave now_cave
  from (
        /*总累计面积*/
        select sum(ct.area) sum_area,
                ct.create_org_id org_id,
                d.dict_name property_name,
                d.dict_code property
          from archives_cemetery_registry acr, cemetery_type ct, dict d
         where acr.cemetery_type_id = ct.id
           and ct.cemetery_property = d.dict_code
         group by ct.create_org_id, d.dict_code, d.dict_name

        ) sum_area
  left join (
             /*本年面积*/
             select sum(ct.area) year_area,
                     ct.create_org_id org_id,
                     d.dict_name property_name,
                     d.dict_code property
               from archives_cemetery_registry acr, cemetery_type ct, dict d
              where acr.cemetery_type_id = ct.id
                and ct.cemetery_property = d.dict_code
                and acr.create_date >= trunc(sysdate, 'yyyy')
                and acr.create_date <=
                    add_months(trunc(sysdate, 'yyyy'), 12) - 1
              group by ct.create_org_id, d.dict_code, d.dict_name

             ) year_area

    on sum_area.org_id = year_area.org_id
   and sum_area.property_name = year_area.property_name
   and sum_area.property = year_area.property

  left join (
             /*去年本月同期面积*/
             select sum(ct.area) up_now_area,
                     ct.create_org_id org_id,
                     d.dict_name property_name,
                     d.dict_code property
               from archives_cemetery_registry acr, cemetery_type ct, dict d
              where acr.cemetery_type_id = ct.id
                and ct.cemetery_property = d.dict_code
                and acr.create_date >= trunc(add_months(sysdate, -12), 'MM')
                and acr.create_date <= last_day(add_months(sysdate, -12))
              group by ct.create_org_id, d.dict_code, d.dict_name

             ) up_now_area

    on sum_area.org_id = up_now_area.org_id
   and sum_area.property_name = up_now_area.property_name
   and sum_area.property = up_now_area.property

  left join (
             /*本月面积*/
             select sum(ct.area) now_area,
                     ct.create_org_id org_id,
                     d.dict_name property_name,
                     d.dict_code property
               from archives_cemetery_registry acr, cemetery_type ct, dict d
              where acr.cemetery_type_id = ct.id
                and ct.cemetery_property = d.dict_code
                and acr.create_date >= trunc(sysdate, 'MM')
                and acr.create_date <= last_day(sysdate)
              group by ct.create_org_id, d.dict_code, d.dict_name

             ) now_area

    on sum_area.org_id = now_area.org_id
   and sum_area.property_name = now_area.property_name
   and sum_area.property = now_area.property

  left join

 (
  /*本月总收入*/
  select sum(acr.FACT_PRICE) now_fact_price,
          ct.create_org_id org_id,
          d.dict_name property_name,
          d.dict_code property
    from archives_cemetery_registry acr, cemetery_type ct, dict d
   where acr.cemetery_type_id = ct.id
     and ct.cemetery_property = d.dict_code
     and acr.create_date >= trunc(sysdate, 'MM')
     and acr.create_date <= last_day(sysdate)
   group by ct.create_org_id, d.dict_code, d.dict_name

  ) now_fact_price

    on sum_area.org_id = now_fact_price.org_id
   and sum_area.property_name = now_fact_price.property_name
   and sum_area.property = now_fact_price.property

  left join (
             /*本月墓位数*/
             select count(acr.id) now_location,
                     ct.create_org_id org_id,
                     d.dict_name property_name,
                     d.dict_code property
               from archives_cemetery_registry acr, cemetery_type ct, dict d
              where acr.cemetery_type_id = ct.id
                and acr.create_date >= trunc(sysdate, 'MM')
                and ct.cemetery_property = d.dict_code
                and acr.create_date <= last_day(sysdate)
              group by ct.create_org_id, d.dict_code, d.dict_name

             ) now_location

    on sum_area.org_id = now_location.org_id
   and sum_area.property_name = now_location.property_name
   and sum_area.property = now_location.property

  left join (
             /*本月墓穴数*/
             select sum(ct.cave) now_cave,
                     ct.create_org_id org_id,
                     d.dict_name property_name,
                     d.dict_code property
               from archives_cemetery_registry acr, cemetery_type ct, dict d
              where acr.cemetery_type_id = ct.id
                and ct.cemetery_property = d.dict_code
                and acr.create_date >= trunc(sysdate, 'MM')
                and acr.create_date <= last_day(sysdate)
              group by ct.create_org_id, d.dict_code, d.dict_name

             ) now_cave

    on sum_area.org_id = now_cave.org_id
   and sum_area.property_name = now_cave.property_name
   and sum_area.property = now_cave.property;

prompt
prompt Creating view TEST_LOC_STATICS
prompt ==============================
prompt
create or replace view bj_cemetery.test_loc_statics as
select a."DICT_CODE",a."DICT_NAME",a."ID",a."BUSINESS_NAME",a."CTID",a."CNT" ,a.cnt* b.total_price  price from (
   select di.dict_code,di.dict_name,bd.id,bd.business_name,ct.id ctID,count(ct.id) cnt
     from cemetery_type ct, cemetery_location cl,dict di,BUSINESS_DATA bd,
     archives_cemetery_registry acr
    where
        di.dict_code = bd.business_type(+)
    and bd.id=ct.business_data_id(+)
    and ct.id = cl.cemetery_type_id

    and  di.pid = 3300
    and acr.cemetery_location_id=cl.id
    and acr.cemetery_registry_type='1'
    group by  di.dict_code,di.dict_name,bd.id,bd.business_name,ct.id
    order by  di.dict_code,di.dict_name,bd.id,bd.business_name)a,cemetery_type b
    where a.ctID=b.id;

prompt
prompt Creating package REPORT_PACK
prompt ============================
prompt
create or replace package bj_cemetery.report_pack AS
  TYPE cuc_cursor IS REF CURSOR;
  TYPE pd_cursor IS REF CURSOR;
  TYPE ol_cursor IS REF CURSOR;

  /**
  土地使用情况统计表
  region_id区域id
  org_id机构id
  create_date创建时间
  rc_cuc 返回值
  */
  procedure pro_cave_user_case(region_id     in NUMBER,
                               v_org_id      in NUMBER,
                               v_create_date in varchar,
                               rc_cuc        out report_pack.cuc_cursor);

  /**
  同期业务统计表
  org_id机构id
  create_date创建时间
  pd_cursor 返回值
  */
  procedure pro_period_business(v_org_id      in NUMBER,
                                v_create_date in varchar,
                                pd_cursor     out report_pack.pd_cursor);

  /**
  公墓信息一览表
  org_id机构id
  ol_cursor 返回值
  */
  procedure pro_org_location(v_org_id  in NUMBER,
                             v_code    in varchar,
                             ol_cursor out report_pack.ol_cursor);

end report_pack;
/

prompt
prompt Creating package body REPORT_PACK
prompt =================================
prompt
create or replace package body bj_cemetery.report_pack is

  /*土地使用情况统计表（市/公墓）*/
  procedure pro_cave_user_case(region_id     in NUMBER,
                               v_org_id      in NUMBER,
                               v_create_date in varchar,
                               rc_cuc        out report_pack.cuc_cursor) is
  begin
  
    if ((v_org_id is null) or (v_org_id <= 0)) then
    
      open rc_cuc for
      /*区域统计*/
        select sum_area.grid,
               sum_area.grname,
               sum_area.gdid,
               sum_area.gdname,
               sum_area.property_name property_name,
               now_area.snow_area snow_area,
               up_now_area.sup_now_area sup_now_area,
               year_area.syear_area syear_area,
               sum_area.ssum_area ssum_area,
               now_fact_price.snow_fact_price snow_fact_price,
               now_fact_price.snow_fact_price / now_location.snow_location snow_location,
               now_fact_price.snow_fact_price / now_cave.snow_cave snow_cave
        
          from ( /*总累计面积*/
                select sum(ct.area) ssum_area,
                        d.dict_name property_name,
                        d.dict_code property,
                        gr.id grid,
                        gd.id gdid,
                        gr.name grname,
                        gd.name gdname
                  from archives_cemetery_registry acr,
                        cemetery_type              ct,
                        dict                       d,
                        gos_dept                   gd,
                        gos_region                 gr
                 where acr.cemetery_type_id = ct.id
                   and ct.cemetery_property = d.dict_code
                   and acr.create_org_id = gd.id
                   and gd.regionid = gr.id
                   and gr.id = region_id
                 group by gr.id,
                           gd.id,
                           gr.name,
                           gd.name,
                           d.dict_code,
                           d.dict_name
                
                ) sum_area
        
          left join ( /*本年面积*/
                     select sum(ct.area) syear_area,
                             d.dict_name property_name,
                             d.dict_code property,
                             gr.id grid,
                             gd.id gdid,
                             gr.name grname,
                             gd.name gdname
                       from archives_cemetery_registry acr,
                             cemetery_type              ct,
                             dict                       d,
                             gos_dept                   gd,
                             gos_region                 gr
                     
                      where acr.cemetery_type_id = ct.id
                        and ct.cemetery_property = d.dict_code
                        and acr.create_org_id = gd.id
                        and gd.regionid = gr.id
                        and gr.id = region_id
                        and acr.create_date >=
                            trunc(to_date(v_create_date, 'yyyy-MM'), 'yyyy')
                        and acr.create_date <=
                            add_months(trunc(to_date(v_create_date, 'yyyy-MM'),
                                             'yyyy'),
                                       12) - 1
                      group by gr.id,
                                gd.id,
                                gr.name,
                                gd.name,
                                d.dict_code,
                                d.dict_name
                     
                     ) year_area
        
            on sum_area.gdid = year_area.gdid
           and sum_area.grid = year_area.grid
           and sum_area.property_name = year_area.property_name
           and sum_area.property = year_area.property
        
          left join ( /*去年本月同期面积*/
                     select sum(ct.area) sup_now_area,
                             d.dict_name property_name,
                             d.dict_code property,
                             gr.id grid,
                             gd.id gdid,
                             gr.name grname,
                             gd.name gdname
                       from archives_cemetery_registry acr,
                             cemetery_type              ct,
                             dict                       d,
                             gos_dept                   gd,
                             gos_region                 gr
                     
                      where acr.cemetery_type_id = ct.id
                        and ct.cemetery_property = d.dict_code
                        and acr.create_org_id = gd.id
                        and gd.regionid = gr.id
                        and gr.id = region_id
                        and acr.create_date >=
                            trunc(add_months(to_date(v_create_date, 'yyyy-MM'),
                                             -12),
                                  'MM')
                        and acr.create_date <=
                            last_day(add_months(to_date(v_create_date,
                                                        'yyyy-MM'),
                                                -12))
                      group by gr.id,
                                gd.id,
                                gr.name,
                                gd.name,
                                d.dict_code,
                                d.dict_name) up_now_area
        
            on sum_area.gdid = up_now_area.gdid
           and sum_area.grid = up_now_area.grid
           and sum_area.property_name = up_now_area.property_name
           and sum_area.property = up_now_area.property
        
          left join ( /*本月面积*/
                     select sum(ct.area) snow_area,
                             d.dict_name property_name,
                             d.dict_code property,
                             gr.id grid,
                             gd.id gdid,
                             gr.name grname,
                             gd.name gdname
                       from archives_cemetery_registry acr,
                             cemetery_type              ct,
                             dict                       d,
                             gos_dept                   gd,
                             gos_region                 gr
                      where acr.cemetery_type_id = ct.id
                        and ct.cemetery_property = d.dict_code
                        and acr.create_org_id = gd.id
                        and gd.regionid = gr.id
                        and gr.id = region_id
                        and acr.create_date >=
                            trunc(to_date(v_create_date, 'yyyy-MM'), 'MM')
                        and acr.create_date <=
                            last_day(to_date(v_create_date, 'yyyy-MM'))
                      group by gr.id,
                                gd.id,
                                gr.name,
                                gd.name,
                                d.dict_code,
                                d.dict_name) now_area
        
            on sum_area.gdid = now_area.gdid
           and sum_area.grid = now_area.grid
           and sum_area.property_name = now_area.property_name
           and sum_area.property = now_area.property
        
          left join (
                     /*本月总收入*/
                     select sum(acr.FACT_PRICE) snow_fact_price,
                             d.dict_name property_name,
                             d.dict_code property,
                             gr.id grid,
                             gd.id gdid,
                             gr.name grname,
                             gd.name gdname
                       from archives_cemetery_registry acr,
                             cemetery_type              ct,
                             dict                       d,
                             gos_dept                   gd,
                             gos_region                 gr
                      where acr.cemetery_type_id = ct.id
                        and ct.cemetery_property = d.dict_code
                        and acr.create_org_id = gd.id
                        and gd.regionid = gr.id
                        and gr.id = region_id
                        and acr.create_date >=
                            trunc(to_date(v_create_date, 'yyyy-MM'), 'MM')
                        and acr.create_date <=
                            last_day(to_date(v_create_date, 'yyyy-MM'))
                      group by gr.id,
                                gd.id,
                                gr.name,
                                gd.name,
                                d.dict_code,
                                d.dict_name
                     
                     ) now_fact_price
        
            on sum_area.gdid = now_fact_price.gdid
           and sum_area.grid = now_fact_price.grid
           and sum_area.property_name = now_fact_price.property_name
           and sum_area.property = now_fact_price.property
        
          left join (
                     /*本月墓位数*/
                     select count(acr.id) snow_location,
                             d.dict_name property_name,
                             d.dict_code property,
                             gr.id grid,
                             gd.id gdid,
                             gr.name grname,
                             gd.name gdname
                     
                       from archives_cemetery_registry acr,
                             cemetery_type              ct,
                             dict                       d,
                             gos_dept                   gd,
                             gos_region                 gr
                      where acr.cemetery_type_id = ct.id
                        and ct.cemetery_property = d.dict_code
                        and acr.create_org_id = gd.id
                        and gd.regionid = gr.id
                        and gr.id = region_id
                        and acr.create_date >=
                            trunc(to_date(v_create_date, 'yyyy-MM'), 'MM')
                        and acr.create_date <=
                            last_day(to_date(v_create_date, 'yyyy-MM'))
                      group by gr.id,
                                gd.id,
                                gr.name,
                                gd.name,
                                d.dict_code,
                                d.dict_name
                     
                     ) now_location
        
            on sum_area.gdid = now_location.gdid
           and sum_area.grid = now_location.grid
           and sum_area.property_name = now_location.property_name
           and sum_area.property = now_location.property
        
          left join ( /*本月墓穴数*/
                     select sum(ct.cave) snow_cave,
                             d.dict_name property_name,
                             d.dict_code property,
                             gr.id grid,
                             gd.id gdid,
                             gr.name grname,
                             gd.name gdname
                       from archives_cemetery_registry acr,
                             cemetery_type              ct,
                             dict                       d,
                             gos_dept                   gd,
                             gos_region                 gr
                      where acr.cemetery_type_id = ct.id
                        and ct.cemetery_property = d.dict_code
                        and acr.create_org_id = gd.id
                        and gd.regionid = gr.id
                        and gr.id = region_id
                        and acr.create_date >=
                            trunc(to_date(v_create_date, 'yyyy-MM'), 'MM')
                        and acr.create_date <=
                            last_day(to_date(v_create_date, 'yyyy-MM'))
                      group by gr.id,
                                gd.id,
                                gr.name,
                                gd.name,
                                d.dict_code,
                                d.dict_name) now_cave
            on sum_area.gdid = now_cave.gdid
           and sum_area.grid = now_cave.grid
           and sum_area.property_name = now_cave.property_name
           and sum_area.property = now_cave.property;
    
    else
    
      open rc_cuc for
      /*部门统计*/
        select sum_area.grid,
               sum_area.grname,
               sum_area.gdid,
               sum_area.gdname,
               sum_area.property_name property_name,
               now_area.snow_area snow_area,
               up_now_area.sup_now_area sup_now_area,
               year_area.syear_area syear_area,
               sum_area.ssum_area ssum_area,
               now_fact_price.snow_fact_price snow_fact_price,
               now_fact_price.snow_fact_price / now_location.snow_location snow_location,
               now_fact_price.snow_fact_price / now_cave.snow_cave snow_cave
        
          from ( /*总累计面积*/
                select sum(ct.area) ssum_area,
                        d.dict_name property_name,
                        d.dict_code property,
                        gr.id grid,
                        gd.id gdid,
                        gr.name grname,
                        gd.name gdname
                  from archives_cemetery_registry acr,
                        cemetery_type              ct,
                        dict                       d,
                        gos_dept                   gd,
                        gos_region                 gr
                 where acr.cemetery_type_id = ct.id
                   and ct.cemetery_property = d.dict_code
                   and acr.create_org_id = gd.id
                   and gd.regionid = gr.id
                   and gd.id = v_org_id
                 group by gr.id,
                           gd.id,
                           gr.name,
                           gd.name,
                           d.dict_code,
                           d.dict_name
                
                ) sum_area
        
          left join ( /*本年面积*/
                     select sum(ct.area) syear_area,
                             d.dict_name property_name,
                             d.dict_code property,
                             gr.id grid,
                             gd.id gdid,
                             gr.name grname,
                             gd.name gdname
                       from archives_cemetery_registry acr,
                             cemetery_type              ct,
                             dict                       d,
                             gos_dept                   gd,
                             gos_region                 gr
                     
                      where acr.cemetery_type_id = ct.id
                        and ct.cemetery_property = d.dict_code
                        and acr.create_org_id = gd.id
                        and gd.regionid = gr.id
                        and gd.id = v_org_id
                        and acr.create_date >=
                            trunc(to_date(v_create_date, 'yyyy-MM'), 'yyyy')
                        and acr.create_date <=
                            add_months(trunc(to_date(v_create_date, 'yyyy-MM'),
                                             'yyyy'),
                                       12) - 1
                      group by gr.id,
                                gd.id,
                                gr.name,
                                gd.name,
                                d.dict_code,
                                d.dict_name
                     
                     ) year_area
        
            on sum_area.gdid = year_area.gdid
           and sum_area.grid = year_area.grid
           and sum_area.property_name = year_area.property_name
           and sum_area.property = year_area.property
        
          left join ( /*去年本月同期面积*/
                     select sum(ct.area) sup_now_area,
                             d.dict_name property_name,
                             d.dict_code property,
                             gr.id grid,
                             gd.id gdid,
                             gr.name grname,
                             gd.name gdname
                       from archives_cemetery_registry acr,
                             cemetery_type              ct,
                             dict                       d,
                             gos_dept                   gd,
                             gos_region                 gr
                     
                      where acr.cemetery_type_id = ct.id
                        and ct.cemetery_property = d.dict_code
                        and acr.create_org_id = gd.id
                        and gd.regionid = gr.id
                        and gd.id = v_org_id
                        and acr.create_date >=
                            trunc(add_months(to_date(v_create_date, 'yyyy-MM'),
                                             -12),
                                  'MM')
                        and acr.create_date <=
                            last_day(add_months(to_date(v_create_date,
                                                        'yyyy-MM'),
                                                -12))
                      group by gr.id,
                                gd.id,
                                gr.name,
                                gd.name,
                                d.dict_code,
                                d.dict_name) up_now_area
        
            on sum_area.gdid = up_now_area.gdid
           and sum_area.grid = up_now_area.grid
           and sum_area.property_name = up_now_area.property_name
           and sum_area.property = up_now_area.property
        
          left join ( /*本月面积*/
                     select sum(ct.area) snow_area,
                             d.dict_name property_name,
                             d.dict_code property,
                             gr.id grid,
                             gd.id gdid,
                             gr.name grname,
                             gd.name gdname
                       from archives_cemetery_registry acr,
                             cemetery_type              ct,
                             dict                       d,
                             gos_dept                   gd,
                             gos_region                 gr
                      where acr.cemetery_type_id = ct.id
                        and ct.cemetery_property = d.dict_code
                        and acr.create_org_id = gd.id
                        and gd.regionid = gr.id
                        and gd.id = v_org_id
                        and acr.create_date >=
                            trunc(to_date(v_create_date, 'yyyy-MM'), 'MM')
                        and acr.create_date <=
                            last_day(to_date(v_create_date, 'yyyy-MM'))
                      group by gr.id,
                                gd.id,
                                gr.name,
                                gd.name,
                                d.dict_code,
                                d.dict_name) now_area
        
            on sum_area.gdid = now_area.gdid
           and sum_area.grid = now_area.grid
           and sum_area.property_name = now_area.property_name
           and sum_area.property = now_area.property
        
          left join (
                     /*本月总收入*/
                     select sum(acr.FACT_PRICE) snow_fact_price,
                             d.dict_name property_name,
                             d.dict_code property,
                             gr.id grid,
                             gd.id gdid,
                             gr.name grname,
                             gd.name gdname
                       from archives_cemetery_registry acr,
                             cemetery_type              ct,
                             dict                       d,
                             gos_dept                   gd,
                             gos_region                 gr
                      where acr.cemetery_type_id = ct.id
                        and ct.cemetery_property = d.dict_code
                        and acr.create_org_id = gd.id
                        and gd.regionid = gr.id
                        and gd.id = v_org_id
                        and acr.create_date >=
                            trunc(to_date(v_create_date, 'yyyy-MM'), 'MM')
                        and acr.create_date <=
                            last_day(to_date(v_create_date, 'yyyy-MM'))
                      group by gr.id,
                                gd.id,
                                gr.name,
                                gd.name,
                                d.dict_code,
                                d.dict_name
                     
                     ) now_fact_price
        
            on sum_area.gdid = now_fact_price.gdid
           and sum_area.grid = now_fact_price.grid
           and sum_area.property_name = now_fact_price.property_name
           and sum_area.property = now_fact_price.property
        
          left join (
                     /*本月墓位数*/
                     select count(acr.id) snow_location,
                             d.dict_name property_name,
                             d.dict_code property,
                             gr.id grid,
                             gd.id gdid,
                             gr.name grname,
                             gd.name gdname
                     
                       from archives_cemetery_registry acr,
                             cemetery_type              ct,
                             dict                       d,
                             gos_dept                   gd,
                             gos_region                 gr
                      where acr.cemetery_type_id = ct.id
                        and ct.cemetery_property = d.dict_code
                        and acr.create_org_id = gd.id
                        and gd.regionid = gr.id
                        and gd.id = v_org_id
                        and acr.create_date >=
                            trunc(to_date(v_create_date, 'yyyy-MM'), 'MM')
                        and acr.create_date <=
                            last_day(to_date(v_create_date, 'yyyy-MM'))
                      group by gr.id,
                                gd.id,
                                gr.name,
                                gd.name,
                                d.dict_code,
                                d.dict_name
                     
                     ) now_location
        
            on sum_area.gdid = now_location.gdid
           and sum_area.grid = now_location.grid
           and sum_area.property_name = now_location.property_name
           and sum_area.property = now_location.property
        
          left join ( /*本月墓穴数*/
                     select sum(ct.cave) snow_cave,
                             d.dict_name property_name,
                             d.dict_code property,
                             gr.id grid,
                             gd.id gdid,
                             gr.name grname,
                             gd.name gdname
                       from archives_cemetery_registry acr,
                             cemetery_type              ct,
                             dict                       d,
                             gos_dept                   gd,
                             gos_region                 gr
                      where acr.cemetery_type_id = ct.id
                        and ct.cemetery_property = d.dict_code
                        and acr.create_org_id = gd.id
                        and gd.regionid = gr.id
                        and gd.id = v_org_id
                        and acr.create_date >=
                            trunc(to_date(v_create_date, 'yyyy-MM'), 'MM')
                        and acr.create_date <=
                            last_day(to_date(v_create_date, 'yyyy-MM'))
                      group by gr.id,
                                gd.id,
                                gr.name,
                                gd.name,
                                d.dict_code,
                                d.dict_name) now_cave
            on sum_area.gdid = now_cave.gdid
           and sum_area.grid = now_cave.grid
           and sum_area.property_name = now_cave.property_name
           and sum_area.property = now_cave.property;
    
    end if;
  
  end pro_cave_user_case;

  /*同期业务统计表公墓*/
  procedure pro_period_business(v_org_id      in NUMBER,
                                v_create_date in varchar,
                                pd_cursor     out report_pack.pd_cursor) is
  begin
  
    open pd_cursor for
    
      select business_data.dict_name     dict_name,
             business_data.business_name business_name,
             bnby.count_id               bnby_count_id,
             bnsy.count_id               bnsy_count_id,
             snby.count_id               snby_count_id,
             snsy.count_id               snsy_count_id
        from ( /*业务分类*/
              select bd.id, d.dict_code, d.dict_name, bd.business_name, null
                from business_data bd, dict d
               where bd.create_org_id = v_org_id
                 and bd.business_type = d.dict_code
               group by bd.id, d.dict_code, d.dict_name, bd.business_name) business_data
      
        FULL OUTER JOIN ( /*本年本月*/
                         select acr.business_data_id,
                                 d.dict_code,
                                 d.dict_name,
                                 bd.business_name,
                                 count(acr.id) count_id
                           from archives_cemetery_registry acr,
                                 business_data              bd,
                                 dict                       d
                          where acr.business_data_id = bd.id
                            and bd.business_type = d.dict_code
                            and acr.create_date >=
                                trunc(to_date(v_create_date, 'yyyy-MM'), 'MM')
                            and acr.create_date <=
                                last_day(to_date(v_create_date, 'yyyy-MM'))
                            and acr.create_org_id = v_org_id
                          group by acr.business_data_id,
                                    d.dict_code,
                                    d.dict_name,
                                    bd.business_name) bnby
          on business_data.id = bnby.business_data_id
         and business_data.dict_code = bnby.dict_code
      
        FULL OUTER JOIN ( /*本年上月*/
                         select acr.business_data_id,
                                 d.dict_code,
                                 d.dict_name,
                                 bd.business_name,
                                 count(acr.id) count_id
                           from archives_cemetery_registry acr,
                                 business_data              bd,
                                 dict                       d
                          where acr.business_data_id = bd.id
                            and bd.business_type = d.dict_code
                            and acr.create_date >=
                                trunc(add_months(to_date(v_create_date,
                                                         'yyyy-MM'),
                                                 -1),
                                      'MM')
                            and acr.create_date <=
                                last_day(add_months(to_date(v_create_date,
                                                            'yyyy-MM'),
                                                    -1))
                            and acr.create_org_id = v_org_id
                          group by acr.business_data_id,
                                    d.dict_code,
                                    d.dict_name,
                                    bd.business_name) bnsy
      
          on business_data.id = bnsy.business_data_id
         and business_data.dict_code = bnsy.dict_code
      
        FULL OUTER JOIN
      
       (
        /*上年本月*/
        select acr.business_data_id,
                d.dict_code,
                d.dict_name,
                bd.business_name,
                count(acr.id) count_id
          from archives_cemetery_registry acr, business_data bd, dict d
         where acr.business_data_id = bd.id
           and bd.business_type = d.dict_code
           and acr.create_date >=
               trunc(add_months(to_date(v_create_date, 'yyyy-MM'), -12), 'MM')
           and acr.create_date <=
               last_day(add_months(to_date(v_create_date, 'yyyy-MM'), -12))
           and acr.create_org_id = v_org_id
         group by acr.business_data_id,
                   d.dict_code,
                   d.dict_name,
                   bd.business_name) snby
      
          on business_data.id = snby.business_data_id
         and business_data.dict_code = snby.dict_code
      
        FULL OUTER JOIN (
                         /*上年上月*/
                         select acr.business_data_id,
                                 d.dict_code,
                                 d.dict_name,
                                 bd.business_name,
                                 count(acr.id) count_id
                           from archives_cemetery_registry acr,
                                 business_data              bd,
                                 dict                       d
                          where acr.business_data_id = bd.id
                            and bd.business_type = d.dict_code
                            and acr.create_date >=
                                trunc(add_months(to_date(v_create_date,
                                                         'yyyy-MM'),
                                                 -13),
                                      'MM')
                            and acr.create_date <=
                                last_day(add_months(to_date(v_create_date,
                                                            'yyyy-MM'),
                                                    -13))
                            and acr.create_org_id = v_org_id
                          group by acr.business_data_id,
                                    d.dict_code,
                                    d.dict_name,
                                    bd.business_name) snsy
      
          on business_data.id = snsy.business_data_id
         and business_data.dict_code = snsy.dict_code
       order by business_data.id, business_data.dict_code;
  end pro_period_business;

  /*公墓信息一览表*/
  procedure pro_org_location(v_org_id  in NUMBER,
                             v_code    in varchar,
                             ol_cursor out report_pack.ol_cursor) is
  begin
    if (v_org_id is null and v_code is null) then
      open ol_cursor for
      
        select business_data.dict_code,
               business_data.dict_name,
               l_count.gdid,
               l_count.gdname,
               l_count.countid         as l_countid,
               NVL(m_count.countid,0)       as m_countid
          from (
                /*业务分类*/
                select d.dict_code, d.dict_name
                  from business_data bd, dict d
                 where bd.business_type = d.dict_code
                 group by d.dict_code, d.dict_name) business_data
          left join (
                     /*墓位总数*/
                     select d.dict_code,
                             d.dict_name,
                             count(cl.id) as countid,
                             gd.id gdid,
                             gd.name gdname
                       from cemetery_location cl,
                             cemetery_type     ct,
                             business_data     bd,
                             dict              d,
                             gos_dept          gd,
                             gos_region        gr
                      where cl.cemetery_type_id = ct.id
                        and ct.business_data_id = bd.id
                        and bd.business_type = d.dict_code
                        and gd.id = cl.create_org_id
                        and gd.regionid = gr.id
                      group by d.dict_code, d.dict_name, gd.id, gd.name) l_count
        
            on l_count.dict_code = business_data.dict_code
        
          left join (
                     /*墓位已经使用总数*/
                     select d.dict_code,
                             d.dict_name,
                             count(cl.id) as countid,
                             gd.id gdid,
                             gd.name gdname
                       from cemetery_location cl,
                             cemetery_type     ct,
                             business_data     bd,
                             dict              d,
                             gos_dept          gd,
                             gos_region        gr
                      where cl.cemetery_type_id = ct.id
                        and ct.business_data_id = bd.id
                        and cl.status = 6
                        and bd.business_type = d.dict_code
                        and gd.id = cl.create_org_id
                        and gd.regionid = gr.id
                      group by d.dict_code, d.dict_name, gd.id, gd.name) m_count
        
            on m_count.dict_code = business_data.dict_code;
    
    elsif (v_code is not null) then
    
      open ol_cursor for
      
        select business_data.dict_code,
               business_data.dict_name,
               l_count.gdid,
               l_count.gdname,
               l_count.countid         as l_countid,
               NVL(m_count.countid,0)       as m_countid
          from (
                /*业务分类*/
                select d.dict_code, d.dict_name
                  from business_data bd, dict d
                 where bd.business_type = d.dict_code
                   and d.dict_code = v_code
                 group by d.dict_code, d.dict_name) business_data
          left join (
                     /*墓位总数*/
                     select d.dict_code,
                             d.dict_name,
                             count(cl.id) as countid,
                             gd.id gdid,
                             gd.name gdname
                       from cemetery_location cl,
                             cemetery_type     ct,
                             business_data     bd,
                             dict              d,
                             gos_dept          gd,
                             gos_region        gr
                      where cl.cemetery_type_id = ct.id
                        and ct.business_data_id = bd.id
                        and bd.business_type = d.dict_code
                        and gd.id = cl.create_org_id
                        and gd.regionid = gr.id
                      group by d.dict_code, d.dict_name, gd.id, gd.name) l_count
        
            on l_count.dict_code = business_data.dict_code
        
          left join (
                     /*墓位已经使用总数*/
                     select d.dict_code,
                             d.dict_name,
                             count(cl.id) as countid,
                             gd.id gdid,
                             gd.name gdname
                       from cemetery_location cl,
                             cemetery_type     ct,
                             business_data     bd,
                             dict              d,
                             gos_dept          gd,
                             gos_region        gr
                      where cl.cemetery_type_id = ct.id
                        and ct.business_data_id = bd.id
                        and cl.status = 6
                        and bd.business_type = d.dict_code
                        and gd.id = cl.create_org_id
                        and gd.regionid = gr.id
                      group by d.dict_code, d.dict_name, gd.id, gd.name) m_count
        
            on m_count.dict_code = business_data.dict_code;
    
    elsif (v_org_id is not null) then
    
      open ol_cursor for
      
        select business_data.dict_code,
               business_data.dict_name,
               l_count.gdid,
               l_count.gdname,
               l_count.countid         as l_countid,
               NVL(m_count.countid,0)       as m_countid
          from (
                /*业务分类*/
                select d.dict_code, d.dict_name
                  from business_data bd, dict d
                 where bd.create_org_id = v_org_id
                   and bd.business_type = d.dict_code
                 group by d.dict_code, d.dict_name) business_data
          left join (
                     /*墓位总数*/
                     select d.dict_code,
                             d.dict_name,
                             count(cl.id) as countid,
                             gd.id gdid,
                             gd.name gdname
                       from cemetery_location cl,
                             cemetery_type     ct,
                             business_data     bd,
                             dict              d,
                             gos_dept          gd,
                             gos_region        gr
                      where cl.cemetery_type_id = ct.id
                        and ct.business_data_id = bd.id
                        and bd.business_type = d.dict_code
                        and gd.id = cl.create_org_id
                        and gd.regionid = gr.id
                        and gd.id = v_org_id
                      group by d.dict_code, d.dict_name, gd.id, gd.name) l_count
        
            on l_count.dict_code = business_data.dict_code
        
          left join (
                     /*墓位已经使用总数*/
                     select d.dict_code,
                             d.dict_name,
                             count(cl.id) as countid,
                             gd.id gdid,
                             gd.name gdname
                       from cemetery_location cl,
                             cemetery_type     ct,
                             business_data     bd,
                             dict              d,
                             gos_dept          gd,
                             gos_region        gr
                      where cl.cemetery_type_id = ct.id
                        and ct.business_data_id = bd.id
                        and cl.status = 6
                        and bd.business_type = d.dict_code
                        and gd.id = cl.create_org_id
                        and gd.regionid = gr.id
                        and gd.id = v_org_id
                      group by d.dict_code, d.dict_name, gd.id, gd.name) m_count
        
            on m_count.dict_code = business_data.dict_code;
    else
      open ol_cursor for
      
        select business_data.dict_code,
               business_data.dict_name,
               l_count.gdid,
               l_count.gdname,
               l_count.countid         as l_countid,
               NVL(m_count.countid,0)       as m_countid
          from (
                /*业务分类*/
                select d.dict_code, d.dict_name
                  from business_data bd, dict d
                 where bd.create_org_id = v_org_id
                   and d.dict_code = v_code
                   and bd.business_type = d.dict_code
                
                 group by d.dict_code, d.dict_name) business_data
          left join (
                     /*墓位总数*/
                     select d.dict_code,
                             d.dict_name,
                             count(cl.id) as countid,
                             gd.id gdid,
                             gd.name gdname
                       from cemetery_location cl,
                             cemetery_type     ct,
                             business_data     bd,
                             dict              d,
                             gos_dept          gd,
                             gos_region        gr
                      where cl.cemetery_type_id = ct.id
                        and ct.business_data_id = bd.id
                        and bd.business_type = d.dict_code
                        and gd.id = cl.create_org_id
                        and gd.regionid = gr.id
                        and gd.id = v_org_id
                      group by d.dict_code, d.dict_name, gd.id, gd.name) l_count
        
            on l_count.dict_code = business_data.dict_code
        
          left join (
                     /*墓位已经使用总数*/
                     select d.dict_code,
                             d.dict_name,
                             count(cl.id) as countid,
                             gd.id gdid,
                             gd.name gdname
                       from cemetery_location cl,
                             cemetery_type     ct,
                             business_data     bd,
                             dict              d,
                             gos_dept          gd,
                             gos_region        gr
                      where cl.cemetery_type_id = ct.id
                        and ct.business_data_id = bd.id
                        and cl.status = 6
                        and bd.business_type = d.dict_code
                        and gd.id = cl.create_org_id
                        and gd.regionid = gr.id
                        and gd.id = v_org_id
                      group by d.dict_code, d.dict_name, gd.id, gd.name) m_count
        
            on m_count.dict_code = business_data.dict_code;
    end if;
  end pro_org_location;

end report_pack;
/


spool off
