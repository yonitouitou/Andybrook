package com.andybrook.dao.stock.jpa;

import com.andybrook.dao.jpa.entity.stock.StockReportEntity;
import com.andybrook.enums.ReportStatus;
import com.andybrook.model.StockReport;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

public interface IStockReportCrudRepository extends PagingAndSortingRepository<StockReportEntity, Long> {

    String ENTITY_NAME = "StockReportEntity";
    String COLUMN_ID = "id";
    String COLUMN_NAME = "name";
    String COLUMN_COMMENT = "comment";
    String COLUMN_STATUS = "status";

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
                    "s. " + COLUMN_STATUS + " = :status " +
            "WHERE " +
                    "s." + COLUMN_ID + "= :id";

    @Modifying
    @Transactional
    @Query(value = UPDATE_STATUS_QUERY)
    void updateStockReportStatus(@Param("id") long id, @Param("status") ReportStatus status);
}
