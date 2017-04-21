create table IF NOT EXISTS T_TRANSCORE_CONFIG
(
  id             NUMBER(10) not null,
  product_code   VARCHAR2(20),
  trans_type     VARCHAR2(2) not null,
  name           VARCHAR2(200) not null,
  sub_trans_type VARCHAR2(2) not null,
  sub_name       VARCHAR2(50) not null,
  payer          VARCHAR2(50),
  payee          VARCHAR2(50),
  dc_flag        CHAR(1) not null,
  status         CHAR(1) not null,
  description    VARCHAR2(300),
  create_time    TIMESTAMP(6) default sysdate,
  modify_time    TIMESTAMP(6) default sysdate
);

create table IF NOT EXISTS  T_TRANSCORE_CONFIG_PROPERTY
(
  id          NUMBER(10) not null,
  config_id   NUMBER(10) not null,
  type        VARCHAR2(4) not null,
  name        VARCHAR2(50) not null,
  value       VARCHAR2(3000),
  status      CHAR(1) not null,
  description VARCHAR2(100),
  create_time TIMESTAMP(6) default sysdate,
  modify_time TIMESTAMP(6) default sysdate
);

create table IF NOT EXISTS T_TRANSCORE_ERROR_LOG
(
  id              NUMBER(14) not null,
  trans_id        VARCHAR2(32) not null,
  payment_id      VARCHAR2(64),
  system_id       VARCHAR2(10),
  error_system_id VARCHAR2(10),
  response_code   VARCHAR2(10),
  status          CHAR(10),
  memo            VARCHAR2(500),
  client_ip       VARCHAR2(100),
  server_ip       VARCHAR2(100),
  version         VARCHAR2(20),
  create_time     TIMESTAMP(6) default sysdate,
  modify_time     TIMESTAMP(6) default sysdate
);


create table IF NOT EXISTS   T_TRANSCORE_FEE
(
  id           NUMBER(16) not null,
  trans_id     VARCHAR2(32) not null,
  customer_id  VARCHAR2(24) not null,
  fee_code     VARCHAR2(20),
  account_type VARCHAR2(24) not null,
  amount       NUMBER(18) not null,
  description  VARCHAR2(100),
  create_time  TIMESTAMP(6) default sysdate,
  modify_time  TIMESTAMP(6) default sysdate,
  fee_type     NUMBER(2),
  account_id   VARCHAR2(24),
  payment_id   VARCHAR2(32),
  status       VARCHAR2(10) default '00'
);


create table IF NOT EXISTS   T_TRANSCORE_INTERNAL_TRANS
(
  trans_id           VARCHAR2(32) not null,
  order_no           VARCHAR2(32) not null,
  trans_code         VARCHAR2(24) not null,
  busi_channel       CHAR(1),
  amount             NUMBER(18) not null,
  act_amount         NUMBER(18) default 0,
  ccy                CHAR(3) not null,
  trans_time         TIMESTAMP(6) default sysdate not null,
  company_code       VARCHAR2(12),
  biz_scenario_code  VARCHAR2(24),
  trans_desc         VARCHAR2(300) not null,
  from_merc_id       VARCHAR2(15),
  from_customer_id   VARCHAR2(24),
  from_customer_name VARCHAR2(120),
  from_acct_id       VARCHAR2(24),
  from_acct_name     VARCHAR2(64),
  from_acct_type     VARCHAR2(24),
  to_merc_id         VARCHAR2(15),
  to_customer_id     VARCHAR2(24),
  to_customer_name   VARCHAR2(120),
  to_acct_id         VARCHAR2(24),
  to_acct_name       VARCHAR2(64),
  to_acct_type       VARCHAR2(24),
  trans_status       CHAR(2) default '00',
  client_src         VARCHAR2(10),
  external_fields    VARCHAR2(2001),
  create_time        TIMESTAMP(6) default sysdate not null,
  update_time        TIMESTAMP(6) default sysdate not null
);

create table IF NOT EXISTS T_TRANSCORE_JMS_LOG
(
  id          NUMBER(14) not null,
  destination VARCHAR2(100),
  msg_type    CHAR(1),
  direction   CHAR(1),
  msg         VARCHAR2(3000),
  create_time TIMESTAMP(6) default sysdate
);

create table IF NOT EXISTS T_TRANSCORE_PAYMENT
(
  id               VARCHAR2(32) not null,
  payment_mode     NUMBER(6) not null,
  currency_code    VARCHAR2(3),
  business_channel CHAR(1) not null,
  trans_id         VARCHAR2(32) not null,
  operator_ip      VARCHAR2(24),
  operator_id      VARCHAR2(24),
  amount           NUMBER(18) not null,
  status           VARCHAR2(2) not null,
  create_time      TIMESTAMP(6) default sysdate,
  modify_time      TIMESTAMP(6) default sysdate
);

create table IF NOT EXISTS T_TRANSCORE_PAYMENT_DETAIL
(
  id              NUMBER(16) not null,
  payment_id      VARCHAR2(32) not null,
  credential_id   VARCHAR2(32),
  credential_name VARCHAR2(24),
  currency_code   VARCHAR2(3),
  amount          NUMBER(18) not null,
  create_time     TIMESTAMP(6) default sysdate,
  modify_time     TIMESTAMP(6) default sysdate,
  payment_type    VARCHAR2(10)
);

create table IF NOT EXISTS T_TRANSCORE_PAY_REQ
(
  id                        NUMBER(14) not null,
  tran_order_id             VARCHAR2(50),
  business_domain           VARCHAR2(20),
  last_return_tran_order_id VARCHAR2(32),
  tran_type                 VARCHAR2(3),
  in_request_no             VARCHAR2(32),
  request_source            VARCHAR2(32),
  trans_flag                VARCHAR2(1),
  create_time               TIMESTAMP(6) default sysdate,
  modify_time               TIMESTAMP(6) default sysdate
);

create table IF NOT EXISTS T_TRANSCORE_PAY_REQ_ITEM
(
  id                          NUMBER(14) not null,
  pay_req_id                  NUMBER(14),
  account_trans_code          VARCHAR2(20),
  operation_type              VARCHAR2(20),
  from_entity                 VARCHAR2(50),
  from_entity_id              VARCHAR2(50),
  from_entity_detail          VARCHAR2(50),
  to_entity                   VARCHAR2(50),
  to_entity_id                VARCHAR2(50),
  to_entity_detail            VARCHAR2(50),
  calc_base                   VARCHAR2(20),
  calc_base_type              VARCHAR2(20),
  pay_urgent_fag              VARCHAR2(1),
  amount                      NUMBER(18),
  offline_bank_card_posp_info VARCHAR2(3000),
  online_bank_card_info       VARCHAR2(3000),
  account_info                VARCHAR2(3000),
  lufax_info                  VARCHAR2(3000),
  create_time                 TIMESTAMP(6) default sysdate,
  modify_time                 TIMESTAMP(6) default sysdate
);

create table IF NOT EXISTS T_TRANSCORE_RULE_COMPLIANCE
(
  verificationlevel CHAR(2) not null,
  transtype         CHAR(2) not null,
  singleamount      NUMBER(18) not null,
  dayamount         NUMBER(18) not null,
  daycount          NUMBER(8) not null,
  monthamount       NUMBER(18) not null,
  monthcount        NUMBER(8) not null
);


create table IF NOT EXISTS T_TRANSCORE_RULE_COUNT
(
  customer_id  VARCHAR2(24) not null,
  transtype    CHAR(2) not null,
  busi_channel CHAR(1) not null,
  dayamount    NUMBER(18) not null,
  daycount     NUMBER(8) not null,
  monthamount  NUMBER(18) not null,
  monthcount   NUMBER(8) not null,
  createdate   TIMESTAMP(6) not null
);

create table IF NOT EXISTS T_TRANSCORE_RULE_SECURITY
(
  busi_channel CHAR(1) not null,
  transtype    CHAR(2) not null,
  security     VARCHAR2(24),
  singleamount NUMBER(18) not null,
  dayamount    NUMBER(18) not null,
  daycount     NUMBER(8) not null,
  monthamount  NUMBER(18) not null,
  monthcount   NUMBER(8) not null
);

create table IF NOT EXISTS T_TRANSCORE_SUBLEDGER
(
  acct_name   VARCHAR2(64),
  amt         NUMBER(18),
  ccy         VARCHAR2(32),
  comments    VARCHAR2(300),
  acct_type   VARCHAR2(32),
  flag        CHAR(2),
  trans_id    VARCHAR2(32) not null,
  id          VARCHAR2(32) not null,
  create_time TIMESTAMP(6),
  update_time TIMESTAMP(6),
  status      VARCHAR2(10) default '00'
);

create table IF NOT EXISTS T_TRANSCORE_TRANSACTION
(
  trans_id           VARCHAR2(32) not null,
  order_no           VARCHAR2(32),
  trans_type         CHAR(2) not null,
  busi_channel       CHAR(1) not null,
  trans_time         TIMESTAMP(6) default sysdate not null,
  trans_end_time     TIMESTAMP(6),
  trans_expired_time TIMESTAMP(6),
  trans_status       CHAR(2) default '00' not null,
  customer_id        VARCHAR2(24) not null,
  customer_name      VARCHAR2(120),
  acct_id            VARCHAR2(24),
  acct_name          VARCHAR2(255),
  register_flag      CHAR(1),
  dc_flag            CHAR(1) not null,
  to_customer_id     VARCHAR2(24),
  to_customer_name   VARCHAR2(120),
  to_acct_id         VARCHAR2(24),
  to_acct_name       VARCHAR2(255),
  trans_amt          NUMBER(18) not null,
  trans_fact_amt     NUMBER(18) default 0,
  trans_desc         VARCHAR2(300),
  refund_amt         NUMBER(18) default 0,
  refund_fact_amt    NUMBER(18) default 0,
  refund_desc        VARCHAR2(120),
  cap_channel_type   CHAR(2),
  cap_channel_id     VARCHAR2(32),
  cap_channel_name   VARCHAR2(120),
  create_time        TIMESTAMP(6) default sysdate not null,
  update_time        TIMESTAMP(6) default sysdate not null,
  trans_summary_id   NUMBER(18),
  ccy                CHAR(3),
  fee                NUMBER(18) default 0,
  other_fee          NUMBER(18) default 0,
  product_code       VARCHAR2(32),
  sub_trans_type     CHAR(2),
  external_fields    VARCHAR2(2000),
  trans_code         VARCHAR2(4),
  subledger_type     CHAR(1),
  parent_transid     VARCHAR2(32),
  merchant_num       VARCHAR2(32),
  settle_customer_id VARCHAR2(24)
);


create table IF NOT EXISTS T_TRANSCORE_TRANSACTION_EXT
(
  id          NUMBER(16) not null,
  trans_id    VARCHAR2(32) not null,
  info_type   CHAR(2) not null,
  id_info0    VARCHAR2(32),
  id_info1    VARCHAR2(32),
  name_info0  VARCHAR2(64),
  name_info1  VARCHAR2(255),
  enc_info0   VARCHAR2(128),
  enc_info1   VARCHAR2(128),
  create_time TIMESTAMP(6),
  enc_info2   VARCHAR2(32),
  enc_info3   VARCHAR2(32)
);

create table IF NOT EXISTS T_TRANSCORE_TRANSCODE_ACCTID
(
  transcode          VARCHAR2(4) not null,
  from_inner_acct_id VARCHAR2(64),
  to_inner_acct_id   VARCHAR2(64),
  create_time        TIMESTAMP(6),
  modify_time        TIMESTAMP(6),
  from_info          VARCHAR2(300),
  to_info            VARCHAR2(300)
);

create table IF NOT EXISTS T_TRANSCORE_TRANSTYPE_DETAIL
(
  sub_trans_type          CHAR(2) not null,
  sub_trans_type_desc     VARCHAR2(100),
  trans_type              CHAR(2) not null,
  trans_type_desc         VARCHAR2(100),
  customer_trans_desc     VARCHAR2(100),
  to_customer_trans_desc  VARCHAR2(100),
  dcflag                  CHAR(1),
  reg_trans_code          CHAR(4),
  unreg_trans_code        CHAR(4),
  reg_refund_trans_code   CHAR(4),
  unreg_refund_trans_code CHAR(4),
  reg_fee_trans_code      CHAR(4),
  unreg_fee_trans_code    CHAR(4),
  reg_comm_trans_code     CHAR(4),
  unreg_comm_trans_code   CHAR(4),
  reg_trans_code_after    CHAR(4)
);

create table IF NOT EXISTS T_TRANSCORE_TRANS_CUSTID_INFO
(
  customer_id VARCHAR2(24) not null,
  trans_id    VARCHAR2(32) not null,
  del_flag    CHAR(1) default 0 not null,
  create_time TIMESTAMP(6),
  info_type   CHAR(2) not null,
  expire_time TIMESTAMP(6)
);


create table IF NOT EXISTS T_TRANSCORE_TRANS_EXPIRED
(
  trans_id     VARCHAR2(32) not null,
  expired_time TIMESTAMP(6) not null,
  is_expired   CHAR(1) default 'F'
);


create table IF NOT EXISTS T_TRANSCORE_TRANS_MONITOR_CFG
(
  id                 NUMBER(14) not null,
  status             CHAR(2) not null,
  verification_level VARCHAR2(2) not null,
  trans_type         CHAR(2) not null,
  is_open_service    VARCHAR2(2) not null,
  busi_channel       CHAR(1) not null,
  limit_level        CHAR(1) not null,
  single_max_amount  NUMBER(18) default 0,
  single_min_amount  NUMBER(18) default 0,
  day_max_amount     NUMBER(18) default 0,
  day_max_times      NUMBER(8) default 0,
  month_max_amount   NUMBER(18) default 0,
  month_max_times    NUMBER(8) default 0,
  create_time        TIMESTAMP(6) default sysdate not null,
  update_time        TIMESTAMP(6) default sysdate not null
);

create table IF NOT EXISTS T_TRANSCORE_TRANS_RESOURCE
(
  id          NUMBER(16) not null,
  trans_id    VARCHAR2(32) not null,
  res_type    CHAR(2),
  res_name    VARCHAR2(100),
  res_length  NUMBER(16),
  res_url     VARCHAR2(200),
  res_suffix  VARCHAR2(10),
  status      CHAR(1),
  create_time TIMESTAMP(6) default sysdate not null,
  update_time TIMESTAMP(6) default sysdate not null,
  trans_type  CHAR(2)
);

create table IF NOT EXISTS T_TRANSCORE_TRANS_STATISTIC
(
  id             NUMBER(14) not null,
  trans_type     CHAR(2) not null,
  customer_id    VARCHAR2(24) not null,
  to_customer_id VARCHAR2(24) not null,
  credit_amount  NUMBER(18) not null,
  debit_amount   NUMBER(18) not null,
  status         CHAR(2) not null,
  create_time    TIMESTAMP(6) default sysdate not null,
  update_time    TIMESTAMP(6) default sysdate not null
);

create table IF NOT EXISTS T_TRANSCORE_TRANS_SUMMARY
(
  id               NUMBER(14) not null,
  customer_id      VARCHAR2(24) not null,
  customer_name    VARCHAR2(120),
  acct_id          VARCHAR2(24) not null,
  acct_name        VARCHAR2(64),
  status           CHAR(2) default '00' not null,
  amount           NUMBER(18) default 0,
  participant      NUMBER(4) default 0,
  begin_time       TIMESTAMP(6),
  end_time         TIMESTAMP(6),
  trans_name       VARCHAR2(120),
  trans_desc       VARCHAR2(300),
  trans_type       CHAR(3) not null,
  related_id       VARCHAR2(128),
  create_time      TIMESTAMP(6) default sysdate not null,
  update_time      TIMESTAMP(6) default sysdate not null,
  fact_amount      NUMBER(18) default 0,
  fact_participant NUMBER(4) default 0
);

create sequence IF NOT EXISTS SEQ_INTER_TRANSACTION_TRANS_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANSACTION_EXT_ID 		start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANSACTION_MONITOR_CFG_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANSACTION_RESOURCE_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANSACTION_STATISTIC_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANSACTION_SUMMARY_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANSACTION_TRANS_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANSCORE_FEE_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANS_CONFIG_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANS_CONFIG_PROPERTY_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANS_ERROR_LOG_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANS_PAYMENT_DETAIL_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANS_PAYMENT_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANS_PAY_REQ_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANS_PAY_REQ_ITEM_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_TRANS_SUBLEDGER_ID start with 1 ;
create sequence IF NOT EXISTS SEQ_T_TRANSCORE_JMS_LOG_ID start with 1 ;

  


