package com.andybrook.dao.stock.jpa;

import com.andybrook.dao.jpa.entity.stock.StockReportEntity;
import com.andybrook.enums.ReportStatus;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

public interface IStockReportCrudRepository extends PagingAndSortingRepository<StockReportEntity, Long> {

    String ENTITY_NAME = "StockReportEntity";
    String COLUMN_ID = "id";
    String COLUMN_NAME = "name";
    String COLUMN_COMMENT = "comment";
    String COLUMN_STATUS = "status";
    String COLUMN_CLOSE_DATETIME = "closeDatetime";

    String UPDATE_EXISTING_STOCK_REPORT_QUERY =
            "UPDATE " + ENTITY_NAME + " s SET " +
                    "s." + COLUMN_NAME + " = :name, " +
                    "s." + COLUMN_COMMENT + " = :comment " +
            "WHERE " +
                    "s." + COLUMN_ID + "= :id";

    @Modifying
    @Transactional
    @Query(value = UPDATE_EXISTING_STOCK_REPORT_QUERY)
    void updateExistingStockReport(@Param("id") long id,
                                   @Param("name") String name,
                                   @Param("comment") String comment);


    String UPDATE_STATUS_QUERY =
            "UPDATE " + ENTITY_NAME + " s SET " +
                    "s." + COLUMN_STATUS + " = :status, " +
                    "s." + COLUMN_CLOSE_DATETIME + " = :closeDatetime " +
            "WHERE " +
                    "s." + COLUMN_ID + "= :id";

    @Modifying
    @Transactional
    @Query(value = UPDATE_STATUS_QUERY)
    void closeStockReport(@Param("id") long id, @Param("status") ReportStatus status, @Param("closeDatetime") LocalDateTime closeDatetime);
}
