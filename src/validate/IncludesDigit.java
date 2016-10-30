package validate;

public class IncludesDigit implements PanelData {

	@Override
	public Validator validator(String context, String store, String qualifiers) {
		return ValidatorFactory.makeValidator(p -> p.matches(".*\\d.*"),
				"(default) expected digits");
	}

}
