package validate;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class PanelValidatorsTest {

	@Test
	public void allValid() {
		List<PanelData> validatorData = new ArrayList<PanelData>();
		validatorData.add(new IncludesAlpha());
		validatorData.add(new IncludesDigit());
		validatorData.add(new MinLength(8));

		String testInput = "abcd1234";
		List<ValidationResult> results = runValidators(validatorData, context,
				store, qualifiers, testInput);
		long validCount = results.stream().filter(p -> p.isValid()).count();
		long errorCount = results.stream().filter(p -> !p.isValid()).count();

		assertEquals(3, validCount);
		assertEquals(0, errorCount);
	}

	@Test
	public void noneValid() {
		List<PanelData> validatorData = new ArrayList<PanelData>();
		validatorData.add(new IncludesAlpha());
		validatorData.add(new IncludesDigit());
		validatorData.add(new MinLength(8));

		String testInput = "";
		List<ValidationResult> results = runValidators(validatorData, context,
				store, qualifiers, testInput);
		long validCount = results.stream().filter(p -> p.isValid()).count();
		long errorCount = results.stream().filter(p -> !p.isValid()).count();

		assertEquals(0, validCount);
		assertEquals(3, errorCount);
	}

	@Test
	public void oneValid() {
		List<PanelData> validatorData = new ArrayList<PanelData>();
		validatorData.add(new IncludesAlpha());
		validatorData.add(new IncludesDigit());
		validatorData.add(new MinLength(8));

		String testInput = "abc";
		List<ValidationResult> results = runValidators(validatorData, context,
				store, qualifiers, testInput);
		long validCount = results.stream().filter(p -> p.isValid()).count();
		long errorCount = results.stream().filter(p -> !p.isValid()).count();

		assertEquals(1, validCount);
		assertEquals(2, errorCount);
	}

	@Test
	public void twoValid() {
		List<PanelData> validatorData = new ArrayList<PanelData>();
		validatorData.add(new IncludesAlpha());
		validatorData.add(new IncludesDigit());
		validatorData.add(new MinLength(8));

		String testInput = "123123123";
		List<ValidationResult> results = runValidators(validatorData, context,
				store, qualifiers, testInput);
		long validCount = results.stream().filter(p -> p.isValid()).count();
		long errorCount = results.stream().filter(p -> !p.isValid()).count();

		assertEquals(2, validCount);
		assertEquals(1, errorCount);
	}

	private List<ValidationResult> runValidators(List<PanelData> data,
			String context, String store, String qualifiers, String testInput) {
		List<ValidationResult> results = new ArrayList<ValidationResult>();

		for (PanelData pd : data) {
			Validator validator = pd.validator(context, store, qualifiers);
			results.add(validator.validation(testInput));
		}

		return results;
	}

	private String context = "CONTEXT";

	private String qualifiers = "QUALIFIERS";

	private String store = "STORE";

}
