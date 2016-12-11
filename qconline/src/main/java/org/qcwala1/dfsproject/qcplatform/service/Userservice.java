package org.qcwala1.dfsproject.qcplatform.service;

import org.qcwala1.dfsproject.qcplatform.userinfo.UserBean;

public class Userservice {
	//private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("QCportalPU");
	//private static EntityManager em = emf.createEntityManager();
//	private static CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

	//private static CriteriaQuery<UserBean> criteriaQuery = criteriaBuilder.createQuery(UserBean.class);
//	private static Root<UserBean> c = criteriaQuery.from(UserBean.class);

	public static UserBean createUserBean(String username) {
		UserBean currentUser = null;
		// get User from DB code here if exist else throw as null
		// currentUser =
		// em.createQuery(criteriaQuery.select(c)).getSingleResult();
		UserDAO userDAO = new UserDAO();
		currentUser = userDAO.get(username);
		if (currentUser == null) {
			return null;
		} else {
			return currentUser;
		}
	}

	public void updateUser(UserBean modifiedUser) {
		UserDAO UserDAO = new UserDAO();
		UserDAO.update(modifiedUser);
	}

	public void addUser(UserBean user) {
		UserDAO UserDAO = new UserDAO();
		UserDAO.insert(user);
	}

	public UserBean getUser(String user_id) {
		UserDAO UserDAO = new UserDAO();
		UserBean retqc = UserDAO.get(user_id);
		return retqc;
	}

	public void deleteUser(String user_id) {
		UserDAO UserDAO = new UserDAO();
		UserDAO.delete(user_id);
	}

}
