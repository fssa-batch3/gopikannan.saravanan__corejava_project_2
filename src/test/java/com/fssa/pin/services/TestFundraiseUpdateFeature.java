package com.fssa.pin.services;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

import com.fssa.pin.model.Fundraise;
import com.fssa.pin.service.FundraiseService;
import com.fssa.pin.service.exception.ServiceException;

class TestFundraiseUpdateFeature {

	@Test
	void testUpdateSuccess() { 


		FundraiseService fundraiseservice = new FundraiseService();

		try {
			int fundraiseId = fundraiseservice.fundraiseGetFundraiseId();
	
			Fundraise fundraise = new Fundraise();
			fundraise.setCause("Education");
			fundraise.setCoverPic("https://www.google.com/imgres?imgurl=https%3A%2F%2Fgogetfunding.com%2Fwp-content%2Fuploads%2F2012%2F06%2F11737%2Fprimary_image.jpg&tbnid=0VbTGHhKTjE1NM&vet=12ahUKEwiFzNKA7faAAxWSpekKHSguC1gQMygBegQIARBS..i&imgrefurl=https%3A%2F%2Fgogetfunding.com%2Fhelp-to-educate-poor-children-in-india%2F&docid=f2ZBoLrO-_1-9M&w=525&h=362&q=education%20for%20poor%20story&ved=2ahUKEwiFzNKA7faAAxWSpekKHSguC1gQMygBegQIARBS");
			fundraise.setTitle("Help this students to achieve their dreams");
			fundraise.setStory(" In a poverty-stricken community, there was a strong desire for education. The residents, despite their financial hardships, recognized the value of education in breaking the cycle of poverty. Determined to make a change, a group of individuals came forward and established a non-profit organization. With limited resources but infinite determination, they created a program that provided scholarships, mentorship, and skill development opportunities to the needy members of the community. Through their selfless efforts, children and adults who had once been denied access to education were given a chance to learn and grow. As the community embraced this opportunity, remarkable transformations took place. Graduates from this program went on to pursue higher education, secure better jobs, and contribute to the development of their community. Their success stories continue to inspire others, proving that education truly has the power to lift individuals and communities out of poverty.");
			fundraise.setExpectedAmount(500000);
			fundraise.setFundraiseid(fundraiseId);
			assertTrue(fundraiseservice.fundraiseUpdate(fundraise));
			

		} catch (ServiceException e) {
			
			e.printStackTrace();
			fail();

		}
	} 

	@Test
	void testUpdateFail() {

		FundraiseService fundraiseservice = new FundraiseService();
		Fundraise fundraise = new Fundraise();
		
		fundraise.setCause(null);
		fundraise.setCoverPic(null);
		fundraise.setTitle(null);
		fundraise.setStory(null);
		fundraise.setExpectedAmount(0);
		fundraise.setFundraiseid(0);
		try {

			assertFalse(fundraiseservice.fundraiseUpdate(fundraise));

		} catch (ServiceException e) {
			System.out.println(e.getMessage());

		}
	}
}
