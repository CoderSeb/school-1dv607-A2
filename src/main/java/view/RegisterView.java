package view;

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
   * Print no edit message.
   */
  public void printNoEditMessage() {
    System.out.println("Press enter if no change.");
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
   * Is blank boolean.
   *
   * @param input the input
   * @return the boolean
   */
  public Boolean isBlank(String input) {
    return input.equals("");
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
