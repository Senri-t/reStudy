package com.example.__22.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.__22.Entity.SubjectEntity;
import com.example.__22.form.SubjectForm;
import com.example.__22.repository.SubjectRepository;


@Service
public class SubjectService {
	
	@Autowired
	  private SubjectRepository subjectRepository;
	
	public List<SubjectEntity> searchAll() {
	      return subjectRepository.findAll();
	}
	
	 public void create(SubjectForm subjectRequest) {
		   SubjectEntity subject = new SubjectEntity();
		   subject.setTitle(subjectRequest.getTitle());
		   subject.setName(subjectRequest.getName());
		   subjectRepository.save(subject);
		 }
	 /**
	    * @return
	    */
	   public SubjectEntity findById(Integer id) {
	       return subjectRepository.getOne(id);
	   }
	  
	   /**
	    * @param  
	    */
	   public void update(SubjectForm subjectUpdateRequest) {
	       SubjectEntity subject = findById(subjectUpdateRequest.getId());
	       subject.setTitle(subjectUpdateRequest.getTitle());
	       subject.setName(subjectUpdateRequest.getName());
	       subjectRepository.save(subject);
	   }
	   
		/**
    	 * @param
		 */
		public void delete(Integer id) {
			SubjectEntity subject = findById(id);
			subjectRepository.delete(subject);
		}
}

