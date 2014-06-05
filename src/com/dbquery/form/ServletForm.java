package com.dbquery.form;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletForm
 */
@WebServlet("/ServletForm")
public class ServletForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		//out.println(request.getParameter("showfields"));
		if(request.getParameter("showfields").equalsIgnoreCase("showDBContents")){
			out.println("ID   Name   Email");
			ArrayList<DatabaseObject> listObjs = DBOperations.getAllObjects();
			for(DatabaseObject obj : listObjs){
				out.println(obj.getID()+"  "+obj.getName()+"  "+obj.getEmail()+"<br>");
			}
		}else if(request.getParameter("showfields").equalsIgnoreCase("addObjectToDB")){
			int retval=DBOperations.addObjectIntoDB(new DatabaseObject(request.getParameter("name"), request.getParameter("email")));
			if(retval > 0){
				out.println("Sucessfully Added the data Into DB");
			}else{
				out.println("Failed to add the data into DB");
			}
		}else if(request.getParameter("showfields").equalsIgnoreCase("searchDB")){
			DatabaseObject obj = DBOperations.getByID(Integer.parseInt(request.getParameter("ID")));
			out.println("ID   Name   Email <br>");
			out.println(obj.getID()+"  "+obj.getName()+"  "+obj.getEmail()+"<br>");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
