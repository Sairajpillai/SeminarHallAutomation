package in.ineuron.dao;

import in.ineuron.dto.DepartmentDTO;
import in.ineuron.dto.HallDTO;

public interface IAdminDAO {
	
	public String saveDepartment(DepartmentDTO department);
	
	public DepartmentDTO findDepartment(String name);
	
	public String removeDepartment(String name);
	
	public String updateDepartment(DepartmentDTO department);
	
	public String addHall(HallDTO halldto);
	
	public HallDTO findHall(String name);

	public String updateHall(HallDTO hall);
	
	public String removeHall(String name);
}
