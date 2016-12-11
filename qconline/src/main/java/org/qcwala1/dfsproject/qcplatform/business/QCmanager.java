package org.qcwala1.dfsproject.qcplatform.business;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.UriInfo;

import org.qcwala1.dfsproject.qcplatform.qcinfo.QC;
import org.qcwala1.dfsproject.qcplatform.qcinfo.QCFilter;
import org.qcwala1.dfsproject.qcplatform.service.QCservice;

@Path("QC")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class QCmanager {

	public static List<QC> populateQCdetailsToAppFromDb(Map<QCFilter, Object> filters) {
		List<QC> list = null;
		if (!filters.isEmpty()) {
			list = QCservice.populateQCdetailsFromDbToApp(filters);
		}
		if (list != null && !list.isEmpty()) {
			return list;
		}
		return null;
	}

	@GET
	public static List<QC> getQCsbyFilter(@Context UriInfo uriInfo) {
		List<QC> list = null;

		Map<QCFilter, Object> formattedMap = getFormattedMap(uriInfo.getQueryParameters());
		list = QCservice.populateQCdetailsFromDbToApp(formattedMap);
		return list;
	}

	@PUT
	@Path("{qcId}")
	public static void updateQC(@PathParam("qcId") String qc_id, QC modifiedQC) {
		modifiedQC.setId(qc_id);
		System.out.println("@Manager for PUT: " + modifiedQC);
		new QCservice().updateQC(modifiedQC);
	}

	@POST
	public static void addQC(QC modifiedQC) {
		System.out.println("@Manager for POST: " + modifiedQC);
		new QCservice().updateQC(modifiedQC);
	}

	@DELETE
	@Path("{qcId}")
	public static void deleteQC(@PathParam("qcId") String qc_id) {

		new QCservice().deleteQC(qc_id);
	}

	@GET
	@Path("{qcId}")
	public static QC getQC(@PathParam("qcId") String qc_id) {

		QC retqc = new QCservice().getQC(qc_id);
		if (retqc != null) {
			return retqc;
		}
		return null;
	}

	public static void printQCdetails(List<QC> list) {
		for (QC qc : list) {
			System.out.println(qc);
		}
	}

	private static Map<QCFilter, Object> getFormattedMap(MultivaluedMap<String, String> queryParameters) {
		Map<QCFilter, Object> formattedMap = new HashMap<>();

		queryParameters.forEach((k, v) -> {

			System.out.println("filter name :" + k + " Value : " + v);
			switch (k) {
			case "ID":
				formattedMap.put(QCFilter.ID, v.get(0));
				break;
			case "FS_ID":
				formattedMap.put(QCFilter.FS_ID, v.get(0));
				break;
			case "CURRENT_STATUS":
				formattedMap.put(QCFilter.CURRENT_STATUS, v.get(0));
				break;
			case "DESCRIPTION":
				formattedMap.put(QCFilter.DESCRIPTION, v.get(0));
				break;
			case "DEVELOPER":
				formattedMap.put(QCFilter.DEVELOPER, v.get(0));
				break;
			case "TESTER":
				formattedMap.put(QCFilter.TESTER, v.get(0));
				break;
			case "SEVERITY":
				formattedMap.put(QCFilter.SEVERITY, v.get(0));
				break;
			case "MODULE_ID":
				formattedMap.put(QCFilter.MODULE_ID, v.get(0));
				break;
			case "QCTRACK":
				formattedMap.put(QCFilter.QCTRACK, v.get(0));
				break;
			case "READYTOTEST":
				break;
			case "REMARKS":
				formattedMap.put(QCFilter.REMARKS, v.get(0));
				break;
			case "E_C_ETA":
				formattedMap.put(QCFilter.E_C_ETA, LocalDate.parse(v.get(0), DateTimeFormatter.BASIC_ISO_DATE));
				break;
			case "E_P_ETA":
				System.out.println(LocalDate.parse(v.get(0), DateTimeFormatter.BASIC_ISO_DATE));
				formattedMap.put(QCFilter.E_P_ETA, LocalDate.parse(v.get(0), DateTimeFormatter.BASIC_ISO_DATE));
				break;
			case "E_UPLOAD_DATE":
				formattedMap.put(QCFilter.E_UPLOAD_DATE, LocalDate.parse(v.get(0), DateTimeFormatter.BASIC_ISO_DATE));
				break;
			case "GT_C_ETA":
				formattedMap.put(QCFilter.GT_C_ETA, LocalDate.parse(v.get(0), DateTimeFormatter.BASIC_ISO_DATE));
				break;
			case "GT_P_ETA":
				formattedMap.put(QCFilter.GT_P_ETA, LocalDate.parse(v.get(0), DateTimeFormatter.BASIC_ISO_DATE));
				break;
			case "GT_UPLOAD_DATE":
				formattedMap.put(QCFilter.GT_UPLOAD_DATE, LocalDate.parse(v.get(0), DateTimeFormatter.BASIC_ISO_DATE));
				break;
			case "LT_C_ETA":
				formattedMap.put(QCFilter.LT_C_ETA, LocalDate.parse(v.get(0), DateTimeFormatter.BASIC_ISO_DATE));
				break;
			case "LT_P_ETA":
				formattedMap.put(QCFilter.LT_P_ETA, LocalDate.parse(v.get(0), DateTimeFormatter.BASIC_ISO_DATE));
				break;
			case "LT_UPLOAD_DATE":
				formattedMap.put(QCFilter.LT_UPLOAD_DATE, LocalDate.parse(v.get(0), DateTimeFormatter.BASIC_ISO_DATE));
				break;
			case "E_EXTERNAL_REOPEN_COUNTER":
				formattedMap.put(QCFilter.E_EXTERNAL_REOPEN_COUNTER, Integer.parseInt(v.get(0)));
				break;
			case "E_INTERNAL_REOPEN_COUNTER":
				formattedMap.put(QCFilter.E_INTERNAL_REOPEN_COUNTER, Integer.parseInt(v.get(0)));
				break;
			case "GT_EXTERNAL_REOPEN_COUNTER":
				formattedMap.put(QCFilter.GT_EXTERNAL_REOPEN_COUNTER, Integer.parseInt(v.get(0)));
				break;
			case "GT_INTERNAL_REOPEN_COUNTER":
				formattedMap.put(QCFilter.GT_INTERNAL_REOPEN_COUNTER, Integer.parseInt(v.get(0)));
				break;
			case "LT_EXTERNAL_REOPEN_COUNTER":
				formattedMap.put(QCFilter.LT_EXTERNAL_REOPEN_COUNTER, Integer.parseInt(v.get(0)));
				break;
			case "LT_INTERNAL_REOPEN_COUNTER":

				formattedMap.put(QCFilter.LT_INTERNAL_REOPEN_COUNTER, Integer.parseInt(v.get(0)));
				break;
			default:
				System.out.println("Undefined Enum");
				break;
			}
		});

		return formattedMap;
	}
}