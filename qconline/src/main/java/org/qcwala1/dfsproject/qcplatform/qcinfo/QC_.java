package org.qcwala1.dfsproject.qcplatform.qcinfo;

import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-12-04T16:14:12.559+0530")
@StaticMetamodel(QC.class)
public class QC_ {
	public static volatile SingularAttribute<QC, String> id;
	public static volatile ListAttribute<QC, FS> fss;
	public static volatile SingularAttribute<QC, String> description;
	public static volatile SingularAttribute<QC, Integer> external_reopen_counter;
	public static volatile SingularAttribute<QC, Severity> severity;
	public static volatile SingularAttribute<QC, Module_ID> module_ID;
	public static volatile SingularAttribute<QC, String> remarks;
}
