import controller.RegisterController;
import model.BoatType;
import model.Register;
import view.ConsoleUi;
import view.RegisterView;

/**
 * Responsible for starting the application.
 */
public class App {
  /**
   * Application starting point.

   * @param args command line arguments.
   */
  public static void main(String[] args) {
    Boolean quit = false;
    ConsoleUi mainUi = new ConsoleUi();
    Register regModel = new Register();
    RegisterView regView = new RegisterView();
    RegisterController regController = new RegisterController(regView, regModel);

    regController.addRandomMembers(6);

    mainUi.printWelcomeMessage();
    do {
      switch(mainUi.printMainOption()) {
        case(1):
          mainUi.consumeLeftOvers();
          regController.createAndAddMember();
          break;
        case(2):
          mainUi.consumeLeftOvers();
          switch(mainUi.printSearchOption()){
            case(1):
              mainUi.consumeLeftOvers();
              System.out.println("Accessed personal number");
              break;
            case(2):
              mainUi.consumeLeftOvers();
              regController.searchMemberById();
              break;
            default:
              mainUi.consumeLeftOvers();
              break;
          }
          break;
        case(3):
          mainUi.consumeLeftOvers();
          regController.showMembersVerbose();
          break;
        case(4):
          mainUi.consumeLeftOvers();
          regController.showMembersCompact();
          break;
        default:
          mainUi.closeScanner();
          quit = true;
          break;
      }
    } while (!quit);
  }
}
