----------------FUNC_QUERY_MESSAGE_AT_USER----------------------
------------------------查询@我的信息----------------------------------
create or replace function 
FUNC_QUERY_MESSAGE_AT_USER(user_id in INTEGER, startFrom in INTEGER, limitation in INTEGER, search_result out sys_refcursor)
return INTEGER
is 
state INTEGER:=0;

begin
select count(*) into state
from AT_USER
where AT_USER_ID = user_id;

if state=0 then 
return state;
else
state:=1;
open search_result for
    select * from
(select M.*, ROWNUM rn from(
select MESSAGE_ID
from AT_USER
where AT_USER_ID= user_id
order by AT_TIME desc) M)
where rn >= startFrom and rn < startFrom + limitation;

end if;
return state;
end;
/

-------------FUNC_ADD_AT_USER-----------------------------------
-------------添加@某人的记�?------------------------------------
create or replace function
FUNC_ADD_AT_USER(at_nickname in VARCHAR2, atmessage_id in INTEGER, source_user_id in INTEGER)
return INTEGER
is
state INTEGER:=0;
count_nickname INTEGER;
temp_time VARCHAR2(30);
at_userID INTEGER;
count_at INTEGER;

begin 

select to_char(sysdate, 'yyyy-mm-dd HH24:MI:SS')into temp_time from dual;

select count(*) into count_nickname
from USER_PUBLIC_INFO
where user_nickname = at_nickname;
at_userID:=0;

if count_nickname = 0
then state:=1;
  return state;
else 
  select user_id into at_userID
  from USER_PUBLIC_INFO
  where USER_NICKNAME=at_nickname;
  
  select count(*) into count_at
  from AT_USER
  where AT_USER_ID=at_userID and MESSAGE_ID=atmessage_id;
end if;

if count_at = 0
then
  insert into AT_USER(at_user_id, message_id, user_id, at_time, at_is_read)
  values (at_userID, atmessage_id, source_user_id, temp_time, 0);
  state:=1;
end if;

state:=1;
return state;
end;
/

-------------FUNC_QUERY_UNREAD_AT-----------------------------------
-------------Query amounts of ats which are not read so far------------------------------------
create or replace function 
FUNC_QUERY_UNREAD_AT(userid in INTEGER, unread_count out INTEGER)
return INTEGER
is 
state INTEGER:=0;

begin

select count(*) into unread_count
from AT_USER
where AT_USER_ID=userid and AT_IS_READ=0;
state:=1;
return state;
end;
/