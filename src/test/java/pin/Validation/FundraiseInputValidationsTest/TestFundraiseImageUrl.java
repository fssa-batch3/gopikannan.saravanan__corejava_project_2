package pin.Validation.FundraiseInputValidationsTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Test;

import pin.validation.FundraiseValidation;
import pin.validation.exceptions.InvalidFundraiseException;


public class TestFundraiseImageUrl {
	@Test

	void ValidProductImage() {
		try {
			assertTrue(FundraiseValidation.validateFundraiseImageURL(
					"https://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais"));
			
		} catch (InvalidFundraiseException e) {
			System.out.println(e.getMessage());
		}

	}

	@Test

	void InValidProductImage() {
		try {
			assertFalse(FundraiseValidation.validateFundraiseImageURL(
					"lll://img.freepik.com/free-photo/beauty-portrait-ginger-woman-with-flower-hair-sitting-by-mirror-table-with-bottle-lotion-while-looking-away_171337-1068.jpg?size=626&ext=jpg&ga=GA1.2.1319163761.1690984074&semt=ais"));
			System.out.println("Image URL isn't Valid");
		} catch (InvalidFundraiseException e) {
			System.out.println(e.getMessage());
		}

	}
}
