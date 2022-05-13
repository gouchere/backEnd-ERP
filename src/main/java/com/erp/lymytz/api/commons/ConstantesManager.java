package com.erp.lymytz.api.commons;

public class ConstantesManager {

	public static String regexParam = "\\b(:\\D\\w*)\\b";

	public static boolean isNumeric(Object val) {
		return val != null ? isNumeric(val.toString()) : false;
	}

	public static boolean isNumeric(String val) {
		if (isString(val)) {
			try {
				Float.valueOf(val);
				return true;
			} catch (Exception ex) {
			}
		}
		return false;
	}

	public static boolean isLong(Long val) {
		return (val != null) ? val > 0 : false;
	}

	public static boolean isInteger(Integer val) {
		return (val != null) ? val > 0 : false;
	}

	public static boolean isString(String val) {
		return (val != null) ? !val.trim().isEmpty() : false;
	}

	public static boolean isDouble(Double val) {
		return (val != null) ? val > -1 : false;
	}
}
