package in.ineuron.servicefactory;

import in.ineuron.service.AdminServiceImpl;
import in.ineuron.service.IAdminService;

public class AdminServiceFactory {
	
	private AdminServiceFactory() {
		// TODO Auto-generated constructor stub
	}
	
	private static IAdminService adminService = null;
	
	public static IAdminService getAdminService() {
		if(adminService==null) {
			adminService = new AdminServiceImpl();
		}
		return adminService;
	}

}
