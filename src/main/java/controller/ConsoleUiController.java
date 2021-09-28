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
  private void showMainMenu() {
    switch (view.printMainOption()) {
      case (1):
        regController.createAndAddMember();
        break;
      case (2):
        showSearchMenu();
        break;
      case (3):
        regController.showMembersVerbose();
        break;
      case (4):
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
    switch (view.printSearchOption()) {
      case (1):
        currentMember = regController.searchMemberByPersonalNr();
        if (currentMember != null) {
          showMemberMenu();
        }
        break;
      case (2):
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
   * Show boats.
   */
  public void showBoats() {
    for (Boat boat : currentMember.getBoatList()) {
      regController.showBoat(boat.getName(), boat.getType(), boat.getLength());
    }
  }

  /**
   * Show boat menu.
   */
  private void showBoatMenu() {
    showBoats();
    switch (view.printBoatOption()) {
      case (1):
        regController.registerBoat(currentMember);
        break;
      case (2):
        regController.editBoat(regController.chooseBoat(currentMember));
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
