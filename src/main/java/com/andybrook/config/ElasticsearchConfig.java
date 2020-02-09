package com.andybrook.config;

import com.andybrook.ApplicationProperties;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.data.elasticsearch.config.AbstractElasticsearchConfiguration;
import org.springframework.http.HttpHeaders;

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
}
