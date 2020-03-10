package com.techjava.stock.dbservice.resource;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techjava.stock.dbservice.model.Quote;
import com.techjava.stock.dbservice.model.Quotes;
import com.techjava.stock.dbservice.repository.QuoteRepositroy;

@RestController
@RequestMapping("/rest/db")
public class Dbresource {
	
	 @Autowired
	 private QuoteRepositroy quoteReposiotry; 
	
	@GetMapping("/{username}")
   public List<String> getQuotes(@PathVariable("username") final String username){
		
		return getQuoteByUserName(username);
	}
	
	@PostMapping("/add")
	public List<String> add(@RequestBody final Quotes quotes){
		quotes.getQuotes()
		      .stream()
		      .map(quote->new Quote(quotes.getUsername(),quote))
		      .forEach(quote->quoteReposiotry.save(quote));
		
		return  getQuoteByUserName(quotes.getUsername());
		      
	}
	
	@PostMapping("/delete/{username}")
	public List<String> deleteQuote(@PathVariable("username") String username ){
		 
		List<Quote> quotes=quoteReposiotry.findByUsername(username);
		quotes.forEach((quote)->quoteReposiotry.delete(quote));
		return  getQuoteByUserName(username);
	}
	
	public List<String> getQuoteByUserName(String username){
		
		 return quoteReposiotry.findByUsername(username)
				.stream()
				.map(quote->{return quote.getQuote();} )
				.collect(Collectors.toList());
	}
	
}
