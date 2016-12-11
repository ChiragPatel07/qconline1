package org.qcwala1.dfsproject.qcplatform.service;

import javax.persistence.EntityManager;

import org.qcwala1.dfsproject.qcplatform.userinfo.UserBean;

public class UserDAO {

	public UserBean get(String user_id) {
		EntityManager entityManager = null;
		UserBean userBean = null;
		try {
			entityManager = EntityManagerUtil.getEntityManager();
			userBean = entityManager.find(UserBean.class, user_id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userBean;
	}

	public void insert(UserBean userBean) {
		EntityManager entityManager = null;

		try {

			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(userBean);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(UserBean userBean) {
		EntityManager entityManager = null;

		try {
			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(userBean);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String user_id) {
		EntityManager entityManager = null;

		try {

			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			UserBean userBean = (UserBean) entityManager.find(UserBean.class, user_id);
			entityManager.remove(userBean);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
