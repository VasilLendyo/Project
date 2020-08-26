package ua.lviv.lgs.selectionCommittee.domain;

import java.util.Date;

public class Data {

	private Integer id;
	private Integer user_id;
	private Integer faculty_id;
	private Date date;
	private String status;
	
	public Data() {
		super();
	}

	public Data(Integer user_id, Integer faculty_id, Date date, String status) {
		super();
		this.user_id = user_id;
		this.faculty_id = faculty_id;
		this.date = date;
		this.status = status;
	}

	public Data(Integer id, Integer user_id, Integer faculty_id, Date date, String status) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.faculty_id = faculty_id;
		this.date = date;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_id() {
		return user_id;
	}

	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}

	public Integer getFaculty_id() {
		return faculty_id;
	}

	public void setFaculty_id(Integer faculty_id) {
		this.faculty_id = faculty_id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((faculty_id == null) ? 0 : faculty_id.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((status == null) ? 0 : status.hashCode());
		result = prime * result + ((user_id == null) ? 0 : user_id.hashCode());
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
		Data other = (Data) obj;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (faculty_id == null) {
			if (other.faculty_id != null)
				return false;
		} else if (!faculty_id.equals(other.faculty_id))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (status == null) {
			if (other.status != null)
				return false;
		} else if (!status.equals(other.status))
			return false;
		if (user_id == null) {
			if (other.user_id != null)
				return false;
		} else if (!user_id.equals(other.user_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Data [id=" + id + ", user_id=" + user_id + ", faculty_id=" + faculty_id + ", date=" + date + ", status="
				+ status + "]";
	}
}
