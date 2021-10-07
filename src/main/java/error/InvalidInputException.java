package error;

public class InvalidInputException extends Exception {
  private String message;

  public InvalidInputException() {
    super();
    this.message = "Invalid input!";
  }
}
