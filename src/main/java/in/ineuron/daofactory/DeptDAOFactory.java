package in.ineuron.daofactory;

import in.ineuron.dao.DeptDAOImpl;
import in.ineuron.dao.IDeptDAO;

public class DeptDAOFactory {
	
	private DeptDAOFactory() {
		// TODO Auto-generated constructor stub
	}
	
	private static IDeptDAO deptDAO = null;
	
	public static IDeptDAO getDeptDAO() {
		if(deptDAO==null) {
			deptDAO = new DeptDAOImpl();
		}
		return deptDAO;
	}

}
