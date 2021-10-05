package model;

import java.util.ArrayList;

public class BoatList {
  private ArrayList<Boat> boats;

  public BoatList(){
    this.boats = new ArrayList<Boat>();
  }

  public ArrayList<Boat> getBoats() {
    return boats;
  }

  public void addBoat(Boat boat) {
    boats.add(boat);
  }

  public void removeBoat(Boat boat){
    boats.remove(boat);
  }

  public Boat findBoatByName(String boatName){
    for (Boat boat : boats ) {
      if( boat.getName().equals(boatName) ){
        return boat;
      }
    }
    return null;
  }
}
