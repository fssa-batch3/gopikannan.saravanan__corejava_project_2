package com.fssa.pin.model;

/**
 * Represents a user in the application.
 */
public class User {

	private String mail;
	private String username;
	private String password;
	private String mobileno;
	private long accNo;
	private String ifscNo;
	private String accName;
	private int userid;

	/**
	 * Constructs a new User instance.
	 */
	public User() {
	}

	/**
	 * Constructs a new User instance with specified details.
	 *
	 * @param mail     The email address of the user.
	 * @param username The userName of the user.
	 * @param password The password of the user.
	 * @param mobileno The mobile number of the user.
	 * @param accNo    The bank account number of the user.
	 * @param ifscNo   The IFSC code of the user's bank.
	 * @param accName  The account holder's name.
	 */
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

	public long getAccNo() {
		return accNo;
	}

	public void setAccNo(long accNo) {
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
	    return "User{" +
	            "Name='" + username + '\'' +
	            ", Email='" + mail + '\'' +
	            ", Phone='" + mobileno + '\'' +
	            ", Account Number=" + accNo +
	            ", IFSC Code='" + ifscNo + '\'' +
	            ", Account Holder='" + accName + '\'' +
	            ", UserId=" + userid +
	            ", Password='" + password + '\'' + 
	            '}';
	}


	public String getAccountDetailsAsString() {
		return "User [" + "accNo=" + accNo + ", ifscNo=" + ifscNo + ", accName=" + accName + "]";
	}

}
