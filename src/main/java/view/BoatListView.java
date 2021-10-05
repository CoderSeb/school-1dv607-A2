package view;

import java.util.Scanner;

public class BoatListView {
  private Scanner scan;

  public BoatListView(){
    this.scan = new Scanner(System.in);
  }

  /**
   * Print boat.
   *
   * @param boatName   the name
   * @param boatType   the type
   * @param boatLength the length
   */
  public void printBoat(String boatName, String boatType, Double boatLength) {
    System.out.println("-Boat " + boatName + ", type: " + boatType + " and with a length of " + boatLength + "ft.");
  }
}
