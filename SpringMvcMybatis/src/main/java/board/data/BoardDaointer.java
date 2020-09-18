package board.data;

import java.util.List;

public interface BoardDaointer {
	
	public int getTotalCount();	
	public void insertBoard(BoardDto dto);	
	public List<BoardDto> getAllDatas();	
	public BoardDto getData(String num);
	public void updateBoard(BoardDto dto);
	public void deleteBoard(String num);
	

	
}
