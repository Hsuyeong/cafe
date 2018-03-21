package com.community.cafe.vo;

public class CommunityCafeReplyVO {

	private int id; //글번호 
	private String replyUserId;
	private String replybody;
	private String replyDate;
	private String replyUserLevel;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getReplyUserId() {
		return replyUserId;
	}

	public void setReplyUserId(String replyUserId) {
		this.replyUserId = replyUserId;
	}

	public String getReplybody() {
		return replybody;
	}

	public void setReplybody(String replybody) {
		this.replybody = replybody;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	public String getReplyUserLevel() {
		return replyUserLevel;
	}

	public void setReplyUserLevel(String replyUserLevel) {
		this.replyUserLevel = replyUserLevel;
	}

}
