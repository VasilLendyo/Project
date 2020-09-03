package ua.lviv.lgs.selectionCommittee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.selectionCommittee.dao.ApplicantRepository;
import ua.lviv.lgs.selectionCommittee.domain.Applicant;

@Service
public class ApplicantService {

	@Autowired
	private ApplicantRepository applicantRepository;
	
	public Applicant save(Applicant applicant) {
		return applicantRepository.save(applicant);
	}
	
	public List<Applicant> getAllApplicants(){
		return applicantRepository.findAll();
	}
	
	public Applicant findById(Integer id) {
		return applicantRepository.findById(id).get();
	}
}
