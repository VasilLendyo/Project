package ua.lviv.lgs.selectionCommittee.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.selectionCommittee.domain.Applicant;
import ua.lviv.lgs.selectionCommittee.domain.FacultyName;

public class ApplicantDtoHelper {

	public static Applicant createEntity(MultipartFile file, String name, FacultyName facultyName, Double averageGrade) throws IOException {
		Applicant applicant = new Applicant();
		applicant.setName(name);
		applicant.setFacultyName(facultyName);
		applicant.setAverageGrade(averageGrade);
		applicant.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		
		return applicant;
	}
}
