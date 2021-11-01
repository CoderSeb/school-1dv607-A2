package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Personal number.
 */
public class PersonalNumber {
  private String personalNumber;
  public Boolean valid;

  /**
   * Instantiates a new Personal number.
   *
   * @param newPersonalNumber the new personal number
   */
  public PersonalNumber(String newPersonalNumber) {
    this.personalNumber = newPersonalNumber;
    this.valid = this.isValid();
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
   * Validates personal number.
   *
   * @return a boolean depending on the validity of the new personal number.
   */
  public Boolean isValid() {
    // Regex source: https://github.com/personnummer/java/blob/master/src/main/java/dev/personnummer/Personnummer.java
    Pattern regex = Pattern.compile(
        "^(\\d{2})?(\\d{2})([-|+]?)?(\\d{2})([-|+]?)?(\\d{2})([-|+]?)?((?!000)\\d{3})(\\d?)$");
    Matcher matcher = regex.matcher(this.personalNumber);
    Boolean matchFound = matcher.find();
    if (!matchFound) {
      return false;
    }
    return true;
  }
}
