/*
 * Copyright 2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *	  https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.restservice;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;


@SpringBootTest
@AutoConfigureMockMvc
public class UnicornControllerTests {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void validUnicornPostShouldReturnUnicornId() throws Exception {
		
		StringBuffer mockPostBuffer = new StringBuffer();
		mockPostBuffer.append("{\"name\": \"Sparkle Princess\",");
		mockPostBuffer.append("\"hairColor\": \"White\",");
		mockPostBuffer.append("\"hornLength\": 104,");
		mockPostBuffer.append("\"hornColor\": \"Gold\",");
		mockPostBuffer.append("\"eyeColor\":  \"Sapphire\",");
		mockPostBuffer.append("\"height\": 94,");
		mockPostBuffer.append("\"heightUnit\": \"cm\",");
		mockPostBuffer.append("\"weight\": 104,");
		mockPostBuffer.append("\"weightUnit\": \"kg\",");
		mockPostBuffer.append("\"identifiableMarks\": [{");
		mockPostBuffer.append("\"side\": \"Left\",");
		mockPostBuffer.append("\"location\": \"Hind Quarters\",");
		mockPostBuffer.append("\"mark\": \"Star\",");
		mockPostBuffer.append("\"color\": \"Blue\" }");
		mockPostBuffer.append("]}");
		
		String mockJsonPostBody = mockPostBuffer.toString();

		this.mockMvc.perform(post("/unicorns").contentType("application/json").content(mockJsonPostBody)).andDo(print()).andExpect(status().isOk())
				.andExpect(jsonPath("$.unicornId").exists()).andExpect(jsonPath("$.unicornId").isNumber());
	}
	
	@Test
	public void getAllUnicornsReturnsUnicorns() throws Exception {
		this.mockMvc.perform(get("/unicorns").contentType("application/json")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.").isArray()).andExpect(jsonPath("$.unicornId").exists());
	}
	
	@Test
	public void getUnicornWithId1ReturnsUnicornId1() throws Exception{
		this.mockMvc.perform(get("/unicorns/1").contentType("application/json")).andDo(print()).andExpect(status().isOk()).andExpect(jsonPath("$.unicornId").exists()).andExpect(jsonPath("$.unicornId").isNumber());
	}

}
