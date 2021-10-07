package model.persistance;

import java.util.ArrayList;
import model.Boat;
import model.Member;
import model.Register;

/**
 * The type Mock data.
 */
public class MockData implements Persistence {
  private Register register;
  private ArrayList<Member> names;

  /**
   * Instantiates a new Mock data.
   */
  public MockData() {
    this.names = new ArrayList<Member>();
  }

  /**
   * Loads mocked member data.
   *
   * @return the mocked member data.
   */
  public ArrayList<Member> loadData() {
    Member goran = new Member("Göran", "Persson", "1951-05-21-8734", "1X2Y3D");
    goran.addBoat(new Boat("Jolly Sailor", "Sailboat", 32.15));
    goran.addBoat(new Boat("Jolly Backup", "Sailboat", 29.0));
    names.add(goran);

    Member sten = new Member("Sten", "Nilsson", "1948-11-07-9234", "3J2Y2F");
    sten.addBoat(new Boat("Sinker 5", "Motorsailer", 22.0));
    sten.addBoat(new Boat("Pocahontas", "Canoe/Kayak", 8.2));
    names.add(sten);

    Member vanessa = new Member("Vanessa", "Samuelsson", "1989-08-21-9103", "8G1B5H");

    names.add(vanessa);

    return names;
  }

}
