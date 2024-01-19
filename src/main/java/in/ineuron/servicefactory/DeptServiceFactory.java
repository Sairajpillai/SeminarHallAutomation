package in.ineuron.servicefactory;

import in.ineuron.service.AdminServiceImpl;
import in.ineuron.service.DeptServiceImpl;
import in.ineuron.service.IAdminService;
import in.ineuron.service.IDeptService;

public class DeptServiceFactory {
	
	private DeptServiceFactory() {
		// TODO Auto-generated constructor stub
	}
	
	private static IDeptService deptService = null;
	
	public static IDeptService getDeptService() {
		if(deptService==null) {
			deptService = new DeptServiceImpl();
		}
		return deptService;
	}

}
