package com.ibanheiz.utils.enums;

public enum MongoCollectionsEnum {

	CLIENTES("clientes");
	
	private MongoCollectionsEnum(String name) {
		this.name = name;
	}

	private String name;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
