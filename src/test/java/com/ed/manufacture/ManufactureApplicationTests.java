package com.ed.manufacture;

import com.ed.manufacture.dao.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ManufactureApplicationTests {

	@Autowired
	private UserRepository userRepository;

	@Value("${spring.datasource.url}")
	private String jdbcURl;


	@Test
	public void contextLoads() {
		System.out.println(jdbcURl);
	}

	@Test
	public void findUser(){
		String name = "Гусев";
		Assert.assertEquals(userRepository.findUser(name).getSurname(),name);
	}

}
