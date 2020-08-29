package ua.lviv.lgs.selectionCommittee.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "faculty")
public class Faculty {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "faculty_name")
	private FacultyName facultyName;
	
	@Column(name = "numbers_of_students")
	private Integer numberOfStudents;
	
	@Column(name = "acceptable_points")
	private Integer acceptablePoints;
	
	public Faculty() {
	}

	public Faculty(FacultyName facultyName, Integer numberOfStudents, Integer acceptablePoints) {
		super();
		this.facultyName = facultyName;
		this.numberOfStudents = numberOfStudents;
		this.acceptablePoints = acceptablePoints;
	}

	public Faculty(Integer id, FacultyName facultyName, Integer numberOfStudents, Integer acceptablePoints) {
		super();
		this.id = id;
		this.facultyName = facultyName;
		this.numberOfStudents = numberOfStudents;
		this.acceptablePoints = acceptablePoints;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public FacultyName getFacultyName() {
		return facultyName;
	}

	public void setFacultyName(FacultyName facultyName) {
		this.facultyName = facultyName;
	}

	public Integer getNumberOfStudents() {
		return numberOfStudents;
	}

	public void setNumberOfStudents(Integer numberOfStudents) {
		this.numberOfStudents = numberOfStudents;
	}

	public Integer getAcceptablePoints() {
		return acceptablePoints;
	}

	public void setAcceptablePoints(Integer acceptablePoints) {
		this.acceptablePoints = acceptablePoints;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acceptablePoints == null) ? 0 : acceptablePoints.hashCode());
		result = prime * result + ((facultyName == null) ? 0 : facultyName.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((numberOfStudents == null) ? 0 : numberOfStudents.hashCode());
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
		Faculty other = (Faculty) obj;
		if (acceptablePoints == null) {
			if (other.acceptablePoints != null)
				return false;
		} else if (!acceptablePoints.equals(other.acceptablePoints))
			return false;
		if (facultyName != other.facultyName)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (numberOfStudents == null) {
			if (other.numberOfStudents != null)
				return false;
		} else if (!numberOfStudents.equals(other.numberOfStudents))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", facultyName=" + facultyName + ", numberOfStudents=" + numberOfStudents
				+ ", acceptablePoints=" + acceptablePoints + "]";
	}
}
