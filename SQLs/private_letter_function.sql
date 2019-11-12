--------------------------------------------------
--------------FUNC_ADD_PRIVATE_LETTER--------------------------------//
CREATE OR REPLACE 
FUNCTION FUNC_ADD_PRIVATE_LETTER(sender_user_id IN INTEGER, receiver_user_id IN INTEGER, content IN VARCHAR2)
RETURN INTEGER
AS
temp_date VARCHAR2(30);
state integer:=1;
BEGIN
  select to_char(sysdate,'yyyy-mm-dd HH24:MI:SS')into temp_date from dual;

  insert into PRIVATE_LETTER
      (PRIVATE_LETTER_CONTENT, PRIVATE_LETTER_IS_READ,PRIVATE_LETTER_CREATE_TIME,PRIVATE_LETTER_SENDER_ID,PRIVATE_LETTER_RECEIVER_ID)
  values(content, '0', temp_date, sender_user_id, receiver_user_id);

	RETURN state;
END;
/

--------------------------------------------------
--------------FUNC_DELETE_PRIVATE_LETTER--------------------------------//
CREATE OR REPLACE 
FUNCTION FUNC_DELETE_PRIVATE_LETTER (d_private_letter_id IN INTEGER)
RETURN INTEGER
AS
state integer:=1;
BEGIN
  select count(*) into state 
  from PRIVATE_LETTER
  where d_private_letter_id=PRIVATE_LETTER.PRIVATE_LETTER_ID;
if state=0
  then 
  return state;
ELSE
  DELETE from PRIVATE_LETTER
  where PRIVATE_LETTER.PRIVATE_LETTER_ID=d_private_letter_id;
  state:=1;
end if;
return state;
END;
/

--------------------------------------------------
--------------FUNC_QUERY_PRIVATE_LETTERS--------------------------------//

CREATE OR REPLACE 
FUNCTION FUNC_QUERY_PRIVATE_LETTERS
(user_id IN INTEGER, startFrom IN INTEGER, limitation IN INTEGER,search_result OUT sys_refcursor)
RETURN INTEGER
AS
state integer:=1;

BEGIN

  SELECT count(*) into state 
  from PRIVATE_LETTER
  where PRIVATE_LETTER.PRIVATE_LETTER_RECEIVER_ID=user_id;

  IF state=0
  THEN 
    return state;
  ELSE  
    open search_result for
        select * from
        (SELECT M.*, ROWNUM rn FROM
         (SELECT PRIVATE_LETTER_SENDER_ID,PRIVATE_LETTER_ID,PRIVATE_LETTER_CONTENT,PRIVATE_LETTER_CREATE_TIME
         from PRIVATE_LETTER
         WHERE PRIVATE_LETTER.PRIVATE_LETTER_RECEIVER_ID=user_id 
         ORDER BY PRIVATE_LETTER.PRIVATE_LETTER_CREATE_TIME DESC) M)
    WHERE rn >= startFrom and rn < startFrom+limitation;

    state:=1;
  END IF;
	RETURN state;
END;

/
--------------FUNC_QUERY_LATEST_CONTACT--------------------------------
create or replace FUNCTION FUNC_QUERY_LATEST_CONTACT
(userid IN INTEGER, startFrom IN INTEGER, limitation IN INTEGER,search_result OUT sys_refcursor)
RETURN INTEGER
AS
state integer:=0;

BEGIN
  open search_result for
  SELECT USER_ID, USER_NICKNAME, utime
  FROM USER_PUBLIC_INFO natural join
  ((SELECT searchid AS USER_ID, utime FROM
    (select searchid, max(mtime) as utime from
      ((select PRIVATE_LETTER_RECEIVER_ID as searchid, max(PRIVATE_LETTER_CREATE_TIME) as mtime
        from PRIVATE_LETTER
        where PRIVATE_LETTER_SENDER_ID=userid and PRIVATE_LETTER_RECEIVER_ID<>userid
        group by PRIVATE_LETTER_RECEIVER_ID)
       UNION
       (select PRIVATE_LETTER_SENDER_ID as searchid, max(PRIVATE_LETTER_CREATE_TIME) as mtime
        from PRIVATE_LETTER
        where PRIVATE_LETTER_RECEIVER_ID=userid and PRIVATE_LETTER_SENDER_ID<>userid
        group by PRIVATE_LETTER_SENDER_ID))
      group by searchid
      order by utime desc)
    WHERE ROWNUM<startFrom+Limitation)
  MINUS
  (SELECT searchid AS user_id, utime FROM
    (select searchid, max(mtime) as utime from
      ((select PRIVATE_LETTER_RECEIVER_ID as searchid, max(PRIVATE_LETTER_CREATE_TIME) as mtime
        from PRIVATE_LETTER
        where PRIVATE_LETTER_SENDER_ID=userid and PRIVATE_LETTER_RECEIVER_ID<>userid
        group by PRIVATE_LETTER_RECEIVER_ID)
       UNION
       (select PRIVATE_LETTER_SENDER_ID as searchid, max(PRIVATE_LETTER_CREATE_TIME) as mtime
        from PRIVATE_LETTER
        where PRIVATE_LETTER_RECEIVER_ID=userid and PRIVATE_LETTER_SENDER_ID<>userid
        group by PRIVATE_LETTER_SENDER_ID))
      group by searchid
      order by utime desc)
    WHERE ROWNUM<startFrom));


  state:=1;
	RETURN state;
END;
/