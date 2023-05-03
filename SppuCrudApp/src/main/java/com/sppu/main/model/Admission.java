package com.sppu.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Admission {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer addId;
	private String studentName;
	private String educationDetails;
	private long contactNo;
	private String course;
	
	

}
