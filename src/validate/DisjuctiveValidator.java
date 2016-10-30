package validate;

public class DisjuctiveValidator implements Validator {

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
		if (first.validation(input).isValid()) {
			return new JustValid();
		}

		if (second.validation(input).isValid()) {
			return new JustValid();
		}

		return new JustError(overrideMessage);
	}

	public DisjuctiveValidator(Validator first, Validator second) {
		this.first = first;
		this.second = second;
		this.defaultMessage = first.defaultMessage() + " OR "
				+ second.defaultMessage();
	}

	private String defaultMessage;

	private Validator first;

	private Validator second;

}
