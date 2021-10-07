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
  public Boat(String name, String type, Double length) {
    this.name = name;
    this.length = length;
    this.type = convertBoatType(type);
  }

  private BoatType convertBoatType(String boatType) {
    boatType = boatType.toUpperCase();
    for (BoatType type : BoatType.values()) {
      if (type.label.toUpperCase().equals(boatType)) {
        return type;
      }
    }
    return null;
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
  public void setType(String type) {
    this.type = convertBoatType(type);
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
}
