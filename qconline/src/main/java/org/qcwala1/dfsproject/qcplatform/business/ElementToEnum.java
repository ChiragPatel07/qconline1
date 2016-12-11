package org.qcwala1.dfsproject.qcplatform.business;

import org.qcwala1.dfsproject.qcplatform.qcinfo.Module_ID;
import org.qcwala1.dfsproject.qcplatform.qcinfo.Severity;

public class ElementToEnum {

	public static Severity mapSeverity(Object severity) {
		String string = severity.toString();
		if (string.equals("1-Low")) {
			return Severity.NORMAL;
		} else if (string.equals("2-Medium")) {
			return Severity.MEDIUM;
		} else if (string.equals("3-High")) {
			return Severity.HIGH;
		} else {
			return Severity.UNDEFINED;
		}

	}

	public static Module_ID mapModule_ID(Object module_id) {
		String string = module_id.toString();
		if (string.equals("DFS_DM_DSL")) {
			return Module_ID.DFS_DM_DSL;
		} else if (string.equals("DFS_CUSTOM_DSL")) {
			return Module_ID.DFS_CUSTOM_DSL;
		} else if (string.equals("DFS_PRODUCT_DSL")) {
			return Module_ID.DFS_PRODUCT_DSL;
		} else if (string.equals("DFS_CRM_DSL")) {
			return Module_ID.DFS_CRM_DSL;
		} else {
			return Module_ID.UNDEFINED;
		}

	}
}
