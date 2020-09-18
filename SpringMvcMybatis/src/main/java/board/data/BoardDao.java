package board.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDao extends SqlSessionDaoSupport implements BoardDaointer{

	@Override
	public int getTotalCount() {
		
		return getSqlSession().selectOne("selectCountOfBoard");
	}
	@Override
	public void insertBoard(BoardDto dto)
	{
		//dao에서 dto를 넘기는 것
		getSqlSession().insert("insertOfBoard", dto);
		
	}
	
	@Override
	public List<BoardDto> getAllDatas() {
		
		return getSqlSession().selectList("selectAllOfBoard");
	
	}
	
	@Override
	public BoardDto getData(String num) {
		return getSqlSession().selectOne("selectOneOfBoard",num);
	}
	
	@Override	
	public void updateBoard(BoardDto dto) {
		
		getSqlSession().update("updateOfBoard",dto);
	}
	@Override
	public void deleteBoard(String num) {

		getSqlSession().delete("deleteOfBoard",num);
		
	}
	
	
	
}
