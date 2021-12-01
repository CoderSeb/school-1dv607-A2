package model;

/**
 * The type Boat.
 */
public class Boat {
  private String name;
  private Double length;
  private BoatType type;

  /**
   * Instantiates a new Boat.
   *
   * @param name   the name
   * @param type   the type
   * @param length the length
   */
  public Boat(String name, BoatType type, Double length) {
    this.name = name;
    this.length = length;
    this.type = type;
  }


  /**
   * Gets name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name.
   *
   * @param name the name
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Gets type.
   *
   * @return the type
   */
  public String getType() {
    return type.label;
  }

  /**
   * Sets type.
   *
   * @param type the type
   */
  public void setType(BoatType type) {
    this.type = type;
  }

  /**
   * Gets length.
   *
   * @return the length
   */
  public Double getLength() {
    return length;
  }

  /**
   * Sets length.
   *
   * @param length the length
   */
  public void setLength(Double length) {
    this.length = length;
  }


  /**
   * The enum Boat type.
   */
  public enum BoatType {
    SAILBOAT("Sailboat"),
    MOTORSAILER("Motorsailer"),
    CANOEORKAYAK("Canoe/Kayak"),
    OTHER("Other");

    public final String label;

    private BoatType(String label) {
      this.label = label;
    }
  }
}
