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
	
	@Column(name = "average_grade")
	private Double averageGrade;

	@Lob
	private String encodedImage;
	
	public Applicant() {
		super();
	}

	public Applicant(String name, FacultyName facultyName, Double averageGrade) {
		super();
		this.name = name;
		this.facultyName = facultyName;
		this.averageGrade = averageGrade;
	}

	public Applicant(Integer id, String name, FacultyName facultyName, Double averageGrade) {
		super();
		this.id = id;
		this.name = name;
		this.facultyName = facultyName;
		this.averageGrade = averageGrade;
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

	public Double getAverageGrade() {
		return averageGrade;
	}

	public void setAverageGrade(Double averageGrade) {
		this.averageGrade = averageGrade;
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
		result = prime * result + ((averageGrade == null) ? 0 : averageGrade.hashCode());
		result = prime * result + ((facultyName == null) ? 0 : facultyName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		if (averageGrade == null) {
			if (other.averageGrade != null)
				return false;
		} else if (!averageGrade.equals(other.averageGrade))
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
		return true;
	}

	@Override
	public String toString() {
		return "Applicant [id=" + id + ", name=" + name + ", facultyName=" + facultyName + ", averageGrade="
				+ averageGrade + "]";
	}
}
