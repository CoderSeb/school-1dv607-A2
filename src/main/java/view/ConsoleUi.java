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


  /**
   * Print main options main options.
   *
   * @return the main options
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
    return getMainInput();
  }

  /**
   * Parse string to integer.
   *
   * @param input the input.
   * @return the input as integer.
   */
  public Integer parseStringToInt(String input) {
    if (input.equals("") || input == null) {
     throw new InvalidInputException();
    }
    return Integer.parseInt(input);
  }

  private MainOptions getMainInput() {
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
   * Print search option integer.
   *
   * @return the integer
   */
  public MainOptions printSearchOptions() {
    System.out.println("1 - Search by personal number.");
    System.out.println("2 - Search by member id.");
    return getSearchMenuInput();
  }

  private MainOptions getSearchMenuInput() {
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
   * Ask yes or no boolean.
   *
   * @return the boolean
   */
  public Boolean askYesOrNo() {
    System.out.println("Y/(N)?");
    return scan.nextLine().equals("Y");
  }

  /**
   * Print member menu integer.
   *
   * @return the integer
   */
  public MainOptions printMemberMenu() {
    System.out.println("");
    System.out.println("1 - Edit this member.");
    System.out.println("2 - Remove this member.");
    System.out.println("3 - Member boat menu.");
    System.out.println("0 - Go back.");
    return getMemberMenuInput();
  }

  private MainOptions getMemberMenuInput() {
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
   * Print boat option integer.
   *
   * @return the integer
   */
  public MainOptions printBoatOptions() {
    System.out.println("");
    System.out.println("Boat menu: ");
    System.out.println("1 - Add a boat");
    System.out.println("2 - Edit a boat");
    System.out.println("3 - Remove a boat");
    System.out.println("0 - Go back.");
    return getBoatMenuInput();
  }

  private MainOptions getBoatMenuInput() {
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
    /**
     * Add member main options.
     */
    ADD_MEMBER,
    /**
     * Search member main options.
     */
    SEARCH_MEMBER,
    /**
     * Show verbose main options.
     */
    SHOW_VERBOSE,
    /**
     * Show compact main options.
     */
    SHOW_COMPACT,
    /**
     * Search by personalnr main options.
     */
    SEARCH_BY_PERSONALNR,
    /**
     * Search by id main options.
     */
    SEARCH_BY_ID,
    /**
     * Edit member main options.
     */
    EDIT_MEMBER,
    /**
     * Remove member main options.
     */
    REMOVE_MEMBER,
    /**
     * Boat menu main options.
     */
    BOAT_MENU,
    /**
     * Add boat main options.
     */
    ADD_BOAT,
    /**
     * Edit boat main options.
     */
    EDIT_BOAT,
    /**
     * Remove boat main options.
     */
    REMOVE_BOAT,
    /**
     * Quit main options.
     */
    QUIT;
  }
}
