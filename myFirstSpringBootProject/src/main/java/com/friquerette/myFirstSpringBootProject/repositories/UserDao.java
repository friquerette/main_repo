package com.friquerette.myFirstSpringBootProject.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.friquerette.myFirstSpringBootProject.domain.User;

@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

	List<User> findByName(String lastname);

}
