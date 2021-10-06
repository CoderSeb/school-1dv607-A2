package view;

import java.util.Scanner;

/**
 * Class ConsoleUi.
 */
public class ConsoleUi {
  private Scanner scan;

  /**
   * Instantiates a new Console ui.
   */
  public ConsoleUi() {
    this.scan = new Scanner(System.in);
  }

  public enum MainOptions {
    ADD_MEMBER,
    SEARCH_MEMBER,
    SHOW_VERBOSE,
    SHOW_COMPACT,
    QUIT;
  }

  /**
   * Print main option integer.
   *
   * @return the integer
   */
  public MainOptions printMainOptions() {
    System.out.println("");
    System.out.println("Please choose an option: ");
    System.out.println("1 - Add new member.");
    System.out.println("2 - Search member.");
    System.out.println("    * Edit member.");
    System.out.println("    * Remove member.");
    System.out.println("    * Boat menu.");
    System.out.println("3 - Show verbose list of members.");
    System.out.println("4 - Show compact list of members.");
    System.out.println("0 - Quit.");
    // TODO: Add more options.
    return getMainInput();
  }

  /**
   * Parse string to int integer.
   *
   * @param input the input
   * @return the integer
   */
  public Integer parseStringToInt(String input) {
    return Integer.parseInt(input);
  }

  public MainOptions getMainInput() {
    switch(parseStringToInt(scan.nextLine())) {
      case(1):
        return MainOptions.ADD_MEMBER;
      case(2):
        return MainOptions.SEARCH_MEMBER;
      case(3):
        return MainOptions.SHOW_VERBOSE;
      case(4):
        return MainOptions.SHOW_COMPACT;
      default:
        return MainOptions.QUIT;
    }
  }

  /**
   * Print search option integer.
   *
   * @return the integer
   */
  public Integer printSearchOption() {
    System.out.println("1 - Search by personal number.");
    System.out.println("2 - Search by member id.");
    return parseStringToInt(scan.nextLine());
  }

  /**
   * Ask yes or no boolean.
   *
   * @return the boolean
   */
  public Boolean askYesOrNo() {
    System.out.println("Y/(N)?");
    return scan.nextLine().equals("Y");
  }

  /**
   * Ask edit member boolean.
   *
   * @return the boolean
   */
  public Boolean askEditMember() {
    System.out.println("Edit this member?");
    return askYesOrNo();
  }

  /**
   * Ask delete member boolean.
   *
   * @return the boolean
   */
  public Boolean askDeleteMember() {
    System.out.println("Delete this member?");
    return askYesOrNo();
  }

  /**
   * Print success.
   */
  public void printSuccess() {
    System.out.println("Task completed.");
  }

  /**
   * Print member menu integer.
   *
   * @return the integer
   */
  public Integer printMemberMenu() {
    System.out.println("");
    System.out.println("1 - Edit this member.");
    System.out.println("2 - Remove this member.");
    System.out.println("3 - Member boat menu.");
    System.out.println("0 - Go back.");
    return parseStringToInt(scan.nextLine());
  }


  /**
   * Print boat option integer.
   *
   * @return the integer
   */
  public Integer printBoatOption() {
    System.out.println("");
    System.out.println("Boat menu: ");
    System.out.println("1 - Add a boat");
    System.out.println("2 - Edit a boat");
    System.out.println("3 - Remove a boat");
    System.out.println("0 - Go back.");
    return parseStringToInt(scan.nextLine());
  }

  /**
   * Print welcome message.
   */
  public void printWelcomeMessage() {
    System.out.println("-+-----------------------------------------+-");
    System.out.println(" |                                         | ");
    System.out.println(" |   Welcome to the yacht club manager!    | ");
    System.out.println(" |                                         | ");
    System.out.println("-+-----------------------------------------+-");
  }

  /**
   * Consume left overs.
   */
  public void consumeLeftOvers() {
    scan.nextLine();
  }

  /**
   * Close scanner.
   */
  public void closeScanner() {
    scan.close();
  }
}
