package in.ineuron.service;

import in.ineuron.dao.IAdminDAO;
import in.ineuron.daofactory.AdminDAOFactory;
import in.ineuron.dto.DepartmentDTO;
import in.ineuron.dto.HallDTO;

public class AdminServiceImpl implements IAdminService {
	
	IAdminDAO adminDao = AdminDAOFactory.getAdminDAO();
	
	@Override
	public String saveDepartment(DepartmentDTO department) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		department.setCreatedDate(sqlDate);
		return adminDao.saveDepartment(department);
	}

	@Override
	public DepartmentDTO findDepartment(String name) {
		return adminDao.findDepartment(name);
	}

	@Override
	public String removeDepartment(String name) {
		return adminDao.removeDepartment(name);
	}

	@Override
	public String updateDepartment(DepartmentDTO department) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		department.setModifiedDate(sqlDate);
		return adminDao.updateDepartment(department);
	}

	@Override
	public String saveHall(HallDTO halldto) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		halldto.setCdate(sqlDate);
		return adminDao.addHall(halldto);
	}

	@Override
	public HallDTO findHall(String name) {
		return adminDao.findHall(name);
	}

	@Override
	public String updateHall(HallDTO hall) {
		java.util.Date utilDate = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		hall.setMdate(sqlDate);
		return adminDao.updateHall(hall);
	}

	@Override
	public String removeHall(String name) {
		return adminDao.removeHall(name);
	}

	@Override
	public Boolean isAdmin(Integer id, String password) {
		return adminDao.isAdmin(id, password);
	}

}
