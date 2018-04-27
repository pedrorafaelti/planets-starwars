package br.com.b2w.desafio;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.b2w.desafio.models.Planet;
import br.com.b2w.desafio.repositories.PlanetRepository;
import br.com.b2w.desafio.services.PlanetService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PlanetServiceTests {
	
	@Autowired
	PlanetService service;
	
	@Autowired
	PlanetRepository repository;
	
	Planet terra, marte, plutao;
	
	@Before
    public void setUp() {

        repository.deleteAll();

        terra = repository.save(new Planet("Terra", "tropical","misto"));
        marte = repository.save(new Planet("Marte", "árido", "rochoso"));
        plutao = repository.save(new Planet("Plutão", "seco", "rochoso"));
    }
	
	@Test
	public void savePlanetExisted(){
		Planet planet = new Planet("Terra", "temperado","Marítimo");
		String msg = service.save(planet);
		Assert.assertEquals("Planeta já existe.", msg);
	}
	
	@Test
	public void savePlanetNotExisted(){
		Planet planet = new Planet("Jupter","quente","vulcanico");
		String msg = service.save(planet);
		Assert.assertEquals("Planeta salvo com sucesso!", msg);
	}
	    
	@Test
	public void findByIdSuccess(){
		Planet terra = service.findByName("Terra");
		Planet planet = service.findById(terra.getId());
		Assert.assertTrue(planet != null);
		Assert.assertEquals("Terra", terra.getName());
		
	}
	
	
	@Test
	public void findByIdError(){
		Planet planet = service.findById("Terra");
		Assert.assertTrue(planet == null);
	}

}
