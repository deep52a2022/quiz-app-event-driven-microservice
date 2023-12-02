package com.quiz.app.event.deserializer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

@Slf4j
public class GenericDeserializer<T> implements Deserializer<T> {
    private final ObjectMapper objectMapper;
    private final TypeReference<T> typeReference;
    private final String typeName;

    public GenericDeserializer(TypeReference<T> typeReference) {
        this.typeReference = typeReference;
        this.objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        typeName = typeReference.getType().getTypeName();
    }


    @Override
    public T deserialize(String s, byte[] data) {
        try {
            if (data == null){
                System.out.println("Null received at deserializing");
                return null;
            }
            System.out.println("Deserializing...");
            return objectMapper.readValue(new String(data, "UTF-8"), typeReference);
        } catch (Exception e) {
            throw new SerializationException("Error when deserializing byte[] to " + typeName);
        }
    }

    @Override
    public void close() {
        Deserializer.super.close();
    }
}
