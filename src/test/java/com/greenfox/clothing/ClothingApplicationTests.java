package com.greenfox.clothing;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import java.nio.charset.Charset;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = ClothingApplication.class)
public class ClothingApplicationTests {

	private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
			MediaType.APPLICATION_JSON.getSubtype(),
			Charset.forName("utf8"));

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext webApplicationContext;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(webApplicationContext).build();
	}

	//test for type:lower
	@Test
	public void testWarehouseLower() throws Exception {
		mockMvc.perform(get("/warehouse/query?price=50&type=lower"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.result", is("ok")))
				.andExpect(jsonPath("$.clothes[0].itemName", is("Strecth Steamed Pencil Skirt")))
				.andExpect(jsonPath("$.clothes", hasSize(2)));
	}

	//test for type:equals
	@Test
	public void testWarehouseEquals() throws Exception {
		mockMvc.perform(get("/warehouse/query?price=100&type=equals"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(contentType))
				.andExpect(jsonPath("$.result", is("ok")))
				.andExpect(jsonPath("$.clothes[4].manufacturer", is("Bonnie Jean")))
				.andExpect(jsonPath("$.clothes", hasSize(5)));
	}
}
