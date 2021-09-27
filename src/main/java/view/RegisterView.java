package view;

import java.util.Scanner;

public class RegisterView {
  private Scanner scan;

  public RegisterView() {
    this.scan = new Scanner(System.in);
  }

  public String askFirstName() {
    System.out.println("Please enter first name: ");
    String input = scan.nextLine();
    if (isBlank(input)) {
      return null;
    }
    return input;
  }

  public String askLastName() {
    System.out.println("Please enter last name: ");
    String input = scan.nextLine();
    if (isBlank(input)) {
      return null;
    }
    return input;
  }

  public Long askPersonalNr() {
    System.out.println("Please enter personal nr (12-digits): ");
    String personalNr = scan.nextLine();
    Integer length = personalNr.length();
    Integer lengthOfPersonalNr = 12;

    if (length.equals(lengthOfPersonalNr)) {
      return Long.parseLong(personalNr);
    }
    return null;
  }

  public String askMemberId() {
    System.out.println("Please enter member id:");
    return scan.nextLine();
  }

  public Boolean isBlank(String input) {
    if (input.equals("")) {
      return true;
    }
    return false;
  }


  public void printLine() {
    System.out.println("----------------------------------");
  }

  public void printBoatSection() {
    System.out.println("Owned boats: ");
  }

  public void printMemberVerbose(String firstName, String lastName, Long personalNr, String memberId) {
    printLine();
    System.out.println("Member " + memberId);
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Personal number: " + personalNr);
  }

  public void printMemberCompact(String firstName, String lastName, String memberId, Integer amountOfBoats) {
    printLine();
    System.out.println("Member " + memberId);
    System.out.println("Name: " + firstName + " " + lastName);
    System.out.println("Amount of boats: " + amountOfBoats);
  }

  public void printBoat(String name, String type, Double length) {
    System.out.println("-Boat " + name + ", type: " + type + " and with a length of " + length + "ft.");
  }
}
