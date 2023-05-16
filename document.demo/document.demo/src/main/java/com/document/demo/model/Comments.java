package com.document.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Comments {
	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "commentId")
	Integer id;	
	Integer postId;
	String name;
	String body;

}
