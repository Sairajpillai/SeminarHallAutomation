package in.ineuron.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import in.ineuron.dto.DepartmentDTO;
import in.ineuron.dto.HallDTO;
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

	@Override
	public String addHall(HallDTO halldto) {
		String status = "failure";
		String insertQuery = "insert into hall(hallname,hallfloor,createddate,adminid_fk) values(?,?,?,?)";
		try {
			con = JDBCUtil.getJdbcConnection();
			if(con!=null) {
				ps = con.prepareStatement(insertQuery);
			}
			if(ps!=null) {
				ps.setString(1,halldto.getHallname());
				ps.setString(2,halldto.getHallfloor());
				ps.setDate(3,halldto.getCdate());
				ps.setInt(4,1);
				
				int rowEffected = ps.executeUpdate();
				if(rowEffected==1) {
					status="success";
				}
			}
		}catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public HallDTO findHall(String name) {
		HallDTO dto = null;
		//String sqlQuery = "select hallid,hallname,hallfloor,createddate from hall where hallname=?";
		String sqlQuery = "select hallid,hallname,hallfloor,h.createddate,adminname from hall h inner join admin a on "+
				          "h.adminid_fk=a.adminid where hallname=?";
		try {
			con = JDBCUtil.getJdbcConnection();
			if (con != null) {
				ps = con.prepareStatement(sqlQuery);
			}
			if (ps != null) {
				ps.setString(1, name);
				rs = ps.executeQuery();
			}
			if (rs != null) {
				while (rs.next()) {
					dto=new HallDTO();
					dto.setHallid(rs.getInt(1));
					dto.setHallname(rs.getString(2));
					dto.setHallfloor(rs.getString(3));
					dto.setCdate(rs.getDate(4));
					dto.setCreatedby(rs.getString(5));
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dto;
	}

	@Override
	public String updateHall(HallDTO hall) {
		String sqlUpdateQuery = "update hall set hallname=?,hallfloor=?,modifieddate=? where hallid=?";
		try {
			con = JDBCUtil.getJdbcConnection();
			if (con != null) {
				ps = con.prepareStatement(sqlUpdateQuery);
			}
			if (ps != null) {
				ps.setString(1, hall.getHallname());
				ps.setString(2, hall.getHallfloor());
				ps.setDate(3, hall.getMdate());
				ps.setInt(4, hall.getHallid());
				

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

	@Override
	public String removeHall(String name) {
		String sqlQuery = "delete from hall where hallname = ?";
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
				System.out.println(result+" in DAOImpl");
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	@Override
	public Boolean isAdmin(Integer id, String password) {
		Boolean status = false;
		String sqlQuery = "select count(*) as row_count from admin where adminid=? and adminpassword=?";
		int rowcount=0;
		try {
			con = JDBCUtil.getJdbcConnection();
			if (con != null) {
				ps = con.prepareStatement(sqlQuery);
			}
			if (ps != null) {
				ps.setInt(1, id);
				ps.setString(2, password);
				rs = ps.executeQuery();

			}
			
			if (rs != null) {
				if (rs.next()) {
					rowcount=rs.getInt("row_count");
				}
			}
			if(rowcount==1) {
				status=true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}
