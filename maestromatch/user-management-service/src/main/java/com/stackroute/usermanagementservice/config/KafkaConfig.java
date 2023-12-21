package com.stackroute.usermanagementservice.config;


import java.util.HashMap;
import java.util.Map;

import com.stackroute.usermanagementservice.model.UserProfile;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import com.stackroute.usermanagementservice.model.TeacherProfile;

@Configuration
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")

    private String bootStrapServers;

    @Bean

    ProducerFactory<String, TeacherProfile> producerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);

        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                org.apache.kafka.common.serialization.StringSerializer.class);

        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                org.springframework.kafka.support.serializer.JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);

    }

    @Bean

    ProducerFactory<String, UserProfile> userProducerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);

        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                org.apache.kafka.common.serialization.StringSerializer.class);

        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                org.springframework.kafka.support.serializer.JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);

    }


    @Bean
    ProducerFactory<String, UserProfile> senderProducerFactory() {

        Map<String, Object> config = new HashMap<>();

        config.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootStrapServers);

        config.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG,
                org.apache.kafka.common.serialization.StringSerializer.class);

        config.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                org.springframework.kafka.support.serializer.JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(config);

    }

    @Bean

    KafkaTemplate<String, TeacherProfile> kafkaTemplate() {

        return new KafkaTemplate<>(producerFactory());

    }

    @Bean
    KafkaTemplate<String, UserProfile> userKafkaTemplate() {

        return new KafkaTemplate<>(userProducerFactory());

    }
    @Bean
   KafkaTemplate<String,UserProfile> senderKafkaTemplate(){
        return new KafkaTemplate<>(senderProducerFactory());
   }




    @Bean
    public NewTopic topic() {

        return TopicBuilder
                .name("teacher")

                .build();

    }

    @Bean
    public NewTopic courseTopic() {
        return TopicBuilder.name("course").build();
    }

    @Bean
    public NewTopic bookingTopic(){return TopicBuilder.name("booking").build();}

    //For email service
    @Bean
    public NewTopic userTopic(){return TopicBuilder.name("userRegistration").build();}

    @Bean
    public NewTopic teacherTopic(){return TopicBuilder.name("teacherRegistration").build();}





}
