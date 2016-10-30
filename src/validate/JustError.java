package validate;

public class JustError implements ValidationResult {

	@Override
	public String errorMessage() {
		return errorMessage;
	}

	@Override
	public boolean isValid() {
		return false;
	}

	public JustError(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	private String errorMessage;

}
