package model;

import error.InvalidInputException;

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
   * @throws InvalidInputException the invalid input exception
   */
  public Boat(String name, String type, Double length) throws InvalidInputException {
    this.name = name;
    this.length = length;
    this.type = validateBoatType(convertBoatType(type));
  }

  private BoatType validateBoatType(BoatType boatType) throws InvalidInputException {
    if (boatType == null) {
      throw new InvalidInputException("Boat type is not valid.");
    }
    return boatType;
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
   * @throws InvalidInputException the invalid input exception
   */
  public void setType(String type) throws InvalidInputException {
    this.type = validateBoatType(convertBoatType(type));
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
