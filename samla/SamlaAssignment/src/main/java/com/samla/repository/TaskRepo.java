package com.samla.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.samla.model.Task;

@Repository
public interface TaskRepo extends JpaRepository<Task, Integer> {
	//@Query(value = "SELECT  FROM task ORDER BY RAND() LIMIT 1", nativeQuery = true)
	@Query("select que from Task que order by RAND() LIMIT 1")
    Task getRandomQuestion();
}
