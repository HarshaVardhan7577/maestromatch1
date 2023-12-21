package com.stackroute.searchandrecommendationservice.config;

import java.util.HashMap;
import java.util.Map;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.support.serializer.ErrorHandlingDeserializer;
import org.springframework.kafka.support.serializer.JsonDeserializer;

import com.stackroute.searchandrecommendationservice.model.Teacher;

@Configuration
@EnableKafka
public class Kafkaconfig {
	
 	@Value("${spring.kafka.bootstrap-servers}")
	private String bootStrapServers;

	@Value("${spring.kafka.consumer.group-id}")
	private String groupId;

	 

		@Bean
		ConsumerFactory<String, Teacher> consumerFactory() {
			Map<String, Object> config = new HashMap<>();
			config.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);
			config.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
			// config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG,

			// JsonDeserializer.class);

			config.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, ErrorHandlingDeserializer.class);

			config.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, "earliest");

			config.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);

			config.put(JsonDeserializer.TRUSTED_PACKAGES, "*");

	 

			return new DefaultKafkaConsumerFactory<>(config, new StringDeserializer(), new JsonDeserializer<>(Teacher.class));

	 

		}

	 

		@Bean
		ConcurrentKafkaListenerContainerFactory<String, Teacher> kafkaContainerListenerFactory() {

			ConcurrentKafkaListenerContainerFactory<String, Teacher> concurrentKafkaListenerContainerFactory = new ConcurrentKafkaListenerContainerFactory<>();

			concurrentKafkaListenerContainerFactory.setConsumerFactory(consumerFactory());

			return concurrentKafkaListenerContainerFactory;

	 

		}
}
