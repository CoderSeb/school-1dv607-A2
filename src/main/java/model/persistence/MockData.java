package model.persistence;

import model.Boat;
import model.Member;
import model.PersonalNumber;

/**
 * The type Mock data.
 */
public class MockData implements Persistence {

  /**
   * Instantiates a new Mock data.
   */
  public MockData() {
  }

  /**
   * Loads mocked data.
   */
  public void loadData(model.Register register) {
    Member goran = new Member("Göran", "Persson", new PersonalNumber("19510521-8734"), "3J5Y2F");
    goran.createAndAddBoat("Jolly Sailor", Boat.BoatType.SAILBOAT, 32.15);
    goran.createAndAddBoat("Jolly Backup", Boat.BoatType.SAILBOAT, 29.0);


    Member sten = new Member("Sten", "Nilsson", new PersonalNumber("1948-11-07-9234"), "3J2Y2F");
    sten.createAndAddBoat("Sinker 5", Boat.BoatType.MOTORSAILER, 22.0);
    sten.createAndAddBoat("Pocahontas", Boat.BoatType.CANOEORKAYAK, 8.2);


    Member vanessa = new Member("Vanessa", "Samuelsson", new PersonalNumber("1989-08-21-9103"), "8G1B5H");

    register.addMember(goran);
    register.addMember(sten);
    register.addMember(vanessa);
  }
}
