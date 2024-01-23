package in.ineuron.service;

import java.sql.Date;
import java.util.List;

import in.ineuron.dao.IHallApprovalDAO;
import in.ineuron.daofactory.HallApprovalDAOFactory;
import in.ineuron.dto.HallApprovalDTO;

public class HallApprovalServiceImpl implements IHallApprovalService {
	
	IHallApprovalDAO hallApprovalDAO=HallApprovalDAOFactory.getHallApprovalDAO();

	@Override
	public List<HallApprovalDTO> getAllRequests() {
		return hallApprovalDAO.getAllRequests();
	}

	@Override
	public String approveRequest(Integer adminid, String bookeddate, Integer bookingid) {
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		
		java.sql.Date sqlRequestedDate = java.sql.Date.valueOf(bookeddate);
		return hallApprovalDAO.approveRequest(adminid, sqlDate, sqlRequestedDate, bookingid);
	}

	@Override
	public String rejectRequest(String halldate, Integer adminid) {
		String status="requested";
		
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		
		java.sql.Date sqlRequestedDate = java.sql.Date.valueOf(halldate);
		
		return hallApprovalDAO.rejectRequest(status, sqlRequestedDate, adminid, sqlDate);
	}

	@Override
	public List<HallApprovalDTO> bookinghistory() {
		List<HallApprovalDTO> dto = hallApprovalDAO.bookingHistory();
		if(dto.size()==0) {
			System.out.println(dto);
			dto=null;
		}
		//System.out.println(dto);
		return dto;
		
	}

}
