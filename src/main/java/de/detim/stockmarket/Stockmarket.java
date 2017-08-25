package de.detim.stockmarket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Service;

@Service
public class Stockmarket {

	List<Stock> stocks = new ArrayList<>();
	
	@PostConstruct
	void initStocks(){
		Stock adidas = new Stock();
		adidas.setName("adidas");
		adidas.setValue(BigDecimal.TEN);
		stocks.add(adidas);
	}
	
	public List<Stock> getStocks() {
		return stocks;
	}

	public Optional<Stock> getStock(String name){
		return stocks.stream().findFirst().filter(s -> s.getName().equals(name));
	}
}
