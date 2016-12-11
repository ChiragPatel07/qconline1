package org.qcwala1.dfsproject.qcplatform.qcinfo;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import org.qcwala1.dfsproject.qcplatform.userinfo.Track;
import org.qcwala1.dfsproject.qcplatform.userinfo.UserBean;

@Entity
@XmlRootElement
public class FS {

	@Id
	private String fs_id;

	@XmlJavaTypeAdapter(DateAdapter.class)
	private LocalDate p_eta;
	@XmlJavaTypeAdapter(DateAdapter.class)
	private LocalDate c_eta;
	@XmlJavaTypeAdapter(DateAdapter.class)
	private LocalDate upload_date;

	@Enumerated(EnumType.STRING)
	private Status current_status_fs;

	@Column(columnDefinition = "NUMBER(2) DEFAULT 0")
	private Integer fs_reopen_counter = 0;

	private String patches;

	@Enumerated(EnumType.STRING)
	private Track QCtrack;

	@OneToOne(cascade = CascadeType.REMOVE)
	// (cascade = { CascadeType.DETACH, CascadeType.PERSIST,
	// CascadeType.REFRESH, CascadeType.REMOVE })
	private UserBean developer;

	@OneToOne(cascade = CascadeType.REMOVE)
	private UserBean tester;

	private String createdBy;
	@XmlJavaTypeAdapter(DateAdapter.class)
	private LocalDate createdDate;
	@XmlJavaTypeAdapter(DateAdapter.class)
	private String lastModifiedBy;
	@XmlJavaTypeAdapter(DateAdapter.class)
	private LocalDate lastModifiedDate;

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public LocalDate getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(LocalDate createdDate) {
		this.createdDate = createdDate;
	}

	public String getLastModifiedBy() {
		return lastModifiedBy;
	}

	public void setLastModifiedBy(String lastModifiedBy) {
		this.lastModifiedBy = lastModifiedBy;
	}

	public LocalDate getLastModifiedDate() {
		return lastModifiedDate;
	}

	public void setLastModifiedDate(LocalDate lastModifiedDate) {
		this.lastModifiedDate = lastModifiedDate;
	}

	public Status getCurrent_status_fs() {
		return current_status_fs;
	}

	public void setCurrent_status_fs(Status current_status_fs) {
		this.current_status_fs = current_status_fs;
	}

	public Integer getFs_reopen_counter() {
		return fs_reopen_counter;
	}

	public String getPatches() {
		return patches;
	}

	public void setPatches(String patches) {
		this.patches = patches;
	}

	public Track getQCtrack() {
		return QCtrack;
	}

	public void setQCtrack(Track qCtrack) {
		QCtrack = qCtrack;
	}

	public UserBean getDeveloper() {
		return developer;
	}

	public void setDeveloper(UserBean developer) {
		this.developer = developer;
	}

	public UserBean getTester() {
		return tester;
	}

	public void setTester(UserBean tester) {
		this.tester = tester;
	}

	public void setFs_reopen_counter(Integer fs_reopen_counter) {
		this.fs_reopen_counter = fs_reopen_counter;
	}

	public int getInternal_reopen_counter() {
		return fs_reopen_counter;
	}

	public void setInternal_reopen_counter(int internal_reopen_counter) {
		this.fs_reopen_counter = internal_reopen_counter;
	}

	public LocalDate getP_eta() {
		return p_eta;
	}

	public void setP_eta(LocalDate p_eta) {
		this.p_eta = p_eta;
	}

	public LocalDate getC_eta() {
		return c_eta;
	}

	public void setC_eta(LocalDate c_eta) {
		this.c_eta = c_eta;
	}

	public LocalDate getUpload_date() {
		return upload_date;
	}

	public void setUpload_date(LocalDate upload_date) {
		this.upload_date = upload_date;
	}

	public String getFs_id() {
		return fs_id;
	}

	public void setFs_id(String fs_id) {
		this.fs_id = fs_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((fs_id == null) ? 0 : fs_id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		FS other = (FS) obj;
		if (fs_id == null) {
			if (other.fs_id != null)
				return false;
		} else if (!fs_id.equals(other.fs_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "FS [fs_id=" + fs_id + ", p_eta=" + p_eta + ", c_eta=" + c_eta + ", upload_date=" + upload_date
				+ ", current_status_fs=" + current_status_fs + ", fs_reopen_counter=" + fs_reopen_counter + ", patches="
				+ patches + ", QCtrack=" + QCtrack + ", developer=" + developer + ", tester=" + tester + ", createdBy="
				+ createdBy + ", createdDate=" + createdDate + ", lastModifiedBy=" + lastModifiedBy
				+ ", lastModifiedDate=" + lastModifiedDate + "]";
	}

}
