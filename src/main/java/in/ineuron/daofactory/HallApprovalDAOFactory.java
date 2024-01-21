package in.ineuron.daofactory;

import in.ineuron.dao.DeptDAOImpl;
import in.ineuron.dao.HallApprovalDAOImpl;
import in.ineuron.dao.IDeptDAO;
import in.ineuron.dao.IHallApprovalDAO;

public class HallApprovalDAOFactory {
	
	private HallApprovalDAOFactory() {
		// TODO Auto-generated constructor stub
	}
	
	private static IHallApprovalDAO hallDAO = null;
	
	public static IHallApprovalDAO getHallApprovalDAO() {
		if(hallDAO==null) {
			hallDAO = new HallApprovalDAOImpl();
		}
		return hallDAO;
	}

}
