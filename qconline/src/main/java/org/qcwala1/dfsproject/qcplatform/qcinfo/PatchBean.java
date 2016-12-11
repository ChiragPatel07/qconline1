package org.qcwala1.dfsproject.qcplatform.qcinfo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PatchBean {

	@Id
	private Integer request_num;
	private String patch_id;
	// private Patch_Release_Version release_version;
	// private Product_Category category;

	public Integer getRequest_num() {
		return request_num;
	}

	public void setRequest_num(Integer request_num) {
		this.request_num = request_num;
	}

	public String getPatch_id() {
		return patch_id;
	}

	public void setPatch_id(String patch_id) {
		this.patch_id = patch_id;
	}

}
