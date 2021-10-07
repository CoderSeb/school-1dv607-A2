package controller;

import java.util.ArrayList;
import mock.MockData;
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
    view.printMemberVerbose(member.getFirstName(), member.getLastName(), member.getPersonalNr(),
        member.getMemberId());
    view.printBoatSection();
    memController.showBoats(member);
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

  /**
   * Create unique id string.
   *
   * @return the string
   */
  // ----------------------------------Id section----------------------------
  public String createUniqueId() {

    return model.generateUniqueId();
  }
}
