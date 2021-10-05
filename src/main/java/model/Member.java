package model;

import java.util.ArrayList;


/**
 * The type Member.
 */
public class Member {
  private String firstName;
  private String lastName;
  private PersonalNumber personalNr;
  private String memberId;
  private BoatList boatList;

  /**
   * Instantiates a new Member.
   *
   * @param firstName    the first name
   * @param lastName     the last name
   * @param personalNr   the personal nr
   * @param allMemberIds the all member ids
   */
  public Member(String firstName, String lastName, String personalNr, ArrayList<String> allMemberIds) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.personalNr = new PersonalNumber(personalNr);
    this.memberId = new MemberId(allMemberIds).getId();
    this.boatList = new BoatList();
  }

  /**
   * Instantiates a new Member.
   *
   * @param mockedFirstName  the mocked first name
   * @param mockedLastName   the mocked last name
   * @param mockedPersonalNr the mocked personal nr
   * @param mockedMemberId   the mocked member id
   */
  public Member(String mockedFirstName, String mockedLastName, String mockedPersonalNr, String mockedMemberId) {
    this.firstName = mockedFirstName;
    this.lastName = mockedLastName;
    this.personalNr = new PersonalNumber(mockedPersonalNr);
    this.memberId = mockedMemberId;
    this.boatList = new BoatList();
  }

  /**
   * Gets first name.
   *
   * @return the first name
   */
  public String getFirstName() {
    return firstName;
  }

  /**
   * Sets first name.
   *
   * @param firstName the first name
   */
  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  /**
   * Gets last name.
   *
   * @return the last name
   */
  public String getLastName() {
    return lastName;
  }

  /**
   * Sets last name.
   *
   * @param lastName the last name
   */
  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  /**
   * Gets personal nr.
   *
   * @return the personal nr
   */
  public PersonalNumber getPersonalNr() {
    return personalNr;
  }

  /**
   * Sets personal nr.
   *
   * @param personalNr the personal nr
   */
  public void setPersonalNr(String personalNr) {
    this.personalNr.setPersonalNumber(personalNr);
  }

  /**
   * Gets member id.
   *
   * @return the member id
   */
  public String getMemberId() {
    return memberId;
  }

  /**
   * Gets boat list.
   *
   * @return the boat list
   */
  public BoatList getBoatList() {
    return boatList;
  }

  /**
   * Add boat.
   *
   * @param newBoat the new boat
   */
  public void addBoat(Boat newBoat) {
    boatList.addBoat(newBoat);
  }

  /**
   * Remove boat.
   *
   * @param boat the boat
   */
  public void removeBoat(Boat boat) {
    boatList.removeBoat(boat);
  }

  /**
   * Gets boat by name.
   *
   * @param boatName the boat name
   * @return the boat by name
   */
  public Boat getBoatByName(String boatName) {
    return boatList.findBoatByName(boatName);
  }

  /**
   * Gets amount of boats.
   *
   * @return the amount of boats
   */
  public Integer getAmountOfBoats() {
    return boatList.size();
  }
}
