package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.DepartmentDTO;
import in.ineuron.util.JDBCUtil;

public class AdminDAOImpl implements IAdminDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public String saveDepartment(DepartmentDTO department) {
		String status = "failure";
		String sqlInsertQuery = "insert into department(deptname,depthod,deptbranch,deptpassword,createddate,modifieddate,adminid_fk) values(?,?,?,?,?,?,?)";

		try {

			con = JDBCUtil.getJdbcConnection();
			if (con != null) {
				ps = con.prepareStatement(sqlInsertQuery);
			}
			if (ps != null) {
				ps.setString(1, department.getDeptname());
				ps.setString(2, department.getDepthod());
				ps.setString(3, department.getDeptname());
				ps.setString(4, department.getDeptpassword());
				ps.setDate(5, department.getCreatedDate());
				ps.setDate(6, department.getModifiedDate());
				ps.setInt(7, 1);

				int rowsEffected = ps.executeUpdate();

				if (rowsEffected == 1) {
					status = "success";
				}
			}

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public DepartmentDTO findDepartment(String deptName) {
		DepartmentDTO dept = null;
		String sqlQuery = "select departmentid,deptname,depthod,deptbranch,deptpassword,createddate from department where deptname=?";
		try {
			con = JDBCUtil.getJdbcConnection();
			if (con != null) {
				ps = con.prepareStatement(sqlQuery);
			}
			if (ps != null) {
				ps.setString(1, deptName);
				rs = ps.executeQuery();
			}
			if (rs != null) {
				while (rs.next()) {
					dept = new DepartmentDTO();
					dept.setDeptId(rs.getInt(1));
					dept.setDeptname(rs.getString(2));
					dept.setDepthod(rs.getString(3));
					dept.setDeptbranch(rs.getString(4));
					dept.setDeptpassword(rs.getString(5));
					dept.setCreatedDate(rs.getDate(6));
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dept;
	}

	@Override
	public String removeDepartment(String name) {
		String sqlQuery = "delete from department where deptname = ?";
		String result = "failure";
		int rowsEffected = 0;
		try {
			con = JDBCUtil.getJdbcConnection();
			if (con != null) {
				ps = con.prepareStatement(sqlQuery);
			}
			if(ps!=null) {
				ps.setString(1, name);
				rowsEffected = ps.executeUpdate();
			}
			if(rowsEffected==1) {
				result="success";
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public String updateDepartment(DepartmentDTO department) {
		String sqlUpdateQuery = "update department set deptname=?,depthod=?,deptbranch=?,deptpassword=?,modifieddate=?,adminid_fk=? where departmentid=?";
		try {
			con = JDBCUtil.getJdbcConnection();
			if (con != null) {
				ps = con.prepareStatement(sqlUpdateQuery);
			}
			if (ps != null) {
				ps.setString(1, department.getDeptname());
				ps.setString(2, department.getDepthod());
				ps.setString(3, department.getDeptname());
				ps.setString(4, department.getDeptpassword());
				ps.setDate(5, department.getModifiedDate());
				ps.setInt(6, 1);
				ps.setInt(7, department.getDeptId());

				int rowEffected = ps.executeUpdate();
				if (rowEffected == 1) {
					return "success";
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "faliure";
	}

}
