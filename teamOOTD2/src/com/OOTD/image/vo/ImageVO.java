package com.OOTD.image.vo;

public class ImageVO {
	private long no, seasonNo;
	
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public long getSeasonNo() {
		return seasonNo;
	}
	public void setSeasonNo(long seasonNo) {
		this.seasonNo = seasonNo;
	}
	public String getName1() {
		return name1;
	}
	public void setName1(String name1) {
		this.name1 = name1;
	}
	public String getLink1() {
		return link1;
	}
	public void setLink1(String link1) {
		this.link1 = link1;
	}
	public String getName2() {
		return name2;
	}
	public void setName2(String name2) {
		this.name2 = name2;
	}
	public String getLink2() {
		return link2;
	}
	public void setLink2(String link2) {
		this.link2 = link2;
	}
	public String getName3() {
		return name3;
	}
	public void setName3(String name3) {
		this.name3 = name3;
	}
	public String getLink3() {
		return link3;
	}
	public void setLink3(String link3) {
		this.link3 = link3;
	}
	public String getName4() {
		return name4;
	}
	public void setName4(String name4) {
		this.name4 = name4;
	}
	public String getLink4() {
		return link4;
	}
	public void setLink4(String link4) {
		this.link4 = link4;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	private String name1, link1, name2, link2, name3, link3, name4, link4,
	 fileName;
	@Override
	public String toString() {
		return "ImageVO [no=" + no + ", seasonNo=" + seasonNo + ", name1=" + name1 + ", link1=" + link1 + ", name2="
				+ name2 + ", link2=" + link2 + ", name3=" + name3 + ", link3=" + link3 + ", name4=" + name4 + ", link4="
				+ link4 + ", fileName=" + fileName + "]";
	}
	
}