package pin.model;

public class User {

	private String mail;
	private String username;
	private String password;
	private String mobileno;
	private int accNo;
	private String ifscNo;
	private String accName;
	private int userid;

	public User() {
	};

	public User(String mail, String username, String password, String mobileno) {

		this.mail = mail;
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
	}

	public User(String mail, String username, String password, String mobileno, int accNo, String ifscNo,
			String accName) {

		this.mail = mail;
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
		this.accNo = accNo;
		this.ifscNo = ifscNo;
		this.accName = accName;
	}

	public User(String user_mail, String user_pwd) {
		this.mail = user_mail;
		this.password = user_pwd;
	}
	

	public User(String mail, String username, String password, String mobileno, int accNo, String ifscNo,
			String accName, int userid) {
		
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.mobileno = mobileno;
		this.accNo = accNo;
		this.ifscNo = ifscNo;
		this.accName = accName;
		this.userid = userid;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getIfscNo() {
		return ifscNo;
	}

	public void setIfscNo(String ifscNo) {
		this.ifscNo = ifscNo;
	}

	public String getAccName() {
		return accName;
	}

	public void setAccName(String accName) {
		this.accName = accName;
	}
	
	
	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	
	@Override
	public String toString() {
		return "User [mail=" + mail + ", username=" + username + ", password=" + password + ", mobileNo=" + mobileno
				+ "]";
	}

	

}
