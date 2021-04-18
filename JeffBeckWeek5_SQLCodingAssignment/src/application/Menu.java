package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.PeopleDao;
import entity.People;

public class Menu {
	
	private PeopleDao peopleDao = new PeopleDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Add New Family Member",
			"Display Family",
			"Display Family Members by First Name",
			"Display Family Members by Last Name",
			"Update Family Members Name",
			"Update Relationship Status",
			"Delete a Family Member");
	
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try { 
				if (selection.equals("1")) {
					createNewFamilyMember();
				} else if (selection.equals("2")) {
					displayFamily();
				} else if (selection.equals("3")) {
					lookUpPersonByFirstName();
				} else if (selection.equals("4")) {
					lookUpPersonByLasttName();
				} else if (selection.equals("5")) {
					updateFamilyMemberName();
				} else if (selection.equals("6")) {
					updateRelationship();
				} else if (selection.equals("7")) {
					deleteFamilyMember();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}				
			
			System.out.println("Press enter to continue......");
			scanner.nextLine();
		} while (!selection.equals("-1"));
	}
		
		private void printMenu() {
			System.out.println("Select an Option:\n------------------------------");
			for(int i=0; i < options.size(); i++) {
				System.out.println(i + 1 + ") " + options.get(i));
		}
	}
		private void createNewFamilyMember() throws SQLException {			
			System.out.println("Enter a numerical unique ID for the new family member: ");
			int people_id = Integer.parseInt(scanner.nextLine());
			System.out.println("Enter first name of new family member: ");
			String firstName = scanner.nextLine();
			System.out.println("Enter middle name of new family member: ");
			String middleName = scanner.nextLine();
			System.out.println("Enter last name of new family member: ");
			String lastName = scanner.nextLine();
			System.out.println("Enter maiden name of new family member. Otherwise press enter to continue: ");
			String maidenName = scanner.nextLine();
			System.out.println("Enter gender of new family member: ");
			String gender = scanner.nextLine();
			System.out.println("Enter the new family members birthday: ");
			String birthDate = scanner.nextLine();
			System.out.println("Enter the city the new family member was born in: ");
			String birthCity = scanner.nextLine();
			System.out.println("Enter the state the new family member was born in: ");
			String birthState = scanner.nextLine();
			System.out.println("Enter the country the new family member was born in: ");
			String birthCountry = scanner.nextLine();
			System.out.println("Is this individual is Deceased or Living: ");
			String lifeStatus = scanner.nextLine();
			System.out.println("If the individual is deceased enter the date he/she passed away. Otherwise press enter to continue: ");
			String deathDate = scanner.nextLine();
			System.out.println("If the individual is deceased enter the cause of death. Otherwise press enter to continue: ");
			String causeDeath = scanner.nextLine();
			System.out.println("Enter the age of the new family member as of today. If deceased enter how old he/she was at time of death: ");
			String age = scanner.nextLine();
			System.out.println("Enter your relationship with the new family member: ");
			String relationshipType = scanner.nextLine();
			peopleDao.createNewFamilyMember(people_id, firstName, middleName, lastName, maidenName, gender, birthDate, birthCity, birthState, birthCountry, lifeStatus, deathDate, causeDeath, age, relationshipType);
			
			}
		private void displayFamily() throws SQLException {
			List<People> myFamily = peopleDao.getFamily();
			for (People person : myFamily) {
				System.out.println(
					person.getPeopleId() + ": " + " - Name: " +
					person.getFirstName() + " " +
					person.getMiddleName() + " " +  
					person.getLastName() + " " + 
					person.getMaidenName() + " " + "\n - Gender: " +
					person.getGender() + " " + "\n - Birthday: " +  
					person.getBirthDate() + " " + "\n - City of Birth: " +
					person.getBirthCity() + " " + "\n - State of Birth: " +
					person.getBirthState() + " " + "\n - Country of Birth: " +
					person.getBirthCountry() + " " + "\n - Decease or Living: " + 
					person.getLifeStatus() + " " + "\n - Date of Death: " +
					person.getDeathDate() + " " + "\n - Cause of Death: " +
					person.getCauseDeath() + " " + "\n - Age: " +
					person.getAge() + " " + "\n - Relationship: " +
					person.getRelationshipType());
			}
		}
		
		private void lookUpPersonByFirstName() throws SQLException {
			System.out.println("Type in a first name to show all family members with the same first name: ");
			String firstNames = scanner.nextLine();
			List<People> fName = peopleDao.getPersonByFirstName(firstNames);
			for (People p : fName) {
				System.out.println(
					p.getPeopleId() + ": " + " - Name: " +
					p.getFirstName() + " " +
					p.getMiddleName() + " " +  
					p.getLastName() + " " + 
					p.getMaidenName() + " " + "\n - Gender: " +
					p.getGender() + " " + "\n - Birthday: " +  
					p.getBirthDate() + " " + "\n - City of Birth: " +
					p.getBirthCity() + " " + "\n - State of Birth: " +
					p.getBirthState() + " " + "\n - Country of Birth: " +
					p.getBirthCountry() + " " + "\n - Decease or Living: " + 
					p.getLifeStatus() + " " + "\n - Date of Death: " +
					p.getDeathDate() + " " + "\n - Cause of Death: " +
					p.getCauseDeath() + " " + "\n - Age: " +
					p.getAge() + " " + "\n - Relationship: " +
					p.getRelationshipType());
			}
		}
		
		private void lookUpPersonByLasttName() throws SQLException {
			System.out.println("Type in a last name to show all family members with the same first name: ");
			String lastNames = scanner.nextLine();
			List<People> lName = peopleDao.getPersonByLastName(lastNames);
			for (People p : lName) {
				System.out.println(
					p.getPeopleId() + ": " + " - Name: " +
					p.getFirstName() + " " +
					p.getMiddleName() + " " +  
					p.getLastName() + " " + 
					p.getMaidenName() + " " + "\n - Gender: " +
					p.getGender() + " " + "\n - Birthday: " +  
					p.getBirthDate() + " " + "\n - City of Birth: " +
					p.getBirthCity() + " " + "\n - State of Birth: " +
					p.getBirthState() + " " + "\n - Country of Birth: " +
					p.getBirthCountry() + " " + "\n - Decease or Living: " + 
					p.getLifeStatus() + " " + "\n - Date of Death: " +
					p.getDeathDate() + " " + "\n - Cause of Death: " +
					p.getCauseDeath() + " " + "\n - Age: " +
					p.getAge() + " " + "\n - Relationship: " +
					p.getRelationshipType());
			}
		}
		
		private void updateRelationship() throws SQLException {
			System.out.println("Enter ID of family member you wish to update: ");
			String n1 = scanner.nextLine();
			Integer people_id = null;
			try {
				people_id = Integer.parseInt(n1);
			} catch(NumberFormatException e) {
				System.out.println("Please enter the ID of the family member.");
				return;
			}
			if (people_id !=null) {
				System.out.println("Please update status to the Relationship: ");
				String relationshipType = scanner.nextLine();
				peopleDao.updateRelationship(people_id, relationshipType);
			}
		}
		
		private void updateFamilyMemberName() throws SQLException {
			System.out.println("Enter ID of family members name you wish to update: ");
			String n1 = scanner.nextLine();
			Integer people_id = null;
			try {
				people_id = Integer.parseInt(n1);
			} catch (NumberFormatException e) {
				System.out.println("Please enter the ID of the family member.");
				return;
			}
			if (people_id != null) {
					System.out.println("Please update the First Name or press enter to continue: ");
					String firstName = scanner.nextLine();
				if (!firstName.isEmpty()) {
					System.out.println("Please update the Middle Name or press enter to continue:  ");
					String middleName = scanner.nextLine();
				if (!middleName.isEmpty()) {
					System.out.println("Please update the Last name or press enter to continue: ");
					String lastName = scanner.nextLine();
				if (!lastName.isEmpty()) {
					System.out.println("Please update the Maiden Name or press enter to continue: ");
					String maidenName = scanner.nextLine();
				if (!maidenName.isEmpty()) {
					peopleDao.updateFamilyMemberName(people_id, firstName, middleName, lastName, maidenName);
					}
				}
			}
		}
	}
}
				private void deleteFamilyMember() throws SQLException {
				System.out.println("Enter the ID of the family member you want to delete: ");
				int people_id = Integer.parseInt(scanner.nextLine());
				peopleDao.deletePersonById(people_id);
			}
			
}
