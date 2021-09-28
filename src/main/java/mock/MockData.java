package mock;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

import model.Boat;
import model.BoatType;
import model.Member;

/**
 * The type Mock data.
 */
public class MockData {
  private ArrayList<String> names;

  /**
   * Instantiates a new Mock data.
   */
  public MockData() {
    this.names = new ArrayList<String>();
    addNames();
  }

  /**
   * Add names.
   */
  public void addNames() {
    names.add("Liam");
    names.add("Olivia");
    names.add("Noah");
    names.add("Emma");
    names.add("Oliver");
    names.add("Elijah");
    names.add("Ava");
    names.add("Isabella");
    names.add("Evelyn");
    names.add("Henry");
  }

  /**
   * Gets random member.
   *
   * @param membersId the members id
   * @return the random member
   */
  public Member getRandomMember(ArrayList<String> membersId) {
    Boat sailBoat = new Boat(getRandomName(), BoatType.SAILBOAT, getRandomDouble());
    Boat motorSailer = new Boat(getRandomName(), BoatType.MOTORSAILER, getRandomDouble());

    Member newMember = new Member(getRandomName(), getRandomName(), randomLong(), membersId);
    newMember.addBoat(sailBoat);
    newMember.addBoat(motorSailer);
    return newMember;
  }

  /**
   * Gets random name.
   *
   * @return the random name
   */
  public String getRandomName() {
    Random random = new Random();

    Integer randomInt = random.nextInt(names.size());
    return names.get(randomInt);
  }

  /**
   * Random long long.
   *
   * @return the long
   */
  public Long randomLong() {
    Random random = new Random();
    char[] digits = new char[12];
    digits[0] = '1';
    digits[1] = '9';
    for (int i = 2; i < 12; i++) {
      digits[i] = (char) (random.nextInt(10) + '0');
    }
    return Long.parseLong(new String(digits));
  }

  /**
   * Gets random double.
   *
   * @return the random double
   */
  public Double getRandomDouble() {
    Random random = new Random();
    DecimalFormat df = new DecimalFormat("#.1");
    Double db = 10 + (42 - 10) * random.nextDouble();
    String ds = df.format(db).replace(",", ".");
    return Double.parseDouble(ds);
  }
}
