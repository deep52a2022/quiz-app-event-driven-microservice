package com.quiz.app.messaging.config;

import com.quiz.app.event.QuizCreatedEvent;
import com.quiz.app.event.QuizSubmittedEvent;
import com.quiz.app.kafka.CommonKafkaData;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class EventPublisherConfig {

    @Bean
    public NewTopic createTopic(){
        return new NewTopic(CommonKafkaData.quizCreatedEventTopicName, CommonKafkaData.numPartitions, CommonKafkaData.replicationFactor);
    }

    @Bean
    public NewTopic createTopic2(){
        return new NewTopic(CommonKafkaData.quizSubmittedEventTopicName, CommonKafkaData.numPartitions, CommonKafkaData.replicationFactor);
    }

    @Bean
    public Map<String, Object> producerConfig(){
        Map<String, Object> props = new HashMap<>();
        props.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        props.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        props.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);
        return props;
    }

    @Bean
    public ProducerFactory<String, QuizSubmittedEvent> producerFactory(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }

    @Bean
    public ProducerFactory<String, QuizCreatedEvent> producerFactory2(){
        return new DefaultKafkaProducerFactory<>(producerConfig());
    }


    @Bean
    public KafkaTemplate<String, QuizSubmittedEvent> kafkaTemplate1() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public KafkaTemplate<String, QuizCreatedEvent> kafkaTemplate2() {
        return new KafkaTemplate<>(producerFactory2());
    }
}
