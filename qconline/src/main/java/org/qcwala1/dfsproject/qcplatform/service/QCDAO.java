package org.qcwala1.dfsproject.qcplatform.service;

import javax.persistence.EntityManager;

import org.qcwala1.dfsproject.qcplatform.qcinfo.QC;

public class QCDAO {

	public QC get(String qcid) {
		EntityManager entityManager = null;
		QC qc = null;
		try {
			entityManager = EntityManagerUtil.getEntityManager();
			qc = entityManager.find(QC.class, qcid);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return qc;
	}

	public void insert(QC qc) {
		EntityManager entityManager = null;

		try {

			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.persist(qc);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(QC qc) {
		EntityManager entityManager = null;
		System.out.println("In DAO: " + qc.getFss().get(0).getP_eta());
		try {
			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			entityManager.merge(qc);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String qc_id) {
		EntityManager entityManager = null;

		try {

			entityManager = EntityManagerUtil.getEntityManager();
			entityManager.getTransaction().begin();
			QC qc = (QC) entityManager.find(QC.class, qc_id);
			qc.getFss().forEach((k) -> {
				k.setDeveloper(null);
				k.setTester(null);
			});
			entityManager.remove(qc);
			entityManager.getTransaction().commit();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
