package entity;


public class People {
	
	private int people_id;
	private String firstName;
	private String middleName;
	private String lastName;
	private String maidenName;
	private String gender;
	private String birthDate;
	private String birthCity;
	private String birthState;
	private String birthCountry;
	private String lifeStatus;
	private String deathDate;
	private String causeDeath;
	private String age;
	private String relationshipType;
	
	public People (int people_id, String firstName, String middleName, String lastName, String maidenName, String gender, String birthDate, String birthCity, String birthState, String birthCountry, String lifeStatus, String deathDate, String causeDeath, String age, String relationshipType) {
		this.setPeopleId(people_id);
		this.setFirstName(firstName);
		this.setMiddleName(middleName);
		this.setLastName(lastName);
		this.setMaidenName(maidenName);
		this.setGender(gender);
		this.setBirthDate(birthDate);
		this.setBirthCity(birthCity);
		this.setBirthState(birthState);
		this.setBirthCountry(birthCountry);
		this.setLifeStatus(lifeStatus);
		this.setDeathDate(deathDate);
		this.setCauseDeath(causeDeath);
		this.setAge(age);
		this.setRelationshipType(relationshipType);
	}

	public int getPeopleId() {
		return people_id;
	}

	public void setPeopleId(int people_id) {
		this.people_id = people_id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMaidenName() {
		return maidenName;
	}

	public void setMaidenName(String maidenName) {
		this.maidenName = maidenName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(String birthDate) {
		this.birthDate = birthDate;
	}

	public String getBirthCity() {
		return birthCity;
	}

	public void setBirthCity(String birthCity) {
		this.birthCity = birthCity;
	}

	public String getBirthState() {
		return birthState;
	}

	public void setBirthState(String birthState) {
		this.birthState = birthState;
	}

	public String getBirthCountry() {
		return birthCountry;
	}

	public void setBirthCountry(String birthCountry) {
		this.birthCountry = birthCountry;
	}

	public String getLifeStatus() {
		return lifeStatus;
	}

	public void setLifeStatus(String lifeStatus) {
		this.lifeStatus = lifeStatus;
	}

	public String getDeathDate() {
		return deathDate;
	}

	public void setDeathDate(String deathDate) {
		this.deathDate = deathDate;
	}
	public String getCauseDeath() {
		return causeDeath;
	}

	public void setCauseDeath(String causeDeath) {
		this.causeDeath = causeDeath;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

}
