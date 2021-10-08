package controller;

import error.InvalidInputException;
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
  private void addMember(Member member) {
    model.addMember(member);
  }


  /**
   * Create and add member.
   *
   * @throws InvalidInputException the invalid input exception
   */
  public void createAndAddMember() throws InvalidInputException {
    String firstName = view.askFirstName();
    String lastName = view.askLastName();
    String personalNr = view.askPersonalNr();
    Member newMember = new Member(firstName, lastName, personalNr, createUniqueId());
    addMember(newMember);
  }

  /**
   * Search member by id.
   *
   * @return the member
   * @throws InvalidInputException the invalid input exception
   */
  public Member searchMemberById() throws InvalidInputException {
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
   * Search member by personal nr.
   *
   * @return the member
   * @throws InvalidInputException the invalid input exception
   */
  public Member searchMemberByPersonalNr() throws InvalidInputException {
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
   * Show all members verbose.
   */
  public void showMembersVerbose() {
    for (Member member : model.getMembers()) {
      showMemberVerbose(member);
    }
  }

  /**
   * Show all members compact.
   */
  public void showMembersCompact() {
    for (Member member : model.getMembers()) {
      view.printMemberCompact(member.getFirstName(), member.getLastName(), member.getMemberId(),
          member.getAmountOfBoats());
    }
  }

  /**
   * Create unique id string.
   *
   * @return the string
   */
  public String createUniqueId() {
    return model.generateUniqueId();
  }
}
