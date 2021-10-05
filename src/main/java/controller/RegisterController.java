package controller;

import java.util.ArrayList;
import java.util.Arrays;
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
  private MemberController memController;

  /**
   * Instantiates a new Register controller.
   *
   * @param view          the view
   * @param model         the model
   * @param memController the mem controller
   */
  public RegisterController(RegisterView view, Register model, MemberController memController) {
    this.view = view;
    this.model = model;
    this.memController = memController;
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
   * Fetch members ids array list.
   *
   * @return the array list
   */
  public ArrayList<String> fetchMembersIds() {
    return model.getAllMemberIds();
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
    String personalNr = view.askPersonalNr();
    if (personalNr != null) {
      Member foundMember = model.findByPersonalNr(personalNr);
      if (foundMember != null) {
        return foundMember;
      }
    }
    view.printNoMemberFound();
    return null;
  }

  /**
   * Show member verbose.
   *
   * @param member the member
   */
  public void showMemberVerbose(Member member) {
    view.printMemberVerbose(member.getFirstName(), member.getLastName(), member.getPersonalNr().getPersonalNumber(),
        member.getMemberId());
    view.printBoatSection();
    memController.showBoatList(member);
  }

  /**
   * Show members verbose.
   */
  public void showMembersVerbose() {
    for (Member member : model.getMembers()) {
      showMemberVerbose(member);
    }
  }

  /**
   * Show members compact.
   */
  public void showMembersCompact() {
    for (Member member : model.getMembers()) {
      view.printMemberCompact(member.getFirstName(), member.getLastName(), member.getMemberId(),
          member.getAmountOfBoats());
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

  /**
   * Edit boat.
   *
   * @param boat the boat
   */
  public void editBoat(Boat boat) {
    String boatName = view.askBoatName();
    BoatType boatType = view.askBoatType(BoatType.values());
    Double boatLength = view.askBoatLength();

    if (boatName != null) {
      boat.setName(boatName);
    }
    if (boatType != null && Arrays.stream(BoatType.values()).anyMatch(type -> type.equals(boatType))) {
      boat.setType(boatType);
    }
    if (boatLength != null) {
      boat.setLength(boatLength);
    }
  }

  /**
   * Choose boat boat.
   *
   * @param member the member
   * @return the boat
   */
  public Boat chooseBoat(Member member) {
    String boatName = view.askBoatName();
    return member.getBoatByName(boatName);
  }

  /**
   * Remove boat.
   *
   * @param member the member
   */
  public void removeBoat(Member member) {
    member.removeBoat(chooseBoat(member));
  }

  // ----------------------------------Member section----------------------------

  /**
   * Add mock data to register.
   */
  public void loadFromMock() {
    MockData mockData = new MockData();
    for (Member member : mockData.loadMembers()) {
      model.addMember(member);
    }
  }
}
