package com.example.restService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalculateController {
	private CalculationService calculationService = new CalculationService("empty");

	@CrossOrigin(origins = "http://localhost:5000")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/calculate", consumes = "application/json", produces = "application/json")
	public String calculate(@RequestBody CalculationRequest request) {
		String result = calculationService.eval(request);
		return "{\"result\": \""+result+"\"}";
	}

	@CrossOrigin(origins = "http://localhost:5000")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/store", consumes = "application/json", produces = "application/json")
	public void store(@RequestBody StoreRequest request) {
		this.calculationService.storeValue = request.store;
	}
	
	@CrossOrigin(origins = "http://localhost:5000")
	@ResponseStatus(HttpStatus.OK)
	@GetMapping(value = "/store", produces = "application/json")
	public String store() {
		return "{\"result\": \""+this.calculationService.storeValue+"\"}";
	}
	
}