package br.com.opencare.springdemo.model;

public enum Status {
	ACTIVE("Active"), INACTIVE("Inactive"), DELETED("Deleted"), LOCKED("Locked");

	private String status;
	
	private Status(final String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return this.status;
	}

	public String getStatus() {
		return this.name();
	}
}
