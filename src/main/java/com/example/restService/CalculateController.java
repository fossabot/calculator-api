package com.example.restService;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CalculateController {
	@CrossOrigin(origins = "http://localhost:5000")
	@PostMapping("/calculate")
	public Object calculate(@RequestParam(value = "calculation", defaultValue = "0") String calculation) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("js");
		Object result = calculation;
		try {
			result = engine.eval(calculation);
		} catch (ScriptException e) {
			e.printStackTrace();
		}
		String result2 = "";
		try {
			result2 = URLEncoder.encode(result.toString(), StandardCharsets.UTF_8.toString());
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return result2;
	}
}