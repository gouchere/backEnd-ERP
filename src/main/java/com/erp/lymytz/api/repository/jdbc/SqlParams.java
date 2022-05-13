package com.erp.lymytz.api.repository.jdbc;

public class SqlParams {
	private int index;
	private String paramName;
	private Object value;
	
	public SqlParams() {
		
	}
	
	public SqlParams(int index, Object value) {
		this.index = index;
		this.value = value;
	}

	public SqlParams(String name, Object value) {
		this.paramName = name;
		this.value = value;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public String getParamName() {
		return paramName;
	}

	public void setParamName(String paramName) {
		this.paramName = paramName;
	}
}
