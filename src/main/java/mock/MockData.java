package mock;

import java.util.ArrayList;
import model.Boat;
import model.BoatType;
import model.Member;
import model.Register;

/**
 * The type Mock data.
 */
public class MockData {
  private Register register;
  private ArrayList<Member> names;

  /**
   * Instantiates a new Mock data.
   */
  public MockData() {
    this.names = new ArrayList<Member>();
    loadMockedData();
  }

  /**
   * Load members array list.
   *
   * @return the array list
   */
  public ArrayList<Member> loadMembers() {
    return names;
  }

  private void loadMockedData() {
    Member goran = new Member("Göran", "Persson", "1951-05-21-8734", "1X2Y3D");
    goran.addBoat(new Boat("Jolly Sailor", BoatType.SAILBOAT, 32.1));
    goran.addBoat(new Boat("Jolly Backup", BoatType.SAILBOAT, 29.0));
    names.add(goran);

    Member sten = new Member("Sten", "Nilsson", "1948-11-07-9234", "3J2Y2F");
    sten.addBoat(new Boat("Sinker 5", BoatType.MOTORSAILER, 22.0));
    names.add(sten);

    Member vanessa = new Member("Vanessa", "Samuelsson", "1989-08-21-9103", "8G1B5H");
    names.add(vanessa);
  }

}
