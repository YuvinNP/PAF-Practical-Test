package com.caremarque.patient.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
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
	

    /**
     * Default constructor. 
     */
    public PatientAPI() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Patient patient = new Patient();
		
		patient.setFirstName(request.getParameter("firstName"));
		patient.setLastName(request.getParameter("lastName"));
		patient.setGender(request.getParameter("gender"));
		patient.setNIC(request.getParameter("NIC"));
		patient.setDOB(request.getParameter("DOB"));
		patient.setEmail(request.getParameter("email"));
		patient.setPhone(request.getParameter("phone"));
		patient.setBloodGroup(request.getParameter("bloodGroup"));
		patient.setPassword(request.getParameter("password"));
		patient.setConfirmPassword(request.getParameter("cPassword"));
		
		String output = patientObj.registerPatient(patient);
		response.getWriter().write(output);
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private static Map getParasMap(HttpServletRequest request) {
			
			Map<String, String> map = new HashMap<String, String>();
			
			try {
				
				Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
				String queryString = scanner.hasNext() ?
									 scanner.useDelimiter("\\A").next() : "";
				
				scanner.close();
				
				String[] params = queryString.split("&");
				for(String param : params) {
					
					String[] p = param.split("=");
					map.put(p[0], p[1]);
				}
									 
			}
			catch (Exception e) {
				
			}
			return map;
		}

}
