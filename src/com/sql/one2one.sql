/*»ùÓÚÍâ¼üÓ³Éä*/
CREATE TABLE ct_person_fk
 (
 	id NUMBER(10) PRIMARY KEY,
 	name VARCHAR2(20) NOT NULL,
 	gender VARCHAR2(10),
 	age NUMBER(3) CHECK(age BETWEEN 1 AND 100)
 );
 
 CREATE TABLE ct_passport_fk
 (
 	id NUMBER(10) PRIMARY KEY,
 	bh VARCHAR2(30) NOT NULL UNIQUE,
 	person_id NUMBER(10) REFERENCES t_person_fk(id) UNIQUE
 );
 
 CREATE SEQUENCE ct_person_fk_seq
 START WITH 1
 INCREMENT BY 1;
 
 CREATE SEQUENCE ct_passport_fk_seq
 START WITH 1
 INCREMENT BY 1;