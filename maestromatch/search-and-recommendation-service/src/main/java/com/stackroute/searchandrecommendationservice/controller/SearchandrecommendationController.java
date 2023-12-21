package com.stackroute.searchandrecommendationservice.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.stackroute.searchandrecommendationservice.model.Teacher;
import com.stackroute.searchandrecommendationservice.service.SearchandrecommednationService;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import co.elastic.clients.elasticsearch.core.search.Hit;

import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api")
public class SearchandrecommendationController {

	@Autowired
	SearchandrecommednationService ss;

	@GetMapping("/get-recommendations")
	public Iterable<Teacher> get() {
		return ss.getAllRecommendations();
	}

	@GetMapping("/get-recommendations/{id}")
	public Teacher getTeacher(@PathVariable int id) {
		return ss.getRecommendation(id);
	}

//	@KafkaListener(topics = { "teacher" })
//	public void post(@RequestBody Teacher t) {
//		ObjectMapper objectMapper = new ObjectMapper();
//
//		objectMapper.registerModule(new JavaTimeModule());
//
// 
//
//		Teacher product1 = objectMapper.readValue(t, Teacher.class);
//		return ss.newRecommendation(t);
//	}
	
	@KafkaListener(topics = { "teacher" })
	public void createItem(@RequestBody String item) throws JsonMappingException, JsonProcessingException {
			ObjectMapper objectMapper = new ObjectMapper();

			objectMapper.registerModule(new JavaTimeModule());

	 

			Teacher product1 = objectMapper.readValue(item, Teacher.class);

			this.save(product1);

		}
	@PostMapping("/addRecommendation")
	public void save(@RequestBody Teacher t){
		ss.newRecommendation(t);
	}


	@PutMapping("/update-recommendation/{id}")
	public Teacher update(@RequestBody Teacher t, @PathVariable int id) {
		return ss.updateRecommendation(t, id);
	}

	@DeleteMapping("/delete-recommendation/{id}")
	public void delete(@PathVariable int id) {
		ss.deleteRecommendation(id);
	}

	@GetMapping("/matchAllTeachers")
	public List<Teacher> matchAllTeachers() throws IOException {
		SearchResponse<Teacher> searchResponse = ss.matchTeachers();
		System.out.println(searchResponse.hits().hits().toString());

		List<Hit<Teacher>> listOfHits = searchResponse.hits().hits();
		List<Teacher> listOfTeachers = new ArrayList<>();
		for (Hit<Teacher> hit : listOfHits) {
			listOfTeachers.add(hit.source());
		}
		return listOfTeachers;
	}

	@GetMapping("/matchAllTeachersWithAllFields")
	public List<Teacher> matchAllTeachersWithWithAllFields(@RequestParam String firstName) throws IOException {
		SearchResponse<Teacher> searchResponse = ss.matchTeachersWithAllFields(firstName);
		System.out.println(searchResponse.hits().hits().toString());

		List<Hit<Teacher>> listOfHits = searchResponse.hits().hits();
		List<Teacher> listOfTeachers = new ArrayList<>();
		for (Hit<Teacher> hit : listOfHits) {
			listOfTeachers.add(hit.source());
		}
		return listOfTeachers;
	}

	@GetMapping("/matchAllTeachersWithFirstName")
	public List<Teacher> matchAllTeachersWithFirstName(@RequestParam String firstName) throws IOException {
		SearchResponse<Teacher> searchResponse = ss.matchTeachersWithFirstName(firstName);
		System.out.println(searchResponse.hits().hits().toString());

		List<Hit<Teacher>> listOfHits = searchResponse.hits().hits();
		List<Teacher> listOfTeachers = new ArrayList<>();
		for (Hit<Teacher> hit : listOfHits) {
			listOfTeachers.add(hit.source());
		}
		return listOfTeachers;
	}

	@GetMapping("/matchAllTeachersWithLastName")
	public List<Teacher> matchAllTeachersWithLastName(@RequestParam String lastName) throws IOException {
		SearchResponse<Teacher> searchResponse = ss.matchTeachersWithLastName(lastName);
		System.out.println(searchResponse.hits().hits().toString());

		List<Hit<Teacher>> listOfHits = searchResponse.hits().hits();
		List<Teacher> listOfTeachers = new ArrayList<>();
		for (Hit<Teacher> hit : listOfHits) {
			listOfTeachers.add(hit.source());
		}
		return listOfTeachers;
	}

	@GetMapping("/matchAllTeachersWithInstrument")
	public List<Teacher> matchAllTeachersWithInstrument(@RequestParam String instrument) throws IOException {
		SearchResponse<Teacher> searchResponse = ss.matchTeachersWithinstrument(instrument);
		System.out.println(searchResponse.hits().hits().toString());

		List<Hit<Teacher>> listOfHits = searchResponse.hits().hits();
		List<Teacher> listOfTeachers = new ArrayList<>();
		for (Hit<Teacher> hit : listOfHits) {
			listOfTeachers.add(hit.source());
		}
		return listOfTeachers;
	}

	@GetMapping("/matchAllTeachersWithLocation")
	public List<Teacher> matchAllTeachersWithLocation(@RequestParam String location) throws IOException {
		SearchResponse<Teacher> searchResponse = ss.matchTeachersWithlocation(location);
		System.out.println(searchResponse.hits().hits().toString());

		List<Hit<Teacher>> listOfHits = searchResponse.hits().hits();
		List<Teacher> listOfTeachers = new ArrayList<>();
		for (Hit<Teacher> hit : listOfHits) {
			listOfTeachers.add(hit.source());
		}
		return listOfTeachers;
	}

	@GetMapping("/matchAllTeachersWithFirstNameAndLastName")
	public List<Teacher> multiMatchQuerywithfirstNameAndlastName(@RequestParam String firstName) throws IOException {
		SearchResponse<Teacher> searchResponse = ss.matchTeachersWithFirstName(firstName);
		System.out.println(searchResponse.hits().hits().toString());

		List<Hit<Teacher>> listOfHits = searchResponse.hits().hits();
		List<Teacher> listOfTeachers = new ArrayList<>();
		for (Hit<Teacher> hit : listOfHits) {
			listOfTeachers.add(hit.source());
		}
		return listOfTeachers;
	}

	@GetMapping("/matchAllTeachersWithtNameAndInstrument")
	public List<Teacher> multiMatchQuerywithfirstnameAndinstrument(@RequestParam String firstName) throws IOException {
		SearchResponse<Teacher> searchResponse = ss.matchTeachersWithfirstnameAndinstrument(firstName);
		System.out.println(searchResponse.hits().hits().toString());

		List<Hit<Teacher>> listOfHits = searchResponse.hits().hits();
		List<Teacher> listOfTeachers = new ArrayList<>();
		for (Hit<Teacher> hit : listOfHits) {
			listOfTeachers.add(hit.source());
		}
		return listOfTeachers;
	}

	@GetMapping("/matchAllTeachersWithtNameAndLocation")
	public List<Teacher> multiMatchQuerywithfirstnameAndlocation(@RequestParam String firstName) throws IOException {
		SearchResponse<Teacher> searchResponse = ss.matchTeachersWithfirsnameAndlocation(firstName);
		System.out.println(searchResponse.hits().hits().toString());

		List<Hit<Teacher>> listOfHits = searchResponse.hits().hits();
		List<Teacher> listOfTeachers = new ArrayList<>();
		for (Hit<Teacher> hit : listOfHits) {
			listOfTeachers.add(hit.source());
		}
		return listOfTeachers;
	}

	@GetMapping("/matchAllTeachersWithtInstrumentAndLocation")
	public List<Teacher> multiMatchQuerywithInstrumentAndLocation(@RequestParam String instrument) throws IOException {
		SearchResponse<Teacher> searchResponse = ss.matchTeachersWithinstrumentandlocation(instrument);
		System.out.println(searchResponse.hits().hits().toString());

		List<Hit<Teacher>> listOfHits = searchResponse.hits().hits();
		List<Teacher> listOfTeachers = new ArrayList<>();
		for (Hit<Teacher> hit : listOfHits) {
			listOfTeachers.add(hit.source());
		}
		return listOfTeachers;
	}

}
