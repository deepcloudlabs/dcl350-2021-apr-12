package com.example.hr.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.example.hr.document.EmployeeDocument;
import com.example.hr.entity.EmployeeEntity;

public interface EmployeeDocumentRepository extends MongoRepository<EmployeeDocument, String> {
	@Query("{year : {$gt: ?0, $lte: ?1} }")
	List<EmployeeEntity> calisanlariGetirNative(int fromYear,int toYear);

	List<EmployeeDocument> findAllByBirthYearBetween(int fromYear,int toYear);
}
