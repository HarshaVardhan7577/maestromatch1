package com.stackroute.searchandrecommendationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.searchandrecommendationservice.model.Teacher;
import com.stackroute.searchandrecommendationservice.repository.SearchandrecommendationRepository;
import com.stackroute.searchandrecommendationservice.util.TeacherUtil;

import co.elastic.clients.elasticsearch.ElasticsearchClient;
import co.elastic.clients.elasticsearch._types.query_dsl.MultiMatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.QueryBuilders;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;

import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.SearchHitsIterator;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import co.elastic.clients.elasticsearch.core.SearchResponse;
import java.util.function.Supplier;
import java.util.Optional;

@Service
public class SearchandrecommednationService implements IsearchandrecommendationService {

	@Autowired
	SearchandrecommendationRepository sr;

	@Autowired
	private ElasticsearchClient elasticsearchClient;

	@Override
	public Iterable<Teacher> getAllRecommendations() {
		// TODO Auto-generated method stub
		return sr.findAll();
	}

	@Override
	public Teacher getRecommendation(int id) {
		// TODO Auto-generated method stub
		return sr.findByuserId(id).get();
	}

	@Override
	public Teacher newRecommendation(Teacher t) {
		// TODO Auto-generated method stub
		return sr.save(t);
	}

	@Override
	public Teacher updateRecommendation(Teacher t, int id) {
		// TODO Auto-generated method stub
		Teacher t1 = sr.findById(id).get();
		t1.setId(t.getId());
		t1.setUserId(t.getUserId());
		t1.setFirstName(t.getFirstName());
		t1.setLastName(t.getLastName());
		t1.setDescription(t.getDescription());
		t1.setInstrument(t.getInstrument());
		t1.setExperience(t.getExperience());
		t1.setLocation(t.getLocation());
		return sr.save(t1);
	}

	@Override
	public void deleteRecommendation(int id) {
		// TODO Auto-generated method stub
		sr.deleteById(id);
	}

	public SearchResponse<Teacher> matchTeachers() throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplier();
		SearchResponse<Teacher> searchResponse = elasticsearchClient
				.search(s -> s.index("teachers").query(supplier.get()), Teacher.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

	public SearchResponse<Teacher> matchTeachersWithFirstName(String firstName) throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplierWithFirstName(firstName);
		SearchResponse<Teacher> searchResponse = elasticsearchClient
				.search(s -> s.index("teachers").query(supplier.get()), Teacher.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

	public SearchResponse<Teacher> matchTeachersWithLastName(String lastName) throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplierWithLastName(lastName);
		SearchResponse<Teacher> searchResponse = elasticsearchClient
				.search(s -> s.index("teachers").query(supplier.get()), Teacher.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

	public SearchResponse<Teacher> matchTeachersWithinstrument(String instrument) throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplierWithinstrument(instrument);
		SearchResponse<Teacher> searchResponse = elasticsearchClient
				.search(s -> s.index("teachers").query(supplier.get()), Teacher.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

	public SearchResponse<Teacher> matchTeachersWithlocation(String location) throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplierWithlocation(location);
		SearchResponse<Teacher> searchResponse = elasticsearchClient
				.search(s -> s.index("teachers").query(supplier.get()), Teacher.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

	public SearchResponse<Map> matchAllServices() throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplier();
		SearchResponse<Map> searchResponse = elasticsearchClient.search(s -> s.query(supplier.get()), Map.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

	public SearchResponse<Teacher> matchAllTeachersServices() throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplier();
		SearchResponse<Teacher> searchResponse = elasticsearchClient
				.search(s -> s.index("teachers").query(supplier.get()), Teacher.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

	public SearchResponse<Teacher> matchTeachersWithAllFields(String query) throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplierWithAllFields(query);
		SearchResponse<Teacher> searchResponse = elasticsearchClient
				.search(s -> s.index("teachers").query(supplier.get()), Teacher.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

	public SearchResponse<Teacher> matchTeachersWithfirstNameAndlastName(String query) throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplierWithfirstNameAndlastName(query);
		SearchResponse<Teacher> searchResponse = elasticsearchClient
				.search(s -> s.index("teachers").query(supplier.get()), Teacher.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

	public SearchResponse<Teacher> matchTeachersWithfirstnameAndinstrument(String query) throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplierWithfirstnameAndinstrument(query);
		SearchResponse<Teacher> searchResponse = elasticsearchClient
				.search(s -> s.index("teachers").query(supplier.get()), Teacher.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

	public SearchResponse<Teacher> matchTeachersWithfirsnameAndlocation(String query) throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplierWithfirsnameAndlocation(query);
		SearchResponse<Teacher> searchResponse = elasticsearchClient
				.search(s -> s.index("teachers").query(supplier.get()), Teacher.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

	public SearchResponse<Teacher> matchTeachersWithlasstnameAndinstrument(String query) throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplierWithlasstnameAndinstrument(query);
		SearchResponse<Teacher> searchResponse = elasticsearchClient
				.search(s -> s.index("teachers").query(supplier.get()), Teacher.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

	public SearchResponse<Teacher> matchTeachersWithlastnameAndlocation(String query) throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplierWithlastnameAndlocation(query);
		SearchResponse<Teacher> searchResponse = elasticsearchClient
				.search(s -> s.index("teachers").query(supplier.get()), Teacher.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

	public SearchResponse<Teacher> matchTeachersWithinstrumentandlocation(String query) throws IOException {
		Supplier<Query> supplier = TeacherUtil.supplierWithinstrumentandlocation(query);
		SearchResponse<Teacher> searchResponse = elasticsearchClient
				.search(s -> s.index("teachers").query(supplier.get()), Teacher.class);
		System.out.println("elasticsearch query is " + supplier.get().toString());
		return searchResponse;
	}

}
