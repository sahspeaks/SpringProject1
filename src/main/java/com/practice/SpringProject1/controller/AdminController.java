package com.practice.SpringProject1.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.practice.SpringProject1.model.Underwriter;
import com.practice.SpringProject1.service.AdminService;
import com.practice.SpringProject1.util.ApiResponse;
import com.practice.SpringProject1.util.ApiResponseUtil;

@RestController
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	//private UnderWriterService underWriterService;
	
	@GetMapping("/")
	public String Home() {
		return "Home";
	}
	@PostMapping("/login")
	public String Login() {
		return "Login";
	}

	@GetMapping("/admin")
	public String AdminHome() {
		return "Admin Home";
	}
	
	@PostMapping("/admin/addUnderWriter")
	public ResponseEntity<ApiResponse<Underwriter>> addUnderWriter(@RequestBody Underwriter underwriter) {
	    ApiResponse<Underwriter> response = adminService.addUnderWriter(underwriter);
	    return ApiResponseUtil.buildResponse(response);
	}
	
	@PutMapping("/admin/updateUnderWriter")
	public ResponseEntity<ApiResponse<Underwriter>> updateUnderWriter(@RequestBody Underwriter underwriter) {
		ApiResponse<Underwriter> response = adminService.updateUnderWriter(underwriter);
		return ApiResponseUtil.buildResponse(response);
	}
	@DeleteMapping("/admin/deleteUnderWriter/{underwriterId}")
	public ResponseEntity<ApiResponse<String>> deleteUnderWriter(@PathVariable int underwriterId) {
		ApiResponse<String> response = adminService.deleteUnderWriter(underwriterId);
		return ApiResponseUtil.buildResponse(response);
	}
	@GetMapping("/admin/searchUnderWriter/{underwriterId}")
	public ResponseEntity<ApiResponse<Underwriter>> viewUnderWriter(@PathVariable int underwriterId) {
		ApiResponse<Underwriter> response = adminService.getUnderWriterById(underwriterId);
		return ApiResponseUtil.buildResponse(response);
	}
	
	@GetMapping("/admin/viewAllUnderWriters")
	public ResponseEntity<ApiResponse<List<Underwriter>>>  viewAllUnderWriters() {
		ApiResponse<List<Underwriter>> response = adminService.getAllUnderWriters();
		return ApiResponseUtil.buildResponse(response);
	}
	
}
