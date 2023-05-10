package com.document.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.document.demo.model.Document;

public interface DocRepository extends JpaRepository<Document, Integer>{

}
