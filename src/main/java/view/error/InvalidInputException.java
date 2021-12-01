package view.error;

/**
 * The type Invalid input exception.
 */
public class InvalidInputException extends Exception {
  /**
   * The Message.
   */
  public String message;

  /**
   * Instantiates a new Invalid input exception.
   */
  public InvalidInputException() {
    super();
    this.message = "Invalid input!";
  }

  /**
   * Instantiates a new Invalid input exception.
   *
   * @param newMessage the new message
   */
  public InvalidInputException(String newMessage) {
    super();
    this.message = newMessage;
  }
}
