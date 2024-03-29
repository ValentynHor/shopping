package at.bovt.order;

import at.bovt.order.dto.OrderLineItemsDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@Testcontainers
@AutoConfigureMockMvc
class OrderAppTests {

	@Value("${spring.datasource.url}")
	private static String jdbcUrl;
	@Value("${spring.datasource.username}")
	private static String username;
	@Value("${spring.datasource.password}")
	private static String password;

	@Container
	private static final PostgreSQLContainer<?> postgresqlContainer =
			new PostgreSQLContainer<>("postgres:11.1")
			.withDatabaseName(jdbcUrl)
			.withUsername(username)
			.withPassword(password);

	@Autowired
	private MockMvc mvc;
	@Autowired
	private ObjectMapper objectMapper;

	@Test
	void createOrder() throws Exception {

		Map<String, List<OrderLineItemsDto>> requestBody = new HashMap<>();

		requestBody.put("orderLineItemsDtoList", getOrderLineItemsDtoList());

		String orderRequestString = objectMapper.writeValueAsString(requestBody);

		mvc.perform(MockMvcRequestBuilders
						.post("/api/order")
						.contentType(MediaType.APPLICATION_JSON)
						.content(orderRequestString))
				.andExpect(status().isCreated());
	}
	private List<OrderLineItemsDto> getOrderLineItemsDtoList() {
		return Collections.singletonList(
				OrderLineItemsDto.builder()
						.skuCode("iphone_13")
						.price(BigDecimal.valueOf(1200.99))
						.quantity(1)
						.build()
		);
	}
}
