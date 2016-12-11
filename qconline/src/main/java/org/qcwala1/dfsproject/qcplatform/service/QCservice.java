package org.qcwala1.dfsproject.qcplatform.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.qcwala1.dfsproject.qcplatform.qcinfo.FS;
import org.qcwala1.dfsproject.qcplatform.qcinfo.FS_;
import org.qcwala1.dfsproject.qcplatform.qcinfo.Module_ID;
import org.qcwala1.dfsproject.qcplatform.qcinfo.QC;
import org.qcwala1.dfsproject.qcplatform.qcinfo.QCFilter;
import org.qcwala1.dfsproject.qcplatform.qcinfo.QC_;
import org.qcwala1.dfsproject.qcplatform.qcinfo.Severity;
import org.qcwala1.dfsproject.qcplatform.qcinfo.Status;
import org.qcwala1.dfsproject.qcplatform.userinfo.Track;
import org.qcwala1.dfsproject.qcplatform.userinfo.UserBean;

public class QCservice {
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("QCportalPU");
	private static EntityManager em = emf.createEntityManager();
	private static CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();
	private static CriteriaQuery<QC> criteriaQuery = criteriaBuilder.createQuery(QC.class);
	private static Root<QC> c = criteriaQuery.from(QC.class);
	private static Join<QC, FS> join = c.join("fss");

	public static List<QC> populateQCdetailsFromDbToApp(Map<QCFilter, Object> filters) {

		TypedQuery<QC> typedQuery = prepareQuery(filters);
		List<QC> qcss = typedQuery.getResultList();
		List<QC> qcs = qcss.parallelStream().distinct().collect(Collectors.toList());

		if (qcs != null) {
			return qcs;
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public static TypedQuery<QC> prepareQuery(Map<QCFilter, Object> filters) {

		List<Predicate> predicates = new ArrayList<>();
		filters.forEach((k, v) -> {
			System.out.println("In service :filter name :" + k + " Value : " + v);
			switch (k) {
			case ID:
				// ParameterExpression<String> qcid =
				// criteriaBuilder.parameter(String.class);
				predicates.add(criteriaBuilder.equal(c.get(QC_.id), v.toString()));
				break;

			case FS_ID:
				// ParameterExpression<Integer> fsid =
				// criteriaBuilder.parameter(Integer.class);
				predicates.add(criteriaBuilder.equal(join.get(FS_.fs_id), v.toString()));

				break;
			case CURRENT_STATUS:
				predicates.add(criteriaBuilder.equal(join.get(FS_.current_status_fs), Status.valueOf(v.toString())));
				break;
			case DESCRIPTION:
				predicates.add(criteriaBuilder.like(criteriaBuilder.lower(c.get(QC_.description)),
						"%" + v.toString().toLowerCase() + "%"));
			case DEVELOPER:
				UserBean qDeveloper = new UserBean();
				qDeveloper.setUser_name(v.toString());
				predicates.add(criteriaBuilder.equal(join.get(FS_.developer), qDeveloper));
				break;
			case TESTER:
				UserBean qTester = new UserBean();
				qTester.setUser_name(v.toString());

				predicates.add(criteriaBuilder.equal(join.get(FS_.tester), qTester));
				break;
			case SEVERITY:
				predicates.add(criteriaBuilder.equal(c.get(QC_.severity), Severity.valueOf(v.toString())));
				break;
			case MODULE_ID:
				predicates.add(criteriaBuilder.equal(c.get(QC_.module_ID), Module_ID.valueOf(v.toString())));
				break;
			case QCTRACK:
				predicates.add(criteriaBuilder.equal(join.get(FS_.QCtrack), Track.valueOf(v.toString())));
				break;
			case READYTOTEST:
				predicates.add(criteriaBuilder.equal(join.get("READYTOTEST"), v));
				break;
			case REMARKS:
				predicates.add(criteriaBuilder.like(criteriaBuilder.lower(c.get(QC_.remarks)),
						"%" + v.toString().toLowerCase() + "%"));
				break;

			case E_C_ETA:
				// predicates.add(criteriaBuilder.equal(join.<LocalDate>get(FS_.c_eta),
				// ((LocalDate) v)));
				Expression<String> fetchedDate = criteriaBuilder.function("TO_CHAR", String.class,
						join.<LocalDate>get(FS_.c_eta), criteriaBuilder.literal("YYYY-MM-DD"));
				predicates.add(criteriaBuilder.equal(fetchedDate, v.toString()));
				break;
			case E_P_ETA:
				// predicates.add(criteriaBuilder.equal(join.<LocalDate>get(FS_.p_eta),
				// ((LocalDate) v)));
				Expression<String> fetchedDate1 = criteriaBuilder.function("TO_CHAR", String.class,
						join.<LocalDate>get(FS_.p_eta), criteriaBuilder.literal("YYYY-MM-DD"));
				predicates.add(criteriaBuilder.equal(fetchedDate1, v.toString()));
				break;
			case E_UPLOAD_DATE:
				// predicates.add(criteriaBuilder.equal(join.<LocalDate>get(FS_.upload_date),
				// ((LocalDate) v)));
				Expression<String> fetchedDate2 = criteriaBuilder.function("TO_CHAR", String.class,
						join.<LocalDate>get(FS_.upload_date), criteriaBuilder.literal("YYYY-MM-DD"));
				predicates.add(criteriaBuilder.equal(fetchedDate2, v.toString()));
				break;

			case GT_C_ETA:
				predicates.add(criteriaBuilder.greaterThan(join.<LocalDate>get(FS_.c_eta),
						LocalDate.parse(v.toString(), DateTimeFormatter.BASIC_ISO_DATE)));
				break;
			case GT_P_ETA:
				predicates.add(criteriaBuilder.greaterThan(join.<LocalDate>get(FS_.p_eta),
						LocalDate.parse(v.toString(), DateTimeFormatter.BASIC_ISO_DATE)));
				break;
			case GT_UPLOAD_DATE:
				predicates.add(criteriaBuilder.greaterThan(join.<LocalDate>get(FS_.upload_date),
						LocalDate.parse(v.toString(), DateTimeFormatter.BASIC_ISO_DATE)));
				break;

			case LT_C_ETA:
				predicates.add(criteriaBuilder.lessThan(join.<LocalDate>get(FS_.c_eta),
						LocalDate.parse(v.toString(), DateTimeFormatter.BASIC_ISO_DATE)));
				break;
			case LT_P_ETA:
				predicates.add(criteriaBuilder.lessThan(join.<LocalDate>get(FS_.p_eta),
						LocalDate.parse(v.toString(), DateTimeFormatter.BASIC_ISO_DATE)));
				break;
			case LT_UPLOAD_DATE:
				predicates.add(criteriaBuilder.lessThan(join.<LocalDate>get(FS_.upload_date),
						LocalDate.parse(v.toString(), DateTimeFormatter.BASIC_ISO_DATE)));
				break;

			case E_EXTERNAL_REOPEN_COUNTER:
				predicates.add(criteriaBuilder.equal(c.get(QC_.external_reopen_counter), ((Integer) v)));
				break;
			case E_INTERNAL_REOPEN_COUNTER:
				predicates.add(criteriaBuilder.equal(join.get(FS_.fs_reopen_counter), ((Integer) v)));
				break;

			case GT_EXTERNAL_REOPEN_COUNTER:
				predicates.add(criteriaBuilder.greaterThan(c.get(QC_.external_reopen_counter), ((Integer) v)));
				break;
			case GT_INTERNAL_REOPEN_COUNTER:
				predicates.add(criteriaBuilder.greaterThan(join.get(FS_.fs_reopen_counter), ((Integer) v)));
				break;

			case LT_EXTERNAL_REOPEN_COUNTER:
				predicates.add(criteriaBuilder.lessThan(c.get(QC_.external_reopen_counter), ((Integer) v)));
				break;
			case LT_INTERNAL_REOPEN_COUNTER:
				predicates.add(criteriaBuilder.lessThan(join.get(FS_.fs_reopen_counter), ((Integer) v)));
				break;

			default:
				System.out.println("Undefined Enum");
				break;
			}
		});

		criteriaQuery.select(c).where(predicates.toArray(new Predicate[] {}));
		TypedQuery<QC> typedQuery = em.createQuery(criteriaQuery);

		return typedQuery;
	}

	public void updateQC(QC modifiedQC) {
		QCDAO qcdao = new QCDAO();
		qcdao.update(modifiedQC);
	}

	public void addQC(QC qc) {
		QCDAO qcdao = new QCDAO();
		qcdao.insert(qc);
	}

	public QC getQC(String qc_id) {
		QCDAO qcdao = new QCDAO();
		QC retqc = qcdao.get(qc_id);
		return retqc;
	}

	public void deleteQC(String qc_id) {
		QCDAO qcdao = new QCDAO();
		qcdao.delete(qc_id);
	}
}
