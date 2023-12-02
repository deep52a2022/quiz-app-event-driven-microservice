package com.quiz.app.config;

import com.quiz.app.event.QuizSubmittedEvent;
import com.quiz.app.event.serializer.QuizSubmittedEventSerializer;
import com.quiz.app.kafka.CommonKafkaData;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic(CommonKafkaData.quizSubmittedEventTopicName, CommonKafkaData.numPartitions, CommonKafkaData.replicationFactor);
    }

    @Bean
    public Map<String, Object> producerConfig(){

        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,
                QuizSubmittedEventSerializer.class);
        return props;
    }

    @Bean
    public ProducerFactory<String, QuizSubmittedEvent> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }


    @Bean
    public KafkaTemplate<String, QuizSubmittedEvent> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }


}
