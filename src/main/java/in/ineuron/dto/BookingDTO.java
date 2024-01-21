package in.ineuron.dto;

import java.io.Serializable;
import java.sql.Date;

public class BookingDTO implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer bookingid;
	private String status;
	private Date requesteddate;
	private Date accepteddate;
	private Date rejecteddate;
	private Date bookeddate;
	private Integer adminid_fk;
	private Integer hallid_fk;
	private Integer deptid_fk;
	private Date halldate;
	public Date getHalldate() {
		return halldate;
	}
	public void setHalldate(Date halldate) {
		this.halldate = halldate;
	}
	public Integer getBookingid() {
		return bookingid;
	}
	public void setBookingid(Integer bookingid) {
		this.bookingid = bookingid;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getRequesteddate() {
		return requesteddate;
	}
	public void setRequesteddate(Date requesteddate) {
		this.requesteddate = requesteddate;
	}
	public Date getAccepteddate() {
		return accepteddate;
	}
	public void setAccepteddate(Date accepteddate) {
		this.accepteddate = accepteddate;
	}
	public Date getRejecteddate() {
		return rejecteddate;
	}
	public void setRejecteddate(Date rejecteddate) {
		this.rejecteddate = rejecteddate;
	}
	public Date getBookeddate() {
		return bookeddate;
	}
	public void setBookeddate(Date bookeddate) {
		this.bookeddate = bookeddate;
	}
	public Integer getAdminid_fk() {
		return adminid_fk;
	}
	public void setAdminid_fk(Integer adminid_fk) {
		this.adminid_fk = adminid_fk;
	}
	public Integer getHallid_fk() {
		return hallid_fk;
	}
	public void setHallid_fk(Integer hallid_fk) {
		this.hallid_fk = hallid_fk;
	}
	public Integer getDeptid_fk() {
		return deptid_fk;
	}
	public void setDeptid_fk(Integer deptid_fk) {
		this.deptid_fk = deptid_fk;
	}
	@Override
	public String toString() {
		return "BookingDTO [bookingid=" + bookingid + ", status=" + status + ", requesteddate=" + requesteddate
				+ ", accepteddate=" + accepteddate + ", rejecteddate=" + rejecteddate + ", bookeddate=" + bookeddate
				+ ", adminid_fk=" + adminid_fk + ", hallid_fk=" + hallid_fk + ", deptid_fk=" + deptid_fk + ", halldate="
				+ halldate + "]";
	}
	
	

}
