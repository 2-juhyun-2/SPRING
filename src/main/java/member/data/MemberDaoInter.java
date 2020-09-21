package member.data;

import java.util.List;

public interface MemberDaoInter {
	
	public List<MemberDto> getAllDatas();
	public void insertMember(MemberDto dto);
	
	//getDData
	public MemberDto getData(String num);
	
	//update
	public void updateMember(MemberDto dto);
	
	//delete
	public void deleteMember(String num);
	
	//아이디비번체크
	public boolean isLogin(String id, String pass);
	
	//네임얻기
	public String getName(String id);
	
}
