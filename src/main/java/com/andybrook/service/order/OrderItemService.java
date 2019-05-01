package com.andybrook.service.order;

import com.andybrook.dao.stock.IOrderItemDao;
import com.andybrook.exception.InsufficientQuantityException;
import com.andybrook.model.BarCode;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.request.orderitem.ProductItemInfo;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.stock.IProductStockInfoService;
import com.andybrook.service.stock.IStockService;
import com.andybrook.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

@Service
public class OrderItemService implements IOrderItemService {

    private static Logger LOGGER = System.getLogger(OrderItemService.class.getSimpleName());

    @Autowired
    private IOrderItemDao dao;
    @Autowired
    private IStockService stockService;

    @Override
    public List<OrderItem> createOrderItems(Order order, ProductItemInfo info, int quantityRequested) {
        List<OrderItem> orderItems = new LinkedList<>();
        int freeQuantity = stockService.getFreeQuantity(info.getProductId());
        if (freeQuantity >= quantityRequested) {
            for (int i = 0; i < quantityRequested; i++) {
                Optional<ProductItem> productItemOpt = stockService.findFreeProductItemOf(info.getProductId());
                if (productItemOpt.isPresent()) {
                    ProductItem productItem = productItemOpt.get();
                    OrderItem orderItem = buildOrderItem(productItem);
                    persist(order, orderItem);
                    productItem.setOrderItemIdOpt(OptionalLong.of(orderItem.getId()));
                    orderItems.add(orderItem);
                    stockService.onProductItemLinked(productItem);
                } else {
                    logFreeQuantityError(freeQuantity, quantityRequested, info.getProductId());
                }
            }
        } else {
            throw new InsufficientQuantityException(freeQuantity);
        }
        return orderItems;
    }

    @Override
    public OrderItem createSingleItemByBarCode(BarCode barCode) {
        /*ProductItem productItem = stockService.getProductItemByBarCode(barCode);
        if (productItem.isInOrder()) {
            throw new ProductItemNotFree(productItem.getId());
        }
        return buildOrderItem(productItem);*/
        return null;
    }

    @Override
    public void delete(OrderItem orderItemToDelete) {
        updateStockOnDelete(orderItemToDelete);
        dao.delete(orderItemToDelete.getId());
    }

    @Override
    public boolean isExist(long id) {
        return dao.isExist(id);
    }

    private void updateStockOnDelete(OrderItem orderItemToDelete) {
        ProductItem productItem = orderItemToDelete.getProductItem();
        productItem.setOrderItemIdOpt(OptionalLong.empty());
        stockService.onProductItemUnlinked(productItem);
    }

    private OrderItem buildOrderItem(ProductItem productItem) {
        return new OrderItem(IdGenerator.generateId(), productItem);
    }

    private void persist(Order order, OrderItem orderItem) {
        dao.update(order, orderItem);
    }

    private void logFreeQuantityError(int freeQty, int requestedQty, long productId) {
        LOGGER.log(Level.ERROR, "FreeQuantity (" + freeQty + ")" +
                " > QuantityRequested(" + requestedQty + ")" +
                " , but no free product item found for productId : " + productId);
    }
}
