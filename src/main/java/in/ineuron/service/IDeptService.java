package in.ineuron.service;

import java.util.Date;
import java.util.List;

import in.ineuron.dto.BookingDTO;
import in.ineuron.dto.HallApprovalDTO;
import in.ineuron.dto.HallDTO;

public interface IDeptService {
	
	public String checkDept(Integer id,String password);
	
	public HallDTO searchHall(String hallname,String date);
	
	public HallDTO getHallDetails(String name);
	
	public String bookHall(String hallid,Integer deptid, String requestedDate);
	
	public HallDTO checkRequested(String hallname, String date, Integer deptid);
	
	public List<HallDTO> bookingStatus(Integer deptId);
	
	public List<HallDTO> hallHistory(Integer deptId);
	
	public List<HallApprovalDTO> selectRequestsForDeletion(Integer deptId);
	
	public String deleteRequest(Integer bookingId);

}
