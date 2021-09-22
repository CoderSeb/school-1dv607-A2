package view;

import java.util.Scanner;

public class ConsoleUi {
  private Scanner scan;

  public ConsoleUi() {
    this.scan = new Scanner(System.in);
  }
  public Integer printMainOption() {
    System.out.println("Please choose an option: ");
    System.out.println("1 - Add new member.");
    System.out.println("2 - Show verbose list of members.");
    System.out.println("3 - Show compact list of members.");
    System.out.println("0 - Quit.");
    // TODO: Add more options.
    return scan.nextInt();
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
