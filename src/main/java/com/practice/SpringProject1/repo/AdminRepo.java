package com.practice.SpringProject1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practice.SpringProject1.model.Underwriter;

public interface AdminRepo extends JpaRepository<Underwriter, Integer> {
	// This interface will automatically provide CRUD operations for the UnderWriter entity

}
