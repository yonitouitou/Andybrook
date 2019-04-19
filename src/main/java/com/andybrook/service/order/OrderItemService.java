package com.andybrook.service.order;

import com.andybrook.dao.stock.IOrderItemDao;
import com.andybrook.exception.BarCodeNotFound;
import com.andybrook.exception.InsufficientQuantityException;
import com.andybrook.exception.ProductNotFound;
import com.andybrook.model.BarCode;
import com.andybrook.model.order.OrderItem;
import com.andybrook.model.product.Product;
import com.andybrook.model.request.orderitem.OrderItemInfo;
import com.andybrook.service.product.IBarCodeService;
import com.andybrook.service.product.IProductService;
import com.andybrook.util.IdGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderItemService implements IOrderItemService {

    @Autowired
    private IOrderItemDao dao;
    @Autowired
    private IBarCodeService barCodeService;
    @Autowired
    private IProductService productService;

    @Override
    public OrderItem createOrderItem(OrderItemInfo info) throws ProductNotFound, InsufficientQuantityException, BarCodeNotFound {
        OrderItem orderItem;
        Product product = productService.get(info.getProductId());
        if (product.getQuantityUnused() > 0) {
            product.incrementQuantityUsed();
            product = productService.update(product);
            orderItem = buildOrderItem(info, product);
        } else {
            throw new InsufficientQuantityException(product.getQuantityUnused());
        }
        return orderItem;
    }

    @Override
    public OrderItem updateOrderItem(OrderItem orderItem, OrderItemInfo info) throws InsufficientQuantityException {
        /*Product product = orderItem.getProduct();
        if (product.getQuantityUnused() >= info.getQuantity()) {
            orderItem.incrementQuantity(info.getQuantity());
            product.incrementQuantityUsed(info.getQuantity());
        } else {
            throw new InsufficientQuantityException(product.getQuantityUnused());
        }
        return orderItem;*/
        return null;
    }

    @Override
    public void postDeletion(OrderItem deletedOrderItem) {
        Product product = deletedOrderItem.getProduct();
        product.decrementQuantityUsed();
        productService.update(product);
    }

    @Override
    public boolean isExist(long id) {
        return dao.isExist(id);
    }

    private OrderItem buildOrderItem(OrderItemInfo info, Product product) throws BarCodeNotFound {
        OrderItem orderItem = new OrderItem(IdGenerator.generateId(), product);
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
