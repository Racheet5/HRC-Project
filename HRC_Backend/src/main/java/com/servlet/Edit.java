package com.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Servlet implementation class Edit
 */
@WebServlet("/edit")
public class Edit extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Edit() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PrintWriter pw;
		response.setContentType("text/html");
		pw = response.getWriter();
		
		Integer sl_no = Integer.parseInt(request.getParameter("sl_no"));
		String invoice_currency = request.getParameter("invoice_currency");
		
		String cust_payment_terms = request.getParameter("cust_payment_terms");
		
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/grey_goose";
			String user = "root";
			String pass ="Rockleone5%";
			
			Connection con = DriverManager.getConnection(url, user, pass);
			String query = "UPDATE winter_internship SET invoice_currency = ?,cust_payment_terms = ? WHERE sl_no = ?;";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, invoice_currency);
			pstmt.setString(2, cust_payment_terms);
			pstmt.setInt(3, sl_no);
			
			
		 	int result=pstmt.executeUpdate(); 
			
			if(result>0)    
            {    
            pw.println("Updated values Successfully");    
            }   
                
        }
		catch(Exception e)
		{    
            e.printStackTrace();
        }       
			
		 pw.close();
	}
	
	

}
