package com.erp.lymytz.api.model;

public class ResultAction<T> {
	
	private boolean succes;
	private T entity;
	private String message;
	
	public ResultAction(boolean succes, T entity, String message) {
		this.succes = succes;
		this.entity = entity;
		this.message = message;
	}
	
	public boolean isSucces() {
		return succes;
	}
	
	public void setSucces(boolean succes) {
		this.succes = succes;
	}
	
	public T getEntity() {
		return entity;
	}
	
	public void setEntity(T entity) {
		this.entity = entity;
	}
	
	public String getMessage() {
		return message;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	

}
