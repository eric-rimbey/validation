package validate;

import static org.junit.Assert.*;

import org.junit.Test;

public class StandardValidatorsTest {

	@Test
	public void optionalPhoneNumberAndInvalid() {
		String testString = "abc";
		Validator validator = ValidatorFactory.optionalPhoneNumber();
		ValidationResult result = validator.validation(testString);
		assertFalse(result.isValid());
		assertTrue(result.errorMessage().equals(validator.defaultMessage()));
	}

	@Test
	public void optionalPhoneNumberAndValid() {
		String testString = "425 777 8888";
		Validator validator = ValidatorFactory.optionalPhoneNumber();
		ValidationResult result = validator.validation(testString);
		assertTrue(result.isValid());
		assertTrue(result.errorMessage().isEmpty());
	}

	@Test
	public void optionalPhoneNumberButEmpty() {
		String testString = "";
		Validator validator = ValidatorFactory.optionalPhoneNumber();
		ValidationResult result = validator.validation(testString);
		assertTrue(result.isValid());
		assertTrue(result.errorMessage().isEmpty());
	}

	@Test
	public void optionalPhoneNumberButNull() {
		String testString = null;
		Validator validator = ValidatorFactory.optionalPhoneNumber();
		ValidationResult result = validator.validation(testString);
		assertTrue(result.isValid());
		assertTrue(result.errorMessage().isEmpty());
	}

	@Test
	public void requiredPhoneNumberAndInvalid() {
		String testString = "425abc";
		Validator validator = ValidatorFactory.requiredPhoneNumber();
		ValidationResult result = validator.validation(testString);
		assertFalse(result.isValid());
		assertTrue(result.errorMessage().equals(validator.defaultMessage()));
	}

	@Test
	public void requiredPhoneNumberAndValid() {
		String testString = "425 777 8888";
		Validator validator = ValidatorFactory.requiredPhoneNumber();
		ValidationResult result = validator.validation(testString);
		assertTrue(result.isValid());
		assertTrue(result.errorMessage().isEmpty());
	}

	@Test
	public void requiredPhoneNumberButEmpty() {
		String testString = "";
		Validator validator = ValidatorFactory.requiredPhoneNumber();
		ValidationResult result = validator.validation(testString);
		assertFalse(result.isValid());
		assertTrue(result.errorMessage().equals(validator.defaultMessage()));
	}

	@Test
	public void requiredPhoneNumberButNull() {
		String testString = null;
		Validator validator = ValidatorFactory.requiredPhoneNumber();
		ValidationResult result = validator.validation(testString);
		assertFalse(result.isValid());
		assertTrue(result.errorMessage().equals(validator.defaultMessage()));
	}

}
