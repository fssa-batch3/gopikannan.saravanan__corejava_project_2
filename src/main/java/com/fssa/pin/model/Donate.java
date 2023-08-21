package com.fssa.pin.model;

public class Donate {

	private String donaterName;
	private String donaterEmail;
	private String donaterid;
	private int donaterContribution;
	private String donationFor;
	private String fundraiserName;
	private String fundrasierEmail;
	private int fromAccNo;
	private String fromAccIfscNo;
	private String fromAccHolderName;
	private int toAccNo;
	private String toAccIfscNo;
	private String toAccHolderName;
	private User user;
	private Fundraise fundraise;

	public Donate() {
	}
//	 constructor to view donation detail 

	public Donate(String donaterName, String donaterEmail, int donaterContribution, String donationFor,
			String fundraiserName, String fundrasierEmail, int fromAccNo, String fromAccIfscNo,
			String fromAccHolderName, int toAccNo, String toAccIfscNo, String toAccHolderName) {
		this.donaterName = donaterName;
		this.donaterEmail = donaterEmail;
		this.donaterContribution = donaterContribution;
		this.donationFor = donationFor;
		this.fundraiserName = fundraiserName;
		this.fundrasierEmail = fundrasierEmail;
		this.fromAccNo = fromAccNo;
		this.fromAccIfscNo = fromAccIfscNo;
		this.fromAccHolderName = fromAccHolderName;
		this.toAccNo = toAccNo;
		this.toAccIfscNo = toAccIfscNo;
		this.toAccHolderName = toAccHolderName;
	}

	public String getDonaterName() {
		return donaterName;
	}

	public void setDonaterName(String donaterName) {
		this.donaterName = donaterName;
	}

	public String getDonaterEmail() {
		return donaterEmail;
	}

	public void setDonaterEmail(String donaterEmail) {
		this.donaterEmail = donaterEmail;
	}

	public String getDonaterid() {
		return donaterid;
	}

	public void setDonaterid(String donaterid) {
		this.donaterid = donaterid;
	}

	public int getDonaterContribution() {
		return donaterContribution;
	}

	public void setDonaterContribution(int donaterContribution) {
		this.donaterContribution = donaterContribution;
	}

	public String getDonationFor() {
		return donationFor;
	}

	public void setDonationFor(String donationFor) {
		this.donationFor = donationFor;
	}

	public String getFundraiserName() {
		return fundraiserName;
	}

	public void setFundraiserName(String fundraiserName) {
		this.fundraiserName = fundraiserName;
	}

	public String getFundrasierEmail() {
		return fundrasierEmail;
	}

	public void setFundrasierEmail(String fundrasierEmail) {
		this.fundrasierEmail = fundrasierEmail;
	}

	public int getFromAccNo() {
		return fromAccNo;
	}

	public void setFromAccNo(int fromAccNo) {
		this.fromAccNo = fromAccNo;
	}

	public String getFromAccIfscNo() {
		return fromAccIfscNo;
	}

	public void setFromAccIfscNo(String fromAccIfscNo) {
		this.fromAccIfscNo = fromAccIfscNo;
	}

	public String getFromAccHolderName() {
		return fromAccHolderName;
	}

	public void setFromAccHolderName(String fromAccHolderName) {
		this.fromAccHolderName = fromAccHolderName;
	}

	public int getToAccNo() {
		return toAccNo;
	}

	public void setToAccNo(int toAccNo) {
		this.toAccNo = toAccNo;
	}

	public String getToAccIfscNo() {
		return toAccIfscNo;
	}

	public void setToAccIfscNo(String toAccIfscNo) {
		this.toAccIfscNo = toAccIfscNo;
	}

	public String getToAccHolderName() {
		return toAccHolderName;
	}

	public void setToAccHolderName(String toAccHolderName) {
		this.toAccHolderName = toAccHolderName;
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

	@Override
	public String toString() {
		return "DonateModel [donaterName=" + donaterName + ", donaterEmail=" + donaterEmail + ", donaterContribution="
				+ donaterContribution + ", donationFor=" + donationFor + ", fundraiserName=" + fundraiserName
				+ ", fundrasierEmail=" + fundrasierEmail + ", fromAccNo=" + fromAccNo + ", fromAccIfscNo="
				+ fromAccIfscNo + ", fromAccHolderName=" + fromAccHolderName + ", toAccNo=" + toAccNo + ", toAccIfscNo="
				+ toAccIfscNo + ", toAccHolderName=" + toAccHolderName + "]";
	}

}
