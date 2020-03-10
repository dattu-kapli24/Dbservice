package com.techjava.stock.dbservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.techjava.stock.dbservice.model.Quote;

@Repository
public interface QuoteRepositroy extends JpaRepository<Quote, Integer> {
 
	List<Quote> findByUsername(String username);
}
