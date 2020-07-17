package com.database.example.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.database.example.model.Members;


public interface MemberDetailsDao extends JpaRepository<Members, Integer> {

	List<Members> findByDevice(String device);

	@Query(" from Members where device = ?1 order by name ASC")
	List<Members> findBydeviceSorted(String device);
	
}
