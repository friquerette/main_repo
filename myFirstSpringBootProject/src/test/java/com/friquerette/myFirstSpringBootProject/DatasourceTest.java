package com.friquerette.myFirstSpringBootProject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.friquerette.myFirstSpringBootProject.repositories.UserDao;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class DatasourceTest {

	@Autowired
	private UserDao userDao;

	@Test
	public void getHello() throws Exception {
		userDao.findAll();
	}
}
