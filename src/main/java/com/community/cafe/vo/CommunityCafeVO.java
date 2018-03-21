package com.community.cafe.vo;

import java.util.List;

public class CommunityCafeVO {

	/**
	 * 글번호, 유저id, 글제목, 글본문, 작성일, 조회수, 댓글List
	 */
	private int id;
	private String userId;
	private String title;
	private String body;
	private String writeDate;
	private int viewCount;
	private List<CommunityCafeReplyVO> replyList; // 글번호(id),댓글,유저id,댓글작성시간

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int viewCount) {
		this.viewCount = viewCount;
	}

	public List<CommunityCafeReplyVO> getReplyList() {
		return replyList;
	}

	public void setReplyList(List<CommunityCafeReplyVO> replyList) {
		this.replyList = replyList;
	}


	public String getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(String writeDate) {
		this.writeDate = writeDate;
	}

}
