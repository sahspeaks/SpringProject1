package com.practice.SpringProject1.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practice.SpringProject1.model.Underwriter;
import com.practice.SpringProject1.repo.AdminRepo;
import com.practice.SpringProject1.util.ApiResponse;

@Service
public class AdminService {
	
	@Autowired
	private AdminRepo adminRepo;

	public ApiResponse<List<Underwriter>> getAllUnderWriters() {
		
		List<Underwriter> underwriters = adminRepo.findAll();
		if(underwriters.isEmpty()) {
			return ApiResponse.error("No underwriters found.");
		}
		return ApiResponse.success("Underwriters retrieved successfully.", underwriters);
	}
	
	public ApiResponse<Underwriter> getUnderWriterById(int underwriterId) {

		Underwriter underwriter= adminRepo.findById(underwriterId).orElse(null);
		if (underwriter == null) {
			return ApiResponse.error("Underwriter with ID " + underwriterId + " not found.");
		}
		return ApiResponse.success("Underwriter retrieved successfully.", underwriter);
	}
	
	public ApiResponse<Underwriter> addUnderWriter(Underwriter underwriter) {
	    if (adminRepo.existsById(underwriter.getUnderwriterId())) {
	        return ApiResponse.error("Underwriter with ID " + underwriter.getUnderwriterId() + " already exists.");
	    }

	    if (!isValidPassword(underwriter.getPassword())) {
	        return ApiResponse.error("Password must be at least 8 characters long and include letters, numbers, and a special character.");
	    }

	    if (underwriter.getDob().after(new Date())) {
	        return ApiResponse.error("Date of birth cannot be in the future.");
	    }

	    if (underwriter.getJoiningDate().before(underwriter.getDob())) {
	        return ApiResponse.error("Joining date cannot be before date of birth.");
	    }

	    Underwriter savedUnderwriter = adminRepo.save(underwriter);
	    if (savedUnderwriter == null) {
	        return ApiResponse.error("Failed to add underwriter.");
	    }
	    
	    return ApiResponse.success("Underwriter added successfully.", savedUnderwriter);
	}
	
	
	public ApiResponse<Underwriter> updateUnderWriter(Underwriter underwriter) {
		if(!adminRepo.existsById(underwriter.getUnderwriterId())) {
			return ApiResponse.error("Underwriter with ID " + underwriter.getUnderwriterId() + " not found.");
		}
		if (!isValidPassword(underwriter.getPassword())) {
	        return ApiResponse.error("Password must be at least 8 characters long and include letters, numbers, and a special character.");
	    }

	    if (underwriter.getDob().after(new Date())) {
	        return ApiResponse.error("Date of birth cannot be in the future.");
	    }

	    if (underwriter.getJoiningDate().before(underwriter.getDob())) {
	        return ApiResponse.error("Joining date cannot be before date of birth.");
	    }
	    
	    Underwriter updatedUnderwriter = adminRepo.save(underwriter);
	    if (updatedUnderwriter == null) {
	        return ApiResponse.error("Failed to update underwriter.");
	    }
	    return ApiResponse.success("Underwriter updated successfully.", updatedUnderwriter);
	}
	
	public ApiResponse<String> deleteUnderWriter(int underwriterId) {
		if(!adminRepo.existsById(underwriterId)) {
			return ApiResponse.error("Underwriter with ID " + underwriterId + " not found.");	
		}
		adminRepo.deleteById(underwriterId);
		return ApiResponse.success("Underwriter with ID " + underwriterId + " deleted successfully.", null);
	}
	
	// Validation methods
	private static boolean isValidPassword(String password) {
		// Password must contain alphanumeric and special character
		return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
	}
}
