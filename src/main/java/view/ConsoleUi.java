package view;

import error.InvalidInputException;
import java.util.Scanner;


/**
 * The type Console ui.
 */
public class ConsoleUi {
  private Scanner scan;

  /**
   * Instantiates a new Console ui.
   */
  public ConsoleUi() {
    this.scan = new Scanner(System.in, "utf-8");
  }


  /**
   * Print main menu.
   *
   * @return MainOptions enum.
   * @throws InvalidInputException the invalid input exception
   */
  public MainOptions printMainOptions() throws InvalidInputException {
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
    return getMainInput();
  }

  /**
   * Parse string to int integer.
   *
   * @param input the input
   * @return the integer
   * @throws InvalidInputException the invalid input exception
   */
  private Integer parseStringToInt(String input) throws InvalidInputException {
    if (!canBeParsed(input)) {
      throw new InvalidInputException();
    }
    return Integer.parseInt(input);
  }

  /**
   * Returns true if String input can be parsed to Integer.
   *
   * @param input the input
   * @return the boolean
   */
  private boolean canBeParsed(String input) {
    try {
      Integer.parseInt(input);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }


  /**
   * Returns Main menu input as MainOptions enum.
   *
   * @return MainOptions enum.
   * @throws InvalidInputException as an invalid input exception.
   */
  private MainOptions getMainInput() throws InvalidInputException {
    switch (parseStringToInt(scan.nextLine())) {
      case (1):
        return MainOptions.ADD_MEMBER;
      case (2):
        return MainOptions.SEARCH_MEMBER;
      case (3):
        return MainOptions.SHOW_VERBOSE;
      case (4):
        return MainOptions.SHOW_COMPACT;
      default:
        return MainOptions.QUIT;
    }
  }

  /**
   * Prints search menu.
   *
   * @return MainOptions enum.
   * @throws InvalidInputException the invalid input exception.
   */
  public MainOptions printSearchOptions() throws InvalidInputException {
    System.out.println("1 - Search by personal number.");
    System.out.println("2 - Search by member id.");
    return getSearchMenuInput();
  }

  /**
   * Returns Search menu input as MainOptions enum.
   *
   * @return MainOptions enum.
   * @throws InvalidInputException the invalid input exception.
   */
  private MainOptions getSearchMenuInput() throws InvalidInputException {
    switch (parseStringToInt(scan.nextLine())) {
      case (1):
        return MainOptions.SEARCH_BY_PERSONALNR;
      case (2):
        return MainOptions.SEARCH_BY_ID;
      default:
        return MainOptions.QUIT;
    }
  }

  /**
   * Print member menu.
   *
   * @return MainOptions enum.
   * @throws InvalidInputException the invalid input exception.
   */
  public MainOptions printMemberMenu() throws InvalidInputException {
    System.out.println("");
    System.out.println("1 - Edit this member.");
    System.out.println("2 - Remove this member.");
    System.out.println("3 - Member boat menu.");
    System.out.println("0 - Go back.");
    return getMemberMenuInput();
  }

  /**
   * Returns Member menu option as MainOptions enum.
   *
   * @return MainOptions enum.
   * @throws InvalidInputException the invalid input exception.
   */
  private MainOptions getMemberMenuInput() throws InvalidInputException {
    switch (parseStringToInt(scan.nextLine())) {
      case (1):
        return MainOptions.EDIT_MEMBER;
      case (2):
        return MainOptions.REMOVE_MEMBER;
      case (3):
        return MainOptions.BOAT_MENU;
      default:
        return MainOptions.QUIT;
    }
  }

  /**
   * Print boat menu.
   *
   * @return MainOptions enum.
   * @throws InvalidInputException the invalid input exception.
   */
  public MainOptions printBoatOptions() throws InvalidInputException {
    System.out.println("");
    System.out.println("Boat menu: ");
    System.out.println("1 - Add a boat");
    System.out.println("2 - Edit a boat");
    System.out.println("3 - Remove a boat");
    System.out.println("0 - Go back.");
    return getBoatMenuInput();
  }


  /**
   * Returns Boat menu option as MainOptions enum.
   *
   * @return MainOptions enum.
   * @throws InvalidInputException the invalid input exception.
   */
  private MainOptions getBoatMenuInput() throws InvalidInputException {
    switch (parseStringToInt(scan.nextLine())) {
      case (1):
        return MainOptions.ADD_BOAT;
      case (2):
        return MainOptions.EDIT_BOAT;
      case (3):
        return MainOptions.REMOVE_BOAT;
      default:
        return MainOptions.QUIT;
    }
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
   * Close scanner.
   */
  public void closeScanner() {
    scan.close();
  }


  /**
   * The enum Main options.
   */
  public enum MainOptions {
    ADD_MEMBER,
    SEARCH_MEMBER,
    SHOW_VERBOSE,
    SHOW_COMPACT,
    SEARCH_BY_PERSONALNR,
    SEARCH_BY_ID,
    EDIT_MEMBER,
    REMOVE_MEMBER,
    BOAT_MENU,
    ADD_BOAT,
    EDIT_BOAT,
    REMOVE_BOAT,
    QUIT;
  }
}
