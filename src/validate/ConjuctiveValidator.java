package validate;

public class ConjuctiveValidator implements Validator {

	@Override
	public String defaultMessage() {
		return defaultMessage;
	}

	@Override
	public ValidationResult validation(String input) {
		return validation(input, defaultMessage());
	}

	@Override
	public ValidationResult validation(String input, String overrideMessage) {
		ValidationResult firstResult = first.validation(input, overrideMessage);
		if (!firstResult.isValid()) {
			return firstResult;
		}

		ValidationResult secondResult = second.validation(input,
				overrideMessage);
		if (!secondResult.isValid()) {
			return secondResult;
		}

		return new JustValid();
	}

	public ConjuctiveValidator(Validator first, Validator second) {
		this.first = first;
		this.second = second;
		this.defaultMessage = first.defaultMessage() + " AND "
				+ second.defaultMessage();
	}

	private String defaultMessage;

	private Validator first;

	private Validator second;

}
