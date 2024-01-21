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

import in.ineuron.daofactory.HallApprovalDAOFactory;
import in.ineuron.dto.HallApprovalDTO;
import in.ineuron.service.IDeptService;
import in.ineuron.service.IHallApprovalService;
import in.ineuron.servicefactory.DeptServiceFactory;
import in.ineuron.servicefactory.HallApprovalServiceFactory;

@WebServlet("/AdminHallApproval/*")
public class AdminHallApproval extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doProcess(request, response);
	}

	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI()+"Reached here");
		
        IHallApprovalService service = HallApprovalServiceFactory.getApprovalService();
		
		System.out.println(request.getRequestURI()+" Request URI");
		HttpSession session = request.getSession();	
		
		if(request.getRequestURI().endsWith("/ApproveRequest")) {
			
			List<HallApprovalDTO> dto = service.getAllRequests();
			request.setAttribute("dto", dto);
			
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../JSP/Admin/HallBooking/HallApproval.jsp");
			rd.forward(request, response);
			
		}
		
		if(request.getRequestURI().endsWith("/ApproveHallRequest")) {
			Integer loginid = (Integer) session.getAttribute("loginid");
			Integer bookingid=Integer.parseInt(request.getParameter("hallbookingid"));
			/*String hallname=request.getParameter("hallname");
			String hallfloor=request.getParameter("hallfloor");
			String deptname=request.getParameter("deptname");
			String deptbranch=request.getParameter("deptbranch");
			String halldate=request.getParameter("halldate");*/
			String requesteddate=request.getParameter("requesteddate");
			String halldate=request.getParameter("halldate");
			
			String result = service.approveRequest(loginid, requesteddate, bookingid);
			System.out.println(result+"1st operation");
			
			String rejectResult="failure";
			if(result.equalsIgnoreCase("success")) {
				rejectResult = service.rejectRequest(halldate, loginid);
				System.out.println(rejectResult+"inside reject");
			}else {
				System.out.println(rejectResult+"inside reject");
			}
			
			request.setAttribute("rejectResult", rejectResult);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../JSP/Admin/HallBooking/ApprovalResult.jsp");
			rd.forward(request, response);
		
		}
		
		if(request.getRequestURI().endsWith("/BookingHistory")) {
			List<HallApprovalDTO> dto = service.bookinghistory();
			
			request.setAttribute("dto", dto);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../JSP/Admin/HallBooking/BookingHistory.jsp");
			rd.forward(request, response);
			
		}

	}

}
