/*
 * 프로젝트명(Project Name): JSP/Servlet - Hibernate 5.4 - MySQL 8
 * 작성일자(Create Date): 2020-09-21
 * 저자(Author): 도도(Dodo) / rabbit.white at daum dot net
 * 파일명(Filename): StudentService.java
 * 설명(Description):
 *  
 * 
 * 
 */

package com.hibernateMaven.web.service;

import java.util.List;

import org.hibernate.query.*;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.hibernateMaven.web.factory.HibernateUtil;
import com.hibernateMaven.web.model.Student;

public class StudentService implements IStudent {

	@Override
	public List<Student> allList() {
		return null;
	}

	@Override
	public Student getList(Integer num) {
		
		Student student;
		Transaction transaction = null;
		
        Session session= HibernateUtil.getSessionFactory().openSession();
         try
         {
 			 transaction = session.beginTransaction();
             student=(Student)session.get(Student.class,num); 
 			
             System.out.println("특정 조회:" + student.getName());
             transaction.commit();
             return student;
         }
         catch (Exception e) 
         {
        	 e.printStackTrace();
           	 return null;
         }
         finally 
         {
             session.close(); 
         }
         
         /*
		
		Student student = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			student = session.get(Student.class, num);
            
			System.out.println("특정 조회:" + student.getName());
			
			
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
		*/
	}

}
