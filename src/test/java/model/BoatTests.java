package model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

class BoatTests {
  Boat boat;

  @BeforeEach
  void setUp() {
    boat = new Boat("TestBoat", BoatType.MOTORSAILER, 10.5);
  }

  @Test
  @DisplayName("Boat name getter should work.")
  void testBoatNameGetter() {
    assertTrue(boat.getName().equals("TestBoat"));
  }

  @Test
  @DisplayName("Boat type getter should work.")
  void testBoatTypeGetter() {
    assertTrue(boat.getType().equals("Motorsailer"));
  }

  @Test
  @DisplayName("Boat length getter should work.")
  void testBoatLengthGetter() {
    assertTrue(boat.getLength().equals(10.5));
  }

  @Test
  @DisplayName("Boat name setter should work.")
  void testBoatNameSetter() {
    boat.setName("AnotherBoat");
    assertTrue(boat.getName().equals("AnotherBoat"));
  }

  @Test
  @DisplayName("Boat type setter should work.")
  void testBoatTypeSetter() {
    boat.setType(BoatType.SAILBOAT);
    assertTrue(boat.getType().equals("Sailboat"));
  }

  @Test
  @DisplayName("Boat length setter should work.")
  void testBoatLengthSetter() {
    boat.setLength(12.3);
    assertTrue(boat.getLength().equals(12.3));
  }
}
