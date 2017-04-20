-- Create the user 
create user bj_cemetery
  default tablespace bj_cemetery
  IDENTIFIED BY bj_cemetery1635
  temporary tablespace TEMP
  profile DEFAULT;
-- Grant/Revoke role privileges 
grant connect to bj_cemetery;
grant dba to bj_cemetery;
grant resource to bj_cemetery;
-- Grant/Revoke system privileges 
grant alter session to bj_cemetery with admin option;
grant create any directory to bj_cemetery;
grant create procedure to bj_cemetery with admin option;
grant create sequence to bj_cemetery with admin option;
grant create session to bj_cemetery with admin option;
grant create synonym to bj_cemetery with admin option;
grant create table to bj_cemetery with admin option;
grant create type to bj_cemetery with admin option;
grant create view to bj_cemetery with admin option;
grant select any dictionary to bj_cemetery with admin option;
grant unlimited tablespace to bj_cemetery;