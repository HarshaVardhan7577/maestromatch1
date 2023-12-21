package com.stackroute.searchandrecommendationservice.util;

import co.elastic.clients.elasticsearch._types.query_dsl.MatchAllQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.MultiMatchQuery;
import co.elastic.clients.elasticsearch._types.query_dsl.Query;
import lombok.val;

import java.util.function.Supplier;

public class TeacherUtil {
	
	 public static Supplier<Query> supplier(){
	        Supplier<Query> supplier = ()->Query.of(q->q.matchAll(matchAllQuery()));
	        return supplier;
	    }

	    public static MatchAllQuery matchAllQuery(){
	        val  matchAllQuery = new MatchAllQuery.Builder();
	        return matchAllQuery.build();
	    }



	    public static Supplier<Query> supplierWithFirstName(String firstName){
	        Supplier<Query> supplier = ()->Query.of(q->q.match(matchQueryWithFirstName(firstName)));
	        return supplier;
	    }

	    public static MatchQuery matchQueryWithFirstName(String firstName){
	        val  matchQuery = new MatchQuery.Builder();
	        return matchQuery.field("firstName").query(firstName).build();
	    }
	    public static Supplier<Query> supplierWithLastName(String lastName){
	        Supplier<Query> supplier = ()->Query.of(q->q.match(matchQueryWithLastName(lastName)));
	        return supplier;
	    }

	    public static MatchQuery matchQueryWithLastName(String lastName){
	        val  matchQuery = new MatchQuery.Builder();
	        return matchQuery.field("lastName").query(lastName).build();
	    }
	    
	    public static Supplier<Query> supplierWithinstrument(String instrument){
	        Supplier<Query> supplier = ()->Query.of(q->q.match(matchQueryWithinstrument(instrument)));
	        return supplier;
	    }

	    public static MatchQuery matchQueryWithinstrument(String instrument){
	        val  matchQuery = new MatchQuery.Builder();
	        return matchQuery.field("instrument").query(instrument).build();
	    }
	    
	    public static Supplier<Query> supplierWithlocation(String location){
	        Supplier<Query> supplier = ()->Query.of(q->q.match(matchQueryWithlocation(location)));
	        return supplier;
	    }

	    public static MatchQuery matchQueryWithlocation(String location){
	        val  matchQuery = new MatchQuery.Builder();
	        return matchQuery.field("location").query(location).build();
	    }
	    
	    public static Supplier<Query> supplierWithAllFields(String query){
	        Supplier<Query> supplier = ()->Query.of(q->q.multiMatch(multiMatchQuery(query)));
	        return supplier;
	    }
	    

	    public static MultiMatchQuery multiMatchQuery(String query) {
	        val  matchQuery = new MultiMatchQuery.Builder();
	        return matchQuery.fields("firstName", "lastName","location","instrument","experience", "description").query(query).build();
	        
	    }
	    public static Supplier<Query> supplierWithfirstNameAndlastName(String query){
	        Supplier<Query> supplier = ()->Query.of(q->q.multiMatch(multiMatchQuerywithfirstNameAndlastName(query)));
	        return supplier;
	    }

	    public static MultiMatchQuery multiMatchQuerywithfirstNameAndlastName(String query) {
	        val  matchQuery = new MultiMatchQuery.Builder();
	        return matchQuery.fields("firstName", "lastName").query(query).build();
	        
	    }
	   
	    public static Supplier<Query> supplierWithfirstnameAndinstrument(String query){
	        Supplier<Query> supplier = ()->Query.of(q->q.multiMatch(multiMatchQuerywithfirstnameAndinstrument(query)));
	        return supplier;
	    }

	    public static MultiMatchQuery multiMatchQuerywithfirstnameAndinstrument(String query) {
	        val  matchQuery = new MultiMatchQuery.Builder();
	        return matchQuery.fields("firstName", "instrument","lastName").query(query).build();
	        
	    }
	    public static Supplier<Query> supplierWithfirsnameAndlocation(String query){
	        Supplier<Query> supplier = ()->Query.of(q->q.multiMatch(multiMatchQuerywithfirsnameAndlocation(query)));
	        return supplier;
	    }

	    public static MultiMatchQuery multiMatchQuerywithfirsnameAndlocation(String query) {
	        val  matchQuery = new MultiMatchQuery.Builder();
	        return matchQuery.fields("firstName", "location","lastname").query(query).build();
	        
	    }
	    
	    public static Supplier<Query> supplierWithlasstnameAndinstrument(String query){
	        Supplier<Query> supplier = ()->Query.of(q->q.multiMatch(multiMatchQuerywithlastnameAndinstrument(query)));
	        return supplier;
	    }

	    public static MultiMatchQuery multiMatchQuerywithlastnameAndinstrument(String query) {
	        val  matchQuery = new MultiMatchQuery.Builder();
	        return matchQuery.fields("lastName", "instrument").query(query).build();
	        
	    }
	    
	    public static Supplier<Query> supplierWithlastnameAndlocation(String query){
	        Supplier<Query> supplier = ()->Query.of(q->q.multiMatch(multiMatchQuerywithlastnameAndlocation(query)));
	        return supplier;
	    }

	    public static MultiMatchQuery multiMatchQuerywithlastnameAndlocation(String query) {
	        val  matchQuery = new MultiMatchQuery.Builder();
	        return matchQuery.fields("lastName", "location").query(query).build();
	        
	    }
	    public static Supplier<Query> supplierWithinstrumentandlocation(String query){
	        Supplier<Query> supplier = ()->Query.of(q->q.multiMatch(multiMatchQuerywithinstrumentandlocation(query)));
	        return supplier;
	    }

	    public static MultiMatchQuery multiMatchQuerywithinstrumentandlocation(String query) {
	        val  matchQuery = new MultiMatchQuery.Builder();
	        return matchQuery.fields("instrument", "location").query(query).build();
	        
	    }

}
