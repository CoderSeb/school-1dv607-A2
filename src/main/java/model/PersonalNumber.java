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
    this.personalNumber = personalNumberIsValid(newPersonalNumber);
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
   * Sets personal number.
   *
   * @param newPersonalNumber the new personal number
   */
  public void setPersonalNumber(String newPersonalNumber) {
    personalNumber = newPersonalNumber;
  }

  /**
   * Personal number is valid boolean.
   *
   * @param newPersonalNumber the new personal number
   * @return the boolean
   */
  public String personalNumberIsValid(String newPersonalNumber) {
    // Regex source: https://github.com/personnummer/java/blob/master/src/main/java/dev/personnummer/Personnummer.java
    Pattern regex = Pattern.compile(
        "^(\\d{2})?(\\d{2})([-|+]?)?(\\d{2})([-|+]?)?(\\d{2})([-|+]?)?((?!000)\\d{3})(\\d?)$");
    Matcher matcher = regex.matcher(newPersonalNumber);
    Boolean matchFound = matcher.find();
    if (matchFound == true) {
      return newPersonalNumber;
    }
    return null;
  }
}
