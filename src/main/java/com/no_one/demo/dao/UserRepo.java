package com.no_one.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.no_one.demo.model.UserTable;
@Repository
public interface UserRepo extends JpaRepository<UserTable, Integer>{
	
	UserTable findByuName(String uName);

}
