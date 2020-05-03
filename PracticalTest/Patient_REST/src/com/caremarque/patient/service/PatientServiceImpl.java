package com.caremarque.patient.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import com.caremarque.patient.model.Patient;
import com.caremarque.patient.utils.CommonUtils;
import com.caremarque.patient.utils.Constants;
import com.caremarque.patient.utils.DBConnection;
//import com.google.gson.Gson;
//import com.google.gson.JsonElement;
//import com.google.gson.JsonParser;
//import com.google.gson.reflect.TypeToken;
//import com.sun.jersey.api.client.Client;
//import com.sun.jersey.api.client.ClientResponse;
//import com.sun.jersey.api.client.WebResource;


public class PatientServiceImpl implements IPatientService {

	public static final Logger log = Logger.getLogger(PatientServiceImpl.class.getName());

	private static Connection con;

	private static PreparedStatement preparedStmt;

	private static Statement st;

	// to insert patient details to the db
	@Override
	public String registerPatient(Patient patient) {

		String output = "";

		// Here we call the generatePatientIDs method to auto generate a patientId
		String patientId = CommonUtils.generatePatientIDs(getPatientIDs());

		try {

			con = DBConnection.getDBConnection();

			String query = "INSERT INTO patient(patientId, firstName, lastName, gender, NIC, DOB, email, phone, bloodGroup, password, cPassword) "
					+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

			preparedStmt = con.prepareStatement(query);


				patient.setPatientId(patientId);
				preparedStmt.setString(Constants.COLUMN_INDEX_ONE, patient.getPatientId());
				preparedStmt.setString(Constants.COLUMN_INDEX_TWO, patient.getFirstName());
				preparedStmt.setString(Constants.COLUMN_INDEX_THREE, patient.getLastName());
				preparedStmt.setString(Constants.COLUMN_INDEX_FOUR, patient.getGender());
				preparedStmt.setString(Constants.COLUMN_INDEX_FIVE, patient.getNIC());
				preparedStmt.setString(Constants.COLUMN_INDEX_SIX, patient.getDOB());
				preparedStmt.setString(Constants.COLUMN_INDEX_SEVEN, patient.getEmail());
				preparedStmt.setString(Constants.COLUMN_INDEX_EIGHT, patient.getPhone());
				preparedStmt.setString(Constants.COLUMN_INDEX_NINE, patient.getBloodGroup());
				preparedStmt.setString(Constants.COLUMN_INDEX_TEN, patient.getPassword());
				preparedStmt.setString(Constants.COLUMN_INDEX_ELEVEN, patient.getConfirmPassword());

				int result = 0;

				result = preparedStmt.executeUpdate();

				if (result > 0) {

					output = "{\"status\" : \"success\", \"data\" : \"Successfully registered\"}";
				}
			

		} catch (Exception e) {
			
			output = "{\"status\" : \"error\", \"data\" : \"Error while registering to the system..!\"}";
			log.log(Level.SEVERE, e.getMessage());

		} finally {

			try {
				if (preparedStmt != null) {
					preparedStmt.close();
				}

				if (con != null) {
					con.close();
				}
			} catch (Exception e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return output;
	}
	
	// to get all the registerd patients to a arraylist
		@Override
		public ArrayList<String> getPatientIDs() {

			ArrayList<String> patientList = new ArrayList<String>();

			ResultSet rs = null;

			try {
				con = DBConnection.getDBConnection();

				String query = "SELECT patientId FROM patient";

				preparedStmt = con.prepareStatement(query);
				rs = preparedStmt.executeQuery();

				while (rs.next()) {

					patientList.add(rs.getString(1));

				}

			} catch (Exception e) {

				log.log(Level.SEVERE, e.getMessage());

			} finally {
				try {
					if (preparedStmt != null) {
						preparedStmt.close();
					}
					if (con != null) {
						con.close();
					}
				} catch (SQLException e) {
					log.log(Level.SEVERE, e.getMessage());
				}
			}
			return patientList;
		}

	/*// to get details of one patient
	@Override
	public String getPatientDetailById(int patientId) {

		String output = "";
		ResultSet rs = null;

		try {
			con = DBConnection.getDBConnection();

			String query = "SELECT * FROM patient WHERE patientId = '" + patientId + "'";

			st = con.createStatement();
			rs = st.executeQuery(query);

			output = "<table border=\"1\"> " + "<tr>" + "<th>Patient Id</th> " + "<th>First Name</th> "
					+ "<th>Last Name</th> " + "<th>Gender</th> " + "<th>NIC</th> " + "<th>DOB</th> " + "<th>Email</th> "
					+ "<th>Phone</th> " + "<th>Blood Group</th> " + "<th>Allergies</th> " + "<th>Password</th> "
					+ "</tr>";

			while (rs.next()) {

				String paId = rs.getString("patientId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String gender = rs.getString("gender");
				String nic = rs.getString("NIC");
				String dob = rs.getString("DOB");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String bloodGroup = rs.getString("bloodGroup");
				String password = rs.getString("password");

				output += "<tr><td><input id = 'hidePatientIdUpdate' name = 'hidePatientIdUpdate' type='hidden' value = '" + paId + "'>" + paId + "</td>";
				output += "<td>" + firstName + "</td>";
				output += "<td>" + lastName + "</td>";
				output += "<td>" + gender + "</td>";
				output += "<td>" + nic + "</td>";
				output += "<td>" + dob + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + phone + "</td>";
				output += "<td>" + bloodGroup + "</td>";
				output += "<td>" + password + "</td>";
				output += "<td><input name = 'btnUpdate' type = 'button' value = 'Update' class = 'btnUpdate btn btn-secondary'></td>"
						+ "<td><input name = 'btnRemove' type = 'button' value = 'Remove' class = 'btnRemove btn btn-danger' data-patientid = '"+ paId +"'>" 
						+ "</td></tr>";
						

			}
			// Complete the html table
			output += "</table>";

		} catch (Exception e) {

			output = "Error while reading the patient details...!";
			log.log(Level.SEVERE, e.getMessage());

		} finally {

			try {
				if (st != null) {
					st.close();
				}

				if (con != null) {
					con.close();
				}

				if (rs != null) {
					rs.close();
				}

			} catch (Exception e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return output;

	}*/

	// to get details of all the registered patients
	@Override
	public String getAllPatients() {

		String output = "";
		ResultSet rs = null;

		try {
			con = DBConnection.getDBConnection();

			String query = "SELECT patientId, firstName, lastName, gender, NIC, DOB, email, phone, bloodGroup, password  FROM patient";

			st = con.createStatement();
			rs = st.executeQuery(query);

			output = "<table border= '1'>" +
					 "<tr><th>Patient Id</th>" + "<th>First Name</th>" + "<th>Last Name</th>" +
					 "<th>Gender</th>" + "<th>NIC</th>" + "<th>DOB</th>" + "<th>Email</th>" +
					 "<th>Phone</th>" + "<th>Blood Group</th>" + "<th>Password</th>" + "<th>Update</th>" + "<th>Remove</th></tr>";

			while (rs.next()) {

				String patientId = rs.getString("patientId");
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				String gender = rs.getString("gender");
				String nic = rs.getString("NIC");
				String dob = rs.getString("DOB");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				String bloodGroup = rs.getString("bloodGroup");
				String password = rs.getString("password");

				output += "<tr><td><input id = 'hidePatientIdUpdate' name = 'hidePatientIdUpdate' type='hidden' value = '" + patientId + "'>" + patientId + "</td>";
				output += "<td>" + firstName + "</td>";
				output += "<td>" + lastName + "</td>";
				output += "<td>" + gender + "</td>";
				output += "<td>" + nic + "</td>";
				output += "<td>" + dob + "</td>";
				output += "<td>" + email + "</td>";
				output += "<td>" + phone + "</td>";
				output += "<td>" + bloodGroup + "</td>";
				output += "<td>" + password + "</td>";
				output += "<td><input name = 'btnUpdate' type = 'button' value = 'Update' class = 'btnUpdate btn btn-secondary'></td>"
						+ "<td><input name = 'btnRemove' type = 'button' value = 'Remove' class = 'btnRemove btn btn-danger' data-patientid = '"+ patientId +"'>" 
						+ "</td></tr>";

			}
			// Complete the html table
			output += "</table>";

		} catch (Exception e) {

			output = "Error while reading the patient details...!";
			log.log(Level.SEVERE, e.getMessage());

		} finally {

			try {
				if (st != null) {
					st.close();
				}

				if (con != null) {
					con.close();
				}

				if (rs != null) {
					rs.close();
				}

			} catch (Exception e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}
		return output;

	}

	// to update patient details
	@Override
	public String updatePatientDetails(Patient patient) {

		String output = "";

		try {

			con = DBConnection.getDBConnection();

			String query = "UPDATE patient SET firstName=?, lastName=?, gender=?, NIC=?, DOB=?, phone=?, bloodGroup=?, allergies=?, password=?, cPassword=?"
					+ " WHERE patientId=? ";
			

			preparedStmt = con.prepareStatement(query);
			
			preparedStmt.setString(Constants.COLUMN_INDEX_ONE, patient.getFirstName());
			preparedStmt.setString(Constants.COLUMN_INDEX_TWO, patient.getLastName());
			preparedStmt.setString(Constants.COLUMN_INDEX_THREE, patient.getGender());
			preparedStmt.setString(Constants.COLUMN_INDEX_FOUR, patient.getNIC());
			preparedStmt.setString(Constants.COLUMN_INDEX_FIVE, patient.getDOB());
			preparedStmt.setString(Constants.COLUMN_INDEX_SIX, patient.getPhone());
			preparedStmt.setString(Constants.COLUMN_INDEX_SEVEN, patient.getBloodGroup());
			preparedStmt.setString(Constants.COLUMN_INDEX_EIGHT, patient.getPassword());
			preparedStmt.setString(Constants.COLUMN_INDEX_NINE, patient.getConfirmPassword());
			preparedStmt.setString(Constants.COLUMN_INDEX_TEN, patient.getPatientId());
			
			preparedStmt.execute();
			
			String newPatient = getAllPatients();
			 output = "{\"status\":\"success\", \"data\": \"" + newPatient + "\"}"; 
			
		} catch (Exception e) {

			output = "{\"status\":\"error\", \"data\":\"Error while updating the patient details..!\"}"; 
			log.log(Level.SEVERE, e.getMessage());

		} finally {

			try {
				if (preparedStmt != null) {
					preparedStmt.close();
				}

				if (con != null) {
					con.close();
				}

			} catch (Exception e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return output;
	}
	
	// to delete a patient from the system
	@Override
	public String deletePatient(String patientId) {

		String output = "";

		try {

			con = DBConnection.getDBConnection();

			String query = "DELETE FROM patient WHERE patientId = ?";

			preparedStmt = con.prepareStatement(query);

			preparedStmt.setString(Constants.COLUMN_INDEX_ONE, patientId);

			preparedStmt.execute();

			String newPatient = getAllPatients();
			output = "{\"status\":\"success\", \"data\": \"" + newPatient + "\"}"; 

		} catch (Exception e) {

			output = "{\"status\":\"error\", \"data\":\"Error while deleting the patient account..!\"}"; 
			log.log(Level.SEVERE, e.getMessage());

		} finally {

			try {
				if (preparedStmt != null) {
					preparedStmt.close();
				}

				if (con != null) {
					con.close();
				}

			} catch (Exception e) {
				log.log(Level.SEVERE, e.getMessage());
			}
		}

		return output;
	}

	

}
