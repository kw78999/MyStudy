drop table member;

CREATE TABLE IF NOT EXISTS member(
   id VARCHAR(20) NOT NULL,
   passwd  VARCHAR(20),
   name VARCHAR(30),    
   PRIMARY KEY (id)
);
INSERT INTO member VALUES('1', '1234', 'ȫ���');
INSERT INTO member VALUES('2', '1235', 'ȫ�浿');


select * from member;
