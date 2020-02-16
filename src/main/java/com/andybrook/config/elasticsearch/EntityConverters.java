package com.andybrook.config.elasticsearch;


import com.andybrook.model.order.OrderItem;
import com.andybrook.util.DateUtil;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.convert.WritingConverter;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collection;
import java.util.Map;

public class EntityConverters {

    static final Converter<LocalDateTime, Long> LOCAL_DATE_TIME_TO_LONG = new LocalDateTimeToLongConverter();
    static final Converter<Long, LocalDateTime> LONG_TO_LOCAL_DATE_TIME = new LongToLocalDateTimeConverter();
    static final Converter<Map<Long, OrderItem>, Collection<OrderItem>> MAP_TO_ORDER_ITEM = new MapToOrderItem();

    public static class LocalDateTimeToLongConverter implements Converter<LocalDateTime, Long> {

        @Override
        public Long convert(LocalDateTime localDateTime) {
            return DateUtil.toEpochMilli(localDateTime);
        }
    }

    public static class LongToLocalDateTimeConverter implements Converter<Long, LocalDateTime> {

        @Override
        public LocalDateTime convert(Long aLong) {
            return LocalDateTime.ofInstant(Instant.ofEpochMilli(aLong), ZoneId.of("UTC"));
        }
    }

    @WritingConverter
    public static class MapToOrderItem implements Converter<Map<Long, OrderItem>, Collection<OrderItem>> {
        @Override
        public Collection<OrderItem> convert(Map<Long, OrderItem> map) {
            return map.values();
        }

        /*@Override
        public OrderItem convert(Map<String, String> stringObjectMap) {
            long id = Long.parseLong(stringObjectMap.get("id"));
            long orderId = Long.parseLong(stringObjectMap.get("orderId"));
            long productItemId = Long.parseLong(stringObjectMap.get("productItemId"));
            LocalDateTime createdDateTime = LONG_TO_LOCAL_DATE_TIME.convert(Long.parseLong(stringObjectMap.get("createdDateTime")));
            LocalDateTime lastModifiedDateTime = LONG_TO_LOCAL_DATE_TIME.convert(Long.parseLong(stringObjectMap.get("lastModifiedDatetime")));
            return new OrderItem(id, orderId, productItemId, createdDateTime, lastModifiedDateTime);
        }*/
    }
}
