package ua.lviv.lgs.selectionCommittee.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import ua.lviv.lgs.selectionCommittee.domain.FacultyName;
import ua.lviv.lgs.selectionCommittee.service.ApplicantDtoHelper;
import ua.lviv.lgs.selectionCommittee.service.ApplicantService;

@Controller
public class ApplicantsController {

	@Autowired
	ApplicantService applicantService;
	
	@RequestMapping(value = "/addApplicant", method = RequestMethod.POST)
	public ModelAndView registerApplicant(@RequestParam MultipartFile image, 
			@RequestParam String name, 
			@RequestParam FacultyName facultyName, 
			@RequestParam Integer subject1,
			@RequestParam Integer subject2,
			@RequestParam Integer subject3) throws IOException {
		applicantService.save(ApplicantDtoHelper.createEntity(image, name, facultyName, subject1, subject2, subject3));
		
		return new ModelAndView("redirect:/home");
	}
	
    @RequestMapping(value ="/home", method = RequestMethod.GET)
    public ModelAndView home() {
    	ModelAndView map = new ModelAndView("home");
    	map.addObject("applicants",applicantService.getAllApplicants());
        return map;
    }
    
    @RequestMapping(value ="/register-applicant", method = RequestMethod.GET)
    public String registerApplicant() {
        return "registerApplicant";
    }
}
