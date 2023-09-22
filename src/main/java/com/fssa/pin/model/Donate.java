package com.fssa.pin.model;

public class Donate {


	private int donaterContribution;
	private int donaterId;
	 private String donationDate; 
	private User user;
	private Fundraise fundraise;



	public int getDonaterContribution() {
		return donaterContribution;
	}

	public void setDonaterContribution(int donaterContribution) {
		this.donaterContribution = donaterContribution;
	}

	


	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	public Fundraise getFundraise() {
		return fundraise;
	}

	public void setFundraise(Fundraise fundraise) {
		this.fundraise = fundraise;
	}
	
	
	
	

	

	public int getDonaterId() {
		return donaterId;
	}

	public void setDonaterId(int donaterId) {
		this.donaterId = donaterId;
	}
	
	
	

	public String getDonationDate() {
		return donationDate;
	}

	public void setDonationDate(String donationDate) {
		this.donationDate = donationDate;
	}

	public String toString() {
	    StringBuilder sb = new StringBuilder();
	    sb.append("Donate [donaterContribution=" + donaterContribution);

	    if (user != null) {
	        sb.append(", DonaterUser=" + user.toString());
	    } else {
	        sb.append(", DonaterUser=null");
	    }

	    if (fundraise != null) {
	        sb.append(", fundraise=" + fundraise.toString());
	    } else {
	        sb.append(", fundraise=null");
	    }

	    sb.append("]");

	    return sb.toString();
	}


}


