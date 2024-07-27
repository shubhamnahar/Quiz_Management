package com.no_one.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.no_one.demo.model.Quiz;
@Repository
public interface QuizDao extends JpaRepository<Quiz, Integer>{

	@Query(value ="Select id from quiz order by id desc",nativeQuery=true)
	List<Integer> findIdOrderById();

}
