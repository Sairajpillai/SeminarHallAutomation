package in.ineuron.dto;

import java.io.Serializable;
import java.sql.Date;

public class DepartmentDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer deptId;
	private String deptname;
	private String depthod;
	private String deptbranch;
	private String deptpassword;
	private Date createdDate;
	private Date modifiedDate;
	private Integer admin_fk;
	
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public Integer getAdmin_fk() {
		return admin_fk;
	}
	public void setAdmin_fk(Integer admin_fk) {
		this.admin_fk = admin_fk;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getDepthod() {
		return depthod;
	}
	public void setDepthod(String depthod) {
		this.depthod = depthod;
	}
	public String getDeptbranch() {
		return deptbranch;
	}
	public void setDeptbranch(String deptbranch) {
		this.deptbranch = deptbranch;
	}
	public String getDeptpassword() {
		return deptpassword;
	}
	public void setDeptpassword(String deptpassword) {
		this.deptpassword = deptpassword;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	public Date getModifiedDate() {
		return modifiedDate;
	}
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
	@Override
	public String toString() {
		return "DepartmentDTO [deptId=" + deptId + ", deptname=" + deptname + ", depthod=" + depthod + ", deptbranch="
				+ deptbranch + ", deptpassword=" + deptpassword + ", createdDate=" + createdDate + ", modifiedDate="
				+ modifiedDate + ", admin_fk=" + admin_fk + "]";
	}
	
	
	
	

}
