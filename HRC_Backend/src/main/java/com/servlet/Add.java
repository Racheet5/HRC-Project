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
 * Servlet implementation class Add
 */

@WebServlet("/insert")
public class Add extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
    public Add() {
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
		
		String business_code = request.getParameter("business_code");
		//String business_name = request.getParameter("business_name");
	    Integer cust_number = Integer.parseInt(request.getParameter("cust_number"));
       // String name_customer = request.getParameter("name_customer");
        String clear_date = request.getParameter("clear_date");
		String buisness_year = request.getParameter("buisness_year");
		String doc_id = request.getParameter("doc_id");
		String posting_date = request.getParameter("posting_date");
		String document_create_date = request.getParameter("document_create_date");
		//String document_create_date1 = request.getParameter("document_create_date1");
	    String due_in_date = request.getParameter("due_in_date");
		String invoice_currency = request.getParameter("invoice_currency");
		String document_type = request.getParameter("document_type");
		Integer posting_id = Integer.parseInt(request.getParameter("posting_id"));
		//String area_business = request.getParameter("area_business");
		double total_open_amount = Double.parseDouble(request.getParameter("total_open_amount"));
	    String baseline_create_date = request.getParameter("baseline_create_date");
		String cust_payment_terms = request.getParameter("cust_payment_terms");
		Integer invoice_id = Integer.parseInt(request.getParameter("invoice_id"));
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/grey_goose";
			String user = "root";
			String pass ="Rockleone5%";
			
			Connection con = DriverManager.getConnection(url, user, pass);
			String query = "Insert into winter_internship(business_code,cust_number,clear_date,buisness_year,doc_id,posting_date,document_create_date,due_in_date,invoice_currency,document_type,posting_id,total_open_amount,baseline_create_date,cust_payment_terms,invoice_id) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
			PreparedStatement pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, business_code);
			pstmt.setInt(2, cust_number);
			pstmt.setString(3, clear_date);
			pstmt.setString(4, buisness_year);
			pstmt.setString(5, doc_id);
			pstmt.setString(6, posting_date);
			pstmt.setString(7, document_create_date);
		
			pstmt.setString(8, due_in_date);
			pstmt.setString(9, invoice_currency);
			pstmt.setString(10, document_type);
			pstmt.setInt(11, posting_id);
			
			pstmt.setDouble(12, total_open_amount);
			pstmt.setString(13, baseline_create_date);
			pstmt.setString(14, cust_payment_terms);
			pstmt.setInt(15, invoice_id);
			
		 	int result=pstmt.executeUpdate(); 
			
			if(result==1)    
            {    
            pw.println("Values Inserted Successfully");    
            }   
                
        }
		catch(Exception e)
		{    
            e.printStackTrace();
        }       
			
		 pw.close();
	}
	

}
