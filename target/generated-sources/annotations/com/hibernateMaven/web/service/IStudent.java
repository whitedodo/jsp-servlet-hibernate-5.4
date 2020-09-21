/*
 * 프로젝트명(Project Name): JSP/Servlet - Hibernate 5.4 - MySQL 8
 * 작성일자(Create Date): 2020-09-21
 * 저자(Author): 도도(Dodo) / rabbit.white at daum dot net
 * 파일명(Filename): IStudent.java
 * 설명(Description):
 *  
 * 
 * 
 */

package com.hibernateMaven.web.service;

import java.util.List;

import com.hibernateMaven.web.model.Student;

public interface IStudent {

	public List<Student> allList();				// Select * FROM student
	public Student getList(Integer num);						// Select * from student where studentno = ?
}
