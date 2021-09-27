package model;

/**
 * The enum Boat type.
 */
public enum BoatType {
  /**
   * Sailboat boat type.
   */
  SAILBOAT("Sailboat"),
  /**
   * Motorsailer boat type.
   */
  MOTORSAILER("Motorsailer"),
  /**
   * Canoeorkayak boat type.
   */
  CANOEORKAYAK("Canoe/Kayak"),
  /**
   * Other boat type.
   */
  OTHER("Other");

  /**
   * The Label.
   */
  public final String label;

  private BoatType(String label) {
    this.label = label;
  }
}
