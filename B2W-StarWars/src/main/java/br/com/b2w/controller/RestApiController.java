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
import br.com.b2w.model.PlanetParent;
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
		
		return ResponseEntity.ok("Exclusão Efetuada com Sucesso!");
	}
	
	@GetMapping(value = "/listPlanetsAPI", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> getPlanetsAPI(){
		
		RestApiClient apiClient =  new RestApiClient();
		
		List<PlanetParent> planets =  apiClient.getPlanetsAPI();
		
		return planets.isEmpty()? ResponseEntity.notFound().build() : ResponseEntity.ok(planets);
	}
	
	@GetMapping(value = "/insertPlanetsAPI", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> insertPlanetsAPI(){
		
		RestApiClient apiClient =  new RestApiClient();
		List<PlanetParent> planets =  apiClient.getPlanetsAPI();
		
		planets.forEach(p -> {
			p.getResults().forEach(r -> {
				
				String id = r.getUrl().replace("https://swapi.co/api/planets/", "").replaceAll("/", "");
				
				Planet planet = new Planet();
				planet.setId(new Long(id));
				planet.setNome(r.getName());
				planet.setTerreno(r.getTerrain());
				planet.setClima(r.getClimate());
				planet.setAparicoes(r.getFilms().size());
				
				planetService.add(planet);				
			});
		});
		
		
		return planets.isEmpty() ? 
				ResponseEntity.notFound().build() : 
				ResponseEntity.ok("Planetas Inseridos com Sucesso!");
	}

}
