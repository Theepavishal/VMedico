package com.example.demo.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name =  "Prescription", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Prescription {
	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "doctorname")
	private String doctorname;
	
	@Column(name = "patientid")
	private Long patientid;
	
	private String medicine;
	
	private String dosage;
	
	private String diagnosis;
	
	private String additional;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public Prescription(String doctorname, Long patientid, String medicine, String dosage, String diagnosis,
			String additional) {
		super();
		this.doctorname = doctorname;
		this.patientid = patientid;
		this.medicine = medicine;
		this.dosage = dosage;
		this.diagnosis = diagnosis;
		this.additional = additional;
	}
	
	

}
