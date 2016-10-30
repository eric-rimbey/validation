package validate;

public class MinLength implements PanelData {

	@Override
	public Validator validator(String context, String store, String qualifiers) {
		return ValidatorFactory.makeValidator(p -> this.min <= p.length(),
				"(default) expected digits");
	}

	public MinLength(int min) {
		this.min = min;
	}

	private int min;

}
