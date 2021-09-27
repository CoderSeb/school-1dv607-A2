package view;

import java.util.Scanner;

public class ConsoleUi {
  private final Scanner scan;

  public ConsoleUi() {
    this.scan = new Scanner(System.in);
  }

  public Integer printMainOption() {
    System.out.println("Please choose an option: ");
    System.out.println("1 - Add new member.");
    System.out.println("2 - Search / edit / delete member");
    System.out.println("3 - Show verbose list of members.");
    System.out.println("4 - Show compact list of members.");
    System.out.println("0 - Quit.");
    // TODO: Add more options.
    return scan.nextInt();
  }

  public Integer printSearchOption() {
    System.out.println("1 - Search by personal number.");
    System.out.println("2 - Search by member id.");
    return scan.nextInt();
  }

  public Boolean askYesOrNo() {
    System.out.println("Y/(N)?");
    return scan.nextLine().equals("Y");
  }

  public Boolean askEditMember() {
    System.out.println("Edit this member?");
    return askYesOrNo();
  }

  public Boolean askDeleteMember() {
    System.out.println("Delete this member?");
    return askYesOrNo();
  }

  public void printSuccess() {
    System.out.println("Task completed.");
  }


  public void printWelcomeMessage() {
    System.out.println("Welcome to Jolly Roger yacht club!");
  }

  public void consumeLeftOvers() {
    scan.nextLine();
  }

  public void closeScanner() {
    scan.close();
  }
}
