package com.fssa.pin.model;

public class Fundraise {

	private String name;
	private String email;
	private String phno;
	private int accNo;
	private String ifscNo;
	private String accName;
	private String cause;
	private String coverpic;
	private String title;
	private String story;
	private int expectedamount;
	private int userid;
	private int fundraiseid;
	private User user; 

	public Fundraise() {  
	}

//constructor for view data

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhno() {
		return phno;
	}

	public void setPhno(String phno) {
		this.phno = phno;
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

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getCoverPic() {
		return coverpic;
	}

	public void setCoverPic(String coverPic) {
		this.coverpic = coverPic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getStory() {
		return story;
	}

	public void setStory(String story) {
		this.story = story;
	}

	public int getExpectedAmount() {
		return expectedamount;
	}

	public void setExpectedAmount(int expectedAmount) {
		this.expectedamount = expectedAmount;
	}

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public int getFundraiseid() {
		return fundraiseid;
	}

	public void setFundraiseid(int fundraiseid) {
		this.fundraiseid = fundraiseid;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "Fundraise [name=" + name + ", email=" + email + ", phno=" + phno + ", accNo=" + accNo + ", ifscNo="
				+ ifscNo + ", accName=" + accName + ", cause=" + cause + ", coverpic=" + coverpic + ", title=" + title
				+ ", story=" + story + ", expectedamount=" + expectedamount + "]";
	}

	
}
