package com.OOTD.like.vo;

public class LikeVO {

	private long no;
	private String id;
	private long likeCnt;
	
	
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
	public long getLikeCnt() {
		return likeCnt;
	}
	public void setLikeCnt(long likeCnt) {
		this.likeCnt = likeCnt;
	}
	
	@Override
	public String toString() {
		return "LikeVO [no=" + no + ", id=" + id + ", likeCnt=" + likeCnt + "]";
	}
	
	
	
	
}
