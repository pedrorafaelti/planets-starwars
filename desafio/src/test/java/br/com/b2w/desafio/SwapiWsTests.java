package br.com.b2w.desafio;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.b2w.desafio.ws.SwapiWS;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SwapiWsTests {
	@Autowired
	SwapiWS swapiWS;
	
	@Test
	public void filmsApparitionsTest(){
		int count = swapiWS.filmsApparitions("Alderaan");
		Assert.assertFalse(count == 0);
	}
	
	@Test
	public void filmsWithoutApparitionsTest(){
		int count = swapiWS.filmsApparitions("Terra");
		Assert.assertTrue(count == 0);
	}
	
}
