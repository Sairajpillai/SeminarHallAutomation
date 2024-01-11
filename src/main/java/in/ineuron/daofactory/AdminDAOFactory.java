package in.ineuron.daofactory;

import in.ineuron.dao.AdminDAOImpl;
import in.ineuron.dao.IAdminDAO;

public class AdminDAOFactory {
	
	private AdminDAOFactory() {
	}
	
	private static IAdminDAO adminDAO = null;
	
	public static IAdminDAO getAdminDAO() {
		if(adminDAO==null) {
			adminDAO = new AdminDAOImpl();
		}
		return adminDAO;
	}

}
