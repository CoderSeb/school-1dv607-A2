import controller.BoatListController;
import controller.ConsoleUiController;
import controller.MemberController;
import controller.RegisterController;
import model.BoatList;
import model.Register;
import view.BoatListView;
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
    BoatList boatListModel = new BoatList();
    BoatListView boatListView = new BoatListView();
    BoatListController boatListController = new BoatListController(boatListModel, boatListView);
    Register regModel = new Register();
    RegisterView regView = new RegisterView();
    MemberView memView = new MemberView();
    MemberController memController = new MemberController(memView, boatListController);
    RegisterController regController = new RegisterController(regView, regModel, memController);

    ConsoleUiController consoleController = new ConsoleUiController(mainUi, regController, memController,
        boatListController);

    consoleController.run();
  }
}
