package member.data;

import java.sql.Timestamp;

public class MemberDto {
	
	private String no;
	private String name;
	private String ban;
	private String hp;
	private Timestamp gaipday;
	
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBan() {
		return ban;
	}
	public void setBan(String ban) {
		this.ban = ban;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public Timestamp getGaipday() {
		return gaipday;
	}
	public void setGaipday(Timestamp gaipday) {
		this.gaipday = gaipday;
	}

	
	


}
