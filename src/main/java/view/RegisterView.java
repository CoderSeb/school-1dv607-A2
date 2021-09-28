package view;

import java.util.Scanner;
import model.BoatType;

/**
 * The type Register view.
 */
public class RegisterView {
  private Scanner scan;

  /**
   * Instantiates a new Register view.
   */
  public RegisterView() {
    this.scan = new Scanner(System.in);
  }

  /**
   * Ask first name string.
   *
   * @return the string
   */
  public String askFirstName() {
    System.out.println("Please enter first name: ");
    String input = scan.nextLine();
    if (isBlank(input)) {
      return null;
    }
    return input;
  }

  /**
   * Print no edit message.
   */
  public void printNoEditMessage() {
    System.out.println("Press enter if no change.");
  }

  /**
   * Ask last name string.
   *
   * @return the string
   */
  public String askLastName() {
    System.out.println("Please enter last name: ");
    String input = scan.nextLine();
    if (isBlank(input)) {
      return null;
    }
    return input;
  }

  /**
   * Ask personal nr long.
   *
   * @return the long
   */
  public String askPersonalNr() {
    System.out.println("Please enter personal nr (YYMMDD-XXXX): ");
    String input = scan.nextLine();
    if (isBlank(input)) {
      return null;
    }
    return input;
  }

  /**
   * Print no member found.
   */
  public void printNoMemberFound() {
    System.out.println("No member found!");
  }

  /**
   * Ask member id string.
   *
   * @return the string
   */
  public String askMemberId() {
    System.out.println("Please enter member id:");
    return scan.nextLine();
  }

  /**
   * Is blank boolean.
   *
   * @param input the input
   * @return the boolean
   */
  public Boolean isBlank(String input) {
    return input.equals("");
  }

  /**
   * Print line.
   */
  public void printLine() {
    System.out.println("----------------------------------");
  }

  /**
   * Print boat section.
   */
  public void printBoatSection() {
    System.out.println("Owned boats: ");
  }

  /**
   * Print member verbose.
   *
   * @param firstName  the first name
   * @param lastName   the last name
   * @param personalNr the personal nr
   * @param memberId   the member id
   */
  public void printMemberVerbose(String firstName, String lastName, String personalNr, String memberId) {
    printLine();
    System.out.println("Member " + memberId);
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Personal number: " + personalNr);
  }

  /**
   * Print member compact.
   *
   * @param firstName     the first name
   * @param lastName      the last name
   * @param memberId      the member id
   * @param amountOfBoats the amount of boats
   */
  public void printMemberCompact(String firstName, String lastName, String memberId, Integer amountOfBoats) {
    printLine();
    System.out.println("Member " + memberId);
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Amount of boats: " + amountOfBoats);
  }

  /**
   * Print boat.
   *
   * @param name   the name
   * @param type   the type
   * @param length the length
   */
  public void printBoat(String name, String type, Double length) {
    System.out.println("-Boat " + name + ", type: " + type + " and with a length of " + length + "ft.");
  }

  /**
   * Ask boat name string.
   *
   * @return the string
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
   * Ask boat length double.
   *
   * @return the double
   */
  public Double askBoatLength() {
    System.out.println("Please enter boat length in ft: ");
    String input = scan.nextLine().replace(',', '.');
    if (!input.equals("")) {
      return Double.parseDouble(input);
    }

    return null;
  }

  /**
   * Ask boat type boat type.
   *
   * @param boatTypes the boat types
   * @return the boat type
   */
  public BoatType askBoatType(BoatType[] boatTypes) {
    System.out.println("Please choose a boat type: ");
    for (BoatType type : boatTypes) {
      System.out.println(type.label);
    }
    String input = scan.nextLine();

    for (BoatType type : boatTypes) {
      if (type.label.equals(input)) {
        return type;
      }
    }
    return null;
  }
}
