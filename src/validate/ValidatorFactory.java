package validate;

import java.util.function.Predicate;

public class ValidatorFactory {

	public static Validator isEmpty() {
		return makeValidator(isEmptyPredicate(),
				"(default) value must be empty");
	}

	public static Validator isNull() {
		return makeValidator(isNullPredicate(), "(default) value must be null");
	}

	public static Validator isNullOrEmpty() {
		return new DisjuctiveValidator(isNull(), isEmpty());
	}

	public static Validator makeValidator(Predicate<String> predicate,
			String defaultMessage) {
		return new Validator() {

			@Override
			public String defaultMessage() {
				return defaultMessage;
			}

			@Override
			public ValidationResult validation(String input) {
				return validation(input, defaultMessage());
			}

			@Override
			public ValidationResult validation(String input,
					String overrideMessage) {
				if (predicate.test(input)) {
					return new JustValid();
				} else {
					return new JustError(overrideMessage);
				}
			}
		};
	}

	public static Validator notNull() {
		return makeValidator(notNullPredicate(),
				"(default) value should not be null");
	}

	public static Validator optionalPhoneNumber() {
		return new DisjuctiveValidator(isNullOrEmpty(), phoneNumber());
	}

	public static Validator requiredPhoneNumber() {
		return new ConjuctiveValidator(notNull(), phoneNumber());
	}

	private static Predicate<String> isEmptyPredicate() {
		return p -> "".equals(p);
	}

	private static Predicate<String> isNullPredicate() {
		return p -> null == p;
	}

	private static Predicate<String> notNullPredicate() {
		return p -> null != p;
	}

	private static Validator phoneNumber() {
		return makeValidator(phoneNumberPredicate(),
				"(default) number should be valid");
	}

	private static Predicate<String> phoneNumberPredicate() {
		return p -> 10 == scrubPhoneNumber(p).length();
	}

	private static String scrubPhoneNumber(String p) {
		// just an example of how could process input before testing it
		return p.replaceAll("\\D+", "");
	}

}
