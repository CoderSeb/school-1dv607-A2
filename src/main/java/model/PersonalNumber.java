package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * The type Personal number.
 */
public class PersonalNumber {

  private String personalNumber;
  private Boolean isValid;

  /**
   * Instantiates a new Personal number.
   *
   * @param newPersonalNumber the new personal number
   */
  public PersonalNumber(String newPersonalNumber) {
    this.personalNumber = newPersonalNumber;
    this.isValid = personalNumberIsValid();
  }

  /**
   * Gets valid.
   *
   * @return the valid
   */
  public Boolean getValid() {
    return isValid;
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
    isValid = personalNumberIsValid();
  }

  /**
   * Personal number is valid boolean.
   *
   * @return the boolean
   */
  public Boolean personalNumberIsValid() {
    // Regex source: https://github.com/personnummer/java/blob/master/src/main/java/dev/personnummer/Personnummer.java
    Pattern regex = Pattern.compile("^(\\d{2})?(\\d{2})(\\d{2})(\\d{2})([-|+]?)?((?!000)\\d{3})(\\d?)$");
    Matcher matcher = regex.matcher(personalNumber);
    Boolean matchFound = matcher.find();
    return matchFound;
  }
}
