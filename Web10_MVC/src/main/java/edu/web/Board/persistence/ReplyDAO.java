package edu.web.Board.persistence;

import java.util.List;

import edu.web.Board.domain.ReplyVO;

public interface ReplyDAO {
	public abstract int insert(ReplyVO vo);
	public abstract List<ReplyVO> select(int boardNo); // 댓글은 전체검색만 잇다. 한글당 다보여짐
	public abstract int update(ReplyVO vo);
	public abstract int delete(int replyNo, int boardNo);
	
	

}
