package com.cts.kafka.rest.producer.config;

import java.util.Map;
import java.util.TreeMap;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

@Configuration
public class ProducerConfiguaration {

	@Bean
	public ProducerFactory<String,String> producerFactory(){
		Map<String,Object> configs = new TreeMap<>();
		
		configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
		configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"localhost:9092");
		
		return new DefaultKafkaProducerFactory<>(configs);
	}
	
	@Bean
	public KafkaTemplate<String,String> kafkaTemplate(){
		return new KafkaTemplate<>(producerFactory());
	}
}
