package com.example.demo.web.dto;

public class PrescriptionDto {
	private String doctorname;

	private Long patientid;
	
	private String medicine;
	
	private String dosage;
	
	private String diagnosis;
	
	private String additional;

	public String getDoctorname() {
		return doctorname;
	}

	public void setDoctorname(String doctorname) {
		this.doctorname = doctorname;
	}

	public Long getPatientid() {
		return patientid;
	}

	public void setPatientid(Long patientid) {
		this.patientid = patientid;
	}

	public String getMedicine() {
		return medicine;
	}

	public void setMedicine(String medicine) {
		this.medicine = medicine;
	}

	public String getDosage() {
		return dosage;
	}

	public void setDosage(String dosage) {
		this.dosage = dosage;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public String getAdditional() {
		return additional;
	}

	public void setAdditional(String additional) {
		this.additional = additional;
	}

	public PrescriptionDto(String doctorname, Long patientid, String medicine, String dosage, String diagnosis,
			String additional) {
		super();
		this.doctorname = doctorname;
		this.patientid = patientid;
		this.medicine = medicine;
		this.dosage = dosage;
		this.diagnosis = diagnosis;
		this.additional = additional;
	}

	public PrescriptionDto() {
		// TODO Auto-generated constructor stub
	}
	
	
}
