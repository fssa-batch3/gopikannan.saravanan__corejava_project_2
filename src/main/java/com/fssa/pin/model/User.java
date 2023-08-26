package com.fssa.pin.model;

/**
 * Represents a user in the application.
 */
public class User {

	private String mail;
	private String username;
	private String password;
	private String mobileno;
	private int accNo;
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

	/**
     * Gets the email address of the user.
     *
     * @return The email address.
     */
	public String getMail() {
		return mail;
	}
	 /**
     * Sets the email address of the user.
     *
     * @param mail The email address to set.
     */
	public void setMail(String mail) {
		this.mail = mail;
	}

	 /**
     * Gets the userName of the user.
     *
     * @return The userName.
     */ 
	public String getUsername() {
		return username;
	}
	 /**
     * Sets the userName of the user.
     *
     * @param username The userName to set.
     */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
     * Gets the password of the user.
     *
     * @return The password.
     */ 
	public String getPassword() {
		return password;
	}
	/**
     * Sets the password of the user.
     *
     * @param The password to set.
     */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
     * Gets the mobileNo of the user.
     *
     * @return The mobileNo.
     */ 
	public String getMobileno() {
		return mobileno;
	}
	/**
     * Sets the mobile number of the user.
     *
     * @param The mobile number  to set.
     */
	public void setMobileno(String mobileno) {
		this.mobileno = mobileno;
	}
	/**
     * Gets the Account number of the user.
     *
     * @return The Account number.
     */ 
	public int getAccNo() {
		return accNo;
	}
	/**
     * Sets the Account number of the user.
     *
     * @param The Account number to set.
     */
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}
	/**
     * Gets the Account ifscNumber of the user.
     *
     * @return The Account ifscNumber.
     */ 
	public String getIfscNo() {
		return ifscNo;
	}

	/**
     * Sets the Account ifscNumber of the user.
     *
     * @param The Account ifscNumber to set.
     */
	public void setIfscNo(String ifscNo) {
		this.ifscNo = ifscNo;
	}
	/**
     * Gets the Account AccountName of the user.
     *
     * @return The Account AccountName.
     */ 
	public String getAccName() {
		return accName;
	}
	/**
     * Sets the AccountName of the user.
     *
     * @param The AccountName to set.
     */
	public void setAccName(String accName) {
		this.accName = accName;
	}
	/**
     * Gets the userId of the user.
     *
     * @return The userId.
     */ 
	public int getUserid() {
		return userid;
	}
	/**
     * Sets the userId of the user.
     *
     * @param The userId to set.
     */
	public void setUserid(int userid) {
		this.userid = userid;
	}



}
