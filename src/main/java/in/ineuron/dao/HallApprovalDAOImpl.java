package in.ineuron.dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import in.ineuron.dto.HallApprovalDTO;
import in.ineuron.dto.HallDTO;
import in.ineuron.util.JDBCUtil;

public class HallApprovalDAOImpl implements IHallApprovalDAO {

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	@Override
	public List<HallApprovalDTO> getAllRequests() {
		List<HallApprovalDTO> listDTO = new ArrayList<HallApprovalDTO>();
		
		String sqlQuery = "SELECT hb.bookingid,hb.requesteddate,hb.halldate, d.deptname,d.deptbranch, h.hallname,h.hallfloor\r\n"
				+ "FROM hallbooking hb\r\n"
				+ "JOIN department d ON hb.deptid_fk = d.departmentid\r\n"
				+ "JOIN hall h ON hb.hallid_fk = h.hallid \r\n"
				+ "where hb.status=\"requested\"";
		
		try {
			con = JDBCUtil.getJdbcConnection();
			if (con != null) {
				ps = con.prepareStatement(sqlQuery);
			}
			if (ps != null) {
				rs = ps.executeQuery();
			}
			if (rs != null) {
				while (rs.next()) {
					HallApprovalDTO dto=new HallApprovalDTO();
					dto.setHallbookingid(rs.getInt(1));
					dto.setRequesteddate(rs.getDate(2));
					dto.setHalldate(rs.getDate(3));
					dto.setDeptname(rs.getString(4));
					dto.setDeptbranch(rs.getString(5));
					dto.setHallname(rs.getString(6));
					dto.setHallfloor(rs.getString(7));
					
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
	public String approveRequest(Integer adminid,Date statusdate, Date bookeddate, Integer bookingid) {
		String result = "failure";
		
		String sqlQuery = "update hallbooking set status =?,statusdate=?,adminid_fk=?, bookeddate=? where bookingid=?";
		try {
			con = JDBCUtil.getJdbcConnection();
			if(con!=null) {
				ps = con.prepareStatement(sqlQuery);
			}
			if(ps!=null) {
				ps.setString(1, "accepted");
				ps.setDate(2,statusdate);
				ps.setInt(3, adminid);
				ps.setDate(4, bookeddate);
				ps.setInt(5, bookingid);
				int rowsEffected = ps.executeUpdate();
				if(rowsEffected==1) {
					result="success";
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return result;
	}

	@Override
	public String rejectRequest(String status, Date halldate, Integer adminid, Date statusDate) {
		String result = "failure";
		System.out.println("Inside reject DAO");
		//
		 try (Connection con = JDBCUtil.getJdbcConnection()) {
	            // Step 1: Select IDs based on the specified conditions
	            String sqlQuery = "SELECT bookingid FROM hallbooking WHERE status = ? AND halldate = ?";
	            try (PreparedStatement ps = con.prepareStatement(sqlQuery)) {
	                ps.setString(1, status);
	                ps.setDate(2, halldate);

	                try (ResultSet resultSet = ps.executeQuery()) {
	                    // Step 2: Update other fields for the selected IDs
	                    String sqlQuery1 = "UPDATE hallbooking " +
	                            "SET status = ?, statusdate = ?,adminid_fk=? " +
	                            "WHERE bookingid = ?";
	                    
	                    int counter=0;

	                    try (PreparedStatement ps1 = con.prepareStatement(sqlQuery1)) {
	                        while (resultSet.next()) {
	                        	counter++;
	                            int id = resultSet.getInt("bookingid");

	                            ps1.setString(1, "rejected");
	                            ps1.setDate(2, statusDate);
	                            ps1.setInt(3, adminid);
	                            ps1.setInt(4, id);

	                            int rowsAffected = ps1.executeUpdate();
	                            System.out.println("Rows affected for ID " + id + ": " + rowsAffected);
	                        }
	                    }
	                    if(counter>0) {
	                    	result="success";
	                    }
	                }
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }catch(Exception e) {
	        	e.printStackTrace();
	        }
		//
		System.out.println(result);
		return result;
	}

	@Override
	public List<HallApprovalDTO> bookingHistory() {
List<HallApprovalDTO> listDTO = new ArrayList<HallApprovalDTO>();
		
		String sqlQuery = "SELECT hb.bookingid,hb.requesteddate,hb.halldate,hb.status,\r\n"
				+ " d.deptname,d.deptbranch, h.hallname,h.hallfloor,\r\n"
				+ " a.adminname\r\n"
				+ "FROM hallbooking hb\r\n"
				+ "JOIN department d ON hb.deptid_fk = d.departmentid\r\n"
				+ "JOIN hall h ON hb.hallid_fk = h.hallid\r\n"
				+ "JOIN admin a ON hb.adminid_fk=a.adminid";
		
		try {
			con = JDBCUtil.getJdbcConnection();
			if (con != null) {
				ps = con.prepareStatement(sqlQuery);
			}
			if (ps != null) {
				rs = ps.executeQuery();
			}
			if (rs != null) {
				while (rs.next()) {
					HallApprovalDTO dto=new HallApprovalDTO();
					dto.setHallbookingid(rs.getInt(1));
					dto.setRequesteddate(rs.getDate(2));
					dto.setHalldate(rs.getDate(3));
					dto.setStatus(rs.getString(4));
					dto.setDeptname(rs.getString(5));
					dto.setDeptbranch(rs.getString(6));
					dto.setHallname(rs.getString(7));
					dto.setHallfloor(rs.getString(8));
					dto.setAdminname(rs.getString(9));
					
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
