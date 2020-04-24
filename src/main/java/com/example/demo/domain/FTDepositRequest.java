package com.example.demo.domain;

public class FTDepositRequest {

	private Integer id;
	
	private String state;
	
	private String clientID;
	
	private String account;
	
	private Boolean fundsRequested;
	
	private Boolean fundsLoaded;
	
	private String lastActivity;

	public FTDepositRequest() { }
	
	public FTDepositRequest(Integer id, String state, String clientID, String account, Boolean fundsRequested,
			Boolean fundsLoaded, String lastActivity) {
		super();
		this.id = id;
		this.state = state;
		this.clientID = clientID;
		this.account = account;
		this.fundsRequested = fundsRequested;
		this.fundsLoaded = fundsLoaded;
		this.lastActivity = lastActivity;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getClientID() {
		return clientID;
	}

	public void setClientID(String clientID) {
		this.clientID = clientID;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Boolean getFundsRequested() {
		return fundsRequested;
	}

	public void setFundsRequested(Boolean fundsRequested) {
		this.fundsRequested = fundsRequested;
	}

	public Boolean getFundsLoaded() {
		return fundsLoaded;
	}

	public void setFundsLoaded(Boolean fundsLoaded) {
		this.fundsLoaded = fundsLoaded;
	}

	public String getLastActivity() {
		return lastActivity;
	}

	public void setLastActivity(String lastActivity) {
		this.lastActivity = lastActivity;
	}

}
