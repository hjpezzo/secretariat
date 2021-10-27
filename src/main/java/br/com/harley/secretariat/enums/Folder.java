package br.com.harley.secretariat.enums;

public enum Folder {

	HEALTH("HEALTH"), EDUCATION("EDUCATION"), SPORTS("SPORTS"), INFRASTRUCTURE("INFRASTRUCTURE");

	private final String value;

	Folder(String value) {
		this.value = value;
	}

	public String getValue() {
		return value;
	}

}
