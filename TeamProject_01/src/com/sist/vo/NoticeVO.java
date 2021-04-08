package com.sist.vo;
/*
 * NO      NOT NULL NUMBER         
SUBJECT          VARCHAR2(260)  
CONTENT          CLOB           
NFILE            VARCHAR2(4000) 
HIT              NUMBER         
ADMIN            VARCHAR2(1)    

 */
public class NoticeVO {
	private int no,hit;
	private String subject,content,nfile,admin;
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getHit() {
		return hit;
	}
	public void setHit(int hit) {
		this.hit = hit;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getNfile() {
		return nfile;
	}
	public void setNfile(String nfile) {
		this.nfile = nfile;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	
	
}
