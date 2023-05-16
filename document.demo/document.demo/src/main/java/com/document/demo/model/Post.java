package com.document.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "posts")
@Getter
@Setter
@Builder
public class Post {

	@Id()
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "postId")
	private Integer id;
	
	@Column
	private Integer documentId; 

	@Column(name = "title")
	private String title;

	@Column(name = "content")
	private String content;

}
