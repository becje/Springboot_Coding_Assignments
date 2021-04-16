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
	private final String Get_Family_Query = "SELECT * FROM people";
	private final String Create_New_FamilyMember_Query = "insert into people(people_id, firstName, middleName, lastName, maidenName, gender, birthDate, birthCity, birthState, birthCountry, lifeStatus, deathDate, causeDeath, age, relationshipType) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private final String Get_Individual_By_FirstName_Query = "select * from people where firstName = ?";
	private final String Get_Individual_By_LastName_Query = "select * from people where lastName = ?";
	private final String Update_Individual_By_Id_Query = "update people set firstName=?, middleName=?, lastName=?, maidenName=? where id=?";
	private final String Delete_Individual_By_ID_Query = "delete from people where id = ?";
	
	public PeopleDao() {
		connection = DBConnection.getConnection();
	
	}
	
	public List<People> getFamily() throws SQLException {
		List<People> family = new ArrayList<People>();
		PreparedStatement ps = connection.prepareStatement(Get_Family_Query);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			family.add(new People(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)));
		}
		
		return family;
	}
		
	public List<People> getPersonByFirstName() throws SQLException {
		List<People> firstNames = new ArrayList<People>();
		PreparedStatement ps = connection.prepareStatement(Get_Individual_By_FirstName_Query);
		ResultSet rs = ps.executeQuery();
		
		while (rs.next()) {
			firstNames.add(new People(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)));
		}
		
		return firstNames;
	}
	
	public List<People> getPersonByLastName() throws SQLException {
		List<People> lastNames = new ArrayList<People>();
		PreparedStatement ps = connection.prepareStatement(Get_Individual_By_LastName_Query);
		ResultSet rs = ps.executeQuery();
	
		while (rs.next()) {
			lastNames.add(new People(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9), rs.getString(10), rs.getString(11), rs.getString(12), rs.getString(13), rs.getString(14), rs.getString(15)));
		}
		
		return lastNames;
	}
	public void createNewFamilyMember(int people_id, String firstName, String middleName, String lastName, String maidenName,
			String gender, String birthDate, String birthCity, String birthState, String birthCountry,
			String lifeStatus, String deathDate, String causeDeath, String age, String relationshipType) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Create_New_FamilyMember_Query);
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
		PreparedStatement ps = connection.prepareStatement(Update_Individual_By_Id_Query);
		ps.setInt(1, people_id);
		ps.setString(2, firstName);
		ps.setString(3, middleName);
		ps.setString(4, lastName);
		ps.setString(5, maidenName);
		ps.executeUpdate();
	}
	
	public void deletePersonById(int people_id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(Delete_Individual_By_ID_Query);
		ps.setInt(1, people_id);
		ps.executeUpdate();
	}
	
//	public void close() {
//		DBConnection.getInstance().closeConnection();
//	}
	

}
