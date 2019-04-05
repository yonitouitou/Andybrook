package com.andybrook.service.order;

import com.andybrook.dao.stock.IOrderItemDao;
import com.andybrook.exception.InsufficientQuantityException;
import com.andybrook.exception.OrderItemNotFound;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.BarCode;
import com.andybrook.model.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.orderitem.OrderItemInfo;
import com.andybrook.service.product.IBarCodeService;
import com.andybrook.service.product.IProductService;
import com.andybrook.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class OrderItemService implements IOrderItemService {

    @Autowired
    private IOrderItemDao dao;
    @Autowired
    private IBarCodeService barCodeService;
    @Autowired
    private IProductService productService;

    @Override
    public OrderItem<? extends Product> createOrderItem(OrderItemInfo info) throws ProductNotFound, InsufficientQuantityException {
        OrderItem<? extends Product> orderItem;
        Product product = productService.get(info.getProductId());
        if (product.getQuantity() >= info.getQuantity()) {
            orderItem = buildOrderItem(info, product);
            product.decrementQuantity(info.getQuantity());
        } else {
            throw new InsufficientQuantityException(product.getQuantity());
        }
        return orderItem;
    }

    @Override
    public OrderItem<? extends Product> get(long id) throws OrderItemNotFound {
        OrderItem<? extends Product> item;
        Optional<OrderItem<Product>> stockItemOpt = dao.getOrderItem(id);
        if (stockItemOpt.isPresent()) {
            item = stockItemOpt.get();
        } else {
            throw new OrderItemNotFound(id);
        }
        return item;
    }

    @Override
    public OrderItem<? extends Product> updateOrderItem(OrderItem orderItem, OrderItemInfo info) throws InsufficientQuantityException {
        Product product = orderItem.getProduct();
        if (product.getQuantity() >= info.getQuantity()) {
            orderItem.setQuantity(info.getQuantity());
        } else {
            throw new InsufficientQuantityException(product.getQuantity());
        }
        return orderItem;
    }

    private OrderItem<? extends Product> buildOrderItem(OrderItemInfo info, Product product) {
        OrderItem<? extends Product> orderItem = new OrderItem<>(IdGenerator.generateId(), product, info.getQuantity());
        BarCode barCode = barCodeService.get(info.getBarCodeId());
        if (barCode != null) {
            orderItem.setBarCode(barCode);
        }
        return orderItem;
    }

    @Override
    public void postDeletion(long orderItemId) throws OrderItemNotFound {
        OrderItem<? extends Product> orderItemToDelete = get(orderItemId);
        Product product = orderItemToDelete.getProduct();
        product.decrementQuantity(orderItemToDelete.getQuantity());
    }
}
