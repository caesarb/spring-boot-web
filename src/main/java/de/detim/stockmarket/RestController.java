package de.detim.stockmarket;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.RestController
public class RestController {

	@Autowired
	private Stockmarket marketplace;

	@RequestMapping("/get")
	public Stock getStock(@RequestParam(value = "name") String name) {
		return marketplace.getStock(name).get();
	}

	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(value = java.util.NoSuchElementException.class)
	public Stock handle() {
		return null;
	}
}
