//Page refresh moment
$(document).ready(function() {
	if ($("#alertSuccess").text().trim() == "") {
		$("#alertSuccess").hide();
	}
	$("#alertError").hide();
});

$(document).on("click", "#btnSave", function(event) {
	$("#alertSuccess").text("");
	$("#alertSuccess").hide();
	$("#alertError").text("");
	$("#alertError").hide();

	var status = validateForm();
	if (status != true) {
		$("#alertError").text(status);
		$("#alertError").show();
		return;
	}
	//If valid
	var type = ($("#hidPaymentIDSave").val() == "") ? "POST" : "PUT";

	$.ajax({
		url : "PaymentAPI",
		type : type,
		data : $("#formItem").serialize(),
		dataType : "text",
		complete : function(response, status) {
			$("#alertSuccess").text(status);
			$("#alertSuccess").show();
			onPaymentSaveComplete(response.responseText, status);
		}

	});
});

$(document).on("click", ".btnUpdate", function(event)
{	
	$("#hidPaymentIDSave").val($(this).closest("tr").find('#hidPaymentIdUpdate').val());
	$("#patientId").val($(this).closest("tr").find('td:eq(1)').text());
	$("#appointmentId").val($(this).closest("tr").find('td:eq(3)').text());
	$("#doctorId").val($(this).closest("tr").find('td:eq(4)').text());
	$("#hospitalId").val($(this).closest("tr").find('td:eq(5)').text());
	$("#patientName").val($(this).closest("tr").find('td:eq(2)').text());
	$("#email").val($(this).closest("tr").find('td:eq(12)').text());
	$("#telephone").val($(this).closest("tr").find('td:eq(11)').text());
	

})

function validateForm() {

	if ($("#appointmentId").val() == "") {
		return "Select Appointment ID";
	}
	if ($("#patientId").val() == "") {
		return "Select Patient ID";
	}
	if ($("#doctorId").val() == "") {
		return "Select Doctor ID";
	}
	if ($("#hospitalId").val() == "") {
		return "Select Hospital ID";
	}
	if ($("#patientName").val().trim() == "") {
		return "Insert Patient Name";
	}
	if ($("#cardNo").val().trim() == "") {
		return "Insert Card No";
	}
	if ($("#passCode").val().trim() == "") {
		return "Insert Pass Code";
	}
	if ($("#expDate").val().trim() == "") {
		return "Insert Exp Date";
	}
	return true;
}

function onPaymentSaveComplete(response, status) {
	if (status == "success") {
	
		var resultSet = JSON.parse(response);
		
		if (resultSet.status.trim() == "success") {
			$("#alertSuccess").text("Successfully saved.");
			$("#alertSuccess").show();
			$("#divPaymentsGrid").html(resultSet.data);
		} else if (resultSet.status.trim() == "error") {
			$("#alertError").text(resultSet.data);
			$("#alertError").show();
		}
	} else if (status == "error") {
			$("#alertError").text("Error while saving.");
			$("#alertError").show();
	} else 
		{
			$("#alertError").text("Unknown error while saving..");
			$("#alertError").show();
		}
	
		$("#hidPaymentIDSave").val("");
		$("#formItem")[0].reset();

}

$(document).on("click", ".btnRemove", function(event) {
	$.ajax({
		url : "PaymentAPI",
		type : "DELETE",
		data : "paymentID=" + $(this).data("paymentid"),
		dataType : "text",
		complete : function(response, status) {
			onPaymentDeleteComplete(response.responseText, status);
		}
	});
});

function onPaymentDeleteComplete(response, status) {
	if (status == "success") { 
		var resultSet = JSON.parse(response); 
		if (resultSet.status.trim() == "success") { 
			$("#alertSuccess").text("Successfully deleted."); 
			$("#alertSuccess").show(); 
			$("#divItemsGrid").html(resultSet.data); 
		} else if (resultSet.status.trim() == "error") { 
			$("#alertError").text(resultSet.data); 
			$("#alertError").show(); 
		} 
	} else if (status == "error") { 
		$("#alertError").text("Error while deleting."); 
		$("#alertError").show(); 
	} else { 
		$("#alertError").text("Unknown error while deleting.."); 
		$("#alertError").show(); 
	} 
}
