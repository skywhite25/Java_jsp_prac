package com.OOTD.timeline.vo;

public class TimelineVO {
	
	private long no;
	private String id;
	private String title;
	private String content;
	private String writeDate;
	private long hit;
	private String fileName;
	private long spNo;
	public long getNo() {
		return no;
	}
	public void setNo(long no) {
		this.no = no;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriteDate() {
		return writeDate;
	}
	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}
	public long getHit() {
		return hit;
	}
	public void setHit(long hit) {
		this.hit = hit;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public long getSpNo() {
		return spNo;
	}
	public void setSpNo(long spNo) {
		this.spNo = spNo;
	}
	@Override
	public String toString() {
		return "TimelineVO [no=" + no + ", id=" + id + ", title=" + title + ", content=" + content + ", writeDate="
				+ writeDate + ", hit=" + hit + ", fileName=" + fileName + ", spNo=" + spNo + "]";
	}
	
	
}