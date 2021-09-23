package model;

public class Boat {
  private String name;
  private Double length;
  private String type;

  public Boat(String name, BoatType type, Double length) {
    this.name = name;
    this.length = length;
    this.type = type.label;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getType() {
    return type;
  }

  public void setType(BoatType type) {
    this.type = type.label;
  }

  public Double getLength() {
    return length;
  }

  public void setLength(Double length) {
    this.length = length;
  }
}
