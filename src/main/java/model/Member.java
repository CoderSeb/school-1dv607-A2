package model;

import error.InvalidInputException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * The type Member.
 */
public class Member {
  private String firstName;
  private String lastName;
  private PersonalNumber personalNr;
  private String memberId;
  private ArrayList<Boat> boatList;

  /**
   * Instantiates a new Member.
   *
   * @param firstName  the first name
   * @param lastName   the last name
   * @param personalNr the personal nr
   * @param memberId   the member id
   * @throws InvalidInputException the invalid input exception
   */
  public Member(String firstName, String lastName, String personalNr, String memberId) throws InvalidInputException {
    this.firstName = firstName;
    this.lastName = lastName;
    this.personalNr = new PersonalNumber(personalNr);
    this.memberId = memberId;
    this.boatList = new ArrayList<Boat>();
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
  public String getPersonalNr() {
    return personalNr.getPersonalNumber();
  }

  /**
   * Sets personal nr.
   *
   * @param personalNr the personal nr
   * @throws InvalidInputException the invalid input exception
   */
  public void setPersonalNr(String personalNr) throws InvalidInputException {
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
  public List<Boat> getBoatList() {
    List<Boat> readOnlyBoats = Collections.unmodifiableList(boatList);
    return readOnlyBoats;
  }

  /**
   * Find boat by name boat.
   *
   * @param boatName the boat name
   * @return the boat
   */
  public Boat findBoatByName(String boatName) {
    for (Boat boat : boatList) {
      if (boat.getName().equals(boatName)) {
        return boat;
      }
    }
    return null;
  }

  /**
   * Add boat.
   *
   * @param newBoat the new boat
   */
  public void addBoat(Boat newBoat) {
    boatList.add(newBoat);
  }

  /**
   * Remove boat.
   *
   * @param boat the boat
   */
  public void removeBoat(Boat boat) {
    boatList.remove(boat);
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
