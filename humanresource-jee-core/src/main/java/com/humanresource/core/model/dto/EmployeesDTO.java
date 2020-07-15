package com.humanresource.core.model.dto;

public class EmployeesDTO {
	
	private Long id;
	private String name;
	private String email;
	private String password;
	private String image;
	private DepartamentDTO departament;
	private JobDTO job;
	private String profiles;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public DepartamentDTO getDepartament() {
		return departament;
	}

	public void setDepartament(DepartamentDTO departament) {
		this.departament = departament;
	}

	public JobDTO getJob() {
		return job;
	}

	public void setJob(JobDTO job) {
		this.job = job;
	}

	public String getProfiles() {
		return profiles;
	}

	public void setProfiles(String profiles) {
		this.profiles = profiles;
	}

}
