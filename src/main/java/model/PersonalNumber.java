package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Personal number.
 */
public class PersonalNumber {
  private String personalNumber;

  /**
   * Instantiates a new Personal number.
   *
   * @param newPersonalNumber the new personal number
   */
  public PersonalNumber(String newPersonalNumber) {
    if (!isValid(newPersonalNumber)) {
      throw new IllegalArgumentException("Personal number is not valid!");
    }
    this.personalNumber = newPersonalNumber;
  }

  /**
   * Gets personal number.
   *
   * @return the personal number
   */
  public String getPersonalNumber() {
    return personalNumber;
  }

  /**
   * Validates personal number.
   *
   * @return a boolean depending on the validity of the new personal number.
   */
  public Boolean isValid(String personalNumber) {
    // Regex source: https://github.com/personnummer/java/blob/master/src/main/java/dev/personnummer/Personnummer.java
    Pattern regex = Pattern.compile(
        "^(\\d{2})?(\\d{2})([-|+]?)?(\\d{2})([-|+]?)?(\\d{2})([-|+]?)?((?!000)\\d{3})(\\d?)$");
    Matcher matcher = regex.matcher(personalNumber);
    Boolean matchFound = matcher.find();
    if (!matchFound) {
      return false;
    }
    return true;
  }
}
