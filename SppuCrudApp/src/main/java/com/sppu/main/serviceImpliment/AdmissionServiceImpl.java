package com.sppu.main.serviceImpliment;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sppu.main.model.Admission;
import com.sppu.main.repository.AdmissionRepo;
import com.sppu.main.service.AdmissionService;


@Service
public class AdmissionServiceImpl implements AdmissionService {

	@Autowired
	AdmissionRepo admissionRepo;
	
	@Override
	public Admission postAdmission(Admission admission) {
		return admissionRepo.save(admission);
	}

	@Override
	public Iterable<Admission> getAllAdmission() {
		return admissionRepo.findAll();
	}

	@Override
	public Admission putAdmission(Admission admission, int id) {
		       Optional<Admission> admisionData= admissionRepo.findById(id);
		       
		       if(admisionData.isPresent()) 
		       {
		    	     admission.setAddId(admisionData.get().getAddId());
		    	     return admissionRepo.save(admission);
		       }
		       else
               {
		    	    return null;
		       }
		      
	   }

	@Override
	public String deleteAdmission(int id) {
		
		if(admissionRepo.existsById(id)) 
		{
			admissionRepo.deleteById(id);
			return "Admission Delete";
			
		}
		else 
		{
			return "Admission Not Avalable";
		}
		
	}
	
	
	
	
	

}
