package pin.model;

public class Fundraise {
	@Override
	public String toString() {
		return "Fundraise [name=" + name + ", email=" + email + ", phno=" + phno + ", cause=" + cause + ", cover_pic="
				+ cover_pic + ", title=" + title + ", story=" + story + ", expected_amount=" + expected_amount + "]";
	}

	private String name;
	private String email;
	private String phno;
	private String cause;
	private String cover_pic;
	private String title;
	private String story;
	private int expected_amount;

	public Fundraise(String name, String email, String phno, String cause, String cover_pic, String title, String story,
			int expected_amount) {

		this.name = name;
		this.email = email;
		this.phno = phno;
		this.cause = cause;
		this.cover_pic = cover_pic;
		this.title = title;
		this.story = story;
		this.expected_amount = expected_amount;
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

	public String getCause() {
		return cause;
	}

	public void setCause(String cause) {
		this.cause = cause;
	}

	public String getCover_pic() {
		return cover_pic;
	}

	public void setCover_pic(String cover_pic) {
		this.cover_pic = cover_pic;
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
		return expected_amount;
	}

	public void setExpected_amount(int expected_amount) {
		this.expected_amount = expected_amount;
	}

}
