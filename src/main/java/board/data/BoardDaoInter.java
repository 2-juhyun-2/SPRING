package board.data;

import java.util.List;

public interface BoardDaoInter {
	
	public int getTotalCount();
	public void insertBoard(BoardDto dto);
	public List<BoardDto> getList(int start, int end);
	public void updateReadcount(int num);
	public BoardDto getData(int num);
	public void deleteBoard(int num);
	public void updateBoard(BoardDto dto);
	
}



