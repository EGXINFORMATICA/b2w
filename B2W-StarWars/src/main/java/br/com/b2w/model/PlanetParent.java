package br.com.b2w.model;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

@JsonDeserialize(as = PlanetParent.class)
public class PlanetParent implements Serializable{
	
	private static final long serialVersionUID = -5372702531991416258L;
	
	public String count;
    public String next;
    public String previous;
    public List<PlanetAPI> results;
	
    public String getCount() {
		return count;
	}
	public void setCount(String count) {
		this.count = count;
	}
	public String getNext() {
		return next;
	}
	public void setNext(String next) {
		this.next = next;
	}
	public String getPrevious() {
		return previous;
	}
	public void setPrevious(String previous) {
		this.previous = previous;
	}
	public List<PlanetAPI> getResults() {
		return results;
	}
	public void setResults(List<PlanetAPI> results) {
		this.results = results;
	}
	
	public PlanetParent() {}
	
	public PlanetParent(String count, String next, String previous, List<PlanetAPI> results) {
		super();
		this.count = count;
		this.next = next;
		this.previous = previous;
		this.results = results;
	}    
}
