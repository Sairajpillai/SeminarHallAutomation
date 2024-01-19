package in.ineuron.dao;

import java.sql.Date;
import java.util.List;

import in.ineuron.dto.BookingDTO;
import in.ineuron.dto.HallDTO;

public interface IDeptDAO {
	
	public String checkDept(Integer id,String password);
	
	public HallDTO searchHall(String hallname,Date date);
	
	public HallDTO getHallDetails(String name);
	
	public String bookHall(BookingDTO dto);
	
	public HallDTO checkRequested(String hallname,Date date,Integer deptid);
	
	public List<HallDTO> bookingStatus(Integer deptId);

}
