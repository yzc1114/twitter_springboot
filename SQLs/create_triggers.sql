create or replace trigger User_Public_Info_ID_ADD
before insert on User_Public_Info
for each row
-- WHEN (new.id is null)
-- local variables here
begin
select SEQ_USER_PUBLIC_INFO.NEXTVAL into :new.user_id from dual;
end User_Public_Info_ID_ADD;
/

create or replace trigger Avatar_Image_ID_ADD
before insert on Avatar_Image
for each row
-- WHEN (new.id is null)
-- local variables here
begin
select SEQ_AVATAR_IMAGE.NEXTVAL into :new.avatar_image_id from dual;
end Avatar_Image_ID_ADD;
/

create or replace trigger Private_Letter_ID_ADD
before insert on Private_Letter
for each row
-- WHEN (new.id is null)
-- local variables here
begin
select SEQ_PRIVATE_LETTER.NEXTVAL into :new.private_letter_id from dual;
end Private_Letter_ID_ADD;
/

create or replace trigger Message_ID_ADD
before insert on Message
for each row
-- WHEN (new.id is null)
-- local variables here
begin
select SEQ_MESSAGE.NEXTVAL into :new.message_id from dual;
end Message_ID_ADD;
/

create or replace trigger Comment_On_Message_ID_ADD
before insert on Comment_On_Message
for each row
-- WHEN (new.id is null)
-- local variables here
begin
select SEQ_COMMENT_ON_MESSAGE.NEXTVAL into :new.comment_id from dual;
end Comment_On_Message_ID_ADD;
/

create or replace trigger Topic_ID_ADD
before insert on Topic
for each row
-- WHEN (new.id is null)
-- local variables here
begin
select SEQ_TOPIC.NEXTVAL into :new.topic_id from dual;
end Topic_ID_ADD;
/