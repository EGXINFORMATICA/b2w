package br.com.b2w.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.b2w.model.Planet;
import br.com.b2w.repository.PlanetRepository;

/** 
 * Service layer.
 * Specify transactional behavior and mainly
 * delegate calls to Repository.
 */
@Component
public class PlanetService {

	@Autowired
	private PlanetRepository productRepository;

	@Transactional
	public void add(Planet product) {
		productRepository.save(product);
	}
	
	@Transactional
	public void deleteById(Long id) {
		productRepository.delete(id);
	}
	
	@Transactional(readOnly=true)
	public List<Planet> findAll() {
		return productRepository.findAll();
	}

	@Transactional(readOnly=true)
	public List<Planet> findByNomeIs(String nome) {
		return productRepository.findByNomeIs(nome);
	}
	@Transactional(readOnly=true)
	public List<Planet> findById(Long id) {
		return productRepository.findById(id);
	}
}
