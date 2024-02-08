package com.da.sb;

import com.da.sb.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OrderServiceImpl implements OrderService {

    private final OrderRepo orderRepo;
    private static final Logger logger = LoggerFactory.getLogger(SbApplication.class);

    @Autowired
    public OrderServiceImpl(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    @Override
    public Order getOrder(long orderId) {
        logger.info(String.format("Processing a new request for the order ID: %d", orderId));
        return orderRepo.getReferenceById(orderId);
    }
}
