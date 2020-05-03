package com.caremarque.payment.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.caremarque.payment.model.Payment;
import com.caremarque.payment.service.PaymentServiceImpl;

/**
 * Servlet implementation class PaymentAPI
 */
@WebServlet("/PaymentAPI")
public class PaymentAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public PaymentAPI() {
        // TODO Auto-generated constructor stub
    }
    
    private static Map getParasMap(HttpServletRequest request)
    {
    	System.out.println("HEre");
    	Map<String, String> map = new HashMap<String, String>();
    	try {
			Scanner scanner = new Scanner(request.getInputStream(), "UTF-8");
			String queryString = scanner.hasNext() ? scanner.useDelimiter("\\A").next() : "";
			
			scanner.close();
			
			String[] params = queryString.split("&");
			for (String param : params) {
				String[] p = param.split("=");
				map.put(p[0], p[1]);
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
    	
    	return map;
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("PAYMENT API");
		Payment payment = new Payment();
		payment.setPatientId(request.getParameter("patientId"));
		payment.setPatientName(request.getParameter("patientName"));
		payment.setAppointmentId(request.getParameter("appointmentId"));
		payment.setDoctorId(request.getParameter("doctorId"));
		payment.setHospitalId(request.getParameter("hospitalId"));
		payment.setDoctorCharges(Double.parseDouble(request.getParameter("doctorCharges")));
		payment.setHospitalCharges(Double.parseDouble(request.getParameter("hospitalCharges")));
		payment.setCardNo(request.getParameter("cardNo"));
		payment.setPassCode(request.getParameter("passCode"));
		payment.setExpDate(request.getParameter("expDate"));
		payment.setTelPhone(request.getParameter("telephone"));
		payment.setEmail(request.getParameter("email"));
		payment.setPaymentStatus("active");
		
		PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
		String output = paymentServiceImpl.createPayement(payment);
		System.out.println(output);
		response.getWriter().write(output);
}		

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
		
		Map paras = getParasMap(request);
		System.out.println("paymeint id: " + paras.get("hidPaymentIDSave").toString());
		System.out.println("paymeint id: " + paras.get("telephone").toString());
		System.out.println("paymeint id: " + paras.get("email").toString());


		//		System.out.println(request.getParameter("hidPaymentIDSave"));
//		System.out.println(request.getParameter("telephone"));
//		System.out.println(request.getParameter("email"));
		String output = paymentServiceImpl.updatePayment(paras.get("hidPaymentIDSave").toString(),
				paras.get("telephone").toString(), paras.get("email").toString());
//		
		response.getWriter().write(output);
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
		
		Map paras = getParasMap(request);
		
		String output = paymentServiceImpl.cancelPayment(paras.get("paymentId").toString());
	}

}
