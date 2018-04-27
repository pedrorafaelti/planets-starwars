package br.com.b2w.desafio.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

public class Planet {
	
	@Id
    private String id;
	private String name;
	private String climate;
	private String terrain;
	
	@Transient
	private int apparitions;
	
	public Planet(){
		
	}

	public Planet(String name, String climate, String terrain) {
		super();
		this.name = name;
		this.climate = climate;
		this.terrain = terrain;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getClimate() {
		return climate;
	}

	public void setClimate(String climate) {
		this.climate = climate;
	}

	public String getTerrain() {
		return terrain;
	}

	public void setTerrain(String terrain) {
		this.terrain = terrain;
	}
	
	public int getApparitions() {
		return apparitions;
	}

	public void setApparitions(int apparitions) {
		this.apparitions = apparitions;
	}

}
