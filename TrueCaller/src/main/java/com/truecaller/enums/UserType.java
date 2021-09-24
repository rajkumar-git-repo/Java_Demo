package com.truecaller.enums;

import java.util.EnumSet;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonValue;

public enum UserType {
	
	ROLE_USER(1, "USER");

	UserType(Integer value, String label) {
		this.value = value;
		this.label = label;
	}

	private Integer value;
	private String label;

	@JsonValue
	public String toValue() {
		return this.label;
	}

	public Integer getValue() {
		return value;
	}

	public String getLabel() {
		return label;
	}
}
