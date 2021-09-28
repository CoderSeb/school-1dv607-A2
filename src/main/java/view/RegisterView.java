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
  public Long askPersonalNr() {
    System.out.println("Please enter personal nr (12-digits): ");
    String personalNr = scan.nextLine();
    Integer length = personalNr.length();
    Integer lengthOfPersonalNr = 12;

    if (length.equals(lengthOfPersonalNr)) {
      return Long.parseLong(personalNr);
    }
    return null;
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
  public void printMemberVerbose(String firstName, String lastName, Long personalNr, String memberId) {
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
    return scan.nextLine();
  }

  /**
   * Ask boat length double.
   *
   * @return the double
   */
  public Double askBoatLength() {
    System.out.println("Please enter boat length in ft: ");
    return scan.nextDouble();
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
      System.out.println(type);
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
