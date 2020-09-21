/*
 * 프로젝트명(Project Name): JSP/Servlet - Hibernate 5.4 - MySQL 8
 * 작성일자(Create Date): 2020-09-21
 * 저자(Author): 도도(Dodo) / rabbit.white at daum dot net
 * 파일명(Filename): StudentServlet.java
 * 설명(Description):
 *  
 * 
 * 
 */
package com.hibernateMaven.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hibernateMaven.web.model.Student;
import com.hibernateMaven.web.service.StudentService;


public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public StudentServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		res.setContentType("text/html;charset=UTF-8");
		PrintWriter out = res.getWriter();
		
		// HTML 스타일 정의
		out.println("<html><head><title>Hibernate Maven - MySQL 8 실험(Table:Student)</title></head><body>");
		
		StudentService service2 = new StudentService();

		// 1. 전체 조회
		//List<Student> student1 = service.allList();
		service2.getList(1);
		
		out.println("</body></html>");
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
