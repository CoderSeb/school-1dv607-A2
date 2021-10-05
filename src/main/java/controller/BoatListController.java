package controller;

import model.Boat;
import model.BoatList;
import view.BoatListView;

/**
 * The type Boat list controller.
 */
public class BoatListController {
  private BoatList model;
  private BoatListView view;

  /**
   * Instantiates a new Boat list controller.
   *
   * @param model the model
   * @param view  the view
   */
  public BoatListController(BoatList model, BoatListView view) {
    this.model = model;
    this.view = view;
  }

  /**
   * Show boats.
   *
   * @param boatList the boat list
   */
  public void showBoats(BoatList boatList) {
    for (Boat boat : boatList.getBoats()) {
      view.printBoat(boat.getName(), boat.getType(), boat.getLength());
    }
  }
}


