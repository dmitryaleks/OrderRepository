package com.da.sb;

import com.da.sb.order.Order;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class OrderRepoCompositeServiceImpl implements  OrderRepoCompositeService {

    private static final String ORDER_SERVICE_URL_FORMATTER = "http://%s:%d/order/{orderId}";

    private static final Logger logger = LoggerFactory.getLogger(SbApplication.class);

    private final RestTemplate restTemplate;
    //@Value("${app.order-service.host")
    private String orderServiceHost = "localhost";
    //@Value("${app.order-service.port")
    private int orderServicePort = 7080;

    @Autowired
    public OrderRepoCompositeServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Override
    public Order getComposite(long compositeId) {
        logger.info(String.format("Processing a new request for the composite ID: %d", compositeId));
        // dispatch the call to the concrete service
        return restTemplate.getForObject(getUrlForTheOrderService(),
                Order.class, compositeId);
    }

    private String getUrlForTheOrderService() {
        return ORDER_SERVICE_URL_FORMATTER.formatted(orderServiceHost, orderServicePort);
    }
}
