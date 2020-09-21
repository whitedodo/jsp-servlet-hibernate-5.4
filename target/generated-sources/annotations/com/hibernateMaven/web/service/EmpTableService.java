/*
 * 프로젝트명(Project Name): JSP/Servlet - Hibernate 5.4 - MySQL 8
 * 작성일자(Create Date): 2020-09-21
 * 저자(Author): 도도(Dodo) / rabbit.white at daum dot net
 * 파일명(Filename): EmpTableService.java
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
import com.hibernateMaven.web.model.Emptable;

public class EmpTableService implements IEmpTable {

	@Override
	public List<Emptable> allList() {

		Transaction transaction = null;
		List<Emptable> list = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// get an user object
			
			list = session.createQuery("from Emptable").getResultList();
		
			System.out.println("연습:" + list.get(0).getName());
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
        return list;
	}

	@Override
	public Emptable getList(Integer num) {
		
		Transaction transaction = null;
		Emptable emptable = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			transaction = session.beginTransaction();
			emptable = session.get(Emptable.class, num);
            
			System.out.println("특정 조회:" + emptable.getName());
			
			transaction.commit();

			return emptable;
			
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
            
            return null;
        }
		
	}

	

	@Override
	public void save(Emptable emptable) {
		
		Transaction transaction = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			session.save(emptable);
			// commit transaction
			transaction.commit();
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
	}

	@Override
	public int update(Emptable emptable) {

		Transaction transaction = null;
		String hql = null;
		int result = -1;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			
			hql = "UPDATE Emptable set name = :name, "  +
					 "address = :address, createdate = :createdate " +
		             "WHERE empno = :empno";
			
			Query query = session.createQuery(hql);
			query.setParameter("name", emptable.getName());
			query.setParameter("address", emptable.getAddress());
			query.setParameter("createdate", emptable.getCreatedate());
			query.setParameter("empno", emptable.getEmpno());
			result = query.executeUpdate();

			System.out.println("수정결과:" + result);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	public int delete(Integer num) {
		
		Transaction transaction = null;
		String hql = null;
		int result = -1;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			
			hql = "Delete from Emptable " +
		             "WHERE empno = :empno";
			
			Query query = session.createQuery(hql);
			query.setParameter("empno",  num);
			result = query.executeUpdate();

			System.out.println("삭제결과:" + result);
			
			// commit transaction
			transaction.commit();
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
		}
		
		return result;
		
	}

	@Override
	public Emptable searchName(Integer num, String name) {

		Transaction transaction = null;
		String hql = null;
		Emptable emp = null;
		
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			// start a transaction
			transaction = session.beginTransaction();
			// save the student object
			
			hql = "from Emptable " +
		             "WHERE empno = :empno and name = :name";
			
			Query query = session.createQuery(hql);
			query.setParameter("empno", num);
			query.setParameter("name",  name);
			
			emp = (Emptable) query.list().get(0);

			System.out.println("번호, 이름 검색");
			
			// commit transaction
			transaction.commit();
			return emp;
			
		} catch (Exception e) {
			if (transaction != null) {
				transaction.rollback();
			}
			e.printStackTrace();
			return null;
		}
		
	}

}
