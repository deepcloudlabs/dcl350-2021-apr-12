package com.example.crm.domain;

import java.util.Map;
import java.util.Objects;
import java.util.WeakHashMap;

/**
 * 
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 *
 */
// Value Object -> i) has no identity ii) immutable class
public final class TcKimlikNo {
	private final String value;
	private final static Map<String, TcKimlikNo> identityCache = new WeakHashMap<>();

	private TcKimlikNo(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

	public static TcKimlikNo valueOf(String value) {
		Objects.requireNonNull(value);
		// validation : cross-cutting concern
		if (!isValidate(value))
			throw new IllegalArgumentException("This is not  valid identity no.");
		// caching -> Fly-weight (GoF) : cross-cutting concern
		synchronized (TcKimlikNo.class) {
			var identity = identityCache.get(value);
			if (Objects.isNull(identity)) {
				identity = new TcKimlikNo(value);
				identityCache.put(value, identity);
			}
			return identity;
		}
	}

	private static boolean isValidate(String value) {
		if (value == null)
			return false;
		if (!value.matches("^\\d{11}$")) {
			return false;
		}
		int[] digits = new int[11];
		for (int i = 0; i < digits.length; ++i) {
			digits[i] = value.charAt(i) - '0';
		}
		int x = digits[0];
		int y = digits[1];
		for (int i = 1; i < 5; i++) {
			x += digits[2 * i];
		}
		for (int i = 2; i <= 4; i++) {
			y += digits[2 * i - 1];
		}
		int c1 = 7 * x - y;
		if (c1 % 10 != digits[9]) {
			return false;
		}
		int c2 = 0;
		for (int i = 0; i < 10; ++i) {
			c2 += digits[i];
		}
		if (c2 % 10 != digits[10]) {
			return false;
		}
		return true;
	}

}
