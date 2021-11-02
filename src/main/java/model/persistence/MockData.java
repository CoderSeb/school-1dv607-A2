package model.persistence;

import error.InvalidInputException;
import java.util.ArrayList;
import model.Boat;
import model.Member;
import model.PersonalNumber;

/**
 * The type Mock data.
 */
public class MockData implements Persistence {
  private ArrayList<Member> names;

  /**
   * Instantiates a new Mock data.
   */
  public MockData() {
    this.names = new ArrayList<Member>();
  }

  /**
   * Loads mocked data.
   *
   * @return a list with new mocked members.
   * @throws InvalidInputException as Member creation validates it's values.
   */
  public ArrayList<Member> loadData() {
    Member goran = new Member("Göran", "Persson", new PersonalNumber("19510521-8734"), "1X2Y3D");
    goran.createAndAddBoat("Jolly Sailor", Boat.BoatType.SAILBOAT, 32.15);
    goran.createAndAddBoat("Jolly Backup", Boat.BoatType.SAILBOAT, 29.0);
    names.add(goran);

    Member sten = new Member("Sten", "Nilsson", new PersonalNumber("1948-11-07-9234"), "3J2Y2F");
    sten.createAndAddBoat("Sinker 5", Boat.BoatType.MOTORSAILER, 22.0);
    sten.createAndAddBoat("Pocahontas", Boat.BoatType.CANOEORKAYAK, 8.2);
    names.add(sten);

    Member vanessa = new Member("Vanessa", "Samuelsson", new PersonalNumber("1989-08-21-9103"), "8G1B5H");

    names.add(vanessa);

    return names;
  }
}
