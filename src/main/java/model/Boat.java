package model;

/**
 * Boat Class.
 */
public class Boat {
  private String name;
  private Double length;
  private BoatType type;

  /**
   * Boat constructor.
   *
   * @param name   name of the boat.
   * @param type   Boat type.
   * @param length boat length.
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
   * Returns name of boat.
   *
   * @return the name.
   */
  public String getName() {
    return name;
  }

  /**
   * Sets name of boat.
   *
   * @param name as the name.
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * Return boat type as a string.
   *
   * @return as the boat type.
   */
  public String getType() {
    return type.label;
  }

  /**
   * Sets the boat type as a string.
   * BoatType.label is the string.
   *
   * @param type as the boat type.
   */
  public void setType(String type) {
    this.type = convertBoatType(type);
  }

  /**
   * Returns boat length.
   *
   * @return the boat length.
   */
  public Double getLength() {
    return length;
  }

  /**
   * Sets length of boat.
   *
   * @param length as the length.
   */
  public void setLength(Double length) {
    this.length = length;
  }
}
