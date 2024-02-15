package com.da.sb;

import com.da.sb.order.Order;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

public interface OrderRepoCompositeService {

    @GetMapping(
            value = "/composite/{compositeId}",
            produces = "application/json")
    Order getComposite(@PathVariable long compositeId);
}
