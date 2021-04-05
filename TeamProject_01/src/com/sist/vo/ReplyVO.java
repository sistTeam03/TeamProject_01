package com.sist.vo;
 
import java.util.Date;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter

public class ReplyVO {
	private int recipeno, no;
	private String id, nickname, msg;
	private String regdate;
}
