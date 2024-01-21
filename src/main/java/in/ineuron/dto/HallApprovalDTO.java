package in.ineuron.dto;

import java.io.Serializable;
import java.sql.Date;

public class HallApprovalDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer hallbookingid;
	private String hallname;
	private String hallfloor;
	private String deptname;
	private String deptbranch;
	private String status;
	private String adminname;
	private Date requesteddate;
	private Date halldate;
	
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public Integer getHallbookingid() {
		return hallbookingid;
	}
	public void setHallbookingid(Integer hallbookingid) {
		this.hallbookingid = hallbookingid;
	}
	public String getHallname() {
		return hallname;
	}
	public void setHallname(String hallname) {
		this.hallname = hallname;
	}
	public String getHallfloor() {
		return hallfloor;
	}
	public void setHallfloor(String hallfloor) {
		this.hallfloor = hallfloor;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public String getDeptbranch() {
		return deptbranch;
	}
	public void setDeptbranch(String deptbranch) {
		this.deptbranch = deptbranch;
	}
	public Date getRequesteddate() {
		return requesteddate;
	}
	public void setRequesteddate(Date requesteddate) {
		this.requesteddate = requesteddate;
	}
	public Date getHalldate() {
		return halldate;
	}
	public void setHalldate(Date halldate) {
		this.halldate = halldate;
	}
	@Override
	public String toString() {
		return "HallApprovalDTO [hallbookingid=" + hallbookingid + ", hallname=" + hallname + ", hallfloor=" + hallfloor
				+ ", deptname=" + deptname + ", deptbranch=" + deptbranch + ", status=" + status + ", adminname="
				+ adminname + ", requesteddate=" + requesteddate + ", halldate=" + halldate + "]";
	}
	
	

}
