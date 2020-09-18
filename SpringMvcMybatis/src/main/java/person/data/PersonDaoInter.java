package person.data;

import java.util.List;

public interface PersonDaoInter {

	public List<PersonDto> getAllDatas();
	public void insertPerson(PersonDto dto);
	
	public PersonDto getData(String num);
	public void updatePerson(PersonDto dto);
	public void deletePerson(String num);
	
}
