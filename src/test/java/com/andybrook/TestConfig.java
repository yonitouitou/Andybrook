package com.andybrook;

import com.andybrook.service.glasses.GlassesService;
import com.andybrook.service.glasses.IGlassesService;
import com.andybrook.service.stock.GlassesStockService;
import com.andybrook.service.stock.IGlassesStockService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {

    @Bean
    private IGlassesService glassesService() {
        return new GlassesService();
    }

    @Bean
    private IGlassesStockService glassesStockService() {
        return new GlassesStockService();
    }
}
