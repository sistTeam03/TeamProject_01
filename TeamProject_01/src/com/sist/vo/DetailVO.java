package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 * NO                      NUMBER         
TITLE          NOT NULL VARCHAR2(2000) 
POSTER                  VARCHAR2(260)  
CHEF           NOT NULL VARCHAR2(100)  
CHEF_POSTER             VARCHAR2(260)  
INFO                    VARCHAR2(4000) 
INFO1                   VARCHAR2(100)  
INFO2                   VARCHAR2(100)  
INFO3                   VARCHAR2(100)  
INGRE                   VARCHAR2(4000) 
CONTENT_POSTER          VARCHAR2(4000) 
LIKED                   VARCHAR2(20)   
REGDATE                 VARCHAR2(100)  
CHEF_MSG                VARCHAR2(4000) 
CONTENT                 CLOB           
HIT2                    NUMBER  
 */
@Getter
@Setter
public class DetailVO {
	private int no, hit2;
	private String title, poster, chef, chef_poster, info, info1, info2, info3, ingre,
	content_poster, liked, regdate, chef_msg, content;
}
