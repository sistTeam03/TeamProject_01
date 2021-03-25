package com.sist.dao;

import lombok.Getter;
import lombok.Setter;

/*
 * 	NO           NOT NULL NUMBER        
	POSTER       NOT NULL VARCHAR2(260) 
	TITLE        NOT NULL VARCHAR2(700) 
	CHEF_POSTER           VARCHAR2(260) 
	CHEF         NOT NULL VARCHAR2(150) 
	RATING                NUMBER        
	COUNT_REVIEW          NUMBER        
	LINK                  VARCHAR2(260) 
	HIT                   VARCHAR2(100) 
 * 
 */
@Getter
@Setter
public class ListVO {
	private int no,rating,count_review;
	private String poster,title,chef,
			chef_poster,link,hit;
}
