package validate;

public interface Validator {

	public String defaultMessage();

	public ValidationResult validation(String input);

	public ValidationResult validation(String input, String overrideMessage);

}
