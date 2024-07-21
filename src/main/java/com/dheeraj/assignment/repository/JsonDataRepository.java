package com.dheeraj.assignment.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dheeraj.assignment.entity.JsonData;

/**
 * Repository to perform JPA operations on JsonData entity.
 * 
 * @author Dheeraj Verma
 * @since v1.0.0
 */
public interface JsonDataRepository extends JpaRepository<JsonData, Integer> {

}