package ua.lviv.lgs.selectionCommittee.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.selectionCommittee.dao.SubmissionRepository;
import ua.lviv.lgs.selectionCommittee.domain.Submission;

@Service
public class SubmissionService {
	
	Logger logger = LoggerFactory.getLogger(SubmissionService.class);

	@Autowired
	private SubmissionRepository submissionRepository;
	

	public List<Submission> getAll() {
		logger.info("Get all applicants of submission");
		return submissionRepository.findAll();
	}
	

	public Submission add(Submission submission) {
		logger.info("Register new applicant to submission");
		return submissionRepository.save(submission);
	}
	
	
}
