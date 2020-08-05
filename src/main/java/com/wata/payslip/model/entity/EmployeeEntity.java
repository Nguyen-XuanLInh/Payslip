package com.wata.payslip.model.entity;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Employee")
public class EmployeeEntity {
	private Integer id;
	private String fullName;
	private String telephone;
	private String email;
	private Date birthday;
	private Date joinDay;

	public EmployeeEntity(Integer id, String fullName, String telephone, String email, Date birthday, Date joinDay) {
		this.id = id;
		this.fullName = fullName;
		this.telephone = telephone;
		this.email = email;
		this.birthday = birthday;
		this.joinDay = joinDay;
	}

	public EmployeeEntity() {
		
	}

//	@OneToMany(mappedBy = "employeeEntity")
//	private List<TimeLogEntity> timeLog = new ArrayList<>();

	@OneToMany(mappedBy = "employeeEntity")
	private List<AssigmentEntity> assigment = new ArrayList<>();
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "FullName", nullable = false)
	@Pattern(regexp = "[A-Za-z \\t\\n\\x0B\\f\\r\\p{L}]+")
	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	@Column(name = "Telephone", nullable = false)
	@Pattern(regexp = "[0-9]+")
	@Size(min = 10, max = 12)
	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	@Column(name = "Email", nullable = false, unique = true)
	@Email(regexp = ".+@.+\\..+")
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Column(name = "Birthday", nullable = false)
//    @DateTimeFormat(pattern = "yyyy-mm-dd")
//    @Past
	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "JoinDay", nullable = false)
	// @PastOrPresent
	public Date getJoinDay() {
		return joinDay;
	}

	public void setJoinDay(Date joinDay) {
		this.joinDay = joinDay;
	}

}
