package org.qcwala1.dfsproject.qcplatform.qcinfo;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class QC {

	@Id
	private String id;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "QC_FSS", joinColumns = @JoinColumn(name = "QC_ID"), inverseJoinColumns = @JoinColumn(name = "FS_ID"))
	private List<FS> fss;
	private String description;
	@Column(columnDefinition ="NUMBER(2) DEFAULT 0")
	private Integer external_reopen_counter=0;

	@Enumerated(EnumType.STRING)
	private Severity severity;

	@Enumerated(EnumType.STRING)
	private Module_ID module_ID;

	private String remarks;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getExternal_reopen_counter() {
		return external_reopen_counter;
	}

	public void setExternal_reopen_counter(Integer external_reopen_counter) {
		this.external_reopen_counter = external_reopen_counter;
	}

	public Severity getSeverity() {
		return severity;
	}

	public void setSeverity(Severity severity) {
		this.severity = severity;
	}

	public Module_ID getModule_ID() {
		return module_ID;
	}

	public void setModule_ID(Module_ID module_ID) {
		this.module_ID = module_ID;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		QC other = (QC) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public List<FS> getFss() {
		return fss;
	}

	public void setFss(List<FS> fss) {
		this.fss = fss;
	}

	@Override
	public String toString() {
		return "QC [id=" + id + ", fss=" + fss + ", description=" + description + ", external_reopen_counter="
				+ external_reopen_counter + ", severity=" + severity + ", module_ID=" + module_ID + ", remarks="
				+ remarks + "]";
	}

}
