package in.ineuron.dto;

import java.io.Serializable;
import java.sql.Date;

public class HallDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer hallid;
	private String hallname;
	private String hallfloor;
	private Date cdate;
	private Date mdate;
	private Integer adminid_fk;
	private String createdby;
	private String status;
	private Date bookeddate;
	private Date halldate;
	private Date requesteddate;
	private Date statusDate;
	
	public Date getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(Date statusDate) {
		this.statusDate = statusDate;
	}
	public Date getHalldate() {
		return halldate;
	}
	public void setHalldate(Date halldate) {
		this.halldate = halldate;
	}
	public Date getRequesteddate() {
		return requesteddate;
	}
	public void setRequesteddate(Date requesteddate) {
		this.requesteddate = requesteddate;
	}
	public Date getBookeddate() {
		return bookeddate;
	}
	public void setBookeddate(Date bookeddate) {
		this.bookeddate = bookeddate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getCreatedby() {
		return createdby;
	}
	public void setCreatedby(String createdby) {
		this.createdby = createdby;
	}
	public Integer getHallid() {
		return hallid;
	}
	public void setHallid(Integer hallid) {
		this.hallid = hallid;
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
	public Date getCdate() {
		return cdate;
	}
	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}
	public Date getMdate() {
		return mdate;
	}
	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}
	public Integer getAdminid_fk() {
		return adminid_fk;
	}
	public void setAdminid_fk(Integer adminid_fk) {
		this.adminid_fk = adminid_fk;
	}
	@Override
	public String toString() {
		return "HallDTO [hallid=" + hallid + ", hallname=" + hallname + ", hallfloor=" + hallfloor + ", cdate=" + cdate
				+ ", mdate=" + mdate + ", adminid_fk=" + adminid_fk + ", createdby=" + createdby + ", status=" + status
				+ ", bookeddate=" + bookeddate + ", halldate=" + halldate + ", requesteddate=" + requesteddate
				+ ", statusDate=" + statusDate + "]";
	}
	
	

}
