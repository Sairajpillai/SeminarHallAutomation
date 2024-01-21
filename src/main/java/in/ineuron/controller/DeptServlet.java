package in.ineuron.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.dto.HallApprovalDTO;
import in.ineuron.dto.HallDTO;
import in.ineuron.service.IDeptService;
import in.ineuron.servicefactory.DeptServiceFactory;


@WebServlet("/DeptServlet/*")
public class DeptServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}


	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		IDeptService service = DeptServiceFactory.getDeptService();
		
		System.out.println(request.getRequestURI()+" Request URI");
		HttpSession session = request.getSession();	
		
		if(request.getRequestURI().endsWith("/home")) {
			System.out.println("Reached Dept");
			Integer loginid = Integer.parseInt(request.getParameter("loginid"));
			String loginpassword = request.getParameter("loginpassword");
			System.out.println(loginid+" "+loginpassword);
			
			Boolean isDept = true;
			
			String deptName = service.checkDept(loginid, loginpassword);
			if(deptName==null) {
				isDept=false;
			}else {
				request.setAttribute("deptname", deptName);
				session.setAttribute("loginid", loginid);
			}
			request.setAttribute("isDept", isDept);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../JSP/Dept/DeptHome.jsp");
			rd.forward(request, response);
			System.out.println(deptName);
		}
		
		if(request.getRequestURI().endsWith("/SearchHall")) {
			String hallname = request.getParameter("hallname");
			String selectedDate = request.getParameter("selectedDate");
			System.out.println(hallname+" "+selectedDate);
			
			HallDTO dto = service.searchHall(hallname, selectedDate);
			
			if(dto==null) {
				request.setAttribute("isAvailable", true);
				session.setAttribute("selectedDate", selectedDate);
				HallDTO hallDTO = service.getHallDetails(hallname);
				request.setAttribute("halldto", hallDTO);
			}else {
				request.setAttribute("isAvailable", false);
				request.setAttribute("dto", dto);
			}
			
			System.out.println(dto);
			
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../JSP/Dept/DeptSearchHallResult.jsp");
			rd.forward(request, response);
		}
		
		if(request.getRequestURI().endsWith("/BookHall")) {
			String hallid = request.getParameter("hallid");
			String hallname = request.getParameter("hallname");
			String selectedDate = (String)session.getAttribute("selectedDate");
			Integer loginid=(Integer) session.getAttribute("loginid");
			
			HallDTO dto = service.checkRequested(hallname, selectedDate, loginid);
			System.out.println(dto + "reached dto in controller");
			String status = null;
			if(dto==null) {
			System.out.println(selectedDate);
			status = service.bookHall(hallid, loginid, selectedDate);
			}
			
			RequestDispatcher rd = null;
			request.setAttribute("status", status);
			rd = request.getRequestDispatcher("../../JSP/Dept/BookHallResult.jsp");
			rd.forward(request, response);
			
			
			//System.out.println(loginid+"reached loginid");
		}
		
		if(request.getRequestURI().endsWith("/BookingStatus")) {
			System.out.println("Reached Booking Status");
			Integer loginid=(Integer) session.getAttribute("loginid");
			List<HallDTO> dto = service.bookingStatus(loginid);
			
			RequestDispatcher rd = null;
			request.setAttribute("dto", dto);
			rd = request.getRequestDispatcher("../JSP/Dept/DeptHallStatus.jsp");
			rd.forward(request, response);
		}
		
		if(request.getRequestURI().endsWith("/HallHistory")) {
			System.out.println("Reached Booking Status");
			Integer loginid=(Integer) session.getAttribute("loginid");
			List<HallDTO> dto = service.hallHistory(loginid);
			
			RequestDispatcher rd = null;
			request.setAttribute("dto", dto);
			rd = request.getRequestDispatcher("../JSP/Dept/HallHistory.jsp");
			rd.forward(request, response);
		}
		
		if(request.getRequestURI().endsWith("/DeleteRequest")) {
			Integer loginid=(Integer) session.getAttribute("loginid");
			List<HallApprovalDTO> dto = service.selectRequestsForDeletion(loginid);
			
			RequestDispatcher rd = null;
			request.setAttribute("dto", dto);
			rd = request.getRequestDispatcher("../JSP/Dept/DeptDeletePage.jsp");
			rd.forward(request, response);
		}
		
		if(request.getRequestURI().endsWith("/DeleteBookingRequest")) {
			Integer bookingid = Integer.parseInt(request.getParameter("hallbookingid"));
			String status = service.deleteRequest(bookingid);
			System.out.println(status);
			
			RequestDispatcher rd = null;
			request.setAttribute("status", status);
			rd = request.getRequestDispatcher("../JSP/Dept/DeptDeleteResult.jsp");
			rd.forward(request, response);
			
		}
		
		
	}

}
