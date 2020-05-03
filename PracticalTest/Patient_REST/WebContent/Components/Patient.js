//Page refresh moment
$(document).ready(function(){
	if($("alertSuccess").text().trim() == "")
	{
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});

//Save
$(document).on("click", "#btnSave", function(event)
{
	//Clear alerts
	$("alertSuccess").text("");
	$("alertSuccess").hide();
	$("alertError").text("");
	$("alertError").hide();
	
	//Form validation
	var status = validateForm();
	if(status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	
	//If valid
	$("#patientSignUp").submit();
});

function validateForm()
{

	
	if($("#fName").val().trim() == "")
	{
		return "Insert First Name...!";
	}
	
	if($("#lName").val().trim() == "")
	{
		return "Insert Last Name...!";
	}
	if($("#gender").val() == "0")
	{
		return "Select Gender...!";
	}
	if($("#NIC").val().trim() == "")
	{
		return "Insert NIC...!";
	}
	if($("#DOB").val().trim() == "")
	{
		return "Insert Date Of Birth...!";
	}
	if($("#bloodGroup").val() == "0")
	{
		return "Select Blood Group...!";
	}
	if($("#email").val().trim() == "")
	{
		return "Insert Email...!";
	}
	if($("#phone").val().trim() == "")
	{
		return "Insert Phone Number...!";
	}
	if($("#password").val().trim() == "")
	{
		return "Insert Password...!";
	}
	if($("#cPassword").val().trim() == "")
	{
		return "Insert Confirm Password...!";
	}
	
	return true;
}
