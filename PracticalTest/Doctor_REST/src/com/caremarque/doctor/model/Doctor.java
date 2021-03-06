package com.caremarque.doctor.model;

//Example..
public class Doctor

{

	private String doctorId;
	private String firstName;
	private String lastName;
	private String regNo;
	private String gender;
	private String specialization;
	private String phone;
	private String email;
	private double doctorCharges;
	private String password;
	private String confirmPassword;
	private String type;

	public Doctor() {
		// TODO Auto-generated constructor stub
		super();
	}

	public String getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(String doctorId) {
		this.doctorId = doctorId;
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

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getDoctorCharges() {
		return doctorCharges;
	}

	public void setDoctorCharges(double doctorCharges) {
		this.doctorCharges = doctorCharges;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Doctor(String doctorId, String firstName, String lastName, String regNo, String gender,
			String specialization, String phone, String email, int doctorCharges, String password,
			String confirmPassword, String type) {

		super();
		this.doctorId = doctorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.regNo = regNo;
		this.gender = gender;
		this.specialization = specialization;
		this.phone = phone;
		this.email = email;
		this.doctorCharges = doctorCharges;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.type = type;
	}

}
