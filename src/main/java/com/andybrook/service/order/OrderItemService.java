package com.andybrook.service.order;

import com.andybrook.dao.stock.IOrderItemDao;
import com.andybrook.exception.BarCodeNotFound;
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
    public OrderItem<? extends Product> createOrderItem(OrderItemInfo info) throws ProductNotFound, InsufficientQuantityException, BarCodeNotFound {
        OrderItem<? extends Product> orderItem;
        Product product = productService.get(info.getProductId());
        if (product.getQuantityUnused() >= info.getQuantity()) {
            orderItem = buildOrderItem(info, product);
            product.incrementQuantityUsed(info.getQuantity());
        } else {
            throw new InsufficientQuantityException(product.getQuantityUnused());
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
        if (product.getQuantityUnused() >= info.getQuantity()) {
            orderItem.incrementQuantity(info.getQuantity());
            product.incrementQuantityUsed(info.getQuantity());
        } else {
            throw new InsufficientQuantityException(product.getQuantityUnused());
        }
        return orderItem;
    }

    @Override
    public void postDeletion(OrderItem<? extends Product> deletedOrderItem) {
        Product product = deletedOrderItem.getProduct();
        product.decrementQuantityUsed(deletedOrderItem.getQuantity());
        productService.update(product);
    }

    @Override
    public boolean isExist(long id) {
        return dao.isExist(id);
    }

    private OrderItem<? extends Product> buildOrderItem(OrderItemInfo info, Product product) throws BarCodeNotFound {
        OrderItem<? extends Product> orderItem = new OrderItem<>(IdGenerator.generateId(), product, info.getQuantity());
        if (info.getBarCodeId() != null) {
            BarCode barCode = barCodeService.get(info.getBarCodeId());
            if (barCode != null) {
                orderItem.setBarCode(barCode);
            } else {
                throw new BarCodeNotFound(info.getBarCodeId());
            }
        }
        return orderItem;
    }
}
