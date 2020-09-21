package guest.data;

import java.util.List;

public interface GuestDaoInter {
	
	public void insertGuest(GuestDto dto);
	public List<GuestDto>getList(int start, int end);
	public int getTotalCount();
	public void deleteGuest(int num);
	public GuestDto getData(int num);
	
}
