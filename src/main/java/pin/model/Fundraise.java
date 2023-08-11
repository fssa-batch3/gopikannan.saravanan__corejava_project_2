package pin.model;

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

//	create 
	public Fundraise(String name, String email, String phno, int accNo, String ifscNo, String accName, int userid,
			String cause, String cover_pic, String title, String story, int expected_amount) {

		this.name = name;
		this.email = email;
		this.phno = phno;
		this.accNo = accNo;
		this.ifscNo = ifscNo;
		this.accName = accName;
		this.userid = userid;
		this.cause = cause;
		this.coverpic = cover_pic;
		this.title = title;
		this.story = story;
		this.expectedamount = expected_amount;
	}
//constructor for create usdr
	public Fundraise(String name, String email, String phno, int accNo, String ifscNo, String accName, int userid,
			String cause, String cover_pic, String title, String story, int expected_amount, int fundraiseid) {

		this.name = name;
		this.email = email;
		this.phno = phno;
		this.accNo = accNo;
		this.ifscNo = ifscNo;
		this.accName = accName;
		this.userid = userid;
		this.cause = cause;
		this.coverpic = cover_pic;
		this.title = title;
		this.story = story;
		this.expectedamount = expected_amount;
		this.fundraiseid =fundraiseid;
	}

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

	public String getCover_pic() {
		return coverpic;
	}

	public void setCover_pic(String cover_pic) {
		this.coverpic = cover_pic;
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

	public int getExpected_amount() {
		return expectedamount;
	}

	public void setExpected_amount(int expected_amount) {
		this.expectedamount = expected_amount;
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
				+ ifscNo + ", accName=" + accName + ", cause=" + cause + ", cover_pic=" + coverpic + ", title=" + title
				+ ", story=" + story + ", expected_amount=" + expectedamount + ", userid=" + userid + ", fundraiseid="
				+ fundraiseid + "]";
	}
	

}
