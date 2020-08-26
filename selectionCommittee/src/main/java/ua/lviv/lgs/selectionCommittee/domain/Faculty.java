package ua.lviv.lgs.selectionCommittee.domain;

public class Faculty {

	private Integer id;
	private String name;
	private Integer numberOfPeople;
	private Integer acceptableAssessment;
	
	public Faculty() {
	}

	public Faculty(String name, Integer numberOfPeople, Integer acceptableAssessment) {
		super();
		this.name = name;
		this.numberOfPeople = numberOfPeople;
		this.acceptableAssessment = acceptableAssessment;
	}

	public Faculty(Integer id, String name, Integer numberOfPeople, Integer acceptableAssessment) {
		super();
		this.id = id;
		this.name = name;
		this.numberOfPeople = numberOfPeople;
		this.acceptableAssessment = acceptableAssessment;
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

	public Integer getNumberOfPeople() {
		return numberOfPeople;
	}

	public void setNumberOfPeople(Integer numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}

	public Integer getAcceptableAssessment() {
		return acceptableAssessment;
	}

	public void setAcceptableAssessment(Integer acceptableAssessment) {
		this.acceptableAssessment = acceptableAssessment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((acceptableAssessment == null) ? 0 : acceptableAssessment.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((numberOfPeople == null) ? 0 : numberOfPeople.hashCode());
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
		if (acceptableAssessment == null) {
			if (other.acceptableAssessment != null)
				return false;
		} else if (!acceptableAssessment.equals(other.acceptableAssessment))
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
		if (numberOfPeople == null) {
			if (other.numberOfPeople != null)
				return false;
		} else if (!numberOfPeople.equals(other.numberOfPeople))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faculty [id=" + id + ", name=" + name + ", numberOfPeople=" + numberOfPeople + ", acceptableAssessment="
				+ acceptableAssessment + "]";
	}
}
