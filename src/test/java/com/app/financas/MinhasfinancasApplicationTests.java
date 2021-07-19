package com.app.financas;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class MinhasfinancasApplicationTests {

	@Test
	void contextLoads() {
	}


	@Autowired
	MockMvc mockMvc;

	@Test
	void testeControllerGET(){
		mockMvc.perform(get("http://localhost:8080/1")).andExpect(status().ok());
	}

}
