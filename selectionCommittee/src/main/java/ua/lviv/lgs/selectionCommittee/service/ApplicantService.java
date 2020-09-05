package ua.lviv.lgs.selectionCommittee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.selectionCommittee.dao.ApplicantRepository;
import ua.lviv.lgs.selectionCommittee.domain.Applicant;

@Service
public class ApplicantService {
	
	Logger logger = LoggerFactory.getLogger(ApplicantService.class);

	@Autowired
	private ApplicantRepository applicantRepository;
	
	public Applicant save(Applicant applicant) {
		logger.info("Register applicant {}: " + applicant);
		return applicantRepository.save(applicant);
	}
	
	public List<Applicant> getAllApplicants(){
		logger.info("Get all applicants");
		return applicantRepository.findAll();
	}
	
	public Applicant findById(Integer id) {
		logger.info("Get applicants by id: " + id);
		return applicantRepository.findById(id).get();
	}
}
