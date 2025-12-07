package com.example.__22.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;


	@Data
	@Entity
	@Table(name = "book")
	
	public class SubjectEntity {


	   @Id
	   @GeneratedValue(strategy=GenerationType.IDENTITY)
	   @Column(name="bookid")
	   private Integer bookid;
	  
	   @Column(name="title")
	   private String title;
	  
	   @Column(name="name")
	   private String name;

	}
