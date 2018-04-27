package br.com.b2w.desafio;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.b2w.desafio.models.Planet;
import br.com.b2w.desafio.repositories.PlanetRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetRepositoryTests {
	
	Planet terra, marte, plutao;
    
    @Autowired
    PlanetRepository repository;
    
    @Before
    public void setUp() {

        repository.deleteAll();

        terra = repository.save(new Planet("Terra", "tropical","misto"));
        marte = repository.save(new Planet("Marte", "árido", "rochoso"));
        plutao = repository.save(new Planet("Plutão", "seco", "rochoso"));
    }
    
    @Test
    public void createPlanet() {
    	
    	Planet venus = repository.save(new Planet("Vênus", "quente", "vulcanico"));
        Assert.assertNotNull(venus.getId());
        
    }
    
    
    @Test
    public void findsByName() {

        Planet planet = repository.findByName("Plutão");
        Assert.assertNotNull(planet);

    }
    
    @Test
    public void findsByTerrain() {
        List<Planet> planets = repository.findByTerrain("rochoso");
        Assert.assertFalse(planets.isEmpty());
        Assert.assertEquals(2, planets.size());
        List<String> planetNames = Arrays.asList("Marte", "Plutão");
        
        for (Planet planet : planets) {
        	Assert.assertTrue(planetNames.contains(planet.getName()));
		}

    }

}
