package com.sist.vo;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

/*
 *  NO         NOT NULL NUMBER        
	ID                  VARCHAR2(20)  
	NAME                VARCHAR2(20)  
	SUBJECT             VARCHAR2(100) 
	CONTENT             CLOB          
	PWD                 VARCHAR2(30)  
	REGDATE             DATE          
	HIT                 NUMBER        
	GROUP_ID            NUMBER        
	GROUP_STEP          NUMBER        
	GROUP_TAB           NUMBER        
	ROOT                NUMBER        
	DEPTH               NUMBER  
 */
@Getter
@Setter
public class QnaboardVO {
	private int no;
	// 기본 게시물
	private String id;
	private String name;
	private String subject;
	private String content;
	private String pwd;
	
	private Date regdate;
	private int hit;
	// 답변 표시
	private int group_id;
	private int group_step;
	private int group_tab;
	// 삭제용
	private int root;
	private int depth;
}
