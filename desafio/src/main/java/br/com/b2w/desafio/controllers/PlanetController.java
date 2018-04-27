package br.com.b2w.desafio.controllers;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.desafio.models.Planet;
import br.com.b2w.desafio.services.PlanetService;

@RestController
@RequestMapping("/planet")
public class PlanetController {
	
	@Autowired
	private PlanetService service;
	
	@PostMapping("/create")
	public ResponseEntity<String> create(@RequestBody Planet planet) {
		return new ResponseEntity<>(service.save(planet), HttpStatus.OK);
	}
	
	@GetMapping("/findAll")
	public ResponseEntity<Collection<Planet>> findAll() {
		return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/findByName")
	public ResponseEntity<Planet> findByName(@RequestParam String name) {
		return new ResponseEntity<>(service.findByName(name), HttpStatus.OK);
	}
	
	@GetMapping("/find")
	public ResponseEntity<Planet> findById(@RequestParam String id) {
		return new ResponseEntity<>(service.findById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> delete(@RequestParam String id) {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}
	
	

}
