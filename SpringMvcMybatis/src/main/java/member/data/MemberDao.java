package member.data;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao extends SqlSessionDaoSupport implements MemberDaoInter{

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCountOfMember");
	}
	
	@Override
	public List<MemberDto> getAllDatas()
{
		return getSqlSession().selectList("selectAllOfMember");
		
}

	@Override
	public void insertMember(MemberDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfMember",dto);
	}

	@Override
	public void updateMember(MemberDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfMember",dto);

	}

	@Override
	public void deleteMember(String no) {
		// TODO Auto-generated method stub
		 getSqlSession().delete("deleteOfMember",no);

	}

	@Override
	public MemberDto getData(String no) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectByNoOfMember", no);
	}



	
}
