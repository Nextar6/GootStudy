package edu.web.Board.domain;

public class ReplyVO {
	private int replyNo; // 댓글 번호
	private int boardNo; // 게시글 번호
	private String replyContent; // 댓글 내용
	private String replyId; // 댓글 작성자 아이디
	private String replyDate; // 댓글 작성/수정 시간

	public ReplyVO() {
	}

	public ReplyVO(int replyNo, int boardNo, String replyContent, String replyId, String replyDate) {
		super();
		this.replyNo = replyNo;
		this.boardNo = boardNo;
		this.replyContent = replyContent;
		this.replyId = replyId;
		this.replyDate = replyDate;
	}

	public int getReplyNo() {
		return replyNo;
	}

	public void setReplyNo(int replyNo) {
		this.replyNo = replyNo;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getReplyContent() {
		return replyContent;
	}

	public void setReplyContent(String replyContent) {
		this.replyContent = replyContent;
	}

	public String getReplyId() {
		return replyId;
	}

	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}

	public String getReplyDate() {
		return replyDate;
	}

	public void setReplyDate(String replyDate) {
		this.replyDate = replyDate;
	}

	@Override
	public String toString() {
		return "ReplyVO [replyNo=" + replyNo + ", boardNo=" + boardNo + ", replyContent=" + replyContent + ", replyId="
				+ replyId + ", replyDate=" + replyDate + "]";
	}

	
}
