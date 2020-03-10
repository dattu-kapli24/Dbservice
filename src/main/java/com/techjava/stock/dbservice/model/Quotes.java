package com.techjava.stock.dbservice.model;

import java.util.List;

public class Quotes {

	private List<String> quotes;
    private String username;
    
    public Quotes() {}

	public Quotes(List<String> quotes, String username) {
		super();
		this.quotes = quotes;
		this.username = username;
	}

	public List<String> getQuotes() {
		return quotes;
	}

	public void setQuotes(List<String> quotes) {
		this.quotes = quotes;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
    

	
	
}
