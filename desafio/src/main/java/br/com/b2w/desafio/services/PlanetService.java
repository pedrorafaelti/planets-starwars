package br.com.b2w.desafio.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import br.com.b2w.desafio.models.Planet;
import br.com.b2w.desafio.repositories.PlanetRepository;
import br.com.b2w.desafio.ws.SwapiWS;

@Service
public class PlanetService {

	@Autowired
	PlanetRepository repository;
	
	@Autowired
	SwapiWS swapiWS;
	
	 @Autowired
	 private MongoOperations mongoOperations;
	
	public String save (Planet planet){
		Planet entitySearch = repository.findByName(planet.getName());
		if(entitySearch == null){
			repository.save(planet);
			return "Planeta salvo com sucesso!";
		}
		return "Planeta já existe.";
	}
	
	public List<Planet> findAll(){
		List<Planet> planets = repository.findAll();
		if(!planets.isEmpty()){
			planets.stream().forEach(planet -> planet.setApparitions(swapiWS.filmsApparitions(planet.getName())));
		}
		return planets;
	}
	
	public Planet findById(String id){
		Planet planet = getNewsDetail(id);
		if(planet != null){
			planet.setApparitions(swapiWS.filmsApparitions(planet.getName()));
		}
		return planet;
	}
	
	public Planet findByName(String name){
		Planet planet = repository.findByName(name);
		if(planet != null){
			planet.setApparitions(swapiWS.filmsApparitions(planet.getName()));
		}
		return planet;
	}
	
	public String delete(String id){
		repository.deleteById(id);
		return "Planeta removido.";
	}
	
	//but this method return null     
    public Planet getNewsDetail(String id) {
        return mongoOperations.findOne(Query.query(Criteria.where("_id").is(id)), Planet.class);
    }
	
}
