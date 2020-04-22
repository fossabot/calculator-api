package com.example.restService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class CalculateController {
	
	@CrossOrigin(origins = "http://localhost:5000")
	@ResponseStatus(HttpStatus.OK)
	@PostMapping(value = "/calculate", consumes = "application/json", produces = "application/json")
	public String calculate(@RequestBody CalculationRequest request) {
		
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		
		String result = "";
		try {
			result =  engine.eval(request.calculation).toString();
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		
		return "{\"result\": \""+result+"\"}";
	}
	
}