package com.document.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name ="Docs")

public class Document {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id ;
	
	private String DocName;
	
	private String docType;
	
	@Lob
	private byte[] data;
	
	

	public Document(String docName, String docType, byte[] data) {
		super();
		DocName = docName;
		this.docType = docType;
		this.data = data;
	}



	public Document() {
		super();
	}
	
	
	

}