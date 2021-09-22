package model;

import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;

public class Member {
  private String firstName;
  private String lastName;
  private Long personalNr;
  private String memberId;
  private ArrayList<Boat> boatList;

  public Member(String firstName, String lastName, Long personalNr, ArrayList<String> allMemberIds) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.personalNr = personalNr;
    this.memberId = new MemberId(allMemberIds).getId();
    this.boatList = new ArrayList<Boat>();
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public Long getPersonalNr() {
    return personalNr;
  }

  public void setPersonalNr(Long personalNr) {
    this.personalNr = personalNr;
  }

  public String getMemberId() {
    return memberId;
  }

  public ArrayList<Boat> getBoatList() {
    return boatList;
  }

  public void addBoat(Boat newBoat) {
    boatList.add(newBoat);
  }

  public void removeBoat(Boat boat) {
    boatList.remove(boat);
  }

  public Boat getBoatByName(String boatName) {
    for (Boat boat : boatList) {
      if (boat.getName().equals(boatName)) {
        return boat;
      }
    }
    return null;
  }
}
