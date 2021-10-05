package controller;
import model.Boat;
import model.BoatList;
import view.BoatListView;

public class BoatListController {
  private BoatList model;
  private BoatListView view;

  public BoatListController(BoatList model, BoatListView view){
    this.model = model;
    this.view = view;
  }

  public void showBoats(){
    for (Boat boat : model.getBoats()) {
      view.printBoat(boat.getName(), boat.getType(), boat.getLength());
    }
  }
}


