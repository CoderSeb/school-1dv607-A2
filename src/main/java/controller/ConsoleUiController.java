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
    regController.addRandomMembers(6);
    view.printWelcomeMessage();
    do {
      switch (view.printMainOption()) {
        case (1):
          view.consumeLeftOvers();
          regController.createAndAddMember();
          break;
        case (2):
          view.consumeLeftOvers();
          switch (view.printSearchOption()) {
            case (1):
              view.consumeLeftOvers();
              Member foundMemberByPersonalNr = regController.searchMemberByPersonalNr();
              if (view.askEditMember()) {
                regController.editMember(foundMemberByPersonalNr);
              } else if (view.askDeleteMember()) {
                regController.removeMember(foundMemberByPersonalNr);
              }
              break;
            case (2):
              view.consumeLeftOvers();
              Member foundMemberById = regController.searchMemberById();
              if (view.askEditMember()) {
                regController.editMember(foundMemberById);
              } else if (view.askDeleteMember()) {
                regController.removeMember(foundMemberById);
              }
              break;
            default:
              view.consumeLeftOvers();
              break;
          }
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
    } while (!quit);
  }
}
