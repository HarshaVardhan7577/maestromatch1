package com.stackroute.searchandrecommendationservice.model;

import org.springframework.data.elasticsearch.annotations.Document;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Document(indexName = "teachers")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Teacher {

	public Teacher() {
		super();
	}

	public Teacher(int id, int userId, String firstName, String lastName, String location, String instrument, String experience, String description) {
		super();
		this.id = id;
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.location = location;
		this.instrument = instrument;
		this.experience = experience;
		this.description = description;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}



	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getInstrument() {
		return instrument;
	}

	public void setInstrument(String instrument) {
		this.instrument = instrument;
	}

	public String getExperience() {
		return experience;
	}

	public void setExperience(String experience) {
		this.experience = experience;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	private int id;
	private int userId;
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	private String firstName;
	private String lastName;
	private String location;
	private String instrument;
	private String experience;
	private String description;

}
