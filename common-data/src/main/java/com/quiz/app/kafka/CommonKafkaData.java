package com.quiz.app.kafka;

public class CommonKafkaData {

    private CommonKafkaData(){}


    public static final String quizCreatedEventTopicName = "quiz-created-event";
    public static final String quizSubmittedEventTopicName = "quiz-submitted-event";

    public static final String consumerGroupId = "score-processor-group";

    public static final int numPartitions = 3;

    public static final short replicationFactor = 1;

}
