//Page refresh moment
$(document).ready(function(){
	if($("alertSuccess").text().trim() == "")
	{
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});

$(document).on("click", "#btnSave", function(event)
{
	$("alertSuccess").text("");
	$("alertSuccess").hide();
	$("alertError").text("");
	$("alertError").hide();
	
	var status = validateForm();
	if(status != true)
	{
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
});

function validateForm()
{

	if($("#patientName").val().trim() == "")
	{
		return "Insert Patient Name";
	}
	if($("#appointmentId").val().trim() == "")
	{
		return "Select Appointment ID";
	}
	if($("#patientId").val().trim() == "")
	{
		return "Select Patient ID";
	}
	if($("#doctorId").val().trim() == "")
	{
		return "Select Doctor ID";
	}
	if($("#hospitalId").val().trim() == "")
	{
		return "Select Hospital ID";
	}
	if($("#cardNo").val().trim() == "")
	{
		return "Insert Card No";
	}
	if($("#passCode").val().trim() == "")
	{
		return "Insert Pass Code";
	}
	if($("#expDate").val().trim() == "")
	{
		return "Insert Exp Date";
	}
	
	return true;
}
