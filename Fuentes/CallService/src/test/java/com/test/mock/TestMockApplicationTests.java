package com.test.mock;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.test.mock.resources.PersonService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;


@SpringBootTest
public class TestMockApplicationTests {

	@Autowired
	private PersonService service;


	@Test
	public void testFindPersonById(){
      assertEquals( 200, service.findPersonById( 4 ).getCode() );
	}

	@Test
	public void testInformationExist(){
		   Pageable page = PageRequest.of(0, 5);
           assertTrue( service.getPersonByPage( page ).hasContent() );
	}


}
