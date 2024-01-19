package in.ineuron.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import in.ineuron.dao.IDeptDAO;
import in.ineuron.daofactory.DeptDAOFactory;
import in.ineuron.dto.BookingDTO;
import in.ineuron.dto.HallDTO;

public class DeptServiceImpl implements IDeptService{

	IDeptDAO deptDAO=DeptDAOFactory.getDeptDAO();
	
	@Override
	public String checkDept(Integer id, String password) {
		return deptDAO.checkDept(id, password);
	}

	@Override
	public HallDTO searchHall(String hallname, String date) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date selectedDate = null;
        try {
            selectedDate = sdf.parse(date);
            //String format = sdf.format(selectedDate);
        }catch (Exception e) {
            e.printStackTrace();
        }
		java.sql.Date sqlDate = new java.sql.Date(selectedDate.getTime());
		return deptDAO.searchHall(hallname, sqlDate);
	}

	@Override
	public HallDTO getHallDetails(String name) {
		return deptDAO.getHallDetails(name);
	}

	@Override
	public String bookHall(String hallid,Integer deptid, String requestedDate) {
		BookingDTO dto = new BookingDTO();
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
//		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		Date selectedDate = null;
//        try {
//            selectedDate = sdf.parse(requestedDate);
//            //String format = sdf.format(selectedDate);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
		//java.sql.Date sqlRequestedDate = new java.sql.Date(selectedDate.getTime());
		java.sql.Date sqlRequestedDate = java.sql.Date.valueOf(requestedDate);
		System.out.println(sqlRequestedDate+"in service"+requestedDate);
		
		Integer hallid_fk=Integer.parseInt(hallid);
		
		dto.setHallid_fk(hallid_fk);
		dto.setDeptid_fk(deptid);
		dto.setStatus("requested");
		dto.setRequesteddate(sqlDate);
		dto.setHalldate(sqlRequestedDate);
		return deptDAO.bookHall(dto);
	}

	@Override
	public HallDTO checkRequested(String hallname, String date, Integer deptid) {
		java.sql.Date sqlRequestedDate = java.sql.Date.valueOf(date);
		return deptDAO.checkRequested(hallname, sqlRequestedDate, deptid);
	}

	@Override
	public List<HallDTO> bookingStatus(Integer deptId) {
		return deptDAO.bookingStatus(deptId);
	}

}
