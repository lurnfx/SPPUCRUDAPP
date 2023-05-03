package com.sppu.main.service;

import com.sppu.main.model.Admission;

public interface AdmissionService {

	Admission postAdmission(Admission admission);

	Iterable<Admission> getAllAdmission();

	Admission putAdmission(Admission admission, int id);

	String deleteAdmission(int id);
	
	

}
