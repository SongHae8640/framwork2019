CREATE TABLE struts03(
	num NUMBER PRIMARY KEY,
	sub VARCHAR2(50),
	content VARCHAR2(1024)
);

CREATE SEQUENCE struts03_num_seq;

INSERT INTO struts03 values(struts03_num_seq.nextval, 'test01', 'content01');
INSERT INTO struts03 values(struts03_num_seq.nextval, 'test02', 'content02');
INSERT INTO struts03 values(struts03_num_seq.nextval, 'test03', 'content03');
INSERT INTO struts03 values(struts03_num_seq.nextval, 'test04', 'content04');
INSERT INTO struts03 values(struts03_num_seq.nextval, 'test05', 'content05');
INSERT INTO struts03 values(struts03_num_seq.nextval, 'test06', 'content06');

commit;

--SELECT num, sub FROM struts03 ORDER BY num DESC;
--SELECT * FROM struts03 WHERE num=?;
--INSERT INTO struts03 values(struts03_num_seq.nextval,?,?);