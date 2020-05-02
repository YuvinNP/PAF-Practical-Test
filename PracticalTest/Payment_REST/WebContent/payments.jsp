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
<script src="Components/main.js"></script>
<title>Payments</title>
</head>
<body>
	<div class="Container" style="padding: 20px;">
		<div class="row">
			<div class="col-6">

				<div class="form-row">
					<div class="form-group col-md-4">
						<label for="inputState">Appointment ID</label> <select
							id="inputState" class="form-control">
							<option selected>Choose...</option>
							<option>...</option>
						</select>
					</div>
					<div class="form-group col-md-4">
						<label for="inputState">Patient ID</label> <select id="inputState"
							class="form-control">
							<option selected>Choose...</option>
							<option>...</option>
						</select>
					</div>
					<div class="form-group col-md-4">
						<label for="inputState">Doctor ID</label> <select id="inputState"
							class="form-control">
							<option selected>Choose...</option>
							<option>...</option>
						</select>
					</div>
				</div>
				<div class="form-group">
					<label for="inputAddress">Patient Name</label> <input type="text"
						class="form-control" id="inputAddress" placeholder="Name">
				</div>
				<div class="form-group">
					<label for="inputAddress2">Address 2</label> <input type="text"
						class="form-control" id="inputAddress2"
						placeholder="Apartment, studio, or floor">
				</div>
				<div class="form-row">
					<div class="form-group col-md-6">
						<label for="inputCity">City</label> <input type="text"
							class="form-control" id="inputCity">
					</div>
					<div class="form-group col-md-4">
						<label for="inputState">State</label> <select id="inputState"
							class="form-control">
							<option selected>Choose...</option>
							<option>...</option>
						</select>
					</div>
					<div class="form-group col-md-2">
						<label for="inputZip">Zip</label> <input type="text"
							class="form-control" id="inputZip">
					</div>
				</div>

			</div>
		</div>
	</div>
	<!-- <div style="padding: 5px;"><hr></div> -->
	<div class="Container" style="padding: 10px;">
		<%
			PaymentServiceImpl paymentServiceImpl = new PaymentServiceImpl();
			out.print(paymentServiceImpl.getPayments());
		%>
	</div>
	<div class="Container" style="padding: 10px;">
		<%
			out.print(paymentServiceImpl.getCanceledPayments());
		%>
	</div>
</body>
</html>