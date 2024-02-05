package com.da.sb;

import com.da.sb.order.Order;
import com.da.sb.order.Side;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

    List<Order> findBySide(final Side side);

    Order findById(long id);
}
