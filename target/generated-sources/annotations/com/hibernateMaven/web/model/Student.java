/*
 * 프로젝트명(Project Name): JSP/Servlet - Hibernate 5.4 - MySQL 8
 * 작성일자(Create Date): 2020-09-21
 * 저자(Author): 도도(Dodo) / rabbit.white at daum dot net
 * 파일명(Filename): Student.java
 * 설명(Description):
 *  
 * 
 * 
 */

package com.hibernateMaven.web.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentno;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="createdate")
	private Date createdate;
	
	public int getStudentno() {
		return studentno;
	}
	public void setStudentno(int studentno) {
		this.studentno = studentno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	
}
