package br.com.b2w.desafio.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.b2w.desafio.models.Planet;

public interface PlanetRepository extends MongoRepository<Planet, String> {
	
	 public Planet findByName(String name);
	 public List<Planet> findByTerrain(String terrain);

}
