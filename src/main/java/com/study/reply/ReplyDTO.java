package com.study.reply;
 
public class ReplyDTO {
  private int rnum;
  private String content;
  private String regdate;
  private String id;
  private int reviewno;
 
  
  @Override
public String toString() {
	return "ReplyDTO [rnum=" + rnum + ", content=" + content + ", regdate=" + regdate + ", id=" + id + ", reviewno="
			+ reviewno + "]";
}

public ReplyDTO(int rnum, String content, String regdate, String id, int reviewno) {
	super();
	this.rnum = rnum;
	this.content = content;
	this.regdate = regdate;
	this.id = id;
	this.reviewno = reviewno;
}

public ReplyDTO() {
	super();
	// TODO Auto-generated constructor stub
}

public int getRnum() {
    return rnum;
  }
 
  public void setRnum(int rnum) {
    this.rnum = rnum;
  }
 
  public String getContent() {
    return content;
  }
 
  public void setContent(String content) {
    this.content = content;
  }
 
  public String getRegdate() {
    return regdate;
  }
 
  public void setRegdate(String regdate) {
    this.regdate = regdate;
  }
 
  public String getId() {
    return id;
  }
 
  public void setId(String id) {
    this.id = id;
  }

public int getReviewno() {
	return reviewno;
}

public void setReviewno(int reviewno) {
	this.reviewno = reviewno;
}
}