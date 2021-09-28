package controller;

import mock.MockData;
import model.Boat;
import model.BoatType;
import model.Member;
import model.Register;
import view.RegisterView;

/**
 * The type Register controller.
 */
public class RegisterController {
  private RegisterView view;
  private Register model;

  /**
   * Instantiates a new Register controller.
   *
   * @param view  the view
   * @param model the model
   */
  public RegisterController(RegisterView view, Register model) {
    this.view = view;
    this.model = model;
  }

  /**
   * Remove member.
   *
   * @param member the member
   */
  public void removeMember(Member member) {
    model.removeMember(member);
  }

  /**
   * Add member.
   *
   * @param member the member
   */
  public void addMember(Member member) {
    model.addMember(member);
  }

  /**
   * Search member by id member.
   *
   * @return the member
   */
  public Member searchMemberById() {
    String memberId = view.askMemberId();
    if (memberId != null) {
      Member foundMember = model.findById(memberId);
      if (foundMember != null) {
        view.printMemberCompact(foundMember.getFirstName(), foundMember.getLastName(), foundMember.getMemberId(), foundMember.getAmountOfBoats());
        return foundMember;
      }
    }
    view.printNoMemberFound();
    return null;
  }

  /**
   * Search member by personal nr member.
   *
   * @return the member
   */
  public Member searchMemberByPersonalNr() {
    Long personalNr = view.askPersonalNr();
    if (personalNr != null) {
      Member foundMember = model.findByPersonalNr(personalNr);
      if (foundMember != null) {
        view.printMemberCompact(foundMember.getFirstName(), foundMember.getLastName(), foundMember.getMemberId(), foundMember.getAmountOfBoats());
        return foundMember;
      }
    }
    view.printNoMemberFound();
    return null;
  }

  /**
   * Show members verbose.
   */
  public void showMembersVerbose() {
    for (Member member : model.getMembers()) {
      view.printMemberVerbose(member.getFirstName(), member.getLastName(), member.getPersonalNr(), member.getMemberId());
      view.printBoatSection();
      for (Boat boat : member.getBoatList()) {
        showBoat(boat.getName(), boat.getType(), boat.getLength());
      }
    }
  }

  /**
   * Show members compact.
   */
  public void showMembersCompact() {
    for (Member member : model.getMembers()) {
      view.printMemberCompact(member.getFirstName(), member.getLastName(), member.getMemberId(), member.getAmountOfBoats());
    }
  }

  // ----------------------------------Boat section----------------------------


  /**
   * Register boat.
   *
   * @param member the member
   */
  public void registerBoat(Member member) {
    String name = view.askBoatName();
    BoatType type = view.askBoatType(BoatType.values());
    Double length = view.askBoatLength();
    Boat newBoat = new Boat(name, type, length);
    member.addBoat(newBoat);
  }

  public void editBoat(Boat boat) {
    String boatName = view.askBoatName();
    BoatType boatType = view.askBoatType(BoatType.values());
    Double boatLength = view.askBoatLength();

    if (boatName != null) {
      boat.setName(boatName);
    }
    if (boatType.label.equals(boat.getType())) {
      boat.setType(boatType);
    }
    if (boatLength != null) {
      boat.setLength(boatLength);
    }
  }

  public void showBoat(String boatName, String boatType, Double boatLength) {
    view.printBoat(boatName, boatType, boatLength);
  }

  public Boat chooseBoat(Member member) {
    String boatName = view.askBoatName();
    return member.getBoatByName(boatName);
  }
  // ----------------------------------Member section----------------------------


  /**
   * Create and add member.
   */
  public void createAndAddMember() {
    String firstName = view.askFirstName();
    String lastName = view.askLastName();
    Long personalNr = view.askPersonalNr();
    Member newMember = new Member(firstName, lastName, personalNr, model.getAllMemberIds());
    addMember(newMember);
  }

  /**
   * Edit member.
   *
   * @param member the member
   */
  public void editMember(Member member) {
    String firstName = view.askFirstName();
    String lastName = view.askLastName();
    Long personalNr = view.askPersonalNr();

    if (firstName != null) {
      member.setFirstName(firstName);
    }
    if (lastName != null) {
      member.setLastName(lastName);
    }
    if (personalNr != null) {
      member.setPersonalNr(personalNr);
    }
  }

  /**
   * Add mock data to register.
   * TODO: Remove before production!!!!
   *
   * @param amount the amount
   */
  public void addRandomMembers(Integer amount) {
    MockData mocker = new MockData();
    for (int i = 0; i < amount; i++) {
      model.addMember(mocker.getRandomMember(model.getAllMemberIds()));
    }
  }
}
