package com.sist.vo;

import lombok.Getter;
import lombok.Setter;

/*0406 생성추가
 * 이름  널?       유형           
--- -------- ------------ 
NO  NOT NULL NUMBER       
INO          NUMBER       
ID           VARCHAR2(20)  
 */
@Getter
@Setter
public class UserIngreVO {
	private int no, ino;
	private String id;
	private String name;
}
