package com.da.sb;

import com.da.sb.order.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface OrderService {

    @GetMapping(
            value = "/order/{orderId}",
            produces = "application/json")
    Order getOrder(@PathVariable long orderId);
}
