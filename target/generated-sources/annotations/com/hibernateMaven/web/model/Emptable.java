/*
 * 프로젝트명(Project Name): JSP/Servlet - Hibernate 5.4 - MySQL 8
 * 작성일자(Create Date): 2020-09-21
 * 저자(Author): 도도(Dodo) / rabbit.white at daum dot net
 * 파일명(Filename): Emptable.java
 * 설명(Description):
 *  
 * 
 * 
 */

package com.hibernateMaven.web.model;

import java.sql.Date;

import javax.persistence.*;

@Entity
@Table(name = "emptable")
public class Emptable
{	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empno;
	@Column(name="name")
	private String name;
	@Column(name="address")
	private String address;
	@Column(name="createdate")
	private Date createdate;
	
	public int getEmpno() {
		return empno;
	}
	public void setEmpno(int empno) {
		this.empno = empno;
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
