package com.study.reviews;

import org.springframework.web.multipart.MultipartFile;

public class ReviewsDTO {
	private int reviewno;
	private int contentsno;
	private String revtitle;
	private String revcontent;
	private String revdate;
	private String revwriter;
	private int cateno;
	private String revpass;
	private String filename;
	private String pname;
	private int viewcnt; 
	
	

	public ReviewsDTO(int reviewno, int contentsno, String revtitle, String revcontent, String revdate,
			String revwriter, int cateno, String revpass, String filename, String pname, int viewcnt) {
		super();
		this.reviewno = reviewno;
		this.contentsno = contentsno;
		this.revtitle = revtitle;
		this.revcontent = revcontent;
		this.revdate = revdate;
		this.revwriter = revwriter;
		this.cateno = cateno;
		this.revpass = revpass;
		this.filename = filename;
		this.pname = pname;
		this.viewcnt = viewcnt;
	}
	
	

	public ReviewsDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	@Override
	public String toString() {
		return "ReviewsDTO [reviewno=" + reviewno + ", contentsno=" + contentsno + ", revtitle=" + revtitle
				+ ", revcontent=" + revcontent + ", revdate=" + revdate + ", revwriter=" + revwriter + ", cateno="
				+ cateno + ", revpass=" + revpass + ", filename=" + filename + ", pname=" + pname + ", viewcnt="
				+ viewcnt + "]";
	}



	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public String getRevpass() {
		return revpass;
	}

	public void setRevpass(String revpass) {
		this.revpass = revpass;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public int getReviewno() {
		return reviewno;
	}

	public void setReviewno(int reviewno) {
		this.reviewno = reviewno;
	}

	public int getContentsno() {
		return contentsno;
	}

	public void setContentsno(int contentsno) {
		this.contentsno = contentsno;
	}

	public String getRevtitle() {
		return revtitle;
	}

	public void setRevtitle(String revtitle) {
		this.revtitle = revtitle;
	}

	public String getRevcontent() {
		return revcontent;
	}

	public void setRevcontent(String revcontent) {
		this.revcontent = revcontent;
	}

	public String getRevdate() {
		return revdate;
	}

	public void setRevdate(String revdate) {
		this.revdate = revdate;
	}

	public String getRevwriter() {
		return revwriter;
	}

	public void setRevwriter(String revwriter) {
		this.revwriter = revwriter;
	}


	public int getCateno() {
		return cateno;
	}

	public void setCateno(int cateno) {
		this.cateno = cateno;
	}
	
	

}
