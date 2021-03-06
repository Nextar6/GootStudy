package edu.web.Board.persistence;

import java.util.List;

import edu.web.Board.domain.BoardVO;
import edu.web.Board.util.PageCriteria;

public interface BoardDAO {
	public abstract int insert(BoardVO vo);
	public abstract List<BoardVO> select();
	public abstract BoardVO select(int bno);
	public abstract int update(BoardVO vo);
	public abstract int delete(int bno);
	public abstract List<BoardVO> select(PageCriteria criteria);
	public abstract int getTotalCounts();
	

}
