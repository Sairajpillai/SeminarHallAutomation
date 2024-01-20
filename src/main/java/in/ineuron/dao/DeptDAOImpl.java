package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.dto.BookingDTO;
import in.ineuron.dto.HallDTO;
import in.ineuron.util.JDBCUtil;

public class DeptDAOImpl implements IDeptDAO {
	
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;

	@Override
	public String checkDept(Integer id, String password) {
		String deptName = null;
		String sqlQuery = "select deptname as deptname from department where departmentid=? and deptpassword=?";
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
					deptName=rs.getString("deptname");
				}
			}
//			if(rowcount==1) {
//				status=true;
//			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deptName;
	}

	@Override
	public HallDTO searchHall(String hallname,Date date) {
		HallDTO dto = null;
//		String sqlQuery = "SELECT hi.hallid, hi.hallname, hi.hallfloor, hb.status,hb.bookeddate\r\n"
//				+ "FROM hall hi\r\n"
//				+ "JOIN hallbooking hb ON hi.hallid = hb.hallid_fk\r\n"
//				+ "WHERE hi.hallname = ?";
		
		String sqlQuery = "SELECT hi.hallid, hi.hallname, hi.hallfloor, hb.status,hb.bookeddate\r\n"
				+ "FROM hall hi\r\n"
				+ "JOIN hallbooking hb ON hi.hallid = hb.hallid_fk\r\n"
				+ "WHERE hi.hallname = ? and hb.requesteddate=? and hb.status=?";
		
		try {
			con = JDBCUtil.getJdbcConnection();
			if (con != null) {
				ps = con.prepareStatement(sqlQuery);
			}
			if (ps != null) {
				ps.setString(1, hallname);
				ps.setDate(2, date);
				ps.setString(3, "accepted");
				rs = ps.executeQuery();
			}
			if (rs != null) {
				while (rs.next()) {
					dto=new HallDTO();
					dto.setHallid(rs.getInt(1));
					dto.setHallname(rs.getString(2));
					dto.setHallfloor(rs.getString(3));
					dto.setStatus(rs.getString(4));
					dto.setBookeddate(rs.getDate(5));
					//query needs to be modified look in mysql workbench
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
	public HallDTO getHallDetails(String name) {
		HallDTO dto = null;
		String sqlQuery = "select hallid,hallname,hallfloor from hall where hallname=?";
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
	public String bookHall(BookingDTO dto) {
		String status = "failure";
		String sqlQuery = "insert into hallbooking(status,requesteddate,deptid_fk,hallid_fk,halldate) values(?,?,?,?,?)";
		try {
			con = JDBCUtil.getJdbcConnection();
			if(con!=null) {
				ps = con.prepareStatement(sqlQuery);
			}
			if(ps!=null) {
				ps.setString(1, dto.getStatus());
				ps.setDate(2, dto.getRequesteddate());
				ps.setInt(3, dto.getDeptid_fk());
				ps.setInt(4, dto.getHallid_fk());
				ps.setDate(5, dto.getHalldate());
				int rowsEffected = ps.executeUpdate();
				if(rowsEffected==1) {
					status="success";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public HallDTO checkRequested(String hallname, Date date, Integer deptid) {
		HallDTO dto = null;
		
		String sqlQuery = "SELECT hi.hallid, hi.hallname, hi.hallfloor, hb.status,hb.bookeddate,hb.deptid_fk\r\n"
				+ "FROM hall hi\r\n"
				+ "JOIN hallbooking hb ON hi.hallid = hb.hallid_fk\r\n"
				+ "WHERE hi.hallname = ? and hb.requesteddate =? and hb.status=? and hb.deptid_fk=? ;";
		
		try {
			con = JDBCUtil.getJdbcConnection();
			if (con != null) {
				ps = con.prepareStatement(sqlQuery);
			}
			if (ps != null) {
				ps.setString(1, hallname);
				ps.setDate(2, date);
				ps.setString(3, "requested");
				ps.setInt(4, deptid);
				rs = ps.executeQuery();
			}
			if (rs != null) {
				while (rs.next()) {
					dto=new HallDTO();
					dto.setHallid(rs.getInt(1));
					dto.setHallname(rs.getString(2));
					dto.setHallfloor(rs.getString(3));
					dto.setStatus(rs.getString(4));
					dto.setBookeddate(rs.getDate(5));
					//query needs to be modified look in mysql workbench
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
	public List<HallDTO> bookingStatus(Integer deptId) {
        List<HallDTO> listDTO = new ArrayList<HallDTO>();
		
		String sqlQuery = "SELECT hi.hallid, hi.hallname, hi.hallfloor, hb.status,hb.requesteddate,hb.halldate\r\n"
				+ "FROM hall hi\r\n"
				+ "JOIN hallbooking hb ON hi.hallid = hb.hallid_fk\r\n"
				+ "where hb.deptid_fk=? and hb.status=?";
		
		try {
			con = JDBCUtil.getJdbcConnection();
			if (con != null) {
				ps = con.prepareStatement(sqlQuery);
			}
			if (ps != null) {
				ps.setInt(1, deptId);
				ps.setString(2, "requested");
				rs = ps.executeQuery();
			}
			if (rs != null) {
				while (rs.next()) {
					HallDTO dto=new HallDTO();
					dto.setHallid(rs.getInt(1));
					dto.setHallname(rs.getString(2));
					dto.setHallfloor(rs.getString(3));
					dto.setStatus(rs.getString(4));
					dto.setRequesteddate(rs.getDate(5));
					dto.setHalldate(rs.getDate(6));
					
					listDTO.add(dto);
					
				}
			}
		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return listDTO;
	}

	@Override
	public List<HallDTO> hallHistory(Integer deptId) {
		
		 List<HallDTO> listDTO = new ArrayList<HallDTO>();
			
			String sqlQuery = "SELECT hi.hallid, hi.hallname, hi.hallfloor, hb.status,hb.requesteddate,hb.halldate,\r\n"
					+ "hb.statusdate,hb.bookeddate\r\n"
					+ "FROM hall hi\r\n"
					+ "JOIN hallbooking hb ON hi.hallid = hb.hallid_fk\r\n"
					+ "where hb.deptid_fk=?";
			
			try {
				con = JDBCUtil.getJdbcConnection();
				if (con != null) {
					ps = con.prepareStatement(sqlQuery);
				}
				if (ps != null) {
					ps.setInt(1, deptId);
					rs = ps.executeQuery();
				}
				if (rs != null) {
					while (rs.next()) {
						HallDTO dto=new HallDTO();
						dto.setHallid(rs.getInt(1));
						dto.setHallname(rs.getString(2));
						dto.setHallfloor(rs.getString(3));
						dto.setStatus(rs.getString(4));
						dto.setRequesteddate(rs.getDate(5));
						dto.setHalldate(rs.getDate(6));
						dto.setStatusDate(rs.getDate(7));
						dto.setBookeddate(rs.getDate(8));;
						
						listDTO.add(dto);
						
					}
				}
			} catch (SQLException se) {
				se.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return listDTO;
	}
	
	

}
