package br.com.b2w.client;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import br.com.b2w.model.PlanetParent;

public class RestApiClient {
	
	@SuppressWarnings("static-access")
	public List<PlanetParent> getPlanetsAPI(){
		
	    final String uri = "https://swapi.co/api/planets";
	     
	    RestTemplate restTemplate = new RestTemplate();
	     
	    HttpHeaders headers = new HttpHeaders();
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	    headers.set("User-Agent", "SWAPI-Java-Client/1.0");
	    HttpEntity<String> entity = new HttpEntity<String>("parameters", headers);
	     
	    ResponseEntity<PlanetParent> result = restTemplate.exchange(uri, HttpMethod.GET, entity, PlanetParent.class);
	     
	    ObjectMapper objectMapper = new ObjectMapper();
	    objectMapper.configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);

	    PlanetParent[] planets = objectMapper.convertValue(result.getBody(), PlanetParent[].class);
	    
	    return Arrays.asList(planets);
	}
}
