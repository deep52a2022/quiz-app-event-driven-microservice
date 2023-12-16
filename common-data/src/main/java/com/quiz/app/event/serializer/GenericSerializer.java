package com.quiz.app.event.serializer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

@Slf4j
public class GenericSerializer<T> implements Serializer<T> {
    private final ObjectMapper objectMapper ;
    private final TypeReference<T> typeReference;
    private final String typeName;
    public GenericSerializer(TypeReference<T> typeReference) {
        this.typeReference = typeReference;
        this.objectMapper = new ObjectMapper();
        typeName = typeReference.getType().getTypeName();
        objectMapper.findAndRegisterModules();
    }


    @Override
    public byte[] serialize(String s, T data) {
        try {
            if (data == null){
                System.out.println("Null received at serializing");
                return null;
            }
            log.info("Serializing " + typeName + "......");
            return objectMapper.writeValueAsBytes(data);
        } catch (JsonProcessingException e) {

            log.info(e.getMessage());
            throw new SerializationException("Error when serializing " + typeName + " to byte[]");
        }
    }

    @Override
    public void close() {
        Serializer.super.close();
    }
}
