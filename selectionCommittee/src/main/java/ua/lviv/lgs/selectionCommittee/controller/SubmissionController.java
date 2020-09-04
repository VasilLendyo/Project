package ua.lviv.lgs.selectionCommittee.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.selectionCommittee.domain.Applicant;
import ua.lviv.lgs.selectionCommittee.domain.Submission;
import ua.lviv.lgs.selectionCommittee.domain.User;
import ua.lviv.lgs.selectionCommittee.service.ApplicantService;
import ua.lviv.lgs.selectionCommittee.service.SubmissionService;
import ua.lviv.lgs.selectionCommittee.service.UserService;

@Controller
public class SubmissionController {

	@Autowired
	private SubmissionService submissionService;

	@Autowired
	private UserService userService;

	@Autowired
	private ApplicantService applicantService;

	@RequestMapping(value = "/submissions", method = RequestMethod.GET)
	public ModelAndView getAllItems() {
		return getSubmissionItems();
	}

	@RequestMapping(value = "/submission", method = RequestMethod.POST)
	public ModelAndView create(@RequestParam String applicantId) {
		Applicant applicant = applicantService.findById(Integer.parseInt(applicantId));

		Submission submission = new Submission();
		submission.setApplicant(applicant);
		submission.setDate(new Date());
		if(applicant.getAllGrades()>350) {
			submission.setAccepted(true);
		}

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String userEmail = auth.getName();
		User user = userService.findByEmail(userEmail);
		submission.setUser(user);

		submissionService.add(submission);
		return getSubmissionItems();
	}

	private ModelAndView getSubmissionItems() {
		ModelAndView map = new ModelAndView("submission");
		map.addObject("submissionItems", submissionService.getAll());
//		Collections.sort(submissionService.getAll(), (a, b) -> a.getApplicant().getAllGrades().compareTo(b.getApplicant().getAllGrades()));
		return map;
	}

}
