package controller;

import model.Member;
import view.ConsoleUi;

public class ConsoleUiController {
  private ConsoleUi view;
  private RegisterController regController;
  private Boolean quit;

  public ConsoleUiController(ConsoleUi view, RegisterController regController) {
    this.view = view;
    this.regController = regController;
    this.quit = false;
  }

  public void run() {
    regController.addRandomMembers(6); // TODO: Remove before production!!!
    view.printWelcomeMessage();
    do {
      showMainMenu();
    } while (!quit);
  }

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

  public void showSearchMenu() {
    switch (view.printSearchOption()) {
      case (1):
        view.consumeLeftOvers();
        Member foundMemberByPersonalNr = regController.searchMemberByPersonalNr();
        if (foundMemberByPersonalNr != null) {
          if (view.askEditMember()) {
            regController.editMember(foundMemberByPersonalNr);
          } else if (view.askDeleteMember()) {
            regController.removeMember(foundMemberByPersonalNr);
          }
        }
        break;
      case (2):
        view.consumeLeftOvers();
        Member foundMemberById = regController.searchMemberById();
        if (foundMemberById != null) {
          if (view.askEditMember()) {
            regController.editMember(foundMemberById);
          } else if (view.askDeleteMember()) {
            regController.removeMember(foundMemberById);
          }
        }
        break;
      default:
        view.consumeLeftOvers();
        break;
    }
  }
}
