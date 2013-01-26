package com.excel.associations6.one2many2;

import java.io.Serializable;

public class StudentEntity implements Serializable {

	private Long sid;
	private String sname;
	
	public StudentEntity(){}

	public Long getSid() {
		return sid;
	}

	public void setSid(Long sid) {
		this.sid = sid;
	}

	public String getSname() {
		return sname;
	}

	public void setSname(String sname) {
		this.sname = sname;
	}
	
}
