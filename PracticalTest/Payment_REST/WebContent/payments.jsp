<%@page import="com.caremarque.payment.service.PaymentServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="Views/bootstrap.min.css">
<link rel="stylesheet" href="Views/payments.css">
<link
	href="https://fonts.googleapis.com/css2?family=Roboto:wght@100&display=swap"
	rel="stylesheet">
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/payments.js"></script>
<title>Payments</title>
</head>
<body>
	<%
		PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
	%>
	<div class="Container" style="padding: 30px;">
		<div class="row">
			<div class="col-6">
				<div class="Container cancel-title"
					style="padding: 10px; background-color: #008AD9; font-weight: bold;">
					<label style="color: white">CREATE PAYMENTS</label>
				</div>
				<form action="" style="padding: 10px;">
					<div class="form-row">
						<div class="form-group col-md-3">
							<label for="inputState">Appointment ID:</label> <select
								id="appointmentId" name="appointmentId" class="form-control">
								<option selected>Choose...</option>
								<option>APP001</option>
								<option>APP002</option>
								<option>APP003</option>
							</select>
						</div>
						<div class="form-group col-md-3">
							<label for="inputState">Patient ID:</label> <select
								id="patientId" name="patientId" class="form-control">
								<option selected>Choose...</option>
								<option>P101</option>
								<option>P102</option>
								<option>P103</option>
							</select>
						</div>
						<div class="form-group col-md-3">
							<label for="inputState">Doctor ID:</label> <select id="doctorId"
								name="doctorId" class="form-control">
								<option selected>Choose...</option>
								<option>D202</option>
								<option>D203</option>
								<option>D204</option>
							</select>
						</div>
						<div class="form-group col-md-3">
							<label for="inputState">Hospital ID:</label> <select id="hospitalId"
								name="hospitalId" class="form-control">
								<option selected>Choose...</option>
								<option>H202</option>
								<option>H203</option>
								<option>H204</option>
							</select>
						</div>
					</div>
					<div class="form-group">
						<label for="inputAddress">Patient Name:</label> <input type="text"
							class="form-control" id="patientName" name="patientName"
							placeholder="Name">
					</div>
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="inputCity">Card No:</label> <input type="text"
								class="form-control" id="cardNo" name="cardNo"
								placeholder="XXXX-XXXX-XXXX-XXXX">
						</div>
						<div class="form-group col-md-4">
							<label for="inputCity">Passcode:</label> <input type="text"
								class="form-control" id="passCode" name="passCode" placeholder="XXX">
						</div>
						<div class="form-group col-md-4">
							<label for="inputCity">EXP Date:</label> <input type="text"
								class="form-control" id="expDate" name="expDate" placeholder="12/22">
						</div>
					</div>
					
					<div class="form-row">
						<div class="form-group col-md-4">
							<label for="inputCity">Hospital Charges:</label> <input
								type="text" class="form-control" id="hospitalCharges" name="hospitalCharges"
								placeholder="0.00" readonly>
						</div>
						<div class="form-group col-md-4">
							<label for="inputCity">Doctor Charges:</label> <input type="text"
								class="form-control" id="doctorCharges" name="doctorCharges" placeholder="0.00" readonly>
						</div>
						<div class="form-group col-md-4">
							<label for="inputCity">Total Amount:</label> <input type="text"
								class="form-control" id="totalAmount" name="totalAmount" placeholder="0.00" readonly>
						</div>
					</div>
					<div class="form-row">
						<div class="form-group col-md-6">
							<label for="inputCity">Email:</label> <input type="text"
								class="form-control" id="email" name="email"
								placeholder="sampleuser@email.com">
						</div>
						<div class="form-group col-md-6">
							<label for="inputCity">Telephone:</label> <input type="text"
								class="form-control" id="telephone" name="telephone" placeholder="07XXXXXXXX">
						</div>

					</div>
					<div class="form-group">
						<input type="button"  id="btnSave" name="btnSave" value="Save" class="btn btn-success">
					 	<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
					</div>
					<!-- <div class="form-group">
						 <input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-success">
						 <input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value="">
					 </div> -->
				</form>
				<div id="alertSuccess" class="alert alert-success" style="font-weight: bold"></div>
				<div id="alertError" class="alert alert-danger" style="font-weight: bold"></div>

			</div>

			<div class="col-md-6">
				<div class="Container"
					style="padding: 10px; background-color: #008AD9; font-weight: bold;">
					<label style="color: white;"> CANCELED PAYMENTS</label>
				</div>
				<div class="Container" style="padding: 10px;">
					<%
						out.print(paymentServiceImpl.getCanceledPayments());
					%>
				</div>
			</div>
		</div>
	</div>
	<!-- <div style="padding: 5px;"><hr></div> -->

	<div class="Container"
		style="padding-top: 5px; padding-right: 30px; padding-left: 30px; padding-bottom: 30px">
		<div class="Container cancel-title"
			style="padding: 10px; background-color: #008AD9; font-weight: bold;">
			<label style="color: white"> ACTIVE PAYMENTS</label>
		</div>
		<%
			out.print(paymentServiceImpl.getPayments());
		%>
	</div>

</body>
</html>