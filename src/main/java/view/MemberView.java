package view;

import error.InvalidInputException;
import java.util.Scanner;
import model.PersonalNumber;

/**
 * The type Member view.
 */
public class MemberView {
  private Scanner scan;

  /**
   * Instantiates a new Member view.
   */
  public MemberView() {
    this.scan = new Scanner(System.in);
  }

  /**
   * Prompts user to enter first name.
   *
   * @return the input.
   */
  public String askEditFirstName() {
    System.out.println("Please enter first name: ");
    String input = scan.nextLine();
    if (isBlank(input)) {
      return null;
    }
    return input;
  }

  /**
   * Prompts user to enter last name.
   *
   * @return the input.
   */
  public String askEditLastName() {
    System.out.println("Please enter last name: ");
    String input = scan.nextLine();
    if (isBlank(input)) {
      return null;
    }
    return input;
  }

  /**
   * Prompts user to enter personal number.
   *
   * @return the input.
   */
  public PersonalNumber askEditPersonalNr() throws InvalidInputException {
    System.out.println("Please enter personal nr (YYMMDD-XXXX): ");
    PersonalNumber personalNumber = new PersonalNumber(scan.nextLine());
    if (!personalNumber.valid) {
      throw new InvalidInputException("Not a valid personal number.");
    }
    return personalNumber;
  }

  /**
   * Returns true if input is blank.
   *
   * @param input the input
   * @return the boolean
   */
  private Boolean isBlank(String input) {
    return input.equals("");
  }

  /**
   * Print no edit message.
   */
  public void printNoEditMessage() {
    System.out.println("Press enter if no change.");
  }


  /**
   * Print boat.
   *
   * @param boatName   the boat name
   * @param boatType   the boat type
   * @param boatLength the boat length
   */
  public void printBoat(String boatName, String boatType, Double boatLength) {
    System.out.println("-Boat " + boatName + ", type: " + boatType + " and with a length of " + boatLength + "ft.");
  }


  /**
   * Prompts user to enter boat name.
   *
   * @return the input.
   */
  public String askBoatName() {
    System.out.println("Please enter boat name: ");
    String boatName = scan.nextLine();
    if (!boatName.equals("")) {
      return boatName;
    }
    return null;
  }

  /**
   * Converts String input to a Double.
   *
   * @param input the input
   * @return the Double.
   * @throws InvalidInputException the invalid input exception.
   */
  private Double parseStringToDouble(String input) throws InvalidInputException {
    if (!canBeParsed(input)) {
      throw new InvalidInputException();
    }
    return Double.parseDouble(input);
  }

  /**
   * Returns true if String input can be parsed to Double.
   *
   * @param input the input
   * @return the boolean
   */
  private boolean canBeParsed(String input) {
    try {
      Double.parseDouble(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  /**
   * Prompts user to enter boat length.
   *
   * @return the double
   * @throws InvalidInputException the invalid input exception
   */
  public Double askBoatLength() throws InvalidInputException {
    System.out.println("Please enter boat length in ft: ");
    String input = scan.nextLine().replace(',', '.');
    if (!input.equals("")) {
      return parseStringToDouble(input);
    }

    return null;
  }

  /**
   * Prompts user to enter boat type.
   *
   * @return the input.
   */
  public String askBoatType() {
    System.out.println("Please choose a boat type: ");
    String input = scan.nextLine();
    if (!input.equals("")) {
      return input;
    }

    return null;
  }
}
