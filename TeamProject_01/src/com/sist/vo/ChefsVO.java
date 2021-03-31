package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*
 * 이름            널? 유형            
------------- -- ------------- 
ID               NUMBER        
RANKING          NUMBER        
CHEF_NAME        VARCHAR2(140) 
CHEF_IMG         VARCHAR2(350) 
COOKING_COUNT    VARCHAR2(50)   
COOKING_CLIP     VARCHAR2(50)  
HIT              VARCHAR2(50)  
FOLLOWER         VARCHAR2(50) 
 */
@Getter
@Setter
public class ChefsVO {
	private int id, ranking;
	private String chef_name, chef_img, cooking_count, cooking_clip, hit, follower;
}
