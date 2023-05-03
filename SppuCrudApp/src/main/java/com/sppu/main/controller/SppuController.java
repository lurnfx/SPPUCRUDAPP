package com.sppu.main.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sppu.main.model.Admission;
import com.sppu.main.responce.AdmissionResponce;
import com.sppu.main.service.AdmissionService;

@RestController
@RequestMapping("/admission")
public class SppuController {

	
	@Autowired
	AdmissionService admissionService;
	
	@PostMapping("/add") 
	public ResponseEntity<AdmissionResponce<Admission>> postAdmissonData(@RequestBody Admission admission){
		
		Admission postAdmission = admissionService.postAdmission(admission);
		
		AdmissionResponce<Admission> admissionResponce = new  AdmissionResponce<Admission>(201, "Addmision Form Submitted", postAdmission);
		
		return new ResponseEntity<AdmissionResponce<Admission>>(admissionResponce, HttpStatus.ACCEPTED);
	}
	
	
	@GetMapping("/get")
	
	public ResponseEntity<AdmissionResponce<Iterable<Admission>>> getAllAddmisionDetails(){
		
		     Iterable<Admission> allAddmission = admissionService.getAllAdmission();
		     
		     AdmissionResponce<Iterable<Admission>> admissionResponce = new AdmissionResponce<>(200, "All Admission Request Avilable", allAddmission);
		     
		     return new ResponseEntity<AdmissionResponce<Iterable<Admission>>>(admissionResponce, HttpStatus.OK);
		     
	}
	
	@PutMapping("/put/{id}")
	public ResponseEntity<AdmissionResponce<Admission>> putAdmissonData(@RequestBody Admission admission, @PathVariable int id){
		
		Admission postAdmission = admissionService.putAdmission(admission,id);
		
		AdmissionResponce<Admission> admissionResponce = new  AdmissionResponce<Admission>(201, "Addmision updated Succesfully", postAdmission);
		
		return new ResponseEntity<AdmissionResponce<Admission>>(admissionResponce, HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<AdmissionResponce<Admission>> deleteAddmision(@PathVariable int id){
		
		             String msg = admissionService.deleteAdmission(id);
		             
		             AdmissionResponce<Admission> admissionResponce = new AdmissionResponce<Admission>(204,msg , new Admission());
		             
		             return new ResponseEntity<AdmissionResponce<Admission>>(admissionResponce, HttpStatus.NO_CONTENT);
		
	}
	
	
}
