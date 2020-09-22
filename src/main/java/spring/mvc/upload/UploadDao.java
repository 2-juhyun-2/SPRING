package spring.mvc.upload;

import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class UploadDao extends SqlSessionDaoSupport implements UploadDaoInter{

	@Override
	public int getTotalCount() {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectCountOfUpload");
	}

	@Override
	public List<UploadDto> getAllDatas() {
		// TODO Auto-generated method stub
		return getSqlSession().selectList("selectAllOfUpload");
	}

	@Override
	public void insertUpload(UploadDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().insert("insertOfUpload",dto);
	}

	@Override
	public void deleteUpload(String num) {
		// TODO Auto-generated method stub
		getSqlSession().delete("deleteOfUpload",num);
	}

	@Override
	public UploadDto getData(String num) {
		// TODO Auto-generated method stub
		return getSqlSession().selectOne("selectOneOfUpload",num);
	}

	@Override
	public void updateUpload(UploadDto dto) {
		// TODO Auto-generated method stub
		getSqlSession().update("updateOfUpload",dto);
	}

}
