package in.ineuron.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import in.ineuron.dto.DepartmentDTO;
import in.ineuron.service.IAdminService;
import in.ineuron.servicefactory.AdminServiceFactory;


@WebServlet("/AdminServlet/*")
public class AdminServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request,response);
	}
	
	private void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println(request.getRequestURI()+"Reached here");
		
		IAdminService service = AdminServiceFactory.getAdminService();
		HttpSession session = request.getSession();
		
		if(request.getRequestURI().endsWith(("home"))) {
			Integer loginid = Integer.parseInt(request.getParameter("loginid"));
			String loginpassword = request.getParameter("loginpassword");
			session.setAttribute("loginid", loginid);
			Boolean result = service.isAdmin(loginid, loginpassword);
			
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../JSP/Admin/AdminHomepage.jsp");
			request.setAttribute("result", result);
			rd.forward(request, response);
		}
		
		if(request.getRequestURI().endsWith(("addDepartment"))) {
			System.out.println("Reached add dept");
			String deptName = request.getParameter("deptName");
			String deptHODName = request.getParameter("deptHODName");
			String deptBranch = request.getParameter("deptBranch");
			System.out.println(deptName+" "+deptHODName+" "+deptBranch);
			
			DepartmentDTO deptDTO = new DepartmentDTO();
			deptDTO.setDeptname(deptName);
			deptDTO.setDeptbranch(deptBranch);
			deptDTO.setDepthod(deptHODName);
			deptDTO.setDeptpassword("pass1234");
			
			String saveResult = service.saveDepartment(deptDTO);
			System.out.println(saveResult);
			
//			String role=null;
//			session.setAttribute(role, "admin");
			
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../JSP/Admin/AdminHomepage.jsp");
			rd.forward(request, response);
		}
		
		if(request.getRequestURI().endsWith("SearchDepartment")) {
			System.out.println("Reached search dept");
			
			String deptName=request.getParameter("deptName");
			System.out.println(deptName);
			
			DepartmentDTO dept = service.findDepartment(deptName);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../JSP/Admin/DepartmentSearchResult.jsp");
			request.setAttribute("dept", dept);
			rd.forward(request, response);
			System.out.println(dept);
		}
		
		if(request.getRequestURI().endsWith("removeDepartment")) {
			System.out.println("Reached removed dept");
			
			String deptName=request.getParameter("deptname");
			
			String result = service.removeDepartment(deptName);
			RequestDispatcher rd = null;
			rd = request.getRequestDispatcher("../JSP/Admin/DepartmentDeleteResult.jsp");
			request.setAttribute("result", result);
			rd.forward(request, response);
			
		}
		
		if(request.getRequestURI().endsWith("UpdateDepartment")) {
			System.out.println("Reached Update Department");
			
			String deptName = request.getParameter("deptName");
			
			DepartmentDTO dept = service.findDepartment(deptName);
			
			System.out.println(dept);
			
			
			//RequestDispatcher rd = null;
			request.setAttribute("dept", dept);
			RequestDispatcher rd = request.getRequestDispatcher("../JSP/Admin/EditDepartment.jsp");
			System.out.println(rd);
			rd.forward(request, response);
			
			
		}
		
		if(request.getRequestURI().endsWith("EditDepartment")) {
			System.out.println("Reached Update Department");
			
			Integer deptId = Integer.parseInt(request.getParameter("deptid"));
			String deptName = request.getParameter("deptname");
			String deptHod = request.getParameter("depthod");
			String deptBranch = request.getParameter("deptbranch");
			String deptPassword = request.getParameter("deptpassword");
			
			DepartmentDTO deptDTO = new DepartmentDTO();
			deptDTO.setDeptId(deptId);
			deptDTO.setDeptname(deptName);
			deptDTO.setDeptbranch(deptBranch);
			deptDTO.setDepthod(deptHod);
			deptDTO.setDeptpassword(deptPassword);
			
			String result = service.updateDepartment(deptDTO);
			
			System.out.println("Updateion rEsult :: "+result);
			
			
			//RequestDispatcher rd = null;
			request.setAttribute("result", result);
			RequestDispatcher rd = request.getRequestDispatcher("../../JSP/Admin/DepartmentUpdateResult.jsp");
			System.out.println(rd);
			rd.forward(request, response);
			
			
		}
		
		
		
		

		
	}

}
