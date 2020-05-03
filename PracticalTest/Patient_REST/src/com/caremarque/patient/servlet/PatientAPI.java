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
	
	PatientServiceImpl patientServiceImpl = new PatientServiceImpl();
	

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
		
		String output = patientServiceImpl.registerPatient(patient);
		response.getWriter().write(output);
		
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

//		Map paras = getParasMap(request);
//		
//		paras.get("hidePatientIdSave").toString();
//		paras.get("firstName").toString();
//		paras.get("lastName").toString();
//		paras.get("gender").toString();
//		paras.get("NIC").toString();
//		paras.get("DOB").toString();
//		paras.get("email").toString();
//		paras.get("phone").toString();
//		paras.get("bloodGroup").toString();
//		paras.get("password").toString();
//		paras.get("cPassword").toString();
//		
//		String output = patientObj.updatePatientDetails(paras);
		
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request);
		
		String output = patientServiceImpl.deletePatient(paras.get("patientId").toString());
		
		response.getWriter().write(output);
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
