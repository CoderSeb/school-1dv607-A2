package controller;

import Mock.MockData;
import model.Boat;
import model.Member;
import model.Register;
import view.RegisterView;

public class RegisterController {
  private RegisterView view;
  private Register model;

  public RegisterController(RegisterView view, Register model) {
    this.view = view;
    this.model = model;
  }

  public void validatePersonalNr() {
    // TODO: implement validation...
  }

  public void createAndAddMember() {
    String firstName = view.askFirstName();
    String lastName = view.askLastName();
    Long personalNr = view.askPersonalNr();
    view.consumeLeftOverCharacters();
    Member newMember = new Member(firstName, lastName, personalNr, model.getAllMemberIds());
    model.addMember(newMember);
  }

  public void showMembersVerbose() {
    for (Member member : model.getMembers()) {
      view.printMemberVerbose(member.getFirstName(), member.getLastName(), member.getPersonalNr(), member.getMemberId());
      view.printBoatSection();
      for (Boat boat : member.getBoatList()) {
        view.printBoat(boat.getName(), boat.getType(), boat.getLength());
      }
    }
  }

  /**
   * Add mock data to register
   * TODO: Remove before production!!!!
   */
  public void addRandomMembers(Integer amount) {
    MockData mocker = new MockData();
    for (int i = 0; i < amount; i++) {
      model.addMember(mocker.getRandomMember(model.getAllMemberIds()));
    }
  }
}
