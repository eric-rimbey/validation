package validate;

public class JustValid implements ValidationResult {

	@Override
	public String errorMessage() {
		return "";
	}

	@Override
	public boolean isValid() {
		return true;
	}

}
