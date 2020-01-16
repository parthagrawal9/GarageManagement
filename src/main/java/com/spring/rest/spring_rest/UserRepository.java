package com.spring.rest.spring_rest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Login, Long>{
	Login findByUserName(String userName);
}
