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
	var type = ($("hidePatientIdSave").val() == "") ? "POST" : "PUT";
	
	$.ajax(
	{
		url : "PatientAPI",
		type : type,
		data : $("patientSignUp").serialize(),
		dataType : "text",
		complete : function(response, status)
		{
			onPatientSaveComplete(response.responseText, status);
		}
	});
	
});

function onPatientSaveComplete(response, status)
{
	if(status == "success")
	{
		var resultSet = JSON.parse(response);
		
		if(resultSet.status.trim() == "success")
		{
			$("#alertSuccess").text("Successfully registered to the system..!");
			$("#alertSuccess").show();
			
			$("divPatientsGrid").html(resultSet.data);
		
		}else if(resultSet.status.trim() == "error")
		{
			$("#alertError").text(resultSet.data);
			 $("#alertError").show(); 
		}
		
	}else if(status == "error")
	{
		$("#alertError").text("Error while saving.");
		 $("#alertError").show(); 
	
	}else
	{
		$("#alertError").text("Unknown error while saving..");
		 $("#alertError").show(); 
	}
	
	$("#hidePatientIdSave").val("");
	 $("#patientSignUp")[0].reset(); 
}

//Update
$(document).on("click", ".btnUpdate", function(event)
{
	$("hidePatientIdSave").val($(this).closest("tr").find('hidePatientIdUpdate').val());
	$("#fName").val($(this).closest("tr").find('td:eq(1)').text());
	$("#lName").val($(this).closest("tr").find('td:eq(2)').text());
	$("#gender").val($(this).closest("tr").find('td:eq(3)').text());
	$("#NIC").val($(this).closest("tr").find('td:eq(4)').text());
	$("#DOB").val($(this).closest("tr").find('td:eq(5)').text());
	$("#bloodGroup").val($(this).closest("tr").find('td:eq(6)').text());
	$("#phone").val($(this).closest("tr").find('td:eq(7)').text());
	$("#password").val($(this).closest("tr").find('td:eq(8)').text());
	$("#cPassword").val($(this).closest("tr").find('td:eq(9)').text());
	
});

////Delete
//$(document).on("click", ".btnRemove", function(event)
//		{
//		 $.ajax(
//		 {
//		 url : "PatientAPI",
//		 type : "DELETE",
//		 data : "patientId=" + $(this).data("patientid"),
//		 dataType : "text",
//		 complete : function(response, status)
//		 {
//		 onPatientDeleteComplete(response.responseText, status);
//		 }
//		 });
//		}); 

//Client-Model
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
