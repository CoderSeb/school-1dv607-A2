package controller;

import model.Boat;
import model.Member;
import view.ConsoleUi;

/**
 * The type Console ui controller.
 */
public class ConsoleUiController {
  private ConsoleUi view;
  private RegisterController regController;
  private MemberController memController;
  private Boolean quit;
  private Member currentMember;
  private ConsoleUi.MainOptions action;

  /**
   * Instantiates a new Console ui controller.
   *
   * @param view             the view
   * @param regController    the reg controller
   * @param memberController the member controller
   */
  public ConsoleUiController(ConsoleUi view, RegisterController regController, MemberController memberController) {
    this.view = view;
    this.regController = regController;
    this.memController = memberController;
    this.quit = false;
    this.currentMember = null;
  }

  /**
   * Run.
   */
  public void run() {
    regController.loadFromMock(); // TODO: Remove before production!!!
    view.printWelcomeMessage();
    do {
      showMainMenu();
    } while (!quit);
  }

  /**
   * Show main menu.
   */
  private void showMainMenu() {
    action = view.printMainOptions();
    switch (action) {
      case ADD_MEMBER:
        regController.addMember(memController.createMember(regController.fetchMembersIds()));
        break;
      case SEARCH_MEMBER:
        showSearchMenu();
        break;
      case SHOW_VERBOSE:
        regController.showMembersVerbose();
        break;
      case SHOW_COMPACT:
        regController.showMembersCompact();
        break;
      default:
        view.closeScanner();
        quit = true;
        break;
    }
  }

  /**
   * Show search menu.
   */
  private void showSearchMenu() {
    action = view.printSearchOptions();
    switch (action) {
      case SEARCH_BY_PERSONALNR:
        currentMember = regController.searchMemberByPersonalNr();
        if (currentMember != null) {
          showMemberMenu();
        }
        break;
      case SEARCH_BY_ID:
        currentMember = regController.searchMemberById();
        if (currentMember != null) {
          showMemberMenu();
        }
        break;
      default:
        break;
    }
  }

  /**
   * Show member menu.
   */
  private void showMemberMenu() {
    regController.showMemberVerbose(currentMember);
    action = view.printMemberMenu();
    switch (view.printMemberMenu()) {
      case EDIT_MEMBER:
        memController.editMember(currentMember);
        showMemberMenu();
        break;
      case REMOVE_MEMBER:
        regController.removeMember(currentMember);
        break;
      case BOAT_MENU:
        showBoatMenu();
        break;
      default:
        break;
    }
  }

  /**
   * Show boat menu.
   */
  private void showBoatMenu() {
    memController.showBoats(currentMember);
    action = view.printBoatOptions();
    switch (action) {
      case ADD_BOAT:
        memController.registerBoat(currentMember);
        showBoatMenu();
        break;
      case EDIT_BOAT:
        Boat foundBoat = memController.chooseBoat(currentMember);
        if (foundBoat != null) {
          memController.editBoat(foundBoat);
        }
        showBoatMenu();
        break;
      case REMOVE_BOAT:
        memController.removeBoat(currentMember);
        showBoatMenu();
        break;
      default:
        showMemberMenu();
        break;
    }
  }
}
