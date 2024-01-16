package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import in.ineuron.dao.IAdminDAO;
import in.ineuron.dto.DepartmentDTO;
import in.ineuron.dto.HallDTO;
import in.ineuron.service.IAdminService;
import in.ineuron.servicefactory.AdminServiceFactory;


@WebServlet("/AdminHallServlet/*")
public class AdminHallServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println(request.getRequestURI()+"Reached here");
		
		IAdminService service = AdminServiceFactory.getAdminService();
		
		if(request.getRequestURI().endsWith("AddHall")) {
			String hallName = request.getParameter("hallname");
			String hallfloor = request.getParameter("hallfloor");
			System.out.println(hallName+ " "+hallfloor);
			
			HallDTO hallDTO = new HallDTO();
			hallDTO.setHallname(hallName);
			hallDTO.setHallfloor(hallfloor);
			String result = service.saveHall(hallDTO);
			System.out.println(result);
			
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../JSP/Admin/AdminHomepage.jsp");
			rd.forward(request, response);
			
		}
		
		if(request.getRequestURI().endsWith("SearchHall")) {
			String hallName = request.getParameter("hallname");
			
			System.out.println(hallName);
			
			HallDTO hall = service.findHall(hallName);
			System.out.println(hall);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../JSP/Admin/Department/HallSearchResult.jsp");
			request.setAttribute("hall", hall);
			rd.forward(request, response);
			
		}
		
		if(request.getRequestURI().endsWith("UpdateHall")) {
			
			String hallName = request.getParameter("hallname");
			
			HallDTO hall = service.findHall(hallName);
			
			System.out.println(hall);
			
			
			//RequestDispatcher rd = null;
			request.setAttribute("hall", hall);
			RequestDispatcher rd = request.getRequestDispatcher("../JSP/Admin/Department/EditHall.jsp");
			rd.forward(request, response);
			
			
		}
		
		if(request.getRequestURI().endsWith("EditHall")) {
			System.out.println("Reached Edit Hall");
			
			Integer hallId = Integer.parseInt(request.getParameter("hallid"));
			String hallName = request.getParameter("hallname");
			String hallfloor = request.getParameter("hallfloor");
			
			HallDTO hallDTO = new HallDTO();
			hallDTO.setHallid(hallId);
			hallDTO.setHallname(hallName);
			hallDTO.setHallfloor(hallfloor);
			
			String result = service.updateHall(hallDTO);
			
			System.out.println("Updateion rEsult :: "+result);
			
			
			RequestDispatcher rd = null;
			request.setAttribute("result", result);
			rd = request.getRequestDispatcher("../../JSP/Admin/Department/HallUpdateResult.jsp");
			System.out.println(rd);
			rd.forward(request, response);
			
			
		}
		
		if(request.getRequestURI().endsWith("RemoveHall")) {
			
			String hallName=request.getParameter("hallname");
			
			String result = service.removeHall(hallName);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../JSP/Admin/Department/HallDeleteResult.jsp");
			request.setAttribute("result", result);
			rd.forward(request, response);
			
		}
		
	}

}
