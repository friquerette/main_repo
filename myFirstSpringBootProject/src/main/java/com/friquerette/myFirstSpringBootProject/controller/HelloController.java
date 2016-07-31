package com.friquerette.myFirstSpringBootProject.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.friquerette.myFirstSpringBootProject.domain.User;
import com.friquerette.myFirstSpringBootProject.repositories.UserDao;

@RestController
public class HelloController {

	@Autowired
	private UserDao userDao;
	@Autowired
	// @Qualifier("jdbcTemplateOracle")
	private JdbcTemplate jdbcTemplateOracle;
	@Autowired
	// @Qualifier("jdbcTemplateMySQL")
	private JdbcTemplate jdbcTemplateMySQL;

	@RequestMapping("/")
	public String index() {
		List<User> users = (List<User>) userDao.findAll();
		String size = " - size = " + users.size();
		String msg = "Greetings from Spring Boot! " + users.toString() + size;
		return msg;
	}

	@RequestMapping("/name/{name}")
	public String byName(@PathVariable("name") String name) {
		List<User> users = userDao.findByName(name);
		String size = " - size = " + users.size();
		String msg = "Greetings from Spring Boot! " + users.toString() + size;
		return msg;
	}

	@RequestMapping("/jdbcTemplate/mysql")
	public String byJdbcTemplateMySQL() {
		String sql = "SELECT * FROM users";
		List<User> users = jdbcTemplateMySQL.query(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getInt("id"), rs.getString("name"));
			}
		});

		String size = " - size = " + users.size();
		String msg = "Greetings from Spring Boot! " + users.toString() + size;
		return msg;
	}

	@RequestMapping("/jdbcTemplate/oracle")
	public String byJdbcTemplateOracle() {
		String sql = "SELECT * FROM users";
		List<User> users = jdbcTemplateOracle.query(sql, new RowMapper<User>() {
			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				return new User(rs.getInt("id"), rs.getString("name"));
			}
		});

		String size = " - size = " + users.size();
		String msg = "Greetings from Spring Boot! " + users.toString() + size;
		return msg;
	}

}