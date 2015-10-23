package solutions.egen.model;

public class Customer {

	private int ID;
	private String firstName;
	private String lastName;
	private long phoneNum;
	private String email;
	private String confCode;
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public long getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(long phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getConfCode() {
		return confCode;
	}
	public void setConfCode(String confCode) {
		this.confCode = confCode;
	}
	
	
}
