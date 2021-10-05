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
  private BoatListController boatController;
  private Boolean quit;
  private Member currentMember;

  /**
   * Instantiates a new Console ui controller.
   *
   * @param view             the view
   * @param regController    the reg controller
   * @param memberController the member controller
   */
  public ConsoleUiController(ConsoleUi view, RegisterController regController, MemberController memberController, BoatListController boatController) {
    this.view = view;
    this.regController = regController;
    this.memController = memberController;
    this.boatController = boatController;
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
    switch (view.printMainOption()) {
      case (1):
        regController.addMember(memController.createMember(regController.fetchMembersIds()));
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
    regController.showMemberVerbose(currentMember);
    switch (view.printMemberMenu()) {
      case (1):
        memController.editMember(currentMember);
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
  private void showBoatMenu() {
    boatController.showBoats();
    switch (view.printBoatOption()) {
      case (1):
        regController.registerBoat(currentMember);
        showBoatMenu();
        break;
      case (2):
        Boat foundBoat = regController.chooseBoat(currentMember);
        if (foundBoat != null) {
          regController.editBoat(foundBoat);
        }
        showBoatMenu();
        break;
      case (3):
        regController.removeBoat(currentMember);
        showBoatMenu();
        break;
      default:
        showMemberMenu();
        break;
    }
  }

}
