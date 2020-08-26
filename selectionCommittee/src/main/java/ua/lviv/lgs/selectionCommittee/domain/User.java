package ua.lviv.lgs.selectionCommittee.domain;

public class User {

	private Integer id;
	private String email;
	private String password;
	private String firstName;
	private String lastName;
	private Integer gradeMath;
	private Integer gradeHistory;
	private Integer gradeGeography;
	private String role;
	
	public User() {
	}

	public User(String email, String password, String firstName, String lastName, Integer gradeMath,
			Integer gradeHistory, Integer gradeGeography, String role) {
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeMath = gradeMath;
		this.gradeHistory = gradeHistory;
		this.gradeGeography = gradeGeography;
		this.role = role;
	}

	public User(Integer id, String email, String password, String firstName, String lastName, Integer gradeMath,
			Integer gradeHistory, Integer gradeGeography, String role) {
		super();
		this.id = id;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gradeMath = gradeMath;
		this.gradeHistory = gradeHistory;
		this.gradeGeography = gradeGeography;
		this.role = role;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getGradeMath() {
		return gradeMath;
	}

	public void setGradeMath(Integer gradeMath) {
		this.gradeMath = gradeMath;
	}

	public Integer getGradeHistory() {
		return gradeHistory;
	}

	public void setGradeHistory(Integer gradeHistory) {
		this.gradeHistory = gradeHistory;
	}

	public Integer getGradeGeography() {
		return gradeGeography;
	}

	public void setGradeGeography(Integer gradeGeography) {
		this.gradeGeography = gradeGeography;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result + ((gradeGeography == null) ? 0 : gradeGeography.hashCode());
		result = prime * result + ((gradeHistory == null) ? 0 : gradeHistory.hashCode());
		result = prime * result + ((gradeMath == null) ? 0 : gradeMath.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((role == null) ? 0 : role.hashCode());
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
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (gradeGeography == null) {
			if (other.gradeGeography != null)
				return false;
		} else if (!gradeGeography.equals(other.gradeGeography))
			return false;
		if (gradeHistory == null) {
			if (other.gradeHistory != null)
				return false;
		} else if (!gradeHistory.equals(other.gradeHistory))
			return false;
		if (gradeMath == null) {
			if (other.gradeMath != null)
				return false;
		} else if (!gradeMath.equals(other.gradeMath))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (role == null) {
			if (other.role != null)
				return false;
		} else if (!role.equals(other.role))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", gradeMath=" + gradeMath + ", gradeHistory=" + gradeHistory
				+ ", gradeGeography=" + gradeGeography + ", role=" + role + "]";
	}
}
