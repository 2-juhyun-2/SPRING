package info.data;

import java.util.List;

public interface InfoDaoInter {
	
	public List<InfoDto> getAllDatas();
	public void insertInfo(InfoDto dto);
	
	public void updateInfo(InfoDto dto);
	public InfoDto getData(String num);
	
	public void deleteInfo(String num);
	
	

}
