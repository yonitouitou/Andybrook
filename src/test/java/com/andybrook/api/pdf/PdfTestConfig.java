package com.andybrook.api.pdf;

import com.andybrook.ApplicationProperties;
import com.andybrook.dao.jpa.entity.factory.EntityFactory;
import com.andybrook.dao.order.IOrderDao;
import com.andybrook.dao.order.IOrderItemDao;
import com.andybrook.dao.order.IOrderItemRepository;
import com.andybrook.dao.order.OrderDao;
import com.andybrook.dao.order.OrderItemDao;
import com.andybrook.dao.setting.AdminSettingDao;
import com.andybrook.dao.setting.IAdminSettingDao;
import com.andybrook.dao.setting.IAdminSettingRepository;
import com.andybrook.language.LanguageResolver;
import com.andybrook.manager.order.IOrderManager;
import com.andybrook.manager.order.OrderManager;
import com.andybrook.model.setting.AdminSetting;
import com.andybrook.service.order.IOrderItemService;
import com.andybrook.service.order.IOrderService;
import com.andybrook.service.order.OrderItemService;
import com.andybrook.service.order.OrderService;
import com.andybrook.service.setting.AdminSettingService;
import com.andybrook.service.setting.IAdminSettingService;
import com.andybrook.service.stock.IStockService;
import com.andybrook.service.stock.StockService;

import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchRestTemplate;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.awt.*;
import java.time.ZoneId;
import java.util.Locale;
import java.util.Optional;

public class PdfTestConfig {

    private AdminSetting setting = new AdminSetting(1L, null, null, 10, Color.LIGHT_GRAY, Color.BLACK);

    @MockBean
    IAdminSettingRepository adminSettingRepository;

    @Bean
    MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename("classpath:language/messages");
        messageSource.setFallbackToSystemLocale(false);
        messageSource.setCacheSeconds(3);
        return messageSource;
    }

    @Bean
    LanguageResolver languageResolver() {
        return new LanguageResolver();
    }

    @Bean
    ApplicationProperties applicationProperties() {
        ApplicationProperties appProperties = Mockito.mock(ApplicationProperties.class);
        Mockito.when(appProperties.getLocale()).thenReturn(new Locale("fr", "FR"));
        Mockito.when(appProperties.getZoneId()).thenReturn(ZoneId.of("Europe/Paris"));
        return appProperties;
    }

    @Bean
    CloseOrderPdfBuilder closeReportPdfBuilder() {
        return new CloseOrderPdfBuilder();
    }

    @Bean
    IAdminSettingService adminSettingService() {
        AdminSettingService adminSettingService = Mockito.mock(AdminSettingService.class);
        Mockito.when(adminSettingService.getAdminSetting()).thenReturn(setting);
        return adminSettingService;
    }

    @Bean
    IAdminSettingDao adminSettingDao() {
        AdminSettingDao mock = Mockito.mock(AdminSettingDao.class);
        Mockito.when(mock.getAdminSetting()).thenReturn(Optional.of(setting));
        return mock;
    }

    @Bean
    IOrderManager orderManager() {
        return new OrderManager();
    }

    @Bean
    IOrderService orderService() {
        return new OrderService();
    }

    @Bean
    IOrderDao orderDao() {
        return new OrderDao();
    }
    @Bean
    EntityFactory entityFactory() {
        return new EntityFactory();
    }

    @Bean
    ElasticsearchOperations elasticsearchOperations() {
        return Mockito.mock(ElasticsearchRestTemplate.class);
    }

    @Bean
    ElasticsearchRepository<?, ?> elasticsearchRepository() {
        return Mockito.mock(ElasticsearchRepository.class);
    }

    @Bean
    IOrderItemRepository orderItemRepository() {
        return Mockito.mock(IOrderItemRepository.class);
    }

    @Bean
    IOrderItemService orderItemService() {
        return new OrderItemService();
    }

    @Bean
    IOrderItemDao orderItemDao() {
        return new OrderItemDao();
    }

    @Bean
    IStockService stockService() {
        return Mockito.mock(StockService.class);
    }



}
