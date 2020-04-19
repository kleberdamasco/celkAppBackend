package com.kleber.celk2.demo;

import com.kleber.celk2.demo.model.FederatedState;
import com.kleber.celk2.demo.service.FederatedStateService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class DemoApplicationTests {

	private static final String HOST = "http://localhost:";
	private static final String BASE_PATH = "/api/v1/fs";

	@LocalServerPort
	private int port;

	@Autowired
	private FederatedStateService federatedStateService;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void shouldCreateAndReturn201(){
		FederatedState federatedState = getFederatedState();
		ResponseEntity<String> responseEntity = this.restTemplate.postForEntity(HOST + port + BASE_PATH + "/create", federatedState, String.class);
		assertEquals(201, responseEntity.getStatusCodeValue());
	}

	@Test
	void shouldReturnFederatedStateDeleted(){
		FederatedState federatedState = getFederatedState();
		ResponseEntity<FederatedState> responseEntity = this.restTemplate.postForEntity(HOST + port + BASE_PATH + "/create", federatedState, FederatedState.class);
		FederatedState federatedStateCreated = responseEntity.getBody();
		String url = HOST + port + BASE_PATH + "/delete/id/"+federatedStateCreated.getId();
		ResponseEntity<FederatedState> exchange = restTemplate.exchange(URI.create(url), HttpMethod.DELETE, responseEntity, FederatedState.class);
		assertNotNull(exchange.getBody());
	}

	private FederatedState getFederatedState() {
		FederatedState f = new FederatedState();
		f.setInitials("SC");
		f.setName("Santa Catarina");
		f.setCreated(LocalDateTime.now());
		return f;
	}


}
