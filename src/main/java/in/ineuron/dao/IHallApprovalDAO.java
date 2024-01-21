package in.ineuron.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import in.ineuron.dto.HallApprovalDTO;

public interface IHallApprovalDAO {
	
	public List<HallApprovalDTO> getAllRequests();
	
	public String approveRequest(Integer adminid,Date statusdate,Date bookeddate,Integer bookingid);
	
	public String rejectRequest(String status,Date halldate,Integer adminid,Date statusDate);
	
	public List<HallApprovalDTO> bookingHistory();

}
