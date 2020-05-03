<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="com.caremarque.patient.service.PatientServiceImpl" %>
    
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<title>Patient Service</title>

<!-- CSS -->
<link rel="stylesheet" href="Views/bootstrap.min.css">

<!-- JS -->
<script src="Components/jquery-3.2.1.min.js"></script>
<script src="Components/Patient.js" type="text/javascript"></script>

</head>

<body>

<div class="container">
<div class = "row">
<div class = "col-6">



<form name="patientSignUp" id="patientSignUp">

<h4>Create Your Account</h4>

	<div id = "alertSuccess" class = "alert alert-success"></div>
	<div id = "alertError" class = "alert alert-danger"></div>


	<h5>Profile Information</h5>

	<label>First Name<label_1>*</label_1></label><br/>
		<input type="text" placeholder="Enter First Name" name="fName" id="fName" class="form-control form-control-sm"><br/>
		
	<label>Last Name<label_1>*</label_1></label><br/>
		<input type="text" placeholder="Enter Last Name" name="lName" id="lName" class="form-control form-control-sm"><br/>
	
	<label>Gender<label_1>*</label_1></label><br/>
		<select name="gender" id="gender" class="form-control form-control-sm">
			<option value="0">Select Gender</option>
			<option value="M">Male</option>
			<option value="F">Female</option>
		</select><br/>	
		
	<label>NIC<label_1>*</label_1></label><br/>
		<input type="text" placeholder="Enter NIC Number" name="NIC" id="NIC" class="form-control form-control-sm"><br/>

	<label>Date Of Birth<label_1>*</label_1></label><br/>
		<input type="text" placeholder="Enter Date Of Birth" name="DOB" id="DOB" class="form-control form-control-sm"><br/>	
	
	<label>Blood Group<label_1>*</label_1></label><br/>
		<select name="bloodGroup" id="bloodGroup" class="form-control form-control-sm">
			<option value="0">Select Blood Group</option>
			<option value="A+">A+</option>
			<option value="A-">A-</option>
			<option value="B+">B+</option>
			<option value="B-">B-</option>
			<option value="AB">AB</option>
			<option value="O+">O+</option>
			<option value="O-">O-</option>
		</select><br/>	
		
	<h4>Contact Information</h4>

	<label>Email<label_1>*</label_1></label><br/>
		<input type="text" placeholder="Enter Email" name="email" id="email" class="form-control form-control-sm"><br/>
	
	<label>Telephone Number<label_1>*</label_1></label><br/>
		<input type="text" placeholder="Enter Telephone Number" name="phone" id="phone" class="form-control form-control-sm"><br/>
		
	<h2>Login Information</h2>

	<label>Password<label_1>*</label_1></label><br/> 
		<input type="password" placeholder="Enter Password" name="password" id="password" class="form-control form-control-sm"><br/> 
		
	<label>Confirm Password<label_1>*</label_1></label><br/>
		<input type="password" placeholder="confirm Password" name="cPassword" id="cPassword" class="form-control form-control-sm"><br/>
		
	<hr>

	<p>
		By creating an account you agree to our <a href="#"><b>Terms & Privacy Policy</b></a>
	</p>
	<br />	
	
	<input id = "btnSave" name="btnSave" type = "button" value="Sign Up" class = "btn btn-primary">
	<input type = "hidden" id = "hidePatientIdSave" name = "hidePatientIdSave" value = "">
	<br />
	
	<p style="margin-top: 1%;">Already you are a member?<a href="#"><b>Sign in</b></a></p>
	<br />		
</form>

</div>
</div>
</div>

<div id="divPatientsGrid">
 <%
 PatientServiceImpl patientObj = new PatientServiceImpl();
 out.print(patientObj.getAllPatients());
 %>
</div>

</body>
</html>