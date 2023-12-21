package com.stackroute.searchandrecommendationservice.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.elc.ElasticsearchConfiguration;

import co.elastic.clients.elasticsearch.ElasticsearchClient;

@Configuration
public class ElasticsearchConfig {

	@Configuration
	public class MyClientConfig extends ElasticsearchConfiguration {

		@Override
		public ClientConfiguration clientConfiguration() {
			return ClientConfiguration.builder().connectedTo("localhost:9200").build();
		}
	}
}
