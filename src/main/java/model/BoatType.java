package model;

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
