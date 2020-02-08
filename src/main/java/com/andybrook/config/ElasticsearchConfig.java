package com.andybrook.config;

import com.andybrook.ApplicationProperties;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

@Configuration
public class ElasticsearchConfig {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    RestHighLevelClient client() {

        ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(applicationProperties.getEsHost() + ":" + applicationProperties.getEsPort())
                .build();

        return RestClients.create(clientConfiguration).rest();
    }

    /*@Bean
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost(
                        applicationProperties.getEsHost(),
                        applicationProperties.getEsPort(),
                        "http")));
    }*/
}
