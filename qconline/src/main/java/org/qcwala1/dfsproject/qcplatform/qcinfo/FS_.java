package org.qcwala1.dfsproject.qcplatform.qcinfo;

import java.time.LocalDate;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import org.qcwala1.dfsproject.qcplatform.userinfo.Track;
import org.qcwala1.dfsproject.qcplatform.userinfo.UserBean;

@Generated(value="Dali", date="2016-12-04T16:14:12.551+0530")
@StaticMetamodel(FS.class)
public class FS_ {
	public static volatile SingularAttribute<FS, String> fs_id;
	public static volatile SingularAttribute<FS, LocalDate> p_eta;
	public static volatile SingularAttribute<FS, LocalDate> c_eta;
	public static volatile SingularAttribute<FS, LocalDate> upload_date;
	public static volatile SingularAttribute<FS, Status> current_status_fs;
	public static volatile SingularAttribute<FS, Integer> fs_reopen_counter;
	public static volatile SingularAttribute<FS, String> patches;
	public static volatile SingularAttribute<FS, Track> QCtrack;
	public static volatile SingularAttribute<FS, UserBean> developer;
	public static volatile SingularAttribute<FS, UserBean> tester;
	public static volatile SingularAttribute<FS, String> createdBy;
	public static volatile SingularAttribute<FS, LocalDate> createdDate;
	public static volatile SingularAttribute<FS, String> lastModifiedBy;
	public static volatile SingularAttribute<FS, LocalDate> lastModifiedDate;
}
