import controller.ConsoleUiController;
import controller.MemberController;
import controller.RegisterController;
import model.Register;
import view.ConsoleUi;
import view.MemberView;
import view.RegisterView;

/**
 * The type App.
 */
public class App {
  /**
   * The entry point of application.
   *
   * @param args the input arguments
   */
  public static void main(String[] args) {
    ConsoleUi mainUi = new ConsoleUi();

    Register regModel = new Register();
    RegisterView regView = new RegisterView();
    MemberView memView = new MemberView();
    MemberController memController = new MemberController(memView);
    RegisterController regController = new RegisterController(regView, regModel, memController);

    ConsoleUiController consoleController = new ConsoleUiController(mainUi, regController, memController);

    consoleController.run();
  }
}
