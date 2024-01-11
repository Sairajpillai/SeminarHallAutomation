package in.ineuron.service;

import in.ineuron.dto.DepartmentDTO;

public interface IAdminService {
	
	public String saveDepartment(DepartmentDTO department);
	
	public DepartmentDTO findDepartment(String name);
	
	public String removeDepartment(String name);
	
	public String updateDepartment(DepartmentDTO department);
	

}
