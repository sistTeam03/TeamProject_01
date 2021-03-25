package com.sist.dao;

import lombok.Getter;
import lombok.Setter;
 
/*
 * NO                 
 TITLE          
 POSTER         
 CHEF           
 CHEF_POSTER    
 INFO1          
 INFO2                 
INFO3                 
INGRE                 
 CONTENT               
 CONTENT_POSTER        
 OLD_CONTENT           
 HIT                   
 LIKED,REGDATE,CHEF_MSG              

 * 
 */
@Setter
@Getter
public class DetailVO {
	private int no;
	private String title,poster,chef,chef_poster,info1,info2,info3,info,
			ingre,content,content_poster,old_content,hit,liked,regdate,chef_msg;
}
