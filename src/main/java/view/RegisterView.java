package view;

import java.util.Scanner;
import model.PersonalNumber;
import view.error.InvalidInputException;

/**
 * The type Register view.
 */
public class RegisterView {
  private Scanner scan;

  /**
   * Instantiates a new Register view.
   */
  public RegisterView() {
    this.scan = new Scanner(System.in, "utf-8");
  }


  /**
   * Print no member found.
   */
  public void printNoMemberFound() {
    System.out.println("No member found!");
  }

  /**
   * Prompts user to enter member id.
   *
   * @return the string
   * @throws InvalidInputException the invalid input exception
   */
  public String askMemberId() throws InvalidInputException {
    System.out.println("Please enter member id:");
    return validateInput(scan.nextLine());
  }

  /**
   * Prompts user to enter personal nr.
   *
   * @return the string
   * @throws InvalidInputException the invalid input exception
   */
  public PersonalNumber askPersonalNr() throws InvalidInputException {
    System.out.println("Please enter personal nr (YYMMDD-XXXX): ");
    PersonalNumber personalNumber = new PersonalNumber(validateInput(scan.nextLine()));
    if (!personalNumber.valid) {
      throw new InvalidInputException("Invalid personal number.");
    }
    return personalNumber;
  }


  /**
   * Prompts user to enter first name.
   *
   * @return the string
   * @throws InvalidInputException the invalid input exception
   */
  public String askFirstName() throws InvalidInputException {
    System.out.println("Please enter first name: ");
    return validateInput(scan.nextLine());
  }


  /**
   * Prompts user to enter last name.
   *
   * @return the string
   * @throws InvalidInputException the invalid input exception
   */
  public String askLastName() throws InvalidInputException {
    System.out.println("Please enter last name: ");
    return validateInput(scan.nextLine());
  }


  /**
   * Validates input, throws error if empty.
   *
   * @param input the string.
   * @return the input.
   * @throws InvalidInputException the invalid input exception
   */
  private String validateInput(String input) throws InvalidInputException {
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
  private void printLine() {
    System.out.println("----------------------------------");
  }

  /**
   * Print boat section.
   */
  public void printBoatSection() {
    System.out.println("Owned boats: ");
  }
}
