package com.caremarque.payment.servlet;

import java.io.IOException;
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
		System.out.println("PAYMENT API");
		doGet(request, response);
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
		paymentServiceImpl.createPayement(payment);
}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
