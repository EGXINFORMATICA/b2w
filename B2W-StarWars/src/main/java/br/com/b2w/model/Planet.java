package br.com.b2w.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/** 
 * 	This is a data structure, so
 *  fields can be public. (Clean-Code)
 */
@Entity
@Table(name="planet" ,schema = "b2w")
public class Planet {
	
    @Id
	public Long id;
    public String nome;
    public String clima;
    public String terreno;
    public Integer aparicoes;
	      

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getClima() {
		return clima;
	}
	public void setClima(String clima) {
		this.clima = clima;
	}
	public Integer getAparicoes() {
		return aparicoes;
	}
	public void setAparicoes(Integer aparicoes) {
		this.aparicoes = aparicoes;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTerreno() {
		return terreno;
	}
	public void setTerreno(String terreno) {
		this.terreno = terreno;
	}
	public Planet(Long id, String nome, String clima, String terreno, Integer aparicoes) {
		super();
		this.id = id;
		this.nome = nome;
		this.clima = clima;
		this.terreno = terreno;
		this.aparicoes = aparicoes;
	}
	public Planet() {
		//Default constructor needed for JPA.
	}
	
}
