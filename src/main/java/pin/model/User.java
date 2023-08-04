package pin.model;

public class User {
	public String getMobileno() {
		return mobileno;
	}

	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
 
	private String mail;
	private String username;
	private String password;
	private String mobileno;

	public User(String mail, String username, String password,String mobileno) {
		super();
		this.mail = mail;
		this.username = username;
		this.password = password;
		this.mobileno  = mobileno;
	}

	public User(String user_mail, String user_pwd) {
		this.mail = user_mail;
		this.password = user_pwd;
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

	@Override
	public String toString() {
	    return "User [mail=" + mail + ", username=" + username + ", password=" + password + ", mobileNo=" + mobileno + "]";
	}


}
