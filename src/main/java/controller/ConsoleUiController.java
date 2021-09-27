package controller;

import model.Member;
import view.ConsoleUi;

/**
 * The type Console ui controller.
 */
public class ConsoleUiController {
  private ConsoleUi view;
  private RegisterController regController;
  private Boolean quit;
  private Member currentMember;

  /**
   * Instantiates a new Console ui controller.
   *
   * @param view          the view
   * @param regController the reg controller
   */
  public ConsoleUiController(ConsoleUi view, RegisterController regController) {
    this.view = view;
    this.regController = regController;
    this.quit = false;
    this.currentMember = null;
  }

  /**
   * Run.
   */
  public void run() {
    regController.addRandomMembers(6); // TODO: Remove before production!!!
    view.printWelcomeMessage();
    do {
      showMainMenu();
    } while (!quit);
  }

  /**
   * Show main menu.
   */
  public void showMainMenu() {
    switch (view.printMainOption()) {
      case (1):
        view.consumeLeftOvers();
        regController.createAndAddMember();
        break;
      case (2):
        view.consumeLeftOvers();
        showSearchMenu();
        break;
      case (3):
        view.consumeLeftOvers();
        regController.showMembersVerbose();
        break;
      case (4):
        view.consumeLeftOvers();
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
  public void showSearchMenu() {
    switch (view.printSearchOption()) {
      case (1):
        view.consumeLeftOvers();
        currentMember = regController.searchMemberByPersonalNr();
        if (currentMember != null) {
          showMemberMenu();
        }
        break;
      case (2):
        view.consumeLeftOvers();
        currentMember = regController.searchMemberById();
        if (currentMember != null) {
          showMemberMenu();
        }
        break;
      default:
        view.consumeLeftOvers();
        break;
    }
  }

  /**
   * Show member menu.
   */
  public void showMemberMenu() {
    switch (view.printMemberMenu()) {
      case (1):
        regController.editMember(currentMember);
        break;
      case (2):
        regController.removeMember(currentMember);
        break;
      case (3):
        showBoatMenu();
        break;
      default:
        break;
    }
  }


  /**
   * Show boat menu.
   */
  public void showBoatMenu() {
    // TODO: List boats.
    switch (view.printBoatOption()) {
      case (1):
        regController.registerBoat(currentMember);
        break;
      case (2):
        // Edit
        break;
      case (3):
        // Remove
        break;
      default:
        showMemberMenu();
        break;
    }
  }

}
