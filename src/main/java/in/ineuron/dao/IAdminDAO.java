package in.ineuron.dao;

import in.ineuron.dto.DepartmentDTO;

public interface IAdminDAO {
	
	public String saveDepartment(DepartmentDTO department);
	
	public DepartmentDTO findDepartment(String name);
	
	public String removeDepartment(String name);
	
	
	public String updateDepartment(DepartmentDTO department);
	

}
