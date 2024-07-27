package com.no_one.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.no_one.demo.model.question;

@Repository
public interface QuestionDao extends JpaRepository<question, Integer> {

	List<question> findAllBycategory(String category);

	@Query(value ="Select * from question where category= :category Order by Random() Limit :noOfQues",nativeQuery=true)
	List<question> findRandomQuestionByCategory(@Param("category") String category, @Param("noOfQues") int noOfQues);
	
	@Query(value ="Select Category from question group by category",nativeQuery=true)
	List<String> findCategory();

}
