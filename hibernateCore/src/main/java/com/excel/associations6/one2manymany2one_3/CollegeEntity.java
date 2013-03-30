package com.excel.associations6.one2manymany2one_3;

 
import java.io.Serializable;

public class CollegeEntity implements Serializable {
	private Long collegecode;
	private String cname;
	java.util.Set students;
	public CollegeEntity(){}

	public Long getCollegecode() {
		return collegecode;
	}

	public void setCollegecode(Long collegecode) {
		this.collegecode = collegecode;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public java.util.Set getStudents() {
		return students;
	}

	public void setStudents(java.util.Set students) {
		this.students = students;
	}
	
	
}
