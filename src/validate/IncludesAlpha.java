package validate;

public class IncludesAlpha implements PanelData {

	@Override
	public Validator validator(String context, String store, String qualifiers) {
		return ValidatorFactory.makeValidator(p -> p.matches(".*[a-zA-Z].*"),
				"(default) expected alpha characters");
	}

}
