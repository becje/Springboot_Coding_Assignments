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
				} else if (selection.equals("6")) {
					updateFamilyMemberName();
				} else if (selection.equals("5")) {
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
			System.out.println("Enter a numberical unique ID for the new family member: ");
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
			List<People> firstNames = peopleDao.getPersonByFirstName();
			for (People fName : firstNames) {
				System.out.println(
					fName.getPeopleId() + ": " + " - Name: " +
					fName.getFirstName() + " " +
					fName.getMiddleName() + " " +  
					fName.getLastName() + " " + 
					fName.getMaidenName() + " " + "\n - Gender: " +
					fName.getGender() + " " + "\n - Birthday: " +  
					fName.getBirthDate() + " " + "\n - City of Birth: " +
					fName.getBirthCity() + " " + "\n - State of Birth: " +
					fName.getBirthState() + " " + "\n - Country of Birth: " +
					fName.getBirthCountry() + " " + "\n - Decease or Living: " + 
					fName.getLifeStatus() + " " + "\n - Date of Death: " +
					fName.getDeathDate() + " " + "\n - Cause of Death: " +
					fName.getCauseDeath() + " " + "\n - Age: " +
					fName.getAge() + " " + "\n - Relationship: " +
					fName.getRelationshipType());
			}
		}
		private void lookUpPersonByLasttName() throws SQLException {
			List<People> lastNames = peopleDao.getPersonByLastName();
			for (People lName : lastNames) {
				System.out.println(
					lName.getPeopleId() + ": " + 
					lName.getFirstName() + " " + 
					lName.getMiddleName() + " " +  
					lName.getLastName() + " " + 
					lName.getMaidenName() + " " + 
					lName.getBirthDate() + " " +
					lName.getBirthCity() + " " +
					lName.getBirthState() + " " +
					lName.getBirthCountry() + " " +
					lName.getLifeStatus() + " " +
					lName.getDeathDate() + " " +
					lName.getCauseDeath() + " " +
					lName.getAge() + " " +
					lName.getRelationshipType());
			}
		}

		private void updateFamilyMemberName() throws SQLException {
			System.out.println("Enter ID of family members name you wish to update: ");
			String n1 = scanner.nextLine();
			Integer people_id = null;
			try {
				people_id = Integer.parseInt(n1);
			} catch (NumberFormatException e) {
				System.out.println("Please enter the ID of the the family member.");
				return;
			}
			if (people_id != null) {
				System.out.println("Please enter the required information");
				String firstName = scanner.nextLine();
				String middleName = scanner.nextLine();
				String lastName = scanner.nextLine();
				String maidenName = scanner.nextLine();
			if (!firstName.isEmpty() || !middleName.isEmpty() && !lastName.isEmpty() || !maidenName.isEmpty()) {
				peopleDao.updateFamilyMemberName(people_id, firstName, middleName, lastName, maidenName);
			}
		}	
	}
			private void deleteFamilyMember() throws SQLException {
				System.out.println("Enter the ID of the family member you want to delete: ");
				int people_id = Integer.parseInt(scanner.nextLine());
				peopleDao.deletePersonById(people_id);
			}
			
//			public void end() {
//			System.out.println("Goodbye!");
//			scanner.close();
//			peopleDao.close();
//		}
}
