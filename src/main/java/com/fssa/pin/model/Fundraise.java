package com.fssa.pin.model;

/**
 * Represents a fundRaising campaign.
 */
public class Fundraise {

    private String cause; // The cause of the fundRaising campaign.
    private String coverpic; // URL of the cover picture for the campaign.
    private String title; // The title of the campaign.
    private String story; // The story or description of the campaign.
	private String document; // The required document the campaign
    private int expectedamount; // The expected amount to be raised.
	private int amountReceived;// The actual amount raised.
    private int fundraiseid; // The unique identifier for the campaign.
    private int fundraiseUserId;// The unique identifier for the campaign who created.
	private User user; // The user associated with the campaign.

    /**
     * Gets the cause of the fundRaising campaign.
     *
     * @return The cause.
     */
    public String getCause() {
        return cause;
    }

    /**
     * Sets the cause of the fundRaising campaign.
     *
     * @param cause The cause to set.
     */
    public void setCause(String cause) {
        this.cause = cause;
    }

    /**
     * Gets the URL of the cover picture for the campaign.
     *
     * @return The cover picture URL.
     */
    public String getCoverPic() {
        return coverpic;
    }

    /**
     * Sets the URL of the cover picture for the campaign.
     *
     * @param coverPic The cover picture URL to set.
     */
    public void setCoverPic(String coverPic) {
        this.coverpic = coverPic;
    }

    /**
     * Gets the title of the fundRaising campaign.
     *
     * @return The title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of the fundraising campaign.
     *
     * @param title The title to set.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the story of the fundRaising campaign.
     *
     * @return The story.
     */
    public String getStory() {
        return story;
    }

    /**
     * Sets the story or description of the fundRaising campaign.
     *
     * @param story The story to set.
     */
    public void setStory(String story) {
        this.story = story;
    }

    /**
     * Gets the expected amount to be raised for the campaign.
     *
     * @return The expected amount.
     */
    public int getExpectedAmount() {
        return expectedamount;
    }

    /**
     * Sets the expected amount to be raised for the campaign.
     *
     * @param expectedAmount The expected amount to set.
     */
    public void setExpectedAmount(int expectedAmount) {
        this.expectedamount = expectedAmount;
    }
    
    
    public int getAmountReceived() {
		return amountReceived;
	}

	public void setAmountReceived(int amountReceived) {
		this.amountReceived = amountReceived;
	}


    /**
     * Gets the unique identifier for the fundRaising campaign.
     *
     * @return The campaign identifier.
     */
    public int getFundraiseid() {
        return fundraiseid;
    }

    /**
     * Sets the unique identifier for the fundRaising campaign.
     *
     * @param fundraiseid The campaign identifier to set.
     */
    public void setFundraiseid(int fundraiseid) {
        this.fundraiseid = fundraiseid;
    }

    /**
     * Gets the user associated with the fundRaising campaign.
     *
     * @return The user.
     */
    public User getUser() {
        return user;
    }

    /**
     * Sets the user associated with the fundRaising campaign.
     *
     * @param user The user to set.
     */
    public void setUser(User user) {
        this.user = user;
    }
    

    /**
     * Sets the document for the fundRaising campaign.
     *
     * @param document for The campaign fundraiser to set.
     */
    public String getDocument() {
		return document;
	}
    /**
     * Gets the document  with the fundRaising campaign.
     *
     * @return The document.
     */
	public void setDocument(String document) {
		this.document = document;
	}

	
	  /**
     * Sets the userIdforfundraise for the fundRaising campaign.
     *
     * @param userIdforfundraise for The campaign to set.
     */
	public int getFundraiseUserId() {
		return fundraiseUserId;
	}

	public void setFundraiseUserId(int fundraiseUserId) {
		this.fundraiseUserId = fundraiseUserId;
	}



    /**
     * Returns a string representation of the fundRaising campaign.
     *
     * @return A string representation.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Fundraise [" +
               "cause=" + cause +
               ", coverpic=" + coverpic +
               ", title=" + title +
               ", story=" + story +
               ", expectedamount=" + expectedamount +
               ", amountReceived=" + amountReceived + 
               ", document=" + document + 
               ", fundraiseid=" + fundraiseid +
               ", fundraiseUserId=" + fundraiseUserId
        		);

        if (user != null) {
            sb.append(", user=" + user.toString());
        } else {
            sb.append(", user=null");
        }

        sb.append("]");

        return sb.toString();
    }
} 
