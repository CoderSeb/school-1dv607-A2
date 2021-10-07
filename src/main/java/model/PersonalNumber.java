package model;

import error.InvalidInputException;
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
   * @throws InvalidInputException the invalid input exception
   */
  public PersonalNumber(String newPersonalNumber) throws InvalidInputException {
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
   * Personal number is valid string.
   *
   * @param newPersonalNumber the new personal number
   * @return the string
   * @throws InvalidInputException the invalid input exception
   */
  public String personalNumberIsValid(String newPersonalNumber) throws InvalidInputException {
    // Regex source: https://github.com/personnummer/java/blob/master/src/main/java/dev/personnummer/Personnummer.java
    Pattern regex = Pattern.compile(
        "^(\\d{2})?(\\d{2})([-|+]?)?(\\d{2})([-|+]?)?(\\d{2})([-|+]?)?((?!000)\\d{3})(\\d?)$");
    Matcher matcher = regex.matcher(newPersonalNumber);
    Boolean matchFound = matcher.find();
    if (!matchFound) {
      throw new InvalidInputException("Invalid personal number.");
    }
    return newPersonalNumber;
  }
}
