package com.andybrook.config.elasticsearch;

import com.andybrook.ApplicationProperties;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.data.elasticsearch.core.ElasticsearchEntityMapper;
import org.springframework.data.elasticsearch.core.EntityMapper;
import org.springframework.http.HttpHeaders;

import java.io.IOException;
import java.util.Map;

@Configuration
public class ElasticsearchConfig extends AbstractElasticsearchConfiguration {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Override
    public RestHighLevelClient elasticsearchClient() {
        HttpHeaders defaultHeaders = new HttpHeaders();
        defaultHeaders.setBasicAuth("andybrook", "andybrook");

        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(applicationProperties.getEsHost() + ":" + applicationProperties.getEsPort())
                .build();
        return RestClients.create(clientConfiguration).rest();
    }

    @Bean
    @Override
    public EntityMapper entityMapper() {
        GenericConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(EntityConverters.LOCAL_DATE_TIME_TO_LONG);
        conversionService.addConverter(EntityConverters.LONG_TO_LOCAL_DATE_TIME);
        conversionService.addConverter(EntityConverters.MAP_TO_ORDER_ITEM);
        ElasticsearchEntityMapper entityMapper = new ElasticsearchEntityMapper(
                elasticsearchMappingContext(), conversionService);
        return entityMapper;
    }

    private static class JacksonEntityMapper implements EntityMapper {

        private final ObjectMapper objectMapper;

        public JacksonEntityMapper() {
            objectMapper = new ObjectMapper()
                    .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
                    .configure(DeserializationFeature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true)
                    .configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false)
                    .registerModule(new JavaTimeModule())
                    .registerModule(new Jdk8Module());
            // Only autodetect fields and ignore getters and setters for nonexistent fields when serializing/deserializing
            objectMapper.setVisibility(objectMapper.getSerializationConfig().getDefaultVisibilityChecker()
                    .withFieldVisibility(JsonAutoDetect.Visibility.ANY)
                    .withGetterVisibility(JsonAutoDetect.Visibility.NONE)
                    .withSetterVisibility(JsonAutoDetect.Visibility.NONE)
                    .withCreatorVisibility(JsonAutoDetect.Visibility.NONE));
            objectMapper.findAndRegisterModules();
        }

        @Override
        public String mapToString(Object o) throws IOException {
            return objectMapper.writeValueAsString(o);
        }

        @Override
        public <T> T mapToObject(String s, Class<T> clazz) throws IOException {
            return objectMapper.readValue(s, clazz);
        }

        @Override
        public Map<String, Object> mapObject(Object o) {
            return null;
        }

        @Override
        public <T> T readObject(Map<String, Object> map, Class<T> aClass) {
            return null;
        }
    }
}
