##############################################
# guestbook 만들기
##############################################

-- -----------------------------------------
# guestbook 계정에서 실행
-- -----------------------------------------
 
-- db 선택
use guestbook_db;

-- 테이블 삭제
drop table gbook;

-- 테이블생성 
create table gbook(
    no			int              primary key          auto_increment,
    name		varchar(80)      not null,
    password   	varchar(20),
    content	    text,
    reg_date    datetime
);

-- 테이블조회
select * from gbook;

select  no,
        name,
        password,
        content,
        reg_date
from gbook
order by no asc
;

select  no,
        name,
        password,
        content,
        reg_date
from gbook
where no = 5
;

-- 등록
insert into gbook
values(null, '정우성','1111','안녕하세요. 정우성입니다.','2025-06-16')
;

insert into gbook
values(null, '이효리','2222','안녕하세요. 이효리입니다.','2025-06-15')
;

insert into gbook
values(null, '강호동','3333','안녕하세요. 강호동입니다.','2025-06-14')
;

-- 수정
update gbook
set  name = '김이박' , 
     password = '5555',
     content = '안녕하세요. 김이박입니다.' 
where no = 5 
;

-- 삭제
delete from gbook
where no = 4 ;
