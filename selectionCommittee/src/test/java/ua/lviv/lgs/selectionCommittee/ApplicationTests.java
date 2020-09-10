package ua.lviv.lgs.selectionCommittee;


import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import ua.lviv.lgs.selectionCommittee.dao.ApplicantRepository;
import ua.lviv.lgs.selectionCommittee.dao.SubmissionRepository;
import ua.lviv.lgs.selectionCommittee.dao.UserRepository;
import ua.lviv.lgs.selectionCommittee.domain.Applicant;
import ua.lviv.lgs.selectionCommittee.domain.FacultyName;
import ua.lviv.lgs.selectionCommittee.domain.Submission;
import ua.lviv.lgs.selectionCommittee.domain.User;
import ua.lviv.lgs.selectionCommittee.domain.UserRole;
import ua.lviv.lgs.selectionCommittee.service.ApplicantService;
import ua.lviv.lgs.selectionCommittee.service.SubmissionService;
import ua.lviv.lgs.selectionCommittee.service.UserService;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ApplicationTests {

	@Autowired
	private UserService userService;
	
	@Autowired
	private ApplicantService applicantService;
	
	@Autowired
	private SubmissionService submissionService;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ApplicantRepository applicantRepository;
	
	@Autowired
	private SubmissionRepository submissionRepository;
	
	@Test
	public void testSaveUser() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));
		
		User user = new User();
		user.setEmail("1@gmail.com");
		user.setFirstName("1");
		user.setLastName("1");
		user.setPassword("1");
		user.setPasswordConfirm("1");
		user.setRole(UserRole.ROLE_USER);
		
		userService.save(user);
		
		users = userRepository.findAll();
		assertThat(users, hasSize(1));
	}
	
	@Test
	public void testFindUserByEmail() {
		List<User> users = userRepository.findAll();
		assertThat(users, hasSize(0));

		User user = new User();
		user.setEmail("myCustomEmail@gmail.com");
		user.setFirstName("2");
		user.setLastName("2");
		user.setPassword("2");
		user.setPasswordConfirm("2");
		user.setRole(UserRole.ROLE_USER);

		userRepository.save(user);

		users = userRepository.findAll();
		assertThat(users, hasSize(1));

		User findByEmail = userService.findByEmail(user.getEmail());

		assertTrue(findByEmail.getEmail().equals(user.getEmail()));
		assertTrue(findByEmail.getFirstName().equals(user.getFirstName()));
		assertTrue(findByEmail.getLastName().equals(user.getLastName()));
		assertTrue(findByEmail.getRole().equals(user.getRole()));
	}
	
	@Test
	public void testSaveApplicant() {
		List<Applicant> applicants = applicantRepository.findAll();
		assertThat(applicants, hasSize(0));
		
		Applicant applicant = new Applicant();
		applicant.setName("1");
		applicant.setFacultyName(FacultyName.ECONOMIC);
		applicant.setAllGrades(1);
		applicant.setEncodedImage("1");
		
		applicantService.save(applicant);
		
		applicants = applicantRepository.findAll();
		assertThat(applicants, hasSize(1));
		
		Applicant applicantFromDB = applicants.get(0);
		assertTrue(applicantFromDB.getName().equals(applicant.getName()));
		assertTrue(applicantFromDB.getFacultyName().equals(applicant.getFacultyName()));
		assertTrue(applicantFromDB.getAllGrades().equals(applicant.getAllGrades()));
		assertTrue(applicantFromDB.getEncodedImage().equals(applicant.getEncodedImage()));
	}
	
	@Test
	public void testFindApplicantByID() {
		List<Applicant> applicants = applicantRepository.findAll();
		assertThat(applicants, hasSize(0));
		
		Applicant applicant = new Applicant();
		applicant.setName("1");
		applicant.setFacultyName(FacultyName.ECONOMIC);
		applicant.setAllGrades(1);
		applicant.setEncodedImage("1");
		
		applicantService.save(applicant);
		
		applicants = applicantRepository.findAll();
		assertThat(applicants, hasSize(1));
		
		Applicant applicantFromDB = applicantService.findById(applicants.get(0).getId());
		assertTrue(applicantFromDB.getName().equals(applicant.getName()));
		assertTrue(applicantFromDB.getFacultyName().equals(applicant.getFacultyName()));
		assertTrue(applicantFromDB.getAllGrades().equals(applicant.getAllGrades()));
		assertTrue(applicantFromDB.getEncodedImage().equals(applicant.getEncodedImage()));
	}
	
	@Test
	public void testGetAllApplicants() {
		List<Applicant> applicants = applicantRepository.findAll();
		assertThat(applicants, hasSize(0));
		
		Applicant applicant = new Applicant();
		applicant.setName("1");
		applicant.setFacultyName(FacultyName.ECONOMIC);
		applicant.setAllGrades(1);
		applicant.setEncodedImage("1");
		
		Applicant applicant2 = new Applicant();
		applicant2.setName("2");
		applicant2.setFacultyName(FacultyName.ENGINEERING);
		applicant2.setAllGrades(2);
		applicant2.setEncodedImage("2");
		
		applicantRepository.saveAll(Arrays.asList(applicant, applicant2));
		
		applicants = applicantRepository.findAll();
		assertThat(applicants, hasSize(2));
		
		List<Applicant> applicantFromDB = applicantService.getAllApplicants();
		
		assertTrue(applicantFromDB.get(0).getName().equals(applicant.getName()));
		assertTrue(applicantFromDB.get(0).getFacultyName().equals(applicant.getFacultyName()));
		assertTrue(applicantFromDB.get(0).getAllGrades().equals(applicant.getAllGrades()));
		assertTrue(applicantFromDB.get(0).getEncodedImage().equals(applicant.getEncodedImage()));
		
		assertTrue(applicantFromDB.get(1).getName().equals(applicant2.getName()));
		assertTrue(applicantFromDB.get(1).getFacultyName().equals(applicant2.getFacultyName()));
		assertTrue(applicantFromDB.get(1).getAllGrades().equals(applicant2.getAllGrades()));
		assertTrue(applicantFromDB.get(1).getEncodedImage().equals(applicant2.getEncodedImage()));
	}

	@Test
	public void testAddToSubmission() {
		User user = new User();
		user.setEmail("myCustomEmail@gmail.com");
		user.setFirstName("2");
		user.setLastName("2");
		user.setPassword("2");
		user.setPasswordConfirm("2");
		user.setRole(UserRole.ROLE_USER);

		userRepository.save(user);
		
		User userFromDB = userRepository.findAll().stream().findFirst().get();
		
		List<Applicant> applicants = applicantRepository.findAll();
		assertThat(applicants, hasSize(0));
		
		Applicant applicant = new Applicant();
		applicant.setName("1");
		applicant.setFacultyName(FacultyName.ECONOMIC);
		applicant.setAllGrades(1);
		applicant.setEncodedImage("1");
		
		applicantService.save(applicant);
		
		Applicant applicantFromDB = applicantRepository.findAll().stream().findFirst().get();
		
		Date now = new Date();
		Submission submission = new Submission();
		submission.setUser(userFromDB);
		submission.setApplicant(applicantFromDB);
		submission.setDate(now);
		
		List<Submission> submissions = submissionRepository.findAll();
		assertThat(submissions, hasSize(0));
		
		submissionService.add(submission);
		
		submissions = submissionRepository.findAll();
		assertThat(submissions, hasSize(1));
		
		Submission submissionFromDB = submissions.get(0);
		assertTrue(submissionFromDB.getUser().equals(userFromDB));
		assertTrue(submissionFromDB.getApplicant().equals(applicantFromDB));
		assertTrue(submissionFromDB.getDate().equals(now));
	}
	
	@Test
	public void testGetAll() {
		User user = new User();
		user.setEmail("myCustomEmail@gmail.com");
		user.setFirstName("2");
		user.setLastName("2");
		user.setPassword("2");
		user.setPasswordConfirm("2");
		user.setRole(UserRole.ROLE_USER);

		userRepository.save(user);
		
		User userFromDB = userRepository.findAll().stream().findFirst().get();
		
		List<Applicant> applicants = applicantRepository.findAll();
		assertThat(applicants, hasSize(0));
		
		Applicant applicant = new Applicant();
		applicant.setName("1");
		applicant.setFacultyName(FacultyName.ECONOMIC);
		applicant.setAllGrades(1);
		applicant.setEncodedImage("1");
		
		Applicant applicant2 = new Applicant();
		applicant2.setName("2");
		applicant2.setFacultyName(FacultyName.ENGINEERING);
		applicant2.setAllGrades(2);
		applicant2.setEncodedImage("2");
		
		applicantRepository.saveAll(Arrays.asList(applicant, applicant2));
		
		List<Applicant> applicantFromDB = applicantRepository.findAll();
		
		Date now = new Date();
		Submission submission = new Submission();
		submission.setUser(userFromDB);
		submission.setApplicant(applicantFromDB.get(0));
		submission.setDate(now);
		
		Submission submission2 = new Submission();
		submission2.setUser(userFromDB);
		submission2.setApplicant(applicantFromDB.get(1));
		submission2.setDate(now);
		
		List<Submission> submissions = submissionRepository.findAll();
		assertThat(submissions, hasSize(0));
		
		submissionRepository.saveAll(Arrays.asList(submission, submission2));
		
		List<Submission> submissionFromDB = submissionService.getAll();
		assertThat(submissionFromDB, hasSize(2));
	}
}