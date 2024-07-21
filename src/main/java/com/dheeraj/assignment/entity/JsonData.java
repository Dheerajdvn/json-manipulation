package com.dheeraj.assignment.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Getter;
import lombok.Setter;

/**
 * This entity class represents `jsondata` table.
 * 
 * @author Dheeraj Verma
 * @since v1.0.0
 */
@Getter
@Setter
@Entity
public class JsonData implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Lob
    private String jsonmodel;
}