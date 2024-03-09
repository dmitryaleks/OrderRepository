package com.da.sb;

import com.da.sb.order.Order;
import com.da.sb.order.Side;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureWebTestClient
class SbApplicationTests {

	@Test
	void contextLoads() {
	}

	@MockBean
	private OrderRepoCompositeServiceImpl compositeService;

	@Autowired
	WebTestClient client;

	private static final int ORDER_ID = 1;

	@BeforeEach
	void setUp() {
		when(compositeService.getComposite(ORDER_ID)).
				thenReturn(new Order(42., 100., Side.BUY));
	}

	@Test
	void testCompositeService() {
		client.get().uri("/composite/" + ORDER_ID)
				.accept(APPLICATION_JSON).exchange().expectStatus().isOk()
				.expectHeader().contentType(APPLICATION_JSON)
				.expectBody()
				.jsonPath("$.price").isEqualTo(42)
				.jsonPath("$.quantity").isEqualTo(100.)
				.jsonPath("$.side").isEqualTo(Side.BUY.toString());
	}

}
