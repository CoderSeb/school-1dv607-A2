import controller.ConsoleUiController;
import controller.MemberController;
import controller.RegisterController;
import model.Register;
import view.ConsoleUi;
import view.MemberView;
import view.RegisterView;

/**
 * Responsible for starting the application.
 */
public class App {
  /**
   * Application starting point.
   *
   * @param args command line arguments.
   */
  public static void main(String[] args) {
    ConsoleUi mainUi = new ConsoleUi();
    Register regModel = new Register();
    RegisterView regView = new RegisterView();
    RegisterController regController = new RegisterController(regView, regModel);
    MemberView memView = new MemberView();
    MemberController memController = new MemberController(memView);

    ConsoleUiController consoleController = new ConsoleUiController(mainUi, regController, memController);

    consoleController.run();
  }
}
