package com.techjava.stock.dbservice.model;

import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Quote")
public class Quote {
	
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
 	private Integer id;

    @Column(name = "user_name")
	private String username;
    
    @Column(name = "quote")
	private String quote;
	

	public Quote() {} 
	
	public Quote(String username, String quote) {
		super();
		this.username = username;
		this.quote = quote;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getQuote() {
		return quote;
	}

	public void setQuote(String quote) {
		this.quote = quote;
	}
	
	
}
