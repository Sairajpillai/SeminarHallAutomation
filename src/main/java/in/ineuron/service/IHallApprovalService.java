package in.ineuron.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import in.ineuron.dto.HallApprovalDTO;

public interface IHallApprovalService {
	
	public List<HallApprovalDTO> getAllRequests();
	
	public String approveRequest(Integer adminid,String bookeddate,Integer bookingid);
	
	public String rejectRequest(String halldate,Integer adminid);
	
	public List<HallApprovalDTO> bookinghistory();

}
