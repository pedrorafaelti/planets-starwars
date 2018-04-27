package br.com.b2w.desafio.ws;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.b2w.desafio.dto.ResultSwapiDto;


@Service
public class SwapiWS {
	
	@Value("${swapi.planets.url}")
	private String planetUrl; 
	
	public int filmsApparitions(String planet){
		try {
            RestTemplate restTemplate = new RestTemplate();
            HttpHeaders headers = new HttpHeaders();
            headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
            headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
            HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
            String url = planetUrl+planet;
            ResponseEntity<ResultSwapiDto> response = restTemplate.exchange(url,
                    HttpMethod.GET, entity, new ParameterizedTypeReference<ResultSwapiDto>() {});
            ResultSwapiDto result = response.getBody();
            if(!result.getResults().isEmpty()){
            	return result.getResults().get(0).getFilms().size();
            }
            
        } catch (Exception ex) {
           ex.printStackTrace();

        }
		return 0;
	}
}
