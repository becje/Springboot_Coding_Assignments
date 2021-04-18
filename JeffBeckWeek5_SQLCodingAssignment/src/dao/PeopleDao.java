package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import entity.People;

public class PeopleDao {
	
	private Connection connection;
	private final String GET_FAMILY_QUERY = "SELECT * FROM people";
	private final String CREATE_NEW_FAMILY_Member_QUERY = "INSERT into people(people_id, firstName, middleName, lastName, maidenName, gender, birthDate, birthCity, birthState, birthCountry, lifeStatus, deathDate, causeDeath, age, relationshipType) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String GET_INDIVIDUAL_BY_FIRST_NAME_QUERY = "SELECT * FROM people WHERE firstName = ?";
	private final String GET_INDIVIDUAL_BY_LAST_NAME_QUERY = "SELECT * FROM people WHERE lastName = ?";
	private final String UPDATE_INDIVIDUAL_BY_ID_QUERY = "UPDATE people SET firstName=?, middleName=?, lastName=?, maidenName=? WHERE people_id=?";
	private final String UPDATE_RELATIONSHIP_QUERY = "UPDATE people SET relationshipType=? WHERE people_id=?";
	private final String DELETE_INDIVIDUAL_BY_ID_QUERY = "DELETE FROM people WHERE people_id = ?";
	
	public PeopleDao() {
		connection = DBConnection.getConnection();
	
	}
	
	public List<People> getFamily() throws SQLException {
		List<People> family = new ArrayList<People>();
		PreparedStatement ps = connection.prepareStatement(GET_FAMILY_QUERY);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			family.add(new People(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)));
		}
		
		return family;
	}
		
	public List<People> getPersonByFirstName(String firstName) throws SQLException {
		List<People> firstNames = new ArrayList<People>();
		PreparedStatement ps = connection.prepareStatement(GET_INDIVIDUAL_BY_FIRST_NAME_QUERY );
		ps.setString(1, firstName);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			firstNames.add(new People(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)));
		}
		
		return firstNames;
	}
	
	public List<People> getPersonByLastName(String lastName) throws SQLException {
		List<People> lastNames = new ArrayList<People>();
		PreparedStatement ps = connection.prepareStatement(GET_INDIVIDUAL_BY_LAST_NAME_QUERY);
		ps.setString(1, lastName);
		ResultSet rs = ps.executeQuery();
	
		while (rs.next()) {
			lastNames.add(new People(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)));
		}
		
		return lastNames;
	}
	public void createNewFamilyMember(int people_id, String firstName, String middleName, String lastName, String maidenName,
			String gender, String birthDate, String birthCity, String birthState, String birthCountry,
			String lifeStatus, String deathDate, String causeDeath, String age, String relationshipType) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_FAMILY_Member_QUERY);
		ps.setInt(1, people_id);
		ps.setString(2, firstName);
		ps.setString(3, middleName);
		ps.setString(4, lastName);
		ps.setString(5, maidenName);
		ps.setString(6, gender);
		ps.setString(7, birthDate);
		ps.setString(8, birthCity);
		ps.setString(9, birthState);
		ps.setString(10, birthCountry);
		ps.setString(11, lifeStatus);
		ps.setString(12, deathDate);
		ps.setString(13, causeDeath);
		ps.setString(14, age);
		ps.setString(15, relationshipType);
		ps.executeUpdate();
	}

	public void updateFamilyMemberName(int people_id, String firstName, String middleName, String lastName, String maidenName) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_INDIVIDUAL_BY_ID_QUERY);
		ps.setInt(1, people_id);
		ps.setString(2, firstName);
		ps.setString(3, middleName);
		ps.setString(4, lastName);
		ps.setString(5, maidenName);
		ps.executeUpdate();
	}
	
	public void updateRelationship(int people_id, String relationshipType) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_RELATIONSHIP_QUERY);
		ps.setInt(1, people_id);
		ps.setString(2, relationshipType);
		ps.executeUpdate();
	}
	
	public void deletePersonById(int people_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_INDIVIDUAL_BY_ID_QUERY);
		ps.setInt(1, people_id);
		ps.executeUpdate();
	}


}
