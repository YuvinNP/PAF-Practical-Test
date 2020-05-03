package com.caremarque.patient.resource;


import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.parser.Parser;
import com.caremarque.patient.model.Patient;
import com.caremarque.patient.service.PatientServiceImpl;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

@Path("/Patients")
public class PatientService {

	PatientServiceImpl patientServiceImpl = new PatientServiceImpl();
	
	Patient patient = new Patient();
	
	@POST
	@Path("/")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces(MediaType.TEXT_PLAIN)
	public String registerPatient( 			
			@FormParam("firstName") String firstName,
			@FormParam("lastName") String lastName,
			@FormParam("gender") String gender,
			@FormParam("NIC") String nic,
			@FormParam("DOB") String dob,
			@FormParam("email") String email,
			@FormParam("phone") String phone,
			@FormParam("bloodGroup") String bloodGroup,
			@FormParam("password") String password,
			@FormParam("cPassword") String cPassword) {

		
				patient.setFirstName(firstName);
				patient.setLastName(lastName);
				patient.setGender(gender);
				patient.setNIC(nic);
				patient.setDOB(dob);
				patient.setEmail(email);
				patient.setPhone(phone);
				patient.setBloodGroup(bloodGroup);
				patient.setPassword(password);
				patient.setConfirmPassword(cPassword);
		
				return patientServiceImpl.registerPatient(patient);		    		
				
	}
/*
	// getAllPatientDetails
	@GET
	@Path("/")
	@Produces(MediaType.TEXT_HTML)
	public String getAllPatients() {

		return patientServiceImpl.getAllPatients();

	}

	// get a patient detail by Id
	@GET
	@Path("/{patientId}")
	@Produces(MediaType.TEXT_HTML)
	public String getPatientDetail(@PathParam("patientId") int id) {

		return patientServiceImpl.getPatientDetailById(id);

	}

	// delete a patient
	@DELETE
	@Path("/")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.TEXT_PLAIN)
	public String deletePatient(String patientData) {

		Document doc = Jsoup.parse(patientData, "", Parser.xmlParser());

		String patientId = doc.select("patientId").text();

		return patientServiceImpl.deletePatient(patientId);

	}

	// update patient detail
	@PUT
	@Path("/")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String updatePatientDetails(String patientData) {

		JsonObject patientObj = new JsonParser().parse(patientData).getAsJsonObject();

		String patientId = patientObj.get("patientId").getAsString();
		String firstName = patientObj.get("firstName").getAsString();
		String lastName = patientObj.get("lastName").getAsString();
		String gender = patientObj.get("gender").getAsString();
		String nic = patientObj.get("NIC").getAsString();
		String dob = patientObj.get("DOB").getAsString();
		String email = patientObj.get("email").getAsString();
		String phone = patientObj.get("phone").getAsString();
		String bloodGroup = patientObj.get("bloodGroup").getAsString();
		String allergies = patientObj.get("allergies").getAsString();
		String password = patientObj.get("password").getAsString();
		String cPassword = patientObj.get("cPassword").getAsString();

		patient.setPatientId(patientId);
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setGender(gender);
		patient.setNIC(nic);
		patient.setDOB(dob);
		patient.setEmail(email);
		patient.setPhone(phone);
		patient.setBloodGroup(bloodGroup);
		patient.setAllergy(allergies);
		patient.setPassword(password);
		patient.setConfirmPassword(cPassword);

		return patientServiceImpl.updatePatientDetails(patient);

	}
	
//	@PUT
//	@Path("/")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	public String updatePatientDetails(String patientData) {
//
//		JsonObject patientObj = new JsonParser().parse(patientData).getAsJsonObject();
//
//		String patientId = patientObj.get("patientId").getAsString();
//		String firstName = patientObj.get("firstName").getAsString();
//		String lastName = patientObj.get("lastName").getAsString();
//		String gender = patientObj.get("gender").getAsString();
//		String nic = patientObj.get("NIC").getAsString();
//		String dob = patientObj.get("DOB").getAsString();
//		String phone = patientObj.get("phone").getAsString();
//		String bloodGroup = patientObj.get("bloodGroup").getAsString();
//		String allergies = patientObj.get("allergies").getAsString();
//		String password = patientObj.get("password").getAsString();
//		String cPassword = patientObj.get("cPassword").getAsString();
//		
//		patient.setPatientId(patientId);
//		patient.setFirstName(firstName);
//		patient.setLastName(lastName);
//		patient.setGender(gender);
//		patient.setNIC(nic);
//		patient.setDOB(dob);
//		patient.setPhone(phone);
//		patient.setBloodGroup(bloodGroup);
//		patient.setAllergy(allergies);
//		patient.setPassword(password);
//		patient.setConfirmPassword(cPassword);
//
//		return patientServiceImpl.updatePatientDetails(patient);
//
//	}
	
//	// update patient email
//	@PUT
//	@Path("/updateEmail")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.TEXT_PLAIN)
//	public String updatePatientEmail(String patientData) {
//
//		JsonObject patientObj = new JsonParser().parse(patientData).getAsJsonObject();
//
//		String patientId = patientObj.get("patientId").getAsString();
//		String email = patientObj.get("email").getAsString();
//
//		patient.setPatientId(patientId);
//		patient.setEmail(email);
//
//		return patientServiceImpl.updatePatientEmail(patient);
//
//	}*/
}
