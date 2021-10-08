package controller;

import error.InvalidInputException;
import java.util.Arrays;
import model.Boat;
import model.Member;
import view.MemberView;

/**
 * The type Member controller.
 */
public class MemberController {
  private MemberView view;


  /**
   * Instantiates a new Member controller.
   *
   * @param view the view
   */
  public MemberController(MemberView view) {
    this.view = view;
  }


  /**
   * Edit member.
   *
   * @param member the member
   * @throws InvalidInputException the invalid input exception
   */
  public void editMember(Member member) throws InvalidInputException {
    view.printNoEditMessage();
    String firstName = view.askEditFirstName();
    view.printNoEditMessage();
    String lastName = view.askEditLastName();
    view.printNoEditMessage();
    String personalNr = view.askEditPersonalNr();

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
   * Show boats.
   *
   * @param member the member
   */
  public void showBoats(Member member) {
    for (Boat boat : member.getBoatList()) {
      view.printBoat(boat.getName(), boat.getType(), boat.getLength());
    }
  }

  /**
   * Register boat.
   *
   * @param member the member
   * @throws InvalidInputException the invalid input exception
   */
  public void registerBoat(Member member) throws InvalidInputException {
    String name = view.askBoatName();
    String type = view.askBoatType();
    Double length = view.askBoatLength();
    String[] boatValues = {name, type};
    if (Arrays.stream(boatValues).anyMatch(value -> value == null)) {
      throw new InvalidInputException("You must enter a value.");
    }
    if (length == null) {
      throw new InvalidInputException("You must enter a value.");
    }
    Boat newBoat = new Boat(name, type, length);
    member.addBoat(newBoat);
  }

  /**
   * Edit boat.
   *
   * @param boat the boat
   * @throws InvalidInputException the invalid input exception
   */
  public void editBoat(Boat boat) throws InvalidInputException {
    String boatName = view.askBoatName();
    String boatType = view.askBoatType();
    Double boatLength = view.askBoatLength();

    if (boatName != null) {
      boat.setName(boatName);
    }
    if (boatType != null) {
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
    return member.findBoatByName(boatName);
  }

  /**
   * Remove boat.
   *
   * @param member the member
   */
  public void removeBoat(Member member) {
    member.removeBoat(chooseBoat(member));
  }
}
