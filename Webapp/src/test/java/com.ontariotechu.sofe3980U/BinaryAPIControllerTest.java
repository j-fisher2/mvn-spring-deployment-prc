package com.ontariotechu.sofe3980U;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.junit.runner.RunWith;

import org.junit.*;
import org.junit.runner.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.context.junit4.*;

import static org.hamcrest.Matchers.containsString;

import static org.assertj.core.api.Assertions.*;
import static org.mockito.BDDMockito.*;


@RunWith(SpringRunner.class)
@WebMvcTest(BinaryAPIController.class)
public class BinaryAPIControllerTest {

    @Autowired
    private MockMvc mvc;

   
    @Test
    public void add() throws Exception {
        this.mvc.perform(get("/add").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("10001"));
    }
	@Test
    public void add2() throws Exception {
        this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
			.andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
			.andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
    }
	@Test
	public void addWithBothZeroOperands() throws Exception {
    	this.mvc.perform(get("/add").param("operand1","0").param("operand2","0"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string("0"));
	}
	@Test
	public void addJsonWithValidOperands() throws Exception {
    	this.mvc.perform(get("/add_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
            .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
	}
	@Test
	public void addJsonWithZeroOperand() throws Exception {
    	this.mvc.perform(get("/add_json").param("operand1","0").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(0))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
            .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1010))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("add"));
	}
	@Test
	public void or() throws Exception{
		this.mvc.perform(get("/or").param("operand1","111").param("operand2","11111"))//.andDo(print())
            	.andExpect(status().isOk())
            	.andExpect(content().string("11111"));


	}
	@Test
	public void or2() throws Exception{
		this.mvc.perform(get("/or_json").param("operand1","111").param("operand2","1010"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(1010))
            .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(1111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("or"));

	}
	@Test
	public void and() throws Exception{
		this.mvc.perform(get("/and").param("operand1","111").param("operand2","0"))//.andDo(print())
            	.andExpect(status().isOk())
            	.andExpect(content().string("0"));
	}
	@Test
	public void and2() throws Exception{
		this.mvc.perform(get("/and_json").param("operand1","111").param("operand2","10100"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(10100))
            .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(100))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("and"));

	}
	@Test
	public void multiply() throws Exception{
		this.mvc.perform(get("/multiply").param("operand1","111").param("operand2","101010"))//.andDo(print())
            	.andExpect(status().isOk())
            	.andExpect(content().string("100100110"));
	}
	@Test
	public void multiply2() throws Exception{
		this.mvc.perform(get("/multiply_json").param("operand1","111").param("operand2","10100"))//.andDo(print())
            .andExpect(status().isOk())
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand1").value(111))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operand2").value(10100))
            .andExpect(MockMvcResultMatchers.jsonPath("$.result").value(10001100))
            .andExpect(MockMvcResultMatchers.jsonPath("$.operator").value("multiply"));

	}

}