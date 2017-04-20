-------------------------------------------
-- Export file for user BJ_CEMETERY         --
-- Created by zst on 2014/7/25, 17:36:13 --
-------------------------------------------

spool gos_系统管理.log

prompt
prompt Creating table GOS_APPLOG
prompt =========================
prompt
create table BJ_CEMETERY.GOS_APPLOG
(
  ID          NUMBER(9) not null,
  INFO        VARCHAR2(1000),
  MODULENAME  VARCHAR2(50),
  PLATFORMID  NUMBER(10) default 10,
  USERID      NUMBER(19),
  USERNAME    VARCHAR2(20),
  APENDDATE   DATE,
  OPERATETYPE NUMBER(10) default 50
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 4M
    minextents 1
    maxextents unlimited
  );
alter table BJ_CEMETERY.GOS_APPLOG
  add primary key (ID)
  using index 
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 960K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table GOS_DEPT
prompt =======================
prompt
create table BJ_CEMETERY.GOS_DEPT
(
  ID              NUMBER(25) not null,
  DEPT_CODE       VARCHAR2(50),
  NAME            VARCHAR2(100) not null,
  CAT             VARCHAR2(50),
  LEVELID         NUMBER(25) not null,
  CREATEDATE      DATE not null,
  CREATORID       NUMBER(25) not null,
  DESCRIPTION     VARCHAR2(500),
  BZSM            NUMBER(10),
  SYRS            NUMBER(10),
  FAREN           NUMBER(25),
  BZXS            VARCHAR2(50),
  LDZZS           NUMBER(5),
  LDFZS           NUMBER(5),
  JFXS            VARCHAR2(50),
  SHORTNAME       VARCHAR2(10),
  FRZHENGSHU      VARCHAR2(100),
  OFFICEPHONE     VARCHAR2(50),
  OFFICECODE      VARCHAR2(50),
  OFFICEADDR      VARCHAR2(160),
  OFFICEDUTY      VARCHAR2(50),
  REGIONID        NUMBER(25),
  DISPORDER       VARCHAR2(4),
  OFFICETIME      VARCHAR2(100),
  TRAFFICTYPE     VARCHAR2(50),
  OFFICEMAIL      VARCHAR2(100),
  PARENT_ID       NUMBER(32),
  ROLE_LEV        NUMBER(32),
  USE_FLAG        NUMBER(1),
  CONTACT_PERSON  VARCHAR2(40),
  EMAIL           VARCHAR2(40),
  HEADER          VARCHAR2(40),
  TREE_NODE       NUMBER(2),
  DWLX            NUMBER(32),
  CYBM            VARCHAR2(40),
  DWDM            VARCHAR2(40),
  JGMX            NUMBER(32),
  JG_HYFL         VARCHAR2(64),
  JG_HYFLXL       VARCHAR2(64),
  ORDERBY_ITEM    NUMBER(10),
  IS_REGION       NUMBER(1),
  SFQY            NUMBER(1),
  TSJB_ISSENDINFO NUMBER(2),
  TSJB_SENDTEL    NUMBER(15)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 960K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table GOS_REGION
prompt =========================
prompt
create table BJ_CEMETERY.GOS_REGION
(
  ID                NUMBER(25) not null,
  NAME              VARCHAR2(100),
  LEVELID           NUMBER(25),
  DESCRIPTION       VARCHAR2(100),
  CREATEDATE        DATE,
  CREATORID         NUMBER(25),
  PARENTID          NUMBER(25),
  NUM               VARCHAR2(100),
  SHORTNAME         VARCHAR2(50),
  DISPORDER         VARCHAR2(2),
  STANDARD_NO       VARCHAR2(20),
  USE_FLAG          NUMBER(1),
  OLD_DICTIONARY_ID VARCHAR2(30),
  CONVERT_ID        VARCHAR2(30),
  PEOPLE_NUM        NUMBER(10),
  REGION_CODE       VARCHAR2(20),
  ORDERBY_ITEM      NUMBER(10)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 704K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table GOS_ROLE
prompt =======================
prompt
create table BJ_CEMETERY.GOS_ROLE
(
  ID           NUMBER(25) not null,
  NAME         VARCHAR2(120) not null,
  CREATEDATE   DATE not null,
  CREATORID    NUMBER(25) not null,
  DESCRIPTION  VARCHAR2(500),
  PRIORITY     VARCHAR2(2000),
  DEPT_ID      NUMBER(25),
  OLD_ROLE_ID  NUMBER(10),
  CREATOR_NAME VARCHAR2(50),
  CATEGORY     VARCHAR2(100)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );
comment on column BJ_CEMETERY.GOS_ROLE.NAME
  is '角色名称';
comment on column BJ_CEMETERY.GOS_ROLE.CREATEDATE
  is '创建时间';
comment on column BJ_CEMETERY.GOS_ROLE.CREATORID
  is '创建ID';
comment on column BJ_CEMETERY.GOS_ROLE.DESCRIPTION
  is '角色说明';
comment on column BJ_CEMETERY.GOS_ROLE.PRIORITY
  is '权限';
comment on column BJ_CEMETERY.GOS_ROLE.DEPT_ID
  is '部门ID';
alter table BJ_CEMETERY.GOS_ROLE
  add constraint BIN$3EQDBinoQxK/DaMCSSK3cg==$0 primary key (ID);
create unique index BJ_CEMETERY.BIN$VKGVhezuTa20D0y68J8paQ==$0 on BJ_CEMETERY.GOS_ROLE (ID)
  tablespace BJ_CEMETERY
  pctfree 10
  initrans 2
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table GOS_USER
prompt =======================
prompt
create table BJ_CEMETERY.GOS_USER
(
  ID              NUMBER(25) not null,
  LOGINID         VARCHAR2(100),
  PASSWORD        VARCHAR2(200),
  NAME            VARCHAR2(20) not null,
  GENDER          VARCHAR2(10) not null,
  DEPTID          NUMBER(25) not null,
  USER_CODE       VARCHAR2(50),
  JIGUAN          VARCHAR2(50),
  BIRTHDAY        DATE,
  BIRTHLOCATION   VARCHAR2(200),
  NATION          VARCHAR2(20),
  XUELI           VARCHAR2(50),
  XUEWEI          VARCHAR2(50),
  ZHUANYE         VARCHAR2(200),
  YUANXIAO        VARCHAR2(200),
  ZHENGZHIMIANMAO VARCHAR2(20),
  RUDANGSHIJIAN   DATE,
  WORKYEAR        DATE,
  CALLNAME        VARCHAR2(100),
  POSITIONID      VARCHAR2(100),
  IDENTITYNUM     VARCHAR2(100),
  WORKNUM         VARCHAR2(100),
  ADDRESS         VARCHAR2(100),
  HOMEPHONE       VARCHAR2(100),
  OFFICEPHONE     VARCHAR2(100),
  MOBILE          VARCHAR2(100),
  PUBLICMONEYNUM  VARCHAR2(100),
  OLDSUPPORTNUM   VARCHAR2(100),
  HOUSEPAYNUM     VARCHAR2(100),
  SECURITYNUM     VARCHAR2(100),
  CREATEDATE      DATE,
  CREATORID       NUMBER(25) not null,
  PRIORITY        VARCHAR2(4000),
  MEMO            VARCHAR2(500),
  DELETED         NUMBER(1),
  BIYETIME        DATE,
  XZYEAR          DATE,
  RETIRE          VARCHAR2(10),
  REGISTSTATUS    NUMBER(2),
  DELETEREASON    VARCHAR2(100),
  WORKDEPTID      NUMBER(25),
  TYPE            NUMBER(2),
  CANUMBER        VARCHAR2(4000),
  EMAILID         VARCHAR2(4000),
  SYSTEM_ROLE     VARCHAR2(4000),
  ORDERBY_ITEM    NUMBER(10),
  SFZF            NUMBER(10),
  ZF_NUMBER       NUMBER(32),
  SIGNATURE       BLOB,
  PIC             BLOB
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating table GOS_USEREXT
prompt ==========================
prompt
create table BJ_CEMETERY.GOS_USEREXT
(
  ID            NUMBER(25) not null,
  ISSUPERMAN    NUMBER(1) not null,
  ISSUBMAN      NUMBER(1) not null,
  ISDEPTMAN     NUMBER(1) not null,
  ISLOGMAN      NUMBER(1) not null,
  SUBCREATORID  NUMBER(25),
  LOGCREATORID  NUMBER(25),
  DEPTCREATORID NUMBER(25),
  SUBSTR        VARCHAR2(4000),
  DEPTSTR       VARCHAR2(1000),
  LOGSTR        VARCHAR2(1000),
  PRIORITY      VARCHAR2(4000)
)
tablespace BJ_CEMETERY
  pctfree 10
  initrans 1
  maxtrans 255
  storage
  (
    initial 64K
    minextents 1
    maxextents unlimited
  );

prompt
prompt Creating sequence GOS_APPLOG_SEQ
prompt ================================
prompt
create sequence BJ_CEMETERY.GOS_APPLOG_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 447858
increment by 1
nocache;

prompt
prompt Creating sequence GOS_DEPT_SEQ
prompt ==============================
prompt
create sequence BJ_CEMETERY.GOS_DEPT_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 12022845
increment by 1
cache 20;

prompt
prompt Creating sequence GOS_REGION_SEQ
prompt ================================
prompt
create sequence BJ_CEMETERY.GOS_REGION_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 6139
increment by 1
cache 20;

prompt
prompt Creating sequence GOS_ROLE_SEQ
prompt ==============================
prompt
create sequence BJ_CEMETERY.GOS_ROLE_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 1341
increment by 1
cache 20;

prompt
prompt Creating sequence GOS_USEREXT_SEQ
prompt =================================
prompt
create sequence BJ_CEMETERY.GOS_USEREXT_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 4962
increment by 1
cache 20;

prompt
prompt Creating sequence GOS_USER_SEQ
prompt ==============================
prompt
create sequence BJ_CEMETERY.GOS_USER_SEQ
minvalue 1
maxvalue 999999999999999999999999999
start with 12023087
increment by 1
cache 20;


spool off
