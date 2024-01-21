package in.ineuron.servicefactory;

import in.ineuron.service.AdminServiceImpl;
import in.ineuron.service.HallApprovalServiceImpl;
import in.ineuron.service.IAdminService;
import in.ineuron.service.IHallApprovalService;

public class HallApprovalServiceFactory {
	
	private HallApprovalServiceFactory() {
		// TODO Auto-generated constructor stub
	}
	
	private static IHallApprovalService approvalService = null;
	
	public static IHallApprovalService getApprovalService() {
		if(approvalService==null) {
			approvalService = new HallApprovalServiceImpl();
		}
		return approvalService;
	}

}
