package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 * 	=-------- -------- ------------- 
ID       NOT NULL VARCHAR2(20)  
PWD      NOT NULL VARCHAR2(20)  
NAME     NOT NULL VARCHAR2(34)  
BIRTH    NOT NULL NUMBER        
TEL               VARCHAR2(10)  
PHONE    NOT NULL VARCHAR2(10)  
EMAIL    NOT NULL VARCHAR2(30)  
POST     NOT NULL VARCHAR2(50)  
NICKNAME          VARCHAR2(50)  
ADMIN             VARCHAR2(1)   
ADDR1    NOT NULL VARCHAR2(200) 
ADDR2             VARCHAR2(200) 
 * 
 * 
 */
@Setter
@Getter
public class MemberVO {
	private String id,pwd,name,birth,tel,phone,email,post,nickname,admin,addr1,addr2;
}
