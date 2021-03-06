package com.example.restservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UnicornController {
	
	@Autowired
	UnicornRepository unicornRepo;


	@PostMapping("/unicorns")
	public UnicornIdent createUnicorn(@RequestBody(required=true) Unicorn unicorn) {
		Unicorn savedEntity = unicornRepo.save(unicorn);
		if(savedEntity == null || savedEntity.getId() == null) {
			throw new IllegalStateException("Spring JPA klunkiness: the entity was not properly saved.");
		}
		Long autogendId = savedEntity.getId();
		return new UnicornIdent(autogendId);
	}
	
	
	@GetMapping("/unicorns")
	public List<Unicorn> getAllUnicorns() {
		List<Unicorn> results = unicornRepo.findAll();
		if(results == null) {
			results = new ArrayList<>();
		}
	   return results;
	}
	
	@GetMapping("/unicorns/{unicornId}")
	public Unicorn getUnicornById(@PathVariable(required=true) Long unicornId) {
		Optional<Unicorn> potentiality = unicornRepo.findById(unicornId);
		return (potentiality.isPresent())?  potentiality.get(): null;
	}
	

}
