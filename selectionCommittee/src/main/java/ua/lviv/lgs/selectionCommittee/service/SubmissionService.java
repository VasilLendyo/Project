package ua.lviv.lgs.selectionCommittee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.selectionCommittee.dao.SubmissionRepository;
import ua.lviv.lgs.selectionCommittee.domain.Submission;

@Service
public class SubmissionService {

	@Autowired
	private SubmissionRepository submissionRepository;

	public List<Submission> getAll() {
		return submissionRepository.findAll();
	}

	public void delete(Submission submission) {
		submissionRepository.delete(submission);
	}

	public Submission add(Submission submission) {
		return submissionRepository.save(submission);
	}
}
