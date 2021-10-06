package controller;

import java.util.ArrayList;
import model.Member;
import view.MemberView;

/**
 * The type Member controller.
 */
public class MemberController {
  private MemberView view;
  private BoatListController boatListController;


  /**
   * Instantiates a new Member controller.
   *
   * @param view               the view
   * @param boatListController the boat list controller
   */
  public MemberController(MemberView view, BoatListController boatListController) {
    this.view = view;
    this.boatListController = boatListController;
  }

  /**
   * Create and add member.
   *
   * @param memberIds the member ids
   * @return the member
   */
  public Member createMember(ArrayList<String> memberIds) {
    String firstName = view.askFirstName();
    String lastName = view.askLastName();
    String personalNr = view.askPersonalNr();
    Member newMember = new Member(firstName, lastName, personalNr, memberIds);
    return newMember;
  }

  /**
   * Edit member.
   *
   * @param member the member
   */
  public void editMember(Member member) {
    view.printNoEditMessage();
    String firstName = view.askFirstName();
    view.printNoEditMessage();
    String lastName = view.askLastName();
    view.printNoEditMessage();
    String personalNr = view.askPersonalNr();

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
   * Show boat list.
   *
   * @param member the member
   */
  public void showBoatList(Member member) {
    boatListController.showBoats(member.getBoatList());
  }


}