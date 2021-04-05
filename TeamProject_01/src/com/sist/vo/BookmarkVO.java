package com.sist.vo;
 
import lombok.Getter;
import lombok.Setter;

/*
 * 이름       널?       유형           
-------- -------- ------------ 
NO       NOT NULL NUMBER       
REGDATE           DATE         
RECIPENO          NUMBER       
ID                VARCHAR2(20) 
 */
@Getter
@Setter
public class BookmarkVO {
	private int no, recipeno;
	private String regdate, id;
}
