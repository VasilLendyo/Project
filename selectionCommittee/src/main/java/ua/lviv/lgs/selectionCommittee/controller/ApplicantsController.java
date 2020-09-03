package ua.lviv.lgs.selectionCommittee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.selectionCommittee.domain.Applicant;
import ua.lviv.lgs.selectionCommittee.service.ApplicantService;

@Controller
public class ApplicantsController {

	@Autowired
	ApplicantService applicantService;
	
	@RequestMapping(value = "/addApplicant", method = RequestMethod.POST)
	public ModelAndView registerApplicant(@Validated @ModelAttribute("applicant") Applicant applicant, BindingResult bindingResult) {
		applicantService.save(applicant);
		return new ModelAndView("redirect:/home");
	}
	
    @RequestMapping(value ="/home", method = RequestMethod.GET)
    public ModelAndView home() {
    	ModelAndView map = new ModelAndView("home");
    	map.addObject("applicants",applicantService.getAllApplicants());
        return map;
    }
    
    @RequestMapping(value ="/register-applicant", method = RequestMethod.GET)
    public ModelAndView registerApplicant() {
        return new ModelAndView("registerApplicant", "applicant", new Applicant());
    }
}
