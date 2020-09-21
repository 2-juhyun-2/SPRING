package member.data;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDao extends SqlSessionDaoSupport implements MemberDaoInter {

	@Override
	public List<MemberDto> getAllDatas() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectAllDataOfMember");
	}

	@Override
	public void insertMember(MemberDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfMember", dto);
	}

	@Override
	public MemberDto getData(String num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectByNumOfMember", num);
	}

	@Override
	public void updateMember(MemberDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfMember", dto);
	}

	@Override
	public void deleteMember(String num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfMember", num);
	}

	@Override
	public boolean isLogin(String id, String pass) {
		// TODO Auto-generated method stub
		
		HashMap<String, String>map=new HashMap<String, String>();
		map.put("id", id);
		map.put("pass", pass);
		
		int n=getSqlSession().selectOne("loginSuccess", map);
		return n==1?true:false;
	}

	@Override
	public String getName(String id) {
		// TODO Auto-generated method stub
		String name=getSqlSession().selectOne("nameByMember",id);
		return name;
	}

}
