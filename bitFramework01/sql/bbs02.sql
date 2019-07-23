CREATE TABLE bbS0206 
(
  NUM NUMBER NOT NULL 
, NAME VARCHAR2(20) 
, SUB VARCHAR2(20) 
, CONTENT VARCHAR2(2000) 
, NALJA DATE 
, CONSTRAINT STRUTS06_PK PRIMARY KEY 
  (
    NUM 
  )
  ENABLE 
);
CREATE SEQUENCE bbs02_num_seq;

INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,'테스터','제목1', '내용1',sysdate);
INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,'테스터','제목2', '내용2',sysdate);
INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,'테스터','제목3', '내용3',sysdate);
INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,'테스터','제목4', '내용4',sysdate);
INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,'테스터','제목5', '내용5',sysdate);
INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,'테스터','제목6', '내용6',sysdate);
commit;