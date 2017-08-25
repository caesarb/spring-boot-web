package de.detim.stockmarket;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class UpdateComponent {

	@Autowired
	private Stockmarket marketplace;

	@Scheduled(fixedRate = 5000)
	public void reportCurrentTime() {
		marketplace.getStocks().stream().forEach(s -> s.setValue(BigDecimal.valueOf(Math.random() * 100)));
	}
}
