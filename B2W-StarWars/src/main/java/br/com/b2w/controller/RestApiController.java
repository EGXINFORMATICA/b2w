package br.com.b2w.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.b2w.client.RestApiClient;
import br.com.b2w.model.Planet;
import br.com.b2w.service.PlanetService;

@RestController
@RequestMapping("/api")
public class RestApiController {
	
	@Autowired
	PlanetService planetService;
	
	@GetMapping("/listPlanetsBD")
	public List<Planet> getPlanetsBD(){
		
		List<Planet> planets =  planetService.findAll();
		
		return planets;
	}
	
	@GetMapping("/getByNameBD/{name}")
	public List<Planet> getByNameBD(@PathVariable("name") String name){
		
		List<Planet> planets =  planetService.findByNomeIs(name);
		
		return planets;
	}
	
	@GetMapping("/getByIdBD/{id}")
	public List<Planet> getByIdBD(@PathVariable("id") Long id){
		
		List<Planet> planets =  planetService.findById(id);
		
		return planets;
	}
	
	@GetMapping("/deleteById/{id}")
	public ResponseEntity<?> deleteById(@PathVariable("id") Long id){
		
		planetService.deleteById(id);
		
		return ResponseEntity.ok("delete");
	}
	
	@GetMapping(value = "/listPlanetsAPI", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPlanetsAPI(){
		
		RestApiClient apiClient =  new RestApiClient();
		
		ResponseEntity<?> JSON =  apiClient.getPlanetsAPI();
		
		return JSON;
	}

}
