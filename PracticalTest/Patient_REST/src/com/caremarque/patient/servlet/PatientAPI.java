package com.caremarque.patient.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caremarque.patient.model.Patient;
import com.caremarque.patient.service.PatientServiceImpl;

/**
 * Servlet implementation class PatientAPI
 */
@WebServlet("/PatientAPI")
public class PatientAPI extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	PatientServiceImpl patientObj = new PatientServiceImpl();
	Patient patient = new Patient();

    /**
     * Default constructor. 
     */
    public PatientAPI() {
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		patientObj.registerPatient(
//				request.getParameter("firstName"),
//				request.getParameter("lastName"),
//				request.getParameter("gender"),
//				request.getParameter("NIC"),
//				request.getParameter("DOB"),
//				request.getParameter("email"),
//				request.getParameter("phone"),
//				request.getParameter("bloodGroup"),
//				request.getParameter("password"),
//				request.getParameter("cPassword"),
//				request.getParameter("firstName"));
		
		String output = patientObj.registerPatient(patient);
		response.getWriter().write(output);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
