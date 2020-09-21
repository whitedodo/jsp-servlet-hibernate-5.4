/*
 * 프로젝트명(Project Name): JSP/Servlet - Hibernate 5.4 - MySQL 8
 * 작성일자(Create Date): 2020-09-21
 * 저자(Author): 도도(Dodo) / rabbit.white at daum dot net
 * 파일명(Filename): SampleServlet.java
 * 설명(Description):
 *  
 * 
 * 
 */
package com.hibernateMaven.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernateMaven.web.model.Emptable;
import com.hibernateMaven.web.service.EmpTableService;
import com.hibernateMaven.web.service.StudentService;

public class SampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public SampleServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		// HTML 스타일 정의
		out.println("<html><head><title>Hibernate Maven - MySQL 8 실험</title></head><body>");
		
		EmpTableService service = new EmpTableService();

		// 1. 전체 조회
		List<Emptable> emp1 = service.allList();

		// 2. 특정 ID 조회
		Emptable emp2 = service.getList(1);
	
		// 3. 삽입 구현
		Emptable createEmp = new Emptable();
	
		createEmp.setName("홍길동");
		createEmp.setAddress("행복구 행복시");
		java.sql.Date sqlDate = java.sql.Date.valueOf("2020-05-20");
		createEmp.setCreatedate(sqlDate);
		
		service.save(createEmp);
		
		// 4. 수정
		Emptable updateEmp = new Emptable();
		
		updateEmp.setName("동길홍");
		updateEmp.setAddress("시복행 구복행");
		sqlDate = java.sql.Date.valueOf("1990-09-01");
		updateEmp.setCreatedate(sqlDate);
		updateEmp.setEmpno(3);
		
		service.update(updateEmp);
		
		// 5. 삭제
		service.delete(4);
		
		// 6. 특정 이름, 번호 조회
		Emptable query1 = service.searchName(18, "홍길동");
		out.println("주소:" + query1.getAddress() + "<br/>" );
		
		out.println("</body></html>");
		out.close();
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
	}

}
