/*
 * 프로젝트명(Project Name): JSP/Servlet - Hibernate 5.4 - MySQL 8
 * 작성일자(Create Date): 2020-09-21
 * 저자(Author): 도도(Dodo) / rabbit.white at daum dot net
 * 파일명(Filename): IEmpTable.java
 * 설명(Description):
 *  
 * 
 * 
 */

package com.hibernateMaven.web.service;

import java.util.List;

import com.hibernateMaven.web.model.Emptable;

public interface IEmpTable {

	public List<Emptable> allList();									// Select * FROM empTable
	public Emptable getList(Integer num);						// Select * from emptable where empno = ?
	public void save(Emptable emptable);		// insert into emptable
	public int update(Emptable emptable);		// update emptable set cause where emp = ? 
	public int delete(Integer num);					// delete from emptable where empno = ?
	public Emptable searchName(Integer num, String name);		// 두 가지 조건 동시 만족 조회
	
}
