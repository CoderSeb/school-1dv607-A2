package model;

import java.util.ArrayList;

/**
 * The type Boat list.
 */
public class BoatList {
  private ArrayList<Boat> boats;

  /**
   * Instantiates a new Boat list.
   */
  public BoatList() {
    this.boats = new ArrayList<Boat>();
  }

  /**
   * Gets boats.
   *
   * @return the boats
   */
  public ArrayList<Boat> getBoats() {
    return boats;
  }

  /**
   * Add boat.
   *
   * @param boat the boat
   */
  public void addBoat(Boat boat) {
    boats.add(boat);
  }

  /**
   * Remove boat.
   *
   * @param boat the boat
   */
  public void removeBoat(Boat boat) {
    boats.remove(boat);
  }

  /**
   * Find boat by name boat.
   *
   * @param boatName the boat name
   * @return the boat
   */
  public Boat findBoatByName(String boatName) {
    for (Boat boat : boats) {
      if (boat.getName().equals(boatName)) {
        return boat;
      }
    }
    return null;
  }

  /**
   * Size integer.
   *
   * @return the integer
   */
  public Integer size() {
    return boats.size();
  }
}
