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

INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,'�׽���','����1', '����1',sysdate);
INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,'�׽���','����2', '����2',sysdate);
INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,'�׽���','����3', '����3',sysdate);
INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,'�׽���','����4', '����4',sysdate);
INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,'�׽���','����5', '����5',sysdate);
INSERT INTO bbs02 VALUES(bbs02_num_seq.nextval,'�׽���','����6', '����6',sysdate);
commit;