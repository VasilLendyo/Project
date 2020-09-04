package ua.lviv.lgs.selectionCommittee.service;

import java.io.IOException;
import java.util.Base64;

import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.selectionCommittee.domain.Applicant;
import ua.lviv.lgs.selectionCommittee.domain.FacultyName;

public class ApplicantDtoHelper {

	public static Applicant createEntity(MultipartFile file, String name, FacultyName facultyName, Integer subject1, Integer subject2, Integer subject3) throws IOException {
		Applicant applicant = new Applicant();
		applicant.setName(name);
		applicant.setFacultyName(facultyName);
		applicant.setSubject1(subject1);
		applicant.setSubject2(subject2);
		applicant.setSubject3(subject3);
		applicant.setAllGrades(subject1 + subject2 + subject3);

		applicant.setEncodedImage(Base64.getEncoder().encodeToString(file.getBytes()));
		
		return applicant;
	}
}
