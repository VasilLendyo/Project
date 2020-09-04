package ua.lviv.lgs.selectionCommittee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "applicant")
public class Applicant {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column
	private String name;
	
	@Enumerated(EnumType.STRING)
	private FacultyName facultyName;
	
	@Column
	private Integer subject1;
	
	@Column
	private Integer subject2;
	
	@Column
	private Integer subject3;

	@Column(name = "all_grades")
	private Integer allGrades;
	
	@Lob
	private String encodedImage;
	
	public Applicant() {
		super();
	}

	public Applicant(String name, FacultyName facultyName, Integer subject1, Integer subject2, Integer subject3,
			Integer allGrades, String encodedImage) {
		super();
		this.name = name;
		this.facultyName = facultyName;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.allGrades = allGrades;
		this.encodedImage = encodedImage;
	}

	public Applicant(Integer id, String name, FacultyName facultyName, Integer subject1, Integer subject2,
			Integer subject3, Integer allGrades, String encodedImage) {
		super();
		this.id = id;
		this.name = name;
		this.facultyName = facultyName;
		this.subject1 = subject1;
		this.subject2 = subject2;
		this.subject3 = subject3;
		this.allGrades = allGrades;
		this.encodedImage = encodedImage;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public FacultyName getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(FacultyName facultyName) {
		this.facultyName = facultyName;
	}

	public Integer getSubject1() {
		return subject1;
	}

	public void setSubject1(Integer subject1) {
		this.subject1 = subject1;
	}

	public Integer getSubject2() {
		return subject2;
	}

	public void setSubject2(Integer subject2) {
		this.subject2 = subject2;
	}

	public Integer getSubject3() {
		return subject3;
	}

	public void setSubject3(Integer subject3) {
		this.subject3 = subject3;
	}

	public Integer getAllGrades() {
		return allGrades;
	}

	public void setAllGrades(Integer allGrades) {
		this.allGrades = allGrades;
	}

	public String getEncodedImage() {
		return encodedImage;
	}

	public void setEncodedImage(String encodedImage) {
		this.encodedImage = encodedImage;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((allGrades == null) ? 0 : allGrades.hashCode());
		result = prime * result + ((encodedImage == null) ? 0 : encodedImage.hashCode());
		result = prime * result + ((facultyName == null) ? 0 : facultyName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((subject1 == null) ? 0 : subject1.hashCode());
		result = prime * result + ((subject2 == null) ? 0 : subject2.hashCode());
		result = prime * result + ((subject3 == null) ? 0 : subject3.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Applicant other = (Applicant) obj;
		if (allGrades == null) {
			if (other.allGrades != null)
				return false;
		} else if (!allGrades.equals(other.allGrades))
			return false;
		if (encodedImage == null) {
			if (other.encodedImage != null)
				return false;
		} else if (!encodedImage.equals(other.encodedImage))
			return false;
		if (facultyName != other.facultyName)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (subject1 == null) {
			if (other.subject1 != null)
				return false;
		} else if (!subject1.equals(other.subject1))
			return false;
		if (subject2 == null) {
			if (other.subject2 != null)
				return false;
		} else if (!subject2.equals(other.subject2))
			return false;
		if (subject3 == null) {
			if (other.subject3 != null)
				return false;
		} else if (!subject3.equals(other.subject3))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", name=" + name + ", facultyName=" + facultyName + ", subject1=" + subject1
				+ ", subject2=" + subject2 + ", subject3=" + subject3 + ", allGrades=" + allGrades + ", encodedImage="
				+ encodedImage + "]";
	}
}
