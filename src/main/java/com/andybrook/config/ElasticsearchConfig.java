package com.andybrook.config;

import com.andybrook.ApplicationProperties;
import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchConfig {

    @Autowired
    private ApplicationProperties applicationProperties;

    @Bean
    public RestHighLevelClient restHighLevelClient() {
        return new RestHighLevelClient(
                RestClient.builder(new HttpHost(
                        applicationProperties.getEsHost(),
                        applicationProperties.getEsPort(),
                        "http")));
    }
}
