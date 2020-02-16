package com.andybrook.service.order;

import com.andybrook.dao.order.IOrderItemDao;
import com.andybrook.exception.InsufficientQuantityException;
import com.andybrook.exception.ProductItemNotFree;
import com.andybrook.model.BarCode;
import com.andybrook.model.order.Order;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.ProductId;
import com.andybrook.model.request.orderitem.OrderItemInfo;
import com.andybrook.model.stock.ProductItem;
import com.andybrook.service.stock.IStockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderItemService implements IOrderItemService {

    private static Logger LOGGER = System.getLogger(OrderItemService.class.getSimpleName());

    @Autowired
    private IOrderItemDao dao;
    @Autowired
    private IStockService stockService;

    @Override
    public List<OrderItem> createOrderItems(Order order, OrderItemInfo info, int quantityRequested) {
        List<OrderItem> orderItems = new LinkedList<>();
        int freeQuantity = stockService.getFreeQuantity(info.getProductId());
        if (freeQuantity >= quantityRequested) {
            for (int i = 0; i < quantityRequested; i++) {
                Optional<ProductItem> productItemOpt = stockService.findFreeProductItemOf(info.getProductId());
                if (productItemOpt.isPresent()) {
                    ProductItem productItem = productItemOpt.get();
                    OrderItem orderItem = buildOrderItem(order.getId(), productItem.getId());
                    persist(orderItem);
                    productItem.markAsUsed(orderItem.getId());
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
    public OrderItem createSingleOrderItemByBarCode(Order order, BarCode barCode) {
        ProductItem productItem = stockService.getProductItemByBarCode(barCode);
        if (productItem.isInOrder()) {
            throw new ProductItemNotFree(productItem.getId());
        }
        return buildOrderItem(order.getId(), productItem.getId());
    }

    @Override
    public void delete(OrderItem orderItemToDelete) {
        updateStockOnDelete(orderItemToDelete);
        dao.delete(orderItemToDelete.getId());
    }

    @Override
    public boolean isExist(String id) {
        return dao.isExist(id);
    }

    private void updateStockOnDelete(OrderItem orderItemToDelete) {
        long productItemId = orderItemToDelete.getProductItemId();
        ProductItem productItem = stockService.getProductItem(productItemId);
        productItem.setOrderItemId(null);
        stockService.onProductItemUnlinked(productItem);
    }

    private OrderItem buildOrderItem(long orderId, long productItemId) {
        return new OrderItem(orderId, productItemId);
    }

    private void persist(OrderItem orderItem) {
        dao.save(orderItem);
    }

    private void logFreeQuantityError(int freeQty, int requestedQty, ProductId productId) {
        LOGGER.log(Level.ERROR, "FreeQuantity (" + freeQty + ")" +
                " > QuantityRequested(" + requestedQty + ")" +
                " , but no free product item found for productId : " + productId);
    }
}
