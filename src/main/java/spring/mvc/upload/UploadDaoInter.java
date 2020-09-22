package spring.mvc.upload;

import java.util.List;

public interface UploadDaoInter {
	
	public int getTotalCount();
	public List<UploadDto> getAllDatas();
	public void insertUpload(UploadDto dto);
	public void deleteUpload(String num);
	public UploadDto getData(String num);
	public void updateUpload(UploadDto dto);
	

}
