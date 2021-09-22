package view;

import java.util.Scanner;

public class RegisterView {
  private Scanner scan;

  public RegisterView() {
    this.scan = new Scanner(System.in);
  }
  public String askFirstName() {
    System.out.println("Please enter first name: ");
    return scan.nextLine();
  }

  public String askLastName() {
    System.out.println("Please enter last name: ");
    return scan.nextLine();
  }

  public Long askPersonalNr() {
    System.out.println("Please enter personal nr (12-digits): ");
    return scan.nextLong();
  }

  public void consumeLeftOverCharacters() {
    scan.nextLine();
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

  public void printBoat(String name, String type, Double length) {
    System.out.println("-Boat " + name + ", type: " + type + " and with a length of " + length + "ft.");
  }
}
