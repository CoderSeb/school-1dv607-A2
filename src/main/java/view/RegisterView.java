package view;

import error.InvalidInputException;
import java.util.Scanner;

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
   * Print no member found.
   */
  public void printNoMemberFound() {
    System.out.println("No member found!");
  }

  /**
   * Ask member id string.
   *
   * @return the string
   * @throws InvalidInputException the invalid input exception
   */
  public String askMemberId() throws InvalidInputException {
    System.out.println("Please enter member id:");
    return validateInput(scan.nextLine());
  }

  /**
   * Ask personal nr string.
   *
   * @return the string
   * @throws InvalidInputException the invalid input exception
   */
  public String askPersonalNr() throws InvalidInputException {
    System.out.println("Please enter personal nr (YYMMDD-XXXX): ");
    return validateInput(scan.nextLine());
  }

  /**
   * Ask first name string.
   *
   * @return the string
   * @throws InvalidInputException the invalid input exception
   */
  public String askFirstName() throws InvalidInputException {
    System.out.println("Please enter first name: ");
    return validateInput(scan.nextLine());
  }


  /**
   * Ask last name string.
   *
   * @return the string
   * @throws InvalidInputException the invalid input exception
   */
  public String askLastName() throws InvalidInputException {
    System.out.println("Please enter last name: ");
    return validateInput(scan.nextLine());
  }


  /**
   * Validate input string.
   *
   * @param input the input
   * @return the string
   * @throws InvalidInputException the invalid input exception
   */
  public String validateInput(String input) throws InvalidInputException {
    if (input.trim().equals("")) {
      throw new InvalidInputException();
    }
    return input;
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
}
