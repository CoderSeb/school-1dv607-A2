package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * The type Boat tests.
 */
class BoatTests {
  /**
   * The Boat.
   */
  Boat boat;

  /**
   * Sets up.
   */
  @BeforeEach
  void setUp() {
    boat = new Boat("TestBoat", "Motorsailer", 10.5);
  }

  /**
   * Test boat name getter.
   */
  @Test
  @DisplayName("Boat name getter should work.")
  void testBoatNameGetter() {
    assertTrue(boat.getName().equals("TestBoat"));
  }

  /**
   * Test boat type getter.
   */
  @Test
  @DisplayName("Boat type getter should work.")
  void testBoatTypeGetter() {
    assertTrue(boat.getType().equals("Motorsailer"));
  }

  /**
   * Test boat length getter.
   */
  @Test
  @DisplayName("Boat length getter should work.")
  void testBoatLengthGetter() {
    assertTrue(boat.getLength().equals(10.5));
  }

  /**
   * Test boat name setter.
   */
  @Test
  @DisplayName("Boat name setter should work.")
  void testBoatNameSetter() {
    boat.setName("AnotherBoat");
    assertTrue(boat.getName().equals("AnotherBoat"));
  }

  /**
   * Test boat type setter.
   */
  @Test
  @DisplayName("Boat type setter should work.")
  void testBoatTypeSetter() {
    boat.setType("Sailboat");
    assertTrue(boat.getType().equals("Sailboat"));
  }

  /**
   * Test boat length setter.
   */
  @Test
  @DisplayName("Boat length setter should work.")
  void testBoatLengthSetter() {
    boat.setLength(12.3);
    assertTrue(boat.getLength().equals(12.3));
  }
}
