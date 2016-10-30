package validate;

import static org.junit.Assert.*;

import org.junit.Test;

public class BasicValidatorsTest {

	@Test
	public void failNotNull() {
		String testString = null;
		Validator validator = ValidatorFactory.notNull();
		ValidationResult result = validator.validation(testString);
		assertFalse(result.isValid());
		assertTrue(result.errorMessage().equals(validator.defaultMessage()));
	}

	@Test
	public void failNotNullWithOverrideMessage() {
		String testString = null;
		String overrideMessage = "custom error message";
		Validator validator = ValidatorFactory.notNull();
		ValidationResult result = validator.validation(testString,
				overrideMessage);
		assertFalse(result.isValid());
		assertTrue(result.errorMessage().equals(overrideMessage));
	}

	@Test
	public void passNotNull() {
		String testString = String.valueOf("a");
		Validator validator = ValidatorFactory.notNull();
		ValidationResult result = validator.validation(testString);
		assertTrue(result.isValid());
		assertTrue(result.errorMessage().isEmpty());
	}

	@Test
	public void passNotNullWithOverrideMessage() {
		String testString = String.valueOf("a");
		String overrideMessage = "custom error message";
		Validator validator = ValidatorFactory.notNull();
		ValidationResult result = validator.validation(testString,
				overrideMessage);
		assertTrue(result.isValid());
		assertTrue(result.errorMessage().isEmpty());
	}

}
