package controller;

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
   * Create and add member.
   */
  public void createAndAddMember() {
    String firstName = memController.promptFirstName();
    String lastName = memController.promptLastName();
    String personalNr = view.askPersonalNr();
    Member newMember = new Member(firstName, lastName, personalNr, createUniqueId());
    addMember(newMember);
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

  /**
   * Create unique id string.
   *
   * @return the string
   */
  public String createUniqueId() {
    return model.generateUniqueId();
  }
}
